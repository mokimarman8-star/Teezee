package com.transsion.postdetail.shorttv.factory;

import android.app.Activity;
import android.view.MotionEvent;
import com.therouter.TheRouter;
import com.transsion.baseui.music.MusicFloatManager;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class j implements ur.j {
    @Override // ur.j
    public void a(WeakReference weakReference) {
        Intrinsics.h(weakReference, "refer");
        ep.b bVar = (ep.b) TheRouter.d(ep.b.class, new Object[0]);
        if (bVar != null) {
            bVar.g(weakReference);
        }
    }

    @Override // ur.j
    public void b() {
        ep.b bVar = (ep.b) TheRouter.d(ep.b.class, new Object[0]);
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // ur.j
    public void c(Activity activity, MotionEvent motionEvent) {
        Intrinsics.h(activity, "activity");
        Intrinsics.h(motionEvent, "event");
        MusicFloatManager.h.b().i(activity, motionEvent);
    }

    @Override // ur.j
    public void d() {
        MusicFloatManager.h.b().B(null);
        com.transsion.player.mediasession.h.a.p();
    }

    @Override // ur.j
    public void e(WeakReference weakReference) {
        Intrinsics.h(weakReference, "refer");
        ep.b bVar = (ep.b) TheRouter.d(ep.b.class, new Object[0]);
        if (bVar != null) {
            bVar.i(weakReference);
        }
    }
}
