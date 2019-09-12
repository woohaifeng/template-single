package com.company.template.common.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginUser implements Serializable {
    private String loginCode;
    private String plainPassword;
}
