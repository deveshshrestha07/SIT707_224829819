package web.handler;

import java.util.HashMap;
import web.handler.LoginService;
import java.util.Map;


public class LoginService {

    private static Map<String, String[]> users = new HashMap<>();

    static {
        users.put("ahsan", new String[]{"ahsan_pass", "1990-01-01"});
        users.put("student1", new String[]{"pass123", "1995-05-05"});
        users.put("admin", new String[]{"admin123", "1980-12-12"});
    }

    public static boolean login(String username, String password, String dob) {
        if (username == null || password == null || dob == null) return false;
        if (!users.containsKey(username)) return false;

        String[] creds = users.get(username);
        return creds[0].equals(password) && creds[1].equals(dob);
    }
}