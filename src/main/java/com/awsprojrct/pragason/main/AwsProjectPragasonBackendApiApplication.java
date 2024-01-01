package com.awsprojrct.pragason.main;

import com.awsprojrct.pragason.auth.CredentialsHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AwsProjectPragasonBackendApiApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AwsProjectPragasonBackendApiApplication.class, args);

        String access_key = CredentialsHelper.getAccessKey();
        String secrete_key = CredentialsHelper.getSecretKey();


    }

}
