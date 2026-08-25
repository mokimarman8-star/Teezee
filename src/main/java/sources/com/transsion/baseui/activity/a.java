package com.transsion.baseui.activity;

import android.view.View;
import com.tn.lib.view.DefaultView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* synthetic */ class a implements View.OnClickListener {
    public final /* synthetic */ BaseActivity a;
    public final /* synthetic */ DefaultView b;

    public /* synthetic */ a(BaseActivity baseActivity, DefaultView defaultView) {
        this.a = baseActivity;
        this.b = defaultView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        BaseActivity.W(this.a, this.b, view);
    }
}
