package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Binder;
import android.os.Process;
import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.j1;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class g1 extends Binder {
    private final a a;

    interface a {
        Task a(Intent intent);
    }

    g1(a aVar) {
        this.a = aVar;
    }

    void c(final j1.a aVar) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException("Binding only allowed within app");
        }
        Log.isLoggable("FirebaseMessaging", 3);
        this.a.a(aVar.a).addOnCompleteListener(new v3.m(), new OnCompleteListener() { // from class: com.google.firebase.messaging.f1
            public final void onComplete(Task task) {
                j1.a.this.d();
            }
        });
    }
}
