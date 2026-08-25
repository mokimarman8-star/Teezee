package com.amazonaws.auth.policy;

@Deprecated
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public enum STSActions {
    AssumeRole("sts:AssumeRole"),
    AssumeRoleWithWebIdentity("sts:AssumeRoleWithWebIdentity");

    private final String action;

    STSActions(String str) {
        this.action = str;
    }

    public String getActionName() {
        return this.action;
    }
}
