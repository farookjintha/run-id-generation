package com.trizenai.runidgenerationservice.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RunIdPersister {

    FileInputStream fileInputStream = null;
    FileOutputStream fileOutputStream = null;
    FileUtility fileUtility = new FileUtility();
    Logger logger = LoggerFactory.getLogger(RunIdPersister.class);

    public void saveRunIdAndAlphanumericRunId(String numericRunId, String alphaNumericRunId) throws IOException {
        this.logger.trace("Inside saveRunIdAndAlphanumericRunId method.....");
        File file = this.fileUtility.createFile("RunIdMapping.txt");
        this.fileInputStream = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(this.fileInputStream);
        this.fileInputStream.close();
        this.fileOutputStream = new FileOutputStream(file);
        properties.setProperty(numericRunId, alphaNumericRunId);
        properties.store(this.fileOutputStream, null);
        this.fileOutputStream.close();
    }

    public String getAlphanumericRunId(String numericRunId) throws IOException {
        this.logger.trace("Inside getAlphanumericRunId method.....");
        this.fileInputStream = new FileInputStream(this.fileUtility.createFile("RunIdMapping.txt"));
        Properties properties = new Properties();
        properties.load(this.fileInputStream);
        String alphanumericRunId = properties.getProperty(numericRunId);
        this.fileInputStream.close();
        return alphanumericRunId;
    }

    public String getNumericRunIdUsingAlphaNumericRunId(String alphaNumericRunId) throws FileNotFoundException, IOException {
        this.logger.trace("Inside getNumericRunIdUsingAlphaNumericRunId method.....");
        this.fileInputStream = new FileInputStream(this.fileUtility.createFile("RunIdMapping.txt"));
        Properties properties = new Properties();
        properties.load(this.fileInputStream);
        String numericRunId = null;
        Set<Map.Entry<Object, Object>> propertySet = properties.entrySet();
        for (Map.Entry<Object, Object> entry : propertySet) {
            if (!entry.getValue().equals(alphaNumericRunId)) continue;
            numericRunId = (String) entry.getKey();
        }
        this.fileInputStream.close();
        return numericRunId;
    }

    public void saveRunIdAndLastJobId(String numericRunId, String lastJobId) throws IOException {
        this.logger.trace("Inside saveRunIdAndLastJobId method.....");
        File file = this.fileUtility.createFile("RunIdMapping.txt");
        this.fileInputStream = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(this.fileInputStream);
        this.fileInputStream.close();
        this.fileOutputStream = new FileOutputStream(file);
        properties.setProperty(numericRunId, lastJobId);
        properties.store(this.fileOutputStream, null);
        this.fileOutputStream.close();
    }
}
