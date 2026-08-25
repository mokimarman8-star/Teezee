package com.google.common.collect;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public enum BoundType {
    OPEN(false),
    CLOSED(true);

    final boolean inclusive;

    BoundType(boolean z) {
        this.inclusive = z;
    }

    static BoundType forBoolean(boolean z) {
        return z ? CLOSED : OPEN;
    }
}
