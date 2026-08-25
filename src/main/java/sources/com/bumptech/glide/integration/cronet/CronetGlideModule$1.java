package com.bumptech.glide.integration.cronet;

import android.content.Context;
import com.google.common.base.q;
import org.chromium.net.CronetEngine;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class CronetGlideModule$1 implements q {
    final /* synthetic */ CronetGlideModule this$0;
    final /* synthetic */ Context val$context;

    CronetGlideModule$1(CronetGlideModule cronetGlideModule, Context context) {
        this.this$0 = cronetGlideModule;
        this.val$context = context;
    }

    public CronetEngine get() {
        return CronetEngineSingleton.getSingleton(this.val$context);
    }
}
