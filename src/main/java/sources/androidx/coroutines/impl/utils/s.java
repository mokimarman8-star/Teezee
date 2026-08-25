package androidx.coroutines.impl.utils;

import android.content.Context;
import android.os.PowerManager;
import androidx.coroutines.AbstractC0216j;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    private static final String f14119a;

    static {
        String i5 = AbstractC0216j.i("WakeLocks");
        Intrinsics.g(i5, "tagWithPrefix(\"WakeLocks\")");
        f14119a = i5;
    }

    public static final void a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        t tVar = t.f14120a;
        synchronized (tVar) {
            linkedHashMap.putAll(tVar.a());
            Unit unit = Unit.a;
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            PowerManager.WakeLock wakeLock = (PowerManager.WakeLock) entry.getKey();
            String str = (String) entry.getValue();
            if (wakeLock != null && wakeLock.isHeld()) {
                AbstractC0216j.e().k(f14119a, "WakeLock held for " + str);
            }
        }
    }

    public static final PowerManager.WakeLock b(Context context, String str) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "tag");
        Object systemService = context.getApplicationContext().getSystemService("power");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        String str2 = "WorkManager: " + str;
        PowerManager.WakeLock newWakeLock = ((PowerManager) systemService).newWakeLock(1, str2);
        t tVar = t.f14120a;
        synchronized (tVar) {
        }
        Intrinsics.g(newWakeLock, "wakeLock");
        return newWakeLock;
    }
}
