package com.example.patentproject.service;
/*
 * @author p78o2
 * @date 2021/11/8
 */

import com.example.patentproject.entity.vo.ResltExcelVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ResultService {
//    分页统计
    public List<ResltExcelVo> resultInfo(int applyYear,int cateId, String companyName, int page, int pageSize);
//    导出excel
    public ResponseEntity<byte[]> exportExcel(int applyYear,int cateId)throws IOException;
//    下载excel
    public void downLoadExcel(int applyYear,int cateId)throws IOException;
}
