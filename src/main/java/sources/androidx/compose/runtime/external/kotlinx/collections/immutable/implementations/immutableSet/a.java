package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import kotlin.jvm.internal.DefaultConstructorMarker;
import w.e;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static final C0022a f2722d = new C0022a(null);

    /* renamed from: e, reason: collision with root package name */
    public static final int f2723e = 8;

    /* renamed from: f, reason: collision with root package name */
    private static final a f2724f = new a(0, new Object[0]);

    /* renamed from: a, reason: collision with root package name */
    private int f2725a;

    /* renamed from: b, reason: collision with root package name */
    private Object[] f2726b;

    /* renamed from: c, reason: collision with root package name */
    private e f2727c;

    /* renamed from: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.a$a, reason: collision with other inner class name */
    public static final class C0022a {
        private C0022a() {
        }

        public /* synthetic */ C0022a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a a() {
            return a.f2724f;
        }
    }

    public a(int i5, Object[] objArr) {
        this(i5, objArr, null);
    }

    public a(int i5, Object[] objArr, e eVar) {
        this.f2725a = i5;
        this.f2726b = objArr;
        this.f2727c = eVar;
    }
}
