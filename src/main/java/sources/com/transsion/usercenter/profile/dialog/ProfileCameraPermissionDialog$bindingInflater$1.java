package com.transsion.usercenter.profile.dialog;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import xu.c0;

@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
/* synthetic */ class ProfileCameraPermissionDialog$bindingInflater$1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, c0> {
    public static final ProfileCameraPermissionDialog$bindingInflater$1 INSTANCE = new ProfileCameraPermissionDialog$bindingInflater$1();

    ProfileCameraPermissionDialog$bindingInflater$1() {
        super(3, c0.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/transsion/usercenter/databinding/DialogProfileCameraPermissionBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((LayoutInflater) obj, (ViewGroup) obj2, ((Boolean) obj3).booleanValue());
    }

    public final c0 invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
        Intrinsics.h(p0, "p0");
        return c0.c(p0, viewGroup, z);
    }
}
