package com.company.template.service;

import com.company.template.repository.domain.TbDept;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface DeptService {

    PageInfo list(Integer page, Integer size, TbDept tbDept);

    Integer add(TbDept tbDept);

    Integer deleles(Integer[] ids);
}
