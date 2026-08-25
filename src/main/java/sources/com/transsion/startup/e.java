package com.transsion.startup;

import kotlin.jvm.functions.Function2;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* synthetic */ class e implements Function2 {
    public final /* synthetic */ StartupManager a;

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return StartupManager.d(this.a, ((Boolean) obj).booleanValue(), (com.google.firebase.remoteconfig.a) obj2);
    }
}
