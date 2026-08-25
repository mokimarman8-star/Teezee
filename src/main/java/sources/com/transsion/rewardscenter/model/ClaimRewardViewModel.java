package com.transsion.rewardscenter.model;

import android.app.Application;
import androidx.lifecycle.b0;
import androidx.lifecycle.u0;
import com.transsion.rewardscenterapi.ClaimReceiverRequest;
import kotlin.Pair;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ClaimRewardViewModel extends androidx.lifecycle.b {
    private final b0 b;
    private final b0 c;
    private final b0 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClaimRewardViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.b = new b0(Boolean.FALSE);
        this.c = new b0();
        this.d = new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(String str) {
        if (str.length() != 0) {
            kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new ClaimRewardViewModel$claim$1(str, this, null), 3, (Object) null);
        } else {
            this.b.n(Boolean.FALSE);
            this.c.n(new Pair((Object) null, (Object) null));
        }
    }

    public final b0 e() {
        return this.d;
    }

    public final b0 f() {
        return this.c;
    }

    public final b0 g() {
        return this.b;
    }

    public final void h(ClaimReceiverRequest claimReceiverRequest) {
        Intrinsics.h(claimReceiverRequest, "requestBody");
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new ClaimRewardViewModel$submitAndClaim$1(this, claimReceiverRequest, null), 3, (Object) null);
    }
}
