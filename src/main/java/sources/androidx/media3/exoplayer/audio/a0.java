package androidx.media3.exoplayer.audio;

import android.media.AudioTimestamp;
import android.media.AudioTrack;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class a0 {

    /* renamed from: a, reason: collision with root package name */
    private final a f9767a;

    /* renamed from: b, reason: collision with root package name */
    private int f9768b;

    /* renamed from: c, reason: collision with root package name */
    private long f9769c;

    /* renamed from: d, reason: collision with root package name */
    private long f9770d;

    /* renamed from: e, reason: collision with root package name */
    private long f9771e;

    /* renamed from: f, reason: collision with root package name */
    private long f9772f;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final AudioTrack f9773a;

        /* renamed from: b, reason: collision with root package name */
        private final AudioTimestamp f9774b = new AudioTimestamp();

        /* renamed from: c, reason: collision with root package name */
        private long f9775c;

        /* renamed from: d, reason: collision with root package name */
        private long f9776d;

        /* renamed from: e, reason: collision with root package name */
        private long f9777e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f9778f;

        /* renamed from: g, reason: collision with root package name */
        private long f9779g;

        public a(AudioTrack audioTrack) {
            this.f9773a = audioTrack;
        }

        public void a() {
            this.f9778f = true;
        }

        public long b() {
            return this.f9777e;
        }

        public long c() {
            return this.f9774b.nanoTime / 1000;
        }

        public boolean d() {
            boolean timestamp = this.f9773a.getTimestamp(this.f9774b);
            if (timestamp) {
                long j5 = this.f9774b.framePosition;
                long j6 = this.f9776d;
                if (j6 > j5) {
                    if (this.f9778f) {
                        this.f9779g += j6;
                        this.f9778f = false;
                    } else {
                        this.f9775c++;
                    }
                }
                this.f9776d = j5;
                this.f9777e = j5 + this.f9779g + (this.f9775c << 32);
            }
            return timestamp;
        }
    }

    public a0(AudioTrack audioTrack) {
        this.f9767a = new a(audioTrack);
        h();
    }

    private void i(int i5) {
        this.f9768b = i5;
        if (i5 == 0) {
            this.f9771e = 0L;
            this.f9772f = -1L;
            this.f9769c = System.nanoTime() / 1000;
            this.f9770d = 10000L;
            return;
        }
        if (i5 == 1) {
            this.f9770d = 10000L;
            return;
        }
        if (i5 == 2 || i5 == 3) {
            this.f9770d = 10000000L;
        } else {
            if (i5 != 4) {
                throw new IllegalStateException();
            }
            this.f9770d = 500000L;
        }
    }

    public void a() {
        if (this.f9768b == 4) {
            h();
        }
    }

    public void b() {
        a aVar = this.f9767a;
        if (aVar != null) {
            aVar.a();
        }
    }

    public long c() {
        a aVar = this.f9767a;
        if (aVar != null) {
            return aVar.b();
        }
        return -1L;
    }

    public long d() {
        a aVar = this.f9767a;
        if (aVar != null) {
            return aVar.c();
        }
        return -9223372036854775807L;
    }

    public boolean e() {
        return this.f9768b == 2;
    }

    public boolean f(long j5) {
        a aVar = this.f9767a;
        if (aVar == null || j5 - this.f9771e < this.f9770d) {
            return false;
        }
        this.f9771e = j5;
        boolean d5 = aVar.d();
        int i5 = this.f9768b;
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        if (i5 != 4) {
                            throw new IllegalStateException();
                        }
                    } else if (d5) {
                        h();
                    }
                } else if (!d5) {
                    h();
                }
            } else if (!d5) {
                h();
            } else if (this.f9767a.b() > this.f9772f) {
                i(2);
            }
        } else if (d5) {
            if (this.f9767a.c() < this.f9769c) {
                return false;
            }
            this.f9772f = this.f9767a.b();
            i(1);
        } else if (j5 - this.f9769c > 500000) {
            i(3);
        }
        return d5;
    }

    public void g() {
        i(4);
    }

    public void h() {
        if (this.f9767a != null) {
            i(0);
        }
    }
}
