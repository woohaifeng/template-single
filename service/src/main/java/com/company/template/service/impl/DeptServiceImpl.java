package com.company.template.service.impl;

import com.company.template.common.util.SQLUtil;
import com.company.template.repository.domain.TbDept;
import com.company.template.repository.mapper.TbDeptMapper;
import com.company.template.repository.mapper.TbMenuMapper;
import com.company.template.service.DeptService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private TbDeptMapper tbDeptMapper;

    /**
     * 按条件查询
     *
     * @param page
     * @param size
     * @param tbDept
     * @return
     */
    @Override
    public PageInfo list(Integer page, Integer size, TbDept tbDept) {
        Example example = new Example(TbDept.class);
        Example.Criteria criteria = example.createCriteria();
        String s_name = SQLUtil.like(tbDept.getName());
        if (StringUtils.isNotBlank(s_name)) {
            criteria.andLike("name", s_name);
        }
        PageHelper.startPage(page, size);
        List<TbDept> depts = tbDeptMapper.selectByExample(example);
        PageInfo<TbDept> pageInfo = new PageInfo<>(depts);
        return pageInfo;
    }

    /**
     * @param tbDept
     * @return 影响的条数，如果小于0表示失败
     */
    @Override
    @Transactional(readOnly = false)
    public Integer add(TbDept tbDept) {
        //影响的条数
        Integer count = -1;
        count = tbDeptMapper.insert(tbDept);
        return count;
    }

    @Override
    @Transactional(readOnly = false)
    public Integer deleles(Integer[] ids) {
        Integer count = -1;
        String idsJoin = null;
        if (ids != null && ids.length > 0) {
            idsJoin = StringUtils.join(ids, ",");
            count = tbDeptMapper.deleteByIds(idsJoin);
        }
        return count;
    }


}
