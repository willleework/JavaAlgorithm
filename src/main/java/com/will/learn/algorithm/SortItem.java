package com.will.learn.algorithm;
/**
 * @author liwei15515
 * @since 2018/12/4
 * */
public class SortItem {
    /**
     *
     * @param id
     * @param name
     */
    public SortItem(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer id = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name = "";
}
