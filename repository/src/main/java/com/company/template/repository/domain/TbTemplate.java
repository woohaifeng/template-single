package com.company.template.repository.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_template")
public class TbTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer sex;

    private Integer marry;

    private Double money;

    private Date hirdate;

    private String des;

    private Date ct;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return sex
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * @return marry
     */
    public Integer getMarry() {
        return marry;
    }

    /**
     * @param marry
     */
    public void setMarry(Integer marry) {
        this.marry = marry;
    }

    /**
     * @return money
     */
    public Double getMoney() {
        return money;
    }

    /**
     * @param money
     */
    public void setMoney(Double money) {
        this.money = money;
    }

    /**
     * @return hirdate
     */
    public Date getHirdate() {
        return hirdate;
    }

    /**
     * @param hirdate
     */
    public void setHirdate(Date hirdate) {
        this.hirdate = hirdate;
    }

    /**
     * @return des
     */
    public String getDes() {
        return des;
    }

    /**
     * @param des
     */
    public void setDes(String des) {
        this.des = des;
    }

    /**
     * @return ct
     */
    public Date getCt() {
        return ct;
    }

    /**
     * @param ct
     */
    public void setCt(Date ct) {
        this.ct = ct;
    }
}