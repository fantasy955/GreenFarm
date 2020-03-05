package edu.cn.green_farm.entity;

public class OrderItem extends BaseEntity {
    private Integer id;
    private Integer oid;
    private Long ono;
    private Integer goodsId;
    private Integer goodsCount;
    private Double goodsPrice;
    private String goodsTitle;
    private String goodsImage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle;
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
    }

    public Long getOno() {
        return ono;
    }

    public void setOno(Long ono) {
        this.ono = ono;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", oid=" + oid +
                ", ono=" + ono +
                ", goodsId=" + goodsId +
                ", goodsCount=" + goodsCount +
                ", goodsPrice=" + goodsPrice +
                ", goodsTitle='" + goodsTitle + '\'' +
                ", goodsImage='" + goodsImage + '\'' +
                '}';
    }
}
