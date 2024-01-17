package com.awsprojrct.pragason.auth;

import com.awsprojrct.pragason.errors.Errors;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CredentialsHelper {
    public static String getAccessKey() throws Exception {
        String accessKey = null;
        File file = new File("C:\\Temp\\creds.txt");
        try {
            Scanner sc = new Scanner(file);
            accessKey = sc.nextLine();
            sc.close();
        } catch (FileNotFoundException e) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException();
            Exception ex = new Exception(fileNotFoundException);
            ex.initCause(fileNotFoundException);
            throw ex;
        }
        return accessKey;
    }

    public static String getSecretKey() throws Exception {
        String secretKey = "null";
        File file = new File("C:\\Temp\\creds.txt");
        try {
            Scanner sc = new Scanner(file);
            sc.nextLine();
            secretKey = sc.nextLine();
            sc.close();
        } catch (FileNotFoundException e) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException();
            Exception ex = new Exception(fileNotFoundException);
            ex.initCause(fileNotFoundException);
            throw ex;

        }
        return secretKey;
    }

}