package com.company.template.service.impl;

import com.company.template.common.entity.ITree;
import com.company.template.common.util.TreeUtil;
import com.company.template.repository.domain.TbDept;
import com.company.template.repository.domain.TbMenu;
import com.company.template.repository.mapper.TbMenuMapper;
import com.company.template.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private TbMenuMapper tbMenuMapper;

    @Override
    public List<TbMenu> getMenus() {
        Example example = new Example(TbMenu.class);
        example.orderBy("ord");
        List<TbMenu> menus = tbMenuMapper.selectByExample(example);
        ITree tree = new TbMenu();
        //按照父子关系遍历
        return TreeUtil.getTree(menus);
    }

//    private static List<TbMenu> getTree(List<TbMenu> menus) {
//        List<TbMenu> trees = null;
//        if (menus != null && !menus.isEmpty()) {
//            trees = new ArrayList<>();
//            for (TbMenu tbMenu : menus) {
//                if (tbMenu.getPid() == null) {
//                    trees.add(tbMenu);
//                    if (tbMenu.getType() == 0) {
//                        setChild(menus, tbMenu);
//                    }
//                }
//            }
//        }
//        return trees;
//    }
//
//    private static void setChild(List<TbMenu> menus, TbMenu parent) {
//        for (TbMenu tbMenu : menus) {
//            if (parent.getId() == tbMenu.getPid()) {
//                parent.addChild(tbMenu);
//                if (tbMenu.getType() == 0) {
//                    setChild(menus, tbMenu);
//                }
//            }
//        }
//    }
}
