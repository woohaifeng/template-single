package com.company.template.controller;

import com.company.template.common.dto.ResponseDTO;
import com.company.template.repository.domain.TbMenu;
import com.company.template.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/home")
public class HomeController {

    @Autowired
    private MenuService menuService;

    @PostMapping(value = "/init")
    public ResponseDTO init() {
        Map<String,Object> resultMap = new HashMap<>();
        List<TbMenu> menus = menuService.getMenus();
        resultMap.put("menus",menus);
        return ResponseDTO.successWithD(resultMap);
    }
}
