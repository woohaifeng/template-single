package com.company.template.service;

import com.company.template.repository.domain.TbUser;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface UserService {
    public TbUser findUserByName (String name);
}
