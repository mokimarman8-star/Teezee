package com.cloud.tmc.miniapp;

import android.os.Bundle;
import com.cloud.tmc.kernel.proxy.network.IChangeUrlProxy;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class DynamicChangeUrlImpl implements IChangeUrlProxy {
    @Override // com.cloud.tmc.kernel.proxy.network.IChangeUrlProxy
    public Object getConfigValue(Bundle bundle, String str) {
        Intrinsics.h(str, "key");
        if (bundle != null) {
            return bundle.get(str);
        }
        return null;
    }
}
