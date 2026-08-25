package com.cloud.tmc.miniapp.base;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public enum ShowPageStatus {
    SHOULDOVERRIDEURKLOADING(1),
    PAGE_START(2),
    PAGE_PROGRESS100(3),
    PAGE_FINISHED(4);

    private int type;

    ShowPageStatus(int i) {
        this.type = i;
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }
}
