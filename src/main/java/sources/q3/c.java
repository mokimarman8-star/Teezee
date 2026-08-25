package q3;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class c {

    /* renamed from: f, reason: collision with root package name */
    private int f17019f;

    /* renamed from: h, reason: collision with root package name */
    private int f17021h;

    /* renamed from: o, reason: collision with root package name */
    private float f17028o;

    /* renamed from: a, reason: collision with root package name */
    private String f17014a = "";

    /* renamed from: b, reason: collision with root package name */
    private String f17015b = "";

    /* renamed from: c, reason: collision with root package name */
    private Set f17016c = Collections.emptySet();

    /* renamed from: d, reason: collision with root package name */
    private String f17017d = "";

    /* renamed from: e, reason: collision with root package name */
    private String f17018e = null;

    /* renamed from: g, reason: collision with root package name */
    private boolean f17020g = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f17022i = false;

    /* renamed from: j, reason: collision with root package name */
    private int f17023j = -1;

    /* renamed from: k, reason: collision with root package name */
    private int f17024k = -1;

    /* renamed from: l, reason: collision with root package name */
    private int f17025l = -1;

    /* renamed from: m, reason: collision with root package name */
    private int f17026m = -1;

    /* renamed from: n, reason: collision with root package name */
    private int f17027n = -1;

    /* renamed from: p, reason: collision with root package name */
    private int f17029p = -1;

    /* renamed from: q, reason: collision with root package name */
    private boolean f17030q = false;

    private static int B(int i5, String str, String str2, int i6) {
        if (str.isEmpty() || i5 == -1) {
            return i5;
        }
        if (str.equals(str2)) {
            return i5 + i6;
        }
        return -1;
    }

    public c A(boolean z5) {
        this.f17024k = z5 ? 1 : 0;
        return this;
    }

    public int a() {
        if (this.f17022i) {
            return this.f17021h;
        }
        throw new IllegalStateException("Background color not defined.");
    }

    public boolean b() {
        return this.f17030q;
    }

    public int c() {
        if (this.f17020g) {
            return this.f17019f;
        }
        throw new IllegalStateException("Font color not defined");
    }

    public String d() {
        return this.f17018e;
    }

    public float e() {
        return this.f17028o;
    }

    public int f() {
        return this.f17027n;
    }

    public int g() {
        return this.f17029p;
    }

    public int h(String str, String str2, Set set, String str3) {
        if (this.f17014a.isEmpty() && this.f17015b.isEmpty() && this.f17016c.isEmpty() && this.f17017d.isEmpty()) {
            return TextUtils.isEmpty(str2) ? 1 : 0;
        }
        int B = B(B(B(0, this.f17014a, str, 1073741824), this.f17015b, str2, 2), this.f17017d, str3, 4);
        if (B == -1 || !set.containsAll(this.f17016c)) {
            return 0;
        }
        return B + (this.f17016c.size() * 4);
    }

    public int i() {
        int i5 = this.f17025l;
        if (i5 == -1 && this.f17026m == -1) {
            return -1;
        }
        return (i5 == 1 ? 1 : 0) | (this.f17026m == 1 ? 2 : 0);
    }

    public boolean j() {
        return this.f17022i;
    }

    public boolean k() {
        return this.f17020g;
    }

    public boolean l() {
        return this.f17023j == 1;
    }

    public boolean m() {
        return this.f17024k == 1;
    }

    public c n(int i5) {
        this.f17021h = i5;
        this.f17022i = true;
        return this;
    }

    public c o(boolean z5) {
        this.f17025l = z5 ? 1 : 0;
        return this;
    }

    public c p(boolean z5) {
        this.f17030q = z5;
        return this;
    }

    public c q(int i5) {
        this.f17019f = i5;
        this.f17020g = true;
        return this;
    }

    public c r(String str) {
        this.f17018e = str == null ? null : com.google.common.base.a.e(str);
        return this;
    }

    public c s(float f5) {
        this.f17028o = f5;
        return this;
    }

    public c t(int i5) {
        this.f17027n = i5;
        return this;
    }

    public c u(boolean z5) {
        this.f17026m = z5 ? 1 : 0;
        return this;
    }

    public c v(int i5) {
        this.f17029p = i5;
        return this;
    }

    public void w(String[] strArr) {
        this.f17016c = new HashSet(Arrays.asList(strArr));
    }

    public void x(String str) {
        this.f17014a = str;
    }

    public void y(String str) {
        this.f17015b = str;
    }

    public void z(String str) {
        this.f17017d = str;
    }
}
