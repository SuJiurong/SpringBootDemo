package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 新增用户
     */
    @PostMapping
    public boolean save(@RequestBody User user) {
        return userService.save(user);
    }

    /**
     * 根据ID删除用户
     */
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return userService.removeById(id);
    }

    /**
     * 更新用户
     */
    @PutMapping
    public boolean update(@RequestBody User user) {
        return userService.updateById(user);
    }

    /**
     * 根据ID查询用户
     */
    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    /**
     * 查询所有用户
     */
    @GetMapping
    public List<User> list() {
        return userService.list();
    }

    /**
     * 分页查询
     */
    @GetMapping("/page")
    public Page<User> page(@RequestParam(defaultValue = "1") int current,
                          @RequestParam(defaultValue = "10") int size) {
        return userService.page(new Page<>(current, size));
    }

    /**
     * 条件查询
     */
    @GetMapping("/search")
    public List<User> search(@RequestParam(required = false) String name,
                           @RequestParam(required = false) Integer age) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if (name != null) {
            wrapper.like("name", name);
        }
        if (age != null) {
            wrapper.eq("age", age);
        }
        return userService.list(wrapper);
    }
}
