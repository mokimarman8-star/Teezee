package com.transsion.baseui.music;

import androidx.lifecycle.u;
import com.transsion.player.mediasession.MediaItem;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a implements androidx.lifecycle.f {
    public static final a a = new a();

    private a() {
    }

    public /* synthetic */ void onCreate(u uVar) {
        androidx.lifecycle.e.a(this, uVar);
    }

    public /* synthetic */ void onDestroy(u uVar) {
        androidx.lifecycle.e.b(this, uVar);
    }

    public /* synthetic */ void onPause(u uVar) {
        androidx.lifecycle.e.c(this, uVar);
    }

    public /* synthetic */ void onResume(u uVar) {
        androidx.lifecycle.e.d(this, uVar);
    }

    public void onStart(u uVar) {
        Intrinsics.h(uVar, "owner");
        androidx.lifecycle.e.e(this, uVar);
        MediaItem q = MusicFloatManager.h.b().q();
        if (q != null) {
            q.setInBackground(Boolean.FALSE);
        }
    }

    public void onStop(u uVar) {
        Intrinsics.h(uVar, "owner");
        androidx.lifecycle.e.f(this, uVar);
        MediaItem q = MusicFloatManager.h.b().q();
        if (q != null) {
            q.setInBackground(Boolean.TRUE);
        }
        MusicReport.a.c();
    }
}
