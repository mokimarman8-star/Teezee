package com.transsion.push.tpush;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PushRegisterManager$a implements f {
    PushRegisterManager$a() {
    }

    @Override // com.transsion.push.tpush.f
    public void a(String str) {
        Intrinsics.h(str, "token");
        PushRegisterManager.r(false);
        PushRegisterManager pushRegisterManager = PushRegisterManager.a;
        PushRegisterManager.p(pushRegisterManager);
        pushRegisterManager.N();
    }

    @Override // com.transsion.push.tpush.f
    public void b(long j, String str) {
        PushRegisterManager.o(PushRegisterManager.a, j, str);
    }

    @Override // com.transsion.push.tpush.f
    public void onSdkInitSuccess(String str, String str2) {
        PushRegisterManager.r(false);
        PushRegisterManager pushRegisterManager = PushRegisterManager.a;
        PushRegisterManager.p(pushRegisterManager);
        pushRegisterManager.N();
    }
}
