package androidx.media3.common.util;

import android.os.Looper;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface p {

    public interface a {
        void a();
    }

    boolean a(int i5);

    boolean b(a aVar);

    Looper getLooper();

    a obtainMessage(int i5);

    a obtainMessage(int i5, int i6, int i7);

    a obtainMessage(int i5, int i6, int i7, Object obj);

    a obtainMessage(int i5, Object obj);

    boolean post(Runnable runnable);

    void removeCallbacksAndMessages(Object obj);

    void removeMessages(int i5);

    boolean sendEmptyMessage(int i5);

    boolean sendEmptyMessageAtTime(int i5, long j5);
}
