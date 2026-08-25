package com.google.firebase.installations;

import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class d implements g {
    private final h a;
    private final TaskCompletionSource b;

    public d(h hVar, TaskCompletionSource taskCompletionSource) {
        this.a = hVar;
        this.b = taskCompletionSource;
    }

    @Override // com.google.firebase.installations.g
    public boolean a(Exception exc) {
        this.b.trySetException(exc);
        return true;
    }

    @Override // com.google.firebase.installations.g
    public boolean b(com.google.firebase.installations.local.b bVar) {
        if (!bVar.k() || this.a.f(bVar)) {
            return false;
        }
        this.b.setResult(f.a().b(bVar.b()).d(bVar.c()).c(bVar.h()).a());
        return true;
    }
}
