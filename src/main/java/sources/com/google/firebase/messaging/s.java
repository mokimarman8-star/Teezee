package com.google.firebase.messaging;

import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final /* synthetic */ class s implements Runnable {
    public final /* synthetic */ FirebaseMessaging a;
    public final /* synthetic */ TaskCompletionSource b;

    public /* synthetic */ s(FirebaseMessaging firebaseMessaging, TaskCompletionSource taskCompletionSource) {
        this.a = firebaseMessaging;
        this.b = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FirebaseMessaging.c(this.a, this.b);
    }
}
