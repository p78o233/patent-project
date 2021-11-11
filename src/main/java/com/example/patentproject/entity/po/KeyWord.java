package com.example.patentproject.entity.po;
/*
 * @author p78o2
 * @date 2021/11/8
 */

public class KeyWord {
    private Integer id;
    private String key_word_name;

    public KeyWord() {
    }

    @Override
    public String toString() {
        return "KeyWord{" +
                "id=" + id +
                ", key_word_name='" + key_word_name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey_word_name() {
        return key_word_name;
    }

    public void setKey_word_name(String key_word_name) {
        this.key_word_name = key_word_name;
    }

    public KeyWord(Integer id, String key_word_name) {
        this.id = id;
        this.key_word_name = key_word_name;
    }
}
