package androidx.coroutines.impl.utils;

import androidx.work.impl.WorkDatabase;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private final WorkDatabase f14115a;

    public i(WorkDatabase workDatabase) {
        Intrinsics.h(workDatabase, "workDatabase");
        this.f14115a = workDatabase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer d(i iVar) {
        int d5;
        Intrinsics.h(iVar, "this$0");
        d5 = j.d(iVar.f14115a, "next_alarm_manager_id");
        return Integer.valueOf(d5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer f(i iVar, int i5, int i6) {
        int d5;
        Intrinsics.h(iVar, "this$0");
        d5 = j.d(iVar.f14115a, "next_job_scheduler_id");
        if (i5 > d5 || d5 > i6) {
            j.e(iVar.f14115a, "next_job_scheduler_id", i5 + 1);
        } else {
            i5 = d5;
        }
        return Integer.valueOf(i5);
    }

    public final int c() {
        Object Y = this.f14115a.Y(new Callable() { // from class: androidx.work.impl.utils.g
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Integer d5;
                d5 = i.d(i.this);
                return d5;
            }
        });
        Intrinsics.g(Y, "workDatabase.runInTransa…ANAGER_ID_KEY)\n        })");
        return ((Number) Y).intValue();
    }

    public final int e(final int i5, final int i6) {
        Object Y = this.f14115a.Y(new Callable() { // from class: androidx.work.impl.utils.h
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Integer f5;
                f5 = i.f(i.this, i5, i6);
                return f5;
            }
        });
        Intrinsics.g(Y, "workDatabase.runInTransa…            id\n        })");
        return ((Number) Y).intValue();
    }
}
