package androidx.coroutines.impl.utils;

import androidx.annotation.NonNull;
import androidx.coroutines.WorkInfo$State;
import androidx.coroutines.impl.WorkDatabase;
import androidx.work.impl.d0;
import androidx.work.impl.o;
import androidx.work.impl.s;
import androidx.work.impl.t;
import androidx.work.l;
import j4.b;
import j4.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class CancelWorkRunnable implements Runnable {
    private final o mOperation = new o();

    @NonNull
    public static CancelWorkRunnable forAll(@NonNull d0 d0Var) {
        return new 4(d0Var);
    }

    @NonNull
    public static CancelWorkRunnable forId(@NonNull UUID uuid, @NonNull d0 d0Var) {
        return new 1(d0Var, uuid);
    }

    @NonNull
    public static CancelWorkRunnable forName(@NonNull final String str, @NonNull final d0 d0Var, final boolean z) {
        return new CancelWorkRunnable() { // from class: androidx.work.impl.utils.CancelWorkRunnable.3
            @Override // androidx.coroutines.impl.utils.CancelWorkRunnable
            void runInternal() {
                WorkDatabase t = d0Var.t();
                t.k();
                try {
                    Iterator it = t.n0().g(str).iterator();
                    while (it.hasNext()) {
                        cancel(d0Var, (String) it.next());
                    }
                    t.e0();
                    t.t();
                    if (z) {
                        reschedulePendingWorkers(d0Var);
                    }
                } catch (Throwable th) {
                    t.t();
                    throw th;
                }
            }
        };
    }

    @NonNull
    public static CancelWorkRunnable forTag(@NonNull String str, @NonNull d0 d0Var) {
        return new 2(d0Var, str);
    }

    private void iterativelyCancelWorkAndDependents(WorkDatabase workDatabase, String str) {
        v n0 = workDatabase.n0();
        b h0 = workDatabase.h0();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            WorkInfo$State i = n0.i(str2);
            if (i != WorkInfo$State.SUCCEEDED && i != WorkInfo$State.FAILED) {
                n0.u(WorkInfo$State.CANCELLED, str2);
            }
            linkedList.addAll(h0.a(str2));
        }
    }

    void cancel(d0 d0Var, String str) {
        iterativelyCancelWorkAndDependents(d0Var.t(), str);
        d0Var.q().r(str);
        Iterator it = d0Var.r().iterator();
        while (it.hasNext()) {
            ((s) it.next()).b(str);
        }
    }

    @NonNull
    public l getOperation() {
        return this.mOperation;
    }

    void reschedulePendingWorkers(d0 d0Var) {
        t.b(d0Var.m(), d0Var.t(), d0Var.r());
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            runInternal();
            this.mOperation.a(l.a);
        } catch (Throwable th) {
            this.mOperation.a(new l.b.a(th));
        }
    }

    abstract void runInternal();
}
