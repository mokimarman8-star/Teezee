package com.transsion.spwaitkiller.gchacker;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/transsion/spwaitkiller/gchacker/GCHacker;", "", "<init>", "()V", "TAG", "", "hookGCTimeout", "", "SpWaitKiller_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class GCHacker {
    public static final GCHacker INSTANCE = new GCHacker();
    private static final String TAG = "GCHacker";

    private GCHacker() {
    }

    public final void hookGCTimeout() {
        try {
            Class<?> cls = Class.forName("java.lang.Daemons$FinalizerWatchdogDaemon");
            Field declaredField = cls.getDeclaredField("INSTANCE");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            try {
                Field declaredField2 = cls.getSuperclass().getDeclaredField("thread");
                Intrinsics.g(declaredField2, "getDeclaredField(...)");
                declaredField2.setAccessible(true);
                declaredField2.set(obj, null);
                Unit unit = Unit.a;
            } catch (Throwable th) {
                a.a.f(a.a, TAG, "stopWatchDog, set null occur error:" + th, false, 4, (Object) null);
                th.printStackTrace();
                try {
                    Method declaredMethod = cls.getSuperclass().getDeclaredMethod("stop", null);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(obj, null);
                } catch (Throwable unused) {
                    a.a.f(a.a, TAG, "stopWatchDog, stop occur error:" + th, false, 4, (Object) null);
                    th.printStackTrace();
                    Unit unit2 = Unit.a;
                }
            }
        } catch (Throwable th2) {
            a.a.f(a.a, TAG, "stopWatchDog, get object occur error:" + th2, false, 4, (Object) null);
            th2.printStackTrace();
        }
    }
}
