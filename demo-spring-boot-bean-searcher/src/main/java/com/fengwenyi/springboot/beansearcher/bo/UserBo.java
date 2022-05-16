package com.fengwenyi.springboot.beansearcher.bo;

import com.ejlchina.searcher.bean.DbField;
import com.ejlchina.searcher.bean.SearchBean;
import lombok.Data;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2022-05-16
 */
@Data
@SearchBean(tables="t_user u, t_role r, t_user_role ur", joinCond="ur.role_id = r.id and ur.user_id = u.id", autoMapTo="u")
public class UserBo {

    private String id;

    private String nickname;

    @DbField("r.role_name")
    private String roleName;

}
