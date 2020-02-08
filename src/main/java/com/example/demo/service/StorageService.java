package com.example.demo.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

@Service("StorageService")
public class StorageService {

    @Value("${s3.map.folder}")
    private String S3MapFolder;

    @Value("${object.storage.url.prefix}")
    private String UrlPrefix;

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

    public boolean removeS3File(String FileUrl)
    {
        try
        {
            if(!FileUrl.startsWith(UrlPrefix))
            {
               return false;
            }

            String FileName = FileUrl.substring(UrlPrefix.length());
            File TargetFile = new File(S3MapFolder + FileName);

            if(!TargetFile.delete()) return false;

        }
        catch (Exception ex)
        {
            return false;
        }

        return true;
    }

}
