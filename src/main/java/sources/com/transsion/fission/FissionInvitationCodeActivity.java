package com.transsion.fission;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.lifecycle.ViewModelLazy;
import com.blankj.utilcode.util.i;
import com.therouter.TheRouter;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.view.TitleLayout;
import com.transsion.baselib.report.launch.b;
import com.transsion.baseui.R$string;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.fission.FissionInvitationCodeActivity$special$;
import hk.a;
import ij.y;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0013R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001f\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/transsion/fission/FissionInvitationCodeActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Lhk/a;", "<init>", "()V", "", "k0", "", "code", "n0", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "savedInstanceState", "initView", "(Landroid/os/Bundle;)V", "h0", "()Lhk/a;", "", "isStatusDark", "()Z", "isTranslucent", "Lkk/a;", "a", "Lkotlin/Lazy;", "g0", "()Lkk/a;", "mFissionProvider", "Lcom/transsion/fission/f;", "b", "f0", "()Lcom/transsion/fission/f;", "mFissionInvitationViewModel", "Fission_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class FissionInvitationCodeActivity extends BaseActivity<a> {

    /* renamed from: a, reason: from kotlin metadata */
    private final Lazy mFissionProvider = LazyKt.b(new a());

    /* renamed from: b, reason: from kotlin metadata */
    private final Lazy mFissionInvitationViewModel = new ViewModelLazy(Reflection.b(f.class), new FissionInvitationCodeActivity$special$.inlined.viewModels.default.2(this), new FissionInvitationCodeActivity$special$.inlined.viewModels.default.1(this), new FissionInvitationCodeActivity$special$.inlined.viewModels.default.3((Function0) null, this));

    private final f f0() {
        return (f) this.mFissionInvitationViewModel.getValue();
    }

    private final kk.a g0() {
        return (kk.a) this.mFissionProvider.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void i0(FissionInvitationCodeActivity fissionInvitationCodeActivity, View view) {
        fissionInvitationCodeActivity.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void j0(FissionInvitationCodeActivity fissionInvitationCodeActivity, View view) {
        Editable text = fissionInvitationCodeActivity.getMViewBinding().c.getText();
        String obj = text != null ? text.toString() : null;
        if (obj == null || obj.length() != 8) {
            return;
        }
        fissionInvitationCodeActivity.n0(obj);
    }

    private final void k0() {
        f0().e().j(this, new b(new d(this)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit l0(FissionInvitationCodeActivity fissionInvitationCodeActivity, BaseDto baseDto) {
        if (baseDto == null) {
            return Unit.a;
        }
        if (Intrinsics.c(baseDto.getCode(), "0")) {
            com.tn.lib.widget.toast.core.h.a.k(R.string.fission_invitation_success);
            fissionInvitationCodeActivity.setResult(-1);
            fissionInvitationCodeActivity.finish();
        } else {
            com.tn.lib.widget.toast.core.h.a.k(R.string.fission_invitation_err);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kk.a m0() {
        return (kk.a) TheRouter.d(kk.a.class, new Object[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void n0(String code) {
        if (zg.g.a.a(this)) {
            f0().g(code);
        } else {
            com.tn.lib.widget.toast.core.h.a.k(R$string.base_net_err);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: h0, reason: merged with bridge method [inline-methods] */
    public a getViewBinding() {
        a c = a.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity
    public void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        TitleLayout titleLayout = getMViewBinding().d;
        String string = getString(R.string.fission_invitation_code);
        Intrinsics.g(string, "getString(...)");
        titleLayout.setTitleText(string);
        getMViewBinding().d.setLeftOnclick(new b(this));
        AppCompatEditText appCompatEditText = getMViewBinding().c;
        kk.a g0 = g0();
        appCompatEditText.setText(g0 != null ? g0.h() : null);
        AppCompatEditText appCompatEditText2 = getMViewBinding().c;
        Intrinsics.g(appCompatEditText2, "etInvitationCode");
        jk.a.a(appCompatEditText2, i.e(4.0f));
        AppCompatEditText appCompatEditText3 = getMViewBinding().c;
        Intrinsics.g(appCompatEditText3, "etInvitationCode");
        appCompatEditText3.addTextChangedListener(new a(this));
        getMViewBinding().b.setOnClickListener(new c(this));
        k0();
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return b.a.b().getBoolean("dark_mode_follow_sys", true) && !y.a.a();
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }
}
