package com.transsion.baseui.activity;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* synthetic */ class c implements OnApplyWindowInsetsListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ BaseActivity b;

    public /* synthetic */ c(View view, BaseActivity baseActivity) {
        this.a = view;
        this.b = baseActivity;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return BaseActivity.X(this.a, this.b, view, windowInsetsCompat);
    }
}
