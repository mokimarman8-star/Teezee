package com.cloud.tmc.miniapp.offlineapps;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public enum ScanType {
    LEVEL_0(0),
    LEVEL_1(1);

    private int type;

    ScanType(int i) {
        this.type = i;
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }
}
