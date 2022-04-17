package com.fengwenyi.demospringbootmybatisplus.base;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 业务基础实体类
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2022-03-07
 */
@Getter
@Setter
@Accessors(chain = true)
public class BaseBizEntity extends BaseEntity {

    private static final long serialVersionUID = 1464845551976822009L;

    /**
     * 启用状态
     * @see com.fengwenyi.apistarter.constant.EnabledState
     */
    private Boolean enabledState;

    /**
     * 删除状态
     * @see com.fengwenyi.apistarter.constant.DeletedState
     */
    @TableLogic
    private Boolean deletedState;

}
