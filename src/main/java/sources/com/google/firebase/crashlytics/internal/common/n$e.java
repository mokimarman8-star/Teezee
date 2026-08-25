package com.google.firebase.crashlytics.internal.common;

import android.os.Bundle;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.concurrent.Callable;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class n$e implements Callable {
    final /* synthetic */ long a;
    final /* synthetic */ n b;

    n$e(n nVar, long j) {
        this.b = nVar;
        this.a = j;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() {
        Bundle bundle = new Bundle();
        bundle.putInt("fatal", 1);
        bundle.putLong(CampaignEx.JSON_KEY_TIMESTAMP, this.a);
        n.e(this.b).a("_ae", bundle);
        return null;
    }
}
