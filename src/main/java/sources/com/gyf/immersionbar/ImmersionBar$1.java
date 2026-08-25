package com.gyf.immersionbar;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class ImmersionBar$1 implements Runnable {
    final /* synthetic */ Integer val$finalFitsHeight;
    final /* synthetic */ ViewGroup.LayoutParams val$finalLayoutParams;
    final /* synthetic */ int val$statusBarHeight;
    final /* synthetic */ View val$v;

    ImmersionBar$1(ViewGroup.LayoutParams layoutParams, View view, int i, Integer num) {
        this.val$finalLayoutParams = layoutParams;
        this.val$v = view;
        this.val$statusBarHeight = i;
        this.val$finalFitsHeight = num;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.val$finalLayoutParams.height = (this.val$v.getHeight() + this.val$statusBarHeight) - this.val$finalFitsHeight.intValue();
        View view = this.val$v;
        view.setPadding(view.getPaddingLeft(), (this.val$v.getPaddingTop() + this.val$statusBarHeight) - this.val$finalFitsHeight.intValue(), this.val$v.getPaddingRight(), this.val$v.getPaddingBottom());
        this.val$v.setLayoutParams(this.val$finalLayoutParams);
    }
}
