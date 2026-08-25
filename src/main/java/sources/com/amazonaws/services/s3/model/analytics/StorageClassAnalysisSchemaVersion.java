package com.amazonaws.services.s3.model.analytics;

import java.io.Serializable;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public enum StorageClassAnalysisSchemaVersion implements Serializable {
    V_1("V_1");

    private final String version;

    StorageClassAnalysisSchemaVersion(String str) {
        this.version = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.version;
    }
}
