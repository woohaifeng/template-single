package com.company.template.service;

import com.company.template.repository.domain.TbMenu;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional(readOnly = true)
public interface MenuService {
    public List<TbMenu> getMenus();
}
