package com.app.service;

import com.app.entity.SysUser;

/**
 * @Package com.app.service
 * @ClassName SysUserService
 * @Author shaobin.wang
 * @Date 2019/07/05 17:18
 * @Version 1.0
 * @Description:
 **/
public interface SysUserService {

    SysUser findUserName(String name);
}
