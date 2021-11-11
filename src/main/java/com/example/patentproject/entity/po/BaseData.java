package com.example.patentproject.entity.po;
/*
 * @author p78o2
 * @date 2021/11/8
 */

import java.util.Date;

public class BaseData {
    private Integer id;
    private String title;
    private String abstract_title;
    private String applicant;
    private String announce_num;
    private Date announce_date;
    private String apply_num;
    private int apply_year;
//    1、发明申请 2、发明授权  3、实用新型
    private int apply_type;
    private String ipc_main_type;
    private String ipc;
    private String national_economic_classification;
    private String first_apply;
    private int num_of_apply;
    private String apply_province;
    private String apply_city;
    private String apply_area;
    private String credit_code;
    private int reference_num;
//    1、审中  2、有效
    private int effectiveness;
//    1、公开 2、实质审查  3、授权
    private int legal_status;
    private int transfer_num;
    private int license_num;

    public BaseData() {
    }

    @Override
    public String toString() {
        return "BaseData{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", abstract_title='" + abstract_title + '\'' +
                ", applicant='" + applicant + '\'' +
                ", announce_num='" + announce_num + '\'' +
                ", announce_date=" + announce_date +
                ", apply_num='" + apply_num + '\'' +
                ", apply_year=" + apply_year +
                ", apply_type=" + apply_type +
                ", ipc_main_type='" + ipc_main_type + '\'' +
                ", ipc='" + ipc + '\'' +
                ", national_economic_classification='" + national_economic_classification + '\'' +
                ", first_apply='" + first_apply + '\'' +
                ", num_of_apply=" + num_of_apply +
                ", apply_province='" + apply_province + '\'' +
                ", apply_city='" + apply_city + '\'' +
                ", apply_area='" + apply_area + '\'' +
                ", credit_code='" + credit_code + '\'' +
                ", reference_num=" + reference_num +
                ", effectiveness=" + effectiveness +
                ", legal_status=" + legal_status +
                ", transfer_num=" + transfer_num +
                ", license_num=" + license_num +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstract_title() {
        return abstract_title;
    }

    public void setAbstract_title(String abstract_title) {
        this.abstract_title = abstract_title;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getAnnounce_num() {
        return announce_num;
    }

    public void setAnnounce_num(String announce_num) {
        this.announce_num = announce_num;
    }

    public Date getAnnounce_date() {
        return announce_date;
    }

    public void setAnnounce_date(Date announce_date) {
        this.announce_date = announce_date;
    }

    public String getApply_num() {
        return apply_num;
    }

    public void setApply_num(String apply_num) {
        this.apply_num = apply_num;
    }

    public int getApply_year() {
        return apply_year;
    }

    public void setApply_year(int apply_year) {
        this.apply_year = apply_year;
    }

    public int getApply_type() {
        return apply_type;
    }

    public void setApply_type(int apply_type) {
        this.apply_type = apply_type;
    }

    public String getIpc_main_type() {
        return ipc_main_type;
    }

    public void setIpc_main_type(String ipc_main_type) {
        this.ipc_main_type = ipc_main_type;
    }

    public String getIpc() {
        return ipc;
    }

    public void setIpc(String ipc) {
        this.ipc = ipc;
    }

    public String getNational_economic_classification() {
        return national_economic_classification;
    }

    public void setNational_economic_classification(String national_economic_classification) {
        this.national_economic_classification = national_economic_classification;
    }

    public String getFirst_apply() {
        return first_apply;
    }

    public void setFirst_apply(String first_apply) {
        this.first_apply = first_apply;
    }

    public int getNum_of_apply() {
        return num_of_apply;
    }

    public void setNum_of_apply(int num_of_apply) {
        this.num_of_apply = num_of_apply;
    }

    public String getApply_province() {
        return apply_province;
    }

    public void setApply_province(String apply_province) {
        this.apply_province = apply_province;
    }

    public String getApply_city() {
        return apply_city;
    }

    public void setApply_city(String apply_city) {
        this.apply_city = apply_city;
    }

    public String getApply_area() {
        return apply_area;
    }

    public void setApply_area(String apply_area) {
        this.apply_area = apply_area;
    }

    public String getCredit_code() {
        return credit_code;
    }

    public void setCredit_code(String credit_code) {
        this.credit_code = credit_code;
    }

    public int getReference_num() {
        return reference_num;
    }

    public void setReference_num(int reference_num) {
        this.reference_num = reference_num;
    }

    public int getEffectiveness() {
        return effectiveness;
    }

    public void setEffectiveness(int effectiveness) {
        this.effectiveness = effectiveness;
    }

    public int getLegal_status() {
        return legal_status;
    }

    public void setLegal_status(int legal_status) {
        this.legal_status = legal_status;
    }

    public int getTransfer_num() {
        return transfer_num;
    }

    public void setTransfer_num(int transfer_num) {
        this.transfer_num = transfer_num;
    }

    public int getLicense_num() {
        return license_num;
    }

    public void setLicense_num(int license_num) {
        this.license_num = license_num;
    }

    public BaseData(Integer id, String title, String abstract_title, String applicant, String announce_num, Date announce_date, String apply_num, int apply_year, int apply_type, String ipc_main_type, String ipc, String national_economic_classification, String first_apply, int num_of_apply, String apply_province, String apply_city, String apply_area, String credit_code, int reference_num, int effectiveness, int legal_status, int transfer_num, int license_num) {
        this.id = id;
        this.title = title;
        this.abstract_title = abstract_title;
        this.applicant = applicant;
        this.announce_num = announce_num;
        this.announce_date = announce_date;
        this.apply_num = apply_num;
        this.apply_year = apply_year;
        this.apply_type = apply_type;
        this.ipc_main_type = ipc_main_type;
        this.ipc = ipc;
        this.national_economic_classification = national_economic_classification;
        this.first_apply = first_apply;
        this.num_of_apply = num_of_apply;
        this.apply_province = apply_province;
        this.apply_city = apply_city;
        this.apply_area = apply_area;
        this.credit_code = credit_code;
        this.reference_num = reference_num;
        this.effectiveness = effectiveness;
        this.legal_status = legal_status;
        this.transfer_num = transfer_num;
        this.license_num = license_num;
    }
}
