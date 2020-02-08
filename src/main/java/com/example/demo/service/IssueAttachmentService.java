package com.example.demo.service;

import com.example.demo.entity.IssueAttachment;
import com.example.demo.entity.User;
import com.example.demo.mapper.IssueAttachmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("IssueAttachmentService")
public class IssueAttachmentService {

    @Autowired
    IssueAttachmentMapper issueAttachmentMapper;


    @Autowired
    UserService userService;

    @Transactional(rollbackFor = Exception.class)
    public boolean insert(IssueAttachment entity)
    {
        try
        {
            User user = userService.getUserById(entity.getCreator());

            entity.setModified_by(user.getLogin_name());
            entity.setModified(new Date());
            entity.setCreated_by(user.getLogin_name());
            entity.setCreated(new Date());
            entity.setStatus(0);

            issueAttachmentMapper.insertSelective(entity);
        }
        catch(Exception ex)
        {
            return false;
        }

        return true;
    }


    @Transactional(rollbackFor = Exception.class)
    public boolean remove_logical(IssueAttachment issueAttachment)
    {
        User user = userService.getUserById(issueAttachment.getCreator());

        //1 means disable
        issueAttachment.setStatus(1);
        issueAttachment.setModified(new Date());
        issueAttachment.setModified_by(user.getLogin_name());

        issueAttachmentMapper.setStatus(issueAttachment);
        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean remove_phisics(IssueAttachment issueAttachment)
    {
        issueAttachmentMapper.remove(issueAttachment);
        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<IssueAttachment> getItems(IssueAttachment issueAttachment)
    {
        return issueAttachmentMapper.getItems(issueAttachment);
    }


}
