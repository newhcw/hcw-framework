public class Test {

    private static Log LOG = LogFactory.getLogger(Test.class);


    public static void main(String[] args) {

        LogFactory.useLog4J2Logging();
        LOG.info("my log is starting 1");
        LogFactory.useSlf4jLogging();
        LOG.info("my log is starting 2");

    }

}
