package cdu.logistics.bean;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @description 招聘信息实体类
 */
@Entity
@Table(name = "jobsSupply")
@SuppressWarnings("serial")
public class JobsSupply {

    //主键ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //职位名称
    @Column(name = "jobTitle")
    private String jobTitle;

    //公司名称
    @Column(name = "companyName")
    private String companyName;

    //月薪
    @Column(name = "salary")
    private String salary;

    //工作地点
    @Column(name = "city")
    private String city;

    //发布时间
    @Column(name = "createTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    //信息归属
    @ManyToOne
    @JoinColumn(name = "belong")
    private User jobBelong;

    //信息状态
    @Column(name = "job_check")
    private Integer jobCheck;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public User getJobBelong() {
        return jobBelong;
    }

    public void setJobBelong(User jobBelong) {
        this.jobBelong = jobBelong;
    }

    public Integer getJobCheck() {
        return jobCheck;
    }

    public void setJobCheck(Integer jobCheck) {
        this.jobCheck = jobCheck;
    }
}
