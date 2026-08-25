package com.transsion.subroom.activity;

import android.view.View;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* synthetic */ class j implements View.OnClickListener {
    public final /* synthetic */ MainActivity a;
    public final /* synthetic */ int b;

    public /* synthetic */ j(MainActivity mainActivity, int i) {
        this.a = mainActivity;
        this.b = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MainActivity.l0(this.a, this.b, view);
    }
}
