package ro.pao.threads;

import lombok.AllArgsConstructor;
import ro.pao.application.csv.CsvReader;
import ro.pao.exceptions.CustomFileNotFoundException;

import java.nio.file.Path;
import java.util.List;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AsyncLogger {
    private final Logger logger = Logger.getGlobal();
    private static final AsyncLogger singleton = new AsyncLogger();

    public static AsyncLogger getInstance()
    {
        return singleton;
    }
    public void logTask(Runnable task)
    {
        ThreadExecuter.getInstance().add(task);
    }
    public void log(Level level, String msgSupplier)
    {
        ThreadExecuter.getInstance().add(() -> {
            logger.log(level, msgSupplier);
        });
    }
}
