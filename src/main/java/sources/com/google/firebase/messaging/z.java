package com.google.firebase.messaging;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final /* synthetic */ class z implements SuccessContinuation {
    public final /* synthetic */ FirebaseMessaging a;
    public final /* synthetic */ String b;
    public final /* synthetic */ y0.a c;

    public /* synthetic */ z(FirebaseMessaging firebaseMessaging, String str, y0.a aVar) {
        this.a = firebaseMessaging;
        this.b = str;
        this.c = aVar;
    }

    public final Task then(Object obj) {
        return FirebaseMessaging.a(this.a, this.b, this.c, (String) obj);
    }
}
