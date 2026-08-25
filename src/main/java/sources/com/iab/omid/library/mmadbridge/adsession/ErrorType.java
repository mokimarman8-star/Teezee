package com.iab.omid.library.mmadbridge.adsession;

import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public enum ErrorType {
    GENERIC("generic"),
    VIDEO(MimeTypes.BASE_TYPE_VIDEO);

    private final String errorType;

    ErrorType(String str) {
        this.errorType = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.errorType;
    }
}
