package com.fengwenyi.springboot.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-11-04
 */
@Service
public class LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    public void login() {
        //authenticationManager.authenticate()
    }

}
