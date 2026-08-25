package com.transsion.subroom.activity;

import android.widget.ImageView;
import kotlin.jvm.functions.Function1;
import qv.b;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* synthetic */ class k implements Function1 {
    public final /* synthetic */ MainActivity a;
    public final /* synthetic */ ImageView b;

    public /* synthetic */ k(MainActivity mainActivity, ImageView imageView) {
        this.a = mainActivity;
        this.b = imageView;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return MainActivity.v0(this.a, this.b, (b) obj);
    }
}
