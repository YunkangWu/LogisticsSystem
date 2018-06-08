package cdu.logistics.bean;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @description 管理员账号实体类
 */
@Entity
@Table(name = "admin")
@SuppressWarnings("serial")
public class Admin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "admin")
    private String admin;

    @Column(name = "password")
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
