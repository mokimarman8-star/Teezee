package com.wecloud.load.lib;

import com.transsion.web.api.WebConstants;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class j {
    public static final j a = new j();
    private static final AtomicReference b = new AtomicReference(null);

    public interface a {
        void a(String str, Map map);
    }

    private j() {
    }

    public final void a(List results) {
        Intrinsics.h(results, "results");
        a aVar = (a) b.get();
        if (aVar == null) {
            return;
        }
        Iterator it = results.iterator();
        while (it.hasNext()) {
            aVar.a("network_probe", c((n) it.next()));
        }
    }

    public final void b(a aVar) {
        b.set(aVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0029, code lost:
    
        if (r5.isEmpty() == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Map c(n result) {
        Map map;
        Intrinsics.h(result, "result");
        String k = result.k();
        String str = null;
        if (StringsKt.q0(k)) {
            k = null;
        }
        boolean z = result.l() != 200;
        if (z) {
            map = result.g();
        }
        map = null;
        if (z) {
            String f = result.f();
            if (!StringsKt.q0(f)) {
                str = f;
            }
        }
        return MapsKt.k(TuplesKt.a(WebConstants.FIELD_URL, result.n()), TuplesKt.a("method", result.i()), TuplesKt.a("success", Boolean.valueOf(result.m())), TuplesKt.a("status_code", Integer.valueOf(result.l())), TuplesKt.a("duration", Long.valueOf(result.c())), TuplesKt.a("request_time", Long.valueOf(result.j())), TuplesKt.a("error_code", Integer.valueOf(result.d())), TuplesKt.a("error_message", result.e()), TuplesKt.a("server_ip", k), TuplesKt.a("http_headers", map), TuplesKt.a("http_body", str), TuplesKt.a("http_protocol", result.h()));
    }
}
