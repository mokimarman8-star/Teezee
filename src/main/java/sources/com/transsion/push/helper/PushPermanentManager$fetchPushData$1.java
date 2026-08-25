package com.transsion.push.helper;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import com.transsion.push.bean.MsgStyle;
import com.transsion.push.bean.PagerConfig;
import com.transsion.push.bean.PermanentConfig;
import com.transsion.push.bean.PermanentItemBean;
import com.transsion.push.bean.PermanentPushResp;
import com.transsion.push.db.PermanentRoom;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;
import to.b;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.push.helper.PushPermanentManager$fetchPushData$1", f = "PushPermanentManager.kt", l = {95, 117, 120}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class PushPermanentManager$fetchPushData$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    int label;

    PushPermanentManager$fetchPushData$1(Continuation<? super PushPermanentManager$fetchPushData$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PushPermanentManager$fetchPushData$1 pushPermanentManager$fetchPushData$1 = new PushPermanentManager$fetchPushData$1(continuation);
        pushPermanentManager$fetchPushData$1.L$0 = obj;
        return pushPermanentManager$fetchPushData$1;
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:85:0x0054, code lost:
    
        if (r15 == false) goto L25;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0150 A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:8:0x001b, B:10:0x014a, B:12:0x0150, B:14:0x0158, B:15:0x015c, B:16:0x0166, B:18:0x016e, B:19:0x0174, B:21:0x018b, B:23:0x0193, B:24:0x0199, B:26:0x01bf, B:27:0x01ca, B:35:0x01c5, B:40:0x0031, B:42:0x0137, B:46:0x0036, B:47:0x0099, B:49:0x00a7, B:51:0x00b8, B:53:0x00be, B:54:0x00c4, B:56:0x00ca, B:57:0x00cd, B:59:0x00d5, B:62:0x00dd, B:63:0x00f8, B:65:0x00fe, B:68:0x0106, B:73:0x010e, B:75:0x0126, B:87:0x007f), top: B:2:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x016e A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:8:0x001b, B:10:0x014a, B:12:0x0150, B:14:0x0158, B:15:0x015c, B:16:0x0166, B:18:0x016e, B:19:0x0174, B:21:0x018b, B:23:0x0193, B:24:0x0199, B:26:0x01bf, B:27:0x01ca, B:35:0x01c5, B:40:0x0031, B:42:0x0137, B:46:0x0036, B:47:0x0099, B:49:0x00a7, B:51:0x00b8, B:53:0x00be, B:54:0x00c4, B:56:0x00ca, B:57:0x00cd, B:59:0x00d5, B:62:0x00dd, B:63:0x00f8, B:65:0x00fe, B:68:0x0106, B:73:0x010e, B:75:0x0126, B:87:0x007f), top: B:2:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x018b A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:8:0x001b, B:10:0x014a, B:12:0x0150, B:14:0x0158, B:15:0x015c, B:16:0x0166, B:18:0x016e, B:19:0x0174, B:21:0x018b, B:23:0x0193, B:24:0x0199, B:26:0x01bf, B:27:0x01ca, B:35:0x01c5, B:40:0x0031, B:42:0x0137, B:46:0x0036, B:47:0x0099, B:49:0x00a7, B:51:0x00b8, B:53:0x00be, B:54:0x00c4, B:56:0x00ca, B:57:0x00cd, B:59:0x00d5, B:62:0x00dd, B:63:0x00f8, B:65:0x00fe, B:68:0x0106, B:73:0x010e, B:75:0x0126, B:87:0x007f), top: B:2:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01bf A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:8:0x001b, B:10:0x014a, B:12:0x0150, B:14:0x0158, B:15:0x015c, B:16:0x0166, B:18:0x016e, B:19:0x0174, B:21:0x018b, B:23:0x0193, B:24:0x0199, B:26:0x01bf, B:27:0x01ca, B:35:0x01c5, B:40:0x0031, B:42:0x0137, B:46:0x0036, B:47:0x0099, B:49:0x00a7, B:51:0x00b8, B:53:0x00be, B:54:0x00c4, B:56:0x00ca, B:57:0x00cd, B:59:0x00d5, B:62:0x00dd, B:63:0x00f8, B:65:0x00fe, B:68:0x0106, B:73:0x010e, B:75:0x0126, B:87:0x007f), top: B:2:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01c5 A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:8:0x001b, B:10:0x014a, B:12:0x0150, B:14:0x0158, B:15:0x015c, B:16:0x0166, B:18:0x016e, B:19:0x0174, B:21:0x018b, B:23:0x0193, B:24:0x0199, B:26:0x01bf, B:27:0x01ca, B:35:0x01c5, B:40:0x0031, B:42:0x0137, B:46:0x0036, B:47:0x0099, B:49:0x00a7, B:51:0x00b8, B:53:0x00be, B:54:0x00c4, B:56:0x00ca, B:57:0x00cd, B:59:0x00d5, B:62:0x00dd, B:63:0x00f8, B:65:0x00fe, B:68:0x0106, B:73:0x010e, B:75:0x0126, B:87:0x007f), top: B:2:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0145 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0146  */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Throwable th2;
        CopyOnWriteArrayList copyOnWriteArrayList;
        String str;
        String str2;
        long j;
        to.b r;
        String str3;
        boolean t;
        PermanentPushResp permanentPushResp;
        CopyOnWriteArrayList copyOnWriteArrayList2;
        CopyOnWriteArrayList<PermanentItemBean> copyOnWriteArrayList3;
        String str4;
        PermanentPushResp permanentPushResp2;
        int i;
        PermanentRoom permanentRoom;
        int i2;
        PermanentPushResp permanentPushResp3;
        int i3;
        int i4;
        PagerConfig pager;
        String title;
        CopyOnWriteArrayList copyOnWriteArrayList4;
        PermanentItemBean permanentItemBean;
        Object f = IntrinsicsKt.f();
        int i5 = this.label;
        try {
        } catch (Throwable th3) {
            Result.Companion companion = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.a(th3));
        }
        if (i5 == 0) {
            ResultKt.b(obj);
            str = PushPermanentManager.e;
            if (str != null && str.length() != 0) {
                t = PushPermanentManager.a.t();
            }
            PushPermanentManager.e = MsgStyle.CUSTOM_LEFT_PIC;
            a.a aVar = wf.a.a;
            str2 = PushPermanentManager.e;
            j = PushPermanentManager.i;
            aVar.c("PUSH_SHOW", "fetchPushData pager:" + str2 + ",lastRequestTime:" + j, true);
            Result.Companion companion2 = Result.Companion;
            r = PushPermanentManager.a.r();
            str3 = PushPermanentManager.e;
            this.label = 1;
            obj = b.a.a(r, null, str3, null, this, 5, null);
            if (obj == f) {
                return f;
            }
        } else {
            if (i5 != 1) {
                if (i5 == 2) {
                    int i6 = this.I$0;
                    permanentPushResp2 = (PermanentPushResp) this.L$0;
                    ResultKt.b(obj);
                    i3 = i6;
                    permanentPushResp = permanentPushResp2;
                    i = i3;
                    permanentRoom = PermanentRoom.a;
                    this.L$0 = permanentPushResp;
                    this.I$0 = i;
                    this.label = 3;
                    if (permanentRoom.l(permanentPushResp, this) != f) {
                        return f;
                    }
                    i2 = i;
                    permanentPushResp3 = permanentPushResp;
                    permanentPushResp = permanentPushResp3;
                    i4 = i2;
                    pager = permanentPushResp.getPager();
                    if (pager != null) {
                    }
                    PushPermanentManager pushPermanentManager = PushPermanentManager.a;
                    title = permanentPushResp.getTitle();
                    if (title == null) {
                    }
                    PushPermanentManager.h = title;
                    a.a aVar2 = wf.a.a;
                    copyOnWriteArrayList4 = PushPermanentManager.c;
                    int size = copyOnWriteArrayList4.size();
                    PermanentConfig cfg = permanentPushResp.getCfg();
                    List<PermanentItemBean> items = permanentPushResp.getItems();
                    if (items != null) {
                    }
                    aVar2.c("PUSH_SHOW", "request success pushCacheList:" + size + ", cfg:" + cfg + ", fir:" + ((items != null || (permanentItemBean = (PermanentItemBean) CollectionsKt.k0(items)) == null) ? null : permanentItemBean.getSubjectId()), true);
                    if (i4 != 0) {
                    }
                    obj2 = Result.constructor-impl(Unit.a);
                    th2 = Result.exceptionOrNull-impl(obj2);
                    if (th2 != null) {
                    }
                    return Unit.a;
                }
                if (i5 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i2 = this.I$0;
                permanentPushResp3 = (PermanentPushResp) this.L$0;
                ResultKt.b(obj);
                permanentPushResp = permanentPushResp3;
                i4 = i2;
                pager = permanentPushResp.getPager();
                if (pager != null) {
                    PushPermanentManager pushPermanentManager2 = PushPermanentManager.a;
                    String nextPage = pager.getNextPage();
                    if (nextPage == null) {
                        nextPage = PushPermanentManager.e;
                    }
                    PushPermanentManager.e = nextPage;
                    PushPermanentManager.f = pager.getHasMore();
                }
                PushPermanentManager pushPermanentManager3 = PushPermanentManager.a;
                title = permanentPushResp.getTitle();
                if (title == null) {
                    title = PushPermanentManager.a.s();
                }
                PushPermanentManager.h = title;
                a.a aVar22 = wf.a.a;
                copyOnWriteArrayList4 = PushPermanentManager.c;
                int size2 = copyOnWriteArrayList4.size();
                PermanentConfig cfg2 = permanentPushResp.getCfg();
                List<PermanentItemBean> items2 = permanentPushResp.getItems();
                aVar22.c("PUSH_SHOW", "request success pushCacheList:" + size2 + ", cfg:" + cfg2 + ", fir:" + ((items2 != null || (permanentItemBean = (PermanentItemBean) CollectionsKt.k0(items2)) == null) ? null : permanentItemBean.getSubjectId()), true);
                if (i4 != 0) {
                    PushPermanentManager.a.v();
                } else {
                    PushPermanentShowHelper.a.f();
                }
                obj2 = Result.constructor-impl(Unit.a);
                th2 = Result.exceptionOrNull-impl(obj2);
                if (th2 != null) {
                    copyOnWriteArrayList = PushPermanentManager.c;
                    Collections.shuffle(copyOnWriteArrayList);
                    wf.a.a.c("PUSH_SHOW", "onFailure: " + th2, true);
                }
                return Unit.a;
            }
            ResultKt.b(obj);
        }
        BaseDto baseDto = (BaseDto) obj;
        if (Intrinsics.c(baseDto.getCode(), "0")) {
            PushPermanentManager pushPermanentManager4 = PushPermanentManager.a;
            PushPermanentManager.i = System.currentTimeMillis();
            permanentPushResp = (PermanentPushResp) baseDto.getData();
            if (permanentPushResp != null) {
                PermanentConfig cfg3 = permanentPushResp.getCfg();
                ?? enable = cfg3 != null ? cfg3.getEnable() : 1;
                PermanentConfig cfg4 = permanentPushResp.getCfg();
                if (cfg4 != null) {
                    PushPermanentManager.d = cfg4;
                }
                List<PermanentItemBean> items3 = permanentPushResp.getItems();
                i4 = enable;
                if (items3 != null) {
                    if (items3.isEmpty()) {
                        i4 = enable;
                    } else {
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        copyOnWriteArrayList2 = PushPermanentManager.c;
                        copyOnWriteArrayList2.addAll(0, permanentPushResp.getItems());
                        copyOnWriteArrayList3 = PushPermanentManager.c;
                        for (PermanentItemBean permanentItemBean2 : copyOnWriteArrayList3) {
                            if (permanentItemBean2 != null) {
                                linkedHashMap.putIfAbsent(permanentItemBean2.getSubjectId(), permanentItemBean2);
                            }
                        }
                        PushPermanentManager pushPermanentManager5 = PushPermanentManager.a;
                        PushPermanentManager.c = new CopyOnWriteArrayList(linkedHashMap.values());
                        str4 = PushPermanentManager.e;
                        i = enable;
                        if (Intrinsics.c(str4, MsgStyle.CUSTOM_LEFT_PIC)) {
                            PermanentRoom permanentRoom2 = PermanentRoom.a;
                            this.L$0 = permanentPushResp;
                            this.I$0 = enable;
                            this.label = 2;
                            if (permanentRoom2.c(this) == f) {
                                return f;
                            }
                            permanentPushResp2 = permanentPushResp;
                            i3 = enable;
                            permanentPushResp = permanentPushResp2;
                            i = i3;
                        }
                        permanentRoom = PermanentRoom.a;
                        this.L$0 = permanentPushResp;
                        this.I$0 = i;
                        this.label = 3;
                        if (permanentRoom.l(permanentPushResp, this) != f) {
                        }
                    }
                }
                pager = permanentPushResp.getPager();
                if (pager != null) {
                }
                PushPermanentManager pushPermanentManager32 = PushPermanentManager.a;
                title = permanentPushResp.getTitle();
                if (title == null) {
                }
                PushPermanentManager.h = title;
                a.a aVar222 = wf.a.a;
                copyOnWriteArrayList4 = PushPermanentManager.c;
                int size22 = copyOnWriteArrayList4.size();
                PermanentConfig cfg22 = permanentPushResp.getCfg();
                List<PermanentItemBean> items22 = permanentPushResp.getItems();
                if (items22 != null) {
                }
                aVar222.c("PUSH_SHOW", "request success pushCacheList:" + size22 + ", cfg:" + cfg22 + ", fir:" + ((items22 != null || (permanentItemBean = (PermanentItemBean) CollectionsKt.k0(items22)) == null) ? null : permanentItemBean.getSubjectId()), true);
                if (i4 != 0) {
                }
            }
        }
        obj2 = Result.constructor-impl(Unit.a);
        th2 = Result.exceptionOrNull-impl(obj2);
        if (th2 != null) {
        }
        return Unit.a;
    }
}
