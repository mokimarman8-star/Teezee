package com.transsion.member;

import com.therouter.TheRouter;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class MemberActivity$a extends androidx.activity.u {
    final /* synthetic */ MemberActivity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MemberActivity$a(MemberActivity memberActivity) {
        super(true);
        this.a = memberActivity;
    }

    public void handleOnBackPressed() {
        a.a.a("MemberActivity --> onBackPress --> handleOnBackPressed() --> setResult(RESULT_OK)");
        im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
        if (bVar != null ? bVar.m() : false) {
            this.a.setResult(-1);
        } else {
            this.a.setResult(0);
        }
        this.a.finish();
    }
}
