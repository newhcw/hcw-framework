public interface Log {

    void error(String msg);

    void debug(String msg);

    void info(String msg);

    boolean isDebugEnabled();
}
