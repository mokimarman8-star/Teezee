package am;

import android.os.Bundle;
import android.os.SystemClock;
import androidx.collection.s;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e {
    public static final e a = new e();
    private static final ConcurrentHashMap b = new ConcurrentHashMap();
    private static final ConcurrentHashMap c = new ConcurrentHashMap();

    private e() {
    }

    public final List a(int i) {
        return (List) b.remove(Integer.valueOf(i));
    }

    public final int b(List list) {
        ConcurrentHashMap concurrentHashMap;
        Intrinsics.h(list, "preloadList");
        int hashCode = list.hashCode();
        while (true) {
            concurrentHashMap = b;
            if (!concurrentHashMap.containsKey(Integer.valueOf(hashCode))) {
                break;
            }
            hashCode = (hashCode << 1) | s.a(SystemClock.elapsedRealtimeNanos());
        }
        concurrentHashMap.put(Integer.valueOf(hashCode), list);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            b.g((b) it.next(), null, 1, null);
        }
        return hashCode;
    }

    public final int c(b... bVarArr) {
        Intrinsics.h(bVarArr, "preload");
        return b(ArraysKt.G0(bVarArr));
    }

    public final void d(String str, Bundle bundle) {
        List a2;
        c cVar = (c) c.get(str);
        if (cVar == null || (a2 = cVar.a(str, bundle)) == null) {
            return;
        }
        int b2 = a.b(a2);
        if (bundle != null) {
            bundle.putInt("yy_preload_id", b2);
        }
    }

    public final void e(c cVar) {
        Intrinsics.h(cVar, "interceptor");
        a.a.f(wf.a.a, "IPreload", "regInterceptor", false, 4, (Object) null);
        c.put(cVar.getPath(), cVar);
    }
}
