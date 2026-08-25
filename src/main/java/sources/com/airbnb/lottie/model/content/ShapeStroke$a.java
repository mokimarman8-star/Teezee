package com.airbnb.lottie.model.content;

import com.airbnb.lottie.model.content.ShapeStroke;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
/* synthetic */ class ShapeStroke$a {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f14424a;

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ int[] f14425b;

    static {
        int[] iArr = new int[ShapeStroke.LineJoinType.values().length];
        f14425b = iArr;
        try {
            iArr[ShapeStroke.LineJoinType.BEVEL.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f14425b[ShapeStroke.LineJoinType.MITER.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f14425b[ShapeStroke.LineJoinType.ROUND.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        int[] iArr2 = new int[ShapeStroke.LineCapType.values().length];
        f14424a = iArr2;
        try {
            iArr2[ShapeStroke.LineCapType.BUTT.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f14424a[ShapeStroke.LineCapType.ROUND.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f14424a[ShapeStroke.LineCapType.UNKNOWN.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
