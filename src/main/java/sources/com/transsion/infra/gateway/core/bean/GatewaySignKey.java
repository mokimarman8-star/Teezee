package com.transsion.infra.gateway.core.bean;

import com.transsion.infra.gateway.core.sercurity.SignAlgorithm;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class GatewaySignKey {
    public SignAlgorithm algorithm;
    public String key;
    public int keyVersion;

    public GatewaySignKey(String str, int i, SignAlgorithm signAlgorithm) {
        this.key = str;
        this.keyVersion = i;
        this.algorithm = signAlgorithm;
    }

    public SignAlgorithm getAlgorithm() {
        return this.algorithm;
    }

    public String getKey() {
        return this.key;
    }

    public int getKeyVersion() {
        return this.keyVersion;
    }

    public void setAlgorithm(SignAlgorithm signAlgorithm) {
        this.algorithm = signAlgorithm;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setKeyVersion(int i) {
        this.keyVersion = i;
    }
}
