package com.amazonaws.services.s3.model;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class ReplicationDestinationConfig {
    private String a;
    private String b;

    public void a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Bucket name cannot be null");
        }
        this.a = str;
    }

    public void b(String str) {
        this.b = str;
    }
}
