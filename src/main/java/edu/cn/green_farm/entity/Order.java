package edu.cn.green_farm.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order extends BaseEntity {
    private Integer id;
    private Integer uid;
    private Long ono;
    private String recvName;
    private String recvPhone;
    private String recvDistrict;
    private String recvAddress;
    private Integer status;
    private Double pay;
    private Date orderTime;
    private List<OrderItem> orderItems = new ArrayList<OrderItem>();

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

    public Long getOno() {
        return ono;
    }

    public void setOno(Long ono) {
        this.ono = ono;
    }

    public String getRecvName() {
        return recvName;
    }

    public void setRecvName(String recvName) {
        this.recvName = recvName;
    }

    public String getRecvPhone() {
        return recvPhone;
    }

    public void setRecvPhone(String recvPhone) {
        this.recvPhone = recvPhone;
    }

    public String getRecvDistrict() {
        return recvDistrict;
    }

    public void setRecvDistrict(String recvDistrict) {
        this.recvDistrict = recvDistrict;
    }

    public String getRecvAddress() {
        return recvAddress;
    }

    public void setRecvAddress(String recvAddress) {
        this.recvAddress = recvAddress;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getPay() {
        return pay;
    }

    public void setPay(Double pay) {
        this.pay = pay;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", uid=" + uid +
                ", ono=" + ono +
                ", recvName='" + recvName + '\'' +
                ", recvPhone='" + recvPhone + '\'' +
                ", recvDistrict='" + recvDistrict + '\'' +
                ", recvAddress='" + recvAddress + '\'' +
                ", status=" + status +
                ", pay=" + pay +
                ", orderTime=" + orderTime +
                ", orderItems=" + orderItems +
                '}';
    }
}
