package com.company.template.common.util;

import com.company.template.common.entity.ITree;

import java.util.ArrayList;
import java.util.List;

public class TreeUtil {
    public static <T extends ITree> List<T> getTree(List<T> list) {
        List<T> resultList = null;
        if (list != null && !list.isEmpty()) {
            resultList = new ArrayList<>();
            for (T item : list) {
                if (item.getTreeParentValue() == null) {
                    resultList.add(item);
                    setChild(list, item);
                }
            }
        }
        return resultList;
    }

    private static <T extends ITree> void setChild(List<T> list, T parentItem) {
        for (T item : list) {
            if (parentItem.getTreeValue() == item.getTreeParentValue()) {
                parentItem.addChild(item);
                setChild(list, item);
            }
        }
    }
}
