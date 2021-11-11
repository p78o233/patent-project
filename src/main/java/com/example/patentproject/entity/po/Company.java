package com.example.patentproject.entity.po;
/*
 * @author p78o2
 * @date 2021/11/9
 */

public class Company {
    private Integer id;
    private String company_name;

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", company_name='" + company_name + '\'' +
                '}';
    }

    public Company() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public Company(Integer id, String company_name) {
        this.id = id;
        this.company_name = company_name;
    }
}
