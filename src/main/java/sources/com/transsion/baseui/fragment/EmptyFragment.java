package com.transsion.baseui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.transsion.gslb.BuildConfig;
import jj.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/transsion/baseui/fragment/EmptyFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Ljj/a;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "a0", "(Landroid/view/LayoutInflater;)Ljj/a;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", BuildConfig.FLAVOR, "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "lazyLoadData", "BaseUI_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class EmptyFragment extends BaseFragment<a> {
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public a getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        a c = a.c(inflater);
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public void initView(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
    }

    public void lazyLoadData() {
    }
}
