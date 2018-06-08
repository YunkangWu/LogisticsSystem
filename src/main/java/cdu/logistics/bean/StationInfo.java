package cdu.logistics.bean;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @description 站内公告
 */
@Entity
@Table(name = "stationInfo")
@SuppressWarnings("serial")
public class StationInfo {

    //主键ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //站内信息标题
    @Column(name = "info_title")
    private String infoTitle;

    //站内信息正文
    @Column(name = "info_content")
    private String infoContent;

    //站内信息时间
    @Column(name = "info_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date infoTime;

    //站内信息来源
    @Column(name = "info_from")
    private String infoFrom;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInfoTitle() {
        return infoTitle;
    }

    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle;
    }

    public String getInfoContent() {
        return infoContent;
    }

    public void setInfoContent(String infoContent) {
        this.infoContent = infoContent;
    }

    public Date getInfoTime() {
        return infoTime;
    }

    public void setInfoTime(Date infoTime) {
        this.infoTime = infoTime;
    }

    public String getInfoFrom() {
        return infoFrom;
    }

    public void setInfoFrom(String infoFrom) {
        this.infoFrom = infoFrom;
    }
}
