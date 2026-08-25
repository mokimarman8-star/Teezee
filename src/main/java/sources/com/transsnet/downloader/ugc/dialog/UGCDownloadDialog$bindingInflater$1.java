package com.transsnet.downloader.ugc.dialog;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import bx.c1;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
/* synthetic */ class UGCDownloadDialog$bindingInflater$1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, c1> {
    public static final UGCDownloadDialog$bindingInflater$1 INSTANCE = new UGCDownloadDialog$bindingInflater$1();

    UGCDownloadDialog$bindingInflater$1() {
        super(3, c1.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/transsnet/downloader/databinding/UgcDialogDownloadPageBinding;", 0);
    }

    public final c1 invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
        Intrinsics.h(p0, "p0");
        return c1.c(p0, viewGroup, z);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((LayoutInflater) obj, (ViewGroup) obj2, ((Boolean) obj3).booleanValue());
    }
}
