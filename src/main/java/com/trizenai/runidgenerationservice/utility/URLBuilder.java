package com.trizenai.runidgenerationservice.utility;

import com.trizenai.runidgenerationservice.config.ControlMConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class URLBuilder {

    Logger logger = LoggerFactory.getLogger(URLBuilder.class);
    FileInputStream fileInputStream = null;
    FileOutputStream fileOutputStream = null;
    FileUtility fileUtility = new FileUtility();
    File file;
    ControlMConfig config = null;
    public String serverName;
    public String port;

    public URLBuilder() {
        try {
            this.file = new File(Path.of("", new String[0]).toAbsolutePath().toString() + "\\ServerDetails.txt");
            boolean result = this.file.createNewFile();
            if (result) {
                this.logger.info("File Created : " + this.file.getName() + ", at path :" + this.file.getAbsolutePath());
                this.logger.info("Please update your server name and port details in it...");
                this.storeControlMProperties();
            } else {
                this.logger.info("File already exists : " + this.file.getName() + " \n at path:" + this.file.getAbsolutePath());
                this.config = this.getControlMProperties();
            }
        } catch (IOException e) {
            this.logger.info("Exception caught in URLBuilder constructor:" + e.getMessage());
        }
    }

    public String toString() {
        return "URLBuilder [serverName=" + this.serverName + ", port=" + this.port + "]";
    }

    public ControlMConfig getControlMProperties() throws FileNotFoundException, IOException {
        this.logger.trace("Inside getControlMProperties method..");
        ControlMConfig controlMConfig = new ControlMConfig();
        this.fileInputStream = new FileInputStream(this.file);
        Properties properties = new Properties();
        properties.load(this.fileInputStream);
        controlMConfig.setSessionLoginApi(properties.getProperty("session.login.api"));
        controlMConfig.setOrderApi(properties.getProperty("order.api"));
        controlMConfig.setJobStatusApi(properties.getProperty("job.status.api"));
        controlMConfig.setSLAStatusApi("/automation-api/run/jobs/status?jobname=SLA_ControlM_");
        controlMConfig.setServerName(properties.getProperty("server.name"));
        controlMConfig.setPort(Integer.parseInt(properties.getProperty("port")));
        this.fileInputStream.close();
        return controlMConfig;
    }

    private void storeControlMProperties() throws IOException {
        this.logger.trace("Inside storeControlMProperties method..");
        this.fileInputStream = new FileInputStream(this.file);
        Properties properties = new Properties();
        properties.load(this.fileInputStream);
        this.fileInputStream.close();
        this.fileOutputStream = new FileOutputStream(this.file);
        properties.setProperty("session.login.api", "/automation-api/session/login");
        properties.setProperty("order.api", "/automation-api/run/order");
        properties.setProperty("job.status.api", "/automation-api/run/status/");
        properties.setProperty("server.name", "HOST_NAME");
        properties.setProperty("port", "8443");
        properties.store(this.fileOutputStream, null);
        this.fileOutputStream.close();
    }

    public String buildLoginURL() throws FileNotFoundException, IOException {
        StringBuffer sb = new StringBuffer();
        this.logger.trace("Inside buildLoginURL method");
        sb.append("https://");
        sb.append(this.config.getServerName()).append(":").append(this.config.getPort()).append(this.config.getSessionLoginApi());
        this.logger.trace("Login URL:" + sb.toString());
        return sb.toString();
    }

    public String buildRunOrderURL() throws FileNotFoundException, IOException {
        StringBuffer sb = new StringBuffer();
        this.logger.trace("Inside buildRunOrderURL method");
        sb.append("https://");
        sb.append(this.config.getServerName()).append(":").append(this.config.getPort()).append(this.config.getOrderApi());
        this.logger.trace("Run Order URL:" + sb.toString());
        return sb.toString();
    }

    public String buildJobStatusURL() throws FileNotFoundException, IOException {
        StringBuffer sb = new StringBuffer();
        this.logger.trace("Inside buildJobStatusURL method");
        sb.append("https://");
        sb.append(this.config.getServerName()).append(":").append(this.config.getPort()).append(this.config.getJobStatusApi());
        this.logger.trace("Job Status URL:" + sb.toString());
        return sb.toString();
    }

    public String buildSLAServicesURL() {
        StringBuffer sb = new StringBuffer();
        this.logger.trace("Inside buildSLAServicesURL method");
        sb.append("https://");
        sb.append(this.config.getServerName()).append(":").append(this.config.getPort()).append(this.config.getSLAStatusApi());
        this.logger.trace("SLA Services URL:" + sb.toString());
        return sb.toString();
    }

    public String buildRunJobsURL(String folderName) {
        StringBuffer sb = new StringBuffer();
        this.logger.trace("Inside buildRunJobsURL() method");
        sb.append("https://");
        sb.append(this.config.getServerName()).append(":").append(this.config.getPort()).append(this.config.getRunJobsApi()).append(folderName);
        this.logger.trace("Run Jobs URL:" + sb.toString());
        return sb.toString();
    }
}
