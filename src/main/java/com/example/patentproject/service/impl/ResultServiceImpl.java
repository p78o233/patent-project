package com.example.patentproject.service.impl;

import com.example.patentproject.entity.po.BaseData;
import com.example.patentproject.entity.po.Cate;
import com.example.patentproject.entity.vo.ResltExcelVo;
import com.example.patentproject.mapper.ResultMapper;
import com.example.patentproject.service.ResultService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
 * @author p78o2
 * @date 2021/11/8
 */
@Service
public class ResultServiceImpl implements ResultService {
    @Autowired
    private ResultMapper resultMapper;

    //    分页查找
    @Override
    public List<ResltExcelVo> resultInfo(int applyYear, int cateId, String companyName, int page, int pageSize) {
//        分页获取公司列表
        int start = (page - 1) * pageSize;
        List<String> companys = new ArrayList<>();
        companys = resultMapper.getCompanyNames(companyName, start, pageSize);
        List<ResltExcelVo> resultVos = new ArrayList<>();
        resultVos = serarchData(applyYear, cateId, companys);
        return resultVos;
    }

    //    导出excel
    @Override
    public ResponseEntity<byte[]> exportExcel(int applyYear, int cateId) throws IOException {
        List<String> companys = new ArrayList<>();
        companys = resultMapper.getAllCompanyNames();
        List<ResltExcelVo> resultVos = new ArrayList<>();
        resultVos = serarchData(applyYear, cateId, companys);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<byte[]> filebyte = new ResponseEntity<byte[]>(outputStream.toByteArray(), httpHeaders, HttpStatus.CREATED);
        filebyte = excel("title", "测试", resultVos);
        return filebyte;
    }

    @Override
    public void downLoadExcel(int applyYear, int cateId) throws IOException {
        List<String> companys = new ArrayList<>();
        companys = resultMapper.getAllCompanyNames();
        List<ResltExcelVo> resultVos = new ArrayList<>();
        resultVos = serarchData(applyYear, cateId, companys);
//        根据cateid获取名字
        Cate cate = new Cate();
        cate = resultMapper.getCate(cateId);
        downExcel("title", String.valueOf(applyYear)+"年-"+cate.getCate_num()+"-"+cate.getCate_name(), resultVos);
    }

