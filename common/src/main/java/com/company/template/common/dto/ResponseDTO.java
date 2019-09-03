package com.company.template.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.List;

@Data
public class ResponseDTO<T> implements Serializable {
    private static final Integer SUCCESS = 200;
    private static final Integer FAIL = 500;


    private Integer status = null;
    private String msg = null;
    private T data = null;
    private List<String> errors = null;
    private Cursor cursor = null;

    public static ResponseDTO success(String msg) {
        return successWithMD(msg,null);
    }

    public static <T> ResponseDTO successWithData(T data) {
        return successWithMD(null,data);
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

    public static ResponseDTO fail(String msg) {
        return failWithErrors(msg,null);
    }

    public static ResponseDTO failWithErrors(String msg,List<String> errors) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus(FAIL);
        responseDTO.setMsg(msg);
        if(errors!=null) {
            responseDTO.setErrors(errors);
        }
        return responseDTO;
    }

    @Data
    @AllArgsConstructor
    public static class Cursor {
        private Long total = null;
        private Integer limit = null;
        private Integer offset = null;
    }
}
