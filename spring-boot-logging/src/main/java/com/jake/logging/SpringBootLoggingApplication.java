package com.jake.logging;

import com.jake.logging.common.logging.utils.WorkflowInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class SpringBootLoggingApplication {

    public static void main(String[] args) {

        initLogDir();

        SpringApplication.run(SpringBootLoggingApplication.class, args);

        WorkflowInitializer workflowInitializer = new WorkflowInitializer.Builder().build();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.submit(workflowInitializer.initFlow());
        executorService.submit(workflowInitializer.initFlow());
        executorService.submit(workflowInitializer.initFlow());
        executorService.submit(workflowInitializer.initFlow());
    }

    private static void initLogDir() {
        String logPathDir = "logs";
        File logFilePath = new File(logPathDir);
        if(!logFilePath.isDirectory()) {
            logFilePath.mkdir();
        }

        System.setProperty("logging.file.path", logFilePath.getAbsolutePath());
        System.setProperty("logging.error.file.path", logFilePath.getAbsolutePath());
    }
}
