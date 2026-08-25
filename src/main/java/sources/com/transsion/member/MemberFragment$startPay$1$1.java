package com.transsion.member;

import android.content.Context;
import androidx.lifecycle.v;
import com.transsion.memberapi.MemberDetail;
import com.transsion.memberapi.MemberInfo;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class MemberFragment$startPay$1$1 implements com.transsion.payment.lib.b {
    final /* synthetic */ MemberFragment a;
    final /* synthetic */ String b;
    final /* synthetic */ Ref.BooleanRef c;

    MemberFragment$startPay$1$1(MemberFragment memberFragment, String str, Ref.BooleanRef booleanRef) {
        this.a = memberFragment;
        this.b = str;
        this.c = booleanRef;
    }

    @Override // com.transsion.payment.lib.b
    public void a(Integer num, String str, boolean z, String str2) {
        a.a.m(wf.a.a, "Payment failed " + str + ", " + num, false, 2, (Object) null);
        if (num != null && num.intValue() == -30) {
            Ref.BooleanRef booleanRef = this.c;
            if (booleanRef.element) {
                return;
            }
            booleanRef.element = true;
            com.tn.lib.widget.toast.core.h hVar = com.tn.lib.widget.toast.core.h.a;
            Context context = this.a.getContext();
            hVar.l(context != null ? context.getString(R$string.member_pay_pending) : null);
            return;
        }
        if (num != null && num.intValue() == 1003) {
            MemberFragment.D0(this.a, this.b, num, str);
            com.tn.lib.widget.toast.core.h hVar2 = com.tn.lib.widget.toast.core.h.a;
            Context context2 = this.a.getContext();
            hVar2.l(context2 != null ? context2.getString(R$string.member_pay_processing) : null);
            if (this.a.getContext() != null) {
                this.a.K0();
                return;
            }
            return;
        }
        MemberFragment.D0(this.a, this.b, num, str);
        com.tn.lib.widget.toast.core.h hVar3 = com.tn.lib.widget.toast.core.h.a;
        Context context3 = this.a.getContext();
        hVar3.l(context3 != null ? context3.getString(R$string.member_pay_failed) : null);
        if (this.a.getContext() != null) {
            this.a.K0();
        }
    }

    @Override // com.transsion.payment.lib.b
    public void b(boolean z) {
        if (z) {
            this.a.showLoading();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    @Override // com.transsion.payment.lib.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(int i, String str, String str2) {
        boolean z;
        MemberInfo memberInfo;
        MemberInfo memberInfo2;
        Intrinsics.h(str, "balance");
        a.a aVar = wf.a.a;
        a.a.g(aVar, "Payment succeed " + str2, false, 2, (Object) null);
        MemberDetail B0 = MemberFragment.B0(this.a);
        if ((B0 == null || (memberInfo2 = B0.getMemberInfo()) == null) ? false : memberInfo2.isActive()) {
            MemberDetail B02 = MemberFragment.B0(this.a);
            if ((B02 == null || (memberInfo = B02.getMemberInfo()) == null || memberInfo.getMemberType() != 2) ? false : true) {
                z = true;
                a.a.g(aVar, "after pay isPremium:  " + z, false, 2, (Object) null);
                MemberFragment.F0(this.a, true);
                a.a.g(aVar, "Should refresh purchased info", false, 2, (Object) null);
                MemberFragment.E0(this.a, this.b);
                kotlinx.coroutines.i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new MemberFragment$startPay$1$1$success$1(this.a, null), 3, (Object) null);
                kotlinx.coroutines.i.d(v.a(this.a), (CoroutineContext) null, (CoroutineStart) null, new MemberFragment$startPay$1$1$success$2(str2, null), 3, (Object) null);
                if (this.a.getContext() == null) {
                    this.a.K0();
                    return;
                }
                return;
            }
        }
        z = false;
        a.a.g(aVar, "after pay isPremium:  " + z, false, 2, (Object) null);
        MemberFragment.F0(this.a, true);
        a.a.g(aVar, "Should refresh purchased info", false, 2, (Object) null);
        MemberFragment.E0(this.a, this.b);
        kotlinx.coroutines.i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new MemberFragment$startPay$1$1$success$1(this.a, null), 3, (Object) null);
        kotlinx.coroutines.i.d(v.a(this.a), (CoroutineContext) null, (CoroutineStart) null, new MemberFragment$startPay$1$1$success$2(str2, null), 3, (Object) null);
        if (this.a.getContext() == null) {
        }
    }
}
