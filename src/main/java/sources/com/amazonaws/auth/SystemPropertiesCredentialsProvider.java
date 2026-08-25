package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;

@Deprecated
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class SystemPropertiesCredentialsProvider implements AWSCredentialsProvider {
    @Override // com.amazonaws.auth.AWSCredentialsProvider
    public AWSCredentials a() {
        if (System.getProperty("aws.accessKeyId") == null || System.getProperty("aws.secretKey") == null) {
            throw new AmazonClientException("Unable to load AWS credentials from Java system properties (aws.accessKeyId and aws.secretKey)");
        }
        return new BasicAWSCredentials(System.getProperty("aws.accessKeyId"), System.getProperty("aws.secretKey"));
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
