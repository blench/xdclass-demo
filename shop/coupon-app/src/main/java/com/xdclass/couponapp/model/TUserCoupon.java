package com.xdclass.couponapp.model;

import java.io.Serializable;
import java.util.Date;

public class TUserCoupon implements Serializable {
    private Integer id;

    private String userCouponCode;

    private String picUrl;

    private Integer couponId;

    private Integer userId;

    private Integer status;

    private Integer orderId;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserCouponCode() {
        return userCouponCode;
    }

    public void setUserCouponCode(String userCouponCode) {
        this.userCouponCode = userCouponCode == null ? null : userCouponCode.trim();
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "TUserCoupon{" +
                "id=" + id +
                ", userCouponCode='" + userCouponCode + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", couponId=" + couponId +
                ", userId=" + userId +
                ", status=" + status +
                ", orderId=" + orderId +
                ", createTime=" + createTime +
                '}';
    }
}