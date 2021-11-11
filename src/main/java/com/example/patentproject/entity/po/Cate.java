package com.example.patentproject.entity.po;
/*
 * @author p78o2
 * @date 2021/11/8
 */

public class Cate {
    private Integer id;
    private String cate_name;
    private int parent_id;
    private String cate_num;

    @Override
    public String toString() {
        return "Cate{" +
                "id=" + id +
                ", cate_name='" + cate_name + '\'' +
                ", parent_id=" + parent_id +
                ", cate_num='" + cate_num + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCate_name() {
        return cate_name;
    }

    public void setCate_name(String cate_name) {
        this.cate_name = cate_name;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public String getCate_num() {
        return cate_num;
    }

    public void setCate_num(String cate_num) {
        this.cate_num = cate_num;
    }

    public Cate() {
    }

    public Cate(Integer id, String cate_name, int parent_id, String cate_num) {
        this.id = id;
        this.cate_name = cate_name;
        this.parent_id = parent_id;
        this.cate_num = cate_num;
    }
}
