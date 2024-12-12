package com.ele.shiyan.model;

public class Business {
    private Integer businessId;
    private String businessName;
    private String businessAddress;
    private String businessExplain;
    private String businessImg;
    private Integer orderTypeId;
    private Double starPrice;
    private Double deliveryPrice;
    private String remarks;

    public Business() {
    }

    public Business(Integer businessId, String businessName, String businessAddress, String businessExplain, String businessImg, Integer orderTypeId, Double starPrice, Double deliveryPrice, String remarks) {
        this.businessId = businessId;
        this.businessName = businessName;
        this.businessAddress = businessAddress;
        this.businessExplain = businessExplain;
        this.businessImg = businessImg;
        this.orderTypeId = orderTypeId;
        this.starPrice = starPrice;
        this.deliveryPrice = deliveryPrice;
        this.remarks = remarks;
    }

    public Business(Integer businessId, String businessImg, String businessName, Double starPrice, Double deliveryPrice, String businessExplain) {
        this.businessId = businessId;
        this.businessName = businessName;
        this.businessExplain = businessExplain;
        this.businessImg = businessImg;
        this.starPrice = starPrice;
        this.deliveryPrice = deliveryPrice;
    }

    /**
     * 获取
     * @return businessId
     */
    public Integer getBusinessId() {
        return businessId;
    }

    /**
     * 设置
     * @param businessId
     */
    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    /**
     * 获取
     * @return businessName
     */
    public String getBusinessName() {
        return businessName;
    }

    /**
     * 设置
     * @param businessName
     */
    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    /**
     * 获取
     * @return businessAddress
     */
    public String getBusinessAddress() {
        return businessAddress;
    }

    /**
     * 设置
     * @param businessAddress
     */
    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    /**
     * 获取
     * @return businessExplain
     */
    public String getBusinessExplain() {
        return businessExplain;
    }

    /**
     * 设置
     * @param businessExplain
     */
    public void setBusinessExplain(String businessExplain) {
        this.businessExplain = businessExplain;
    }

    /**
     * 获取
     * @return businessImg
     */
    public String getBusinessImg() {
        return businessImg;
    }

    /**
     * 设置
     * @param businessImg
     */
    public void setBusinessImg(String businessImg) {
        this.businessImg = businessImg;
    }

    /**
     * 获取
     * @return orderTypeId
     */
    public Integer getOrderTypeId() {
        return orderTypeId;
    }

    /**
     * 设置
     * @param orderTypeId
     */
    public void setOrderTypeId(Integer orderTypeId) {
        this.orderTypeId = orderTypeId;
    }

    /**
     * 获取
     * @return starPrice
     */
    public Double getStarPrice() {
        return starPrice;
    }

    /**
     * 设置
     * @param starPrice
     */
    public void setStarPrice(Double starPrice) {
        this.starPrice = starPrice;
    }

    /**
     * 获取
     * @return deliveryPrice
     */
    public Double getDeliveryPrice() {
        return deliveryPrice;
    }

    /**
     * 设置
     * @param deliveryPrice
     */
    public void setDeliveryPrice(Double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    /**
     * 获取
     * @return remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置
     * @param remarks
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String toString() {
        return "Business{businessId = " + businessId + ", businessName = " + businessName + ", businessAddress = " + businessAddress + ", businessExplain = " + businessExplain + ", businessImg = " + businessImg + ", orderTypeId = " + orderTypeId + ", starPrice = " + starPrice + ", deliveryPrice = " + deliveryPrice + ", remarks = " + remarks + "}";
    }
}
