package com.company.template.repository.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_menu")
public class TbMenu extends TbMenuExtend{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer pid;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 路由
     */
    private String url;

    /**
     * 目录:0、菜单：1
     */
    private Integer type;

    /**
     * 顺序
     */
    private Integer ord;

    private String icon;

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
     * 获取菜单名称
     *
     * @return name - 菜单名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置菜单名称
     *
     * @param name 菜单名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取路由
     *
     * @return url - 路由
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置路由
     *
     * @param url 路由
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取目录:0、菜单：1
     *
     * @return type - 目录:0、菜单：1
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置目录:0、菜单：1
     *
     * @param type 目录:0、菜单：1
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取顺序
     *
     * @return ord - 顺序
     */
    public Integer getOrd() {
        return ord;
    }

    /**
     * 设置顺序
     *
     * @param ord 顺序
     */
    public void setOrd(Integer ord) {
        this.ord = ord;
    }

    /**
     * @return icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
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

    @Override
    public Integer getTreeValue() {
        return this.id;
    }

    @Override
    public Integer getTreeParentValue() {
        return this.pid;
    }
}