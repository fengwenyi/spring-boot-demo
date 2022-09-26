package com.fengwenyi.springboot.example.vo.request;

import com.fengwenyi.springboot.example.annotation.ValidTimestamp;
import lombok.Data;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-07-08
 */
@Data
public class PostParamVerifyRequestVo {

    private String id;

    @NotNull(message = "时间戳不能为空")
    @ValidTimestamp(message = "时间戳不合法", past = true)
    private Long timestamp;

//    @Future(message = "时间戳不合法")
//    private LocalDateTime localDateTime;

}
