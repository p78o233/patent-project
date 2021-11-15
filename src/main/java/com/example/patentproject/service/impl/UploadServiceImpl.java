package com.example.patentproject.service.impl;

import com.example.patentproject.entity.po.BaseData;
import com.example.patentproject.exception.MyException;
import com.example.patentproject.mapper.UploadMapper;
import com.example.patentproject.service.UploadService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * @author p78o2
 * @date 2021/11/8
 */
@Service
public class UploadServiceImpl implements UploadService {
    @Autowired
    private UploadMapper uploadMapper;
    @Override
    public int uploadBaseData(MultipartFile file) throws Exception {
        int result = 0;
//		存放excel表中所信息
        List<BaseData> baseDataList = new ArrayList<>();
        /**
         *
         * 判断文件版本
         */
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);

        InputStream ins = file.getInputStream();

        Workbook wb = null;

        if (suffix.equals("xlsx")) {

            wb = new XSSFWorkbook(ins);

        } else {
            wb = new HSSFWorkbook(ins);
        }
        /**
         * 获取excel表单
         */
        Sheet sheet = wb.getSheetAt(0);


        /**
         * line = 1 :从表的第二行开始获取记录
         *
         */
        if (null != sheet) {

            for (int line = 1; line <= sheet.getLastRowNum(); line++) {

                BaseData baseData = new BaseData();

                Row row = sheet.getRow(line);

                if (null == row) {
                    continue;
                }
                /**
                 * 判断单元格类型是否为文本类型
                 */
                String title = row.getCell(1).getStringCellValue();
                String abstract_title = row.getCell(2) == null ? "" : row.getCell(2).getStringCellValue();
                String applicant = row.getCell(3).getStringCellValue();
                String announce_num = row.getCell(4).getStringCellValue();
                Date announce_date = row.getCell(5).getDateCellValue();
                row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
                String apply_num = row.getCell(6).getStringCellValue();
                row.getCell(7).setCellType(Cell.CELL_TYPE_STRING);
                int apply_year = Integer.valueOf(row.getCell(7).getStringCellValue());
                String apply_typeStr = row.getCell(8).getStringCellValue();
                int apply_type = 0;
                switch (apply_typeStr){
                    case "发明申请":
                        apply_type = 1;
                        break;
                    case "发明授权":
                        apply_type = 2;
                        break;
                    case "实用新型":
                        apply_type = 3;
                        break;
                }
                String ipc_main_type = row.getCell(9).getStringCellValue();
                String ipc = row.getCell(10).getStringCellValue();
                String national_economic_classification = row.getCell(11) == null ?"": row.getCell(11).getStringCellValue();
                String first_apply = row.getCell(12).getStringCellValue();
                int num_of_apply = row.getCell(13).getCellType();
                String apply_province = row.getCell(14) == null ?"":row.getCell(14).getStringCellValue();
                String apply_city = row.getCell(15) == null?"":row.getCell(15).getStringCellValue();
                String apply_area = row.getCell(16) == null? "" : row.getCell(16).getStringCellValue();
                if(row.getCell(17) != null){
                    row.getCell(17).setCellType(Cell.CELL_TYPE_STRING);
                }
                String credit_code = row.getCell(17) ==null ? "":row.getCell(17).getStringCellValue();
                int reference_num = row.getCell(18) == null || row.getCell(18).getStringCellValue().equals("") ? 0 : Integer.valueOf(row.getCell(18).getStringCellValue());
                String effectivenessStr = row.getCell(19).getStringCellValue();
                int effectiveness = 0;
                switch (effectivenessStr){
                    case "审中":
                        effectiveness = 1;
                        break;
                    case "有效":
                        effectiveness = 2;
                        break;
                }
                String legal_statusStr = row.getCell(20).getStringCellValue();
                int legal_status = 0;
                switch (legal_statusStr){
                    case "公开":
                        legal_status = 1;
                        break;
                    case "实质审查":
                        legal_status = 2;
                        break;
                    case "授权":
                        legal_status = 3;
                        break;
                }
                if(row.getCell(21) != null){
                    row.getCell(21).setCellType(Cell.CELL_TYPE_STRING);
                }
                int transfer_num = row.getCell(21) == null || row.getCell(21).getStringCellValue().equals("") ? 0 : Integer.valueOf(row.getCell(21).getStringCellValue());
                if(row.getCell(22) != null){
                    row.getCell(22).setCellType(Cell.CELL_TYPE_STRING);
                }
                int license_num = row.getCell(22) == null || row.getCell(22).getStringCellValue().equals("") ? 0 : Integer.valueOf(row.getCell(22).getStringCellValue());

                baseData.setTitle(title);
                baseData.setAbstract_title(abstract_title);
                baseData.setApplicant(applicant);
                baseData.setAnnounce_num(announce_num);
                baseData.setAnnounce_date(announce_date);
                baseData.setApply_num(apply_num);
                baseData.setApply_year(apply_year);
                baseData.setApply_type(apply_type);
                baseData.setIpc_main_type(ipc_main_type);
                baseData.setIpc(ipc);
                baseData.setNational_economic_classification(national_economic_classification);
                baseData.setFirst_apply(first_apply);
                baseData.setNum_of_apply(num_of_apply);
                baseData.setApply_province(apply_province);
                baseData.setApply_city(apply_city);
                baseData.setApply_area(apply_area);
                baseData.setCredit_code(credit_code);
                baseData.setReference_num(reference_num);
                baseData.setEffectiveness(effectiveness);
                baseData.setLegal_status(legal_status);
                baseData.setTransfer_num(transfer_num);
                baseData.setLicense_num(license_num);
                baseDataList.add(baseData);
            }
            result = uploadMapper.insertBaseData(baseDataList);
        }
        return result;
    }

    @Override
    public int uploadCompany(MultipartFile file) throws Exception {
        int result = 0;
        //        需要导出的公司名称列表
        List<String> companys = new ArrayList<>();
        /**
         *
         * 判断文件版本
         */
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);

        InputStream ins = file.getInputStream();

        Workbook wb = null;

        if (suffix.equals("xlsx")) {

            wb = new XSSFWorkbook(ins);

        } else {
            wb = new HSSFWorkbook(ins);
        }
        /**
         * 获取excel表单
         */
        Sheet sheet = wb.getSheetAt(0);


        if (null != sheet) {
//            从第三行开始读
            for (int line = 2; line <= sheet.getLastRowNum(); line++) {

                String companyName = "";

                Row row = sheet.getRow(line);

                if (null == row) {
                    continue;
                }
                /**
                 * 判断单元格类型是否为文本类型
                 */
                companyName = row.getCell(1).getStringCellValue();

                companys.add(companyName);
            }
            result = uploadMapper.insertCompanyData(companys);
        }
        return  result;
    }
}
