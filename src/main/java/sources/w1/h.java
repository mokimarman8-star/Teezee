package w1;

import android.net.Uri;
import androidx.media3.common.u;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f18098a;

    /* renamed from: b, reason: collision with root package name */
    public final long f18099b;

    /* renamed from: c, reason: collision with root package name */
    public final int f18100c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f18101d;

    /* renamed from: e, reason: collision with root package name */
    public final Map f18102e;

    /* renamed from: f, reason: collision with root package name */
    public final long f18103f;

    /* renamed from: g, reason: collision with root package name */
    public final long f18104g;

    /* renamed from: h, reason: collision with root package name */
    public final long f18105h;

    /* renamed from: i, reason: collision with root package name */
    public final String f18106i;

    /* renamed from: j, reason: collision with root package name */
    public final int f18107j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f18108k;

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private Uri f18109a;

        /* renamed from: b, reason: collision with root package name */
        private long f18110b;

        /* renamed from: c, reason: collision with root package name */
        private int f18111c;

        /* renamed from: d, reason: collision with root package name */
        private byte[] f18112d;

        /* renamed from: e, reason: collision with root package name */
        private Map f18113e;

        /* renamed from: f, reason: collision with root package name */
        private long f18114f;

        /* renamed from: g, reason: collision with root package name */
        private long f18115g;

        /* renamed from: h, reason: collision with root package name */
        private String f18116h;

        /* renamed from: i, reason: collision with root package name */
        private int f18117i;

        /* renamed from: j, reason: collision with root package name */
        private Object f18118j;

        public b() {
            this.f18111c = 1;
            this.f18113e = Collections.emptyMap();
            this.f18115g = -1L;
        }

        private b(h hVar) {
            this.f18109a = hVar.f18098a;
            this.f18110b = hVar.f18099b;
            this.f18111c = hVar.f18100c;
            this.f18112d = hVar.f18101d;
            this.f18113e = hVar.f18102e;
            this.f18114f = hVar.f18104g;
            this.f18115g = hVar.f18105h;
            this.f18116h = hVar.f18106i;
            this.f18117i = hVar.f18107j;
            this.f18118j = hVar.f18108k;
        }

        public h a() {
            androidx.media3.common.util.a.j(this.f18109a, "The uri must be set.");
            return new h(this.f18109a, this.f18110b, this.f18111c, this.f18112d, this.f18113e, this.f18114f, this.f18115g, this.f18116h, this.f18117i, this.f18118j);
        }

        public b b(int i5) {
            this.f18117i = i5;
            return this;
        }

        public b c(byte[] bArr) {
            this.f18112d = bArr;
            return this;
        }

        public b d(int i5) {
            this.f18111c = i5;
            return this;
        }

        public b e(Map map) {
            this.f18113e = map;
            return this;
        }

        public b f(String str) {
            this.f18116h = str;
            return this;
        }

        public b g(long j5) {
            this.f18115g = j5;
            return this;
        }

        public b h(long j5) {
            this.f18114f = j5;
            return this;
        }

        public b i(Uri uri) {
            this.f18109a = uri;
            return this;
        }

        public b j(String str) {
            this.f18109a = Uri.parse(str);
            return this;
        }

        public b k(long j5) {
            this.f18110b = j5;
            return this;
        }
    }

    static {
        u.a("media3.datasource");
    }

    private h(Uri uri, long j5, int i5, byte[] bArr, Map map, long j6, long j7, String str, int i6, Object obj) {
        byte[] bArr2 = bArr;
        long j8 = j5 + j6;
        androidx.media3.common.util.a.a(j8 >= 0);
        androidx.media3.common.util.a.a(j6 >= 0);
        androidx.media3.common.util.a.a(j7 > 0 || j7 == -1);
        this.f18098a = (Uri) androidx.media3.common.util.a.e(uri);
        this.f18099b = j5;
        this.f18100c = i5;
        this.f18101d = (bArr2 == null || bArr2.length == 0) ? null : bArr2;
        this.f18102e = Collections.unmodifiableMap(new HashMap(map));
        this.f18104g = j6;
        this.f18103f = j8;
        this.f18105h = j7;
        this.f18106i = str;
        this.f18107j = i6;
        this.f18108k = obj;
    }

    public h(Uri uri, long j5, long j6) {
        this(uri, j5, j6, null);
    }

    public h(Uri uri, long j5, long j6, String str) {
        this(uri, 0L, 1, null, Collections.emptyMap(), j5, j6, str, 0, null);
    }

    public static String c(int i5) {
        if (i5 == 1) {
            return "GET";
        }
        if (i5 == 2) {
            return "POST";
        }
        if (i5 == 3) {
            return "HEAD";
        }
        throw new IllegalStateException();
    }

    public b a() {
        return new b();
    }

    public final String b() {
        return c(this.f18100c);
    }

    public boolean d(int i5) {
        return (this.f18107j & i5) == i5;
    }

    public h e(long j5) {
        long j6 = this.f18105h;
        return f(j5, j6 != -1 ? j6 - j5 : -1L);
    }

    public h f(long j5, long j6) {
        return (j5 == 0 && this.f18105h == j6) ? this : new h(this.f18098a, this.f18099b, this.f18100c, this.f18101d, this.f18102e, this.f18104g + j5, j6, this.f18106i, this.f18107j, this.f18108k);
    }

    public h g(Uri uri) {
        return new h(uri, this.f18099b, this.f18100c, this.f18101d, this.f18102e, this.f18104g, this.f18105h, this.f18106i, this.f18107j, this.f18108k);
    }

    public String toString() {
        return "DataSpec[" + b() + " " + this.f18098a + ", " + this.f18104g + ", " + this.f18105h + ", " + this.f18106i + ", " + this.f18107j + "]";
    }
}
