package com.fengwenyi.demospringbootmybatisplus.repository.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengwenyi.demospringbootmybatisplus.dao.ILogDao;
import com.fengwenyi.demospringbootmybatisplus.entity.LogEntity;
import com.fengwenyi.demospringbootmybatisplus.repository.MPLogRepository;
import org.springframework.stereotype.Service;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2023-07-24
 */
@Service
public class LogRepositoryImpl
        extends ServiceImpl<ILogDao, LogEntity>
        implements MPLogRepository {
}
