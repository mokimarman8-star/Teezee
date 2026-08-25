package com.transsion.baselib.report.launch;

import android.app.Application;
import i5.a;
import i5.d;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class RoomInstallReferrer$b implements i5.c {
    final /* synthetic */ Application a;

    RoomInstallReferrer$b(Application application) {
        this.a = application;
    }

    public void onInstallReferrerServiceDisconnected() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0034, code lost:
    
        kotlin.jvm.internal.Intrinsics.y("referrerClient");
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0039, code lost:
    
        r0.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x004d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0038, code lost:
    
        r0 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004a, code lost:
    
        if (r6 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0032, code lost:
    
        if (r6 == null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onInstallReferrerSetupFinished(int i) {
        a c;
        a aVar = null;
        try {
            try {
                try {
                    if (i == 0) {
                        RoomInstallReferrer roomInstallReferrer = RoomInstallReferrer.a;
                        Application application = this.a;
                        a c2 = RoomInstallReferrer.c();
                        if (c2 == null) {
                            Intrinsics.y("referrerClient");
                            c2 = null;
                        }
                        d b = c2.b();
                        Intrinsics.g(b, "getInstallReferrer(...)");
                        RoomInstallReferrer.a(roomInstallReferrer, application, b);
                    } else {
                        RoomInstallReferrer.b(RoomInstallReferrer.a, this.a, String.valueOf(i));
                    }
                    c = RoomInstallReferrer.c();
                } catch (Exception unused) {
                    RoomInstallReferrer.b(RoomInstallReferrer.a, this.a, "unknown err");
                    c = RoomInstallReferrer.c();
                }
            } catch (Exception unused2) {
            }
        } finally {
            try {
                a c3 = RoomInstallReferrer.c();
                if (c3 == null) {
                    Intrinsics.y("referrerClient");
                } else {
                    aVar = c3;
                }
                aVar.a();
            } catch (Exception unused3) {
            }
        }
    }
}
