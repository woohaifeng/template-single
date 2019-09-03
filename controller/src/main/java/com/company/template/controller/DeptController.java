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

//    @PostMapping(value = "/list")
//    public List<TbDept> list(@RequestParam(value="page") Integer page,@RequestParam(value="size") Integer size,@RequestParam(value = "name",required = true) String name) {
//        System.out.println(name);
//        return deptService.list(page,size,name);
//    }


}
