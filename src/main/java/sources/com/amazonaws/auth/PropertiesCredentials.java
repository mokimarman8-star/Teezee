package com.amazonaws.auth;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class PropertiesCredentials implements AWSCredentials {
    private final String a;
    private final String b;

    public PropertiesCredentials(File file) {
        if (!file.exists()) {
            throw new FileNotFoundException("File doesn't exist:  " + file.getAbsolutePath());
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            if (properties.getProperty("accessKey") != null && properties.getProperty("secretKey") != null) {
                this.a = properties.getProperty("accessKey");
                this.b = properties.getProperty("secretKey");
            } else {
                throw new IllegalArgumentException("The specified file (" + file.getAbsolutePath() + ") doesn't contain the expected properties 'accessKey' and 'secretKey'.");
            }
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public PropertiesCredentials(InputStream inputStream) {
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            if (properties.getProperty("accessKey") == null || properties.getProperty("secretKey") == null) {
                throw new IllegalArgumentException("The specified properties data doesn't contain the expected properties 'accessKey' and 'secretKey'.");
            }
            this.a = properties.getProperty("accessKey");
            this.b = properties.getProperty("secretKey");
        } finally {
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.amazonaws.auth.AWSCredentials
    public String b() {
        return this.a;
    }

    @Override // com.amazonaws.auth.AWSCredentials
    public String c() {
        return this.b;
    }
}
