package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.c;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
class h0 implements r {
    private final Object a;
    private final c.a b;

    h0(Object obj) {
        this.a = obj;
        this.b = c.c.c(obj.getClass());
    }

    public void onStateChanged(u uVar, Lifecycle.Event event) {
        this.b.a(uVar, event, this.a);
    }
}
