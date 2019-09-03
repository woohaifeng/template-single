package com.company.template.repository.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_dept")
public class TbDept {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer pid;

    private String name;

    private String des;

    private Integer cp;

    private Date ct;

    private Integer up;

    private Date ut;

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
     * @return pid
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * @param pid
     */
    public void setPid(Integer pid) {
        this.pid = pid;
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
     * @return cp
     */
    public Integer getCp() {
        return cp;
    }

    /**
     * @param cp
     */
    public void setCp(Integer cp) {
        this.cp = cp;
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

    /**
     * @return up
     */
    public Integer getUp() {
        return up;
    }

    /**
     * @param up
     */
    public void setUp(Integer up) {
        this.up = up;
    }

    /**
     * @return ut
     */
    public Date getUt() {
        return ut;
    }

    /**
     * @param ut
     */
    public void setUt(Date ut) {
        this.ut = ut;
    }
}