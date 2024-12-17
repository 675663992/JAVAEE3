package BS.model;

import lombok.Data;

@Data
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
}
