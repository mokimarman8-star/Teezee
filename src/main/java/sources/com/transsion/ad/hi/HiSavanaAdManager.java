package com.transsion.ad.hi;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.transsion.ad.MBAd;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;
import kotlinx.coroutines.u0;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class HiSavanaAdManager {
    public static final HiSavanaAdManager a = new HiSavanaAdManager();
    private static AtomicBoolean b = new AtomicBoolean(false);
    private static AtomicBoolean c = new AtomicBoolean(false);
    private static final Set d = new LinkedHashSet();

    private HiSavanaAdManager() {
    }

    private final String c() {
        String simpleName = HiSavanaAdManager.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final boolean e() {
        tg.b bVar = tg.b.a;
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        return ((double) bVar.k(a2).totalMem) <= ((double) 1073741824) * ((double) com.transsion.ad.scene.b.a.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00a5 A[LOOP:0: B:11:0x009f->B:13:0x00a5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object g(Continuation continuation) {
        HiSavanaAdManager$onInitSuccess$1 hiSavanaAdManager$onInitSuccess$1;
        int i;
        Iterator it;
        if (continuation instanceof HiSavanaAdManager$onInitSuccess$1) {
            hiSavanaAdManager$onInitSuccess$1 = (HiSavanaAdManager$onInitSuccess$1) continuation;
            int i2 = hiSavanaAdManager$onInitSuccess$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                hiSavanaAdManager$onInitSuccess$1.label = i2 - Integer.MIN_VALUE;
                Object obj = hiSavanaAdManager$onInitSuccess$1.result;
                Object f = IntrinsicsKt.f();
                i = hiSavanaAdManager$onInitSuccess$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    MBAd.a b2 = MBAd.a.b();
                    if (b2 == null || b2.j()) {
                        xh.a.c(xh.a.a, c() + " --> initHiAdSdk() --> complete -- 媒体取消延时", 0, false, 6, null);
                    } else {
                        hiSavanaAdManager$onInitSuccess$1.label = 1;
                        if (u0.a(5000L, hiSavanaAdManager$onInitSuccess$1) == f) {
                            return f;
                        }
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                c.set(true);
                xh.a.c(xh.a.a, c() + " --> initHiAdSdk() --> complete -- isInitialized = " + c.get(), 0, false, 6, null);
                it = d.iterator();
                while (it.hasNext()) {
                    ((b) it.next()).onInitSuccess();
                }
                return Unit.a;
            }
        }
        hiSavanaAdManager$onInitSuccess$1 = new HiSavanaAdManager$onInitSuccess$1(this, continuation);
        Object obj2 = hiSavanaAdManager$onInitSuccess$1.result;
        Object f2 = IntrinsicsKt.f();
        i = hiSavanaAdManager$onInitSuccess$1.label;
        if (i != 0) {
        }
        c.set(true);
        xh.a.c(xh.a.a, c() + " --> initHiAdSdk() --> complete -- isInitialized = " + c.get(), 0, false, 6, null);
        it = d.iterator();
        while (it.hasNext()) {
        }
        return Unit.a;
    }

    public final void b(b bVar) {
        Intrinsics.h(bVar, "listener");
        d.add(bVar);
    }

    public final Object d(String str, boolean z, boolean z2, Continuation continuation) {
        if (e()) {
            xh.a.c(xh.a.a, c() + " --> initHiAdSdk() --> 2g & 开关不打开直接关闭sdk初始化", 6, false, 4, null);
            return Unit.a;
        }
        if (!b.get()) {
            b.set(true);
            Object g = i.g(y0.b(), new HiSavanaAdManager$initHiAdSdk$2(str, z2, z, null), continuation);
            return g == IntrinsicsKt.f() ? g : Unit.a;
        }
        xh.a.c(xh.a.a, c() + " --> initHiAdSdk() --> isInitializing == true", 6, false, 4, null);
        return Unit.a;
    }

    public final boolean f() {
        return c.get();
    }

    public final void h(b bVar) {
        Intrinsics.h(bVar, "listener");
        Set set = d;
        if (!set.isEmpty() && set.contains(bVar)) {
            set.remove(bVar);
        }
    }
}
