package com.example.patentproject.entity.po;
/*
 * @author p78o2
 * @date 2021/11/8
 */

public class CateKeyWord {
    private Integer id;
    private int cate_id;
    private int key_word_id;

    public CateKeyWord() {
    }

    @Override
    public String toString() {
        return "CateKeyWord{" +
                "id=" + id +
                ", cate_id=" + cate_id +
                ", key_word_id=" + key_word_id +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCate_id() {
        return cate_id;
    }

    public void setCate_id(int cate_id) {
        this.cate_id = cate_id;
    }

    public int getKey_word_id() {
        return key_word_id;
    }

    public void setKey_word_id(int key_word_id) {
        this.key_word_id = key_word_id;
    }

    public CateKeyWord(Integer id, int cate_id, int key_word_id) {
        this.id = id;
        this.cate_id = cate_id;
        this.key_word_id = key_word_id;
    }
}
