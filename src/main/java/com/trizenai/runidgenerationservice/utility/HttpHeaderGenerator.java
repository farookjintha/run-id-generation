package com.trizenai.runidgenerationservice.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;

/**
 * NOTE: the original source initializes its logger with FileUtility.class
 * instead of HttpHeaderGenerator.class — mirrored here faithfully since
 * that's what the decompiled bytecode shows, but it looks like a
 * copy-paste bug in the real codebase (harmless, just mislabels log lines).
 */
public class HttpHeaderGenerator {

    static Logger logger = LoggerFactory.getLogger(FileUtility.class);

    public static HttpHeaders getHeaders() {
        logger.trace("Inside getHeaders method...");
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Accept", "application/json");
        return headers;
    }
}
