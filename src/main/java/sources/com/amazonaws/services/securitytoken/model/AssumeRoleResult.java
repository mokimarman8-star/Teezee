package com.amazonaws.services.securitytoken.model;

import java.io.Serializable;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class AssumeRoleResult implements Serializable {
    private AssumedRoleUser assumedRoleUser;
    private Credentials credentials;
    private Integer packedPolicySize;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AssumeRoleResult)) {
            return false;
        }
        AssumeRoleResult assumeRoleResult = (AssumeRoleResult) obj;
        if ((assumeRoleResult.getCredentials() == null) ^ (getCredentials() == null)) {
            return false;
        }
        if (assumeRoleResult.getCredentials() != null && !assumeRoleResult.getCredentials().equals(getCredentials())) {
            return false;
        }
        if ((assumeRoleResult.getAssumedRoleUser() == null) ^ (getAssumedRoleUser() == null)) {
            return false;
        }
        if (assumeRoleResult.getAssumedRoleUser() != null && !assumeRoleResult.getAssumedRoleUser().equals(getAssumedRoleUser())) {
            return false;
        }
        if ((assumeRoleResult.getPackedPolicySize() == null) ^ (getPackedPolicySize() == null)) {
            return false;
        }
        return assumeRoleResult.getPackedPolicySize() == null || assumeRoleResult.getPackedPolicySize().equals(getPackedPolicySize());
    }

    public AssumedRoleUser getAssumedRoleUser() {
        return this.assumedRoleUser;
    }

    public Credentials getCredentials() {
        return this.credentials;
    }

    public Integer getPackedPolicySize() {
        return this.packedPolicySize;
    }

    public int hashCode() {
        return (((((getCredentials() == null ? 0 : getCredentials().hashCode()) + 31) * 31) + (getAssumedRoleUser() == null ? 0 : getAssumedRoleUser().hashCode())) * 31) + (getPackedPolicySize() != null ? getPackedPolicySize().hashCode() : 0);
    }

    public void setAssumedRoleUser(AssumedRoleUser assumedRoleUser) {
        this.assumedRoleUser = assumedRoleUser;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public void setPackedPolicySize(Integer num) {
        this.packedPolicySize = num;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getCredentials() != null) {
            sb.append("Credentials: " + getCredentials() + ",");
        }
        if (getAssumedRoleUser() != null) {
            sb.append("AssumedRoleUser: " + getAssumedRoleUser() + ",");
        }
        if (getPackedPolicySize() != null) {
            sb.append("PackedPolicySize: " + getPackedPolicySize());
        }
        sb.append("}");
        return sb.toString();
    }

    public AssumeRoleResult withAssumedRoleUser(AssumedRoleUser assumedRoleUser) {
        this.assumedRoleUser = assumedRoleUser;
        return this;
    }

    public AssumeRoleResult withCredentials(Credentials credentials) {
        this.credentials = credentials;
        return this;
    }

    public AssumeRoleResult withPackedPolicySize(Integer num) {
        this.packedPolicySize = num;
        return this;
    }
}
