package androidx.datastore.preferences.protobuf;

import java.nio.Buffer;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract class y {
    static void a(Buffer buffer, int i5) {
        buffer.limit(i5);
    }

    static void b(Buffer buffer) {
        buffer.mark();
    }

    static void c(Buffer buffer, int i5) {
        buffer.position(i5);
    }

    static void d(Buffer buffer) {
        buffer.reset();
    }
}
