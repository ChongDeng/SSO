package com.example.demo.controller;

import com.example.demo.common.ListResponse;
import com.example.demo.common.RestCode;
import com.example.demo.common.RestResponse;
import com.example.demo.common.UserException;
import com.example.demo.entity.IssueAttachment;
import com.example.demo.entity.User;
import com.example.demo.service.IssueAttachmentService;
import com.example.demo.service.UserService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("issue_attachment")
@RestController
public class IssueAttachmentController {

    @Autowired
    UserService userService;

    @Autowired
    IssueAttachmentService issueAttachmentService;



    //---------------------- 1 insert ----------------------------------
    // param:  user id,  issue id, from id (it is either issue comment id or meeting id), from type (0: comment; 1: meeting)
    @RequestMapping("/insert")
    public RestResponse insert(@RequestBody IssueAttachment issueAttachment){

        if(!issueAttachmentService.insert(issueAttachment))
            return  RestResponse.error(RestCode.ISSUE_ATTACHMENT_INSERT_FAILURE);

        return RestResponse.success();
    }

    //----------------------  2 remove_logical ----------------------------------
    // param:  user id,  issue id, from id (it is either issue comment id or meeting id), from type (0: comment; 1: meeting)
    @RequestMapping("/remove")
    public RestResponse remove_logical(@RequestBody IssueAttachment issueAttachment){

        try
        {
            if(!issueAttachmentService.remove_logical(issueAttachment))
                return  RestResponse.error(RestCode.ISSUE_ATTACHMENT_REMOVE_FAILURE);

        }
        catch (Exception ex)
        {
                int dmyy = 0;
        }

        return RestResponse.success();
    }

    //----------------------  2.2 remove_phisical ----------------------------------
    // param:  user id,  issue id, from id (it is either issue comment id or meeting id), from type (0: comment; 1: meeting)
    @RequestMapping("/remove_phisical")
    public RestResponse remove_phisical(@RequestBody IssueAttachment issueAttachment){

        try
        {
            if(!issueAttachmentService.remove_phisics(issueAttachment))
                return  RestResponse.error(RestCode.ISSUE_ATTACHMENT_REMOVE_FAILURE);

        }
        catch (Exception ex)
        {
            return  RestResponse.error(RestCode.ISSUE_ATTACHMENT_REMOVE_FAILURE);
        }

        return RestResponse.success();
    }

    //----------------------  3 query  ----------------------------------
    @RequestMapping("/query")
    public RestResponse query(@RequestBody IssueAttachment issueAttachment){

        try
        {
            List<IssueAttachment> res = issueAttachmentService.getItems(issueAttachment);

            ListResponse<IssueAttachment> response = ListResponse.build(res, Long.valueOf(res.size()));
            return RestResponse.success(response);
        }
        catch (Exception ex)
        {
        }

        return  RestResponse.error(RestCode.ISSUE_ATTACHMENT_QUERY_FAILURE);
    }


}
