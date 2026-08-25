package androidx.coroutines;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import z3.f;
import z3.g;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class i0 implements g, f {

    /* renamed from: i, reason: collision with root package name */
    public static final a f13213i = new a(null);

    /* renamed from: j, reason: collision with root package name */
    public static final TreeMap f13214j = new TreeMap();

    /* renamed from: a, reason: collision with root package name */
    private final int f13215a;

    /* renamed from: b, reason: collision with root package name */
    private volatile String f13216b;

    /* renamed from: c, reason: collision with root package name */
    public final long[] f13217c;

    /* renamed from: d, reason: collision with root package name */
    public final double[] f13218d;

    /* renamed from: e, reason: collision with root package name */
    public final String[] f13219e;

    /* renamed from: f, reason: collision with root package name */
    public final byte[][] f13220f;

    /* renamed from: g, reason: collision with root package name */
    private final int[] f13221g;

    /* renamed from: h, reason: collision with root package name */
    private int f13222h;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final i0 a(String str, int i5) {
            Intrinsics.h(str, "query");
            TreeMap treeMap = i0.f13214j;
            synchronized (treeMap) {
                Map.Entry ceilingEntry = treeMap.ceilingEntry(Integer.valueOf(i5));
                if (ceilingEntry == null) {
                    Unit unit = Unit.a;
                    i0 i0Var = new i0(i5, null);
                    i0Var.j(str, i5);
                    return i0Var;
                }
                treeMap.remove(ceilingEntry.getKey());
                i0 i0Var2 = (i0) ceilingEntry.getValue();
                i0Var2.j(str, i5);
                Intrinsics.e(i0Var2);
                return i0Var2;
            }
        }

        public final void b() {
            TreeMap treeMap = i0.f13214j;
            if (treeMap.size() <= 15) {
                return;
            }
            int size = treeMap.size() - 10;
            Iterator it = treeMap.descendingKeySet().iterator();
            Intrinsics.g(it, "iterator(...)");
            while (true) {
                int i5 = size - 1;
                if (size <= 0) {
                    return;
                }
                it.next();
                it.remove();
                size = i5;
            }
        }
    }

    private i0(int i5) {
        this.f13215a = i5;
        int i6 = i5 + 1;
        this.f13221g = new int[i6];
        this.f13217c = new long[i6];
        this.f13218d = new double[i6];
        this.f13219e = new String[i6];
        this.f13220f = new byte[i6][];
    }

    public /* synthetic */ i0(int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i5);
    }

    public static final i0 f(String str, int i5) {
        return f13213i.a(str, i5);
    }

    @Override // z3.f
    public void V(int i5, String str) {
        Intrinsics.h(str, "value");
        this.f13221g[i5] = 4;
        this.f13219e[i5] = str;
    }

    @Override // z3.f
    public void a(int i5, double d5) {
        this.f13221g[i5] = 3;
        this.f13218d[i5] = d5;
    }

    @Override // z3.g
    public void b(f fVar) {
        Intrinsics.h(fVar, "statement");
        int h5 = h();
        if (1 > h5) {
            return;
        }
        int i5 = 1;
        while (true) {
            int i6 = this.f13221g[i5];
            if (i6 == 1) {
                fVar.g(i5);
            } else if (i6 == 2) {
                fVar.c(i5, this.f13217c[i5]);
            } else if (i6 == 3) {
                fVar.a(i5, this.f13218d[i5]);
            } else if (i6 == 4) {
                String str = this.f13219e[i5];
                if (str == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                fVar.V(i5, str);
            } else if (i6 == 5) {
                byte[] bArr = this.f13220f[i5];
                if (bArr == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                fVar.k0(i5, bArr);
            }
            if (i5 == h5) {
                return;
            } else {
                i5++;
            }
        }
    }

    @Override // z3.f
    public void c(int i5, long j5) {
        this.f13221g[i5] = 2;
        this.f13217c[i5] = j5;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // z3.g
    public String d() {
        String str = this.f13216b;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Required value was null.");
    }

    @Override // z3.f
    public void g(int i5) {
        this.f13221g[i5] = 1;
    }

    public int h() {
        return this.f13222h;
    }

    public final void j(String str, int i5) {
        Intrinsics.h(str, "query");
        this.f13216b = str;
        this.f13222h = i5;
    }

    @Override // z3.f
    public void k0(int i5, byte[] bArr) {
        Intrinsics.h(bArr, "value");
        this.f13221g[i5] = 5;
        this.f13220f[i5] = bArr;
    }

    public final void release() {
        TreeMap treeMap = f13214j;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.f13215a), this);
            f13213i.b();
            Unit unit = Unit.a;
        }
    }
}
