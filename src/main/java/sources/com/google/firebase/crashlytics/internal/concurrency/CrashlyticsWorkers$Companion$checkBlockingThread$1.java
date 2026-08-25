package com.google.firebase.crashlytics.internal.concurrency;

import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
/* synthetic */ class CrashlyticsWorkers$Companion$checkBlockingThread$1 extends FunctionReferenceImpl implements Function0<Boolean> {
    CrashlyticsWorkers$Companion$checkBlockingThread$1(Object obj) {
        super(0, obj, CrashlyticsWorkers.Companion.class, "isBlockingThread", "isBlockingThread()Z", 0);
    }

    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Boolean m43invoke() {
        boolean l;
        l = ((CrashlyticsWorkers.Companion) ((CallableReference) this).receiver).l();
        return Boolean.valueOf(l);
    }
}
