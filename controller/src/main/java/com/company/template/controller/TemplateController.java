package com.company.template.controller;

import com.company.template.common.dto.ResponseDTO;
import com.company.template.repository.domain.TbTemplate;
import com.company.template.service.TemplateService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(value = "/template")
public class TemplateController {

    @Autowired
    private TemplateService templateService;

    @GetMapping(value = "/list/{page}/{size}")
    public ResponseDTO list(@PathVariable(required = true) Integer page, @PathVariable(required = true) Integer size, TbTemplate tbTemplate) {
        PageInfo pageInfo = templateService.list(page, size, tbTemplate);
        ResponseDTO.Cursor cursor = new ResponseDTO.Cursor(pageInfo.getTotal(), pageInfo.getPageNum(), (page - 1) * size, size);
        return ResponseDTO.successWithDC(pageInfo.getList(), cursor);
    }

    @PostMapping(value = "/add")
    public ResponseDTO add(@RequestParam(value = "name")String name,@RequestParam(value = "image") MultipartFile image,@RequestParam(value = "files") List<MultipartFile> files) {
        System.out.println(name);
        System.out.println(image.getOriginalFilename());
        for (MultipartFile file : files) {
            System.out.println(file.getOriginalFilename());
        }
//        Integer count = templateService.add(tbTemplate);
        Integer count = 1;
        if (count > 0) {
            return ResponseDTO.success();
        } else {
            return ResponseDTO.fail();
        }
    }

    @DeleteMapping(value = "/deletes")
    public ResponseDTO deletes(@RequestParam(value = "ids", required = true) Integer[] ids) {
        Integer count = templateService.deleles(ids);
        if (count > 0) {
            return ResponseDTO.success();
        } else {
            return ResponseDTO.fail();
        }
    }

    @GetMapping(value = "/get")
    public ResponseDTO get(@RequestParam(value = "id", required = true) Integer id) {
        TbTemplate tbTemplate = null;
        tbTemplate = templateService.get(id);
        return ResponseDTO.successWithD(tbTemplate);
    }

    @PutMapping(value = "/save")
    public ResponseDTO save(@RequestBody TbTemplate tbTemplate) {
        Integer count = templateService.save(tbTemplate);
        if(count>0) {
            return ResponseDTO.success();
        } else {
            return ResponseDTO.fail();
        }
    }

}
