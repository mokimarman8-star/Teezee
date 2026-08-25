package com.bykv.vk.openvk.preload.geckox.buffer.stream;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class b extends OutputStream {
    public abstract void write(long j, int i) throws IOException;

    public abstract void write(long j, byte[] bArr) throws IOException;

    public abstract void write(long j, byte[] bArr, int i, int i2) throws IOException;
}
