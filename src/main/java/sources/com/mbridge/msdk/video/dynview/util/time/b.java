package com.mbridge.msdk.video.dynview.util.time;

import android.os.CountDownTimer;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class b {
    private long a = 0;
    private long b;
    private com.mbridge.msdk.video.dynview.util.time.a c;
    private a d;

    private static class a extends CountDownTimer {
        private com.mbridge.msdk.video.dynview.util.time.a a;

        public a(long j, long j2) {
            super(j, j2);
        }

        void a(com.mbridge.msdk.video.dynview.util.time.a aVar) {
            this.a = aVar;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            com.mbridge.msdk.video.dynview.util.time.a aVar = this.a;
            if (aVar != null) {
                aVar.onFinish();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            com.mbridge.msdk.video.dynview.util.time.a aVar = this.a;
            if (aVar != null) {
                aVar.onTick(j);
            }
        }
    }

    public b a(long j) {
        if (j < 0) {
            j = 1000;
        }
        this.b = j;
        return this;
    }

    public b a(com.mbridge.msdk.video.dynview.util.time.a aVar) {
        this.c = aVar;
        return this;
    }

    public void a() {
        a aVar = this.d;
        if (aVar != null) {
            aVar.cancel();
            this.d = null;
        }
    }

    public void a(long j, com.mbridge.msdk.video.dynview.util.time.a aVar) {
        this.a = j;
        this.c = aVar;
        b();
        a aVar2 = this.d;
        if (aVar2 != null) {
            aVar2.start();
        }
    }

    public b b(long j) {
        this.a = j;
        return this;
    }

    public void b() {
        a aVar = this.d;
        if (aVar != null) {
            aVar.cancel();
            this.d = null;
        }
        if (this.b <= 0) {
            this.b = this.a + 1000;
        }
        a aVar2 = new a(this.a, this.b);
        this.d = aVar2;
        aVar2.a(this.c);
    }

    public void c() {
        if (this.d == null) {
            b();
        }
        this.d.start();
    }
}
