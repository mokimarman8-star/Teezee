package com.google.firebase.analytics;

import java.util.concurrent.Callable;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class b implements Callable {
    private final /* synthetic */ FirebaseAnalytics a;

    b(FirebaseAnalytics firebaseAnalytics) {
        this.a = firebaseAnalytics;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Object call() {
        return FirebaseAnalytics.a(this.a).zzc();
    }
}
