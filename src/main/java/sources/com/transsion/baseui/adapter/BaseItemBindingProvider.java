package com.transsion.baseui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import f4.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class BaseItemBindingProvider extends BaseItemProvider {
    public static final int f = 8;
    private final int e;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00028\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0004\u001a\u00028\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/transsion/baseui/adapter/BaseItemBindingProvider$BindingViewHolder;", "Lf4/a;", "VB", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "binding", "<init>", "(Lf4/a;)V", "a", "Lf4/a;", "f", "()Lf4/a;", "BaseUI_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BindingViewHolder<VB extends a> extends BaseViewHolder {

        /* renamed from: a, reason: from kotlin metadata */
        private final a binding;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public BindingViewHolder(VB vb) {
            super(r0);
            Intrinsics.h(vb, "binding");
            View root = vb.getRoot();
            Intrinsics.g(root, "getRoot(...)");
            this.binding = vb;
        }

        /* renamed from: f, reason: from getter */
        public final a getBinding() {
            return this.binding;
        }
    }

    public void b(BaseViewHolder baseViewHolder, Object obj) {
        Intrinsics.h(baseViewHolder, "helper");
        y(((BindingViewHolder) baseViewHolder).getBinding(), baseViewHolder, obj);
    }

    public final int m() {
        return this.e;
    }

    public BaseViewHolder r(ViewGroup viewGroup, int i) {
        Intrinsics.h(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        Intrinsics.e(from);
        return new BindingViewHolder(z(from, viewGroup));
    }

    public abstract void y(a aVar, BaseViewHolder baseViewHolder, Object obj);

    public abstract a z(LayoutInflater layoutInflater, ViewGroup viewGroup);
}
