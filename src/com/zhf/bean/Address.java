package com.zhf.bean;

import java.io.Serializable;

/**
 * 家庭地址类
 * 包含省份，城市，区三个属性
 *
 */
public class Address implements Serializable {
    private String province;        //省份
    private String city;            //城市
    private String community;       //区或县

    public Address(){

    }

    public Address(String province, String city, String community) {
        this.province = province;
        this.city = city;
        this.community = community;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    @Override
    public String toString() {
        return   province + "省" +
                 city + "市" +
                community + "县或区";
    }


}
