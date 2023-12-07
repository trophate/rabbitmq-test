package com.trophate.rabbitmqtest.deal;

public class Order {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    private Integer productId;

    /**
     * 商品名
     */
    private String productName;

    /**
     * 数量
     */
    private Integer num;

    /**
     * 单价
     */
    private Double price;

    /**
     * 总价
     */
    private Double totalPrice;

    /**
     * 购买人id
     */
    private Integer buyerId;

    /**
     * 购买人姓名
     */
    private String buyerName;

    public Integer getProductId() {
        return productId;
    }

    public Order setProductId(Integer productId) {
        this.productId = productId;
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public Order setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public Integer getNum() {
        return num;
    }

    public Order setNum(Integer num) {
        this.num = num;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Order setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public Order setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public Order setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
        return this;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public Order setBuyerName(String buyerName) {
        this.buyerName = buyerName;
        return this;
    }

    public static Order build() {
        return new Order()
                .setProductId(231)
                .setProductName("可口糖果(1袋装)")
                .setNum(5)
                .setPrice(7.3)
                .setTotalPrice(36.5)
                .setBuyerId(1).setBuyerName("琳枭");
    }
}
