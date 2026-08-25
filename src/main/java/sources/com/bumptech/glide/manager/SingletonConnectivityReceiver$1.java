package com.bumptech.glide.manager;

import android.content.Context;
import android.net.ConnectivityManager;
import com.bumptech.glide.util.GlideSuppliers;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class SingletonConnectivityReceiver$1 implements GlideSuppliers.GlideSupplier<ConnectivityManager> {
    final /* synthetic */ SingletonConnectivityReceiver this$0;
    final /* synthetic */ Context val$context;

    SingletonConnectivityReceiver$1(SingletonConnectivityReceiver singletonConnectivityReceiver, Context context) {
        this.this$0 = singletonConnectivityReceiver;
        this.val$context = context;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.util.GlideSuppliers.GlideSupplier
    public ConnectivityManager get() {
        return (ConnectivityManager) this.val$context.getSystemService("connectivity");
    }
}
