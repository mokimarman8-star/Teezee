package com.airbnb.lottie;

import android.os.Build;
import java.util.HashSet;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class k0 {

    /* renamed from: a, reason: collision with root package name */
    private final HashSet f14384a = new HashSet();

    k0() {
    }

    public boolean a(LottieFeatureFlag lottieFeatureFlag, boolean z5) {
        if (!z5) {
            return this.f14384a.remove(lottieFeatureFlag);
        }
        if (Build.VERSION.SDK_INT >= lottieFeatureFlag.minRequiredSdkVersion) {
            return this.f14384a.add(lottieFeatureFlag);
        }
        x4.f.c(String.format("%s is not supported pre SDK %d", lottieFeatureFlag.name(), Integer.valueOf(lottieFeatureFlag.minRequiredSdkVersion)));
        return false;
    }

    public boolean b(LottieFeatureFlag lottieFeatureFlag) {
        return this.f14384a.contains(lottieFeatureFlag);
    }
}
