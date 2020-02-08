package com.example.demo.controller;

import com.example.demo.common.RestCode;
import com.example.demo.common.RestResponse;
import com.example.demo.common.UserException;
import com.example.demo.entity.IssueAttachment;
import com.example.demo.entity.User;
import com.example.demo.service.IssueAttachmentService;
import com.example.demo.service.StorageService;
import com.example.demo.service.UserService;
import org.json.JSONException;
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

    //--------------------------------------V2  since 02/07 update from disusscion ---------------------------------------
    //client:  curl -i -X POST -H 'Content-type:multipart/form-data' -F "file=@C:\Users\fqyya\Desktop\dc.PNG"  http://localhost:8080/storage/upload
    @PostMapping("/upload")
    public RestResponse upload(@RequestParam(value = "file", required = true) MultipartFile[] UploadingFiles){

        Map<String, String> UrlMaps = new HashMap<String,String>();

        try
        {
            for(MultipartFile UploadedFile : UploadingFiles)
            {
                if(!UploadedFile.isEmpty())
                {
                    String url = storageService.saveToS3(UploadedFile);
                    if(!url.startsWith("http"))
                    {
                        return RestResponse.error(RestCode.STORAGE_FAILURE);
                    }

                    UrlMaps.put(UploadedFile.getOriginalFilename(), url);
                }
            }

        }
        catch (Exception ex)
        {
            return RestResponse.error(RestCode.STORAGE_FAILURE);
        }

        return RestResponse.success(UrlMaps);
    }


    //client:  curl http://localhost:8080/storage/remove?url=http://127.0.0.1:8080/storage/dc.PNG_BrkabK-13689c7b-adff-4ceb-b850-eab8fab9de1b
    @RequestMapping("/remove")
    public RestResponse remove(String url){

        if(!storageService.removeS3File(url))
        {
            return RestResponse.error(RestCode.STORAGE_REMOVE_FAILURE);
        }

        return RestResponse.success();
    }

}
