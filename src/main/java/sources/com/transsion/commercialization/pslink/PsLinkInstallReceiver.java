package com.transsion.commercialization.pslink;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import com.blankj.utilcode.util.Utils;
import com.transsion.gslb.BuildConfig;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ!\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/transsion/commercialization/pslink/PsLinkInstallReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "Landroid/content/Intent;", "intent", BuildConfig.FLAVOR, "action", "c", "(Landroid/content/Intent;Ljava/lang/String;)Ljava/lang/String;", "Landroid/content/Context;", "context", BuildConfig.FLAVOR, "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "a", "Commercialization_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PsLinkInstallReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static PsLinkInstallReceiver b;

    /* renamed from: com.transsion.commercialization.pslink.PsLinkInstallReceiver$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a() {
            if (PsLinkInstallReceiver.b == null) {
                PsLinkInstallReceiver.b = new PsLinkInstallReceiver();
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
            intentFilter.addDataScheme("package");
            if (Build.VERSION.SDK_INT >= 33) {
                Utils.a().registerReceiver(PsLinkInstallReceiver.b, intentFilter, 2);
            } else {
                Utils.a().registerReceiver(PsLinkInstallReceiver.b, intentFilter);
            }
            a.a.a("PsLinkInstallReceiver --> registerInstallReceiver() --> registerReceiver PsLinkInstallReceiver success");
        }

        public final void b() {
            if (PsLinkInstallReceiver.b != null) {
                Utils.a().unregisterReceiver(PsLinkInstallReceiver.b);
                PsLinkInstallReceiver.b = null;
                a.a.a("PsLinkInstallReceiver --> registerInstallReceiver() --> unregisterReceiver PsLinkInstallReceiver success");
            }
        }
    }

    private final String c(Intent intent, String action) {
        Uri data = intent.getData();
        String schemeSpecificPart = data != null ? data.getSchemeSpecificPart() : null;
        a.a.a("PsLinkInstallReceiver --> onReceive() --> packageName = " + schemeSpecificPart + " -- action = " + action);
        return schemeSpecificPart;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intrinsics.h(intent, "intent");
        String action = intent.getAction();
        if (Intrinsics.c("android.intent.action.PACKAGE_REPLACED", action) || Intrinsics.c("android.intent.action.PACKAGE_ADDED", action)) {
            String c = c(intent, action);
            Iterator it = PsLinkServiceHelper.a.i().iterator();
            while (it.hasNext()) {
                ((b) it.next()).a("installApp", BuildConfig.FLAVOR, null, c);
            }
            return;
        }
        if (Intrinsics.c("android.intent.action.PACKAGE_REMOVED", action)) {
            String c2 = c(intent, action);
            Iterator it2 = PsLinkServiceHelper.a.i().iterator();
            while (it2.hasNext()) {
                ((b) it2.next()).a("removedApp", BuildConfig.FLAVOR, null, c2);
            }
        }
    }
}
