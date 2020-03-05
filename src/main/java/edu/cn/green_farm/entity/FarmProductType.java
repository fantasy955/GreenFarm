package edu.cn.green_farm.entity;

public class FarmProductType extends BaseEntity {
    Integer id;
    String typeName;

    @Override
    public String toString() {
        return "FarmProductType{" +
                "id=" + id +
                ", tpyeName='" + typeName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String tpyeName) {
        this.typeName = tpyeName;
    }
}
