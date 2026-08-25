package com.chad.library.adapter.base.binder;

import android.view.View;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import f4.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00028\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0004\u001a\u00028\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/chad/library/adapter/base/binder/QuickViewBindingItemBinder$BinderVBHolder", "Lf4/a;", "VB", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "viewBinding", "<init>", "(Lf4/a;)V", "a", "Lf4/a;", "getViewBinding", "()Lf4/a;", "com.github.CymChad.brvah"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class QuickViewBindingItemBinder$BinderVBHolder<VB extends a> extends BaseViewHolder {

    /* renamed from: a, reason: from kotlin metadata */
    private final a viewBinding;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public QuickViewBindingItemBinder$BinderVBHolder(VB vb) {
        super(r0);
        Intrinsics.h(vb, "viewBinding");
        View root = vb.getRoot();
        Intrinsics.g(root, "viewBinding.root");
        this.viewBinding = vb;
    }
}
