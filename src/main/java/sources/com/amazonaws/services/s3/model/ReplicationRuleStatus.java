package com.amazonaws.services.s3.model;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public enum ReplicationRuleStatus {
    Enabled("Enabled"),
    Disabled(BucketLifecycleConfiguration.DISABLED);

    private final String status;

    ReplicationRuleStatus(String str) {
        this.status = str;
    }

    public String getStatus() {
        return this.status;
    }
}
