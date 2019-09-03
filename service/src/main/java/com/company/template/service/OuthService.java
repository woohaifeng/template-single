package com.company.template.service;

import com.company.template.repository.domain.TbUser;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户的登陆、认证
 */
@Transactional(readOnly = true)
public interface OuthService {

    public TbUser login(String loginCode, String plainPassword);

}
