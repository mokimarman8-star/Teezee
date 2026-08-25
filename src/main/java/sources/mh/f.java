package mh;

import android.os.SystemClock;
import com.cloud.tmc.kernel.bridge.RenderCallContext;
import com.cloud.tmc.kernel.utils.UrlUtils;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.TlsVersion;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class f extends EventListener implements i {
    private final EventListener a;
    private final int b;
    private final boolean c;
    private final String d;
    private final boolean e;
    private final boolean f;
    private long g;
    private long h;
    private long i;
    private long j;
    private long k;
    private long l;
    private long m;
    private long n;
    private final e o;
    private boolean p;
    private long q;
    private int r;
    private int s;
    private String t;
    private final int u;

    public f(EventListener eventListener, int i, boolean z, String str, boolean z2, String str2, boolean z3, boolean z4) {
        this.a = eventListener;
        this.b = i;
        this.c = z;
        this.d = str2;
        this.e = z3;
        this.f = z4;
        this.o = e.J.a(i, str);
        this.p = z || z2;
        this.r = 480;
        this.s = 480;
        this.t = "Unknown";
        this.u = RangesKt.p(new IntRange(1, 10), Random.Default);
    }

    private final boolean b() {
        k kVar = k.a;
        return kVar.f() || SystemClock.uptimeMillis() - kVar.b() > 3000;
    }

    @Override // mh.i
    public void a(Request request, int i) {
        Intrinsics.h(request, "request");
        c.c("[onDowngrade]");
        if (!this.c) {
            this.p = false;
        }
        this.o.d0(i);
    }

    public void callEnd(Call call) {
        Intrinsics.h(call, RenderCallContext.TYPE_CALL);
        super.callEnd(call);
        c.c("[callEnd]");
        e eVar = this.o;
        eVar.I(1);
        eVar.c0(c.e(this.g));
        eVar.S(this.r);
        if (eVar.m() != 304 && !this.p) {
            c.g(eVar);
        }
        EventListener eventListener = this.a;
        if (eventListener != null) {
            eventListener.callEnd(call);
        }
    }

    public void callFailed(Call call, IOException iOException) {
        Intrinsics.h(call, RenderCallContext.TYPE_CALL);
        Intrinsics.h(iOException, "ioe");
        super.callFailed(call, iOException);
        c.b("[callFailed]  " + iOException.getClass().getSimpleName() + " : " + iOException.getMessage());
        this.o.I(2);
        if (b()) {
            k kVar = k.a;
            if (!kVar.g()) {
                this.s = 1020;
                this.t = "Network disconnect";
            } else if (kVar.e()) {
                this.s = 1021;
                this.t = "Fake Network";
            } else {
                this.s = a.a.a(this.r, iOException);
            }
        } else {
            this.s = a.a.a(this.r, iOException);
        }
        this.o.S(this.s);
        this.o.T(Intrinsics.c(this.t, "Unknown") ? c.f(iOException) : this.t);
        if (!this.p) {
            if ((this.f && this.s == 1020) ? false : (this.e && this.s == 1050) ? false : true) {
                c.g(this.o);
            }
        }
        EventListener eventListener = this.a;
        if (eventListener != null) {
            eventListener.callFailed(call, iOException);
        }
    }

    public void callStart(Call call) {
        int i;
        Intrinsics.h(call, RenderCallContext.TYPE_CALL);
        super.callStart(call);
        c.c("[callStart]");
        try {
            String str = call.request().headers().get("isDownload");
            if (str != null) {
                e eVar = this.o;
                if (!Intrinsics.c(str, "true") && !Intrinsics.c(str, "T")) {
                    i = 0;
                    eVar.l0(i);
                }
                i = 1;
                eVar.l0(i);
            }
            String str2 = call.request().headers().get("offlineAd");
            if (str2 != null) {
                this.o.X(Integer.parseInt(str2));
            }
            String host = call.request().url().host();
            String encodedPath = call.request().url().encodedPath();
            e eVar2 = this.o;
            String str3 = "";
            if (encodedPath == null) {
                encodedPath = "";
            }
            eVar2.Y(encodedPath);
            e eVar3 = this.o;
            if (host == null) {
                host = "";
            }
            eVar3.U(host);
            String httpUrl = call.request().url().toString();
            Intrinsics.g(httpUrl, "call.request().url().toString()");
            this.o.P(this.u <= 2 ? httpUrl : "");
            e eVar4 = this.o;
            if (this.b == 0 && StringsKt.c0(httpUrl, UrlUtils.QUESTION_MARK, false, 2, (Object) null)) {
                httpUrl = httpUrl.substring(0, StringsKt.o0(httpUrl, UrlUtils.QUESTION_MARK, 0, false, 6, (Object) null));
                Intrinsics.g(httpUrl, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            eVar4.g0(httpUrl);
            String str4 = call.request().headers().get("infoeyes-tag");
            e eVar5 = this.o;
            if (str4 != null || (str4 = this.d) != null) {
                str3 = str4;
            }
            eVar5.O(str3);
        } catch (Exception e) {
            c.b("[get header exception] " + e.getClass().getSimpleName() + " : " + e.getMessage());
        }
        this.g = c.d();
        EventListener eventListener = this.a;
        if (eventListener != null) {
            eventListener.callStart(call);
        }
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        String str;
        Intrinsics.h(call, RenderCallContext.TYPE_CALL);
        Intrinsics.h(inetSocketAddress, "inetSocketAddress");
        Intrinsics.h(proxy, "proxy");
        super.connectEnd(call, inetSocketAddress, proxy, protocol);
        c.c("[connectEnd] inetSocketAddress " + inetSocketAddress);
        this.o.j0(c.e(this.j));
        e eVar = this.o;
        if (protocol == null || (str = protocol.name()) == null) {
            str = "";
        }
        eVar.Z(str);
        EventListener eventListener = this.a;
        if (eventListener != null) {
            eventListener.connectEnd(call, inetSocketAddress, proxy, protocol);
        }
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        String str;
        Intrinsics.h(call, RenderCallContext.TYPE_CALL);
        Intrinsics.h(inetSocketAddress, "inetSocketAddress");
        Intrinsics.h(proxy, "proxy");
        Intrinsics.h(iOException, "ioe");
        super.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
        c.b("[connectFailed] " + iOException.getClass().getSimpleName() + " : " + iOException.getMessage());
        e eVar = this.o;
        if (protocol == null || (str = protocol.name()) == null) {
            str = "";
        }
        eVar.Z(str);
        EventListener eventListener = this.a;
        if (eventListener != null) {
            eventListener.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
        }
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        Intrinsics.h(call, RenderCallContext.TYPE_CALL);
        Intrinsics.h(inetSocketAddress, "inetSocketAddress");
        Intrinsics.h(proxy, "proxy");
        super.connectStart(call, inetSocketAddress, proxy);
        this.j = c.d();
        e eVar = this.o;
        String hostAddress = inetSocketAddress.getAddress().getHostAddress();
        if (hostAddress == null) {
            hostAddress = "";
        }
        eVar.W(hostAddress);
        c.c("[connectStart] inetSocketAddress : " + inetSocketAddress + ", proxy : " + proxy);
        EventListener eventListener = this.a;
        if (eventListener != null) {
            eventListener.connectStart(call, inetSocketAddress, proxy);
        }
    }

    public void connectionAcquired(Call call, Connection connection) {
        String str;
        TlsVersion tlsVersion;
        Intrinsics.h(call, RenderCallContext.TYPE_CALL);
        Intrinsics.h(connection, "connection");
        super.connectionAcquired(call, connection);
        c.c("[connectionAcquired] connection: " + connection);
        e eVar = this.o;
        Handshake handshake = connection.handshake();
        if (handshake == null || (tlsVersion = handshake.tlsVersion()) == null || (str = tlsVersion.name()) == null) {
            str = "";
        }
        eVar.k0(str);
        this.o.Z(connection.protocol().name());
        EventListener eventListener = this.a;
        if (eventListener != null) {
            eventListener.connectionAcquired(call, connection);
        }
    }

    public void connectionReleased(Call call, Connection connection) {
        Intrinsics.h(call, RenderCallContext.TYPE_CALL);
        Intrinsics.h(connection, "connection");
        super.connectionReleased(call, connection);
        c.c("[connectionReleased]");
        EventListener eventListener = this.a;
        if (eventListener != null) {
            eventListener.connectionReleased(call, connection);
        }
    }

    public void dnsEnd(Call call, String str, List list) {
        Intrinsics.h(call, RenderCallContext.TYPE_CALL);
        Intrinsics.h(str, "domainName");
        Intrinsics.h(list, "inetAddressList");
        super.dnsEnd(call, str, list);
        c.c("[dnsEnd] inetAddressList " + CollectionsKt.s0(list, ",", "[", "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null));
        this.o.R(c.e(this.h));
        EventListener eventListener = this.a;
        if (eventListener != null) {
            eventListener.dnsEnd(call, str, list);
        }
    }

    public void dnsStart(Call call, String str) {
        Intrinsics.h(call, RenderCallContext.TYPE_CALL);
        Intrinsics.h(str, "domainName");
        super.dnsStart(call, str);
        c.c("[dnsStart] domainName: " + str);
        this.h = c.d();
        EventListener eventListener = this.a;
        if (eventListener != null) {
            eventListener.dnsStart(call, str);
        }
    }

    public void requestBodyEnd(Call call, long j) {
        Intrinsics.h(call, RenderCallContext.TYPE_CALL);
        super.requestBodyEnd(call, j);
        c.c("[requestBodyEnd] byteCount: " + j);
        this.m = c.d();
        e eVar = this.o;
        eVar.b0(j);
        eVar.f0(this.m - this.k);
        EventListener eventListener = this.a;
        if (eventListener != null) {
            eventListener.requestBodyEnd(call, j);
        }
    }

    public void requestBodyStart(Call call) {
        Intrinsics.h(call, RenderCallContext.TYPE_CALL);
        super.requestBodyStart(call);
        c.c("[requestBodyStart]");
        EventListener eventListener = this.a;
        if (eventListener != null) {
            eventListener.requestBodyStart(call);
        }
    }

    public void requestFailed(Call call, IOException iOException) {
        Intrinsics.h(call, RenderCallContext.TYPE_CALL);
        Intrinsics.h(iOException, "ioe");
        super.requestFailed(call, iOException);
        c.b("[requestFailed] " + iOException.getClass().getSimpleName() + " : " + iOException.getMessage());
        EventListener eventListener = this.a;
        if (eventListener != null) {
            eventListener.requestFailed(call, iOException);
        }
    }

    public void requestHeadersEnd(Call call, Request request) {
        Intrinsics.h(call, RenderCallContext.TYPE_CALL);
        Intrinsics.h(request, "request");
        super.requestHeadersEnd(call, request);
        c.c("[requestHeadersEnd] request :" + request);
        long d = c.d();
        this.l = d;
        this.o.f0(d - this.k);
        EventListener eventListener = this.a;
        if (eventListener != null) {
            eventListener.requestHeadersEnd(call, request);
        }
    }

    public void requestHeadersStart(Call call) {
        Intrinsics.h(call, RenderCallContext.TYPE_CALL);
        super.requestHeadersStart(call);
        c.c("[requestHeadersStart]");
        this.k = c.d();
        EventListener eventListener = this.a;
        if (eventListener != null) {
            eventListener.requestHeadersStart(call);
        }
    }

    public void responseBodyEnd(Call call, long j) {
        Intrinsics.h(call, RenderCallContext.TYPE_CALL);
        super.responseBodyEnd(call, j);
        c.c("[responseBodyEnd] byteCount: " + j);
        e eVar = this.o;
        eVar.e0(j);
        eVar.a0(c.e(this.n));
        eVar.J(c.e(this.q));
        eVar.M(String.valueOf((j / 1024.0f) / (eVar.c() / 1000.0f)));
        EventListener eventListener = this.a;
        if (eventListener != null) {
            eventListener.responseBodyEnd(call, j);
        }
    }

    public void responseBodyStart(Call call) {
        Intrinsics.h(call, RenderCallContext.TYPE_CALL);
        super.responseBodyStart(call);
        c.c("[responseBodyStart]");
        EventListener eventListener = this.a;
        if (eventListener != null) {
            eventListener.responseBodyStart(call);
        }
    }

    public void responseFailed(Call call, IOException iOException) {
        Intrinsics.h(call, RenderCallContext.TYPE_CALL);
        Intrinsics.h(iOException, "ioe");
        super.responseFailed(call, iOException);
        c.b("[responseFailed] " + iOException.getClass().getSimpleName() + " : " + iOException.getMessage());
        EventListener eventListener = this.a;
        if (eventListener != null) {
            eventListener.responseFailed(call, iOException);
        }
    }

    public void responseHeadersEnd(Call call, Response response) {
        Intrinsics.h(call, RenderCallContext.TYPE_CALL);
        Intrinsics.h(response, "response");
        super.responseHeadersEnd(call, response);
        c.c("[responseHeadersEnd] code : " + response.code());
        String str = response.headers().get("x-response-cdn");
        if (str == null) {
            str = "";
        }
        String str2 = response.headers().get("server-time");
        if (str2 == null) {
            str2 = "0";
        }
        long parseLong = Long.parseLong(str2);
        c.c(str);
        this.o.K(str);
        this.q = c.d();
        this.o.a0(c.e(this.n));
        this.o.L(c.e(this.g));
        this.o.h0(parseLong);
        this.r = response.code();
        EventListener eventListener = this.a;
        if (eventListener != null) {
            eventListener.responseHeadersEnd(call, response);
        }
    }

    public void responseHeadersStart(Call call) {
        Intrinsics.h(call, RenderCallContext.TYPE_CALL);
        super.responseHeadersStart(call);
        c.c("[responseHeadersStart]");
        long d = c.d();
        this.n = d;
        this.o.m0(d - Math.max(this.m, this.l));
        EventListener eventListener = this.a;
        if (eventListener != null) {
            eventListener.responseHeadersStart(call);
        }
    }

    public void secureConnectEnd(Call call, Handshake handshake) {
        String str;
        TlsVersion tlsVersion;
        Intrinsics.h(call, RenderCallContext.TYPE_CALL);
        super.secureConnectEnd(call, handshake);
        c.c("[secureConnectEnd]");
        e eVar = this.o;
        if (handshake == null || (tlsVersion = handshake.tlsVersion()) == null || (str = tlsVersion.name()) == null) {
            str = "";
        }
        eVar.k0(str);
        this.o.i0(c.e(this.i));
        EventListener eventListener = this.a;
        if (eventListener != null) {
            eventListener.secureConnectEnd(call, handshake);
        }
    }

    public void secureConnectStart(Call call) {
        Intrinsics.h(call, RenderCallContext.TYPE_CALL);
        super.secureConnectStart(call);
        c.c("[secureConnectStart]");
        this.i = c.d();
        EventListener eventListener = this.a;
        if (eventListener != null) {
            eventListener.secureConnectStart(call);
        }
    }
}
