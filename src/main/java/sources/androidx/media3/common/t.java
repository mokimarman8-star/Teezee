package androidx.media3.common;

import android.net.Uri;
import android.os.Bundle;
import androidx.media3.common.util.a1;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class t {

    /* renamed from: i, reason: collision with root package name */
    public static final t f8879i = new c().a();

    /* renamed from: j, reason: collision with root package name */
    private static final String f8880j = a1.C0(0);

    /* renamed from: k, reason: collision with root package name */
    private static final String f8881k = a1.C0(1);

    /* renamed from: l, reason: collision with root package name */
    private static final String f8882l = a1.C0(2);

    /* renamed from: m, reason: collision with root package name */
    private static final String f8883m = a1.C0(3);

    /* renamed from: n, reason: collision with root package name */
    private static final String f8884n = a1.C0(4);

    /* renamed from: o, reason: collision with root package name */
    private static final String f8885o = a1.C0(5);

    /* renamed from: a, reason: collision with root package name */
    public final String f8886a;

    /* renamed from: b, reason: collision with root package name */
    public final h f8887b;

    /* renamed from: c, reason: collision with root package name */
    public final h f8888c;

    /* renamed from: d, reason: collision with root package name */
    public final g f8889d;

    /* renamed from: e, reason: collision with root package name */
    public final v f8890e;

    /* renamed from: f, reason: collision with root package name */
    public final d f8891f;

    /* renamed from: g, reason: collision with root package name */
    public final e f8892g;

    /* renamed from: h, reason: collision with root package name */
    public final i f8893h;

    public static final class b {
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private String f8894a;

        /* renamed from: b, reason: collision with root package name */
        private Uri f8895b;

        /* renamed from: c, reason: collision with root package name */
        private String f8896c;

        /* renamed from: d, reason: collision with root package name */
        private d.a f8897d;

        /* renamed from: e, reason: collision with root package name */
        private f.a f8898e;

        /* renamed from: f, reason: collision with root package name */
        private List f8899f;

        /* renamed from: g, reason: collision with root package name */
        private String f8900g;

        /* renamed from: h, reason: collision with root package name */
        private ImmutableList f8901h;

        /* renamed from: i, reason: collision with root package name */
        private Object f8902i;

        /* renamed from: j, reason: collision with root package name */
        private long f8903j;

        /* renamed from: k, reason: collision with root package name */
        private v f8904k;

        /* renamed from: l, reason: collision with root package name */
        private g.a f8905l;

        /* renamed from: m, reason: collision with root package name */
        private i f8906m;

        public c() {
            this.f8897d = new d.a();
            this.f8898e = new f.a();
            this.f8899f = Collections.emptyList();
            this.f8901h = ImmutableList.of();
            this.f8905l = new g.a();
            this.f8906m = i.f8988d;
            this.f8903j = -9223372036854775807L;
        }

        private c(t tVar) {
            this();
            this.f8897d = tVar.f8891f.a();
            this.f8894a = tVar.f8886a;
            this.f8904k = tVar.f8890e;
            this.f8905l = tVar.f8889d.a();
            this.f8906m = tVar.f8893h;
            h hVar = tVar.f8887b;
            if (hVar != null) {
                this.f8900g = hVar.f8983e;
                this.f8896c = hVar.f8980b;
                this.f8895b = hVar.f8979a;
                this.f8899f = hVar.f8982d;
                this.f8901h = hVar.f8984f;
                this.f8902i = hVar.f8986h;
                f fVar = hVar.f8981c;
                this.f8898e = fVar != null ? fVar.b() : new f.a();
                this.f8903j = hVar.f8987i;
            }
        }

        public t a() {
            h hVar;
            androidx.media3.common.util.a.g(this.f8898e.f8948b == null || this.f8898e.f8947a != null);
            Uri uri = this.f8895b;
            if (uri != null) {
                hVar = new h(uri, this.f8896c, this.f8898e.f8947a != null ? this.f8898e.i() : null, null, this.f8899f, this.f8900g, this.f8901h, this.f8902i, this.f8903j);
            } else {
                hVar = null;
            }
            String str = this.f8894a;
            if (str == null) {
                str = "";
            }
            String str2 = str;
            e g5 = this.f8897d.g();
            g f5 = this.f8905l.f();
            v vVar = this.f8904k;
            if (vVar == null) {
                vVar = v.I;
            }
            return new t(str2, g5, hVar, f5, vVar, this.f8906m);
        }

        public c b(String str) {
            this.f8900g = str;
            return this;
        }

        public c c(g gVar) {
            this.f8905l = gVar.a();
            return this;
        }

        public c d(String str) {
            this.f8894a = (String) androidx.media3.common.util.a.e(str);
            return this;
        }

        public c e(String str) {
            this.f8896c = str;
            return this;
        }

        public c f(List list) {
            this.f8899f = (list == null || list.isEmpty()) ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(list));
            return this;
        }

        public c g(List list) {
            this.f8901h = ImmutableList.copyOf(list);
            return this;
        }

        public c h(Object obj) {
            this.f8902i = obj;
            return this;
        }

        public c i(Uri uri) {
            this.f8895b = uri;
            return this;
        }

        public c j(String str) {
            return i(str == null ? null : Uri.parse(str));
        }
    }

    public static class d {

        /* renamed from: h, reason: collision with root package name */
        public static final d f8907h = new a().f();

        /* renamed from: i, reason: collision with root package name */
        private static final String f8908i = a1.C0(0);

        /* renamed from: j, reason: collision with root package name */
        private static final String f8909j = a1.C0(1);

        /* renamed from: k, reason: collision with root package name */
        private static final String f8910k = a1.C0(2);

        /* renamed from: l, reason: collision with root package name */
        private static final String f8911l = a1.C0(3);

        /* renamed from: m, reason: collision with root package name */
        private static final String f8912m = a1.C0(4);

        /* renamed from: n, reason: collision with root package name */
        static final String f8913n = a1.C0(5);

        /* renamed from: o, reason: collision with root package name */
        static final String f8914o = a1.C0(6);

        /* renamed from: a, reason: collision with root package name */
        public final long f8915a;

        /* renamed from: b, reason: collision with root package name */
        public final long f8916b;

        /* renamed from: c, reason: collision with root package name */
        public final long f8917c;

        /* renamed from: d, reason: collision with root package name */
        public final long f8918d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f8919e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f8920f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f8921g;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private long f8922a;

            /* renamed from: b, reason: collision with root package name */
            private long f8923b;

            /* renamed from: c, reason: collision with root package name */
            private boolean f8924c;

            /* renamed from: d, reason: collision with root package name */
            private boolean f8925d;

            /* renamed from: e, reason: collision with root package name */
            private boolean f8926e;

            public a() {
                this.f8923b = Long.MIN_VALUE;
            }

            private a(d dVar) {
                this.f8922a = dVar.f8916b;
                this.f8923b = dVar.f8918d;
                this.f8924c = dVar.f8919e;
                this.f8925d = dVar.f8920f;
                this.f8926e = dVar.f8921g;
            }

            public d f() {
                return new d(this);
            }

            public e g() {
                return new e(this);
            }
        }

        private d(a aVar) {
            this.f8915a = a1.y1(aVar.f8922a);
            this.f8917c = a1.y1(aVar.f8923b);
            this.f8916b = aVar.f8922a;
            this.f8918d = aVar.f8923b;
            this.f8919e = aVar.f8924c;
            this.f8920f = aVar.f8925d;
            this.f8921g = aVar.f8926e;
        }

        public a a() {
            return new a();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f8916b == dVar.f8916b && this.f8918d == dVar.f8918d && this.f8919e == dVar.f8919e && this.f8920f == dVar.f8920f && this.f8921g == dVar.f8921g;
        }

        public int hashCode() {
            long j5 = this.f8916b;
            int i5 = ((int) (j5 ^ (j5 >>> 32))) * 31;
            long j6 = this.f8918d;
            return ((((((i5 + ((int) ((j6 >>> 32) ^ j6))) * 31) + (this.f8919e ? 1 : 0)) * 31) + (this.f8920f ? 1 : 0)) * 31) + (this.f8921g ? 1 : 0);
        }
    }

    public static final class e extends d {

        /* renamed from: p, reason: collision with root package name */
        public static final e f8927p = new d.a().g();

        private e(d.a aVar) {
            super(aVar);
        }
    }

    public static final class f {

        /* renamed from: l, reason: collision with root package name */
        private static final String f8928l = a1.C0(0);

        /* renamed from: m, reason: collision with root package name */
        private static final String f8929m = a1.C0(1);

        /* renamed from: n, reason: collision with root package name */
        private static final String f8930n = a1.C0(2);

        /* renamed from: o, reason: collision with root package name */
        private static final String f8931o = a1.C0(3);

        /* renamed from: p, reason: collision with root package name */
        static final String f8932p = a1.C0(4);

        /* renamed from: q, reason: collision with root package name */
        private static final String f8933q = a1.C0(5);

        /* renamed from: r, reason: collision with root package name */
        private static final String f8934r = a1.C0(6);

        /* renamed from: s, reason: collision with root package name */
        private static final String f8935s = a1.C0(7);

        /* renamed from: a, reason: collision with root package name */
        public final UUID f8936a;

        /* renamed from: b, reason: collision with root package name */
        public final UUID f8937b;

        /* renamed from: c, reason: collision with root package name */
        public final Uri f8938c;

        /* renamed from: d, reason: collision with root package name */
        public final ImmutableMap f8939d;

        /* renamed from: e, reason: collision with root package name */
        public final ImmutableMap f8940e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f8941f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f8942g;

        /* renamed from: h, reason: collision with root package name */
        public final boolean f8943h;

        /* renamed from: i, reason: collision with root package name */
        public final ImmutableList f8944i;

        /* renamed from: j, reason: collision with root package name */
        public final ImmutableList f8945j;

        /* renamed from: k, reason: collision with root package name */
        private final byte[] f8946k;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private UUID f8947a;

            /* renamed from: b, reason: collision with root package name */
            private Uri f8948b;

            /* renamed from: c, reason: collision with root package name */
            private ImmutableMap f8949c;

            /* renamed from: d, reason: collision with root package name */
            private boolean f8950d;

            /* renamed from: e, reason: collision with root package name */
            private boolean f8951e;

            /* renamed from: f, reason: collision with root package name */
            private boolean f8952f;

            /* renamed from: g, reason: collision with root package name */
            private ImmutableList f8953g;

            /* renamed from: h, reason: collision with root package name */
            private byte[] f8954h;

            private a() {
                this.f8949c = ImmutableMap.of();
                this.f8951e = true;
                this.f8953g = ImmutableList.of();
            }

            private a(f fVar) {
                this.f8947a = fVar.f8936a;
                this.f8948b = fVar.f8938c;
                this.f8949c = fVar.f8940e;
                this.f8950d = fVar.f8941f;
                this.f8951e = fVar.f8942g;
                this.f8952f = fVar.f8943h;
                this.f8953g = fVar.f8945j;
                this.f8954h = fVar.f8946k;
            }

            public f i() {
                return new f(this);
            }
        }

        private f(a aVar) {
            androidx.media3.common.util.a.g((aVar.f8952f && aVar.f8948b == null) ? false : true);
            UUID uuid = (UUID) androidx.media3.common.util.a.e(aVar.f8947a);
            this.f8936a = uuid;
            this.f8937b = uuid;
            this.f8938c = aVar.f8948b;
            this.f8939d = aVar.f8949c;
            this.f8940e = aVar.f8949c;
            this.f8941f = aVar.f8950d;
            this.f8943h = aVar.f8952f;
            this.f8942g = aVar.f8951e;
            this.f8944i = aVar.f8953g;
            this.f8945j = aVar.f8953g;
            this.f8946k = aVar.f8954h != null ? Arrays.copyOf(aVar.f8954h, aVar.f8954h.length) : null;
        }

        public a b() {
            return new a();
        }

        public byte[] c() {
            byte[] bArr = this.f8946k;
            if (bArr != null) {
                return Arrays.copyOf(bArr, bArr.length);
            }
            return null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return this.f8936a.equals(fVar.f8936a) && Objects.equals(this.f8938c, fVar.f8938c) && Objects.equals(this.f8940e, fVar.f8940e) && this.f8941f == fVar.f8941f && this.f8943h == fVar.f8943h && this.f8942g == fVar.f8942g && this.f8945j.equals(fVar.f8945j) && Arrays.equals(this.f8946k, fVar.f8946k);
        }

        public int hashCode() {
            int hashCode = this.f8936a.hashCode() * 31;
            Uri uri = this.f8938c;
            return ((((((((((((hashCode + (uri != null ? uri.hashCode() : 0)) * 31) + this.f8940e.hashCode()) * 31) + (this.f8941f ? 1 : 0)) * 31) + (this.f8943h ? 1 : 0)) * 31) + (this.f8942g ? 1 : 0)) * 31) + this.f8945j.hashCode()) * 31) + Arrays.hashCode(this.f8946k);
        }
    }

    public static final class g {

        /* renamed from: f, reason: collision with root package name */
        public static final g f8955f = new a().f();

        /* renamed from: g, reason: collision with root package name */
        private static final String f8956g = a1.C0(0);

        /* renamed from: h, reason: collision with root package name */
        private static final String f8957h = a1.C0(1);

        /* renamed from: i, reason: collision with root package name */
        private static final String f8958i = a1.C0(2);

        /* renamed from: j, reason: collision with root package name */
        private static final String f8959j = a1.C0(3);

        /* renamed from: k, reason: collision with root package name */
        private static final String f8960k = a1.C0(4);

        /* renamed from: a, reason: collision with root package name */
        public final long f8961a;

        /* renamed from: b, reason: collision with root package name */
        public final long f8962b;

        /* renamed from: c, reason: collision with root package name */
        public final long f8963c;

        /* renamed from: d, reason: collision with root package name */
        public final float f8964d;

        /* renamed from: e, reason: collision with root package name */
        public final float f8965e;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private long f8966a;

            /* renamed from: b, reason: collision with root package name */
            private long f8967b;

            /* renamed from: c, reason: collision with root package name */
            private long f8968c;

            /* renamed from: d, reason: collision with root package name */
            private float f8969d;

            /* renamed from: e, reason: collision with root package name */
            private float f8970e;

            public a() {
                this.f8966a = -9223372036854775807L;
                this.f8967b = -9223372036854775807L;
                this.f8968c = -9223372036854775807L;
                this.f8969d = -3.4028235E38f;
                this.f8970e = -3.4028235E38f;
            }

            private a(g gVar) {
                this.f8966a = gVar.f8961a;
                this.f8967b = gVar.f8962b;
                this.f8968c = gVar.f8963c;
                this.f8969d = gVar.f8964d;
                this.f8970e = gVar.f8965e;
            }

            public g f() {
                return new g(this);
            }

            public a g(long j5) {
                this.f8968c = j5;
                return this;
            }

            public a h(float f5) {
                this.f8970e = f5;
                return this;
            }

            public a i(long j5) {
                this.f8967b = j5;
                return this;
            }

            public a j(float f5) {
                this.f8969d = f5;
                return this;
            }

            public a k(long j5) {
                this.f8966a = j5;
                return this;
            }
        }

        public g(long j5, long j6, long j7, float f5, float f6) {
            this.f8961a = j5;
            this.f8962b = j6;
            this.f8963c = j7;
            this.f8964d = f5;
            this.f8965e = f6;
        }

        private g(a aVar) {
            this(aVar.f8966a, aVar.f8967b, aVar.f8968c, aVar.f8969d, aVar.f8970e);
        }

        public a a() {
            return new a();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return this.f8961a == gVar.f8961a && this.f8962b == gVar.f8962b && this.f8963c == gVar.f8963c && this.f8964d == gVar.f8964d && this.f8965e == gVar.f8965e;
        }

        public int hashCode() {
            long j5 = this.f8961a;
            long j6 = this.f8962b;
            int i5 = ((((int) (j5 ^ (j5 >>> 32))) * 31) + ((int) (j6 ^ (j6 >>> 32)))) * 31;
            long j7 = this.f8963c;
            int i6 = (i5 + ((int) ((j7 >>> 32) ^ j7))) * 31;
            float f5 = this.f8964d;
            int floatToIntBits = (i6 + (f5 != 0.0f ? Float.floatToIntBits(f5) : 0)) * 31;
            float f6 = this.f8965e;
            return floatToIntBits + (f6 != 0.0f ? Float.floatToIntBits(f6) : 0);
        }
    }

    public static final class h {

        /* renamed from: j, reason: collision with root package name */
        private static final String f8971j = a1.C0(0);

        /* renamed from: k, reason: collision with root package name */
        private static final String f8972k = a1.C0(1);

        /* renamed from: l, reason: collision with root package name */
        private static final String f8973l = a1.C0(2);

        /* renamed from: m, reason: collision with root package name */
        private static final String f8974m = a1.C0(3);

        /* renamed from: n, reason: collision with root package name */
        private static final String f8975n = a1.C0(4);

        /* renamed from: o, reason: collision with root package name */
        private static final String f8976o = a1.C0(5);

        /* renamed from: p, reason: collision with root package name */
        private static final String f8977p = a1.C0(6);

        /* renamed from: q, reason: collision with root package name */
        private static final String f8978q = a1.C0(7);

        /* renamed from: a, reason: collision with root package name */
        public final Uri f8979a;

        /* renamed from: b, reason: collision with root package name */
        public final String f8980b;

        /* renamed from: c, reason: collision with root package name */
        public final f f8981c;

        /* renamed from: d, reason: collision with root package name */
        public final List f8982d;

        /* renamed from: e, reason: collision with root package name */
        public final String f8983e;

        /* renamed from: f, reason: collision with root package name */
        public final ImmutableList f8984f;

        /* renamed from: g, reason: collision with root package name */
        public final List f8985g;

        /* renamed from: h, reason: collision with root package name */
        public final Object f8986h;

        /* renamed from: i, reason: collision with root package name */
        public final long f8987i;

        private h(Uri uri, String str, f fVar, b bVar, List list, String str2, ImmutableList immutableList, Object obj, long j5) {
            this.f8979a = uri;
            this.f8980b = y.u(str);
            this.f8981c = fVar;
            this.f8982d = list;
            this.f8983e = str2;
            this.f8984f = immutableList;
            ImmutableList.a builder = ImmutableList.builder();
            for (int i5 = 0; i5 < immutableList.size(); i5++) {
                builder.j(((k) immutableList.get(i5)).a().i());
            }
            this.f8985g = builder.n();
            this.f8986h = obj;
            this.f8987i = j5;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return this.f8979a.equals(hVar.f8979a) && Objects.equals(this.f8980b, hVar.f8980b) && Objects.equals(this.f8981c, hVar.f8981c) && this.f8982d.equals(hVar.f8982d) && Objects.equals(this.f8983e, hVar.f8983e) && this.f8984f.equals(hVar.f8984f) && Objects.equals(this.f8986h, hVar.f8986h) && this.f8987i == hVar.f8987i;
        }

        public int hashCode() {
            int hashCode = this.f8979a.hashCode() * 31;
            String str = this.f8980b;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            f fVar = this.f8981c;
            int hashCode3 = (((hashCode2 + (fVar == null ? 0 : fVar.hashCode())) * 961) + this.f8982d.hashCode()) * 31;
            String str2 = this.f8983e;
            int hashCode4 = (((hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f8984f.hashCode()) * 31;
            return (int) (((hashCode4 + (this.f8986h != null ? r1.hashCode() : 0)) * 31) + this.f8987i);
        }
    }

    public static final class i {

        /* renamed from: d, reason: collision with root package name */
        public static final i f8988d = new a().d();

        /* renamed from: e, reason: collision with root package name */
        private static final String f8989e = a1.C0(0);

        /* renamed from: f, reason: collision with root package name */
        private static final String f8990f = a1.C0(1);

        /* renamed from: g, reason: collision with root package name */
        private static final String f8991g = a1.C0(2);

        /* renamed from: a, reason: collision with root package name */
        public final Uri f8992a;

        /* renamed from: b, reason: collision with root package name */
        public final String f8993b;

        /* renamed from: c, reason: collision with root package name */
        public final Bundle f8994c;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private Uri f8995a;

            /* renamed from: b, reason: collision with root package name */
            private String f8996b;

            /* renamed from: c, reason: collision with root package name */
            private Bundle f8997c;

            public i d() {
                return new i(this);
            }
        }

        private i(a aVar) {
            this.f8992a = aVar.f8995a;
            this.f8993b = aVar.f8996b;
            this.f8994c = aVar.f8997c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            if (Objects.equals(this.f8992a, iVar.f8992a) && Objects.equals(this.f8993b, iVar.f8993b)) {
                if ((this.f8994c == null) == (iVar.f8994c == null)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            Uri uri = this.f8992a;
            int hashCode = (uri == null ? 0 : uri.hashCode()) * 31;
            String str = this.f8993b;
            return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + (this.f8994c != null ? 1 : 0);
        }
    }

    public static final class j extends k {
        private j(k.a aVar) {
            super(aVar);
        }
    }

    public static class k {

        /* renamed from: h, reason: collision with root package name */
        private static final String f8998h = a1.C0(0);

        /* renamed from: i, reason: collision with root package name */
        private static final String f8999i = a1.C0(1);

        /* renamed from: j, reason: collision with root package name */
        private static final String f9000j = a1.C0(2);

        /* renamed from: k, reason: collision with root package name */
        private static final String f9001k = a1.C0(3);

        /* renamed from: l, reason: collision with root package name */
        private static final String f9002l = a1.C0(4);

        /* renamed from: m, reason: collision with root package name */
        private static final String f9003m = a1.C0(5);

        /* renamed from: n, reason: collision with root package name */
        private static final String f9004n = a1.C0(6);

        /* renamed from: a, reason: collision with root package name */
        public final Uri f9005a;

        /* renamed from: b, reason: collision with root package name */
        public final String f9006b;

        /* renamed from: c, reason: collision with root package name */
        public final String f9007c;

        /* renamed from: d, reason: collision with root package name */
        public final int f9008d;

        /* renamed from: e, reason: collision with root package name */
        public final int f9009e;

        /* renamed from: f, reason: collision with root package name */
        public final String f9010f;

        /* renamed from: g, reason: collision with root package name */
        public final String f9011g;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private Uri f9012a;

            /* renamed from: b, reason: collision with root package name */
            private String f9013b;

            /* renamed from: c, reason: collision with root package name */
            private String f9014c;

            /* renamed from: d, reason: collision with root package name */
            private int f9015d;

            /* renamed from: e, reason: collision with root package name */
            private int f9016e;

            /* renamed from: f, reason: collision with root package name */
            private String f9017f;

            /* renamed from: g, reason: collision with root package name */
            private String f9018g;

            private a(k kVar) {
                this.f9012a = kVar.f9005a;
                this.f9013b = kVar.f9006b;
                this.f9014c = kVar.f9007c;
                this.f9015d = kVar.f9008d;
                this.f9016e = kVar.f9009e;
                this.f9017f = kVar.f9010f;
                this.f9018g = kVar.f9011g;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public j i() {
                return new j(this);
            }
        }

        private k(a aVar) {
            this.f9005a = aVar.f9012a;
            this.f9006b = aVar.f9013b;
            this.f9007c = aVar.f9014c;
            this.f9008d = aVar.f9015d;
            this.f9009e = aVar.f9016e;
            this.f9010f = aVar.f9017f;
            this.f9011g = aVar.f9018g;
        }

        public a a() {
            return new a();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof k)) {
                return false;
            }
            k kVar = (k) obj;
            return this.f9005a.equals(kVar.f9005a) && Objects.equals(this.f9006b, kVar.f9006b) && Objects.equals(this.f9007c, kVar.f9007c) && this.f9008d == kVar.f9008d && this.f9009e == kVar.f9009e && Objects.equals(this.f9010f, kVar.f9010f) && Objects.equals(this.f9011g, kVar.f9011g);
        }

        public int hashCode() {
            int hashCode = this.f9005a.hashCode() * 31;
            String str = this.f9006b;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f9007c;
            int hashCode3 = (((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f9008d) * 31) + this.f9009e) * 31;
            String str3 = this.f9010f;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f9011g;
            return hashCode4 + (str4 != null ? str4.hashCode() : 0);
        }
    }

    private t(String str, e eVar, h hVar, g gVar, v vVar, i iVar) {
        this.f8886a = str;
        this.f8887b = hVar;
        this.f8888c = hVar;
        this.f8889d = gVar;
        this.f8890e = vVar;
        this.f8891f = eVar;
        this.f8892g = eVar;
        this.f8893h = iVar;
    }

    public static t b(String str) {
        return new c().j(str).a();
    }

    public c a() {
        return new c();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return Objects.equals(this.f8886a, tVar.f8886a) && this.f8891f.equals(tVar.f8891f) && Objects.equals(this.f8887b, tVar.f8887b) && Objects.equals(this.f8889d, tVar.f8889d) && Objects.equals(this.f8890e, tVar.f8890e) && Objects.equals(this.f8893h, tVar.f8893h);
    }

    public int hashCode() {
        int hashCode = this.f8886a.hashCode() * 31;
        h hVar = this.f8887b;
        return ((((((((hashCode + (hVar != null ? hVar.hashCode() : 0)) * 31) + this.f8889d.hashCode()) * 31) + this.f8891f.hashCode()) * 31) + this.f8890e.hashCode()) * 31) + this.f8893h.hashCode();
    }
}
