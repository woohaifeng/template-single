package com.company.template.service.impl;

import com.company.template.repository.domain.TbUser;
import com.company.template.repository.mapper.TbUserMapper;
import com.company.template.service.OuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
public class OuthServiceImpl implements OuthService {
    @Autowired
    private TbUserMapper tbUserMapper;

    @Override
    public TbUser login(String loginCode, String plainPassword) {
        Example example = new Example(TbUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("loginCode",loginCode);

        return null;
    }

}
