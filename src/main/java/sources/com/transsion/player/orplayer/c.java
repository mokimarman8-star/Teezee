package com.transsion.player.orplayer;

import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.Utils;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c implements AudioManager.OnAudioFocusChangeListener {
    private final d a;
    private final Function1 b;
    private String c;
    private final AudioManager d;
    private boolean e;
    private boolean f;
    private boolean g;
    private AudioFocusRequest h;

    public c(d dVar, Function1 function1) {
        Intrinsics.h(dVar, "player");
        Intrinsics.h(function1, "callback");
        this.a = dVar;
        this.b = function1;
        this.c = "AudioFocusHelper";
        Object systemService = Utils.a().getApplicationContext().getSystemService("audio");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.d = (AudioManager) systemService;
        sn.e.b(sn.e.a, this.c, "AudioFocusHelper orPlayer " + this, false, 4, null);
        if (Build.VERSION.SDK_INT >= 26) {
            AudioFocusRequest.Builder a = t1.a.a(1);
            AudioAttributes.Builder builder = new AudioAttributes.Builder();
            builder.setUsage(14);
            builder.setContentType(2);
            t1.b.a(a, builder.build());
            a.setAcceptsDelayedFocusGain(true);
            com.google.android.exoplayer2.d.a(a, this);
            this.h = t1.e.a(a);
        }
    }

    private final void c(int i) {
        sn.e eVar = sn.e.a;
        sn.e.b(eVar, this.c, "handleAudioFocusChange ------------ " + this + ", focusChange = " + i, false, 4, null);
        if (i == -3) {
            if (!this.g || this.a.isMute()) {
                return;
            }
            sn.e.b(eVar, this.c, "handleAudioFocusChange AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK, focusChange = " + i, false, 4, null);
            this.a.setVolume(1.0f);
            return;
        }
        if (i == -2 || i == -1) {
            sn.e.i(eVar, this.c, "handleAudioFocusChange LOSS, focusChange = " + i + ", isUserPause = " + this.f, false, 4, null);
            this.b.invoke(Boolean.TRUE);
            if (this.g) {
                this.a.pause();
                return;
            }
            return;
        }
        if (i == 1 || i == 2) {
            sn.e.b(eVar, this.c, "handleAudioFocusChange GAIN, focusChange = " + i + "， mStartRequested = " + this.e + ", isUserPause = " + this.f, false, 4, null);
            this.b.invoke(Boolean.FALSE);
            if (this.e && !this.f) {
                this.a.play();
            }
            if (this.a.isMute()) {
                return;
            }
            this.a.setVolume(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(c cVar, int i) {
        cVar.c(i);
    }

    public final void b() {
        sn.e.b(sn.e.a, this.c, "abandonFocus " + this, false, 4, null);
        if (Build.VERSION.SDK_INT >= 26) {
            AudioFocusRequest audioFocusRequest = this.h;
            if (audioFocusRequest != null) {
                t1.j.a(this.d, audioFocusRequest);
            }
        } else {
            this.d.abandonAudioFocus(this);
        }
        this.e = false;
    }

    public final void e() {
        sn.e eVar = sn.e.a;
        sn.e.b(eVar, this.c, "requestFocus " + this, false, 4, null);
        if (Build.VERSION.SDK_INT >= 26) {
            AudioFocusRequest audioFocusRequest = this.h;
            if (audioFocusRequest != null) {
                int a = t1.k.a(this.d, audioFocusRequest);
                sn.e.b(eVar, this.c, "requestFocus, result:" + a, false, 4, null);
            }
        } else {
            int requestAudioFocus = this.d.requestAudioFocus(this, 3, 1);
            sn.e.b(eVar, this.c, "requestFocus, result:" + requestAudioFocus, false, 4, null);
        }
        this.e = true;
    }

    public final void f(boolean z) {
        this.g = z;
    }

    public final void g(boolean z) {
        this.f = z;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(final int i) {
        ThreadUtils.j(new Runnable() { // from class: com.transsion.player.orplayer.b
            @Override // java.lang.Runnable
            public final void run() {
                c.d(c.this, i);
            }
        });
    }
}
