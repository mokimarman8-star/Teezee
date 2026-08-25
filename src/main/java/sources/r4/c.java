package r4;

import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final List f17615a;

    /* renamed from: b, reason: collision with root package name */
    private final char f17616b;

    /* renamed from: c, reason: collision with root package name */
    private final double f17617c;

    /* renamed from: d, reason: collision with root package name */
    private final double f17618d;

    /* renamed from: e, reason: collision with root package name */
    private final String f17619e;

    /* renamed from: f, reason: collision with root package name */
    private final String f17620f;

    public c(List list, char c5, double d5, double d6, String str, String str2) {
        this.f17615a = list;
        this.f17616b = c5;
        this.f17617c = d5;
        this.f17618d = d6;
        this.f17619e = str;
        this.f17620f = str2;
    }

    public static int c(char c5, String str, String str2) {
        return (((c5 * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List a() {
        return this.f17615a;
    }

    public double b() {
        return this.f17618d;
    }

    public int hashCode() {
        return c(this.f17616b, this.f17620f, this.f17619e);
    }
}
