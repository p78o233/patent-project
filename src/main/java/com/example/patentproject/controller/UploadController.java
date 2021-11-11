package com.example.patentproject.controller;

import com.example.patentproject.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

/*
 * @author p78o2
 * @date 2021/11/8
 */
@RestController
@RequestMapping(value = "/upload")
public class UploadController {
    @Autowired
    private UploadService uploadService;
    @PostMapping(value = "/uploadBaseData")
    public String excelImport(@RequestParam(value="filename") MultipartFile file){

//		String fileName = file.getOriginalFilename();

        int result = 0;

        try {
            result = uploadService.uploadBaseData(file);
        } catch (Exception e) {

            e.printStackTrace();
        }

        if(result > 0){
            return "excel文件数据导入成功！";
        }else{
            return "excel数据导入失败！";
        }
    }
    @PostMapping(value = "/uploadCompanyData")
    public int uploadCompanyData(@RequestParam(value="filename") MultipartFile file){
        int result = 0;

        try {
            result = uploadService.uploadCompany(file);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return result;
    }
}
