package com.transsion.postdetail.shorttv;

import android.app.Activity;
import android.os.Bundle;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.therouter.router.RouteItem;
import com.transsion.baselib.report.k;
import com.transsion.moviedetailapi.SubjectType;
import cw.e;
import ij.t;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mf.b;
import pr.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class c {
    public static final a a = new a((DefaultConstructorMarker) null);
    private static final Lazy b = LazyKt.b(new b());

    /* JADX INFO: Access modifiers changed from: private */
    public static final c c() {
        return new c();
    }

    public final void d(RouteItem routeItem, b bVar) {
        Object obj;
        Object m34constructorimpl;
        Intrinsics.h(routeItem, "postcard");
        Intrinsics.h(bVar, "callback");
        Iterator it = k.a.m().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            String localClassName = ((Activity) obj).getLocalClassName();
            Intrinsics.g(localClassName, "getLocalClassName(...)");
            if (StringsKt.c0(localClassName, "MainActivity", false, 2, (Object) null)) {
                break;
            }
        }
        Activity activity = (Activity) obj;
        if (activity == null) {
            activity = k.a.o();
        }
        if (!Intrinsics.c(routeItem.getPath(), "/movie/detail")) {
            if (!Intrinsics.c(routeItem.getPath(), "/video/detail")) {
                bVar.a(routeItem);
                return;
            }
            try {
                Result.Companion companion = Result.Companion;
                if (routeItem.getExtras().getInt("subject_type", SubjectType.MOVIE.getValue()) == SubjectType.MUSIC.getValue()) {
                    if (activity != null && !activity.isDestroyed() && !activity.isFinishing()) {
                        Navigator.x(ij.k.b(TheRouter.c("/playvideo/music_detail"), routeItem.getExtras()), activity, (mf.c) null, 2, (Object) null);
                    }
                    fj.b.a(bVar);
                } else {
                    bVar.a(routeItem);
                }
                m34constructorimpl = Result.m34constructorimpl(Unit.a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                m34constructorimpl = Result.m34constructorimpl(ResultKt.a(th));
            }
            if (Result.m37exceptionOrNullimpl(m34constructorimpl) == null) {
                return;
            }
            bVar.a(routeItem);
            return;
        }
        try {
            Bundle extras = routeItem.getExtras();
            int i = extras.getInt("subject_type", SubjectType.MOVIE.getValue());
            boolean z = extras.getBoolean("without_intercept", false);
            e.b.a(e.a.b(), false, 1, (Object) null);
            if (!z && i == SubjectType.SHORT_TV.getValue()) {
                if (activity != null && !activity.isDestroyed() && !activity.isFinishing()) {
                    Navigator.x(ij.k.b(TheRouter.c(a.a.b()), routeItem.getExtras()), activity, (mf.c) null, 2, (Object) null);
                }
                fj.b.a(bVar);
                return;
            }
            if (i != SubjectType.MUSIC.getValue()) {
                if (!t.a.b()) {
                    bVar.a(routeItem);
                    return;
                }
                if (activity != null && !activity.isDestroyed() && !activity.isFinishing()) {
                    Navigator.x(ij.k.b(TheRouter.c("/playvideo/detail"), routeItem.getExtras()), activity, (mf.c) null, 2, (Object) null);
                }
                fj.b.a(bVar);
                return;
            }
            try {
                Result.Companion companion3 = Result.Companion;
                routeItem.getExtras().putBoolean("is_music_liked_fragment", extras.getBoolean("is_music_liked_fragment"));
                Result.m34constructorimpl(Unit.a);
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.Companion;
                Result.m34constructorimpl(ResultKt.a(th2));
            }
            if (activity != null && !activity.isDestroyed() && !activity.isFinishing()) {
                Navigator.x(ij.k.b(TheRouter.c("/playvideo/music_detail"), routeItem.getExtras()), activity, (mf.c) null, 2, (Object) null);
            }
            fj.b.a(bVar);
        } catch (Exception unused) {
            bVar.a(routeItem);
        }
    }
}
