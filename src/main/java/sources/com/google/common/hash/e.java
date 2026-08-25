package com.google.common.hash;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public interface e extends i {
    e a(Object obj, Funnel funnel);

    HashCode b();

    e c(CharSequence charSequence);

    e d(byte[] bArr, int i, int i2);

    e e(ByteBuffer byteBuffer);

    e f(int i);

    e g(CharSequence charSequence, Charset charset);

    e h(long j);
}
