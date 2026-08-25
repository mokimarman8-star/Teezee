package com.iab.omid.library.bytedance2.adsession;

import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public enum CreativeType {
    DEFINED_BY_JAVASCRIPT("definedByJavaScript"),
    HTML_DISPLAY("htmlDisplay"),
    NATIVE_DISPLAY("nativeDisplay"),
    VIDEO(MimeTypes.BASE_TYPE_VIDEO),
    AUDIO(MimeTypes.BASE_TYPE_AUDIO);

    private final String creativeType;

    CreativeType(String str) {
        this.creativeType = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.creativeType;
    }
}
