package com.transsion.subroom.activity;

import android.view.View;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* synthetic */ class l implements View.OnClickListener {
    public final /* synthetic */ MainActivity a;
    public final /* synthetic */ int b;

    public /* synthetic */ l(MainActivity mainActivity, int i) {
        this.a = mainActivity;
        this.b = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MainActivity.s0(this.a, this.b, view);
    }
}
