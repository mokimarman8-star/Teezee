package com.amazonaws.services.s3.model;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class ReplicationRule {
    private String a;
    private String b;
    private ReplicationDestinationConfig c;

    public void a(ReplicationDestinationConfig replicationDestinationConfig) {
        if (replicationDestinationConfig == null) {
            throw new IllegalArgumentException("Destination cannot be null in the replication rule");
        }
        this.c = replicationDestinationConfig;
    }

    public void b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Prefix cannot be null for a replication rule");
        }
        this.a = str;
    }

    public void c(String str) {
        this.b = str;
    }
}
