package cdu.logistics.bean;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @description 货源信息
 */
@Entity
@Table(name = "goodsSupply")
@SuppressWarnings("serial")
public class GoodsSupply {

    //主键ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //起始地
    @Column(name = "start")
    private String goodsStart;

    //目的地
    @Column(name = "end")
    private String goodsEnd;

    //货量
    @Column(name = "quantity")
    private String goodsQuantity;

    //信息状态：0：待交易 1：交易完成
    @Column(name = "status")
    private Integer goodsStatus;

    //配货时间
    @Column(name = "time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date goodsTime;

    //发布时间
    @Column(name = "createTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    //信息归属
    @ManyToOne
    @JoinColumn(name = "belong")
    private User goodsBelong;

    //货物名称
    @Column(name = "goodsName")
    private String goodsName;

    //期望运价
    @Column(name = "price")
    private String goodsPrice;

    //期望车型
    @Column(name = "carType")
    private Integer goodsCarType;

    //信息状态
    @Column(name = "goods_check")
    private Integer goodCheck;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsStart() {
        return goodsStart;
    }

    public void setGoodsStart(String goodsStart) {
        this.goodsStart = goodsStart;
    }

    public String getGoodsEnd() {
        return goodsEnd;
    }

    public void setGoodsEnd(String goodsEnd) {
        this.goodsEnd = goodsEnd;
    }

    public String getGoodsQuantity() {
        return goodsQuantity;
    }

    public void setGoodsQuantity(String goodsQuantity) {
        this.goodsQuantity = goodsQuantity;
    }

    public Integer getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(Integer goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public Date getGoodsTime() {
        return goodsTime;
    }

    public void setGoodsTime(Date goodsTime) {
        this.goodsTime = goodsTime;
    }

    public User getGoodsBelong() {
        return goodsBelong;
    }

    public void setGoodsBelong(User goodsBelong) {
        this.goodsBelong = goodsBelong;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getGoodsCarType() {
        return goodsCarType;
    }

    public void setGoodsCarType(Integer goodsCarType) {
        this.goodsCarType = goodsCarType;
    }

    public Integer getGoodCheck() {
        return goodCheck;
    }

    public void setGoodCheck(Integer goodCheck) {
        this.goodCheck = goodCheck;
    }
}
