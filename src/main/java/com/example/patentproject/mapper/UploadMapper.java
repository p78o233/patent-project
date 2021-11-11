package com.example.patentproject.mapper;
/*
 * @author p78o2
 * @date 2021/11/8
 */

import com.example.patentproject.entity.po.BaseData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UploadMapper {
    @Insert("<script> " +
            "insert into base_data (title,abstract_title,applicant,announce_num,announce_date,apply_num,apply_year,apply_type,ipc_main_type," +
            "ipc,national_economic_classification,first_apply,num_of_apply,apply_province,apply_city,apply_area,credit_code," +
            "reference_num,effectiveness,legal_status,transfer_num,license_num)"+
            "values "+
            "<foreach collection=\"items\" index=\"index\" item=\"item\" separator=\",\"> "+
            "(#{item.title},#{item.abstract_title},#{item.applicant},#{item.announce_num},#{item.announce_date},#{item.apply_num},#{item.apply_year},#{item.apply_type},#{item.ipc_main_type}," +
            "#{item.ipc},#{item.national_economic_classification},#{item.first_apply},#{item.num_of_apply},#{item.apply_province},#{item.apply_city},#{item.apply_area},#{item.credit_code},#{item.reference_num}," +
            "#{item.effectiveness},#{item.legal_status},#{item.transfer_num},#{item.license_num})"
            +
            "</foreach> " +
            "</script>"
    )
    int insertBaseData(@Param("items")List<BaseData> list);

    @Insert("<script> " +
            "insert ignore into company (company_name)" +
            "values " +
            "<foreach collection=\"items\" index=\"index\" item=\"item\" separator=\",\"> "+
            "(#{item})"+
            "</foreach> "+
            "</script>")
    int insertCompanyData(@Param("items")List<String> companys);
}
