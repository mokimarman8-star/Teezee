package com.transsion.member.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.c0;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import com.blankj.utilcode.util.KeyboardUtils;
import com.tn.lib.widget.R;
import com.transsion.baseui.R$style;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.gslb.BuildConfig;
import com.transsion.member.R$layout;
import com.transsion.member.R$string;
import com.transsion.member.i0;
import com.transsion.member.y;
import fh.b;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0003J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0018\u001a\u00020\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dR\u001e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u001b\u0010*\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lcom/transsion/member/dialog/MemberPromoCodeDialog;", "Lcom/transsion/baseui/dialog/BaseDialog;", "<init>", "()V", BuildConfig.FLAVOR, "initView", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "Lkotlin/Function0;", "callBack", "z0", "(Lkotlin/jvm/functions/Function0;)V", BuildConfig.FLAVOR, "msg", "A0", "(Ljava/lang/String;)V", "c", "Lkotlin/jvm/functions/Function0;", "callback", "Lgm/h;", "d", "Lgm/h;", "bind", "Lcom/transsion/member/y;", "e", "Lkotlin/Lazy;", "t0", "()Lcom/transsion/member/y;", "promoCodeViewModel", "f", "a", "Member_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class MemberPromoCodeDialog extends BaseDialog {

    /* renamed from: f, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int g = 8;

    /* renamed from: c, reason: from kotlin metadata */
    private Function0 callback;

    /* renamed from: d, reason: from kotlin metadata */
    private gm.h bind;

    /* renamed from: e, reason: from kotlin metadata */
    private final Lazy promoCodeViewModel;

    /* renamed from: com.transsion.member.dialog.MemberPromoCodeDialog$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MemberPromoCodeDialog a(Function0 function0) {
            Intrinsics.h(function0, "callBack");
            MemberPromoCodeDialog memberPromoCodeDialog = new MemberPromoCodeDialog();
            memberPromoCodeDialog.z0(function0);
            return memberPromoCodeDialog;
        }
    }

    public static final class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AppCompatEditText appCompatEditText;
            AppCompatEditText appCompatEditText2;
            Intrinsics.h(editable, "s");
            String obj = editable.toString();
            if (Intrinsics.c(editable.toString(), obj)) {
                return;
            }
            gm.h hVar = MemberPromoCodeDialog.this.bind;
            if (hVar != null && (appCompatEditText2 = hVar.f) != null) {
                appCompatEditText2.setText(obj);
            }
            gm.h hVar2 = MemberPromoCodeDialog.this.bind;
            if (hVar2 == null || (appCompatEditText = hVar2.f) == null) {
                return;
            }
            appCompatEditText.setSelection(obj.length());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Intrinsics.h(charSequence, "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ImageView imageView;
            AppCompatEditText appCompatEditText;
            Editable text;
            ImageView imageView2;
            Intrinsics.h(charSequence, "s");
            MemberPromoCodeDialog.this.A0(BuildConfig.FLAVOR);
            gm.h hVar = MemberPromoCodeDialog.this.bind;
            if (hVar == null || (appCompatEditText = hVar.f) == null || (text = appCompatEditText.getText()) == null || text.length() == 0) {
                gm.h hVar2 = MemberPromoCodeDialog.this.bind;
                if (hVar2 == null || (imageView = hVar2.c) == null) {
                    return;
                }
                uf.c.g(imageView);
                return;
            }
            gm.h hVar3 = MemberPromoCodeDialog.this.bind;
            if (hVar3 == null || (imageView2 = hVar3.c) == null) {
                return;
            }
            uf.c.k(imageView2);
        }
    }

    static final class c implements c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        c(Function1 function1) {
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

    public MemberPromoCodeDialog() {
        super(R$layout.dialog_member_promo_code_layout);
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.member.dialog.MemberPromoCodeDialog$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Fragment m26invoke() {
                return this;
            }
        };
        this.promoCodeViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(y.class), new Function0<x0>() { // from class: com.transsion.member.dialog.MemberPromoCodeDialog$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final x0 m27invoke() {
                x0 viewModelStore = ((y0) function0.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.member.dialog.MemberPromoCodeDialog$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final v0.c m28invoke() {
                Object invoke = function0.invoke();
                androidx.lifecycle.m mVar = invoke instanceof androidx.lifecycle.m ? (androidx.lifecycle.m) invoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                }
                Intrinsics.g(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    private final void initView() {
        TextView textView;
        ImageView imageView;
        ImageView imageView2;
        AppCompatEditText appCompatEditText;
        gm.h hVar = this.bind;
        if (hVar != null && (appCompatEditText = hVar.f) != null) {
            appCompatEditText.addTextChangedListener(new b());
        }
        gm.h hVar2 = this.bind;
        if (hVar2 != null && (imageView2 = hVar2.b) != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.dialog.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MemberPromoCodeDialog.u0(MemberPromoCodeDialog.this, view);
                }
            });
        }
        gm.h hVar3 = this.bind;
        if (hVar3 != null && (imageView = hVar3.c) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.dialog.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MemberPromoCodeDialog.v0(MemberPromoCodeDialog.this, view);
                }
            });
        }
        gm.h hVar4 = this.bind;
        if (hVar4 != null && (textView = hVar4.d) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.dialog.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MemberPromoCodeDialog.w0(MemberPromoCodeDialog.this, view);
                }
            });
        }
        t0().e().j(getViewLifecycleOwner(), new c(new Function1() { // from class: com.transsion.member.dialog.n
            public final Object invoke(Object obj) {
                Unit x0;
                x0 = MemberPromoCodeDialog.x0(MemberPromoCodeDialog.this, (i0) obj);
                return x0;
            }
        }));
    }

    private final y t0() {
        return (y) this.promoCodeViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(MemberPromoCodeDialog memberPromoCodeDialog, View view) {
        memberPromoCodeDialog.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(MemberPromoCodeDialog memberPromoCodeDialog, View view) {
        AppCompatEditText appCompatEditText;
        gm.h hVar = memberPromoCodeDialog.bind;
        if (hVar == null || (appCompatEditText = hVar.f) == null) {
            return;
        }
        appCompatEditText.setText(BuildConfig.FLAVOR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(MemberPromoCodeDialog memberPromoCodeDialog, View view) {
        String str;
        TextView textView;
        AppCompatEditText appCompatEditText;
        Editable text;
        String obj;
        gm.h hVar = memberPromoCodeDialog.bind;
        if (hVar == null || (appCompatEditText = hVar.f) == null || (text = appCompatEditText.getText()) == null || (obj = text.toString()) == null || (str = StringsKt.n1(obj).toString()) == null) {
            str = BuildConfig.FLAVOR;
        }
        if (str.length() == 0) {
            String string = memberPromoCodeDialog.getString(R$string.member_promo_code_empty_tips);
            Intrinsics.g(string, "getString(...)");
            memberPromoCodeDialog.A0(string);
        } else {
            gm.h hVar2 = memberPromoCodeDialog.bind;
            if (hVar2 != null && (textView = hVar2.d) != null) {
                textView.setEnabled(false);
            }
            memberPromoCodeDialog.t0().h(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x0(MemberPromoCodeDialog memberPromoCodeDialog, i0 i0Var) {
        TextView textView;
        if (!i0Var.c()) {
            if (Intrinsics.c(i0Var.a(), "400")) {
                String string = memberPromoCodeDialog.getString(R$string.member_promo_code_error_tips);
                Intrinsics.g(string, "getString(...)");
                memberPromoCodeDialog.A0(string);
            } else {
                com.tn.lib.widget.toast.core.h.a.k(R.string.error_load_failed);
            }
            gm.h hVar = memberPromoCodeDialog.bind;
            if (hVar != null && (textView = hVar.d) != null) {
                textView.setEnabled(true);
            }
        } else if (i0Var.b() == null) {
            String string2 = memberPromoCodeDialog.getString(R$string.member_promo_code_error_tips);
            Intrinsics.g(string2, "getString(...)");
            memberPromoCodeDialog.A0(string2);
        } else {
            Context context = memberPromoCodeDialog.getContext();
            if (context != null) {
                if (i0Var.b().getVipDurationDays() > 0) {
                    b.a aVar = fh.b.a;
                    int i = R$layout.claim_succeed_layout;
                    String string3 = context.getString(R$string.member_claimed_succeed_days, Integer.valueOf(i0Var.b().getVipDurationDays()));
                    Intrinsics.g(string3, "getString(...)");
                    b.a.h(aVar, i, string3, 17, 0, 0, 8, (Object) null);
                } else {
                    com.tn.lib.widget.toast.core.h.a.k(R$string.member_enjoy_your_benefits_now);
                }
            }
            memberPromoCodeDialog.dismissAllowingStateLoss();
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(AppCompatEditText appCompatEditText) {
        appCompatEditText.requestFocus();
        KeyboardUtils.i(appCompatEditText);
    }

    public final void A0(String msg) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        Intrinsics.h(msg, "msg");
        if (msg.length() <= 0) {
            gm.h hVar = this.bind;
            if (hVar == null || (textView = hVar.e) == null) {
                return;
            }
            uf.c.h(textView);
            return;
        }
        gm.h hVar2 = this.bind;
        if (hVar2 != null && (textView3 = hVar2.e) != null) {
            textView3.setText(msg);
        }
        gm.h hVar3 = this.bind;
        if (hVar3 == null || (textView2 = hVar3.e) == null) {
            return;
        }
        uf.c.k(textView2);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R$style.BottomInputDialogTheme);
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        com.google.android.material.bottomsheet.c cVar = new com.google.android.material.bottomsheet.c(requireContext(), getTheme());
        Window window = cVar.getWindow();
        if (window != null) {
            window.setGravity(80);
        }
        cVar.k().U0(3);
        cVar.k().T0(true);
        return cVar;
    }

    @Override // com.transsion.baseui.dialog.BaseDialog
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.h(dialog, "dialog");
        super.onDismiss(dialog);
        Function0 function0 = this.callback;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.transsion.baseui.dialog.BaseDialog
    public void onStart() {
        final AppCompatEditText appCompatEditText;
        super.onStart();
        gm.h hVar = this.bind;
        if (hVar == null || (appCompatEditText = hVar.f) == null) {
            return;
        }
        appCompatEditText.postDelayed(new Runnable() { // from class: com.transsion.member.dialog.j
            @Override // java.lang.Runnable
            public final void run() {
                MemberPromoCodeDialog.y0(appCompatEditText);
            }
        }, 200L);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(view, savedInstanceState);
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCancelable(true);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            dialog2.setCanceledOnTouchOutside(false);
        }
        this.bind = gm.h.a(view);
        initView();
    }

    public final void z0(Function0 callBack) {
        Intrinsics.h(callBack, "callBack");
        this.callback = callBack;
    }
}