    public void downExcel(String excelTitle, String excelName, List<ResltExcelVo> resultVos) throws IOException{
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
//        汇总行
        HSSFRow hssfRowSum = sheet.createRow(0);
        HSSFCell cellSum = hssfRowSum.createCell(0);
//        这里需要传入
        cellSum.setCellValue(excelTitle);
//        标题行
        HSSFRow hssfTitle = sheet.createRow(1);
        HSSFCell cellTitle1 = hssfTitle.createCell(0);
        cellTitle1.setCellValue("序号");
        HSSFCell cellTitle2 = hssfTitle.createCell(1);
        cellTitle2.setCellValue("企业名称");
        HSSFCell cellTitle3 = hssfTitle.createCell(2);
        cellTitle3.setCellValue("发明授权");
        HSSFCell cellTitle4 = hssfTitle.createCell(3);
        cellTitle4.setCellValue("发明申请-有效");
        HSSFCell cellTitle5 = hssfTitle.createCell(4);
        cellTitle5.setCellValue("发明申请-审中");
        HSSFCell cellTitle6 = hssfTitle.createCell(5);
        cellTitle6.setCellValue("发明申请-PCT-有效期内");
        HSSFCell cellTitle7 = hssfTitle.createCell(6);
        cellTitle7.setCellValue("实用新型");
        HSSFCell cellTitle8 = hssfTitle.createCell(7);
        cellTitle8.setCellValue("短期专利");
        HSSFCell cellTitle9 = hssfTitle.createCell(8);
        cellTitle9.setCellValue("外观设计");
        HSSFCell cellTitle10 = hssfTitle.createCell(9);
        cellTitle10.setCellValue("被引证次数");
        HSSFCell cellTitle11 = hssfTitle.createCell(10);
        cellTitle11.setCellValue("许可次数");
        HSSFCell cellTitle12 = hssfTitle.createCell(11);
        cellTitle12.setCellValue("转让次数");

//        控制行数
        int rowNum = 2;
//        序号
        int index = 1;
        for (ResltExcelVo vo : resultVos) {
            HSSFRow hssfRow = sheet.createRow(rowNum);
//            数据
            HSSFCell cellData1 = hssfRow.createCell(0);
            cellData1.setCellValue(String.valueOf(index));
            HSSFCell cellData2 = hssfRow.createCell(1);
            cellData2.setCellValue(vo.getCompanyName());
            HSSFCell cellData3 = hssfRow.createCell(2);
            cellData3.setCellValue(vo.getInventionAuthorizationNum());
            HSSFCell cellData4 = hssfRow.createCell(3);
            cellData4.setCellValue(vo.getInventionApplicationValid());
            HSSFCell cellData5 = hssfRow.createCell(4);
            cellData5.setCellValue(vo.getInventionApplicationPending());
            HSSFCell cellData6 = hssfRow.createCell(5);
            cellData6.setCellValue(vo.getInventionApplicationPCT());
            HSSFCell cellData7 = hssfRow.createCell(6);
            cellData7.setCellValue(vo.getUtilityModel());
            HSSFCell cellData8 = hssfRow.createCell(7);
            cellData8.setCellValue(vo.getShortTermPatent());
            HSSFCell cellData9 = hssfRow.createCell(8);
            cellData9.setCellValue(vo.getAppearanceDesign());
            HSSFCell cellData10 = hssfRow.createCell(9);
            cellData10.setCellValue(vo.getNumberOfCitations());
            HSSFCell cellData11 = hssfRow.createCell(10);
            cellData11.setCellValue(vo.getLicensesNum());
            HSSFCell cellData12 = hssfRow.createCell(11);
            cellData12.setCellValue(vo.getTransfersNum());
            rowNum++;
            index++;
        }
        try {
            FileOutputStream out=new FileOutputStream("D:\\工程管理\\作业\\薛小龙院长工程\\"+excelName+"结果数据导出.xls");
            wb.write(out);//导出至服务器中
            out.close();
            System.out.println("导出完毕！");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResponseEntity<byte[]> excel(String excelTitle, String excelName, List<ResltExcelVo> resultVos) throws IOException {
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
//        汇总行
        HSSFRow hssfRowSum = sheet.createRow(0);
        HSSFCell cellSum = hssfRowSum.createCell(0);
//        这里需要传入
        cellSum.setCellValue(excelTitle);

//        标题行
        HSSFRow hssfTitle = sheet.createRow(1);
        HSSFCell cellTitle1 = hssfTitle.createCell(0);
        cellTitle1.setCellValue("序号");
        HSSFCell cellTitle2 = hssfTitle.createCell(1);
        cellTitle2.setCellValue("企业名称");
        HSSFCell cellTitle3 = hssfTitle.createCell(2);
        cellTitle3.setCellValue("发明授权");
        HSSFCell cellTitle4 = hssfTitle.createCell(3);
        cellTitle4.setCellValue("发明申请-有效");
        HSSFCell cellTitle5 = hssfTitle.createCell(4);
        cellTitle5.setCellValue("发明申请-审中");
        HSSFCell cellTitle6 = hssfTitle.createCell(5);
        cellTitle6.setCellValue("发明申请-PCT-有效期内");
        HSSFCell cellTitle7 = hssfTitle.createCell(6);
        cellTitle7.setCellValue("实用新型");
        HSSFCell cellTitle8 = hssfTitle.createCell(7);
        cellTitle8.setCellValue("短期专利");
        HSSFCell cellTitle9 = hssfTitle.createCell(8);
        cellTitle9.setCellValue("外观设计");
        HSSFCell cellTitle10 = hssfTitle.createCell(9);
        cellTitle10.setCellValue("被引证次数");
        HSSFCell cellTitle11 = hssfTitle.createCell(10);
        cellTitle11.setCellValue("许可次数");
        HSSFCell cellTitle12 = hssfTitle.createCell(11);
        cellTitle12.setCellValue("转让次数");

//        控制行数
        int rowNum = 2;
//        序号
        int index = 1;
        for (ResltExcelVo vo : resultVos) {
            HSSFRow hssfRow = sheet.createRow(rowNum);
//            数据
            HSSFCell cellData1 = hssfRow.createCell(0);
            cellData1.setCellValue(String.valueOf(index));
            HSSFCell cellData2 = hssfRow.createCell(1);
            cellData2.setCellValue(vo.getCompanyName());
            HSSFCell cellData3 = hssfRow.createCell(2);
            cellData3.setCellValue(vo.getInventionAuthorizationNum());
            HSSFCell cellData4 = hssfRow.createCell(3);
            cellData4.setCellValue(vo.getInventionApplicationValid());
            HSSFCell cellData5 = hssfRow.createCell(4);
            cellData5.setCellValue(vo.getInventionApplicationPending());
            HSSFCell cellData6 = hssfRow.createCell(5);
            cellData6.setCellValue(vo.getInventionApplicationPCT());
            HSSFCell cellData7 = hssfRow.createCell(6);
            cellData7.setCellValue(vo.getUtilityModel());
            HSSFCell cellData8 = hssfRow.createCell(7);
            cellData8.setCellValue(vo.getShortTermPatent());
            HSSFCell cellData9 = hssfRow.createCell(8);
            cellData9.setCellValue(vo.getAppearanceDesign());
            HSSFCell cellData10 = hssfRow.createCell(9);
            cellData10.setCellValue(vo.getNumberOfCitations());
            HSSFCell cellData11 = hssfRow.createCell(10);
            cellData11.setCellValue(vo.getLicensesNum());
            HSSFCell cellData12 = hssfRow.createCell(11);
            cellData12.setCellValue(vo.getTransfersNum());
            rowNum++;
            index++;
        }
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            wb.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            outputStream.close();
        }

        try {
            FileOutputStream out=new FileOutputStream("D:\\工程管理\\作业\\薛小龙院长工程\\"+excelName+".xls");
            wb.write(out);//导出至服务器中
            out.close();
            System.out.println("导出完毕！");

        } catch (Exception e) {
            e.printStackTrace();

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

    //    查询整理数据
    List<ResltExcelVo> serarchData(int applyYear, int cateId, List<String> companys) {
        //        根据类别id获取全部关键字
        List<String> keywords = new ArrayList<>();
        keywords = resultMapper.getAllKeyWord(cateId);
//        返回值
        List<ResltExcelVo> resultVos = new ArrayList<>();
//        遍历根据公司名，关键字列表获取数据信息组装数据
        for (String company : companys) {
            List<BaseData> baseDataList = new ArrayList<>();

            float inventionAuthorizationNum = 0.0f;//resultMapper.getResult(keywords, company, applyYear, 2, 0);
            baseDataList = resultMapper.getResultDetail(keywords, company, applyYear, 2, 0);
            inventionAuthorizationNum = weightedStatistics(baseDataList,company);

            float inventionApplicationValid = 0.0f;//resultMapper.getResult(keywords, company, applyYear, 1, 2);
            baseDataList = resultMapper.getResultDetail(keywords, company, applyYear, 1, 2);
            inventionApplicationValid = weightedStatistics(baseDataList,company);

            float inventionApplicationPending = 0.0f;//resultMapper.getResult(keywords, company, applyYear, 1, 1);
            baseDataList = resultMapper.getResultDetail(keywords, company, applyYear, 1, 1);
            inventionApplicationPending = weightedStatistics(baseDataList,company);

            float inventionApplicationPCT = 0.0f;

            float utilityModel = 0.0f;//resultMapper.getResult(keywords, company, applyYear, 3, 0);
            baseDataList = resultMapper.getResultDetail(keywords, company, applyYear, 3, 0);
            utilityModel = weightedStatistics(baseDataList,company);

            float shortTermPatent = 0.0f;
            float appearanceDesign = 0.0f;
            int numberOfCitations = resultMapper.getReferenceNum(company, applyYear);
            int licensesNum = resultMapper.getLicenseNum(company, applyYear);
            int transfersNum = resultMapper.getTransferNum(company, applyYear);
            ResltExcelVo vo = new ResltExcelVo(company, inventionAuthorizationNum, inventionApplicationValid,
                    inventionApplicationPending, inventionApplicationPCT, utilityModel, shortTermPatent, appearanceDesign,
                    numberOfCitations, licensesNum, transfersNum);
            resultVos.add(vo);
        }
        return resultVos;
    }

//    加权计算
    float weightedStatistics(List<BaseData> baseDataList,String company){
        float resultSum = 0.0f;
        for(BaseData baseData : baseDataList){
            String applicationStr = baseData.getApplicant();
            String [] applicationArray = applicationStr.split(";");
//                当前公司的值
            int companyIndex = 0;
            for(int i = applicationArray.length ; i > 0 ; i--){
                if(applicationArray[i-1].equals(company)){
                    companyIndex = i ;
                    break;
                }
            }
            float sum = ((applicationArray.length + 1)*applicationArray.length)/2;
            resultSum = (companyIndex / sum) + resultSum;
        }
        return resultSum;
    }
}
