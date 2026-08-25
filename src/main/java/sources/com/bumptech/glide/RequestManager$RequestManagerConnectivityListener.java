package com.bumptech.glide;

import androidx.annotation.NonNull;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.manager.RequestTracker;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class RequestManager$RequestManagerConnectivityListener implements ConnectivityMonitor.ConnectivityListener {
    private final RequestTracker requestTracker;
    final /* synthetic */ RequestManager this$0;

    RequestManager$RequestManagerConnectivityListener(@NonNull RequestManager requestManager, RequestTracker requestTracker) {
        this.this$0 = requestManager;
        this.requestTracker = requestTracker;
    }

    @Override // com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener
    public void onConnectivityChanged(boolean z) {
        if (z) {
            synchronized (this.this$0) {
                this.requestTracker.restartRequests();
            }
        }
    }
}
