package androidx.activity;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import androidx.core.app.ActivityCompat;
import f.a;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class ComponentActivity$f extends ActivityResultRegistry {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ ComponentActivity f77i;

    ComponentActivity$f(ComponentActivity componentActivity) {
        this.f77i = componentActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(ComponentActivity$f componentActivity$f, int i5, a.C0141a c0141a) {
        componentActivity$f.f(i5, c0141a.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(ComponentActivity$f componentActivity$f, int i5, IntentSender.SendIntentException sendIntentException) {
        componentActivity$f.e(i5, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", sendIntentException));
    }

    public void i(final int i5, f.a aVar, Object obj, androidx.core.app.c cVar) {
        Bundle c5;
        Intrinsics.h(aVar, "contract");
        ComponentActivity componentActivity = this.f77i;
        final a.C0141a b5 = aVar.b(componentActivity, obj);
        if (b5 != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: androidx.activity.k
                @Override // java.lang.Runnable
                public final void run() {
                    ComponentActivity$f.s(ComponentActivity$f.this, i5, b5);
                }
            });
            return;
        }
        Intent a5 = aVar.a(componentActivity, obj);
        if (a5.getExtras() != null) {
            Bundle extras = a5.getExtras();
            Intrinsics.e(extras);
            if (extras.getClassLoader() == null) {
                a5.setExtrasClassLoader(componentActivity.getClassLoader());
            }
        }
        if (a5.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
            Bundle bundleExtra = a5.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            a5.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            c5 = bundleExtra;
        } else {
            c5 = cVar != null ? cVar.c() : null;
        }
        if (Intrinsics.c("androidx.activity.result.contract.action.REQUEST_PERMISSIONS", a5.getAction())) {
            String[] stringArrayExtra = a5.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            if (stringArrayExtra == null) {
                stringArrayExtra = new String[0];
            }
            ActivityCompat.g(componentActivity, stringArrayExtra, i5);
            return;
        }
        if (!Intrinsics.c("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST", a5.getAction())) {
            ActivityCompat.k(componentActivity, a5, i5, c5);
            return;
        }
        IntentSenderRequest intentSenderRequest = (IntentSenderRequest) a5.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
        try {
            Intrinsics.e(intentSenderRequest);
            ActivityCompat.l(componentActivity, intentSenderRequest.getIntentSender(), i5, intentSenderRequest.getFillInIntent(), intentSenderRequest.getFlagsMask(), intentSenderRequest.getFlagsValues(), 0, c5);
        } catch (IntentSender.SendIntentException e5) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: androidx.activity.l
                @Override // java.lang.Runnable
                public final void run() {
                    ComponentActivity$f.t(ComponentActivity$f.this, i5, e5);
                }
            });
        }
    }
}
