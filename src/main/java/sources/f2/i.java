package f2;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class i {

    /* renamed from: h, reason: collision with root package name */
    private static final AtomicLong f15211h = new AtomicLong();

    /* renamed from: a, reason: collision with root package name */
    public final long f15212a;

    /* renamed from: b, reason: collision with root package name */
    public final w1.h f15213b;

    /* renamed from: c, reason: collision with root package name */
    public final Uri f15214c;

    /* renamed from: d, reason: collision with root package name */
    public final Map f15215d;

    /* renamed from: e, reason: collision with root package name */
    public final long f15216e;

    /* renamed from: f, reason: collision with root package name */
    public final long f15217f;

    /* renamed from: g, reason: collision with root package name */
    public final long f15218g;

    public i(long j5, w1.h hVar, long j6) {
        this(j5, hVar, hVar.f18098a, Collections.emptyMap(), j6, 0L, 0L);
    }

    public i(long j5, w1.h hVar, Uri uri, Map map, long j6, long j7, long j8) {
        this.f15212a = j5;
        this.f15213b = hVar;
        this.f15214c = uri;
        this.f15215d = map;
        this.f15216e = j6;
        this.f15217f = j7;
        this.f15218g = j8;
    }

    public static long a() {
        return f15211h.getAndIncrement();
    }
}
