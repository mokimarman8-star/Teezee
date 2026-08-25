package com.transsion.usercenter.setting.labelsfeedback;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;
import xu.f0;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class j extends RecyclerView.Adapter {

    public final class a extends RecyclerView.a0 {
        final /* synthetic */ j a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(j jVar, f0 binding) {
            super(binding.getRoot());
            Intrinsics.h(binding, "binding");
            this.a = jVar;
        }
    }

    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int i) {
        Intrinsics.h(holder, "holder");
    }

    public int getItemCount() {
        return 1;
    }

    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.h(parent, "parent");
        f0 c = f0.c(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.g(c, "inflate(...)");
        return new a(this, c);
    }
}
