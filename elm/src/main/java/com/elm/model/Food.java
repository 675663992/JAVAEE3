package com.elm.model;

public class Food {
    private Integer foodId;
    private String foodName;
    private String foodExplain;
    private String foodImg;
    private Double foodPrice;
    private Integer businessId;
    private String remarks;

    public Food() {
    }

    public Food(Integer foodId, String foodName, String foodExplain, String foodImg, Double foodPrice, Integer businessId, String remarks) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodExplain = foodExplain;
        this.foodImg = foodImg;
        this.foodPrice = foodPrice;
        this.businessId = businessId;
        this.remarks = remarks;
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
     * @return foodName
     */
    public String getFoodName() {
        return foodName;
    }

    /**
     * 设置
     * @param foodName
     */
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    /**
     * 获取
     * @return foodExplain
     */
    public String getFoodExplain() {
        return foodExplain;
    }

    /**
     * 设置
     * @param foodExplain
     */
    public void setFoodExplain(String foodExplain) {
        this.foodExplain = foodExplain;
    }

    /**
     * 获取
     * @return foodImg
     */
    public String getFoodImg() {
        return foodImg;
    }

    /**
     * 设置
     * @param foodImg
     */
    public void setFoodImg(String foodImg) {
        this.foodImg = foodImg;
    }

    /**
     * 获取
     * @return foodPrice
     */
    public Double getFoodPrice() {
        return foodPrice;
    }

    /**
     * 设置
     * @param foodPrice
     */
    public void setFoodPrice(Double foodPrice) {
        this.foodPrice = foodPrice;
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
        return "Food{foodId = " + foodId + ", foodName = " + foodName + ", foodExplain = " + foodExplain + ", foodImg = " + foodImg + ", foodPrice = " + foodPrice + ", businessId = " + businessId + ", remarks = " + remarks + "}";
    }
}
