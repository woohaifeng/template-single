package com.company.template.common.entity;

/**
 * 具有父子级关系的类接口
 * @param <T>
 */
public interface ITree<T> {
    Integer getTreeValue();
    Integer getTreeParentValue();
    void addChild(T child);
}
