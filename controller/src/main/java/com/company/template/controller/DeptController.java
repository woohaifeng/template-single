package com.company.template.controller;

import com.company.template.common.dto.ResponseDTO;
import com.company.template.repository.domain.TbDept;
import com.company.template.service.DeptService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping(value = "/list/{page}/{size}")
    public ResponseDTO list(@PathVariable(required = true) Integer page, @PathVariable(required = true) Integer size, TbDept tbDept) {
        PageInfo pageInfo = deptService.list(page, size, tbDept);
        ResponseDTO.Cursor cursor = new ResponseDTO.Cursor(pageInfo.getTotal(),page,size);
        return ResponseDTO.successWithDC(pageInfo.getList(),cursor);
    }

    @PostMapping(value = "/add")
    public ResponseDTO add(@RequestBody TbDept tbDept) {
        Integer count = deptService.add(tbDept);
        if(count>0) {
            return ResponseDTO.success();
        } else {
            return ResponseDTO.fail();
        }
    }

    @DeleteMapping(value= "/deletes")
    public ResponseDTO deletes(@RequestParam(value = "ids",required = true) Integer[] ids) {
        Integer count = -1;
        count = deptService.deleles(ids);
        if(count>0) {
            return ResponseDTO.success();
        } else {
            return ResponseDTO.fail();
        }
    }

}
