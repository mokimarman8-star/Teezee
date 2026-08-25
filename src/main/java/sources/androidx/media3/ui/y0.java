package androidx.media3.ui;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface y0 {

    public interface a {
        void l(y0 y0Var, long j5);

        void p(y0 y0Var, long j5);

        void r(y0 y0Var, long j5, boolean z5);
    }

    void addListener(a aVar);

    long getPreferredUpdateDelay();

    void setAdGroupTimesMs(long[] jArr, boolean[] zArr, int i5);

    void setBufferedPosition(long j5);

    void setDuration(long j5);

    void setEnabled(boolean z5);

    void setPosition(long j5);
}
