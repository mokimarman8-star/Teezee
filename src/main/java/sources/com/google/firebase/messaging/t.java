package com.google.firebase.messaging;

import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.u0;
import com.google.firebase.messaging.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final /* synthetic */ class t implements u0.a {
    public final /* synthetic */ FirebaseMessaging a;
    public final /* synthetic */ String b;
    public final /* synthetic */ y0.a c;

    public /* synthetic */ t(FirebaseMessaging firebaseMessaging, String str, y0.a aVar) {
        this.a = firebaseMessaging;
        this.b = str;
        this.c = aVar;
    }

    @Override // com.google.firebase.messaging.u0.a
    public final Task start() {
        return FirebaseMessaging.h(this.a, this.b, this.c);
    }
}
