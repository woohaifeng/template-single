package com.company.template.service.impl;

import com.company.template.common.util.PageUtil;
import com.company.template.common.util.SQLUtil;
import com.company.template.repository.domain.TbTemplate;
import com.company.template.repository.mapper.TbTemplateMapper;
import com.company.template.service.TemplateService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateService {
    @Autowired
    private TbTemplateMapper tbTemplateMapper;

    /**
     * 按条件查询
     *
     * @param page
     * @param size
     * @param tbTemplate
     * @return
     */
    @Override
    public PageInfo list(Integer page, Integer size, TbTemplate tbTemplate) {
        Example example = new Example(TbTemplate.class);
        Example.Criteria criteria = example.createCriteria();
        String s_name = SQLUtil.like(tbTemplate.getName());
        if (StringUtils.isNotBlank(s_name)) {
            criteria.andLike("name", s_name);
        }
        PageHelper.startPage(page, size);
        List<TbTemplate> templates = tbTemplateMapper.selectByExample(example);
        PageInfo<TbTemplate> pageInfo = new PageInfo<>(templates);
        if (PageUtil.pageIsEmpty(pageInfo)) {
            page = PageUtil.lastPage(pageInfo);
            PageHelper.startPage(page, size);
            templates = tbTemplateMapper.selectByExample(example);
            pageInfo = new PageInfo<>(templates);
        }
        return pageInfo;
    }

    /**
     * @param tbTemplate
     * @return 影响的条数，如果小于0表示失败
     */
    @Override
    @Transactional(readOnly = false)
    public Integer add(TbTemplate tbTemplate) {
        //影响的条数
        Integer count = -1;
        count = tbTemplateMapper.insert(tbTemplate);
        return count;
    }

    @Override
    @Transactional(readOnly = false)
    public Integer deleles(Integer[] ids) {
        Integer count = -1;
        String idsJoin = null;
        if (ids != null && ids.length > 0) {
            idsJoin = StringUtils.join(ids, ",");
            count = tbTemplateMapper.deleteByIds(idsJoin);
        }
        return count;
    }

    @Override
    public TbTemplate get(Integer id) {
        TbTemplate tbTemplate = new TbTemplate();
        tbTemplate.setId(id);
        return tbTemplateMapper.selectByPrimaryKey(tbTemplate);
    }

    @Override
    @Transactional(readOnly = false)
    public Integer save(TbTemplate tbTemplate) {
        Integer count = -1;
        count = tbTemplateMapper.updateByPrimaryKey(tbTemplate);
        return count;
    }
}
