package com.trizenai.runidgenerationservice.utility;

import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RandomRunIdGenerator {

    static Logger logger = LoggerFactory.getLogger(RandomRunIdGenerator.class);

    public static String generateRandomRunId() {
        logger.trace("Inside generateRandomRunId method....");
        Random random = new Random();
        Integer randomNumber = random.nextInt(2137483648) + 10000000;
        return randomNumber.toString();
    }
}
