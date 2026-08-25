package com.mbridge.msdk.playercommon.exoplayer2.upstream;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public interface Allocator {
    Allocation allocate();

    int getIndividualAllocationLength();

    int getTotalBytesAllocated();

    void release(Allocation allocation);

    void release(Allocation[] allocationArr);

    void trim();
}
