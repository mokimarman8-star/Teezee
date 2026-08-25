package com.transsion.player.longvideo.member;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.v;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.gslb.BuildConfig;
import com.transsion.memberapi.AdModule;
import com.transsion.memberapi.LotteryDisableModule;
import com.transsion.memberapi.LotteryModule;
import com.transsion.memberapi.MemberCheckResult;
import com.transsion.memberapi.MemberModule;
import com.transsion.memberapi.OrModule;
import com.transsion.memberapi.PayModule;
import com.transsion.memberapi.ThreeInOnePopup;
import com.transsion.memberapi.ThreeInOnePopupTitle;
import com.transsion.player.longvideo.R$id;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import ni.f;
import wj.g;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 42\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u0019\u0010\u000e\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0012\u0010\u000fJ\u0019\u0010\u0013\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0013\u0010\u000fJ\u0019\u0010\u0014\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0014\u0010\u000fJ\u0017\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001f\u0010\u001eJ\u000f\u0010 \u001a\u00020\bH\u0016¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\bH\u0016¢\u0006\u0004\b!\u0010\u0004J5\u0010&\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010$\u001a\u0004\u0018\u00010\u00052\b\u0010%\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b&\u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010$\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010%\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010,R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102¨\u00065"}, d2 = {"Lcom/transsion/player/longvideo/member/ResolutionUnlockFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lmn/b;", "<init>", "()V", BuildConfig.FLAVOR, "getClassTag", "()Ljava/lang/String;", BuildConfig.FLAVOR, "dismiss", "i0", "k0", "Lcom/transsion/memberapi/MemberCheckResult;", "memberCheckResult", "l0", "(Lcom/transsion/memberapi/MemberCheckResult;)V", "p0", "q0", "t0", "r0", "n0", "Landroid/view/LayoutInflater;", "inflater", "h0", "(Landroid/view/LayoutInflater;)Lmn/b;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initView", "lazyLoadData", "onDestroy", "Lln/a;", "bean", "pageName", "genre", "m0", "(Lln/a;Ljava/lang/String;Ljava/lang/String;Lcom/transsion/memberapi/MemberCheckResult;)V", "a", "Lln/a;", "longVdPlayerBean", "b", "Ljava/lang/String;", "c", "d", "Lcom/transsion/memberapi/MemberCheckResult;", "Lln/b;", "e", "Lln/b;", "config", "f", "LongVideo_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ResolutionUnlockFragment extends BaseFragment<mn.b> {

    /* renamed from: f, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    private ln.a longVdPlayerBean;

    /* renamed from: b, reason: from kotlin metadata */
    private String pageName;

    /* renamed from: c, reason: from kotlin metadata */
    private String genre;

    /* renamed from: d, reason: from kotlin metadata */
    private MemberCheckResult memberCheckResult;

    /* renamed from: e, reason: from kotlin metadata */
    private ln.b config;

    /* renamed from: com.transsion.player.longvideo.member.ResolutionUnlockFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ResolutionUnlockFragment a(ln.b bVar) {
            Intrinsics.h(bVar, "config");
            ResolutionUnlockFragment resolutionUnlockFragment = new ResolutionUnlockFragment();
            Bundle bundle = new Bundle();
            bundle.putString("arg_config_content", bVar.d());
            resolutionUnlockFragment.setArguments(bundle);
            resolutionUnlockFragment.config = bVar;
            return resolutionUnlockFragment;
        }
    }

    public static final class b implements wj.g {
        b() {
        }

        @Override // wj.g
        public void a(boolean z) {
            g.a.a(this, z);
        }

        @Override // wj.g
        public void onFail() {
        }

        @Override // wj.g
        public void onSuccess() {
            ResolutionUnlockFragment.this.i0();
        }
    }

    private final void dismiss() {
        getParentFragmentManager().F1("resolution_unlock_dismiss", new Bundle());
        k0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getClassTag() {
        String simpleName = ResolutionUnlockFragment.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0() {
        Bundle bundle = new Bundle();
        ln.b bVar = this.config;
        bundle.putString("config_content", bVar != null ? bVar.d() : null);
        getParentFragmentManager().F1("resolution_unlock_success", bundle);
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(ResolutionUnlockFragment resolutionUnlockFragment, View view) {
        resolutionUnlockFragment.dismiss();
    }

    private final void k0() {
        try {
            Result.Companion companion = Result.Companion;
            if (isAdded()) {
                getParentFragmentManager().p().r(this).j();
            }
            Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
    }

    private final void l0(MemberCheckResult memberCheckResult) {
        ThreeInOnePopup threeInOnePopup;
        List<String> moduleOrder;
        String str;
        if (memberCheckResult == null || (threeInOnePopup = memberCheckResult.getThreeInOnePopup()) == null || (moduleOrder = threeInOnePopup.getModuleOrder()) == null) {
            return;
        }
        for (String str2 : moduleOrder) {
            switch (str2.hashCode()) {
                case -2108817340:
                    if (str2.equals(ThreeInOnePopup.THREE_IN_ONE_MODULE_TYPE_PAY)) {
                        t0(memberCheckResult);
                        break;
                    } else {
                        continue;
                    }
                case -1373222562:
                    if (str2.equals(ThreeInOnePopup.THREE_IN_ONE_MODULE_TYPE_MEMBER)) {
                        r0(memberCheckResult);
                        break;
                    } else {
                        continue;
                    }
                case -1334275730:
                    if (str2.equals(ThreeInOnePopup.THREE_IN_ONE_MODULE_TYPE_LOTTERY_DISABLE)) {
                        q0(memberCheckResult);
                        break;
                    } else {
                        continue;
                    }
                case -1141281069:
                    str = ThreeInOnePopup.THREE_IN_ONE_MODULE_TYPE_UNSPECIFIED;
                    break;
                case -214437659:
                    if (str2.equals(ThreeInOnePopup.THREE_IN_ONE_MODULE_TYPE_LOTTERY)) {
                        p0(memberCheckResult);
                        break;
                    } else {
                        continue;
                    }
                case 1733088487:
                    if (str2.equals(ThreeInOnePopup.THREE_IN_ONE_MODULE_TYPE_AD)) {
                        n0(memberCheckResult);
                        break;
                    } else {
                        continue;
                    }
                case 1733088935:
                    str = ThreeInOnePopup.THREE_IN_ONE_MODULE_TYPE_OR;
                    break;
            }
            str2.equals(str);
        }
    }

    private final void n0(final MemberCheckResult memberCheckResult) {
        ThreeInOnePopup threeInOnePopup;
        AdModule adModule;
        final ResolutionAdView resolutionAdView;
        if (memberCheckResult == null || (threeInOnePopup = memberCheckResult.getThreeInOnePopup()) == null || (adModule = threeInOnePopup.getAdModule()) == null || Intrinsics.c(adModule.getEnable(), Boolean.FALSE)) {
            return;
        }
        wj.h.a.a(getClassTag() + " --> typeAd() --> genre = " + this.genre);
        mn.b bVar = (mn.b) getMViewBinding();
        if (bVar == null || (resolutionAdView = bVar.b) == null) {
            return;
        }
        resolutionAdView.setListener(new b());
        resolutionAdView.setGenre(this.genre);
        resolutionAdView.setAdCallback(new Function1() { // from class: com.transsion.player.longvideo.member.m
            public final Object invoke(Object obj) {
                Unit o0;
                o0 = ResolutionUnlockFragment.o0(ResolutionAdView.this, memberCheckResult, this, ((Boolean) obj).booleanValue());
                return o0;
            }
        });
        resolutionAdView.setAdModule(adModule);
        resolutionAdView.loadAd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit o0(ResolutionAdView resolutionAdView, MemberCheckResult memberCheckResult, ResolutionUnlockFragment resolutionUnlockFragment, boolean z) {
        OrModule orModule;
        mn.b bVar;
        LinearLayout linearLayout;
        if (z) {
            resolutionAdView.setVisibility(0);
            ThreeInOnePopup threeInOnePopup = memberCheckResult.getThreeInOnePopup();
            if (threeInOnePopup != null && (orModule = threeInOnePopup.getOrModule()) != null && !Intrinsics.c(orModule.getEnable(), Boolean.FALSE) && (bVar = (mn.b) resolutionUnlockFragment.getMViewBinding()) != null && (linearLayout = bVar.h) != null) {
                linearLayout.setVisibility(0);
            }
        } else {
            wj.h.a.a(resolutionUnlockFragment.getClassTag() + " --> typeAd() --> 广告加载失败");
        }
        return Unit.a;
    }

    private final void p0(MemberCheckResult memberCheckResult) {
        ThreeInOnePopup threeInOnePopup;
        LotteryModule lotteryModule;
        LinearLayout linearLayout;
        TextView textView;
        TextView textView2;
        String str;
        String highlightText;
        if (memberCheckResult == null || (threeInOnePopup = memberCheckResult.getThreeInOnePopup()) == null || (lotteryModule = threeInOnePopup.getLotteryModule()) == null || Intrinsics.c(lotteryModule.getEnable(), Boolean.FALSE)) {
            return;
        }
        wj.h.a.a(getClassTag() + " --> typeLottery() --> 开始渲染");
        mn.b bVar = (mn.b) getMViewBinding();
        if (bVar == null || (linearLayout = bVar.i) == null) {
            return;
        }
        linearLayout.setVisibility(0);
        mn.b bVar2 = (mn.b) getMViewBinding();
        if (bVar2 != null && (textView2 = bVar2.o) != null) {
            textView2.setVisibility(0);
            di.c cVar = di.c.a;
            ThreeInOnePopupTitle firstTitle = lotteryModule.getFirstTitle();
            String str2 = BuildConfig.FLAVOR;
            if (firstTitle == null || (str = firstTitle.getText()) == null) {
                str = BuildConfig.FLAVOR;
            }
            ThreeInOnePopupTitle firstTitle2 = lotteryModule.getFirstTitle();
            if (firstTitle2 != null && (highlightText = firstTitle2.getHighlightText()) != null) {
                str2 = highlightText;
            }
            textView2.setText(cVar.a(str, str2, Color.parseColor("#59D440")));
        }
        mn.b bVar3 = (mn.b) getMViewBinding();
        if (bVar3 == null || (textView = bVar3.p) == null) {
            return;
        }
        textView.setVisibility(0);
        ThreeInOnePopupTitle secondTitle = lotteryModule.getSecondTitle();
        textView.setText(secondTitle != null ? secondTitle.getText() : null);
    }

    private final void q0(MemberCheckResult memberCheckResult) {
        ThreeInOnePopup threeInOnePopup;
        LotteryDisableModule lotteryDisableModule;
        LinearLayout linearLayout;
        TextView textView;
        TextView textView2;
        String str;
        String highlightText;
        ImageView imageView;
        if (memberCheckResult == null || (threeInOnePopup = memberCheckResult.getThreeInOnePopup()) == null || (lotteryDisableModule = threeInOnePopup.getLotteryDisableModule()) == null || Intrinsics.c(lotteryDisableModule.getEnable(), Boolean.FALSE)) {
            return;
        }
        wj.h.a.a(getClassTag() + " --> typeLotteryDisable() --> 开始渲染");
        mn.b bVar = (mn.b) getMViewBinding();
        if (bVar == null || (linearLayout = bVar.j) == null) {
            return;
        }
        linearLayout.setVisibility(0);
        mn.b bVar2 = (mn.b) getMViewBinding();
        if (bVar2 != null && (imageView = bVar2.g) != null) {
            imageView.setVisibility(0);
            f.a aVar = ni.f.a;
            Context context = imageView.getContext();
            Intrinsics.g(context, "getContext(...)");
            aVar.m(context).g(lotteryDisableModule.getBannerUrl()).d(imageView);
        }
        mn.b bVar3 = (mn.b) getMViewBinding();
        if (bVar3 != null && (textView2 = bVar3.q) != null) {
            textView2.setVisibility(0);
            di.c cVar = di.c.a;
            ThreeInOnePopupTitle firstTitle = lotteryDisableModule.getFirstTitle();
            String str2 = BuildConfig.FLAVOR;
            if (firstTitle == null || (str = firstTitle.getText()) == null) {
                str = BuildConfig.FLAVOR;
            }
            ThreeInOnePopupTitle firstTitle2 = lotteryDisableModule.getFirstTitle();
            if (firstTitle2 != null && (highlightText = firstTitle2.getHighlightText()) != null) {
                str2 = highlightText;
            }
            textView2.setText(cVar.a(str, str2, Color.parseColor("#59D440")));
        }
        mn.b bVar4 = (mn.b) getMViewBinding();
        if (bVar4 == null || (textView = bVar4.r) == null) {
            return;
        }
        textView.setVisibility(0);
        ThreeInOnePopupTitle secondTitle = lotteryDisableModule.getSecondTitle();
        textView.setText(secondTitle != null ? secondTitle.getText() : null);
    }

    private final void r0(MemberCheckResult memberCheckResult) {
        ThreeInOnePopup threeInOnePopup;
        MemberModule memberModule;
        ConstraintLayout constraintLayout;
        TextView textView;
        ImageView imageView;
        if (memberCheckResult == null || (threeInOnePopup = memberCheckResult.getThreeInOnePopup()) == null || (memberModule = threeInOnePopup.getMemberModule()) == null || Intrinsics.c(memberModule.getEnable(), Boolean.FALSE)) {
            return;
        }
        wj.h.a.a(getClassTag() + " --> typeMember() --> 开始渲染");
        mn.b bVar = (mn.b) getMViewBinding();
        if (bVar == null || (constraintLayout = bVar.c) == null) {
            return;
        }
        constraintLayout.setVisibility(0);
        mn.b bVar2 = (mn.b) getMViewBinding();
        if (bVar2 != null && (imageView = bVar2.f) != null) {
            f.a aVar = ni.f.a;
            Context context = imageView.getContext();
            Intrinsics.g(context, "getContext(...)");
            aVar.m(context).g(memberModule.getIconUrl()).d(imageView);
        }
        mn.b bVar3 = (mn.b) getMViewBinding();
        if (bVar3 != null && (textView = bVar3.n) != null) {
            ThreeInOnePopupTitle text = memberModule.getText();
            textView.setText(text != null ? text.getText() : null);
        }
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.member.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ResolutionUnlockFragment.s0(ResolutionUnlockFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(ResolutionUnlockFragment resolutionUnlockFragment, View view) {
        kotlinx.coroutines.i.d(v.a(resolutionUnlockFragment), (CoroutineContext) null, (CoroutineStart) null, new ResolutionUnlockFragment$typeMember$1$1$2$1(resolutionUnlockFragment, null), 3, (Object) null);
    }

    private final void t0(MemberCheckResult memberCheckResult) {
        ThreeInOnePopup threeInOnePopup;
        final PayModule payModule;
        ConstraintLayout constraintLayout;
        TextView textView;
        TextView textView2;
        if (memberCheckResult == null || (threeInOnePopup = memberCheckResult.getThreeInOnePopup()) == null || (payModule = threeInOnePopup.getPayModule()) == null || Intrinsics.c(payModule.getEnable(), Boolean.FALSE)) {
            return;
        }
        wj.h.a.a(getClassTag() + " --> typePay() --> 开始渲染");
        mn.b bVar = (mn.b) getMViewBinding();
        if (bVar == null || (constraintLayout = bVar.d) == null) {
            return;
        }
        constraintLayout.setVisibility(0);
        mn.b bVar2 = (mn.b) getMViewBinding();
        if (bVar2 != null && (textView2 = bVar2.l) != null) {
            textView2.setText(payModule.getMoney());
        }
        mn.b bVar3 = (mn.b) getMViewBinding();
        if (bVar3 != null && (textView = bVar3.k) != null) {
            ThreeInOnePopupTitle text = payModule.getText();
            textView.setText(text != null ? text.getText() : null);
        }
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.member.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ResolutionUnlockFragment.u0(PayModule.this, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(PayModule payModule, ResolutionUnlockFragment resolutionUnlockFragment, View view) {
        Bundle bundle = new Bundle();
        bundle.putString("sku_id", payModule.getSkuId());
        ln.b bVar = resolutionUnlockFragment.config;
        bundle.putString("config_content", bVar != null ? bVar.d() : null);
        resolutionUnlockFragment.getParentFragmentManager().F1("resolution_pay", bundle);
        resolutionUnlockFragment.dismiss();
    }

    /* renamed from: h0, reason: merged with bridge method [inline-methods] */
    public mn.b getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        mn.b c = mn.b.c(inflater);
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public void initView(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
    }

    public void lazyLoadData() {
        l0(this.memberCheckResult);
    }

    public final void m0(ln.a bean, String pageName, String genre, MemberCheckResult memberCheckResult) {
        this.longVdPlayerBean = bean;
        this.pageName = pageName;
        this.genre = genre;
        this.memberCheckResult = memberCheckResult;
    }

    public void onDestroy() {
        ResolutionAdView resolutionAdView;
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        mn.b bVar = (mn.b) getMViewBinding();
        if (bVar == null || (resolutionAdView = bVar.b) == null) {
            return;
        }
        resolutionAdView.onDestroy();
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View findViewById = view.findViewById(R$id.ivClose);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.member.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ResolutionUnlockFragment.j0(ResolutionUnlockFragment.this, view2);
                }
            });
        }
    }
}
