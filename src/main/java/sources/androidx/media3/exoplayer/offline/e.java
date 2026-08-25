package androidx.media3.exoplayer.offline;

import java.io.Closeable;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface e extends Closeable {
    c N();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    int getPosition();

    boolean moveToNext();

    boolean moveToPosition(int i5);
}
