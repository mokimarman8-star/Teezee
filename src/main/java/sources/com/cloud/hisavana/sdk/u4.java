package com.cloud.hisavana.sdk;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class u4 extends x1 implements Map {
    g4 h;

    class a extends g4 {
        a() {
        }

        @Override // com.cloud.hisavana.sdk.g4
        protected int a(Object obj) {
            return u4.this.c(obj);
        }

        @Override // com.cloud.hisavana.sdk.g4
        protected Object b(int i, int i2) {
            return u4.this.b[(i << 1) + i2];
        }

        @Override // com.cloud.hisavana.sdk.g4
        protected Object c(int i, Object obj) {
            return u4.this.f(i, obj);
        }

        @Override // com.cloud.hisavana.sdk.g4
        protected void d() {
            u4.this.clear();
        }

        @Override // com.cloud.hisavana.sdk.g4
        protected void e(int i) {
            u4.this.m(i);
        }

        @Override // com.cloud.hisavana.sdk.g4
        protected void f(Object obj, Object obj2) {
            u4.this.put(obj, obj2);
        }

        @Override // com.cloud.hisavana.sdk.g4
        protected int j(Object obj) {
            return u4.this.j(obj);
        }

        @Override // com.cloud.hisavana.sdk.g4
        protected Map k() {
            return u4.this;
        }

        @Override // com.cloud.hisavana.sdk.g4
        protected int n() {
            return u4.this.c;
        }
    }

    private g4 o() {
        if (this.h == null) {
            this.h = new a();
        }
        return this.h;
    }

    @Override // java.util.Map
    public Set entrySet() {
        return o().p();
    }

    @Override // java.util.Map
    public Set keySet() {
        return o().q();
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        k(this.c + map.size());
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection values() {
        return o().r();
    }
}
