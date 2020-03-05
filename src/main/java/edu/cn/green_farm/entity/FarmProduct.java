package edu.cn.green_farm.entity;

import java.util.HashMap;

/**
 * 农产品
 */
public class FarmProduct extends BaseEntity {
    private static final int STATUS_ONOFFER = 1;
    private static final int STATUS_OUT = 0;//下架
    private final static int PRODUCT_STATUS_AUDITFAILURE = 2;//审核未通过
    private static final int STATUS_WAITTINGCHECK = 3;
    private final static int PRODUCT_STATUS_MOVINGIMAGES_ERROR = 5;
    private final static int PRODUCT_STATUS_DELETE_BY_BUSINESS = -1; //商户删除
    private static HashMap<Integer, String> statusMap;

    static {
        statusMap = new HashMap<Integer, String>();
        statusMap.put(STATUS_ONOFFER, "在售");
        statusMap.put(STATUS_OUT, "下架");
        statusMap.put(STATUS_WAITTINGCHECK, "待审核");
        statusMap.put(PRODUCT_STATUS_MOVINGIMAGES_ERROR, "上架失败");
        statusMap.put(PRODUCT_STATUS_AUDITFAILURE, "未通过审核");
    }

    private String strTimeUpdate;

    /**
     * 农产品id
     */
    private Integer id;
    /**
     * 发布该农产平的商户id
     */
    private Integer bid;
    /**
     * 农产品类型
     */
    private Integer itemType;
    /**
     * 农产品名称
     */
    private String title;
    /**
     * 农产平广告
     */
    private String sellPoint;
    /**
     * 产品价格
     */
    private Double price;
    /**
     * 产品剩余数量
     */
    private Integer num;
    /**
     * 产品照片路径
     */
    private String image;
    /**
     * 产品状态：0下架，1在售
     */
    private Integer status;
    private String statusName;
    /**
     * 产品推荐优先级
     */
    private Integer priority;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getItemType() {
        return itemType;
    }

    public void setItemType(Integer itemType) {
        this.itemType = itemType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        statusName = statusMap.get(status);
        this.status = status;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "FarmProduct{" +
                "id=" + id +
                ", bid=" + bid +
                ", itemType=" + itemType +
                ", title='" + title + '\'' +
                ", sellPoint='" + sellPoint + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", image='" + image + '\'' +
                ", status=" + status +
                ", priority=" + priority +
                '}';
    }

    public String getStatusName() {
        return statusName;
    }

    public String getStrTimeUpdate() {
        return strTimeUpdate;
    }

    public void setStrTimeUpdate(String strTimeUpdate) {
        this.strTimeUpdate = strTimeUpdate;
    }
}
