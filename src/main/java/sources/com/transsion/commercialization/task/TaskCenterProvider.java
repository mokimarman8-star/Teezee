package com.transsion.commercialization.task;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.a;
import com.therouter.TheRouter;
import com.transsion.commercialization.task.treasure.CheckLotteryLoadingDialog;
import com.transsion.commercialization.task.treasure.TreasureStyleADialog;
import com.transsion.memberapi.MemberCheckResult;
import com.transsion.memberapi.MemberSceneType;
import com.transsion.memberapi.MemberSource;
import im.b;
import kg.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import wj.f;
import wj.g;
import wj.h;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class TaskCenterProvider implements f {
    private final Lazy a = LazyKt.b(new o());

    private final void i(g gVar, Integer num, String str, MemberSceneType memberSceneType) {
        b bVar = (b) TheRouter.d(b.class, new Object[0]);
        if (bVar != null) {
            bVar.d(memberSceneType, num, new a(this, gVar, memberSceneType, str));
        }
    }

    private final com.transsion.commercialization.task.treasure.b k() {
        return (com.transsion.commercialization.task.treasure.b) this.a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsion.commercialization.task.treasure.b l() {
        return (com.transsion.commercialization.task.treasure.b) c.e.a().h(com.transsion.commercialization.task.treasure.b.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(g gVar, MemberCheckResult memberCheckResult) {
        b bVar = (b) TheRouter.d(b.class, new Object[0]);
        if (bVar != null) {
            bVar.x(a.b(), MemberSource.SOURCE_OTHER_DOWNLOAD_DIALOG, memberCheckResult, new b(this, gVar));
        }
    }

    @Override // wj.f
    public Object a(String str, String str2, boolean z, Continuation continuation) {
        Activity b = a.b();
        if (b != null) {
            new CheckLotteryLoadingDialog().x0(str, str2, z).k0(b, "CheckLotteryLoadingDialog");
        }
        return Unit.a;
    }

    @Override // wj.f
    public void b(String str, MemberCheckResult memberCheckResult, g gVar) {
        Intrinsics.h(str, "genre");
        new TreasureStyleADialog().z0(memberCheckResult).x0(str).A0(MemberSceneType.SCENE_MULTIDL).y0(gVar).k0(a.b(), "TreasureStyleADialog");
    }

    @Override // wj.f
    public void c(FragmentActivity fragmentActivity, Function1 function1) {
        new MemberPageVideoTaskDialog().t0(function1).k0(fragmentActivity, "MemberPageVideoTaskDialog");
    }

    @Override // wj.f
    public void d(g gVar) {
        new DownloadInterceptAdHelper(gVar, (MemberCheckResult) null, (String) null, true, 6, (DefaultConstructorMarker) null).h();
    }

    @Override // wj.f
    public void e(Integer num, String str, g gVar, MemberSceneType memberSceneType) {
        Intrinsics.h(gVar, "listener");
        Intrinsics.h(memberSceneType, "sceneType");
        h.a.b(j() + " --> interception() --> resolution = " + num + " -- genre = " + str + " -- sceneType = " + memberSceneType.getValue());
        i(gVar, num, str, memberSceneType);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:0|1|(2:3|(10:5|6|7|8|(1:(1:11)(2:25|26))(3:27|28|(1:30))|12|(1:14)(1:24)|15|16|(2:18|19)(2:21|22)))|33|6|7|8|(0)(0)|12|(0)(0)|15|16|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x002c, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005d, code lost:
    
        r0 = kotlin.Result.Companion;
        r9 = kotlin.Result.m34constructorimpl(kotlin.ResultKt.a(r9));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0050 A[Catch: all -> 0x002c, TryCatch #0 {all -> 0x002c, blocks: (B:11:0x0028, B:12:0x004c, B:14:0x0050, B:15:0x0058, B:28:0x0039), top: B:8:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0036  */
    @Override // wj.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(kotlin.coroutines.Continuation r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.transsion.commercialization.task.TaskCenterProvider.getLotteryUserInfoEntity.1
            if (r0 == 0) goto L14
            r0 = r9
            com.transsion.commercialization.task.TaskCenterProvider$getLotteryUserInfoEntity$1 r0 = (com.transsion.commercialization.task.TaskCenterProvider.getLotteryUserInfoEntity.1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            com.transsion.commercialization.task.TaskCenterProvider$getLotteryUserInfoEntity$1 r0 = new com.transsion.commercialization.task.TaskCenterProvider$getLotteryUserInfoEntity$1
            r0.<init>(r8, r9)
            goto L12
        L1a:
            java.lang.Object r9 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.label
            r7 = 0
            r2 = 1
            if (r1 == 0) goto L36
            if (r1 != r2) goto L2e
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L2c
            goto L4c
        L2c:
            r9 = move-exception
            goto L5d
        L2e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L36:
            kotlin.ResultKt.b(r9)
            kotlin.Result$Companion r9 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L2c
            com.transsion.commercialization.task.treasure.b r1 = r8.k()     // Catch: java.lang.Throwable -> L2c
            r4.label = r2     // Catch: java.lang.Throwable -> L2c
            r2 = 0
            r3 = 0
            r5 = 3
            r6 = 0
            java.lang.Object r9 = com.transsion.commercialization.task.treasure.b.a.b(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L2c
            if (r9 != r0) goto L4c
            return r0
        L4c:
            com.tn.lib.net.bean.BaseDto r9 = (com.tn.lib.net.bean.BaseDto) r9     // Catch: java.lang.Throwable -> L2c
            if (r9 == 0) goto L57
            java.lang.Object r9 = r9.getData()     // Catch: java.lang.Throwable -> L2c
            com.transsion.bean.lottery.LotteryUserInfoEntity r9 = (com.transsion.bean.lottery.LotteryUserInfoEntity) r9     // Catch: java.lang.Throwable -> L2c
            goto L58
        L57:
            r9 = r7
        L58:
            java.lang.Object r9 = kotlin.Result.m34constructorimpl(r9)     // Catch: java.lang.Throwable -> L2c
            goto L67
        L5d:
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r9 = kotlin.ResultKt.a(r9)
            java.lang.Object r9 = kotlin.Result.m34constructorimpl(r9)
        L67:
            java.lang.Throwable r0 = kotlin.Result.m37exceptionOrNullimpl(r9)
            if (r0 != 0) goto L6f
            r7 = r9
            goto L8c
        L6f:
            wj.h r9 = wj.h.a
            java.lang.String r1 = r8.j()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r1 = " --> getLotteryUserInfoEntity() --> it = "
            r2.append(r1)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r9.b(r0)
        L8c:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.commercialization.task.TaskCenterProvider.f(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final String j() {
        String simpleName = TaskCenterProvider.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }
}
