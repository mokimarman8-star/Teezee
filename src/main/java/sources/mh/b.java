package mh;

import android.os.SystemClock;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.utils.UrlUtils;
import java.net.URL;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import org.chromium.net.CronetException;
import org.chromium.net.NetworkException;
import org.chromium.net.RequestFinishedInfo;
import org.chromium.net.UrlResponseInfo;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class b {
    public static final b a = new b();

    private b() {
    }

    private final boolean a() {
        k kVar = k.a;
        return kVar.f() || SystemClock.uptimeMillis() - kVar.b() > 3000;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c3, code lost:
    
        if (r0.equals("T") == false) goto L49;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:141:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x014e  */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v3, types: [int] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v34, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(RequestFinishedInfo requestFinishedInfo, int i, String str, String str2, boolean z, boolean z2, boolean z3) {
        boolean z4;
        ?? r3;
        int b;
        String str3;
        long j;
        ?? r2;
        ?? r4;
        Object obj;
        boolean z5;
        String str4;
        int i2;
        Intrinsics.h(requestFinishedInfo, "requestInfo");
        Intrinsics.h(str, "channel");
        Intrinsics.h(str2, "tag");
        if (z2 && requestFinishedInfo.getFinishedReason() == 2) {
            return;
        }
        UrlResponseInfo responseInfo = requestFinishedInfo.getResponseInfo();
        String negotiatedProtocol = responseInfo != null ? responseInfo.getNegotiatedProtocol() : null;
        if (negotiatedProtocol == null) {
            negotiatedProtocol = "";
        }
        e a2 = e.J.a(i, str);
        a2.V(2);
        a2.Z(negotiatedProtocol);
        UrlResponseInfo responseInfo2 = requestFinishedInfo.getResponseInfo();
        int httpStatusCode = responseInfo2 != null ? responseInfo2.getHttpStatusCode() : 480;
        RequestFinishedInfo.Metrics metrics = requestFinishedInfo.getMetrics();
        int p = RangesKt.p(new IntRange(1, 10), Random.Default);
        String str5 = requestFinishedInfo.getUrl().toString();
        a2.P(p <= 2 ? str5 : "");
        try {
            Collection annotations = requestFinishedInfo.getAnnotations();
            Intrinsics.g(annotations, "requestInfo.annotations");
            Iterator it = annotations.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (obj instanceof Headers) {
                        break;
                    }
                }
            }
            Headers headers = obj instanceof Headers ? (Headers) obj : null;
            if (headers != null) {
                String str6 = headers.get("isDownload");
                if (str6 != null) {
                    int hashCode = str6.hashCode();
                    if (hashCode != 84) {
                        if (hashCode == 3569038 && str6.equals("true")) {
                            i2 = 1;
                        }
                        i2 = 0;
                    }
                    a2.l0(i2);
                }
                a2.X(Intrinsics.c(headers.get("offlineAd"), "1") ? 1 : 0);
            } else {
                headers = null;
            }
            String str7 = headers != null ? headers.get("infoeyes-tag") : null;
            if (str7 == null) {
                str7 = str2;
            }
            a2.O(str7);
        } catch (Exception e) {
            e = e;
            z4 = false;
        }
        if (a2.G() == 0) {
            if (StringsKt.c0(str5, UrlUtils.QUESTION_MARK, false, 2, (Object) null)) {
                z5 = false;
                try {
                    str4 = str5.substring(0, StringsKt.o0(str5, UrlUtils.QUESTION_MARK, 0, false, 6, (Object) null));
                    Intrinsics.g(str4, "this as java.lang.String…ing(startIndex, endIndex)");
                    z5 = z5;
                    a2.g0(str4);
                    String host = new URL(str5).getHost();
                    String path = new URL(str5).getPath();
                    Intrinsics.g(host, "host");
                    a2.U(host);
                    Intrinsics.g(path, TmcConstants.EXTRA_PATH);
                    a2.Y(path);
                    r3 = z5;
                } catch (Exception e2) {
                    e = e2;
                    z4 = z5;
                    String message = e.getMessage();
                    r3 = z4;
                    if (message != null) {
                        c.c(message);
                        r3 = z4;
                    }
                    if (requestFinishedInfo.getFinishedReason() == 0) {
                    }
                    a2.S(httpStatusCode);
                    if (z) {
                    }
                }
                if (requestFinishedInfo.getFinishedReason() == 0) {
                    a2.I(1);
                    Date dnsStart = metrics.getDnsStart();
                    long time = dnsStart != null ? dnsStart.getTime() : 0L;
                    Date dnsEnd = metrics.getDnsEnd();
                    a2.R((dnsEnd != null ? dnsEnd.getTime() : 0L) - time);
                    Date sslStart = metrics.getSslStart();
                    long time2 = sslStart != null ? sslStart.getTime() : 0L;
                    Date sslEnd = metrics.getSslEnd();
                    a2.i0((sslEnd != null ? sslEnd.getTime() : 0L) - time2);
                    Date connectStart = metrics.getConnectStart();
                    long time3 = connectStart != null ? connectStart.getTime() : 0L;
                    Date connectEnd = metrics.getConnectEnd();
                    a2.j0((connectEnd != null ? connectEnd.getTime() : 0L) - time3);
                    Date sendingStart = metrics.getSendingStart();
                    long time4 = sendingStart != null ? sendingStart.getTime() : 0L;
                    Date sendingEnd = metrics.getSendingEnd();
                    long time5 = sendingEnd != null ? sendingEnd.getTime() : 0L;
                    a2.f0(time5 - time4);
                    Date responseStart = metrics.getResponseStart();
                    long time6 = responseStart != null ? responseStart.getTime() : 0L;
                    Date requestEnd = metrics.getRequestEnd();
                    if (requestEnd != null) {
                        j = requestEnd.getTime();
                        str3 = "";
                    } else {
                        str3 = "";
                        j = 0;
                    }
                    a2.a0(j - time6);
                    a2.m0(time6 - time5);
                    Long receivedByteCount = metrics.getReceivedByteCount();
                    a2.e0(receivedByteCount == null ? 0L : receivedByteCount.longValue());
                    Long sentByteCount = metrics.getSentByteCount();
                    a2.b0(sentByteCount == null ? 0L : sentByteCount.longValue());
                    UrlResponseInfo responseInfo3 = requestFinishedInfo.getResponseInfo();
                    Map allHeaders = responseInfo3 != null ? responseInfo3.getAllHeaders() : null;
                    List list = allHeaders != null ? (List) allHeaders.get("Content-Encoding") : null;
                    if (list != null) {
                        Iterator it2 = list.iterator();
                        if (it2.hasNext()) {
                            String str8 = (String) it2.next();
                            Intrinsics.g(str8, "contentEncoding");
                            a2.Q(str8);
                        }
                    }
                    String str9 = (allHeaders == null || (r4 = (List) allHeaders.get("server-time")) == 0) ? null : (String) r4.get(r3);
                    if (str9 == null) {
                        str9 = "0";
                    }
                    a2.h0(Long.parseLong(str9));
                    Long totalTimeMs = metrics.getTotalTimeMs();
                    a2.c0(totalTimeMs == null ? 0L : totalTimeMs.longValue());
                    if (a2.G() == 1) {
                        String str10 = (allHeaders == null || (r2 = (List) allHeaders.get("x-response-cdn")) == 0) ? null : (String) r2.get(r3);
                        a2.K(str10 == null ? str3 : str10);
                        Date requestStart = metrics.getRequestStart();
                        a2.L(time6 - (requestStart != null ? requestStart.getTime() : 0L));
                        a2.J(a2.u());
                        a2.M(String.valueOf((a2.y() / 1024.0f) / (a2.u() / 1000.0f)));
                    }
                } else {
                    a2.I(2);
                    boolean z6 = requestFinishedInfo.getFinishedReason() != 2 ? r3 : true;
                    CronetException exception = requestFinishedInfo.getException();
                    String message2 = exception != null ? exception.getMessage() : null;
                    String str11 = message2 == null ? "" : message2;
                    if (requestFinishedInfo.getException() instanceof NetworkException) {
                        NetworkException exception2 = requestFinishedInfo.getException();
                        Intrinsics.f(exception2, "null cannot be cast to non-null type org.chromium.net.NetworkException");
                        NetworkException networkException = exception2;
                        if (a()) {
                            k kVar = k.a;
                            if (!kVar.g()) {
                                str11 = "Network disconnect";
                                httpStatusCode = 1020;
                            } else if (kVar.e()) {
                                b = 1021;
                                str11 = "Fake Network";
                            } else {
                                b = a.a.b(httpStatusCode, networkException, z6);
                            }
                        } else {
                            b = a.a.b(httpStatusCode, networkException, z6);
                        }
                        httpStatusCode = b;
                    } else {
                        httpStatusCode = z6 ? 1050 : 480;
                    }
                    a2.T(str11);
                }
                a2.S(httpStatusCode);
                if (z || httpStatusCode == 304) {
                }
                if (z3 && httpStatusCode == 1020) {
                    return;
                }
                c.g(a2);
                return;
            }
        }
        z5 = false;
        str4 = str5;
        a2.g0(str4);
        String host2 = new URL(str5).getHost();
        String path2 = new URL(str5).getPath();
        Intrinsics.g(host2, "host");
        a2.U(host2);
        Intrinsics.g(path2, TmcConstants.EXTRA_PATH);
        a2.Y(path2);
        r3 = z5;
        if (requestFinishedInfo.getFinishedReason() == 0) {
        }
        a2.S(httpStatusCode);
        if (z) {
        }
    }
}
