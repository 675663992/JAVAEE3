package com.ele.shiyan.model;

public class DeliveryAddress {
    private Integer daId;
    private String contactName;
    private Integer contactSex;
    private String contactTel;
    private String address;
    private String userId;

    public DeliveryAddress() {
    }

    public DeliveryAddress(Integer daId, String contactName, Integer contactSex, String contactTel, String address, String userId) {
        this.daId = daId;
        this.contactName = contactName;
        this.contactSex = contactSex;
        this.contactTel = contactTel;
        this.address = address;
        this.userId = userId;
    }

    /**
     * 获取
     * @return daId
     */
    public Integer getDaId() {
        return daId;
    }

    /**
     * 设置
     * @param daId
     */
    public void setDaId(Integer daId) {
        this.daId = daId;
    }

    /**
     * 获取
     * @return contactName
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * 设置
     * @param contactName
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    /**
     * 获取
     * @return contactSex
     */
    public Integer getContactSex() {
        return contactSex;
    }

    /**
     * 设置
     * @param contactSex
     */
    public void setContactSex(Integer contactSex) {
        this.contactSex = contactSex;
    }

    /**
     * 获取
     * @return contactTel
     */
    public String getContactTel() {
        return contactTel;
    }

    /**
     * 设置
     * @param contactTel
     */
    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    /**
     * 获取
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取
     * @return userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String toString() {
        return "DeliveryAddress{daId = " + daId + ", contactName = " + contactName + ", contactSex = " + contactSex + ", contactTel = " + contactTel + ", address = " + address + ", userId = " + userId + "}";
    }
}
