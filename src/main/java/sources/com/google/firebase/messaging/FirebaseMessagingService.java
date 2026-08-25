package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.android.gms.cloudmessaging.Rpc;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ExecutorService;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class FirebaseMessagingService extends EnhancedIntentService {
    private static final Queue g = new ArrayDeque(10);
    private Rpc f;

    private boolean l(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Queue queue = g;
        if (!queue.contains(str)) {
            if (queue.size() >= 10) {
                queue.remove();
            }
            queue.add(str);
            return false;
        }
        if (!Log.isLoggable("FirebaseMessaging", 3)) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Received duplicate message: ");
        sb.append(str);
        return true;
    }

    private void m(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.remove("androidx.content.wakelockid");
        if (k0.t(extras)) {
            k0 k0Var = new k0(extras);
            ExecutorService e = n.e();
            try {
                if (new f(this, k0Var, e).a()) {
                    return;
                }
                e.shutdown();
                if (i0.D(intent)) {
                    i0.w(intent);
                }
            } finally {
                e.shutdown();
            }
        }
        r(new RemoteMessage(extras));
    }

    private String n(Intent intent) {
        String stringExtra = intent.getStringExtra("google.message_id");
        return stringExtra == null ? intent.getStringExtra("message_id") : stringExtra;
    }

    private Rpc o(Context context) {
        if (this.f == null) {
            this.f = new Rpc(context.getApplicationContext());
        }
        return this.f;
    }

    private void p(Intent intent) {
        if (!l(intent.getStringExtra("google.message_id"))) {
            v(intent);
        }
        o(this).messageHandled(new CloudMessage(intent));
    }

    private void v(Intent intent) {
        String stringExtra;
        stringExtra = intent.getStringExtra("message_type");
        if (stringExtra == null) {
            stringExtra = "gcm";
        }
        switch (stringExtra) {
            case "deleted_messages":
                q();
                break;
            case "gcm":
                i0.y(intent);
                m(intent);
                break;
            case "send_error":
                u(n(intent), new SendException(intent.getStringExtra("error")));
                break;
            case "send_event":
                s(intent.getStringExtra("google.message_id"));
                break;
            default:
                Log.w("FirebaseMessaging", "Received message with unknown type: " + stringExtra);
                break;
        }
    }

    @Override // com.google.firebase.messaging.EnhancedIntentService
    protected Intent e(Intent intent) {
        return v0.b().c();
    }

    @Override // com.google.firebase.messaging.EnhancedIntentService
    public void f(Intent intent) {
        String action = intent.getAction();
        if ("com.google.android.c2dm.intent.RECEIVE".equals(action) || "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(action)) {
            p(intent);
        } else {
            if ("com.google.firebase.messaging.NEW_TOKEN".equals(action)) {
                t(intent.getStringExtra("token"));
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unknown intent action: ");
            sb.append(intent.getAction());
        }
    }

    public void q() {
    }

    public void r(RemoteMessage remoteMessage) {
    }

    public void s(String str) {
    }

    public void t(String str) {
    }

    public void u(String str, Exception exc) {
    }
}
