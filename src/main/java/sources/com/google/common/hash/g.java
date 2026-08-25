package com.google.common.hash;

import java.nio.Buffer;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
abstract class g {
    static void a(Buffer buffer) {
        buffer.flip();
    }

    static void b(Buffer buffer, int i) {
        buffer.position(i);
    }
}
