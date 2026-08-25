package com.transsion.moviedetail.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.noober.background.view.BLTextView;
import com.tn.lib.view.MaxHeightNestedScrollView;
import com.transsion.baseui.R$style;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetail.R$layout;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 +2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0003J!\u0010\u0018\u001a\u00020\u00062\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00060\u0015¢\u0006\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\u001fR$\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lcom/transsion/moviedetail/fragment/RestrictTipsDialog;", "Lcom/transsion/baseui/dialog/BaseDialog;", "<init>", "()V", "Landroid/view/View;", "view", BuildConfig.FLAVOR, "r0", "(Landroid/view/View;)V", "x0", BuildConfig.FLAVOR, "optType", "w0", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroy", "Lkotlin/Function1;", BuildConfig.FLAVOR, "call", "y0", "(Lkotlin/jvm/functions/Function1;)V", "Llm/d;", "c", "Llm/d;", "viewBinding", "d", "Ljava/lang/String;", "tips", "e", "pageFrom", "f", "subjectId", "g", "Lkotlin/jvm/functions/Function1;", "resultCallback", "h", "Z", "isSelectNotShowAgain", "i", "a", "MovieDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class RestrictTipsDialog extends BaseDialog {

    /* renamed from: i, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: from kotlin metadata */
    private lm.d viewBinding;

    /* renamed from: d, reason: from kotlin metadata */
    private String tips;

    /* renamed from: e, reason: from kotlin metadata */
    private String pageFrom;

    /* renamed from: f, reason: from kotlin metadata */
    private String subjectId;

    /* renamed from: g, reason: from kotlin metadata */
    private Function1 resultCallback;

    /* renamed from: h, reason: from kotlin metadata */
    private boolean isSelectNotShowAgain;

    /* renamed from: com.transsion.moviedetail.fragment.RestrictTipsDialog$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RestrictTipsDialog a(String str, String str2, String str3) {
            Intrinsics.h(str, "tips");
            Intrinsics.h(str2, "pageFrom");
            RestrictTipsDialog restrictTipsDialog = new RestrictTipsDialog();
            restrictTipsDialog.setArguments(androidx.core.os.d.b(new Pair[]{TuplesKt.a("tips", str), TuplesKt.a("page_from", str2), TuplesKt.a("subject_id", str3)}));
            return restrictTipsDialog;
        }
    }

    public RestrictTipsDialog() {
        super(R$layout.dialog_restrict_tips);
    }

    private final void r0(View view) {
        LinearLayoutCompat linearLayoutCompat;
        BLTextView bLTextView;
        BLTextView bLTextView2;
        AppCompatTextView appCompatTextView;
        MaxHeightNestedScrollView maxHeightNestedScrollView;
        lm.d a = lm.d.a(view);
        this.viewBinding = a;
        if (a != null && (maxHeightNestedScrollView = a.d) != null) {
            maxHeightNestedScrollView.setMaxHeight(com.blankj.utilcode.util.a0.a(368.0f));
        }
        lm.d dVar = this.viewBinding;
        if (dVar != null && (appCompatTextView = dVar.g) != null) {
            appCompatTextView.setText(this.tips);
        }
        lm.d dVar2 = this.viewBinding;
        if (dVar2 != null && (bLTextView2 = dVar2.f) != null) {
            bLTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.e1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    RestrictTipsDialog.s0(RestrictTipsDialog.this, view2);
                }
            });
        }
        lm.d dVar3 = this.viewBinding;
        if (dVar3 != null && (bLTextView = dVar3.e) != null) {
            bLTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.f1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    RestrictTipsDialog.t0(RestrictTipsDialog.this, view2);
                }
            });
        }
        lm.d dVar4 = this.viewBinding;
        if (dVar4 == null || (linearLayoutCompat = dVar4.c) == null) {
            return;
        }
        linearLayoutCompat.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.g1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RestrictTipsDialog.u0(RestrictTipsDialog.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(RestrictTipsDialog restrictTipsDialog, View view) {
        restrictTipsDialog.w0("confirm");
        Function1 function1 = restrictTipsDialog.resultCallback;
        if (function1 != null) {
            function1.invoke(Boolean.TRUE);
        }
        restrictTipsDialog.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(RestrictTipsDialog restrictTipsDialog, View view) {
        restrictTipsDialog.w0("btn_back");
        restrictTipsDialog.isSelectNotShowAgain = false;
        Function1 function1 = restrictTipsDialog.resultCallback;
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
        restrictTipsDialog.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(RestrictTipsDialog restrictTipsDialog, View view) {
        ImageView imageView;
        lm.d dVar = restrictTipsDialog.viewBinding;
        if (dVar != null && (imageView = dVar.b) != null) {
            imageView.setSelected(!restrictTipsDialog.isSelectNotShowAgain);
        }
        restrictTipsDialog.isSelectNotShowAgain = !restrictTipsDialog.isSelectNotShowAgain;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean v0(RestrictTipsDialog restrictTipsDialog, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        restrictTipsDialog.w0("action_back");
        restrictTipsDialog.isSelectNotShowAgain = false;
        Function1 function1 = restrictTipsDialog.resultCallback;
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
        restrictTipsDialog.dismissAllowingStateLoss();
        return true;
    }

    private final void w0(String optType) {
        HashMap hashMap = new HashMap();
        hashMap.put("opt_type", optType);
        hashMap.put("not_show_select", String.valueOf(this.isSelectNotShowAgain));
        String str = this.subjectId;
        String str2 = BuildConfig.FLAVOR;
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        hashMap.put("subject_id", str);
        String str3 = this.pageFrom;
        if (str3 != null) {
            str2 = str3;
        }
        hashMap.put("page_from", str2);
        qi.h.a.o("restrict_tips_dialog", hashMap);
    }

    private final void x0() {
        HashMap hashMap = new HashMap();
        String str = this.pageFrom;
        String str2 = BuildConfig.FLAVOR;
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        hashMap.put("page_from", str);
        String str3 = this.subjectId;
        if (str3 != null) {
            str2 = str3;
        }
        hashMap.put("subject_id", str2);
        qi.h.a.q("restrict_tips_dialog", "dialog_show", hashMap);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
        setStyle(0, R$style.NormalDialogTheme);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.tips = arguments.getString("tips");
            this.pageFrom = arguments.getString("page_from");
            this.subjectId = arguments.getString("subject_id");
        }
    }

    @Override // com.transsion.baseui.dialog.BaseDialog
    public void onDestroy() {
        super.onDestroy();
        if (this.isSelectNotShowAgain) {
            com.transsion.baselib.report.launch.b.a.b().putBoolean("restrict_tips_dialog_again", false);
        }
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Window window;
        Intrinsics.h(view, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(view, savedInstanceState);
        int e = com.blankj.utilcode.util.y.e() - com.blankj.utilcode.util.a0.a(80.0f);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(e, -2);
            window.setGravity(17);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            dialog2.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.transsion.moviedetail.fragment.d1
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    boolean v0;
                    v0 = RestrictTipsDialog.v0(RestrictTipsDialog.this, dialogInterface, i, keyEvent);
                    return v0;
                }
            });
        }
        x0();
        r0(view);
    }

    public final void y0(Function1 call) {
        Intrinsics.h(call, "call");
        this.resultCallback = call;
    }
}
