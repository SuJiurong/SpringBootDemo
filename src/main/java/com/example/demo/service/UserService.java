package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.model.User;

public interface UserService extends IService<User> {
    // IService已经提供了基本的CRUD操作
    // 这里可以添加自定义的业务方法
}
