package com.bytedance.sdk.component.HiB.TKC.Sj;

import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class TKC<K, V> {
    private int Dq;
    private int EjP;
    private int HiB;
    private int Jcg;
    private final LinkedHashMap<K, SoftReference<V>> Sj;
    private int TKC;
    private int sP;
    private int vS;

    public TKC(int i) {
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
        V v;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            try {
                SoftReference<V> softReference = this.Sj.get(k);
                if (softReference != null) {
                    v = softReference.get();
                    if (v != null) {
                        this.Jcg++;
                        return v;
                    }
                    this.Sj.remove(k);
                } else {
                    v = null;
                }
                this.Dq++;
                V sP = sP(k);
                if (sP == null) {
                    return null;
                }
                synchronized (this) {
                    try {
                        this.HiB++;
                        SoftReference<V> put = this.Sj.put(k, new SoftReference<>(sP));
                        if (put != null) {
                            v = put.get();
                        }
                        if (v != null) {
                            this.Sj.put(k, put);
                        } else {
                            this.sP += TKC(k, sP);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (v != null) {
                    return v;
                }
                Sj(this.TKC);
                return sP;
            } finally {
            }
        }
    }

    public final V Sj(K k, V v) {
        V v2;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            try {
                this.EjP++;
                this.sP += TKC(k, v);
                SoftReference<V> put = this.Sj.put(k, new SoftReference<>(v));
                if (put != null) {
                    v2 = put.get();
                    if (v2 != null) {
                        this.sP -= TKC(k, v2);
                    }
                } else {
                    v2 = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Sj(this.TKC);
        return v2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0054, code lost:
    
        android.util.Log.e("LruCache", "oom maybe occured, clear cache. size= " + r3.sP + ", maxSize: " + r4);
        r3.sP = 0;
        r3.Sj.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x007a, code lost:
    
        return;
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
                    if (this.sP <= i) {
                        return;
                    }
                    Map.Entry<K, SoftReference<V>> next = this.Sj.entrySet().iterator().next();
                    if (next == null) {
                        return;
                    }
                    K key = next.getKey();
                    SoftReference<V> value = next.getValue();
                    this.Sj.remove(key);
                    if (value != null) {
                        this.sP -= TKC(key, value.get());
                    }
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
        return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.TKC), Integer.valueOf(this.Jcg), Integer.valueOf(this.Dq), Integer.valueOf(i2 != 0 ? (i * 100) / i2 : 0));
    }
}
