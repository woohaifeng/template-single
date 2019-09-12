package com.company.template.service.impl;

import com.company.template.common.entity.LoginUser;
import com.company.template.repository.domain.TbUser;
import com.company.template.repository.mapper.TbUserMapper;
import com.company.template.service.OuthService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import tk.mybatis.mapper.entity.Example;

@Service
public class OuthServiceImpl implements OuthService {
    @Autowired
    private TbUserMapper tbUserMapper;

    /**
     * 登陆
     *
     * @param loginUser
     * @return 成功：tbUser，失败：null
     */
    @Override
    public TbUser login(LoginUser loginUser) {
        //登陆名
        String loginCode = null;
        if (loginUser != null) {
            loginCode = loginUser.getLoginCode();
        }
        if (StringUtils.isNotBlank(loginCode)) {
            Example example = new Example(TbUser.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("loginCode", loginCode);
            TbUser tbUser = tbUserMapper.selectOneByExample(example);
            if (tbUser != null) {
                //比对密码
                String plainPassword = loginUser.getPlainPassword();
                if (StringUtils.isNotBlank(plainPassword)) {
                    //在这里做加密
                    String password = DigestUtils.md5DigestAsHex(plainPassword.getBytes());
                    if (password.equals(tbUser.getPassword())) {
                        return tbUser;
                    }
                }
            }
        }
        return null;
    }

}
