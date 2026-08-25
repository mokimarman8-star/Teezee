package com.google.protobuf;

import java.nio.Buffer;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class e0 {
    private e0() {
    }

    static void clear(Buffer buffer) {
        buffer.clear();
    }

    static void flip(Buffer buffer) {
        buffer.flip();
    }

    static void limit(Buffer buffer, int i) {
        buffer.limit(i);
    }

    static void mark(Buffer buffer) {
        buffer.mark();
    }

    static void position(Buffer buffer, int i) {
        buffer.position(i);
    }

    static void reset(Buffer buffer) {
        buffer.reset();
    }
}
