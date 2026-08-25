package com.transsion.baselib.kids;

import cm.f;
import com.google.gson.Gson;
import com.tencent.mmkv.MMKV;
import com.therouter.TheRouter;
import com.transsion.baselib.kids.a;
import com.transsion.baselib.report.launch.b;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.loginapi.bean.UserInfo;
import ij.o;
import java.util.Iterator;
import java.util.List;
import kg.c;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mg.b;
import okhttp3.RequestBody;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class KidsAccountManager {
    public static final KidsAccountManager a = new KidsAccountManager();
    private static final Gson b = new Gson();

    public static final class a {
        public static final C0015a b = new C0015a(null);
        private final int a;

        /* renamed from: com.transsion.baselib.kids.KidsAccountManager$a$a, reason: collision with other inner class name */
        public static final class C0015a {
            private C0015a() {
            }

            public /* synthetic */ C0015a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public a(int i) {
            this.a = i;
        }
    }

    private KidsAccountManager() {
    }

    private final String a() {
        UserInfo i;
        qx.a aVar = (qx.a) TheRouter.d(qx.a.class, new Object[0]);
        String userId = (aVar == null || (i = aVar.i()) == null) ? null : i.getUserId();
        return (userId == null || userId.length() == 0) ? "visitor" : userId;
    }

    private final boolean h(String str) {
        String value;
        Long x;
        long h = b.a.b().h(str, 0L);
        if (h == 0) {
            return false;
        }
        ConfigBean c = f.c.a().c("pk_kids_dialog_suppress_duration", false);
        return System.currentTimeMillis() - h < ((c == null || (value = c.getValue()) == null || (x = StringsKt.x(value)) == null) ? 604800000L : x.longValue());
    }

    public static /* synthetic */ void n(KidsAccountManager kidsAccountManager, KidsProfile kidsProfile, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        kidsAccountManager.m(kidsProfile, z);
    }

    public final void b() {
        b.a.b().M("kids_profile");
        MMKV I = MMKV.I("kv_search_list");
        Intrinsics.g(I, "mmkvWithID(...)");
        I.M("kv_kids_search_work");
        I.M("kv_kids_search_group");
        a.a.f(wf.a.a, "KidsAccountManager", "deleteKidsProfile: profile and search history cleared", false, 4, (Object) null);
        a aVar = new a(2);
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = a.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.postEvent(name, aVar, 0L);
    }

    public final void c(KidsProfile kidsProfile) {
        Intrinsics.h(kidsProfile, "profile");
        a.a.f(wf.a.a, "KidsAccountManager", "enter kids mode.", false, 4, (Object) null);
        o.a.a(kidsProfile.getKidsId());
    }

    public final void d() {
        a.a.f(wf.a.a, "KidsAccountManager", "exit kids mode.", false, 4, (Object) null);
        o.a.b();
    }

    public final String e() {
        String d = o.a.d();
        if (d != null) {
            return d;
        }
        KidsProfile f = f();
        if (f != null) {
            return f.getKidsId();
        }
        return null;
    }

    public final KidsProfile f() {
        String k = b.a.b().k("kids_profile");
        if (k == null) {
            return null;
        }
        return (KidsProfile) b.fromJson(k, KidsProfile.class);
    }

    public final boolean g() {
        return h("kids_create_dialog_dismiss_" + a());
    }

    public final boolean i() {
        KidsProfile f = f();
        if (f == null) {
            return false;
        }
        String pinHash = f.getPinHash();
        return !(pinHash == null || pinHash.length() == 0);
    }

    public final boolean j() {
        return h("kids_switch_dialog_dismiss_" + a());
    }

    public final void k() {
        b.a.b().t("kids_create_dialog_dismiss_" + a(), System.currentTimeMillis());
    }

    public final void l() {
        b.a.b().t("kids_switch_dialog_dismiss_" + a(), System.currentTimeMillis());
    }

    public final void m(KidsProfile kidsProfile, boolean z) {
        Intrinsics.h(kidsProfile, "profile");
        b.a.b().v("kids_profile", b.toJson(kidsProfile));
        if (z) {
            a aVar = new a(1);
            FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = a.class.getName();
            Intrinsics.g(name, "getName(...)");
            applicationScopeViewModel.postEvent(name, aVar, 0L);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:0|1|(2:3|(12:5|6|7|8|(1:(1:11)(2:35|36))(3:37|38|(2:40|41)(2:42|(1:44)))|12|(4:14|(2:15|(2:17|(2:19|20)(1:31))(2:32|33))|21|(5:25|26|27|28|29))|34|26|27|28|29))|47|6|7|8|(0)(0)|12|(0)|34|26|27|28|29) */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x002e, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00cf, code lost:
    
        wf.a.a.i("KidsAccountManager", "shouldShowAutoPopup error: " + r11.getMessage(), true);
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0083 A[Catch: Exception -> 0x002e, TryCatch #0 {Exception -> 0x002e, blocks: (B:11:0x002a, B:12:0x007b, B:14:0x0083, B:15:0x0089, B:17:0x008f, B:21:0x00a2, B:23:0x00a6, B:25:0x00ac, B:26:0x00b2, B:38:0x003c, B:40:0x005b, B:42:0x0060), top: B:8:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object o(Continuation continuation) {
        KidsAccountManager$shouldShowAutoPopup$1 kidsAccountManager$shouldShowAutoPopup$1;
        int i;
        List<ConsumeJudgeItem> list;
        boolean z;
        Object obj;
        Boolean isConsume;
        if (continuation instanceof KidsAccountManager$shouldShowAutoPopup$1) {
            kidsAccountManager$shouldShowAutoPopup$1 = (KidsAccountManager$shouldShowAutoPopup$1) continuation;
            int i2 = kidsAccountManager$shouldShowAutoPopup$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                kidsAccountManager$shouldShowAutoPopup$1.label = i2 - Integer.MIN_VALUE;
                KidsAccountManager$shouldShowAutoPopup$1 kidsAccountManager$shouldShowAutoPopup$12 = kidsAccountManager$shouldShowAutoPopup$1;
                Object obj2 = kidsAccountManager$shouldShowAutoPopup$12.result;
                Object f = IntrinsicsKt.f();
                i = kidsAccountManager$shouldShowAutoPopup$12.label;
                boolean z2 = false;
                if (i != 0) {
                    ResultKt.b(obj2);
                    b.a aVar = mg.b.a;
                    String json = new Gson().toJson(new ConsumeJudgeRequest(CollectionsKt.e("USER_CONSUME_EDUCATION")));
                    Intrinsics.g(json, "toJson(...)");
                    RequestBody a2 = aVar.a(json);
                    if (a2 == null) {
                        return Boxing.a(false);
                    }
                    com.transsion.baselib.kids.a aVar2 = (com.transsion.baselib.kids.a) c.e.a().h(com.transsion.baselib.kids.a.class);
                    kidsAccountManager$shouldShowAutoPopup$12.label = 1;
                    obj2 = a.C0016a.a(aVar2, null, a2, kidsAccountManager$shouldShowAutoPopup$12, 1, null);
                    if (obj2 == f) {
                        return f;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj2);
                }
                list = ((ConsumeJudgeResponse) obj2).getList();
                if (list != null) {
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        if (Intrinsics.c(((ConsumeJudgeItem) obj).getConsumeType(), "USER_CONSUME_EDUCATION")) {
                            break;
                        }
                    }
                    ConsumeJudgeItem consumeJudgeItem = (ConsumeJudgeItem) obj;
                    if (consumeJudgeItem != null && (isConsume = consumeJudgeItem.isConsume()) != null) {
                        z = isConsume.booleanValue();
                        a.a.f(wf.a.a, "KidsAccountManager", "shouldShowAutoPopup response result: " + z, false, 4, (Object) null);
                        z2 = z;
                        return Boxing.a(z2);
                    }
                }
                z = false;
                a.a.f(wf.a.a, "KidsAccountManager", "shouldShowAutoPopup response result: " + z, false, 4, (Object) null);
                z2 = z;
                return Boxing.a(z2);
            }
        }
        kidsAccountManager$shouldShowAutoPopup$1 = new KidsAccountManager$shouldShowAutoPopup$1(this, continuation);
        KidsAccountManager$shouldShowAutoPopup$1 kidsAccountManager$shouldShowAutoPopup$122 = kidsAccountManager$shouldShowAutoPopup$1;
        Object obj22 = kidsAccountManager$shouldShowAutoPopup$122.result;
        Object f2 = IntrinsicsKt.f();
        i = kidsAccountManager$shouldShowAutoPopup$122.label;
        boolean z22 = false;
        if (i != 0) {
        }
        list = ((ConsumeJudgeResponse) obj22).getList();
        if (list != null) {
        }
        z = false;
        a.a.f(wf.a.a, "KidsAccountManager", "shouldShowAutoPopup response result: " + z, false, 4, (Object) null);
        z22 = z;
        return Boxing.a(z22);
    }

    public final void p(String str) {
        KidsProfile copy;
        Intrinsics.h(str, "pinHash");
        KidsProfile f = f();
        if (f == null) {
            return;
        }
        MMKV b2 = com.transsion.baselib.report.launch.b.a.b();
        Gson gson = b;
        copy = f.copy((r20 & 1) != 0 ? f.kidsId : null, (r20 & 2) != 0 ? f.name : null, (r20 & 4) != 0 ? f.avatarResId : 0, (r20 & 8) != 0 ? f.gender : null, (r20 & 16) != 0 ? f.birthday : null, (r20 & 32) != 0 ? f.pinHash : str, (r20 & 64) != 0 ? f.avatarLocalPath : null, (r20 & 128) != 0 ? f.favorites : null, (r20 & 256) != 0 ? f.age : null);
        b2.v("kids_profile", gson.toJson(copy));
    }

    public final boolean q(String str) {
        Intrinsics.h(str, "inputPin");
        KidsProfile f = f();
        if (f == null) {
            return false;
        }
        return Intrinsics.c(f.getPinHash(), str);
    }
}
