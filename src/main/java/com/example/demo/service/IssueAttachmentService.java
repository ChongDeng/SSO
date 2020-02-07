package com.example.demo.service;

import com.example.demo.entity.IssueAttachment;
import com.example.demo.entity.User;
import com.example.demo.mapper.IssueAttachmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;

@Service("IssueAttachmentService")
public class IssueAttachmentService {

    @Autowired
    IssueAttachmentMapper issueAttachmentMapper;

    @Transactional(rollbackFor = Exception.class)
    public boolean insert(User user, Long IssueId, Long IssueRecordId, String SharedUrl)
    {
        IssueAttachment entity = new IssueAttachment();


        entity.setIssue_id(IssueId);
        entity.setIssue_record_id(IssueRecordId);
        entity.setAttachment_url(SharedUrl);

        entity.setIs_disabled(false);

        entity.setCreator(user.getId());
        entity.setCreated(new Date());
        entity.setCreated_by(user.getLogin_name());
        entity.setModified_by(user.getLogin_name());
        entity.setModified(new Date());


        issueAttachmentMapper.insertSelective(entity);

        return true;
    }


    @Transactional(rollbackFor = Exception.class)
    public boolean remove(User user, Long IssueId, Long IssueRecordId, String SharedUrl)
    {
        IssueAttachment entity = new IssueAttachment();

        entity.setCreator(user.getId());
        entity.setIssue_id(IssueId);
        entity.setIssue_record_id(IssueRecordId);
        entity.setAttachment_url(SharedUrl);

        issueAttachmentMapper.remove(entity);

        return true;
    }
}
