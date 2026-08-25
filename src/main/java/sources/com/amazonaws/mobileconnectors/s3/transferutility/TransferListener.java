package com.amazonaws.mobileconnectors.s3.transferutility;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface TransferListener {
    void a(int i, TransferState transferState);

    void b(int i, long j, long j2);

    void c(int i, Exception exc);
}
