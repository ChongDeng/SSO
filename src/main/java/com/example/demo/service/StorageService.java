package com.example.demo.service;

import com.example.demo.common.UserException;
import com.example.demo.entity.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.UUID;

@Service("StorageService")
public class StorageService {

    @Value("${s3.map.folder}")
    private String S3MapFolder;

    @Value("${object.storage.url.prefix}")
    private String UrlPrefix;

    @Autowired
    IssueAttachmentService issueAttachmentService;

    //return name of stored file
    public String saveToS3(MultipartFile UploadedFile) throws Exception {

        FileOutputStream out = null;
        String NewFileName = null;

        try
        {
            byte[] file = UploadedFile.getBytes();

            File ParentFolder = new File(S3MapFolder);
            if(!ParentFolder.exists()){
                ParentFolder.mkdirs();
            }

            NewFileName = UploadedFile.getOriginalFilename() + "_" + RandomStringUtils.randomAlphabetic(6) + "-" + UUID.randomUUID().toString();

            out = new FileOutputStream(S3MapFolder + NewFileName);
            out.write(file);
            out.flush();
            out.close();

            NewFileName = UrlPrefix + NewFileName;
        }
        catch(Exception ex)
        {
            if(out != null)
            {
                out.flush();
                out.close();
            }

            return ex.getMessage();
        }

        return NewFileName;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean insertIssueAttachment(User user, Long IssueId, Long IssueRecordId, Map<String, String> UrlMaps)
    {

        UrlMaps.forEach((k,v) -> {
            if(!issueAttachmentService.insert(user, IssueId, IssueRecordId, v))
            {
                throw new UserException(UserException.Type.USER_AUTH_FAIL,"User Auth Fail");
            }
        });

        return true;
    }

}
