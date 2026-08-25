package com.transsion.ad.monopoly.manager;

import com.transsion.gslb.BuildConfig;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import xh.b;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class c implements xh.b {
    private AtomicBoolean a = new AtomicBoolean(false);

    public final Object a(Continuation continuation) {
        if (this.a.get()) {
            return Unit.a;
        }
        this.a.set(true);
        Object b = b(continuation);
        return b == IntrinsicsKt.f() ? b : Unit.a;
    }

    public abstract Object b(Continuation continuation);

    @Override // xh.b
    public String getClassTag() {
        return b.a.a(this);
    }

    @Override // xh.b
    public String getLogTag() {
        return "ad_init";
    }

    @Override // xh.b
    public String getSceneId() {
        return BuildConfig.FLAVOR;
    }

    @Override // xh.b
    public void onLog(int i, String str, String str2, boolean z) {
        b.a.b(this, i, str, str2, z);
    }
}
