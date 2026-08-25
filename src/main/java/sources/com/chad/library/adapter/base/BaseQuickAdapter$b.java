package com.chad.library.adapter.base;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public /* synthetic */ class BaseQuickAdapter$b {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[BaseQuickAdapter$AnimationType.values().length];
        try {
            iArr[BaseQuickAdapter$AnimationType.AlphaIn.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[BaseQuickAdapter$AnimationType.ScaleIn.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr[BaseQuickAdapter$AnimationType.SlideInBottom.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr[BaseQuickAdapter$AnimationType.SlideInLeft.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr[BaseQuickAdapter$AnimationType.SlideInRight.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        a = iArr;
    }
}
