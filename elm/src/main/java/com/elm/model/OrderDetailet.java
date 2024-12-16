package com.elm.model;

public class OrderDetailet {
    private Integer odId;
    private Integer orderId;
    private Integer foodId;
    private Integer quantity;
    private Food food;

    public OrderDetailet() {
    }

    public OrderDetailet(Integer odId, Integer orderId, Integer foodId, Integer quantity, Food food) {
        this.odId = odId;
        this.orderId = orderId;
        this.foodId = foodId;
        this.quantity = quantity;
        this.food = food;
    }

    public OrderDetailet(int orderId, int foodId, int quantity) {
        this.orderId = orderId;
        this.foodId = foodId;
        this.quantity = quantity;
    }

    /**
     * 获取
     * @return odId
     */
    public Integer getOdId() {
        return odId;
    }

    /**
     * 设置
     * @param odId
     */
    public void setOdId(Integer odId) {
        this.odId = odId;
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
     * @return foodId
     */
    public Integer getFoodId() {
        return foodId;
    }

    /**
     * 设置
     * @param foodId
     */
    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    /**
     * 获取
     * @return quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * 设置
     * @param quantity
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * 获取
     * @return food
     */
    public Food getFood() {
        return food;
    }

    /**
     * 设置
     * @param food
     */
    public void setFood(Food food) {
        this.food = food;
    }

    public String toString() {
        return "OrderDetailet{odId = " + odId + ", orderId = " + orderId + ", foodId = " + foodId + ", quantity = " + quantity + ", food = " + food + "}";
    }
}
