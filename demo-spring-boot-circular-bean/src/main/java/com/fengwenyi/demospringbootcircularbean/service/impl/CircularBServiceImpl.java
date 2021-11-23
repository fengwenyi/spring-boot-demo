package com.fengwenyi.demospringbootcircularbean.service.impl;

import com.fengwenyi.demospringbootcircularbean.service.ICircularAService;
import com.fengwenyi.demospringbootcircularbean.service.ICircularBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Erwin Feng
 * @since 2021-02-04
 */
@Service
public class CircularBServiceImpl implements ICircularBService {

    @Autowired
    private ICircularAService iCircularAService;

    @Override
    public void helloB() {
        System.out.println("Hello B");
    }
}
