package com.cloud.tmc.miniapp.prestrategy.strategy;

import android.content.Context;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.offline.download.OfflineManager;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO0O0 {
    public static final OooO0O0 OooO00o = new OooO0O0();
    public static List<String> OooO0O0 = new CopyOnWriteArrayList();
    public static int OooO0OO = 3;

    public static final class OooO00o extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ String OooO00o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO00o(String str) {
            super(1);
            this.OooO00o = str;
        }

        public final void OooO00o(boolean z) {
            ((CopyOnWriteArrayList) OooO0O0.OooO0O0).remove(this.OooO00o);
            TmcLogger.e("PreOfflinePackageStrategy", "preOfflinePackage task finish. success =" + z + " current size = " + ((CopyOnWriteArrayList) OooO0O0.OooO0O0).size());
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            OooO00o(((Boolean) obj).booleanValue());
            return Unit.a;
        }
    }

    public final void OooO00o(Context context, String str) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "appId");
        try {
            TmcLogger.e("PreOfflinePackageStrategy", "start preOfflinePackage appId = " + str + ", already exist size = " + ((CopyOnWriteArrayList) OooO0O0).size());
            int size = ((CopyOnWriteArrayList) OooO0O0).size();
            int i = OooO0OO;
            if (size >= i) {
                TmcLogger.e("PreOfflinePackageStrategy", "preOfflinePackage failed, because requestNum >= " + i + " return");
                return;
            }
            if (!((CopyOnWriteArrayList) OooO0O0).contains(str)) {
                ((CopyOnWriteArrayList) OooO0O0).add(str);
                OfflineManager.downloadPkgFromPlatform(str, true, new OooO00o(str));
            } else {
                TmcLogger.e("PreOfflinePackageStrategy", str + " preOffline task was processing. ");
            }
        } catch (Throwable th) {
            TmcLogger.e("PreOfflinePackageStrategy", th);
        }
    }
}
