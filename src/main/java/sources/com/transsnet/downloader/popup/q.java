package com.transsnet.downloader.popup;

import android.view.View;
import com.blankj.utilcode.util.y;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class q {
    public static final q a = new q();

    private q() {
    }

    public final int[] a(View anchorView, View contentView) {
        Intrinsics.h(anchorView, "anchorView");
        Intrinsics.h(contentView, "contentView");
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        anchorView.getLocationOnScreen(iArr2);
        int height = anchorView.getHeight();
        int c = y.c();
        int e = y.e();
        contentView.measure(0, 0);
        int measuredHeight = contentView.getMeasuredHeight();
        int measuredWidth = contentView.getMeasuredWidth();
        int i = iArr2[1];
        if ((c - i) - height < measuredHeight) {
            iArr[0] = e - measuredWidth;
            iArr[1] = i - measuredHeight;
        } else {
            iArr[0] = e - measuredWidth;
            iArr[1] = i + height;
        }
        return iArr;
    }
}
