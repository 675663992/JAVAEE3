package BS.model;

public class Cart {
    private Integer cartId;
    private Integer foodId;
    private Integer businessId;
    private String userId;
    private Integer quantity;

    private Food food;
    private Business business;

    public Cart() {
    }

    public Cart(Integer cartId, Integer foodId, Integer businessId, String userId, Integer quantity, Food food, Business business) {
        this.cartId = cartId;
        this.foodId = foodId;
        this.businessId = businessId;
        this.userId = userId;
        this.quantity = quantity;
        this.food = food;
        this.business = business;
    }

    // 全参构造函数
    public Cart(Integer cartId, Integer foodId, Integer businessId, String userId, Integer quantity) {
        this.cartId = cartId;
        this.foodId = foodId;
        this.businessId = businessId;
        this.userId = userId;
        this.quantity = quantity;
    }

    /**
     * 获取
     * @return cartId
     */
    public Integer getCartId() {
        return cartId;
    }

    /**
     * 设置
     * @param cartId
     */
    public void setCartId(Integer cartId) {
        this.cartId = cartId;
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

    public String toString() {
        return "Cart{cartId = " + cartId + ", foodId = " + foodId + ", businessId = " + businessId + ", userId = " + userId + ", quantity = " + quantity + ", food = " + food + ", business = " + business + "}";
    }
}
