package com.transsion.shorttv_pugc.base.adapter;

import android.view.View;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import f4.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00028\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0004\u001a\u00028\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/transsion/shorttv_pugc/base/adapter/BaseItemBindingProvider$BindingViewHolder", "Lf4/a;", "VB", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "binding", "<init>", "(Lf4/a;)V", "a", "Lf4/a;", "getBinding", "()Lf4/a;", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class BaseItemBindingProvider$BindingViewHolder<VB extends a> extends BaseViewHolder {

    /* renamed from: a, reason: from kotlin metadata */
    private final a binding;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BaseItemBindingProvider$BindingViewHolder(VB binding) {
        super(r0);
        Intrinsics.h(binding, "binding");
        View root = binding.getRoot();
        Intrinsics.g(root, "getRoot(...)");
        this.binding = binding;
    }
}
