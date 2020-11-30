package com.xdclass.userapp.model;

import java.io.Serializable;
import java.util.Date;

public class TCoupon implements Serializable {
    private Integer id;

    private String code;

    private String picUrl;

    private Integer archieveAmount;

    private Integer reduceAmount;

    private Integer stock;

    private String title;

    private Integer status;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public Integer getArchieveAmount() {
        return archieveAmount;
    }

    public void setArchieveAmount(Integer archieveAmount) {
        this.archieveAmount = archieveAmount;
    }

    public Integer getReduceAmount() {
        return reduceAmount;
    }

    public void setReduceAmount(Integer reduceAmount) {
        this.reduceAmount = reduceAmount;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "TCoupon{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", archieveAmount=" + archieveAmount +
                ", reduceAmount=" + reduceAmount +
                ", stock=" + stock +
                ", title='" + title + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}