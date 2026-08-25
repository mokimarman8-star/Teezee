package com.bumptech.glide.integration.webp;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface WebpHeaderParser$Reader {
    int getByte() throws IOException;

    int getUInt16() throws IOException;

    short getUInt8() throws IOException;

    int read(byte[] bArr, int i) throws IOException;

    long skip(long j) throws IOException;
}
