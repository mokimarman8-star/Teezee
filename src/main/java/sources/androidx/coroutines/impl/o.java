package androidx.coroutines.impl;

import androidx.coroutines.impl.utils.futures.a;
import androidx.coroutines.l;
import androidx.view.b0;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class o implements l {

    /* renamed from: c, reason: collision with root package name */
    private final b0 f14070c = new b0();

    /* renamed from: d, reason: collision with root package name */
    private final a f14071d = a.x();

    public o() {
        a(l.f14148b);
    }

    public void a(l.b bVar) {
        this.f14070c.n(bVar);
        if (bVar instanceof l.b.c) {
            this.f14071d.t((l.b.c) bVar);
        } else if (bVar instanceof l.b.a) {
            this.f14071d.u(((l.b.a) bVar).a());
        }
    }
}
