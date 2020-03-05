package edu.cn.green_farm.entity;

public class CartItem extends BaseEntity {
    private Integer id;
    private Integer uid;
    private Integer pid;
    private String title;
    private Double price;
    private String pImage;
    private Integer count;

    public CartItem() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getpImage() {
        return pImage;
    }

    public void setpImage(String pImage) {
        this.pImage = pImage;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", uid=" + uid +
                ", pid=" + pid +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", pImage='" + pImage + '\'' +
                ", count=" + count +
                '}';
    }
}
