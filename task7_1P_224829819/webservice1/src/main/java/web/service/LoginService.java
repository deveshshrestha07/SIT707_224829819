package web.service;

import java.util.HashMap;
import java.util.Map;

public class LoginService {

    // User data storage: username -> [password, dob]
    private static Map<String, String[]> users = new HashMap<>();

    static {
        // Pre-defined valid users
        users.put("ahsan", new String[]{"ahsan_pass", "1990-01-01"});
        users.put("student1", new String[]{"pass123", "1995-05-05"});
        users.put("admin", new String[]{"admin123", "1980-12-12"});
    }

    /**
     * Authenticate the user based on username, password, and dob.
     * @param username the input username
     * @param password the input password
     * @param dob the input date of birth
     * @return true if authentication is successful, false otherwise
     */
    public static boolean login(String username, String password, String dob) {
        if (username == null || password == null || dob == null) {
            return false;
        }

        if (!users.containsKey(username)) {
            return false;
        }

        String[] credentials = users.get(username);
        return credentials[0].equals(password) && credentials[1].equals(dob);
    }
}
