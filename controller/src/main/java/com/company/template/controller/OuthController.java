package com.company.template.controller;

import com.company.template.common.dto.ResponseDTO;
import com.company.template.common.entity.LoginUser;
import com.company.template.common.util.JWTUtil;
import com.company.template.repository.domain.TbUser;
import com.company.template.service.OuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/outh")
public class OuthController {
    @Autowired
    private OuthService outhService;

    @GetMapping(value = "/noOuth")
    public String noOuth() {
        return "noOuth";
    }

    @PostMapping(value = "/login")
    public ResponseDTO loign(@RequestBody LoginUser loginUser) {
        TbUser tbUser = outhService.login(loginUser);
        if(tbUser!=null) {
            Map<String,Object> claims = new HashMap<>();
            claims.put("loginCode",tbUser.getLoginCode());
            return ResponseDTO.successWithD(JWTUtil.generateToken(claims));
        } else {
            return ResponseDTO.failWithM("账号或密码不存在！");
        }
    }
}
