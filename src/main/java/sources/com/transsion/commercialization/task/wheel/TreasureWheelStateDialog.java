package com.transsion.commercialization.task.wheel;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.widget.R;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.bean.lottery.LotteryDrawResultEntity;
import com.transsion.bean.lottery.LotteryUserActivityInfoPriceBean;
import com.transsion.commercialization.R$layout;
import com.transsion.commercializationapi.R$string;
import com.transsion.gslb.BuildConfig;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ni.f;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0003J\u0017\u0010\u0016\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/transsion/commercialization/task/wheel/TreasureWheelStateDialog;", "Lcom/transsion/baseui/dialog/BaseDialog;", "<init>", "()V", BuildConfig.FLAVOR, "r0", "q0", BuildConfig.FLAVOR, "moduleName", "p0", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "Lcom/transsion/bean/lottery/LotteryDrawResultEntity$LotteryResultBean;", "target", "u0", "(Lcom/transsion/bean/lottery/LotteryDrawResultEntity$LotteryResultBean;)Lcom/transsion/commercialization/task/wheel/TreasureWheelStateDialog;", "Lsj/g;", "c", "Lsj/g;", "bind", "d", "Lcom/transsion/bean/lottery/LotteryDrawResultEntity$LotteryResultBean;", BuildConfig.FLAVOR, "e", "Z", "isDisplayed", "Commercialization_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class TreasureWheelStateDialog extends BaseDialog {

    /* renamed from: c, reason: from kotlin metadata */
    private sj.g bind;

    /* renamed from: d, reason: from kotlin metadata */
    private LotteryDrawResultEntity.LotteryResultBean target;

    /* renamed from: e, reason: from kotlin metadata */
    private boolean isDisplayed;

    public TreasureWheelStateDialog() {
        super(R$layout.dialog_treasure_wheel_state_layout);
    }

    private final void p0(String moduleName) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dialog_name", "lucky_wheel_result");
            hashMap.put("module_name", moduleName);
            qi.h hVar = qi.h.a;
            String simpleName = activity.getClass().getSimpleName();
            Intrinsics.g(simpleName, "getSimpleName(...)");
            hVar.o(simpleName, hashMap);
        }
    }

    private final void q0() {
        if (this.isDisplayed) {
            return;
        }
        this.isDisplayed = true;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dialog_name", "lucky_wheel_result");
            qi.h hVar = qi.h.a;
            String simpleName = activity.getClass().getSimpleName();
            Intrinsics.g(simpleName, "getSimpleName(...)");
            hVar.p(simpleName, hashMap);
        }
    }

    private final void r0() {
        TextView textView;
        LotteryUserActivityInfoPriceBean price;
        ImageView imageView;
        LotteryUserActivityInfoPriceBean price2;
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        AppCompatImageView appCompatImageView3;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        LotteryUserActivityInfoPriceBean price3;
        FrameLayout frameLayout;
        AppCompatImageView appCompatImageView4;
        wj.h.a.c(getClassTag() + " --> render() --> target = " + this.target);
        sj.g gVar = this.bind;
        if (gVar != null && (appCompatImageView4 = gVar.c) != null) {
            appCompatImageView4.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.commercialization.task.wheel.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TreasureWheelStateDialog.s0(TreasureWheelStateDialog.this, view);
                }
            });
        }
        sj.g gVar2 = this.bind;
        if (gVar2 != null && (frameLayout = gVar2.n) != null) {
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.commercialization.task.wheel.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TreasureWheelStateDialog.t0(TreasureWheelStateDialog.this, view);
                }
            });
        }
        LotteryDrawResultEntity.LotteryResultBean lotteryResultBean = this.target;
        String str = null;
        if (Intrinsics.c((lotteryResultBean == null || (price3 = lotteryResultBean.getPrice()) == null) ? null : price3.getPriceType(), "THANK_YOU")) {
            Context context = getContext();
            if (context != null) {
                sj.g gVar3 = this.bind;
                if (gVar3 != null && (textView4 = gVar3.k) != null) {
                    textView4.setText(androidx.core.content.b.getString(context, R$string.treasure_don_not_give_up_more_amazing_prizes_are_waiting_for_you));
                }
                sj.g gVar4 = this.bind;
                if (gVar4 != null && (textView3 = gVar4.i) != null) {
                    textView3.setText(androidx.core.content.b.getString(context, R$string.treasure_view_more_prizes));
                }
                sj.g gVar5 = this.bind;
                if (gVar5 != null && (textView2 = gVar5.j) != null) {
                    textView2.setText(androidx.core.content.b.getString(context, R$string.treasure_so_close));
                }
            }
            sj.g gVar6 = this.bind;
            if (gVar6 != null && (appCompatImageView3 = gVar6.b) != null) {
                appCompatImageView3.setVisibility(8);
            }
            sj.g gVar7 = this.bind;
            if (gVar7 != null && (appCompatImageView2 = gVar7.d) != null) {
                appCompatImageView2.setVisibility(4);
            }
            sj.g gVar8 = this.bind;
            if (gVar8 != null && (appCompatImageView = gVar8.e) != null) {
                appCompatImageView.setVisibility(4);
            }
        } else {
            Context context2 = getContext();
            if (context2 != null) {
                di.c cVar = di.c.a;
                String string = androidx.core.content.b.getString(context2, R$string.treasure_you_have_just_won_a);
                Intrinsics.g(string, "getString(...)");
                int i = R.font.mulish_bold;
                int color = androidx.core.content.b.getColor(context2, R.color.white_80);
                int color2 = androidx.core.content.b.getColor(context2, R.color.white);
                LotteryDrawResultEntity.LotteryResultBean lotteryResultBean2 = this.target;
                SpannableString c = cVar.c(context2, string, i, Integer.valueOf(color), "  " + ((lotteryResultBean2 == null || (price = lotteryResultBean2.getPrice()) == null) ? null : price.getName()), R.font.mulish_regular, Integer.valueOf(color2));
                sj.g gVar9 = this.bind;
                if (gVar9 != null && (textView = gVar9.k) != null) {
                    textView.setText(c);
                }
            }
        }
        sj.g gVar10 = this.bind;
        if (gVar10 == null || (imageView = gVar10.f) == null) {
            return;
        }
        f.a aVar = ni.f.a;
        Context context3 = imageView.getContext();
        Intrinsics.g(context3, "getContext(...)");
        f.b m = aVar.m(context3);
        LotteryDrawResultEntity.LotteryResultBean lotteryResultBean3 = this.target;
        if (lotteryResultBean3 != null && (price2 = lotteryResultBean3.getPrice()) != null) {
            str = price2.getImgUrl();
        }
        m.g(str).d(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(TreasureWheelStateDialog treasureWheelStateDialog, View view) {
        treasureWheelStateDialog.p0("close");
        treasureWheelStateDialog.getParentFragmentManager().F1("treasure_wheel_result_dismissed", new Bundle());
        treasureWheelStateDialog.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(TreasureWheelStateDialog treasureWheelStateDialog, View view) {
        LotteryUserActivityInfoPriceBean price;
        String str = null;
        Navigator.x(TheRouter.c("/rewards/center").K("source", "TreasureWheelStateDialog"), (Context) null, (mf.c) null, 3, (Object) null);
        LotteryDrawResultEntity.LotteryResultBean lotteryResultBean = treasureWheelStateDialog.target;
        if (lotteryResultBean != null && (price = lotteryResultBean.getPrice()) != null) {
            str = price.getPriceType();
        }
        if (Intrinsics.c(str, "THANK_YOU")) {
            treasureWheelStateDialog.p0("view_more_prizes");
        } else {
            treasureWheelStateDialog.p0("claim_now");
        }
        treasureWheelStateDialog.dismissAllowingStateLoss();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R.style.BaseDialogStyle);
    }

    @Override // com.transsion.baseui.dialog.BaseDialog
    public void onResume() {
        super.onResume();
        q0();
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Window window;
        Intrinsics.h(view, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(view, savedInstanceState);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(-1, -2);
        }
        com.transsion.commercialization.pslink.f.a.f();
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            dialog2.setCancelable(false);
        }
        this.bind = sj.g.a(view);
        r0();
    }

    public final TreasureWheelStateDialog u0(LotteryDrawResultEntity.LotteryResultBean target) {
        this.target = target;
        return this;
    }
}
