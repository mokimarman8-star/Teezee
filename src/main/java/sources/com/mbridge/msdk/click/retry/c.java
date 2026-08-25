package com.mbridge.msdk.click.retry;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class c {
    private final LinkedHashMap<String, b> a;
    private final int b;
    private int c;

    public c(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.b = i;
        this.a = new LinkedHashMap<>(0, 0.75f, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0071, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i) {
        while (true) {
            synchronized (this) {
                try {
                    if (this.c < 0 || (this.a.isEmpty() && this.c != 0)) {
                        break;
                    }
                    if (this.c <= i || this.a.isEmpty()) {
                        break;
                    }
                    Map.Entry<String, b> next = this.a.entrySet().iterator().next();
                    if (next == null) {
                        return;
                    }
                    String key = next.getKey();
                    try {
                        int b = b(key, next.getValue());
                        this.a.remove(key);
                        this.c -= b;
                    } catch (Throwable unused) {
                    }
                } finally {
                }
            }
        }
    }

    private int b(String str, b bVar) {
        return 1;
    }

    public final b a(String str) {
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            try {
                b bVar = this.a.get(str);
                if (bVar != null) {
                    return bVar;
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Collection<String> a() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.a.keySet());
        }
        return hashSet;
    }

    public final boolean a(String str, b bVar) {
        if (str == null || bVar == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            try {
                this.c += b(str, bVar);
                b put = this.a.put(str, bVar);
                if (put != null) {
                    this.c -= b(str, put);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        a(this.b);
        return true;
    }

    public final void b(String str) {
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            try {
                b remove = this.a.remove(str);
                if (remove != null) {
                    this.c -= b(str, remove);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized String toString() {
        return String.format("LruCache[maxSize=%d]", Integer.valueOf(this.b));
    }
}
