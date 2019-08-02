package com.company.template.service;

import com.company.template.repository.domain.TbUser;

/**
 * 用户的登陆、认证
 */
public interface OuthService {

    public TbUser login(String loginCode, String plainPassword);

}
