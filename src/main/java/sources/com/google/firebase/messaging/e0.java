package com.google.firebase.messaging;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.cloudmessaging.Rpc;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class e0 {
    private final com.google.firebase.f a;
    private final j0 b;
    private final Rpc c;
    private final kc.b d;
    private final kc.b e;
    private final lc.e f;

    e0(com.google.firebase.f fVar, j0 j0Var, Rpc rpc, kc.b bVar, kc.b bVar2, lc.e eVar) {
        this.a = fVar;
        this.b = j0Var;
        this.c = rpc;
        this.d = bVar;
        this.e = bVar2;
        this.f = eVar;
    }

    e0(com.google.firebase.f fVar, j0 j0Var, kc.b bVar, kc.b bVar2, lc.e eVar) {
        this(fVar, j0Var, new Rpc(fVar.k()), bVar, bVar2, eVar);
    }

    private static String b(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    private Task c(Task task) {
        return task.continueWith(new v3.m(), new Continuation() { // from class: com.google.firebase.messaging.d0
            public final Object then(Task task2) {
                String i;
                i = e0.this.i(task2);
                return i;
            }
        });
    }

    private String d() {
        try {
            return b(MessageDigest.getInstance("SHA-1").digest(this.a.m().getBytes()));
        } catch (NoSuchAlgorithmException unused) {
            return "[HASH-ERROR]";
        }
    }

    private String g(Bundle bundle) {
        if (bundle == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String string = bundle.getString("registration_id");
        if (string != null) {
            return string;
        }
        String string2 = bundle.getString("unregistered");
        if (string2 != null) {
            return string2;
        }
        String string3 = bundle.getString(CampaignEx.JSON_NATIVE_VIDEO_ERROR);
        if ("RST".equals(string3)) {
            throw new IOException("INSTANCE_ID_RESET");
        }
        if (string3 != null) {
            throw new IOException(string3);
        }
        Log.w("FirebaseMessaging", "Unexpected response: " + bundle, new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    static boolean h(String str) {
        return "SERVICE_NOT_AVAILABLE".equals(str) || "INTERNAL_SERVER_ERROR".equals(str) || "InternalServerError".equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String i(Task task) {
        return g((Bundle) task.getResult(IOException.class));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00c0 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void j(String str, String str2, Bundle bundle) {
        HeartBeatInfo heartBeatInfo;
        HeartBeatInfo.HeartBeat b;
        bundle.putString("scope", str2);
        bundle.putString("sender", str);
        bundle.putString("subtype", str);
        bundle.putString("gmp_app_id", this.a.n().c());
        bundle.putString("gmsv", Integer.toString(this.b.d()));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.b.a());
        bundle.putString("app_ver_name", this.b.b());
        bundle.putString("firebase-app-name-hash", d());
        try {
            String b2 = ((com.google.firebase.installations.f) Tasks.await(this.f.a(false))).b();
            if (TextUtils.isEmpty(b2)) {
                Log.w("FirebaseMessaging", "FIS auth token is empty");
            } else {
                bundle.putString("Goog-Firebase-Installations-Auth", b2);
            }
        } catch (InterruptedException e) {
            e = e;
            Log.e("FirebaseMessaging", "Failed to get FIS auth token", e);
            bundle.putString("appid", (String) Tasks.await(this.f.getId()));
            bundle.putString("cliv", "fcm-25.0.1");
            heartBeatInfo = (HeartBeatInfo) this.e.get();
            zc.i iVar = (zc.i) this.d.get();
            if (heartBeatInfo == null) {
                return;
            } else {
                return;
            }
        } catch (ExecutionException e2) {
            e = e2;
            Log.e("FirebaseMessaging", "Failed to get FIS auth token", e);
            bundle.putString("appid", (String) Tasks.await(this.f.getId()));
            bundle.putString("cliv", "fcm-25.0.1");
            heartBeatInfo = (HeartBeatInfo) this.e.get();
            zc.i iVar2 = (zc.i) this.d.get();
            if (heartBeatInfo == null) {
            }
        }
        bundle.putString("appid", (String) Tasks.await(this.f.getId()));
        bundle.putString("cliv", "fcm-25.0.1");
        heartBeatInfo = (HeartBeatInfo) this.e.get();
        zc.i iVar22 = (zc.i) this.d.get();
        if (heartBeatInfo == null || iVar22 == null || (b = heartBeatInfo.b("fire-iid")) == HeartBeatInfo.HeartBeat.NONE) {
            return;
        }
        bundle.putString("Firebase-Client-Log-Type", Integer.toString(b.getCode()));
        bundle.putString("Firebase-Client", iVar22.getUserAgent());
    }

    private Task l(String str, String str2, Bundle bundle) {
        try {
            j(str, str2, bundle);
            return this.c.send(bundle);
        } catch (InterruptedException | ExecutionException e) {
            return Tasks.forException(e);
        }
    }

    Task e() {
        return this.c.getProxiedNotificationData();
    }

    Task f() {
        return c(l(j0.c(this.a), "*", new Bundle()));
    }

    Task k(boolean z) {
        return this.c.setRetainProxiedNotifications(z);
    }

    Task m(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str2);
        return c(l(str, "/topics/" + str2, bundle));
    }

    Task n(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str2);
        bundle.putString("delete", "1");
        return c(l(str, "/topics/" + str2, bundle));
    }
}
