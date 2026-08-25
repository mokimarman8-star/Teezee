package com.transsion.push.db;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.o;
import com.tencent.mmkv.MMKV;
import com.transsion.gslb.BuildConfig;
import com.transsion.push.PushConstants;
import com.transsion.push.bean.MsgStyle;
import com.transsion.push.bean.PagerConfig;
import com.transsion.push.bean.PermanentConfig;
import com.transsion.push.bean.PermanentItemBean;
import com.transsion.push.bean.PermanentPushResp;
import com.transsion.push.db.PermanentPushDatabase;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PermanentRoom {
    public static final PermanentRoom a = new PermanentRoom();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.push.db.g
        public final Object invoke() {
            MMKV k;
            k = PermanentRoom.k();
            return k;
        }
    });

    private PermanentRoom() {
    }

    private final MMKV j() {
        return (MMKV) b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV k() {
        MMKV I = MMKV.I("PermanentRushMsg");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    public final Object b(List list, Continuation continuation) {
        Object b2;
        PermanentPushDatabase.Companion companion = PermanentPushDatabase.INSTANCE;
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        return (list != null && (b2 = companion.b(a2).i0().b(list, continuation)) == IntrinsicsKt.f()) ? b2 : Unit.a;
    }

    public final Object c(Continuation continuation) {
        PermanentPushDatabase.Companion companion = PermanentPushDatabase.INSTANCE;
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        Object a3 = companion.b(a2).i0().a(continuation);
        return a3 == IntrinsicsKt.f() ? a3 : Unit.a;
    }

    public final Object d(PermanentItemBean permanentItemBean, Continuation continuation) {
        if (permanentItemBean == null) {
            return Unit.a;
        }
        PermanentPushDatabase.Companion companion = PermanentPushDatabase.INSTANCE;
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        Object d = companion.b(a2).i0().d(permanentItemBean, continuation);
        return d == IntrinsicsKt.f() ? d : Unit.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object e(Continuation continuation) {
        PermanentRoom$getAll$1 permanentRoom$getAll$1;
        int i;
        if (continuation instanceof PermanentRoom$getAll$1) {
            permanentRoom$getAll$1 = (PermanentRoom$getAll$1) continuation;
            int i2 = permanentRoom$getAll$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                permanentRoom$getAll$1.label = i2 - Integer.MIN_VALUE;
                Object obj = permanentRoom$getAll$1.result;
                Object f = IntrinsicsKt.f();
                i = permanentRoom$getAll$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    PermanentPushDatabase.Companion companion = PermanentPushDatabase.INSTANCE;
                    Application a2 = Utils.a();
                    Intrinsics.g(a2, "getApp(...)");
                    a i0 = companion.b(a2).i0();
                    permanentRoom$getAll$1.label = 1;
                    obj = i0.c(permanentRoom$getAll$1);
                    if (obj == f) {
                        return f;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                List list = (List) obj;
                return list != null ? CollectionsKt.l() : list;
            }
        }
        permanentRoom$getAll$1 = new PermanentRoom$getAll$1(this, continuation);
        Object obj2 = permanentRoom$getAll$1.result;
        Object f2 = IntrinsicsKt.f();
        i = permanentRoom$getAll$1.label;
        if (i != 0) {
        }
        List list2 = (List) obj2;
        if (list2 != null) {
        }
    }

    public final PermanentConfig f() {
        String string = j().getString(PushConstants.SP_KEY_CONFIG, (String) null);
        if (string != null) {
            return (PermanentConfig) o.d(string, PermanentConfig.class);
        }
        return null;
    }

    public final String g() {
        String string = j().getString("pager", MsgStyle.CUSTOM_LEFT_PIC);
        return string == null ? MsgStyle.CUSTOM_LEFT_PIC : string;
    }

    public final long h() {
        return j().getLong("time", 0L);
    }

    public final String i() {
        String string = j().getString("title", BuildConfig.FLAVOR);
        return string == null ? BuildConfig.FLAVOR : string;
    }

    public final Object l(PermanentPushResp permanentPushResp, Continuation continuation) {
        String g;
        String title = permanentPushResp.getTitle();
        if (title == null) {
            title = i();
        }
        p(title);
        PagerConfig pager = permanentPushResp.getPager();
        if (pager == null || (g = pager.getNextPage()) == null) {
            g = g();
        }
        n(g);
        o(System.currentTimeMillis());
        PermanentConfig cfg = permanentPushResp.getCfg();
        if (cfg != null) {
            a.m(cfg);
        }
        a.a aVar = wf.a.a;
        List<PermanentItemBean> items = permanentPushResp.getItems();
        Integer d = items != null ? Boxing.d(items.size()) : null;
        PagerConfig pager2 = permanentPushResp.getPager();
        String nextPage = pager2 != null ? pager2.getNextPage() : null;
        a.a.l(aVar, "PUSH_SHOW", "DB-addMsgList, size:" + d + "，mPager:" + nextPage + ",title:" + permanentPushResp.getTitle() + " ", false, 4, (Object) null);
        List<PermanentItemBean> items2 = permanentPushResp.getItems();
        Object b2 = b(items2 != null ? CollectionsKt.f0(items2) : null, continuation);
        return b2 == IntrinsicsKt.f() ? b2 : Unit.a;
    }

    public final void m(PermanentConfig permanentConfig) {
        j().putString(PushConstants.SP_KEY_CONFIG, o.j(permanentConfig));
    }

    public final void n(String str) {
        Intrinsics.h(str, "value");
        j().putString("pager", str);
    }

    public final void o(long j) {
        j().putLong("time", j);
    }

    public final void p(String str) {
        Intrinsics.h(str, "value");
        j().putString("title", str);
    }
}
