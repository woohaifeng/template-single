package com.company.template.repository.domain;

import com.company.template.common.entity.ITree;

import java.util.ArrayList;
import java.util.List;

public abstract class TbMenuExtend implements ITree<TbMenuExtend> {
    public List<TbMenuExtend> childMenus;

    public List<TbMenuExtend> getChildMenus() {
        return childMenus;
    }

    public void setChildMenus(List<TbMenuExtend> childMenus) {
        this.childMenus = childMenus;
    }

    @Override
    public void addChild(TbMenuExtend child) {
        if(childMenus == null) {
            childMenus = new ArrayList<>();
        }
        childMenus.add(child);
    }
}
