package com.fengwenyi.demo.springboot.shardingjdbc.controller;

import com.fengwenyi.demo.springboot.shardingjdbc.dto.LogDto;
import com.fengwenyi.demo.springboot.shardingjdbc.entity.LogEntity;
import com.fengwenyi.demo.springboot.shardingjdbc.repository.LogRepository;
import com.fengwenyi.javalib.convert.DateTimeUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2024-01-18
 */
@RestController
@RequestMapping("/log")
@RequiredArgsConstructor
public class LogController {

    private final LogRepository logRepository;

    @PostMapping("/create")
    public String create(@RequestBody LogDto logDto) {

        LogEntity entity = new LogEntity();
        entity.setLogTime(DateTimeUtils.parseLocalDateTime(logDto.getLogTime(), "yyyy-MM-dd HH:mm:ss"));

        logRepository.save(entity);

        return "Success";
    }

}
