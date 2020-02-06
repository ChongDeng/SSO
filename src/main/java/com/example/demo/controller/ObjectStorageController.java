package com.example.demo.controller;

import com.example.demo.common.UserException;
import com.example.demo.entity.IssueAttachment;
import com.example.demo.entity.User;
import com.example.demo.service.IssueAttachmentService;
import com.example.demo.service.StorageService;
import com.example.demo.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("storage")
@RestController
public class ObjectStorageController {

    @Autowired
    StorageService storageService;

    @Autowired
    UserService userService;

    @Autowired
    IssueAttachmentService issueAttachmentService;

    @RequestMapping("/test")
    public String test() {
        return "storage test";
    }

    //client:  curl -i -X POST -H 'Content-type:multipart/form-data' -F "file=@C:\Users\fqyya\Desktop\dc.PNG"  -F "file=@C:\Users\fqyya\Desktop\Octocat.png"  -F "msg={\"user_id\":1,\"issue_id\":2,\"record_id\":3}" http://localhost:8080/storage/upload
    @PostMapping("/upload")
    @ResponseBody
    public ResponseEntity<?> upload(@RequestParam(value = "file", required = false) MultipartFile[] UploadingFiles,
                                                 @RequestParam(value = "msg", required = false) String JsonStr){

        if(JsonStr == null || JsonStr == null)
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        try
        {
            Map<String, String> UrlMaps = new HashMap<String,String>();

            for(MultipartFile UploadedFile : UploadingFiles)
            {
                if(!UploadedFile.isEmpty())
                {
                    try
                    {
                        String url = storageService.saveToS3(UploadedFile);
                        if(!url.startsWith("http"))
                        {
                            return new ResponseEntity<>(HttpStatus.OK);
                        }

                        UrlMaps.put(UploadedFile.getOriginalFilename(), url);
                    }
                    catch (Exception ex)
                    {
                        return new ResponseEntity<>(HttpStatus.OK);
                    }
                }
            }

            JSONObject msg = new JSONObject(JsonStr);

            Long UserId = msg.getLong("user_id");
            Long IssueId = msg.getLong("issue_id");
            Long IssueRecordId = msg.getLong("record_id");

            User user = userService.getUserById(UserId);

            UrlMaps.forEach((k,v) -> {
                if(!issueAttachmentService.insert(user, IssueId, IssueRecordId, v))
                {
                    throw new UserException(UserException.Type.USER_AUTH_FAIL,"User Auth Fail");
                }
            });

        }
        catch (Exception ex)
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }




        return new ResponseEntity<>(HttpStatus.OK);
    }

}
