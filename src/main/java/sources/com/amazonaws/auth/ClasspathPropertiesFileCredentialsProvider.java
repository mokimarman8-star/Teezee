package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import java.io.IOException;
import java.io.InputStream;

@Deprecated
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class ClasspathPropertiesFileCredentialsProvider implements AWSCredentialsProvider {
    private static String b = "AwsCredentials.properties";
    private final String a;

    public ClasspathPropertiesFileCredentialsProvider() {
        this(b);
    }

    public ClasspathPropertiesFileCredentialsProvider(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Credentials file path cannot be null");
        }
        if (str.startsWith("/")) {
            this.a = str;
            return;
        }
        this.a = "/" + str;
    }

    @Override // com.amazonaws.auth.AWSCredentialsProvider
    public AWSCredentials a() {
        InputStream resourceAsStream = getClass().getResourceAsStream(this.a);
        if (resourceAsStream == null) {
            throw new AmazonClientException("Unable to load AWS credentials from the " + this.a + " file on the classpath");
        }
        try {
            return new PropertiesCredentials(resourceAsStream);
        } catch (IOException e) {
            throw new AmazonClientException("Unable to load AWS credentials from the " + this.a + " file on the classpath", e);
        }
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.a + ")";
    }
}
