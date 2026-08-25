package com.pgl.ssdk;

import com.pgl.ssdk.c;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class f {

    public static class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    public static h a(o oVar, c.a aVar, int i) throws IOException, a {
        try {
            return g.a(oVar, aVar, i);
        } catch (i e) {
            throw new a(e.getMessage());
        }
    }

    public static ByteBuffer a(ByteBuffer byteBuffer) throws com.pgl.ssdk.a {
        return g.b(byteBuffer);
    }

    public static byte[] b(ByteBuffer byteBuffer) throws com.pgl.ssdk.a {
        return g.c(byteBuffer);
    }
}
