package mh;

import android.os.Bundle;
import android.os.SystemClock;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class c {
    public static final Bundle a(e eVar) {
        Intrinsics.h(eVar, "<this>");
        return androidx.core.os.d.b(new Pair[]{TuplesKt.a("usage", Integer.valueOf(eVar.G())), TuplesKt.a("call_id", eVar.a()), TuplesKt.a("call_result_code", Integer.valueOf(eVar.b())), TuplesKt.a(OfflineConstantsKt.TRACK_KEY_PRE_ERROR_CODE, Integer.valueOf(eVar.m())), TuplesKt.a(OfflineConstantsKt.TRACK_KEY_PRE_ERROR_MSG, eVar.n()), TuplesKt.a(TmcConstants.CHANNEL_REQUEST_SERVER_API, eVar.B()), TuplesKt.a("complete_api", eVar.i()), TuplesKt.a("ip_address", eVar.q()), TuplesKt.a("req_time", Long.valueOf(eVar.w())), TuplesKt.a("dns_time", Long.valueOf(eVar.l())), TuplesKt.a("tcp_time", Long.valueOf(eVar.E())), TuplesKt.a("ssl_time", Long.valueOf(eVar.D())), TuplesKt.a("send_time", Long.valueOf(eVar.A())), TuplesKt.a("wait_time", Long.valueOf(eVar.H())), TuplesKt.a("rec_time", Long.valueOf(eVar.u())), TuplesKt.a("req_body_size", Long.valueOf(eVar.v())), TuplesKt.a("res_body_size", Long.valueOf(eVar.y())), TuplesKt.a("cdn_req_time", Long.valueOf(eVar.e())), TuplesKt.a("cdn_down_time", Long.valueOf(eVar.c())), TuplesKt.a("cdn_speed", eVar.f()), TuplesKt.a("cdn_provider", eVar.d()), TuplesKt.a("country", eVar.k()), TuplesKt.a("host", eVar.o()), TuplesKt.a("is_offline", Integer.valueOf(eVar.r())), TuplesKt.a("channel", eVar.g()), TuplesKt.a("sdk_version", eVar.z()), TuplesKt.a("server_time", Long.valueOf(eVar.C())), TuplesKt.a("protocol", eVar.t()), TuplesKt.a("compare_tag", eVar.h()), TuplesKt.a("http_type", Integer.valueOf(eVar.p())), TuplesKt.a("content_encoding", eVar.j()), TuplesKt.a("tls_version", eVar.F()), TuplesKt.a("request_downgrade", Integer.valueOf(eVar.x()))});
    }

    public static final void b(String str) {
        Intrinsics.h(str, "<this>");
        o.a.j("NetworkMonitor", new Object[]{"=======/ " + str + " /======="});
    }

    public static final void c(String str) {
        Intrinsics.h(str, "<this>");
        o.a.h("NetworkMonitor", new Object[]{"=======/ " + str + " /======="});
    }

    public static final long d() {
        return SystemClock.elapsedRealtime();
    }

    public static final long e(long j) {
        return d() - j;
    }

    public static final String f(Exception exc) {
        Intrinsics.h(exc, "<this>");
        if (exc.getMessage() == null) {
            return "";
        }
        String message = exc.getMessage();
        Intrinsics.e(message);
        int min = Math.min(message.length(), 200);
        String message2 = exc.getMessage();
        Intrinsics.e(message2);
        String substring = message2.substring(0, min);
        Intrinsics.g(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final void g(e eVar) {
        Intrinsics.h(eVar, "<this>");
        o.a.h("NetworkMonitor", new Object[]{eVar.toString()});
        new hi.a((d.b(eVar.o()) || l.a(eVar.s()) || n.a(eVar.B())) ? "process_black" : (d.c(eVar.o()) || l.b(eVar.s()) || n.b(eVar.B())) ? "process_white" : "process", 1814).c(a(eVar), (Bundle) null).b();
    }
}
