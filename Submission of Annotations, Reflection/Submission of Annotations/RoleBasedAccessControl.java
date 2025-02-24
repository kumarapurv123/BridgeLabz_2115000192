import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class User {
    private String role;

    public User(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

class SecureService {
    @RoleAllowed("ADMIN")
    void adminTask() {
        System.out.println("Admin task executed.");
    }
}

public class RoleBasedAccessControl {
    public static void main(String[] args) {
        User user1 = new User("ADMIN");
        User user2 = new User("USER");

        SecureService service = new SecureService();
        invokeIfAuthorized(service, "adminTask", user1);
        invokeIfAuthorized(service, "adminTask", user2);
    }

    public static void invokeIfAuthorized(Object obj, String methodName, User user) {
        try {
            Method method = obj.getClass().getMethod(methodName);
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
                if (user.getRole().equals(roleAllowed.value())) {
                    method.invoke(obj);
                } else {
                    System.out.println("Access Denied! User role: " + user.getRole());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
