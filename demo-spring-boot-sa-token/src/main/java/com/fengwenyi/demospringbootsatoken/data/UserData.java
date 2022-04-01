package com.fengwenyi.demospringbootsatoken.data;

import java.util.*;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2022-01-13
 */
public class UserData {

    private static final Map<String, User> users = new HashMap<>();

    static {
        users.put("u1", new User("01", "u1", "123456", Collections.singletonList("ROLE_USER")));
        users.put("a2", new User("02", "a2", "123456", Arrays.asList("ROLE_ADMIN", "ROLE_USER")));
    }


    public static class User {
        public String uid;
        public String username;
        public String password;
        public List<String> roles;

        public User(String uid, String username, String password, List<String> roles) {
            this.uid = uid;
            this.username = username;
            this.password = password;
            this.roles = roles;
        }
    }

    public static User queryByUsername(String username) {
        return users.get(username);
    }

    public static List<String> queryRolesByUid(String uid) {
        for (Map.Entry<String, User> entry : users.entrySet()) {
            if (uid.equals(entry.getValue().uid)) {
                return entry.getValue().roles;
            }
        }
        return null;
    }

    public static User queryByUid(String uid) {
        for (Map.Entry<String, User> entry : users.entrySet()) {
            if (uid.equals(entry.getValue().uid)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public static List<User> queryAll() {
        return new ArrayList<>(users.values());
    }

}
