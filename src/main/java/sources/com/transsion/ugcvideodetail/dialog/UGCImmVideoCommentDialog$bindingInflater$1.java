package com.transsion.ugcvideodetail.dialog;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
/* synthetic */ class UGCImmVideoCommentDialog$bindingInflater$1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, iu.b> {
    public static final UGCImmVideoCommentDialog$bindingInflater$1 INSTANCE = new UGCImmVideoCommentDialog$bindingInflater$1();

    UGCImmVideoCommentDialog$bindingInflater$1() {
        super(3, iu.b.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/transsion/ugcvideodetail/databinding/DialogUgcImmVideoCommentBinding;", 0);
    }

    public final iu.b invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
        Intrinsics.h(p0, "p0");
        return iu.b.c(p0, viewGroup, z);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((LayoutInflater) obj, (ViewGroup) obj2, ((Boolean) obj3).booleanValue());
    }
}
