package com.itbin.ss.sharingsphere.data.enums;

/**
 * Created by LIBIN on 2019/2/13 15:54
 * Description:
 */
public enum ResultEnum {

    SUCCESS("操作成功","100");

    private String name;
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    ResultEnum(String name,String code){
        this.name=name;
        this.code=code;
    }
}
