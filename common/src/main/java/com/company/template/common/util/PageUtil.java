package com.company.template.common.util;

import com.github.pagehelper.PageInfo;

public class PageUtil {
    /**
     * @param pageInfo
     * @return 当前页没有数据，且不是第一页，且查询的部分超出了总条数的范围
     */
    public static Boolean pageIsEmpty(PageInfo pageInfo) {
        if (pageInfo != null) {
            return pageInfo.getSize() == 0 && pageInfo.getPageNum() > 1 && (pageInfo.getPageNum() - 1) * pageInfo.getPageSize() >= pageInfo.getTotal();
        } else {
            return false;
        }
    }

    /**
     * @param pageInfo
     * @return 返回可以查询到的最后一页
     */
    public static Integer lastPage(PageInfo pageInfo) {
        if (pageInfo != null) {
            return Integer.valueOf(Long.valueOf((pageInfo.getTotal() - 1) / pageInfo.getPageSize() + 1).intValue());
        } else {
            return 1;
        }
    }
}
