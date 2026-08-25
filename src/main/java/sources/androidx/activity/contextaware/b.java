package androidx.activity.contextaware;

import android.content.Context;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final Set f99a = new CopyOnWriteArraySet();

    /* renamed from: b, reason: collision with root package name */
    private volatile Context f100b;

    public final void a(d dVar) {
        Intrinsics.h(dVar, "listener");
        Context context = this.f100b;
        if (context != null) {
            dVar.a(context);
        }
        this.f99a.add(dVar);
    }

    public final void b() {
        this.f100b = null;
    }

    public final void c(Context context) {
        Intrinsics.h(context, "context");
        this.f100b = context;
        Iterator it = this.f99a.iterator();
        while (it.hasNext()) {
            ((d) it.next()).a(context);
        }
    }

    public final Context d() {
        return this.f100b;
    }

    public final void e(d dVar) {
        Intrinsics.h(dVar, "listener");
        this.f99a.remove(dVar);
    }
}
