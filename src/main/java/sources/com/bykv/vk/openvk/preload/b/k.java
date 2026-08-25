package com.bykv.vk.openvk.preload.b;

import com.bykv.vk.openvk.preload.b.i;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class k<IN, OUT> extends d<IN, OUT> {
    private IN d;

    private Object a(b<OUT> bVar, Throwable th) throws Throwable {
        while (a(th)) {
            try {
                return bVar.a((b<OUT>) a());
            } catch (i.a e) {
                th = e.getCause();
            } catch (Throwable th2) {
                th = th2;
            }
        }
        throw th;
    }

    protected OUT a() {
        return this.d;
    }

    @Override // com.bykv.vk.openvk.preload.b.d
    public final Object a(b<OUT> bVar, IN in) throws Throwable {
        this.d = in;
        try {
            return bVar.a((b<OUT>) a());
        } catch (i.a e) {
            return a((b) bVar, e.getCause());
        } catch (Throwable th) {
            return a((b) bVar, th);
        }
    }

    protected abstract boolean a(Throwable th);

    protected final IN g() {
        return this.d;
    }
}
