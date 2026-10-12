package com.sonnet.pojo;

import java.util.*;

public class Animal {

    private String[] strs;
    private List<String> list;
    private Set<String> set;
    private Map<String,String> map;
    private Properties pros;

    @Override
    public String toString() {
        return "animal{" +
                "strs=" + Arrays.toString(strs) +
                ", list=" + list +
                ", set=" + set +
                ", map=" + map +
                ", pros=" + pros +
                '}';
    }

    public String[] getStrs() {
        return strs;
    }

    public void setStrs(String[] strs) {
        this.strs = strs;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Properties getPros() {
        return pros;
    }

    public void setPros(Properties pros) {
        this.pros = pros;
    }
}
