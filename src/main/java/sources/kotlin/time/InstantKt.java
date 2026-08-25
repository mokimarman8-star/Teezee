package kotlin.time;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.HttpUrl;
import okhttp3.internal.http2.Http2Connection;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\t\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0003¢\u0006\u0004\b\u0003\u0010\u0004\"\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007\"\u0014\u0010\t\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0007\"\u0014\u0010\u000b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0007\"\u0014\u0010\r\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0007¨\u0006\u000e"}, d2 = {"Lkotlin/time/Instant;", "instant", HttpUrl.FRAGMENT_ENCODE_SET, "b", "(Lkotlin/time/Instant;)Ljava/lang/String;", HttpUrl.FRAGMENT_ENCODE_SET, "a", "[I", "POWERS_OF_TEN", "asciiDigitPositionsInIsoStringAfterYear", "c", "colonsInIsoOffsetString", "d", "asciiDigitsInIsoOffsetString", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class InstantKt {
    private static final int[] a = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, Http2Connection.DEGRADED_PONG_TIMEOUT_NS};
    private static final int[] b = {1, 2, 4, 5, 7, 8, 10, 11, 13, 14};
    private static final int[] c = {3, 6};
    private static final int[] d = {1, 2, 4, 5, 7, 8};

    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(Instant instant) {
        int[] iArr;
        StringBuilder sb = new StringBuilder();
        UnboundLocalDateTime a2 = UnboundLocalDateTime.h.a(instant);
        int g = a2.g();
        int i = 0;
        if (Math.abs(g) < 1000) {
            StringBuilder sb2 = new StringBuilder();
            if (g >= 0) {
                sb2.append(g + 10000);
                Intrinsics.g(sb2.deleteCharAt(0), "deleteCharAt(...)");
            } else {
                sb2.append(g - 10000);
                Intrinsics.g(sb2.deleteCharAt(1), "deleteCharAt(...)");
            }
            sb.append((CharSequence) sb2);
        } else {
            if (g >= 10000) {
                sb.append('+');
            }
            sb.append(g);
        }
        sb.append('-');
        c(sb, sb, a2.d());
        sb.append('-');
        c(sb, sb, a2.a());
        sb.append('T');
        c(sb, sb, a2.b());
        sb.append(':');
        c(sb, sb, a2.c());
        sb.append(':');
        c(sb, sb, a2.f());
        if (a2.e() != 0) {
            sb.append('.');
            while (true) {
                int e = a2.e();
                iArr = a;
                int i2 = i + 1;
                if (e % iArr[i2] != 0) {
                    break;
                }
                i = i2;
            }
            int i3 = i - (i % 3);
            String valueOf = String.valueOf((a2.e() / iArr[i3]) + iArr[9 - i3]);
            Intrinsics.f(valueOf, "null cannot be cast to non-null type java.lang.String");
            String substring = valueOf.substring(1);
            Intrinsics.g(substring, "substring(...)");
            sb.append(substring);
        }
        sb.append('Z');
        return sb.toString();
    }

    private static final void c(Appendable appendable, StringBuilder sb, int i) {
        if (i < 10) {
            appendable.append('0');
        }
        sb.append(i);
    }
}
