package com.pgl.ssdk;

import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class c {

    public static class a extends r {
        public a(long j, long j2, int i, long j3, ByteBuffer byteBuffer) {
            super(j, j2, i, j3, byteBuffer);
        }
    }

    public static a a(o oVar) throws IOException, q {
        r a2 = d.a(oVar);
        return new a(a2.a(), a2.c(), a2.b(), a2.e(), a2.d());
    }
}
