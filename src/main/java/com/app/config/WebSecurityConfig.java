package com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @Package com.app.config
 * @ClassName WebSecurityConfig
 * @Author shaobin.wang
 * @Date 2019/07/05 17:15
 * @Version 1.0
 * @Description:
 **/
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /**
         * fromLogin(): 表单认证
         * httpBasic(): 弹出框认证
         * authorizeRequests() 身份认证请求
         * anyRequest(): 所有请求
         * authenticated(): 身份认证
         * loginPage(): 登录页面地址（因为SpringBoot无法直接访问页面，所以这通常是一个路由地址）
         * loginProcessingUrl(): 登录表单提交地址
         * .csrf().disable(): 关闭Spring Security的跨站请求伪造的功能
         */
        http.csrf().disable().formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/auth/login")
                .and()
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .anyRequest()
                .authenticated();
    }

    @Component
    class PasswordEncoderImpl implements PasswordEncoder {
        /**
         * Encode the raw password. Generally, a good encoding algorithm applies a SHA-1 or
         * greater hash combined with an 8-byte or greater randomly generated salt.
         *
         * @param rawPassword
         */
        @Override
        public String encode(CharSequence rawPassword) {
            return rawPassword.toString();
        }

        /**
         * Verify the encoded password obtained from storage matches the submitted raw
         * password after it too is encoded. Returns true if the passwords match, false if
         * they do not. The stored password itself is never decoded.
         *
         * @param rawPassword     the raw password to encode and match
         * @param encodedPassword the encoded password from storage to compare with
         * @return true if the raw password, after encoding, matches the encoded password from
         * storage
         */
        @Override
        public boolean matches(CharSequence rawPassword, String encodedPassword) {
            return encodedPassword.equals(rawPassword.toString());
        }
    }
}
