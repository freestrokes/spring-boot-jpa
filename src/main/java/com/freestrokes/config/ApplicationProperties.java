package com.freestrokes.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Data
@Component
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

    private String tempPath;
    private Email email;
    private Ui ui;
    private Storage storage;
    private Bts bts;
    private Metering metering;
    private Pager pager;

    @Getter
    @Setter
    public static class Email {
        private String endpoint;
    }

    @Getter
    @Setter
    public static class Ui {
        private String success;
        private String error;
    }

    @Getter
    @Setter
    public static class Storage {
        private String account;
        private String password;
        private String domain;
        private String project;
        private String projectId;
        private String bucketName;
        private String imageBucketName;
        private String endpoint;
        private String authEndpoint;
    }

    @Getter
    @Setter
    public static class Bts {
        private String id;
        private String secret;
        private String sphinx;
        private String kkanbu;
        private String nimbus;
        private String daitso;
        private String universe;
    }

    @Getter
    @Setter
    public static class Metering {

        private String serviceId;

        private int productId;

        private String regionCode;
    }

    @Getter
    @Setter
    public static class Pager {
        private String endpoint;
    }
}

