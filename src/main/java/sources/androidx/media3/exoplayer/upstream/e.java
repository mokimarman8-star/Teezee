package androidx.media3.exoplayer.upstream;

import android.os.Handler;
import androidx.media3.exoplayer.upstream.e;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface e {

    public interface a {

        /* renamed from: androidx.media3.exoplayer.upstream.e$a$a, reason: collision with other inner class name */
        public static final class C0084a {

            /* renamed from: a, reason: collision with root package name */
            private final CopyOnWriteArrayList f11637a = new CopyOnWriteArrayList();

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: androidx.media3.exoplayer.upstream.e$a$a$a, reason: collision with other inner class name */
            static final class C0085a {

                /* renamed from: a, reason: collision with root package name */
                private final Handler f11638a;

                /* renamed from: b, reason: collision with root package name */
                private final a f11639b;

                /* renamed from: c, reason: collision with root package name */
                private boolean f11640c;

                public C0085a(Handler handler, a aVar) {
                    this.f11638a = handler;
                    this.f11639b = aVar;
                }

                public void d() {
                    this.f11640c = true;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void d(C0085a c0085a, int i5, long j5, long j6) {
                c0085a.f11639b.onBandwidthSample(i5, j5, j6);
            }

            public void b(Handler handler, a aVar) {
                androidx.media3.common.util.a.e(handler);
                androidx.media3.common.util.a.e(aVar);
                e(aVar);
                this.f11637a.add(new C0085a(handler, aVar));
            }

            public void c(final int i5, final long j5, final long j6) {
                Iterator it = this.f11637a.iterator();
                while (it.hasNext()) {
                    final C0085a c0085a = (C0085a) it.next();
                    if (!c0085a.f11640c) {
                        c0085a.f11638a.post(new Runnable() { // from class: androidx.media3.exoplayer.upstream.d
                            @Override // java.lang.Runnable
                            public final void run() {
                                e.a.C0084a.d(e.a.C0084a.C0085a.this, i5, j5, j6);
                            }
                        });
                    }
                }
            }

            public void e(a aVar) {
                Iterator it = this.f11637a.iterator();
                while (it.hasNext()) {
                    C0085a c0085a = (C0085a) it.next();
                    if (c0085a.f11639b == aVar) {
                        c0085a.d();
                        this.f11637a.remove(c0085a);
                    }
                }
            }
        }

        void onBandwidthSample(int i5, long j5, long j6);
    }

    long a();

    w1.n b();

    void c(a aVar);

    void d(Handler handler, a aVar);

    long getBitrateEstimate();
}
