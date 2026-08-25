package com.transsion.search.dialog;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.gslb.BuildConfig;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.R$style;
import com.transsion.search.dialog.CheckTipsDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import wp.a;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0017¨\u0006\u001f"}, d2 = {"Lcom/transsion/search/dialog/CheckTipsDialog;", "Lcom/transsion/baseui/dialog/BaseDialog;", "<init>", "()V", "Landroid/view/View;", "view", BuildConfig.FLAVOR, "p0", "(Landroid/view/View;)V", "Lwp/a;", "listener", "s0", "(Lwp/a;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "c", "Lwp/a;", BuildConfig.FLAVOR, "d", "Ljava/lang/String;", "title", "e", "btnLeft", "f", "btnRight", "g", "a", "Search_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class CheckTipsDialog extends BaseDialog {

    /* renamed from: g, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: from kotlin metadata */
    private a listener;

    /* renamed from: d, reason: from kotlin metadata */
    private String title;

    /* renamed from: e, reason: from kotlin metadata */
    private String btnLeft;

    /* renamed from: f, reason: from kotlin metadata */
    private String btnRight;

    /* renamed from: com.transsion.search.dialog.CheckTipsDialog$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CheckTipsDialog a() {
            return new CheckTipsDialog();
        }
    }

    public CheckTipsDialog() {
        super(R$layout.dialog_check);
        this.title = BuildConfig.FLAVOR;
        this.btnLeft = BuildConfig.FLAVOR;
        this.btnRight = BuildConfig.FLAVOR;
    }

    private final void p0(View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        View findViewById = view.findViewById(R$id.btn_left);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: wp.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CheckTipsDialog.q0(CheckTipsDialog.this, view2);
                }
            });
        }
        View findViewById2 = view.findViewById(R$id.btn_yes);
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(new View.OnClickListener() { // from class: wp.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CheckTipsDialog.r0(CheckTipsDialog.this, view2);
                }
            });
        }
        if (!TextUtils.isEmpty(this.title) && (textView3 = (TextView) view.findViewById(R$id.tv_tips)) != null) {
            textView3.setText(this.title);
        }
        if (!TextUtils.isEmpty(this.btnLeft) && (textView2 = (TextView) view.findViewById(R$id.btn_yes)) != null) {
            textView2.setText(this.btnLeft);
        }
        if (TextUtils.isEmpty(this.btnRight) || (textView = (TextView) view.findViewById(R$id.btn_left)) == null) {
            return;
        }
        textView.setText(this.btnRight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(CheckTipsDialog checkTipsDialog, View view) {
        a aVar = checkTipsDialog.listener;
        if (aVar != null) {
            aVar.a();
        }
        checkTipsDialog.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(CheckTipsDialog checkTipsDialog, View view) {
        a aVar = checkTipsDialog.listener;
        if (aVar != null) {
            aVar.b();
        }
        checkTipsDialog.dismissAllowingStateLoss();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R$style.BaseDialogStyle);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(view, savedInstanceState);
        p0(view);
    }

    public final void s0(a listener) {
        Intrinsics.h(listener, "listener");
        this.listener = listener;
    }
}
