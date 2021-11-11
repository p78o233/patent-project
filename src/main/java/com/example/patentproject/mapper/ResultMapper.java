package com.example.patentproject.mapper;
/*
 * @author p78o2
 * @date 2021/11/8
 */

import com.example.patentproject.entity.po.Cate;
import com.example.patentproject.entity.po.Company;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ResultMapper {
    //    分页查询所有公司名
    @Select("<script>" +
            "select company_name from company where 1=1 " +
            "<if test = 'companyName != null and companyName!=\"\" '>" +
            "and company_name like '%${companyName}%' " +
            "</if>" +
            "order by id desc limit #{start},#{pageSize}" +
            "</script>")
    List<String> getCompanyNames(@Param("companyName") String companyName, @Param("start") int start, @Param("pageSize") int pageSize);

//    获取全部公司名
    @Select("select company_name from company")
    List<String> getAllCompanyNames();
    //    根据类别id查询出全部关键字列表
    @Select("select key_word_name from key_word where id in (select key_word_id from cate_key_word where cate_id = #{cateId})")
    List<String> getAllKeyWord(@Param("cateId") int cateId);

    //    根据公司名查询出对应的数据
    @Select("<script>" +
            "select count(*) from base_data where 1 = 1" +
//            "(" +
//            "<foreach collection=\"keywords\" index=\"index\" item=\"item\" > " +
//            "<if test = 'index == 0'>" +
//            "abstract_title like '%${item}%'" +
//            "</if>" +
//            "<if test = 'index != 0'>" +
//            " or abstract_title like '%${item}%'" +
//            "</if>" +
//            "</foreach> " +
//            ")" +
            " and applicant like '%${company}%' and apply_year = #{applyYear}" +
            "<if test = 'applyType != 0'>" +
            "and apply_type = #{applyType}" +
            "</if>" +
            "<if test = 'effectiveness != 0'>" +
            "and effectiveness = #{effectiveness}" +
            "</if>" +
            "</script>")
    int getResult(@Param("keywords") List<String> keywords, @Param("company") String company, @Param("applyYear") int applyYear, @Param("applyType") int applyType, @Param("effectiveness") int effectiveness);

    //    引用次数
    @Select("select IFNULL(sum(reference_num),0) from base_data where applicant = #{applicant} and apply_year = #{applyYear}")
    int getReferenceNum(@Param("applicant") String applicant, @Param("applyYear") int applyYear);

    //    许可次数
    @Select("select IFNULL(sum(license_num),0) from base_data where applicant = #{applicant} and apply_year = #{applyYear}")
    int getLicenseNum(@Param("applicant") String applicant, @Param("applyYear") int applyYear);

    //    转让次数
    @Select("select IFNULL(sum(transfer_num),0) from base_data where applicant = #{applicant} and apply_year = #{applyYear}")
    int getTransferNum(@Param("applicant") String applicant, @Param("applyYear") int applyYear);

//    根据cateId获取类别数据
    @Select("select * from cate where id = #{id}")
    Cate getCate(@Param("id")int cateId);
}
