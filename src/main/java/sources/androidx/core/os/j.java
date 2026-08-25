package androidx.core.os;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class j implements k {

    /* renamed from: c, reason: collision with root package name */
    private static final Locale[] f7024c = new Locale[0];

    /* renamed from: d, reason: collision with root package name */
    private static final Locale f7025d = new Locale("en", "XA");

    /* renamed from: e, reason: collision with root package name */
    private static final Locale f7026e = new Locale("ar", "XB");

    /* renamed from: f, reason: collision with root package name */
    private static final Locale f7027f = i.b("en-Latn");

    /* renamed from: a, reason: collision with root package name */
    private final Locale[] f7028a;

    /* renamed from: b, reason: collision with root package name */
    private final String f7029b;

    j(Locale... localeArr) {
        if (localeArr.length == 0) {
            this.f7028a = f7024c;
            this.f7029b = "";
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < localeArr.length; i5++) {
            Locale locale = localeArr[i5];
            if (locale == null) {
                throw new NullPointerException("list[" + i5 + "] is null");
            }
            if (!hashSet.contains(locale)) {
                Locale locale2 = (Locale) locale.clone();
                arrayList.add(locale2);
                c(sb, locale2);
                if (i5 < localeArr.length - 1) {
                    sb.append(',');
                }
                hashSet.add(locale2);
            }
        }
        this.f7028a = (Locale[]) arrayList.toArray(new Locale[0]);
        this.f7029b = sb.toString();
    }

    static void c(StringBuilder sb, Locale locale) {
        sb.append(locale.getLanguage());
        String country = locale.getCountry();
        if (country == null || country.isEmpty()) {
            return;
        }
        sb.append('-');
        sb.append(locale.getCountry());
    }

    @Override // androidx.core.os.k
    public String a() {
        return this.f7029b;
    }

    @Override // androidx.core.os.k
    public Object b() {
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        Locale[] localeArr = ((j) obj).f7028a;
        if (this.f7028a.length != localeArr.length) {
            return false;
        }
        int i5 = 0;
        while (true) {
            Locale[] localeArr2 = this.f7028a;
            if (i5 >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i5].equals(localeArr[i5])) {
                return false;
            }
            i5++;
        }
    }

    @Override // androidx.core.os.k
    public Locale get(int i5) {
        if (i5 >= 0) {
            Locale[] localeArr = this.f7028a;
            if (i5 < localeArr.length) {
                return localeArr[i5];
            }
        }
        return null;
    }

    public int hashCode() {
        int i5 = 1;
        for (Locale locale : this.f7028a) {
            i5 = (i5 * 31) + locale.hashCode();
        }
        return i5;
    }

    @Override // androidx.core.os.k
    public boolean isEmpty() {
        return this.f7028a.length == 0;
    }

    @Override // androidx.core.os.k
    public int size() {
        return this.f7028a.length;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i5 = 0;
        while (true) {
            Locale[] localeArr = this.f7028a;
            if (i5 >= localeArr.length) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(localeArr[i5]);
            if (i5 < this.f7028a.length - 1) {
                sb.append(',');
            }
            i5++;
        }
    }
}
