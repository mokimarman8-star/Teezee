package com.google.firebase.messaging;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final /* synthetic */ class r implements SuccessContinuation {
    public final /* synthetic */ String a;

    public final Task then(Object obj) {
        return FirebaseMessaging.d(this.a, (c1) obj);
    }
}
