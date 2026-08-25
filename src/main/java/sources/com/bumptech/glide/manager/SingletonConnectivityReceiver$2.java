package com.bumptech.glide.manager;

import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.util.Util;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class SingletonConnectivityReceiver$2 implements ConnectivityMonitor.ConnectivityListener {
    final /* synthetic */ SingletonConnectivityReceiver this$0;

    SingletonConnectivityReceiver$2(SingletonConnectivityReceiver singletonConnectivityReceiver) {
        this.this$0 = singletonConnectivityReceiver;
    }

    @Override // com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener
    public void onConnectivityChanged(boolean z) {
        ArrayList arrayList;
        Util.assertMainThread();
        synchronized (this.this$0) {
            arrayList = new ArrayList(this.this$0.listeners);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((ConnectivityMonitor.ConnectivityListener) it.next()).onConnectivityChanged(z);
        }
    }
}
