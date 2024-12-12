package com.ele.shiyan.model;

import java.util.List;

public class Orders {
    private Integer orderId;
    private String userId;
    private Integer businessId;
    private String orderDate;
    private Double orderTotal;
    private Integer daId;
    private Integer orderState;

    //多对一
    private Business business;
    //一对多
    private List<OrderDetailet> list;

    public Orders(int orderId, String userId, int businessId, String orderDate, double orderTotal, int daId, int orderState, Business business,List<OrderDetailet> list) {
        this.orderId = orderId;
        this.userId = userId;
        this.businessId = businessId;
        this.orderDate = orderDate;
        this.orderTotal = orderTotal;
        this.daId = daId;
        this.orderState = orderState;
        this.business = business;
        this.list = list;
    }

    public Orders(int orderId, String userId, int businessId, String orderDate, double orderTotal, int daId, int orderState, Business business) {
        this.orderId = orderId;
        this.userId = userId;
        this.businessId = businessId;
        this.orderDate = orderDate;
        this.orderTotal = orderTotal;
        this.daId = daId;
        this.orderState = orderState;
        this.business = business;
    }

    public Orders() {

    }

    /**
     * 获取
     * @return orderId
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * 设置
     * @param orderId
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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
     * @return orderDate
     */
    public String getOrderDate() {
        return orderDate;
    }

    /**
     * 设置
     * @param orderDate
     */
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * 获取
     * @return orderTotal
     */
    public Double getOrderTotal() {
        return orderTotal;
    }

    /**
     * 设置
     * @param orderTotal
     */
    public void setOrderTotal(Double orderTotal) {
        this.orderTotal = orderTotal;
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
     * @return orderState
     */
    public Integer getOrderState() {
        return orderState;
    }

    /**
     * 设置
     * @param orderState
     */
    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    /**
     * 获取
     * @return business
     */
    public Business getBusiness() {
        return business;
    }

    /**
     * 设置
     * @param business
     */
    public void setBusiness(Business business) {
        this.business = business;
    }

    /**
     * 获取
     * @return list
     */
    public List<OrderDetailet> getList() {
        return list;
    }

    /**
     * 设置
     * @param list
     */
    public void setList(List<OrderDetailet> list) {
        this.list = list;
    }

    public String toString() {
        return "Orders{orderId = " + orderId + ", userId = " + userId + ", businessId = " + businessId + ", orderDate = " + orderDate + ", orderTotal = " + orderTotal + ", daId = " + daId + ", orderState = " + orderState + ", business = " + business + ", list = " + list + "}";
    }

}
