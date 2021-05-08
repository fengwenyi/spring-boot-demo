package com.fengwenyi.demospringbootvalidated.vo;

import com.fengwenyi.demospringbootvalidated.annotation.IdCardNo;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-05-08
 */
@Data
@Accessors(chain = true)
public class UserRegisterRequestVo {

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    @Size(min = 8, max = 32, message = "密码长度必须在8-32个字符之间")
    private String password;

    private String nickname;

    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;

    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$", message = "手机号格式错误")
    private String phone;

    private Integer age;

    @NotNull(message = "出生日期不能为空")
    @Past(message = "出生日期不合法")
    private LocalDate birthDate;

    @NotEmpty(message = "必须选填一个爱好")
    private List<String> likes;

    @NotBlank(message = "身份证号码不能为空")
    @IdCardNo(message = "身份证号码不合法")
    private String idCardNo;

}
