import java.lang.reflect.Constructor;

/**
 * 优先log4j2，再者slf4j
 */
public class LogFactory {

    private static Constructor<? extends Log> logConstructor;

    static {

        tryImplementation(new Runnable() {
            @Override
            public void run() {
                useLog4J2Logging();
            }
        });

        tryImplementation(new Runnable() {
            @Override
            public void run() {
                useSlf4jLogging();
            }
        });


    }

    private LogFactory() {
        // disable construction
    }

    public static Log getLogger(Class<Test> aClass) {
        return getLog(aClass.getName());
    }

    public static Log getLog(String logger) {
        try {
            return logConstructor.newInstance(new Object[] { logger });
        } catch (Throwable t) {
           return null;
        }
    }

    private static void tryImplementation(Runnable runnable) {
        if (logConstructor == null) {
            try {
                runnable.run();
            } catch (Throwable t) {
                // ignore
            }
        }
    }

    public static synchronized void useSlf4jLogging() {
        setImplementation(Slf4jImpl.class);
    }

    public static synchronized void useLog4J2Logging() {
        setImplementation(Log4j2Impl.class);
    }

    private static void setImplementation(Class<? extends Log> implClass) {
        try {
            Constructor<? extends Log> candidate = implClass.getConstructor(new Class[] { String.class });
            Log log = candidate.newInstance(new Object[] { LogFactory.class.getName() });
            if (log.isDebugEnabled()) {
                log.debug("Logging initialized using '" + implClass + "' adapter.");
            }
            logConstructor = candidate;
        } catch (Throwable t) {
            // ignore
        }
    }
}
