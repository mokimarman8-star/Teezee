package com.amazonaws.auth.policy.actions;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public enum SecurityTokenServiceActions {
    AllSecurityTokenServiceActions("sts:*"),
    AssumeRole("sts:AssumeRole"),
    AssumeRoleWithSAML("sts:AssumeRoleWithSAML"),
    AssumeRoleWithWebIdentity("sts:AssumeRoleWithWebIdentity"),
    DecodeAuthorizationMessage("sts:DecodeAuthorizationMessage"),
    GetAccessKeyInfo("sts:GetAccessKeyInfo"),
    GetCallerIdentity("sts:GetCallerIdentity"),
    GetFederationToken("sts:GetFederationToken"),
    GetSessionToken("sts:GetSessionToken");

    private final String action;

    SecurityTokenServiceActions(String str) {
        this.action = str;
    }

    public String getActionName() {
        return this.action;
    }
}
