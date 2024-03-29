package com.app.service.impl;

import com.app.entity.SysUser;
import com.app.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Package com.app.service.impl
 * @ClassName SysUserServiceImpl
 * @Author shaobin.wang
 * @Date 2019/07/05 17:18
 * @Version 1.0
 * @Description:
 **/
@Service
@Slf4j
public class SysUserServiceImpl implements SysUserService {
    @Override
    public SysUser findUserName(String name) {
        return new SysUser(1L, "root", "123456", "123", "root");
    }
}
