package com.example.patentproject.controller;

import com.example.patentproject.entity.vo.ResltExcelVo;
import com.example.patentproject.service.ResultService;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * @author p78o2
 * @date 2021/11/8
 */
@Controller
@RequestMapping(value = "/result")
public class ResultController {
    @Autowired
    private ResultService resultService;

    @GetMapping(value = "/get")
    @ResponseBody
    public List<ResltExcelVo>  resultInfo(@RequestParam int applyYear, @RequestParam int cateId, @RequestParam String companyName, @RequestParam int page, @RequestParam int pageSize){
        List<ResltExcelVo> vos = new ArrayList<>();
        try {
            vos = resultService.resultInfo(applyYear,cateId,companyName,page,pageSize);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return vos;
    }
    @GetMapping("/excelExport")
    public ResponseEntity<byte[]> excelExport(@RequestParam int applyYear, @RequestParam int cateId) throws IOException{
        ResponseEntity<byte[]> filebyte =  resultService.exportExcel(applyYear,cateId);
        return filebyte;
    }

    @GetMapping(value = "/downLoadExcel")
    @ResponseBody
    public void downLoadExcel(@RequestParam int applyYear, @RequestParam int cateId) throws IOException{
        resultService.downLoadExcel(applyYear,cateId);
    }

    @GetMapping("/excel")
    public ResponseEntity<byte[]> excel() throws IOException {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet();
        HSSFCellStyle style = wb.createCellStyle();
        style.setFillForegroundColor((short) 13);
        //设置单元格前景色
        style.setFillForegroundColor((short) 13);
        //设置图案样式
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFFont font = wb.createFont();
        font.setFontName("黑体");
        font.setFontHeightInPoints((short) 16);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        style.setFont(font);
        //设置单元格合并
        //Region region = new Region(0,(short) 0,0,(short) 6);
        //sheet.addMergedRegion(region);
        HSSFRow hssfRowTitle = sheet.createRow(0);
        HSSFCell cellTitle = hssfRowTitle.createCell(0);
        cellTitle.setCellValue( "标题行");

        for (int rownum = 1; rownum < 50; rownum++) {
            HSSFRow hssfRow = sheet.createRow(rownum);
            for (int cellnum = 0; cellnum < 30; cellnum++) {
                HSSFCell cell = hssfRow.createCell((short) cellnum);
                cell.setCellValue(rownum + "" + cellnum);
            }
        }
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            wb.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            outputStream.close();
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        String fileName = new String("测试.xls".getBytes("UTF-8"), "iso-8859-1");
        httpHeaders.setContentDispositionFormData("attachment", fileName);
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        ResponseEntity<byte[]> filebyte = new ResponseEntity<byte[]>(outputStream.toByteArray(), httpHeaders, HttpStatus.CREATED);
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            outputStream.close();
        }
        return filebyte;
    }
}
