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
@ApiModel(value = "com.xlh.swagger.demo.model.UserDTO", description = "新增用户参数")
public class UserDTO implements Serializable {
    private static final long serialVersionUID = -8969396545107246671L;

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "用户名称")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;
}
