package com.cjy.music.domain;

import java.util.Date;

public class Consumer{

    private Integer id;
    private String username;
    private String password;
    private Byte sex;
    private String phoneNum;
    private String email;
    private Date birth;
    private String introduction;
    private String location;
    private String avator;
    private Date createTime;
    private Date updateTime;

    public void setId(Integer id){
        this.id=id;
    }
    public Integer getId(){
        return id;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public String getUsername(){
        return username;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getPassword(){
        return password;
    }
    public void setSex(Byte sex){
        this.sex=sex;
    }
    public Byte getSex(){
        return sex;
    }
    public void setPhoneNum(String phoneNum){
        this.phoneNum=phoneNum;
    }
    public String getPhoneNum(){
        return phoneNum;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return email;
    }
    public void setBirth(Date birth){
        this.birth=birth;
    }
    public Date getBirth(){
        return birth;
    }
    public void setIntroduction(String introduction){
        this.introduction=introduction;
    }
    public String getIntroduction(){
        return introduction;
    }
    public void setLocation(String location){
        this.location=location;
    }
    public String getLocation(){
        return location;
    }
    public void setAvator(String avator){
        this.avator=avator;
    }
    public String getAvator(){
        return avator;
    }
    public void setCreateTime(Date createTime){
        this.createTime=createTime;
    }
    public Date getCreateTime(){
        return createTime;
    }
    public void setUpdateTime(Date updateTime){
        this.updateTime=updateTime;
    }
    public Date getUpdateTime(){
        return updateTime;
    }
}
