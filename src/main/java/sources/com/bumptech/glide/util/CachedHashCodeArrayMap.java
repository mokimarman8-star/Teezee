package com.bumptech.glide.util;

import androidx.collection.a;
import androidx.collection.x0;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class CachedHashCodeArrayMap<K, V> extends a {
    private int hashCode;

    public void clear() {
        this.hashCode = 0;
        super/*androidx.collection.x0*/.clear();
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = super/*androidx.collection.x0*/.hashCode();
        }
        return this.hashCode;
    }

    public V put(K k, V v) {
        this.hashCode = 0;
        return (V) super/*androidx.collection.x0*/.put(k, v);
    }

    public void putAll(x0 x0Var) {
        this.hashCode = 0;
        super/*androidx.collection.x0*/.putAll(x0Var);
    }

    public V removeAt(int i) {
        this.hashCode = 0;
        return (V) super/*androidx.collection.x0*/.removeAt(i);
    }

    public V setValueAt(int i, V v) {
        this.hashCode = 0;
        return (V) super/*androidx.collection.x0*/.setValueAt(i, v);
    }
}
