package androidx.media3.decoder;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface g {
    void a(long j5);

    Object dequeueInputBuffer();

    Object dequeueOutputBuffer();

    void flush();

    String getName();

    void queueInputBuffer(Object obj);

    void release();
}
