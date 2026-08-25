package com.amazonaws.util;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
final class TimingInfoUnmodifiable extends TimingInfo {
    TimingInfoUnmodifiable(Long l, long j, Long l2) {
        super(l, j, l2);
    }

    @Override // com.amazonaws.util.TimingInfo
    public TimingInfo c() {
        throw new UnsupportedOperationException();
    }
}
