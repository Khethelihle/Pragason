package com.awsprojrct.pragason.main;


import com.awsprojrct.pragason.DDB.TableValidator;
import com.awsprojrct.pragason.auth.CredentialsHelper;
import com.awsprojrct.pragason.constants.Constants;
import com.awsprojrct.pragason.errors.Error;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AwsProjectPragasonBackendApiApplication implements Error {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AwsProjectPragasonBackendApiApplication.class, args);

        TableValidator.retrieveItem(Constants.QuestionTBL);

        System.out.println("Exiting .........");

    }


}
