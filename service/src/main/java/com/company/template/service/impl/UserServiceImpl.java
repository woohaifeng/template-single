package com.company.template.service.impl;

import com.company.template.repository.domain.TbUser;
import com.company.template.repository.mapper.TbUserMapper;
import com.company.template.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TbUserMapper tbUserMapper;

    @Override
    public TbUser findUserByName(String name) {
        TbUser tbUser = new TbUser();
        tbUser.setId(1);
        tbUser.setName("Andy");
        tbUser.setLoginCode("andy");
        return tbUser;
    }
}
