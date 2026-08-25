package androidx.coroutines;

import kotlin.jvm.internal.Intrinsics;
import y3.b;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class f0 implements g0 {

    /* renamed from: a, reason: collision with root package name */
    private final int f13197a;

    /* renamed from: b, reason: collision with root package name */
    private final String f13198b;

    /* renamed from: c, reason: collision with root package name */
    private final String f13199c;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f13200a;

        /* renamed from: b, reason: collision with root package name */
        public final String f13201b;

        public a(boolean z5, String str) {
            this.f13200a = z5;
            this.f13201b = str;
        }
    }

    public f0(int i5, String str, String str2) {
        Intrinsics.h(str, "identityHash");
        Intrinsics.h(str2, "legacyIdentityHash");
        this.f13197a = i5;
        this.f13198b = str;
        this.f13199c = str2;
    }

    public abstract void a(b bVar);

    public abstract void b(b bVar);

    public final String c() {
        return this.f13198b;
    }

    public final String d() {
        return this.f13199c;
    }

    public final int e() {
        return this.f13197a;
    }

    public abstract void f(b bVar);

    public abstract void g(b bVar);

    public abstract void h(b bVar);

    public abstract void i(b bVar);

    public abstract a j(b bVar);
}
