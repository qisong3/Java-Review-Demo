package cn.errison.feature.demo.logging;

import java.io.IOException;
import java.util.logging.*;

public class Demo1 {

    private static Logger logger =
            Logger.getLogger(Demo1.class.getName());

    private static FileHandler fileHandler;


    // 格式化输出
    private static class CustomFormatter extends Formatter {
        private static final String format =
                "[%1$tF %1$tT] [%2$-4s] %3$s %n";

        public String format(LogRecord record) {
            return String.format(format,
                    record.getMillis(),
                    record.getLevel().getLocalizedName(),
                    record.getMessage());
        }
    }


    public static void main(String[] args) throws
            IOException {
        // 输出到文件
        fileHandler = new
                FileHandler(Demo1.class.getName() + ".log");
        logger.setLevel(Level.ALL);
        fileHandler.setFormatter(new CustomFormatter());
        logger.addHandler(fileHandler);
        // 日志级别
        logger.fine("Log message redirected to a file");
        logger.finer("The name of the logger is " +
                logger.getName());
        logger.finest("This is same as class name: " +
                Demo1.class.getName());
    }

}