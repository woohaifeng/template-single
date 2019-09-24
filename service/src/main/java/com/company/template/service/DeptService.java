package com.company.template.service;

import com.company.template.repository.domain.TbDept;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface DeptService {

    PageInfo list(Integer page, Integer size, TbDept tbDept);

    Integer add(TbDept tbDept);

    Integer deleles(Integer[] ids);

    TbDept get(Integer id);

    Integer save(TbDept tbDept);
}
