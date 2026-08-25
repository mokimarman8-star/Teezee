package com.bytedance.adsdk.sP;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class sef<K, V> {
    private int Dq;
    private int EjP;
    private int HiB;
    private int Jcg;
    private final LinkedHashMap<K, V> Sj;
    private int TKC;
    private int sP;
    private int vS;

    public sef(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.TKC = i;
        this.Sj = new LinkedHashMap<>(0, 0.75f, true);
    }

    private int TKC(K k, V v) {
        int sP = sP(k, v);
        if (sP >= 0) {
            return sP;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    public final V Sj(K k) {
        V put;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            try {
                V v = this.Sj.get(k);
                if (v != null) {
                    this.Jcg++;
                    return v;
                }
                this.Dq++;
                V sP = sP(k);
                if (sP == null) {
                    return null;
                }
                synchronized (this) {
                    try {
                        this.HiB++;
                        put = this.Sj.put(k, sP);
                        if (put != null) {
                            this.Sj.put(k, put);
                        } else {
                            this.sP += TKC(k, sP);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (put != null) {
                    return put;
                }
                Sj(this.TKC);
                return sP;
            } finally {
            }
        }
    }

    public final V Sj(K k, V v) {
        V put;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            try {
                this.EjP++;
                this.sP += TKC(k, v);
                put = this.Sj.put(k, v);
                if (put != null) {
                    this.sP -= TKC(k, put);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Sj(this.TKC);
        return put;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x006f, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Sj(int i) {
        while (true) {
            synchronized (this) {
                try {
                    if (this.sP < 0 || (this.Sj.isEmpty() && this.sP != 0)) {
                        break;
                    }
                    if (this.sP <= i || this.Sj.isEmpty()) {
                        break;
                    }
                    Map.Entry<K, V> next = this.Sj.entrySet().iterator().next();
                    K key = next.getKey();
                    V value = next.getValue();
                    this.Sj.remove(key);
                    this.sP -= TKC(key, value);
                    this.vS++;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    protected int sP(K k, V v) {
        return 1;
    }

    protected V sP(K k) {
        return null;
    }

    public final synchronized String toString() {
        int i;
        int i2;
        try {
            i = this.Jcg;
            i2 = this.Dq + i;
        } catch (Throwable th) {
            throw th;
        }
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.TKC), Integer.valueOf(this.Jcg), Integer.valueOf(this.Dq), Integer.valueOf(i2 != 0 ? (i * 100) / i2 : 0));
    }
}
