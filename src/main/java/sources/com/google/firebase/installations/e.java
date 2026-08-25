package com.google.firebase.installations;

import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class e implements g {
    final TaskCompletionSource a;

    public e(TaskCompletionSource taskCompletionSource) {
        this.a = taskCompletionSource;
    }

    @Override // com.google.firebase.installations.g
    public boolean a(Exception exc) {
        return false;
    }

    @Override // com.google.firebase.installations.g
    public boolean b(com.google.firebase.installations.local.b bVar) {
        if (!bVar.l() && !bVar.k() && !bVar.i()) {
            return false;
        }
        this.a.trySetResult(bVar.d());
        return true;
    }
}
