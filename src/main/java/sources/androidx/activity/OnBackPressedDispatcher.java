package androidx.activity;

import android.os.Build;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.core.util.a;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.r;
import androidx.lifecycle.u;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class OnBackPressedDispatcher {
    private final Runnable a;
    private final a b;
    private final ArrayDeque c;
    private u d;
    private OnBackInvokedCallback e;
    private OnBackInvokedDispatcher f;
    private boolean g;
    private boolean h;

    private final class c implements r, androidx.activity.c {
        private final Lifecycle a;
        private final u b;
        private androidx.activity.c c;
        final /* synthetic */ OnBackPressedDispatcher d;

        public c(OnBackPressedDispatcher onBackPressedDispatcher, Lifecycle lifecycle, u uVar) {
            Intrinsics.h(lifecycle, "lifecycle");
            Intrinsics.h(uVar, "onBackPressedCallback");
            this.d = onBackPressedDispatcher;
            this.a = lifecycle;
            this.b = uVar;
            lifecycle.a(this);
        }

        public void cancel() {
            this.a.d(this);
            this.b.removeCancellable(this);
            androidx.activity.c cVar = this.c;
            if (cVar != null) {
                cVar.cancel();
            }
            this.c = null;
        }

        public void onStateChanged(u uVar, Lifecycle.Event event) {
            Intrinsics.h(uVar, "source");
            Intrinsics.h(event, "event");
            if (event == Lifecycle.Event.ON_START) {
                this.c = this.d.j(this.b);
                return;
            }
            if (event != Lifecycle.Event.ON_STOP) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    cancel();
                }
            } else {
                androidx.activity.c cVar = this.c;
                if (cVar != null) {
                    cVar.cancel();
                }
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public OnBackPressedDispatcher() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.OnBackPressedDispatcher.<init>():void");
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this(runnable, null);
    }

    public /* synthetic */ OnBackPressedDispatcher(Runnable runnable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : runnable);
    }

    public OnBackPressedDispatcher(Runnable runnable, a aVar) {
        this.a = runnable;
        this.b = aVar;
        this.c = new ArrayDeque();
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            this.e = i >= 34 ? b.a.a(new 1(this), new 2(this), new 3(this), new 4(this)) : a.a.b(new 5(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object] */
    public final void k() {
        u uVar;
        u uVar2 = this.d;
        if (uVar2 == null) {
            ArrayDeque arrayDeque = this.c;
            ListIterator listIterator = arrayDeque.listIterator(arrayDeque.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    uVar = 0;
                    break;
                } else {
                    uVar = listIterator.previous();
                    if (((u) uVar).isEnabled()) {
                        break;
                    }
                }
            }
            uVar2 = uVar;
        }
        this.d = null;
        if (uVar2 != null) {
            uVar2.handleOnBackCancelled();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object] */
    public final void m(b bVar) {
        u uVar;
        u uVar2 = this.d;
        if (uVar2 == null) {
            ArrayDeque arrayDeque = this.c;
            ListIterator listIterator = arrayDeque.listIterator(arrayDeque.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    uVar = 0;
                    break;
                } else {
                    uVar = listIterator.previous();
                    if (((u) uVar).isEnabled()) {
                        break;
                    }
                }
            }
            uVar2 = uVar;
        }
        if (uVar2 != null) {
            uVar2.handleOnBackProgressed(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(b bVar) {
        Object obj;
        ArrayDeque arrayDeque = this.c;
        ListIterator listIterator = arrayDeque.listIterator(arrayDeque.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                obj = null;
                break;
            } else {
                obj = listIterator.previous();
                if (((u) obj).isEnabled()) {
                    break;
                }
            }
        }
        u uVar = (u) obj;
        if (this.d != null) {
            k();
        }
        this.d = uVar;
        if (uVar != null) {
            uVar.handleOnBackStarted(bVar);
        }
    }

    private final void p(boolean z) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f;
        OnBackInvokedCallback onBackInvokedCallback = this.e;
        if (onBackInvokedDispatcher == null || onBackInvokedCallback == null) {
            return;
        }
        if (z && !this.g) {
            a.a.d(onBackInvokedDispatcher, 0, onBackInvokedCallback);
            this.g = true;
        } else {
            if (z || !this.g) {
                return;
            }
            a.a.e(onBackInvokedDispatcher, onBackInvokedCallback);
            this.g = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        boolean z = this.h;
        ArrayDeque arrayDeque = this.c;
        boolean z2 = false;
        if (!(arrayDeque instanceof Collection) || !arrayDeque.isEmpty()) {
            Iterator it = arrayDeque.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((u) it.next()).isEnabled()) {
                    z2 = true;
                    break;
                }
            }
        }
        this.h = z2;
        if (z2 != z) {
            a aVar = this.b;
            if (aVar != null) {
                aVar.accept(Boolean.valueOf(z2));
            }
            if (Build.VERSION.SDK_INT >= 33) {
                p(z2);
            }
        }
    }

    public final void h(u uVar) {
        Intrinsics.h(uVar, "onBackPressedCallback");
        j(uVar);
    }

    public final void i(u uVar, u uVar2) {
        Intrinsics.h(uVar, "owner");
        Intrinsics.h(uVar2, "onBackPressedCallback");
        Lifecycle lifecycle = uVar.getLifecycle();
        if (lifecycle.b() == Lifecycle.State.DESTROYED) {
            return;
        }
        uVar2.addCancellable(new c(this, lifecycle, uVar2));
        q();
        uVar2.setEnabledChangedCallback$activity_release(new addCallback.1(this));
    }

    public final androidx.activity.c j(u uVar) {
        Intrinsics.h(uVar, "onBackPressedCallback");
        this.c.add(uVar);
        d dVar = new d(this, uVar);
        uVar.addCancellable(dVar);
        q();
        uVar.setEnabledChangedCallback$activity_release(new addCancellableCallback.1(this));
        return dVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object] */
    public final void l() {
        u uVar;
        u uVar2 = this.d;
        if (uVar2 == null) {
            ArrayDeque arrayDeque = this.c;
            ListIterator listIterator = arrayDeque.listIterator(arrayDeque.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    uVar = 0;
                    break;
                } else {
                    uVar = listIterator.previous();
                    if (((u) uVar).isEnabled()) {
                        break;
                    }
                }
            }
            uVar2 = uVar;
        }
        this.d = null;
        if (uVar2 != null) {
            uVar2.handleOnBackPressed();
            return;
        }
        Runnable runnable = this.a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void o(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        Intrinsics.h(onBackInvokedDispatcher, "invoker");
        this.f = onBackInvokedDispatcher;
        p(this.h);
    }
}
