package com.xlh.swagger.demo.controller;

import com.xlh.swagger.demo.model.UserDTO;
import com.xlh.swagger.demo.model.UserVO;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 用途描述
 *
 * @author 胡晓磊
 * @company xxx
 * @date 2021年04月05日 18:01 胡晓磊 Exp $
 */
@RestController(value = "user")
@Api(tags = {"用户相关的API", "测试API demo"})
public class UserController {

    @ApiOperation(value = "新增用户", tags = "测试API demo")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = UserDTO.class)
    })
    @PostMapping(value = "/add")
    public UserDTO addUser(@RequestBody UserDTO params) {
        return params;
    }


    @ApiOperation(value = "根据ID查询用户信息", notes = "这是接口的详细信息描述")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = UserVO.class)
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", dataType = "string", paramType = "path", required = true, defaultValue = "1")})
    @GetMapping(value = "/get/{id}")
    public UserVO addUser(@PathVariable(name = "id") @ApiParam(required = true, value = "用户ID") String id) {
        UserVO userVO = new UserVO();
        userVO.setAge(new Random().nextInt(100));
        userVO.setName("测试" + new Random().nextInt(10000000));
        return userVO;
    }

    @ApiOperation(value = "根据用户名称和年龄查询用户信息")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = UserVO.class)
    })
    @PostMapping(value = "/user/list")
    public List<UserVO> queryUserList(@RequestBody @ApiParam(required = true, value = "用户查询参数") UserDTO params) {
        UserVO userVO = new UserVO();
        userVO.setAge(new Random().nextInt(100));
        userVO.setName("测试" + new Random().nextInt(10000000));
        return Arrays.asList(userVO);
    }


    @ApiOperation(value = "根据用户名称和姓名查询用户信息")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = UserVO.class)
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", defaultValue = "0", required = false),
            @ApiImplicitParam(name = "name", value = "用户名", defaultValue = "测试", required = true)
    })
    @PostMapping(value = "/user/listAll")
    public List<UserVO> queryUserList(@RequestParam String id, @RequestParam String name) {
        UserVO userVO = new UserVO();
        userVO.setAge(new Random().nextInt(100));
        userVO.setName("测试" + new Random().nextInt(10000000));
        return Arrays.asList(userVO);
    }
}
