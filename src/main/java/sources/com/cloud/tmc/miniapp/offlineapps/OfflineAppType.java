package com.cloud.tmc.miniapp.offlineapps;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public enum OfflineAppType {
    OFFLINE_DOWNLOAD(1),
    USED(2);

    private int type;

    OfflineAppType(int i) {
        this.type = i;
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }
}
