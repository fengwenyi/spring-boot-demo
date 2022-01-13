package com.fengwenyi.demospringbootsatoken.stp;

import cn.dev33.satoken.stp.StpInterface;
import com.fengwenyi.demospringbootsatoken.data.UserData;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2022-01-13
 */
@Component
public class StpInterfaceImpl implements StpInterface {
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        if (Objects.isNull(loginId)) {
            return null;
        }
        List<String> roles = getRoleList(loginId, loginType);
        if (CollectionUtils.isEmpty(roles)) {
            return null;
        }
        if (roles.contains("ROLE_ADMIN")) {
            return List.of("ADD", "DELETE", "UPDATE", "QUERY");
        }
        return null;
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        if (Objects.isNull(loginId)) {
            return null;
        }
        return UserData.queryRolesByUid(loginId + "");
    }
}
