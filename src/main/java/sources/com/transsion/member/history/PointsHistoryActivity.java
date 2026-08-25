package com.transsion.member.history;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.w;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.c0;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import com.gyf.immersionbar.ImmersionBar;
import com.transsion.baseui.activity.BaseNewActivity;
import com.transsion.gslb.BuildConfig;
import com.transsion.member.R$id;
import com.transsion.member.R$string;
import com.transsion.member.bean.PointsHistoryData;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0014\u0010\u0004R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/transsion/member/history/PointsHistoryActivity;", "Lcom/transsion/baseui/activity/BaseNewActivity;", "Lgm/b;", "<init>", "()V", BuildConfig.FLAVOR, "f0", "()Ljava/lang/String;", BuildConfig.FLAVOR, "isTranslucent", "()Z", "o0", BuildConfig.FLAVOR, "l0", "m0", "k0", "p0", "retryLoadData", "F0", "()Lgm/b;", "q0", "Lcom/transsion/member/history/PointsHistoryViewModel;", "i", "Lkotlin/Lazy;", "E0", "()Lcom/transsion/member/history/PointsHistoryViewModel;", "mViewModel", "Member_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PointsHistoryActivity extends BaseNewActivity<gm.b> {

    /* renamed from: i, reason: from kotlin metadata */
    private final Lazy mViewModel;

    static final class a implements c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        a(Function1 function1) {
            Intrinsics.h(function1, "function");
            this.a = function1;
        }

        public final Function a() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.a.invoke(obj);
        }
    }

    public PointsHistoryActivity() {
        final Function0 function0 = null;
        this.mViewModel = new ViewModelLazy(Reflection.b(PointsHistoryViewModel.class), new Function0<x0>() { // from class: com.transsion.member.history.PointsHistoryActivity$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final x0 m33invoke() {
                return this.getViewModelStore();
            }
        }, new Function0<v0.c>() { // from class: com.transsion.member.history.PointsHistoryActivity$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final v0.c m32invoke() {
                return this.getDefaultViewModelProviderFactory();
            }
        }, new Function0<p1.a>() { // from class: com.transsion.member.history.PointsHistoryActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final p1.a invoke() {
                p1.a aVar;
                Function0 function02 = function0;
                return (function02 == null || (aVar = (p1.a) function02.invoke()) == null) ? this.getDefaultViewModelCreationExtras() : aVar;
            }
        });
    }

    private final PointsHistoryViewModel E0() {
        return (PointsHistoryViewModel) this.mViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(PointsHistoryActivity pointsHistoryActivity, View view) {
        pointsHistoryActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H0(PointsHistoryActivity pointsHistoryActivity, PointsHistoryData pointsHistoryData) {
        String str;
        AppCompatTextView appCompatTextView = ((gm.b) pointsHistoryActivity.getMViewBinding()).d;
        if (pointsHistoryData == null || (str = pointsHistoryData.getCoinBalance()) == null) {
            str = "0";
        }
        appCompatTextView.setText(str);
        return Unit.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: F0, reason: merged with bridge method [inline-methods] */
    public gm.b getViewBinding() {
        gm.b c = gm.b.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public String f0() {
        return BuildConfig.FLAVOR;
    }

    public boolean isTranslucent() {
        return true;
    }

    public void k0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void l0() {
        ((gm.b) getMViewBinding()).c.c.setText(getString(R$string.points_history_title));
        ((gm.b) getMViewBinding()).c.b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.history.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PointsHistoryActivity.G0(PointsHistoryActivity.this, view);
            }
        });
        LinearLayoutCompat root = ((gm.b) getMViewBinding()).getRoot();
        Intrinsics.g(root, "getRoot(...)");
        uf.c.e(root);
        s0();
        ImmersionBar.with(this).statusBarDarkFont(false).init();
    }

    public void m0() {
        E0().e().j(this, new a(new Function1() { // from class: com.transsion.member.history.b
            public final Object invoke(Object obj) {
                Unit H0;
                H0 = PointsHistoryActivity.H0(PointsHistoryActivity.this, (PointsHistoryData) obj);
                return H0;
            }
        }));
    }

    public boolean o0() {
        return false;
    }

    public void p0() {
    }

    public void q0() {
        super.q0();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
        w p = supportFragmentManager.p();
        Intrinsics.g(p, "beginTransaction()");
        p.s(R$id.container, PointsHistoryFragment.INSTANCE.a());
        p.j();
    }

    public void retryLoadData() {
    }
}
