package com.transsion.member;

import android.view.View;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* synthetic */ class s implements View.OnScrollChangeListener {
    public final /* synthetic */ gm.i a;
    public final /* synthetic */ MemberFragment b;

    public /* synthetic */ s(gm.i iVar, MemberFragment memberFragment) {
        this.a = iVar;
        this.b = memberFragment;
    }

    @Override // android.view.View.OnScrollChangeListener
    public final void onScrollChange(View view, int i, int i2, int i3, int i4) {
        MemberFragment.t0(this.a, this.b, view, i, i2, i3, i4);
    }
}
