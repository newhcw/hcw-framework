package cn.hcw.dubbo.provider.component;

public class UserSessionHolder {

    private final static ThreadLocal<UserSession> userSessionThreadLocal = new ThreadLocal<>();

    public static void setUserSession(UserSession userSession){
        userSessionThreadLocal.set(userSession);
    }

    public static UserSession getUserSession() {
        return userSessionThreadLocal.get();
    }

    public static void clearSession(){
        userSessionThreadLocal.set(null);
    }
}
