package com.company.template.service;

import com.company.template.repository.domain.TbTemplate;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface TemplateService {

    PageInfo list(Integer page, Integer size, TbTemplate tbTemplate);

    Integer add(TbTemplate tbTemplate);

    Integer deleles(Integer[] ids);

    TbTemplate get(Integer id);

    Integer save(TbTemplate tbTemplate);
}
