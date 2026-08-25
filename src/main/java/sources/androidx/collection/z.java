package androidx.collection;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class z {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final n.b lock;
    private final n.c map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public z(int i5) {
        this.maxSize = i5;
        if (!(i5 > 0)) {
            n.d.a("maxSize <= 0");
        }
        this.map = new n.c(0, 0.75f);
        this.lock = new n.b();
    }

    private final int a(Object obj, Object obj2) {
        int sizeOf = sizeOf(obj, obj2);
        if (!(sizeOf >= 0)) {
            n.d.b("Negative size: " + obj + '=' + obj2);
        }
        return sizeOf;
    }

    protected Object create(Object obj) {
        Intrinsics.h(obj, "key");
        return null;
    }

    public final int createCount() {
        int i5;
        synchronized (this.lock) {
            i5 = this.createCount;
        }
        return i5;
    }

    protected void entryRemoved(boolean z5, Object obj, Object obj2, Object obj3) {
        Intrinsics.h(obj, "key");
        Intrinsics.h(obj2, "oldValue");
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final int evictionCount() {
        int i5;
        synchronized (this.lock) {
            i5 = this.evictionCount;
        }
        return i5;
    }

    public final Object get(Object obj) {
        Object d5;
        Intrinsics.h(obj, "key");
        synchronized (this.lock) {
            Object a5 = this.map.a(obj);
            if (a5 != null) {
                this.hitCount++;
                return a5;
            }
            this.missCount++;
            Object create = create(obj);
            if (create == null) {
                return null;
            }
            synchronized (this.lock) {
                try {
                    this.createCount++;
                    d5 = this.map.d(obj, create);
                    if (d5 != null) {
                        this.map.d(obj, d5);
                    } else {
                        this.size += a(obj, create);
                        Unit unit = Unit.a;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (d5 != null) {
                entryRemoved(false, obj, create, d5);
                return d5;
            }
            trimToSize(this.maxSize);
            return create;
        }
    }

    public final int hitCount() {
        int i5;
        synchronized (this.lock) {
            i5 = this.hitCount;
        }
        return i5;
    }

    public final int maxSize() {
        int i5;
        synchronized (this.lock) {
            i5 = this.maxSize;
        }
        return i5;
    }

    public final int missCount() {
        int i5;
        synchronized (this.lock) {
            i5 = this.missCount;
        }
        return i5;
    }

    public final Object put(Object obj, Object obj2) {
        Object d5;
        Intrinsics.h(obj, "key");
        Intrinsics.h(obj2, "value");
        synchronized (this.lock) {
            try {
                this.putCount++;
                this.size += a(obj, obj2);
                d5 = this.map.d(obj, obj2);
                if (d5 != null) {
                    this.size -= a(obj, d5);
                }
                Unit unit = Unit.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (d5 != null) {
            entryRemoved(false, obj, d5, obj2);
        }
        trimToSize(this.maxSize);
        return d5;
    }

    public final int putCount() {
        int i5;
        synchronized (this.lock) {
            i5 = this.putCount;
        }
        return i5;
    }

    public final Object remove(Object obj) {
        Object e5;
        Intrinsics.h(obj, "key");
        synchronized (this.lock) {
            try {
                e5 = this.map.e(obj);
                if (e5 != null) {
                    this.size -= a(obj, e5);
                }
                Unit unit = Unit.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (e5 != null) {
            entryRemoved(false, obj, e5, null);
        }
        return e5;
    }

    public void resize(int i5) {
        if (!(i5 > 0)) {
            n.d.a("maxSize <= 0");
        }
        synchronized (this.lock) {
            this.maxSize = i5;
            Unit unit = Unit.a;
        }
        trimToSize(i5);
    }

    public final int size() {
        int i5;
        synchronized (this.lock) {
            i5 = this.size;
        }
        return i5;
    }

    protected int sizeOf(Object obj, Object obj2) {
        Intrinsics.h(obj, "key");
        Intrinsics.h(obj2, "value");
        return 1;
    }

    public final Map<Object, Object> snapshot() {
        LinkedHashMap linkedHashMap;
        synchronized (this.lock) {
            linkedHashMap = new LinkedHashMap(this.map.b().size());
            for (Map.Entry entry : this.map.b()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public String toString() {
        String str;
        synchronized (this.lock) {
            try {
                int i5 = this.hitCount;
                int i6 = this.missCount + i5;
                str = "LruCache[maxSize=" + this.maxSize + ",hits=" + this.hitCount + ",misses=" + this.missCount + ",hitRate=" + (i6 != 0 ? (i5 * 100) / i6 : 0) + "%]";
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0062, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x001c A[Catch: all -> 0x0015, TryCatch #0 {all -> 0x0015, blocks: (B:4:0x0003, B:6:0x0008, B:8:0x0010, B:13:0x001c, B:14:0x0021, B:16:0x0025, B:18:0x002e, B:20:0x0040), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0040 A[Catch: all -> 0x0015, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0015, blocks: (B:4:0x0003, B:6:0x0008, B:8:0x0010, B:13:0x001c, B:14:0x0021, B:16:0x0025, B:18:0x002e, B:20:0x0040), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void trimToSize(int i5) {
        boolean z5;
        Map.Entry entry;
        Object key;
        Object value;
        while (true) {
            synchronized (this.lock) {
                try {
                    if (this.size < 0 || (this.map.c() && this.size != 0)) {
                        z5 = false;
                        if (!z5) {
                            n.d.b("LruCache.sizeOf() is reporting inconsistent results!");
                        }
                        if (this.size > i5 || this.map.c()) {
                            break;
                        }
                        entry = (Map.Entry) CollectionsKt.j0(this.map.b());
                        if (entry != null) {
                            return;
                        }
                        key = entry.getKey();
                        value = entry.getValue();
                        this.map.e(key);
                        this.size -= a(key, value);
                        this.evictionCount++;
                    }
                    z5 = true;
                    if (!z5) {
                    }
                    if (this.size > i5) {
                        break;
                        break;
                    } else {
                        entry = (Map.Entry) CollectionsKt.j0(this.map.b());
                        if (entry != null) {
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            entryRemoved(true, key, value, null);
        }
    }
}
