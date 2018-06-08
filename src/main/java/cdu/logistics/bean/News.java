package cdu.logistics.bean;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @description 新闻实体类
 */
@Entity
@Table(name = "News")
@SuppressWarnings("serial")
public class News {

    //主键ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //新闻标题
    @Column(name = "news_title")
    private String newsTitle;

    //新闻正文
    @Column(name = "news_content")
    private String newsContent;

    //新闻来源
    @Column(name = "news_from")
    private String newsFrom;

    //发布新闻时间
    @Column(name = "news_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date newsTime;

    //新闻所属类型
    @Column(name = "news_type")
    private String newsType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public String getNewsFrom() {
        return newsFrom;
    }

    public void setNewsFrom(String newsFrom) {
        this.newsFrom = newsFrom;
    }

    public Date getNewsTime() {
        return newsTime;
    }

    public void setNewsTime(Date newsTime) {
        this.newsTime = newsTime;
    }

    public String getNewsType() {
        return newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }
}
