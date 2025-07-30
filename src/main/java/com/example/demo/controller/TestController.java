package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserService userService;

    /**
     * 测试基本查询
     */
    @GetMapping("/basic")
    public Map<String, Object> testBasic() {
        // 查询总数
        long count = userService.count();

        // 查询所有用户
        List<User> allUsers = userService.list();

        return Map.of(
            "count", count,
            "users", allUsers
        );
    }

    /**
     * 测试条件查询
     */
    @GetMapping("/query")
    public Map<String, Object> testQuery() {
        // 使用QueryWrapper
        QueryWrapper<User> wrapper1 = new QueryWrapper<>();
        wrapper1.gt("age", 25).like("name", "张");
        List<User> users1 = userService.list(wrapper1);

        // 使用LambdaQueryWrapper（类型安全）
        LambdaQueryWrapper<User> wrapper2 = new LambdaQueryWrapper<>();
        wrapper2.between(User::getAge, 20, 30).orderByDesc(User::getAge);
        List<User> users2 = userService.list(wrapper2);

        return Map.of(
            "ageGreaterThan25AndNameLike", users1,
            "ageBetween20And30", users2
        );
    }

    /**
     * 测试分页查询
     */
    @GetMapping("/page")
    public Page<User> testPage() {
        // 分页查询
        Page<User> page = new Page<>(1, 2); // 第1页，每页2条
        return userService.page(page);
    }

    /**
     * 测试复杂查询
     */
    @GetMapping("/complex")
    public Map<String, Object> testComplex() {
        // 复杂条件查询
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(User::getName, User::getAge) // 只查询指定字段
               .ge(User::getAge, 25) // 年龄大于等于25
               .orderByAsc(User::getAge); // 按年龄升序

        List<User> users = userService.list(wrapper);

        // 统计查询
        QueryWrapper<User> countWrapper = new QueryWrapper<>();
        countWrapper.gt("age", 25);
        long count = userService.count(countWrapper);

        return Map.of(
            "selectedFields", users,
            "countAgeGt25", count
        );
    }

    /**
     * 测试批量操作
     */
    @GetMapping("/batch")
    public String testBatch() {
        // 创建测试用户
        User user1 = new User();
        user1.setName("批量用户1");
        user1.setAge(35);
        user1.setEmail("batch1@example.com");

        User user2 = new User();
        user2.setName("批量用户2");
        user2.setAge(40);
        user2.setEmail("batch2@example.com");

        // 批量保存
        boolean result = userService.saveBatch(List.of(user1, user2));

        return result ? "批量操作成功" : "批量操作失败";
    }
}
