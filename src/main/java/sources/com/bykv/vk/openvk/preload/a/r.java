package com.bykv.vk.openvk.preload.a;

import java.io.IOException;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class r<T> {
    public final r<T> a() {
        return new r<T>() { // from class: com.bykv.vk.openvk.preload.a.r.1
            @Override // com.bykv.vk.openvk.preload.a.r
            public final T a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() != com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    return (T) r.this.a(aVar);
                }
                aVar.j();
                return null;
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final void a(com.bykv.vk.openvk.preload.a.d.c cVar, T t) throws IOException {
                if (t == null) {
                    cVar.h();
                } else {
                    r.this.a(cVar, t);
                }
            }
        };
    }

    public abstract T a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException;

    public abstract void a(com.bykv.vk.openvk.preload.a.d.c cVar, T t) throws IOException;
}
