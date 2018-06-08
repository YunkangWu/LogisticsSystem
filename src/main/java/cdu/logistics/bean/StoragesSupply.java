package cdu.logistics.bean;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @description 仓储信息实体类
 */
@Entity
@Table(name = "storagesSupply")
@SuppressWarnings("serial")
public class StoragesSupply {

    //主键ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //城市
    @Column(name = "city")
    private String storagesCity;

    //详细地址
    @Column(name = "location")
    private String storagesLocation;

    //仓储容量
    @Column(name = "capacity")
    private String capacity;

    //信息归属
    @ManyToOne
    @JoinColumn(name = "belong")
    private User storageBelong;

    //发布时间
    @Column(name = "createTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    //仓储类型 普通仓储，冷藏仓储，恒温仓储
    @Column(name = "storageType")
    private Integer storageType;

    //仓储报价
    @Column(name = "price")
    private String storagePrice;

    //信息状态
    @Column(name = "storage_check")
    private Integer storageCheck;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStoragesCity() {
        return storagesCity;
    }

    public void setStoragesCity(String storagesCity) {
        this.storagesCity = storagesCity;
    }

    public String getStoragesLocation() {
        return storagesLocation;
    }

    public void setStoragesLocation(String storagesLocation) {
        this.storagesLocation = storagesLocation;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public User getStorageBelong() {
        return storageBelong;
    }

    public void setStorageBelong(User storageBelong) {
        this.storageBelong = storageBelong;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStorageType() {
        return storageType;
    }

    public void setStorageType(Integer storageType) {
        this.storageType = storageType;
    }

    public String getStoragePrice() {
        return storagePrice;
    }

    public void setStoragePrice(String storagePrice) {
        this.storagePrice = storagePrice;
    }

    public Integer getStorageCheck() {
        return storageCheck;
    }

    public void setStorageCheck(Integer storageCheck) {
        this.storageCheck = storageCheck;
    }
}
