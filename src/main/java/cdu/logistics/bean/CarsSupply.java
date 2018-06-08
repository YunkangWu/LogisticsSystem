package cdu.logistics.bean;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @description 车源信息实体类
 */
@Entity
@Table(name = "carsSupply")
@SuppressWarnings("serial")
public class CarsSupply {

    //主键ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //起始地
    @Column(name = "start")
    private String carStart;

    //目的地
    @Column(name = "end")
    private String carEnd;

    //车型
    @Column(name = "carType")
    private Integer carType;

    //车源状态 0:待交易 1：交易完成
    @Column(name = "status")
    private Integer carStatus;

    //发车日期
    @Column(name = "time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date carTime;

    //信息归属
    @ManyToOne
    @JoinColumn(name = "belong")
    private User carBelong;

    //发布时间
    @Column(name = "createTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    //载重
    @Column(name = "capacity")
    private String carCapacity;

    //运价
    @Column(name = "price")
    private String carPrice;

    //信息状态
    @Column(name = "car_check")
    private Integer carCheck;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarStart() {
        return carStart;
    }

    public void setCarStart(String carStart) {
        this.carStart = carStart;
    }

    public String getCarEnd() {
        return carEnd;
    }

    public void setCarEnd(String carEnd) {
        this.carEnd = carEnd;
    }

    public Integer getCarType() {
        return carType;
    }

    public void setCarType(Integer carType) {
        this.carType = carType;
    }

    public Integer getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(Integer carStatus) {
        this.carStatus = carStatus;
    }

    public Date getCarTime() {
        return carTime;
    }

    public void setCarTime(Date carTime) {
        this.carTime = carTime;
    }

    public User getCarBelong() {
        return carBelong;
    }

    public void setCarBelong(User carBelong) {
        this.carBelong = carBelong;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCarCapacity() {
        return carCapacity;
    }

    public void setCarCapacity(String carCapacity) {
        this.carCapacity = carCapacity;
    }

    public String getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(String carPrice) {
        this.carPrice = carPrice;
    }

    public Integer getCarCheck() {
        return carCheck;
    }

    public void setCarCheck(Integer carCheck) {
        this.carCheck = carCheck;
    }
}
