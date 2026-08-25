package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class n$c implements SuccessContinuation {
    final /* synthetic */ n a;

    n$c(n nVar) {
        this.a = nVar;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Task then(Void r1) {
        return Tasks.forResult(Boolean.TRUE);
    }
}
