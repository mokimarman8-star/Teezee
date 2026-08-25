package com.bykv.vk.openvk.preload.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class g extends i implements Iterable<i> {
    private final List<i> a = new ArrayList();

    @Override // com.bykv.vk.openvk.preload.a.i
    public final Number a() {
        if (this.a.size() == 1) {
            return this.a.get(0).a();
        }
        throw new IllegalStateException();
    }

    public final void a(i iVar) {
        if (iVar == null) {
            iVar = k.a;
        }
        this.a.add(iVar);
    }

    @Override // com.bykv.vk.openvk.preload.a.i
    public final String b() {
        if (this.a.size() == 1) {
            return this.a.get(0).b();
        }
        throw new IllegalStateException();
    }

    @Override // com.bykv.vk.openvk.preload.a.i
    public final boolean c() {
        if (this.a.size() == 1) {
            return this.a.get(0).c();
        }
        throw new IllegalStateException();
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof g) && ((g) obj).a.equals(this.a);
        }
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator<i> iterator() {
        return this.a.iterator();
    }
}
