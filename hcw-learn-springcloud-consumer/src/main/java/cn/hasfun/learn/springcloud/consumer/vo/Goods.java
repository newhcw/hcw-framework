package cn.hasfun.learn.springcloud.consumer.vo;

import java.io.Serializable;

public class Goods implements Serializable {

    private String goodsId;

    private String name;

    public Goods(String descr) {
        this.descr = descr;
    }

    private String descr;

    public Goods(String goodsId, String name, String descr) {
        this.goodsId = goodsId;
        this.name = name;
        this.descr = descr;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
}
