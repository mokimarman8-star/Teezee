package com.transsion.commercialization.task;

import com.therouter.TheRouter;
import com.transsion.commercialization.task.treasure.TreasureStyleADialog;
import com.transsion.memberapi.MemberCheckResult;
import com.transsion.memberapi.MemberSceneType;
import com.transsion.memberapi.OpType;
import im.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class TaskCenterProvider$a implements im.a {
    final /* synthetic */ TaskCenterProvider a;
    final /* synthetic */ wj.g b;
    final /* synthetic */ MemberSceneType c;
    final /* synthetic */ String d;

    TaskCenterProvider$a(TaskCenterProvider taskCenterProvider, wj.g gVar, MemberSceneType memberSceneType, String str) {
        this.a = taskCenterProvider;
        this.b = gVar;
        this.c = memberSceneType;
        this.d = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(TaskCenterProvider taskCenterProvider, MemberSceneType memberSceneType, Object obj) {
        wj.h.a.a(taskCenterProvider.j() + " --> checkMemberRights() --> sceneType = " + memberSceneType + " --> success");
        return Unit.a;
    }

    @Override // im.a
    public void a(MemberCheckResult memberCheckResult) {
        TaskCenterProvider.h(this.a, this.b, memberCheckResult);
    }

    @Override // im.a
    public void b(MemberCheckResult memberCheckResult) {
        new DownloadInterceptAdHelper(this.b, memberCheckResult, this.d, false, 8, null).h();
    }

    @Override // im.a
    public void c(MemberCheckResult memberCheckResult) {
        a.C0074a.g(this, memberCheckResult);
        new TreasureStyleADialog().z0(memberCheckResult).x0(this.d).A0(this.c).y0(this.b).k0(com.blankj.utilcode.util.a.b(), "TreasureStyleADialog");
    }

    @Override // im.a
    public void d(MemberCheckResult memberCheckResult) {
        new DownloadInterceptAdHelper(this.b, memberCheckResult, this.d, false, 8, null).h();
    }

    @Override // im.a
    public void e() {
        this.b.onSuccess();
        wj.h.a.a(this.a.j() + " --> checkMemberRights() --> passed() --> 会员权益通过验证 --> 继续下载任务");
        im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
        if (bVar != null) {
            OpType opType = OpType.OP_DOWNLOAD;
            final TaskCenterProvider taskCenterProvider = this.a;
            final MemberSceneType memberSceneType = this.c;
            bVar.n(opType, new Function1() { // from class: com.transsion.commercialization.task.p
                public final Object invoke(Object obj) {
                    Unit h;
                    h = TaskCenterProvider$a.h(taskCenterProvider, memberSceneType, obj);
                    return h;
                }
            });
        }
    }

    @Override // im.a
    public void f(MemberCheckResult memberCheckResult) {
        a.C0074a.a(this, memberCheckResult);
        wj.h.a.b(this.a.j() + " --> triggerDownload() --> showCheckMemberRights() --> notImplement() --> 当前类型没有实现");
    }

    @Override // im.a
    public void onFail(String str) {
        Intrinsics.h(str, "errorMsg");
        a.C0074a.b(this, str);
        wj.h.a.b(this.a.j() + " --> checkMemberRights() --> showCheckMemberRightsDialog() --> " + str);
        this.b.onFail();
    }
}
