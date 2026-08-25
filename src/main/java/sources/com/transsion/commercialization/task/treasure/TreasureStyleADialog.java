package com.transsion.commercialization.task.treasure;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.v;
import com.tn.lib.widget.R;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.commercialization.R$layout;
import com.transsion.gslb.BuildConfig;
import com.transsion.memberapi.AdModule;
import com.transsion.memberapi.LotteryDisableModule;
import com.transsion.memberapi.LotteryModule;
import com.transsion.memberapi.MemberCheckResult;
import com.transsion.memberapi.MemberModule;
import com.transsion.memberapi.MemberSceneType;
import com.transsion.memberapi.OrModule;
import com.transsion.memberapi.PayModule;
import com.transsion.memberapi.ThreeInOnePopup;
import com.transsion.memberapi.ThreeInOnePopupTitle;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import ni.f;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0003J\u000f\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u0003J\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010%¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00002\b\u0010*\u001a\u0004\u0018\u00010)¢\u0006\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u0010\"\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006="}, d2 = {"Lcom/transsion/commercialization/task/treasure/TreasureStyleADialog;", "Lcom/transsion/baseui/dialog/BaseDialog;", "<init>", "()V", BuildConfig.FLAVOR, "v0", "D0", "E0", "H0", "F0", "B0", "u0", BuildConfig.FLAVOR, "moduleName", "t0", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onDestroy", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Lcom/transsion/memberapi/MemberCheckResult;", "memberCheckResult", "z0", "(Lcom/transsion/memberapi/MemberCheckResult;)Lcom/transsion/commercialization/task/treasure/TreasureStyleADialog;", "genre", "x0", "(Ljava/lang/String;)Lcom/transsion/commercialization/task/treasure/TreasureStyleADialog;", "Lwj/g;", "listener", "y0", "(Lwj/g;)Lcom/transsion/commercialization/task/treasure/TreasureStyleADialog;", "Lcom/transsion/memberapi/MemberSceneType;", "sceneType", "A0", "(Lcom/transsion/memberapi/MemberSceneType;)Lcom/transsion/commercialization/task/treasure/TreasureStyleADialog;", "Lsj/e;", "c", "Lsj/e;", "bind", "d", "Lcom/transsion/memberapi/MemberCheckResult;", "e", "Ljava/lang/String;", "f", "Lwj/g;", "g", "Lcom/transsion/memberapi/MemberSceneType;", BuildConfig.FLAVOR, "h", "Z", "isDisplayed", "Commercialization_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class TreasureStyleADialog extends BaseDialog {

    /* renamed from: c, reason: from kotlin metadata */
    private sj.e bind;

    /* renamed from: d, reason: from kotlin metadata */
    private MemberCheckResult memberCheckResult;

    /* renamed from: e, reason: from kotlin metadata */
    private String genre;

    /* renamed from: f, reason: from kotlin metadata */
    private wj.g listener;

    /* renamed from: g, reason: from kotlin metadata */
    private MemberSceneType sceneType;

    /* renamed from: h, reason: from kotlin metadata */
    private boolean isDisplayed;

    public static final class a implements c {
        a() {
        }

        @Override // com.transsion.commercialization.task.treasure.c
        public void a() {
            wj.g gVar = TreasureStyleADialog.this.listener;
            if (gVar != null) {
                gVar.onSuccess();
            }
            TreasureStyleADialog.this.dismissAllowingStateLoss();
            TreasureStyleADialog.this.t0("typeAdInstall");
        }

        @Override // com.transsion.commercialization.task.treasure.c
        public void b() {
            TreasureStyleADialog.this.t0("typeAdChange");
        }
    }

    public TreasureStyleADialog() {
        super(R$layout.dialog_treasure_intercept_layout);
    }

    private final void B0() {
        ThreeInOnePopup threeInOnePopup;
        AdModule adModule;
        final TreasureAdView treasureAdView;
        MemberCheckResult memberCheckResult = this.memberCheckResult;
        if (memberCheckResult == null || (threeInOnePopup = memberCheckResult.getThreeInOnePopup()) == null || (adModule = threeInOnePopup.getAdModule()) == null || Intrinsics.c(adModule.getEnable(), Boolean.FALSE)) {
            return;
        }
        wj.h.a.a(getClassTag() + " --> typeAd() --> 开始渲染 --> genre = " + this.genre);
        sj.e eVar = this.bind;
        if (eVar == null || (treasureAdView = eVar.b) == null) {
            return;
        }
        treasureAdView.setListener(new a());
        treasureAdView.setGenre(this.genre);
        treasureAdView.setAdCallback(new Function1() { // from class: com.transsion.commercialization.task.treasure.i
            public final Object invoke(Object obj) {
                Unit C0;
                C0 = TreasureStyleADialog.C0(TreasureAdView.this, this, ((Boolean) obj).booleanValue());
                return C0;
            }
        });
        treasureAdView.loadAd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit C0(TreasureAdView treasureAdView, TreasureStyleADialog treasureStyleADialog, boolean z) {
        ThreeInOnePopup threeInOnePopup;
        OrModule orModule;
        sj.e eVar;
        LinearLayout linearLayout;
        if (z) {
            treasureAdView.setVisibility(0);
            MemberCheckResult memberCheckResult = treasureStyleADialog.memberCheckResult;
            if (memberCheckResult != null && (threeInOnePopup = memberCheckResult.getThreeInOnePopup()) != null && (orModule = threeInOnePopup.getOrModule()) != null && !Intrinsics.c(orModule.getEnable(), Boolean.FALSE) && (eVar = treasureStyleADialog.bind) != null && (linearLayout = eVar.j) != null) {
                linearLayout.setVisibility(0);
            }
        } else {
            wj.h.a.a(treasureStyleADialog.getClassTag() + " --> typeAd() --> 广告加载失败");
        }
        return Unit.a;
    }

    private final void D0() {
        ThreeInOnePopup threeInOnePopup;
        LotteryModule lotteryModule;
        TextView textView;
        TextView textView2;
        TextView textView3;
        String str;
        String highlightText;
        ImageView imageView;
        MemberCheckResult memberCheckResult = this.memberCheckResult;
        if (memberCheckResult == null || (threeInOnePopup = memberCheckResult.getThreeInOnePopup()) == null || (lotteryModule = threeInOnePopup.getLotteryModule()) == null || Intrinsics.c(lotteryModule.getEnable(), Boolean.FALSE)) {
            return;
        }
        wj.h.a.a(getClassTag() + " --> typeLottery() --> 开始渲染");
        sj.e eVar = this.bind;
        if (eVar != null && (imageView = eVar.h) != null) {
            imageView.setVisibility(0);
            f.a aVar = ni.f.a;
            Context context = imageView.getContext();
            Intrinsics.g(context, "getContext(...)");
            aVar.m(context).g(lotteryModule.getBannerUrl()).d(imageView);
        }
        sj.e eVar2 = this.bind;
        if (eVar2 != null && (textView3 = eVar2.o) != null) {
            textView3.setVisibility(0);
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
            textView3.setText(cVar.a(str, str2, Color.parseColor("#59D440")));
        }
        sj.e eVar3 = this.bind;
        if (eVar3 != null && (textView2 = eVar3.p) != null) {
            textView2.setVisibility(0);
            ThreeInOnePopupTitle secondTitle = lotteryModule.getSecondTitle();
            textView2.setText(secondTitle != null ? secondTitle.getText() : null);
        }
        sj.e eVar4 = this.bind;
        if (eVar4 == null || (textView = eVar4.q) == null) {
            return;
        }
        textView.setVisibility(0);
        ThreeInOnePopupTitle thirdTitle = lotteryModule.getThirdTitle();
        textView.setText(thirdTitle != null ? thirdTitle.getText() : null);
    }

    private final void E0() {
        ThreeInOnePopup threeInOnePopup;
        LotteryDisableModule lotteryDisableModule;
        TextView textView;
        TextView textView2;
        String str;
        String highlightText;
        ImageView imageView;
        MemberCheckResult memberCheckResult = this.memberCheckResult;
        if (memberCheckResult == null || (threeInOnePopup = memberCheckResult.getThreeInOnePopup()) == null || (lotteryDisableModule = threeInOnePopup.getLotteryDisableModule()) == null || Intrinsics.c(lotteryDisableModule.getEnable(), Boolean.FALSE)) {
            return;
        }
        wj.h.a.a(getClassTag() + " --> typeLotteryDisable() --> 开始渲染");
        sj.e eVar = this.bind;
        if (eVar != null && (imageView = eVar.f) != null) {
            imageView.setVisibility(0);
            f.a aVar = ni.f.a;
            Context context = imageView.getContext();
            Intrinsics.g(context, "getContext(...)");
            aVar.m(context).g(lotteryDisableModule.getBannerUrl()).d(imageView);
        }
        sj.e eVar2 = this.bind;
        if (eVar2 != null && (textView2 = eVar2.o) != null) {
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
        sj.e eVar3 = this.bind;
        if (eVar3 == null || (textView = eVar3.p) == null) {
            return;
        }
        textView.setVisibility(0);
        ThreeInOnePopupTitle secondTitle = lotteryDisableModule.getSecondTitle();
        textView.setText(secondTitle != null ? secondTitle.getText() : null);
    }

    private final void F0() {
        ThreeInOnePopup threeInOnePopup;
        MemberModule memberModule;
        TextView textView;
        ImageView imageView;
        ConstraintLayout constraintLayout;
        MemberCheckResult memberCheckResult = this.memberCheckResult;
        if (memberCheckResult == null || (threeInOnePopup = memberCheckResult.getThreeInOnePopup()) == null || (memberModule = threeInOnePopup.getMemberModule()) == null || Intrinsics.c(memberModule.getEnable(), Boolean.FALSE)) {
            return;
        }
        wj.h.a.a(getClassTag() + " --> typeMember() --> 开始渲染");
        sj.e eVar = this.bind;
        if (eVar != null && (constraintLayout = eVar.c) != null) {
            constraintLayout.setVisibility(0);
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.commercialization.task.treasure.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TreasureStyleADialog.G0(TreasureStyleADialog.this, view);
                }
            });
        }
        sj.e eVar2 = this.bind;
        if (eVar2 != null && (imageView = eVar2.g) != null) {
            f.a aVar = ni.f.a;
            Context context = imageView.getContext();
            Intrinsics.g(context, "getContext(...)");
            aVar.m(context).g(memberModule.getIconUrl()).d(imageView);
        }
        sj.e eVar3 = this.bind;
        if (eVar3 == null || (textView = eVar3.n) == null) {
            return;
        }
        ThreeInOnePopupTitle text = memberModule.getText();
        textView.setText(text != null ? text.getText() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(TreasureStyleADialog treasureStyleADialog, View view) {
        treasureStyleADialog.t0("typeMember");
        kotlinx.coroutines.i.d(v.a(treasureStyleADialog), (CoroutineContext) null, (CoroutineStart) null, new TreasureStyleADialog$typeMember$1$1$1$1(treasureStyleADialog, null), 3, (Object) null);
    }

    private final void H0() {
        ThreeInOnePopup threeInOnePopup;
        final PayModule payModule;
        ConstraintLayout constraintLayout;
        TextView textView;
        TextView textView2;
        MemberCheckResult memberCheckResult = this.memberCheckResult;
        if (memberCheckResult == null || (threeInOnePopup = memberCheckResult.getThreeInOnePopup()) == null || (payModule = threeInOnePopup.getPayModule()) == null || Intrinsics.c(payModule.getEnable(), Boolean.FALSE)) {
            return;
        }
        wj.h.a.a(getClassTag() + " --> typePay() --> 开始渲染");
        sj.e eVar = this.bind;
        if (eVar == null || (constraintLayout = eVar.d) == null) {
            return;
        }
        if (eVar != null && constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        sj.e eVar2 = this.bind;
        if (eVar2 != null && (textView2 = eVar2.l) != null) {
            textView2.setText(payModule.getMoney());
        }
        sj.e eVar3 = this.bind;
        if (eVar3 != null && (textView = eVar3.k) != null) {
            ThreeInOnePopupTitle text = payModule.getText();
            textView.setText(text != null ? text.getText() : null);
        }
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.commercialization.task.treasure.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TreasureStyleADialog.I0(TreasureStyleADialog.this, payModule, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(final TreasureStyleADialog treasureStyleADialog, PayModule payModule, View view) {
        treasureStyleADialog.t0("typePay");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("activity", "lottery");
        AppCompatActivity activity = treasureStyleADialog.getActivity();
        AppCompatActivity appCompatActivity = activity instanceof AppCompatActivity ? activity : null;
        if (appCompatActivity != null) {
            com.transsion.payment.lib.f a2 = com.transsion.payment.lib.f.b.a();
            String skuId = payModule.getSkuId();
            if (skuId == null) {
                skuId = BuildConfig.FLAVOR;
            }
            a2.e(appCompatActivity, skuId, (r16 & 4) != 0 ? null : null, (r16 & 8) != 0 ? false : false, (r16 & 16) != 0 ? null : linkedHashMap, new com.transsion.payment.lib.b() { // from class: com.transsion.commercialization.task.treasure.TreasureStyleADialog$typePay$1$1$2$1$1
                @Override // com.transsion.payment.lib.b
                public void a(Integer num, String str, boolean z, String str2) {
                    wj.h.a.a(TreasureStyleADialog.this.getClassTag() + " --> error(支付失败) --> Payment failed " + str + ", " + num);
                }

                @Override // com.transsion.payment.lib.b
                public void b(boolean z) {
                }

                @Override // com.transsion.payment.lib.b
                public void c(int i, String str, String str2) {
                    Intrinsics.h(str, "balance");
                    wj.h.a.a(TreasureStyleADialog.this.getClassTag() + " --> success(支付成功) --> 1.激励任务完成 -- 2. 支付成功，请求大转盘信息");
                    wj.g gVar = TreasureStyleADialog.this.listener;
                    if (gVar != null) {
                        gVar.onSuccess();
                    }
                    kotlinx.coroutines.i.d(v.a(TreasureStyleADialog.this), (CoroutineContext) null, (CoroutineStart) null, new TreasureStyleADialog$typePay$1$1$2$1$1$success$1(str2, TreasureStyleADialog.this, null), 3, (Object) null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t0(String moduleName) {
        String str;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dialog_name", "3_in_1");
            hashMap.put("module_name", moduleName);
            MemberSceneType memberSceneType = this.sceneType;
            if (memberSceneType == null || (str = memberSceneType.getValue()) == null) {
                str = "sceneType == null";
            }
            hashMap.put("source", str);
            qi.h hVar = qi.h.a;
            String simpleName = activity.getClass().getSimpleName();
            Intrinsics.g(simpleName, "getSimpleName(...)");
            hVar.o(simpleName, hashMap);
        }
    }

    private final void u0() {
        String str;
        if (this.isDisplayed) {
            return;
        }
        this.isDisplayed = true;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dialog_name", "3_in_1");
            MemberSceneType memberSceneType = this.sceneType;
            if (memberSceneType == null || (str = memberSceneType.getValue()) == null) {
                str = "sceneType == null";
            }
            hashMap.put("source", str);
            qi.h hVar = qi.h.a;
            String simpleName = activity.getClass().getSimpleName();
            Intrinsics.g(simpleName, "getSimpleName(...)");
            hVar.p(simpleName, hashMap);
        }
    }

    private final void v0() {
        ThreeInOnePopup threeInOnePopup;
        List<String> moduleOrder;
        String str;
        AppCompatImageView appCompatImageView;
        sj.e eVar = this.bind;
        if (eVar != null && (appCompatImageView = eVar.e) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.commercialization.task.treasure.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TreasureStyleADialog.w0(TreasureStyleADialog.this, view);
                }
            });
        }
        MemberCheckResult memberCheckResult = this.memberCheckResult;
        if (memberCheckResult == null || (threeInOnePopup = memberCheckResult.getThreeInOnePopup()) == null || (moduleOrder = threeInOnePopup.getModuleOrder()) == null) {
            return;
        }
        for (String str2 : moduleOrder) {
            switch (str2.hashCode()) {
                case -2108817340:
                    if (str2.equals(ThreeInOnePopup.THREE_IN_ONE_MODULE_TYPE_PAY)) {
                        H0();
                        break;
                    } else {
                        continue;
                    }
                case -1373222562:
                    if (str2.equals(ThreeInOnePopup.THREE_IN_ONE_MODULE_TYPE_MEMBER)) {
                        F0();
                        break;
                    } else {
                        continue;
                    }
                case -1334275730:
                    if (str2.equals(ThreeInOnePopup.THREE_IN_ONE_MODULE_TYPE_LOTTERY_DISABLE)) {
                        E0();
                        break;
                    } else {
                        continue;
                    }
                case -1141281069:
                    str = ThreeInOnePopup.THREE_IN_ONE_MODULE_TYPE_UNSPECIFIED;
                    break;
                case -214437659:
                    if (str2.equals(ThreeInOnePopup.THREE_IN_ONE_MODULE_TYPE_LOTTERY)) {
                        D0();
                        break;
                    } else {
                        continue;
                    }
                case 1733088487:
                    if (str2.equals(ThreeInOnePopup.THREE_IN_ONE_MODULE_TYPE_AD)) {
                        B0();
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(TreasureStyleADialog treasureStyleADialog, View view) {
        treasureStyleADialog.t0("ivClose");
        treasureStyleADialog.dismissAllowingStateLoss();
    }

    public final TreasureStyleADialog A0(MemberSceneType sceneType) {
        this.sceneType = sceneType;
        return this;
    }

    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.h(newConfig, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(newConfig);
        dismissAllowingStateLoss();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R.style.BaseDialogStyle);
    }

    @Override // com.transsion.baseui.dialog.BaseDialog
    public void onDestroy() {
        TreasureAdView treasureAdView;
        super.onDestroy();
        sj.e eVar = this.bind;
        if (eVar == null || (treasureAdView = eVar.b) == null) {
            return;
        }
        treasureAdView.onDestroy();
    }

    @Override // com.transsion.baseui.dialog.BaseDialog
    public void onResume() {
        super.onResume();
        u0();
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(view, savedInstanceState);
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCancelable(false);
        }
        this.bind = sj.e.a(view);
        v0();
    }

    public final TreasureStyleADialog x0(String genre) {
        this.genre = genre;
        return this;
    }

    public final TreasureStyleADialog y0(wj.g listener) {
        this.listener = listener;
        return this;
    }

    public final TreasureStyleADialog z0(MemberCheckResult memberCheckResult) {
        this.memberCheckResult = memberCheckResult;
        return this;
    }
}
