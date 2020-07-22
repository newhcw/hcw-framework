import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Slf4jImpl implements Log {

    private Logger logger;

    public Slf4jImpl(String clazz) {
        logger = LoggerFactory.getLogger(clazz);
    }

    @Override
    public void error(String msg) {
        logger.error(msg);
    }

    @Override
    public void debug(String msg) {
        logger.debug(msg);
    }

    @Override
    public void info(String msg) {
        logger.info(msg);
    }

    @Override
    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }
}
