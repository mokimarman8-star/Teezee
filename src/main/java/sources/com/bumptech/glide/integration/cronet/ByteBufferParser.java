package com.bumptech.glide.integration.cronet;

import java.nio.ByteBuffer;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
interface ByteBufferParser<T> {
    Class<T> getDataClass();

    T parse(ByteBuffer byteBuffer);
}
