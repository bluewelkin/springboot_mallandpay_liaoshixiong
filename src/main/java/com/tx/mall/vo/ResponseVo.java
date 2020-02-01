package com.tx.mall.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tx.mall.enums.ResponseEnum;
import lombok.Data;

@Data
//@JsonSerialize(value = Js)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ResponseVo<T> {
    private Integer status;

    private String msg;

    private T data;

    public ResponseVo(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }
    public static <T> ResponseVo<T> success(String msg) {
        return  new ResponseVo<>(0,msg);

    }
    public static  <T> ResponseVo<T> success() {
        return  new ResponseVo<>(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getDesc());
    }

    public static  <T> ResponseVo<T> error(ResponseEnum responseEnum) {
        return  new ResponseVo<>(responseEnum.getCode(),responseEnum.getDesc());
    }

}
