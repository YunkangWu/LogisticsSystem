package cdu.logistics.bean;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @description 用户实体类
 */
@Entity
@Table(name = "user")
@SuppressWarnings("serial")
public class User implements Serializable {

    //主键ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //用户登录名
    @Column(name = "user_username")
    private String userName;

    //密码
    @Column(name = "user_password")
    private String password;

    //用户类型：1，个人 2，企业
    @Column(name = "user_type")
    private Integer userType;

    //地址
    @Column(name = "user_location")
    private String location;

    //电话
    @Column(name = "user_tellphone")
    private String tellphone;

    //邮箱
    @Column(name = "user_email")
    private String email;

    //是否有效
    @Column(name = "user_check")
    private Integer userCheck;

    //企业名称
    @Column(name = "company_name")
    private String companyName;

    //法人代表
    @Column(name = "company_belong")
    private String companyBelong;

    //企业类型
    @Column(name = "company_type")
    private Integer companyType;

    //所属行业
    @Column(name = "company_industry")
    private Integer companyIndustry;

    //用户设置的找回密码的问题
    @Column(name = "user_question")
    private String userQuestion;

    //问题答案
    @Column(name = "user_key")
    private String userKey;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTellphone() {
        return tellphone;
    }

    public void setTellphone(String tellphone) {
        this.tellphone = tellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;

    }

    public Integer getUserCheck() {
        return userCheck;
    }

    public void setUserCheck(Integer userCheck) {
        this.userCheck = userCheck;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyBelong() {
        return companyBelong;
    }

    public void setCompanyBelong(String companyBelong) {
        this.companyBelong = companyBelong;
    }

    public Integer getCompanyType() {
        return companyType;
    }

    public void setCompanyType(Integer companyType) {
        this.companyType = companyType;
    }

    public Integer getCompanyIndustry() {
        return companyIndustry;
    }

    public void setCompanyIndustry(Integer companyIndustry) {
        this.companyIndustry = companyIndustry;
    }

    public String getUserQuestion() {
        return userQuestion;
    }

    public void setUserQuestion(String userQuestion) {
        this.userQuestion = userQuestion;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }
}
