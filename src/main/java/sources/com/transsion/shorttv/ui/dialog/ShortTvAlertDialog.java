package com.transsion.shorttv.ui.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.transsion.shorttv.base.dialog.BaseViewBindingDialog;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.HttpUrl;
import qr.r;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R.\u0010\u001d\u001a\u001c\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/transsion/shorttv/ui/dialog/ShortTvAlertDialog;", "Lcom/transsion/shorttv/base/dialog/BaseViewBindingDialog;", "Lqr/r;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", HttpUrl.FRAGMENT_ENCODE_SET, "onCreate", "(Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lkotlin/Function0;", "c", "Lkotlin/jvm/functions/Function0;", "primaryAction", "d", "secondaryAction", "Lkotlin/Function3;", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", HttpUrl.FRAGMENT_ENCODE_SET, "l0", "()Lkotlin/jvm/functions/Function3;", "bindingInflater", "e", "a", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class ShortTvAlertDialog extends BaseViewBindingDialog<r> {

    /* renamed from: e, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: from kotlin metadata */
    private Function0 primaryAction;

    /* renamed from: d, reason: from kotlin metadata */
    private Function0 secondaryAction;

    /* renamed from: com.transsion.shorttv.ui.dialog.ShortTvAlertDialog$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ShortTvAlertDialog a(String title, String message, String primaryBtnText, Function0 function0, String str, Function0 function02) {
            Intrinsics.h(title, "title");
            Intrinsics.h(message, "message");
            Intrinsics.h(primaryBtnText, "primaryBtnText");
            ShortTvAlertDialog shortTvAlertDialog = new ShortTvAlertDialog();
            Bundle bundle = new Bundle();
            bundle.putString("title", title);
            bundle.putString("message", message);
            bundle.putString("primary_btn_text", primaryBtnText);
            if (str != null && str.length() != 0) {
                bundle.putString("secondary_btn_text", str);
            }
            shortTvAlertDialog.setArguments(bundle);
            shortTvAlertDialog.primaryAction = function0;
            shortTvAlertDialog.secondaryAction = function02;
            return shortTvAlertDialog;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(ShortTvAlertDialog shortTvAlertDialog, View view) {
        shortTvAlertDialog.dismissAllowingStateLoss();
        Function0 function0 = shortTvAlertDialog.primaryAction;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(ShortTvAlertDialog shortTvAlertDialog, View view) {
        shortTvAlertDialog.dismissAllowingStateLoss();
        Function0 function0 = shortTvAlertDialog.secondaryAction;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public Function3 l0() {
        return ShortTvAlertDialog$bindingInflater$1.INSTANCE;
    }

    public void onCreate(Bundle savedInstanceState) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(savedInstanceState);
        setStyle(1, 0);
        setCancelable(false);
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog onCreateDialog = super/*androidx.fragment.app.DialogFragment*/.onCreateDialog(savedInstanceState);
        Intrinsics.g(onCreateDialog, "onCreateDialog(...)");
        Window window = onCreateDialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.addFlags(2);
            window.setDimAmount(0.5f);
            window.setGravity(17);
        }
        return onCreateDialog;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Bundle arguments;
        Intrinsics.h(view, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(view, savedInstanceState);
        r m0 = m0();
        if (m0 == null || (arguments = getArguments()) == null) {
            return;
        }
        m0.e.setText(arguments.getString("title", HttpUrl.FRAGMENT_ENCODE_SET));
        m0.d.setText(arguments.getString("message", HttpUrl.FRAGMENT_ENCODE_SET));
        m0.b.setText(arguments.getString("primary_btn_text", HttpUrl.FRAGMENT_ENCODE_SET));
        m0.b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.shorttv.ui.dialog.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ShortTvAlertDialog.r0(ShortTvAlertDialog.this, view2);
            }
        });
        String string = arguments.getString("secondary_btn_text");
        if (string == null || string.length() == 0) {
            return;
        }
        m0.c.setVisibility(0);
        m0.c.setText(string);
        m0.c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.shorttv.ui.dialog.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ShortTvAlertDialog.s0(ShortTvAlertDialog.this, view2);
            }
        });
    }
}
