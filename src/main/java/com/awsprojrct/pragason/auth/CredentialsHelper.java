package com.awsprojrct.pragason.auth;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CredentialsHelper {
    public static String getAccessKey() {
        String accessKey = null;
        File file = new File("C:\\Users\\mlambokm\\Documents\\keys\\creds.txt");
        try {
            Scanner sc = new Scanner(file);
            accessKey = sc.nextLine();
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return accessKey;
    }

    public static String getSecretKey() {
        String secretKey = null;
        File file = new File("C:\\Users\\mlambokm\\Documents\\keys\\creds.txt");
        try {
            Scanner sc = new Scanner(file);
            sc.nextLine();
            secretKey = sc.nextLine();
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return secretKey;
    }

}