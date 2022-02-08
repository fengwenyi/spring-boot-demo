package com.fengwenyi.demospringbootjsonview.vo.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.fengwenyi.demospringbootjsonview.view.UserView;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2022-02-08
 */
@Data
@Accessors(chain = true)
@JsonView(UserView.UserList.class)
public class UserResponseVo implements Serializable {



    private Integer id;

//    @JsonView(UserView.UserList.class)
    private String username;

    @JsonIgnore
    private String password;

    @JsonView(UserView.UserDetail.class)
    private Integer age;

}
