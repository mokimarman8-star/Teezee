package com.therouter.history;

import com.therouter.TheRouterThreadPool;
import com.therouter.inject.RecyclerLruCache;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class HistoryRecorder {
    private static long a = 0;
    private static int b = 30;
    private static final RecyclerLruCache c;
    private static final WeakHashMap d;

    static {
        RecyclerLruCache recyclerLruCache = new RecyclerLruCache(b);
        recyclerLruCache.a(new Function3<String, d, d, Unit>() { // from class: com.therouter.history.HistoryRecorder$mCacher$1$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((String) obj, (d) obj2, (d) obj3);
                return Unit.a;
            }

            public final void invoke(String str, d dVar, d dVar2) {
                WeakHashMap weakHashMap;
                weakHashMap = HistoryRecorder.d;
                weakHashMap.put(str, dVar);
            }
        });
        c = recyclerLruCache;
        d = new WeakHashMap();
    }

    public static final boolean c(final d dVar) {
        Intrinsics.h(dVar, "event");
        return TheRouterThreadPool.g(new Runnable() { // from class: com.therouter.history.e
            @Override // java.lang.Runnable
            public final void run() {
                HistoryRecorder.d(d.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(d dVar) {
        Intrinsics.h(dVar, "$event");
        RecyclerLruCache recyclerLruCache = c;
        long j = a;
        a = 1 + j;
        recyclerLruCache.put(String.valueOf(j), dVar);
    }
}
