package n5;

import com.cloud.tmc.integration.event.EventConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import m5.d;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class a {
    private final LinkedHashMap a = new LinkedHashMap();
    private final Map b = new LinkedHashMap();
    private final List c = new ArrayList();

    public final void a(String str) {
        Intrinsics.h(str, "subtitleMd5");
        this.b.put(str, "");
    }

    public final void b(Function2 function2) {
        Intrinsics.h(function2, EventConstants.ABILITY_NAME_CALLBACK);
        if (this.c.contains(function2)) {
            return;
        }
        this.c.add(function2);
    }

    public final void c() {
        this.a.clear();
    }

    public final List d(String str) {
        Intrinsics.h(str, "subtitleMd5");
        return (List) this.a.get(str);
    }

    public final boolean e(String str) {
        Intrinsics.h(str, "subtitleMd5");
        return this.a.containsKey(str);
    }

    public final void f(String str, List list) {
        Intrinsics.h(str, "subtitleMd5");
        Intrinsics.h(list, "subtitles");
        if (this.a.size() > 10) {
            try {
                Result.Companion companion = Result.Companion;
                Set keySet = this.a.keySet();
                Intrinsics.g(keySet, "subtitlesMap.keys");
                Object h0 = CollectionsKt.h0(keySet);
                Intrinsics.g(h0, "subtitlesMap.keys.first()");
                Result.constructor-impl((List) this.a.remove((String) h0));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.a(th));
            }
        }
        this.a.put(str, list);
    }

    public final boolean g() {
        return this.a.isEmpty();
    }

    public final boolean h(String str) {
        Intrinsics.h(str, "subtitleMd5");
        return this.b.containsKey(str);
    }

    public final void i(String str) {
        Intrinsics.h(str, "subtitleMd5");
        this.b.remove(str);
    }

    public final void j(String str) {
        Intrinsics.h(str, "subtitleMd5");
        this.a.remove(str);
    }

    public final void k(String str, d dVar) {
        Intrinsics.h(str, "subtitleMd5");
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((Function2) it.next()).invoke(str, dVar);
        }
        this.c.clear();
    }
}
