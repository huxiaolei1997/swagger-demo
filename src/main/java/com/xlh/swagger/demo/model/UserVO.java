package com.xlh.swagger.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 用途描述
 *
 * @author 胡晓磊
 * @company xxx
 * @date 2021年04月05日 17:57 胡晓磊 Exp $
 */
@Data
@ApiModel(value = "com.xlh.swagger.demo.model.UserVO", description = "用户详情")
public class UserVO implements Serializable {

    private static final long serialVersionUID = 2513156692633077311L;
    @ApiModelProperty(value = "用户名称")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;
}
