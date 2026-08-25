package m0;

import androidx.compose.ui.text.platform.o;
import androidx.compose.ui.text.platform.p;
import java.util.HashMap;
import java.util.LinkedHashSet;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final p f16473a = o.a();

    /* renamed from: b, reason: collision with root package name */
    private final HashMap f16474b;

    /* renamed from: c, reason: collision with root package name */
    private final LinkedHashSet f16475c;

    /* renamed from: d, reason: collision with root package name */
    private int f16476d;

    /* renamed from: e, reason: collision with root package name */
    private int f16477e;

    /* renamed from: f, reason: collision with root package name */
    private int f16478f;

    /* renamed from: g, reason: collision with root package name */
    private int f16479g;

    /* renamed from: h, reason: collision with root package name */
    private int f16480h;

    /* renamed from: i, reason: collision with root package name */
    private int f16481i;

    /* renamed from: j, reason: collision with root package name */
    private int f16482j;

    public b(int i5) {
        if (i5 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f16477e = i5;
        this.f16474b = new HashMap(0, 0.75f);
        this.f16475c = new LinkedHashSet();
    }

    private final int g(Object obj, Object obj2) {
        int i5 = i(obj, obj2);
        if (i5 >= 0) {
            return i5;
        }
        throw new IllegalStateException(("Negative size: " + obj + '=' + obj2).toString());
    }

    protected Object b(Object obj) {
        return null;
    }

    protected void c(boolean z5, Object obj, Object obj2, Object obj3) {
    }

    public final Object d(Object obj) {
        synchronized (this.f16473a) {
            Object obj2 = this.f16474b.get(obj);
            if (obj2 != null) {
                this.f16475c.remove(obj);
                this.f16475c.add(obj);
                this.f16481i++;
                return obj2;
            }
            this.f16482j++;
            Object b5 = b(obj);
            if (b5 == null) {
                return null;
            }
            synchronized (this.f16473a) {
                try {
                    this.f16479g++;
                    Object put = this.f16474b.put(obj, b5);
                    this.f16475c.remove(obj);
                    this.f16475c.add(obj);
                    if (put != null) {
                        this.f16474b.put(obj, put);
                        obj2 = put;
                    } else {
                        this.f16476d = h() + g(obj, b5);
                    }
                    Unit unit = Unit.a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (obj2 != null) {
                c(false, obj, b5, obj2);
                return obj2;
            }
            j(this.f16477e);
            return b5;
        }
    }

    public final Object e(Object obj, Object obj2) {
        Object put;
        if (obj == null || obj2 == null) {
            throw null;
        }
        synchronized (this.f16473a) {
            try {
                this.f16478f++;
                this.f16476d = h() + g(obj, obj2);
                put = this.f16474b.put(obj, obj2);
                if (put != null) {
                    this.f16476d = h() - g(obj, put);
                }
                if (this.f16475c.contains(obj)) {
                    this.f16475c.remove(obj);
                }
                this.f16475c.add(obj);
            } catch (Throwable th) {
                throw th;
            }
        }
        if (put != null) {
            c(false, obj, put, obj2);
        }
        j(this.f16477e);
        return put;
    }

    public final Object f(Object obj) {
        Object remove;
        obj.getClass();
        synchronized (this.f16473a) {
            try {
                remove = this.f16474b.remove(obj);
                this.f16475c.remove(obj);
                if (remove != null) {
                    this.f16476d = h() - g(obj, remove);
                }
                Unit unit = Unit.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (remove != null) {
            c(false, obj, remove, null);
        }
        return remove;
    }

    public final int h() {
        int i5;
        synchronized (this.f16473a) {
            i5 = this.f16476d;
        }
        return i5;
    }

    protected int i(Object obj, Object obj2) {
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0094, code lost:
    
        throw new java.lang.IllegalStateException("map/keySet size inconsistency");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void j(int i5) {
        Object obj;
        Object obj2;
        while (true) {
            synchronized (this.f16473a) {
                try {
                    if (h() >= 0) {
                        if (this.f16474b.isEmpty() && h() != 0) {
                            break;
                        }
                        if (this.f16474b.isEmpty() != this.f16475c.isEmpty()) {
                            break;
                        }
                        if (h() <= i5 || this.f16474b.isEmpty()) {
                            obj = null;
                            obj2 = null;
                        } else {
                            obj = CollectionsKt.h0(this.f16475c);
                            obj2 = this.f16474b.get(obj);
                            if (obj2 == null) {
                                throw new IllegalStateException("inconsistent state");
                            }
                            TypeIntrinsics.d(this.f16474b).remove(obj);
                            TypeIntrinsics.a(this.f16475c).remove(obj);
                            int h5 = h();
                            Intrinsics.e(obj);
                            Intrinsics.e(obj2);
                            this.f16476d = h5 - g(obj, obj2);
                            this.f16480h++;
                        }
                        Unit unit = Unit.a;
                    } else {
                        break;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (obj == null && obj2 == null) {
                return;
            }
            Intrinsics.e(obj);
            Intrinsics.e(obj2);
            c(true, obj, obj2, null);
        }
    }

    public String toString() {
        String str;
        synchronized (this.f16473a) {
            try {
                int i5 = this.f16481i;
                int i6 = this.f16482j + i5;
                str = "LruCache[maxSize=" + this.f16477e + ",hits=" + this.f16481i + ",misses=" + this.f16482j + ",hitRate=" + (i6 != 0 ? (i5 * 100) / i6 : 0) + "%]";
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }
}
