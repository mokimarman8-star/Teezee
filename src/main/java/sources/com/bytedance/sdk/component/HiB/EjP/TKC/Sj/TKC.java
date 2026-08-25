package com.bytedance.sdk.component.HiB.EjP.TKC.Sj;

import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class TKC<K, V> {
    private final LinkedHashMap<K, SoftReference<V>> Sj = new LinkedHashMap<>(0, 0.75f, true);
    private int sP;

    public TKC(int i) {
        this.sP = i;
    }

    public synchronized V Sj(K k) {
        V v = null;
        if (k == null) {
            return null;
        }
        if (this.sP <= 0) {
            return null;
        }
        SoftReference<V> softReference = this.Sj.get(k);
        if (softReference != null) {
            v = softReference.get();
            if (v != null) {
                return v;
            }
            this.Sj.remove(k);
        }
        return v;
    }

    public synchronized void Sj(int i) {
        int size = this.Sj.size() - i;
        if (size > 0) {
            Iterator<Map.Entry<K, SoftReference<V>>> it = this.Sj.entrySet().iterator();
            for (int i2 = 0; i2 < size; i2++) {
                it.next();
                it.remove();
            }
        }
        if (i == 0) {
            return;
        }
        Iterator<Map.Entry<K, SoftReference<V>>> it2 = this.Sj.entrySet().iterator();
        while (it2.hasNext()) {
            if (it2.next().getValue().get() == null) {
                it2.remove();
            }
        }
    }

    public synchronized void Sj(K k, V v) {
        if (this.sP <= 0) {
            return;
        }
        if (k == null || v == null) {
            return;
        }
        this.Sj.put(k, new SoftReference<>(v));
        int size = this.Sj.size();
        int i = this.sP;
        if (size > i) {
            Sj((int) (i * 0.7d));
        }
    }

    public final synchronized String toString() {
        return String.format("LruCache[maxCount=%d,size=%d]", Integer.valueOf(this.sP), Integer.valueOf(this.Sj.size()));
    }
}
