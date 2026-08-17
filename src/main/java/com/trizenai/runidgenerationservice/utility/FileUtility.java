package com.trizenai.runidgenerationservice.utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtility {

    Logger logger = LoggerFactory.getLogger(FileUtility.class);

    File createFile(String fileName) throws IOException {
        this.logger.trace("Inside createFile method...");
        File file = new File(Path.of("", new String[0]).toAbsolutePath().toString() + "\\" + fileName);
        boolean result = file.createNewFile();
        if (result) {
            this.logger.info("File Created : " + fileName + ", at path :" + file.getAbsolutePath());
            return file;
        }
        this.logger.info("File already exists : " + fileName + " \n at path:" + file.getAbsolutePath());
        return file;
    }
}
