package com.company.template.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.List;

@Data
public class ResponseDTO<T> implements Serializable {
    private static final Integer SUCCESS = 200;
    private static final Integer UNAUTHORIZED = 401;
    private static final Integer FAIL = 500;


    private Integer status = null;
    private String msg = null;
    private T data = null;
    private List<String> errors = null;
    private Cursor cursor = null;

    public static ResponseDTO success() {
        return successWithMDC(null,null,null);
    }

    public static ResponseDTO successWithM(String msg) {
        return successWithMDC(msg,null,null);
    }

    public static <T> ResponseDTO successWithD(T data) {
        return successWithMDC(null,data,null);
    }

    public static <T> ResponseDTO successWithMD(String msg,T data) {
        return successWithMDC(msg,data,null);
    }

    public static <T> ResponseDTO successWithDC(T data,Cursor cursor) {
        return successWithMDC(null,data,cursor);
    }

    public static <T> ResponseDTO successWithMDC (String msg,T data,Cursor cursor) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus(SUCCESS);
        if(StringUtils.isNotBlank(msg)) {
            responseDTO.setMsg(msg);
        }
        if(data!=null) {
            responseDTO.setData(data);
        }
        if(cursor!=null) {
            responseDTO.setCursor(cursor);
        }
        return responseDTO;
    }

    public static ResponseDTO fail() {
        return failWithME(null,null);
    }

    public static ResponseDTO failWithM(String msg) {
        return failWithME(msg,null);
    }

    public static ResponseDTO failWithME(String msg,List<String> errors) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus(FAIL);
        if(StringUtils.isNotBlank(msg)) {
            responseDTO.setMsg(msg);
        }
        if(errors!=null) {
            responseDTO.setErrors(errors);
        }
        return responseDTO;
    }

    public static ResponseDTO unauthorized() {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus(UNAUTHORIZED);
        responseDTO.setMsg("登陆失效，请重新登陆！");
        return responseDTO;
    }

    @Data
    @AllArgsConstructor
    public static class Cursor {
        private Long total = null;
        private Integer currentPage = null;
        private Integer limit = null;
        private Integer offset = null;
    }
}
