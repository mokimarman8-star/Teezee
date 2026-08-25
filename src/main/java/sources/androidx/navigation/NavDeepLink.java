package androidx.navigation;

import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class NavDeepLink {

    /* renamed from: l, reason: collision with root package name */
    private static final b f12437l = new b(null);

    /* renamed from: m, reason: collision with root package name */
    private static final Pattern f12438m = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");

    /* renamed from: a, reason: collision with root package name */
    private final String f12439a;

    /* renamed from: b, reason: collision with root package name */
    private final String f12440b;

    /* renamed from: c, reason: collision with root package name */
    private final String f12441c;

    /* renamed from: f, reason: collision with root package name */
    private String f12444f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f12446h;

    /* renamed from: i, reason: collision with root package name */
    private String f12447i;

    /* renamed from: k, reason: collision with root package name */
    private boolean f12449k;

    /* renamed from: d, reason: collision with root package name */
    private final List f12442d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private final Map f12443e = new LinkedHashMap();

    /* renamed from: g, reason: collision with root package name */
    private final Lazy f12445g = LazyKt.b(new Function0<Pattern>() { // from class: androidx.navigation.NavDeepLink$pattern$2
        {
            super(0);
        }

        public final Pattern invoke() {
            String str;
            str = NavDeepLink.this.f12444f;
            if (str == null) {
                return null;
            }
            return Pattern.compile(str, 2);
        }
    });

    /* renamed from: j, reason: collision with root package name */
    private final Lazy f12448j = LazyKt.b(new Function0<Pattern>() { // from class: androidx.navigation.NavDeepLink$mimeTypePattern$2
        {
            super(0);
        }

        public final Pattern invoke() {
            String str;
            str = NavDeepLink.this.f12447i;
            if (str == null) {
                return null;
            }
            return Pattern.compile(str);
        }
    });

    public static final class a {

        /* renamed from: d, reason: collision with root package name */
        public static final C0088a f12450d = new C0088a(null);

        /* renamed from: a, reason: collision with root package name */
        private String f12451a;

        /* renamed from: b, reason: collision with root package name */
        private String f12452b;

        /* renamed from: c, reason: collision with root package name */
        private String f12453c;

        /* renamed from: androidx.navigation.NavDeepLink$a$a, reason: collision with other inner class name */
        public static final class C0088a {
            private C0088a() {
            }

            public /* synthetic */ C0088a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public final NavDeepLink a() {
            return new NavDeepLink(this.f12451a, this.f12452b, this.f12453c);
        }

        public final a b(String str) {
            Intrinsics.h(str, "action");
            if (str.length() <= 0) {
                throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
            }
            this.f12452b = str;
            return this;
        }

        public final a c(String str) {
            Intrinsics.h(str, "mimeType");
            this.f12453c = str;
            return this;
        }

        public final a d(String str) {
            Intrinsics.h(str, "uriPattern");
            this.f12451a = str;
            return this;
        }
    }

    private static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final class c implements Comparable {

        /* renamed from: a, reason: collision with root package name */
        private String f12454a;

        /* renamed from: b, reason: collision with root package name */
        private String f12455b;

        public c(String str) {
            List l5;
            Intrinsics.h(str, "mimeType");
            List split = new Regex("/").split(str, 0);
            if (!split.isEmpty()) {
                ListIterator listIterator = split.listIterator(split.size());
                while (listIterator.hasPrevious()) {
                    if (((String) listIterator.previous()).length() != 0) {
                        l5 = CollectionsKt.K0(split, listIterator.nextIndex() + 1);
                        break;
                    }
                }
            }
            l5 = CollectionsKt.l();
            this.f12454a = (String) l5.get(0);
            this.f12455b = (String) l5.get(1);
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            Intrinsics.h(cVar, "other");
            int i5 = Intrinsics.c(this.f12454a, cVar.f12454a) ? 2 : 0;
            return Intrinsics.c(this.f12455b, cVar.f12455b) ? i5 + 1 : i5;
        }

        public final String b() {
            return this.f12455b;
        }

        public final String d() {
            return this.f12454a;
        }
    }

    private static final class d {

        /* renamed from: a, reason: collision with root package name */
        private String f12456a;

        /* renamed from: b, reason: collision with root package name */
        private final List f12457b = new ArrayList();

        public final void a(String str) {
            Intrinsics.h(str, "name");
            this.f12457b.add(str);
        }

        public final String b(int i5) {
            return (String) this.f12457b.get(i5);
        }

        public final List c() {
            return this.f12457b;
        }

        public final String d() {
            return this.f12456a;
        }

        public final void e(String str) {
            this.f12456a = str;
        }

        public final int f() {
            return this.f12457b.size();
        }
    }

    public NavDeepLink(String str, String str2, String str3) {
        this.f12439a = str;
        this.f12440b = str2;
        this.f12441c = str3;
        if (str != null) {
            Uri parse = Uri.parse(str);
            this.f12446h = parse.getQuery() != null;
            StringBuilder sb = new StringBuilder("^");
            if (!f12438m.matcher(str).find()) {
                sb.append("http[s]?://");
            }
            Pattern compile = Pattern.compile("\\{(.+?)\\}");
            if (this.f12446h) {
                Matcher matcher = Pattern.compile("(\\?)").matcher(str);
                if (matcher.find()) {
                    String substring = str.substring(0, matcher.start());
                    Intrinsics.g(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    Intrinsics.g(compile, "fillInPattern");
                    this.f12449k = c(substring, sb, compile);
                }
                for (String str4 : parse.getQueryParameterNames()) {
                    StringBuilder sb2 = new StringBuilder();
                    String queryParameter = parse.getQueryParameter(str4);
                    if (queryParameter == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    Matcher matcher2 = compile.matcher(queryParameter);
                    d dVar = new d();
                    int i5 = 0;
                    while (matcher2.find()) {
                        String group = matcher2.group(1);
                        if (group == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        dVar.a(group);
                        String substring2 = queryParameter.substring(i5, matcher2.start());
                        Intrinsics.g(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                        sb2.append(Pattern.quote(substring2));
                        sb2.append("(.+?)?");
                        i5 = matcher2.end();
                    }
                    if (i5 < queryParameter.length()) {
                        String substring3 = queryParameter.substring(i5);
                        Intrinsics.g(substring3, "this as java.lang.String).substring(startIndex)");
                        sb2.append(Pattern.quote(substring3));
                    }
                    String sb3 = sb2.toString();
                    Intrinsics.g(sb3, "argRegex.toString()");
                    dVar.e(StringsKt.Q(sb3, ".*", "\\E.*\\Q", false, 4, (Object) null));
                    Map map = this.f12443e;
                    Intrinsics.g(str4, "paramName");
                    map.put(str4, dVar);
                }
            } else {
                Intrinsics.g(compile, "fillInPattern");
                this.f12449k = c(str, sb, compile);
            }
            String sb4 = sb.toString();
            Intrinsics.g(sb4, "uriRegex.toString()");
            this.f12444f = StringsKt.Q(sb4, ".*", "\\E.*\\Q", false, 4, (Object) null);
        }
        if (this.f12441c != null) {
            if (!Pattern.compile("^[\\s\\S]+/[\\s\\S]+$").matcher(this.f12441c).matches()) {
                throw new IllegalArgumentException(("The given mimeType " + ((Object) g()) + " does not match to required \"type/subtype\" format").toString());
            }
            c cVar = new c(this.f12441c);
            this.f12447i = StringsKt.Q("^(" + cVar.d() + "|[*]+)/(" + cVar.b() + "|[*]+)$", "*|[*]", "[\\s\\S]", false, 4, (Object) null);
        }
    }

    private final boolean c(String str, StringBuilder sb, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        boolean z5 = !StringsKt.c0(str, ".*", false, 2, (Object) null);
        int i5 = 0;
        while (matcher.find()) {
            String group = matcher.group(1);
            if (group == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            this.f12442d.add(group);
            String substring = str.substring(i5, matcher.start());
            Intrinsics.g(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            sb.append(Pattern.quote(substring));
            sb.append("([^/]+?)");
            i5 = matcher.end();
            z5 = false;
        }
        if (i5 < str.length()) {
            String substring2 = str.substring(i5);
            Intrinsics.g(substring2, "this as java.lang.String).substring(startIndex)");
            sb.append(Pattern.quote(substring2));
        }
        sb.append("($|(\\?(.)*)|(\\#(.)*))");
        return z5;
    }

    private final Pattern i() {
        return (Pattern) this.f12448j.getValue();
    }

    private final Pattern j() {
        return (Pattern) this.f12445g.getValue();
    }

    private final boolean m(Bundle bundle, String str, String str2, androidx.navigation.d dVar) {
        if (dVar != null) {
            dVar.a().d(bundle, str, str2);
            return false;
        }
        bundle.putString(str, str2);
        return false;
    }

    public final String d() {
        return this.f12440b;
    }

    public final List e() {
        List list = this.f12442d;
        Collection values = this.f12443e.values();
        ArrayList arrayList = new ArrayList();
        Iterator it = values.iterator();
        while (it.hasNext()) {
            CollectionsKt.B(arrayList, ((d) it.next()).c());
        }
        return CollectionsKt.B0(list, arrayList);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof NavDeepLink)) {
            return false;
        }
        NavDeepLink navDeepLink = (NavDeepLink) obj;
        return Intrinsics.c(this.f12439a, navDeepLink.f12439a) && Intrinsics.c(this.f12440b, navDeepLink.f12440b) && Intrinsics.c(this.f12441c, navDeepLink.f12441c);
    }

    public final Bundle f(Uri uri, Map map) {
        Matcher matcher;
        String str;
        Intrinsics.h(uri, "deepLink");
        Intrinsics.h(map, "arguments");
        Pattern j5 = j();
        Matcher matcher2 = j5 == null ? null : j5.matcher(uri.toString());
        if (matcher2 == null || !matcher2.matches()) {
            return null;
        }
        Bundle bundle = new Bundle();
        int size = this.f12442d.size();
        int i5 = 0;
        while (i5 < size) {
            int i6 = i5 + 1;
            String str2 = (String) this.f12442d.get(i5);
            String decode = Uri.decode(matcher2.group(i6));
            androidx.navigation.d dVar = (androidx.navigation.d) map.get(str2);
            try {
                Intrinsics.g(decode, "value");
                if (m(bundle, str2, decode, dVar)) {
                    return null;
                }
                i5 = i6;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        if (this.f12446h) {
            for (String str3 : this.f12443e.keySet()) {
                d dVar2 = (d) this.f12443e.get(str3);
                String queryParameter = uri.getQueryParameter(str3);
                if (queryParameter != null) {
                    Intrinsics.e(dVar2);
                    matcher = Pattern.compile(dVar2.d(), 32).matcher(queryParameter);
                    if (!matcher.matches()) {
                        return null;
                    }
                } else {
                    matcher = null;
                }
                Bundle bundle2 = new Bundle();
                try {
                    Intrinsics.e(dVar2);
                    int f5 = dVar2.f();
                    int i7 = 0;
                    while (i7 < f5) {
                        int i8 = i7 + 1;
                        if (matcher != null) {
                            str = matcher.group(i8);
                            if (str == null) {
                                str = "";
                            }
                        } else {
                            str = null;
                        }
                        String b5 = dVar2.b(i7);
                        androidx.navigation.d dVar3 = (androidx.navigation.d) map.get(b5);
                        if (str != null) {
                            if (!Intrinsics.c(str, '{' + b5 + '}') && m(bundle2, b5, str, dVar3)) {
                                return null;
                            }
                        }
                        i7 = i8;
                    }
                    bundle.putAll(bundle2);
                } catch (IllegalArgumentException unused2) {
                }
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            String str4 = (String) entry.getKey();
            androidx.navigation.d dVar4 = (androidx.navigation.d) entry.getValue();
            if (dVar4 != null && !dVar4.c() && !dVar4.b() && !bundle.containsKey(str4)) {
                return null;
            }
        }
        return bundle;
    }

    public final String g() {
        return this.f12441c;
    }

    public final int h(String str) {
        Intrinsics.h(str, "mimeType");
        if (this.f12441c != null) {
            Pattern i5 = i();
            Intrinsics.e(i5);
            if (i5.matcher(str).matches()) {
                return new c(this.f12441c).compareTo(new c(str));
            }
        }
        return -1;
    }

    public int hashCode() {
        String str = this.f12439a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f12440b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f12441c;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String k() {
        return this.f12439a;
    }

    public final boolean l() {
        return this.f12449k;
    }
}
