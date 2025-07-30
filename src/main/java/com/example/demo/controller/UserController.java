package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users") // 所有请求都以 /users 开头
public class UserController {

    @Autowired
    private IUserService userService;

//    // GET /users: 获取所有用户列表
//    @GetMapping("get")
//    public List<User> getAllUsers() {
//        // 调用 MyBatis-Plus 提供的方法查询所有用户
//        // selectList(null) 中的 null 表示没有查询条件
//        return userService.selectList(null);
//    }
//
//    // GET /users/{id}: 根据ID获取单个用户信息
//    @GetMapping("/{id}")
//    public User getUserById(@PathVariable Long id) {
//        return userService.selectById(id);
//    }
//
//    // POST /users: 新增一个用户
//    @PostMapping("/add")
//    public String addUser(@RequestBody User user) {
//        int result = userService.insert(user);
//        return result > 0 ? "新增成功, 用户ID: " + user.getId() : "新增失败";
//    }

    @PutMapping("/put")
    public void updateUser(@RequestBody User user) {
        User updateUser = new User();
        updateUser.setId(user.getId());
        updateUser.setName("siyu");
        updateUser.setAge(18);
        userService.updateById(updateUser);
    }


}