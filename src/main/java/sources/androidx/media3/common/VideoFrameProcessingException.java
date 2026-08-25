package androidx.media3.common;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class VideoFrameProcessingException extends Exception {
    public final long presentationTimeUs;

    public VideoFrameProcessingException(String str) {
        this(str, -9223372036854775807L);
    }

    public VideoFrameProcessingException(String str, long j5) {
        super(str);
        this.presentationTimeUs = j5;
    }

    public VideoFrameProcessingException(String str, Throwable th) {
        this(str, th, -9223372036854775807L);
    }

    public VideoFrameProcessingException(String str, Throwable th, long j5) {
        super(str, th);
        this.presentationTimeUs = j5;
    }

    public VideoFrameProcessingException(Throwable th) {
        this(th, -9223372036854775807L);
    }

    public VideoFrameProcessingException(Throwable th, long j5) {
        super(th);
        this.presentationTimeUs = j5;
    }

    public static VideoFrameProcessingException from(Exception exc) {
        return from(exc, -9223372036854775807L);
    }

    public static VideoFrameProcessingException from(Exception exc, long j5) {
        return exc instanceof VideoFrameProcessingException ? (VideoFrameProcessingException) exc : new VideoFrameProcessingException(exc, j5);
    }
}
