package com.bykv.vk.openvk.preload.b;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class d<IN, OUT> {
    private static AtomicLong d = new AtomicLong();
    d a;
    IN b;
    OUT c;
    private com.bykv.vk.openvk.preload.b.b.a e;
    private b f;
    private long g;

    public abstract Object a(b<OUT> bVar, IN in) throws Throwable;

    final void a(b bVar, d dVar, IN in, com.bykv.vk.openvk.preload.b.b.a aVar, Object[] objArr) {
        this.f = new m(bVar);
        this.a = dVar;
        this.b = in;
        this.e = aVar;
        if (dVar != null) {
            this.g = dVar.g;
        } else {
            long andIncrement = d.getAndIncrement();
            this.g = andIncrement;
            if (andIncrement < 0) {
                throw new RuntimeException("Pipeline ID use up!");
            }
        }
        a(objArr);
    }

    protected void a(Object... objArr) {
    }

    public final long b() {
        return this.g;
    }

    final void b(Throwable th) {
        com.bykv.vk.openvk.preload.b.b.a aVar = this.e;
        if (aVar == null) {
            return;
        }
        aVar.a(this.f, this, th);
    }

    final void c() {
        com.bykv.vk.openvk.preload.b.b.a aVar = this.e;
        if (aVar == null) {
            return;
        }
        aVar.a(this.f, this);
    }

    final void c(Throwable th) {
        com.bykv.vk.openvk.preload.b.b.a aVar = this.e;
        if (aVar == null) {
            return;
        }
        aVar.b(this.f, this, th);
    }

    final void d() {
        com.bykv.vk.openvk.preload.b.b.a aVar = this.e;
        if (aVar == null) {
            return;
        }
        aVar.c(this.f, this);
    }

    protected final void d(Throwable th) {
        com.bykv.vk.openvk.preload.b.b.a aVar = this.e;
        if (aVar == null) {
            return;
        }
        aVar.c(this.f, this, th);
    }

    final void e() {
        com.bykv.vk.openvk.preload.b.b.a aVar = this.e;
        if (aVar == null) {
            return;
        }
        aVar.b(this.f, this);
    }

    public final OUT f() {
        return this.c;
    }
}
