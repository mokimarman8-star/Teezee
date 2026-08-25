package com.google.firebase.perf.v1;

import com.google.protobuf.y;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class ApplicationProcessState$b implements y.e {
    static final y.e a = new ApplicationProcessState$b();

    private ApplicationProcessState$b() {
    }

    @Override // com.google.protobuf.y.e
    public boolean isInRange(int i) {
        return ApplicationProcessState.forNumber(i) != null;
    }
}
