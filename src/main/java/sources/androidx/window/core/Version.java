package androidx.window.core;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class Version implements Comparable {

    /* renamed from: f, reason: collision with root package name */
    public static final a f13753f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    private static final Version f13754g = new Version(0, 0, 0, "");

    /* renamed from: h, reason: collision with root package name */
    private static final Version f13755h = new Version(0, 1, 0, "");

    /* renamed from: i, reason: collision with root package name */
    private static final Version f13756i;

    /* renamed from: j, reason: collision with root package name */
    private static final Version f13757j;

    /* renamed from: a, reason: collision with root package name */
    private final int f13758a;

    /* renamed from: b, reason: collision with root package name */
    private final int f13759b;

    /* renamed from: c, reason: collision with root package name */
    private final int f13760c;

    /* renamed from: d, reason: collision with root package name */
    private final String f13761d;

    /* renamed from: e, reason: collision with root package name */
    private final Lazy f13762e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Version a() {
            return Version.f13755h;
        }

        public final Version b(String str) {
            if (str == null || StringsKt.q0(str)) {
                return null;
            }
            Matcher matcher = Pattern.compile("(\\d+)(?:\\.(\\d+))(?:\\.(\\d+))(?:-(.+))?").matcher(str);
            if (!matcher.matches()) {
                return null;
            }
            String group = matcher.group(1);
            Integer valueOf = group == null ? null : Integer.valueOf(Integer.parseInt(group));
            if (valueOf == null) {
                return null;
            }
            int intValue = valueOf.intValue();
            String group2 = matcher.group(2);
            Integer valueOf2 = group2 == null ? null : Integer.valueOf(Integer.parseInt(group2));
            if (valueOf2 == null) {
                return null;
            }
            int intValue2 = valueOf2.intValue();
            String group3 = matcher.group(3);
            Integer valueOf3 = group3 == null ? null : Integer.valueOf(Integer.parseInt(group3));
            if (valueOf3 == null) {
                return null;
            }
            int intValue3 = valueOf3.intValue();
            String group4 = matcher.group(4) != null ? matcher.group(4) : "";
            Intrinsics.g(group4, "description");
            return new Version(intValue, intValue2, intValue3, group4, null);
        }
    }

    static {
        Version version = new Version(1, 0, 0, "");
        f13756i = version;
        f13757j = version;
    }

    private Version(int i5, int i6, int i7, String str) {
        this.f13758a = i5;
        this.f13759b = i6;
        this.f13760c = i7;
        this.f13761d = str;
        this.f13762e = LazyKt.b(new Function0<BigInteger>() { // from class: androidx.window.core.Version$bigInteger$2
            {
                super(0);
            }

            public final BigInteger invoke() {
                return BigInteger.valueOf(Version.this.e()).shiftLeft(32).or(BigInteger.valueOf(Version.this.f())).shiftLeft(32).or(BigInteger.valueOf(Version.this.g()));
            }
        });
    }

    public /* synthetic */ Version(int i5, int i6, int i7, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(i5, i6, i7, str);
    }

    private final BigInteger d() {
        Object value = this.f13762e.getValue();
        Intrinsics.g(value, "<get-bigInteger>(...)");
        return (BigInteger) value;
    }

    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(Version version) {
        Intrinsics.h(version, "other");
        return d().compareTo(version.d());
    }

    public final int e() {
        return this.f13758a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Version)) {
            return false;
        }
        Version version = (Version) obj;
        return this.f13758a == version.f13758a && this.f13759b == version.f13759b && this.f13760c == version.f13760c;
    }

    public final int f() {
        return this.f13759b;
    }

    public final int g() {
        return this.f13760c;
    }

    public int hashCode() {
        return ((((527 + this.f13758a) * 31) + this.f13759b) * 31) + this.f13760c;
    }

    public String toString() {
        return this.f13758a + '.' + this.f13759b + '.' + this.f13760c + (!StringsKt.q0(this.f13761d) ? Intrinsics.q("-", this.f13761d) : "");
    }
}
