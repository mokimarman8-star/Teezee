package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class u {
    private final CopyOnWriteArrayList<c> cancellables = new CopyOnWriteArrayList<>();
    private Function0<Unit> enabledChangedCallback;
    private boolean isEnabled;

    public u(boolean z5) {
        this.isEnabled = z5;
    }

    @JvmName
    public final void addCancellable(c cVar) {
        Intrinsics.h(cVar, "cancellable");
        this.cancellables.add(cVar);
    }

    public final Function0<Unit> getEnabledChangedCallback$activity_release() {
        return this.enabledChangedCallback;
    }

    public void handleOnBackCancelled() {
    }

    public abstract void handleOnBackPressed();

    public void handleOnBackProgressed(b bVar) {
        Intrinsics.h(bVar, "backEvent");
    }

    public void handleOnBackStarted(b bVar) {
        Intrinsics.h(bVar, "backEvent");
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final void remove() {
        Iterator<T> it = this.cancellables.iterator();
        while (it.hasNext()) {
            ((c) it.next()).cancel();
        }
    }

    @JvmName
    public final void removeCancellable(c cVar) {
        Intrinsics.h(cVar, "cancellable");
        this.cancellables.remove(cVar);
    }

    public final void setEnabled(boolean z5) {
        this.isEnabled = z5;
        Function0<Unit> function0 = this.enabledChangedCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void setEnabledChangedCallback$activity_release(Function0<Unit> function0) {
        this.enabledChangedCallback = function0;
    }
}
