package com.gyf.immersionbar;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
/* synthetic */ class ImmersionBar$a {
    static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[BarHide.values().length];
        a = iArr;
        try {
            iArr[BarHide.FLAG_HIDE_BAR.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[BarHide.FLAG_HIDE_STATUS_BAR.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[BarHide.FLAG_HIDE_NAVIGATION_BAR.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[BarHide.FLAG_SHOW_BAR.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
