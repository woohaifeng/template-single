package com.company.template.service.impl;

import com.company.template.common.util.SQLUtil;
import com.company.template.repository.domain.TbDept;
import com.company.template.repository.mapper.TbDeptMapper;
import com.company.template.service.DeptService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private TbDeptMapper tbDeptMapper;

    @Override
    public PageInfo list(Integer page,Integer size,TbDept tbDept) {
        Example example = new Example(TbDept.class);
        Example.Criteria criteria = example.createCriteria();
        String s_name = SQLUtil.like(tbDept.getName());
        if(StringUtils.isNotBlank(s_name)) {
            criteria.andLike("name",s_name);
        }
        PageHelper.startPage(page,size);
        List<TbDept> depts = tbDeptMapper.selectByExample(example);
        PageInfo<TbDept> pageInfo = new PageInfo<>(depts);
        return pageInfo;
    }
}
