package com.example.patentproject.service;
/*
 * @author p78o2
 * @date 2021/11/8
 */

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    public int uploadBaseData(MultipartFile file)throws Exception;

    public int uploadCompany(MultipartFile file)throws Exception;
}
