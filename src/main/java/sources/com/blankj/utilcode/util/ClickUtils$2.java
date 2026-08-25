package com.blankj.utilcode.util;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class ClickUtils$2 implements Runnable {
    final /* synthetic */ int val$expandSizeBottom;
    final /* synthetic */ int val$expandSizeLeft;
    final /* synthetic */ int val$expandSizeRight;
    final /* synthetic */ int val$expandSizeTop;
    final /* synthetic */ View val$parentView;
    final /* synthetic */ View val$view;

    ClickUtils$2(View view, int i, int i2, int i3, int i4, View view2) {
        this.val$view = view;
        this.val$expandSizeTop = i;
        this.val$expandSizeBottom = i2;
        this.val$expandSizeLeft = i3;
        this.val$expandSizeRight = i4;
        this.val$parentView = view2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Rect rect = new Rect();
        this.val$view.getHitRect(rect);
        rect.top -= this.val$expandSizeTop;
        rect.bottom += this.val$expandSizeBottom;
        rect.left -= this.val$expandSizeLeft;
        rect.right += this.val$expandSizeRight;
        this.val$parentView.setTouchDelegate(new TouchDelegate(rect, this.val$view));
    }
}
