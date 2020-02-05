package com.example.demo.service;

import com.example.demo.util.FileUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service("FileService")
public class FileService
{
    @Value("${file.path}")
    private String filePath;

    public List<String> getImgPaths(List<MultipartFile> files) {
        List<String> paths =  new ArrayList<>();
        files.forEach(file -> {
            File localFile = null;
            try {
                if (!file.isEmpty()) {
                    localFile = FileUtil.saveToLocal(file, filePath);
                    String path =  StringUtils.substringAfterLast(localFile.getAbsolutePath(), filePath);
                    paths.add(path);
                }
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        });
        return paths;

    }
}
