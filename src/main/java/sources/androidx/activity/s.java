package androidx.activity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f145a;

    /* renamed from: b, reason: collision with root package name */
    private final Function0 f146b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f147c;

    /* renamed from: d, reason: collision with root package name */
    private int f148d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f149e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f150f;

    /* renamed from: g, reason: collision with root package name */
    private final List f151g;

    /* renamed from: h, reason: collision with root package name */
    private final Runnable f152h;

    public s(Executor executor, Function0 function0) {
        Intrinsics.h(executor, "executor");
        Intrinsics.h(function0, "reportFullyDrawn");
        this.f145a = executor;
        this.f146b = function0;
        this.f147c = new Object();
        this.f151g = new ArrayList();
        this.f152h = new Runnable() { // from class: androidx.activity.r
            @Override // java.lang.Runnable
            public final void run() {
                s.d(s.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(s sVar) {
        synchronized (sVar.f147c) {
            try {
                sVar.f149e = false;
                if (sVar.f148d == 0 && !sVar.f150f) {
                    sVar.f146b.invoke();
                    sVar.b();
                }
                Unit unit = Unit.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        synchronized (this.f147c) {
            try {
                this.f150f = true;
                Iterator it = this.f151g.iterator();
                while (it.hasNext()) {
                    ((Function0) it.next()).invoke();
                }
                this.f151g.clear();
                Unit unit = Unit.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean c() {
        boolean z5;
        synchronized (this.f147c) {
            z5 = this.f150f;
        }
        return z5;
    }
}
