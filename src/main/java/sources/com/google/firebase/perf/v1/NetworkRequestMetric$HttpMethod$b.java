package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.NetworkRequestMetric;
import com.google.protobuf.y;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class NetworkRequestMetric$HttpMethod$b implements y.e {
    static final y.e a = new NetworkRequestMetric$HttpMethod$b();

    private NetworkRequestMetric$HttpMethod$b() {
    }

    @Override // com.google.protobuf.y.e
    public boolean isInRange(int i) {
        return NetworkRequestMetric.HttpMethod.forNumber(i) != null;
    }
}
