package com.google.firebase.messaging;

import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.android.gms.tasks.OnSuccessListener;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final /* synthetic */ class y implements OnSuccessListener {
    public final /* synthetic */ FirebaseMessaging a;

    public final void onSuccess(Object obj) {
        FirebaseMessaging.g(this.a, (CloudMessage) obj);
    }
}
