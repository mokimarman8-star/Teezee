package com.transsion.commercialization.task;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class TaskCenterProvider$b implements im.c {
    final /* synthetic */ TaskCenterProvider a;
    final /* synthetic */ wj.g b;

    TaskCenterProvider$b(TaskCenterProvider taskCenterProvider, wj.g gVar) {
        this.a = taskCenterProvider;
        this.b = gVar;
    }

    @Override // im.c
    public void a() {
        wj.h.a.a(this.a.j() + " --> showMemberPage() --> checkMember() --> onFailed() --> 开通会员失败");
        wj.g gVar = this.b;
        if (gVar != null) {
            gVar.onFail();
        }
    }

    @Override // im.c
    public void onSuccess() {
        wj.h.a.a(this.a.j() + " --> showMemberPage() --> checkMember() --> onSuccess() --> 开通会员成功，直接下载不需要做任务了");
        wj.g gVar = this.b;
        if (gVar != null) {
            gVar.onSuccess();
        }
    }
}
