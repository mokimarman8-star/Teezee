package com.transsion.audio.player;

import android.text.TextUtils;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.gslb.BuildConfig;
import com.transsion.player.orplayer.PlayError;
import com.transsion.push.bean.MsgStyle;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    private AudioBean a;
    private final String b;
    private long c;
    private long d;
    private long e;
    private long f;
    private int g;
    private long h;
    private long i;
    private long j;
    private int k;
    private long l;
    private long m;
    private Integer n;

    public a(AudioBean audioBean) {
        Intrinsics.h(audioBean, "audioBean");
        this.b = a.class.getSimpleName();
        this.a = audioBean;
        this.c = System.currentTimeMillis();
        a.a.f(wf.a.a, "video_play", "initView", false, 4, (Object) null);
    }

    private final void a() {
        String str;
        String str2;
        Long duration;
        String ops;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        AudioBean audioBean = this.a;
        String str3 = BuildConfig.FLAVOR;
        if (audioBean == null || (str = audioBean.getPostId()) == null) {
            str = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("post_id", str);
        AudioBean audioBean2 = this.a;
        if (audioBean2 == null || (str2 = audioBean2.getSubjectId()) == null) {
            str2 = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("subject_id", str2);
        AudioBean audioBean3 = this.a;
        if (!TextUtils.isEmpty(audioBean3 != null ? audioBean3.getOps() : null)) {
            AudioBean audioBean4 = this.a;
            if (audioBean4 != null && (ops = audioBean4.getOps()) != null) {
                str3 = ops;
            }
            linkedHashMap.put("ops", str3);
        }
        if (this.d > 0) {
            linkedHashMap.put("is_start", MsgStyle.CUSTOM_LEFT_PIC);
            linkedHashMap.put("delay_v", String.valueOf(this.d - this.c));
            linkedHashMap.put("buffer_time", String.valueOf(this.e));
            linkedHashMap.put("buffer_count", String.valueOf(this.g));
            float f = this.h;
            AudioBean audioBean5 = this.a;
            linkedHashMap.put("play_complete", String.valueOf(((f / ((audioBean5 == null || (duration = audioBean5.getDuration()) == null) ? 1L : duration.longValue())) * 100.0f) + (this.k * 100.0f)));
            linkedHashMap.put("play_duration", String.valueOf(this.j));
            linkedHashMap.put("pause_duration", String.valueOf(this.m));
        } else {
            linkedHashMap.put("is_start", "0");
            linkedHashMap.put("delay_v", String.valueOf(System.currentTimeMillis() - this.c));
        }
        Integer num = this.n;
        if (num != null) {
            linkedHashMap.put("error_code", String.valueOf(num));
        }
        qi.h.a.C("postdetail", "audio_play", this.j, linkedHashMap);
    }

    public final void b() {
        a();
    }

    public final void c() {
        if (this.d > 0) {
            this.f = System.currentTimeMillis();
        }
    }

    public final void d() {
        if (this.f > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.f;
            this.f = currentTimeMillis;
            this.e += currentTimeMillis;
            this.g++;
        }
    }

    public final void e(PlayError playError) {
        Intrinsics.h(playError, "errorInfo");
        this.n = playError.getErrorCode();
    }

    public final void f(long j) {
        long j2 = this.i;
        long j3 = j - j2;
        if (1 <= j3 && j3 < 1000) {
            this.j += j - j2;
        }
        this.i = j;
        if (j > this.h) {
            this.h = j;
        }
    }

    public final void g() {
        a.a.f(wf.a.a, "video_play", "onRenderFirstFrame", false, 4, (Object) null);
        if (this.d > 0) {
            return;
        }
        this.d = System.currentTimeMillis();
    }

    public final void h() {
        this.l = System.currentTimeMillis();
    }

    public final void i() {
        if (this.l != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.l;
            this.l = currentTimeMillis;
            this.m += currentTimeMillis;
        }
    }
}
