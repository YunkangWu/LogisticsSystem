package cdu.logistics.bean;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @description 专线信息实体类
 */
@Entity
@Table(name = "linesSupply")
@SuppressWarnings("serial")
public class LinesSupply {

    //主键ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //起始地
    @Column(name = "start")
    private String lineStart;

    //目的地
    @Column(name = "end")
    private String lineEnd;

    //信息归属
    @ManyToOne
    @JoinColumn(name = "belong")
    private User lineBelong;

    //发布时间
    @Column(name = "createTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    //运价
    @Column(name = "price")
    private String linePrice;

    //发车频率
    @Column(name = "frequency")
    private String lineFrequency;

    //运输时效
    @Column(name = "transportTime")
    private String lineTransportTime;

    //信息状态
    @Column(name = "line_check")
    private Integer lineCheck;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLineStart() {
        return lineStart;
    }

    public void setLineStart(String lineStart) {
        this.lineStart = lineStart;
    }

    public String getLineEnd() {
        return lineEnd;
    }

    public void setLineEnd(String lineEnd) {
        this.lineEnd = lineEnd;
    }

    public User getLineBelong() {
        return lineBelong;
    }

    public void setLineBelong(User lineBelong) {
        this.lineBelong = lineBelong;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLinePrice() {
        return linePrice;
    }

    public void setLinePrice(String linePrice) {
        this.linePrice = linePrice;
    }

    public String getLineFrequency() {
        return lineFrequency;
    }

    public void setLineFrequency(String lineFrequency) {
        this.lineFrequency = lineFrequency;
    }

    public String getLineTransportTime() {
        return lineTransportTime;
    }

    public void setLineTransportTime(String lineTransportTime) {
        this.lineTransportTime = lineTransportTime;
    }

    public Integer getLineCheck() {
        return lineCheck;
    }

    public void setLineCheck(Integer lineCheck) {
        this.lineCheck = lineCheck;
    }
}
