package com.transsion.baseui.music;

import android.text.TextUtils;
import com.google.common.reflect.TypeToken;
import com.transsion.gslb.BuildConfig;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class MusicReport {
    public static final MusicReport a = new MusicReport();

    private MusicReport() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List b() {
        String string = com.transsion.baselib.report.launch.b.a.b().getString("music_play_duration", BuildConfig.FLAVOR);
        if (TextUtils.isEmpty(string)) {
            return new ArrayList();
        }
        Type type = new TypeToken<List<n>>() { // from class: com.transsion.baseui.music.MusicReport$getLocalHistoryList$personListType$1
        }.getType();
        Intrinsics.g(type, "getType(...)");
        Object e = com.blankj.utilcode.util.o.e(string, type);
        Intrinsics.e(e);
        return (List) e;
    }

    public final void c() {
        Object obj;
        List<n> b;
        try {
            Result.Companion companion = Result.Companion;
            b = a.b();
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        if (b.isEmpty()) {
            return;
        }
        for (n nVar : b) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("subject_id", String.valueOf(nVar.h()));
            linkedHashMap.put("trace_id", String.valueOf(nVar.d()));
            linkedHashMap.put("ops", String.valueOf(nVar.e()));
            linkedHashMap.put("play_duration", String.valueOf(nVar.f()));
            linkedHashMap.put("total_duration", String.valueOf(nVar.i()));
            linkedHashMap.put("video_bitrate", String.valueOf(nVar.j()));
            linkedHashMap.put("audio_bitrate", String.valueOf(nVar.a()));
            linkedHashMap.put("float_play_duration", String.valueOf(nVar.b()));
            linkedHashMap.put("in_bg_play_duration", String.valueOf(nVar.c()));
            qi.h.a.C("music_play", "music_play", nVar.f(), linkedHashMap);
            com.transsion.player.mediasession.i.a.a("MusicReport --> report() --> 上报播放时长 = " + linkedHashMap);
            com.transsion.baselib.report.launch.b.a.b().remove("music_play_duration");
        }
        obj = Result.constructor-impl(Unit.a);
        Throwable th3 = Result.exceptionOrNull-impl(obj);
        if (th3 == null) {
            return;
        }
        com.transsion.player.mediasession.i.a.b("MusicReport --> report() --> it = " + th3);
    }

    public final void d(n nVar) {
        Intrinsics.h(nVar, "musicPlayDurationBean");
        kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new MusicReport$saveLocal$1(nVar, null), 3, (Object) null);
    }
}
