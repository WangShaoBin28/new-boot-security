package com.app.service.impl;

import com.app.entity.SysUser;
import com.app.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;

/**
 * @Package com.app.service.impl
 * @ClassName UserDetailsServiceImpl
 * @Author shaobin.wang
 * @Date 2019/07/05 17:16
 * @Version 1.0
 * @Description:
 **/
@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private SysUserService sysUserService;

    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("登录，用户名：{}", username);
        SysUser sysUser = sysUserService.findUserName(username);

        if (sysUser == null) {
            throw new UsernameNotFoundException("用户不存在");
        }

        return new User(sysUser.getUsername(), sysUser.getPassword(), new HashSet<SimpleGrantedAuthority>());
    }
}
