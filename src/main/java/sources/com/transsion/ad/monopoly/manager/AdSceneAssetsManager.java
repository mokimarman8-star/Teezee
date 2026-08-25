package com.transsion.ad.monopoly.manager;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.i;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AdSceneAssetsManager extends c {
    public static final AdSceneAssetsManager b = new AdSceneAssetsManager();

    private AdSceneAssetsManager() {
    }

    @Override // com.transsion.ad.monopoly.manager.c
    public Object b(Continuation continuation) {
        Object g = i.g(y0.b(), new AdSceneAssetsManager$innerCopy$2(null), continuation);
        return g == IntrinsicsKt.f() ? g : Unit.a;
    }
}
