package com.tencent.mmkv;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
/* synthetic */ class MMKV$a {
    static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[MMKVLogLevel.values().length];
        a = iArr;
        try {
            iArr[MMKVLogLevel.LevelDebug.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[MMKVLogLevel.LevelWarning.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[MMKVLogLevel.LevelError.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[MMKVLogLevel.LevelNone.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[MMKVLogLevel.LevelInfo.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
