package com.transsnet.downloader.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentManager;
import com.noober.background.view.BLTextView;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsnet.downloader.R;
import com.transsnet.downloader.R$style;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 92\u00020\u0001:\u0001:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\f\u001a\u00020\u00062\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0015\u001a\u00020\u00142\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ0\u0010!\u001a\u00020\u00062!\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00060\u001b¢\u0006\u0004\b!\u0010\"J!\u0010&\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0006H\u0016¢\u0006\u0004\b(\u0010\u0003R \u0010,\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R3\u00100\u001a\u001f\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107¨\u0006;"}, d2 = {"Lcom/transsnet/downloader/dialog/LocalFileErrorDialog;", "Lcom/transsion/baseui/dialog/BaseDialog;", "<init>", "()V", "Landroid/view/View;", "view", HttpUrl.FRAGMENT_ENCODE_SET, "q0", "(Landroid/view/View;)V", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "map", "u0", "(Ljava/util/Map;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "Lkotlin/Function1;", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/ParameterName;", "name", "type", "call", "v0", "(Lkotlin/jvm/functions/Function1;)V", "Landroidx/fragment/app/FragmentManager;", "manager", "tag", "show", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V", "onDestroyView", "Lkotlin/Function0;", "c", "Lkotlin/jvm/functions/Function0;", "dismissListener", "ok", "d", "Lkotlin/jvm/functions/Function1;", "callback", "Lbx/m;", "e", "Lbx/m;", "viewBinding", HttpUrl.FRAGMENT_ENCODE_SET, "f", "Z", "isReport", "g", "a", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class LocalFileErrorDialog extends BaseDialog {

    /* renamed from: c, reason: from kotlin metadata */
    private Function0 dismissListener;

    /* renamed from: d, reason: from kotlin metadata */
    private Function1 callback;

    /* renamed from: e, reason: from kotlin metadata */
    private bx.m viewBinding;

    /* renamed from: f, reason: from kotlin metadata */
    private boolean isReport;

    public LocalFileErrorDialog() {
        super(R.layout.dialog_local_file_error);
    }

    private final void q0(View view) {
        AppCompatImageView appCompatImageView;
        BLTextView bLTextView;
        View view2;
        bx.m a = bx.m.a(view);
        this.viewBinding = a;
        if (a != null && (view2 = a.c) != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.dialog.d0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    LocalFileErrorDialog.r0(LocalFileErrorDialog.this, view3);
                }
            });
        }
        bx.m mVar = this.viewBinding;
        if (mVar != null && (bLTextView = mVar.b) != null) {
            bLTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.dialog.e0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    LocalFileErrorDialog.s0(LocalFileErrorDialog.this, view3);
                }
            });
        }
        bx.m mVar2 = this.viewBinding;
        if (mVar2 == null || (appCompatImageView = mVar2.d) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.dialog.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                LocalFileErrorDialog.t0(LocalFileErrorDialog.this, view3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(LocalFileErrorDialog localFileErrorDialog, View view) {
        Function1 function1 = localFileErrorDialog.callback;
        if (function1 != null) {
            function1.invoke(1);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("type", "download");
        localFileErrorDialog.u0(hashMap);
        localFileErrorDialog.isReport = true;
        localFileErrorDialog.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(LocalFileErrorDialog localFileErrorDialog, View view) {
        Function1 function1 = localFileErrorDialog.callback;
        if (function1 != null) {
            function1.invoke(2);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("type", "delete");
        localFileErrorDialog.u0(hashMap);
        localFileErrorDialog.isReport = true;
        localFileErrorDialog.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(LocalFileErrorDialog localFileErrorDialog, View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", MRAIDPresenter.CLOSE);
        localFileErrorDialog.u0(hashMap);
        localFileErrorDialog.isReport = true;
        localFileErrorDialog.dismissAllowingStateLoss();
    }

    private final void u0(Map map) {
        if (this.isReport) {
            return;
        }
        qi.h.a.o("local_file_do_not_exist", map);
    }

    public void onCreate(Bundle savedInstanceState) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(savedInstanceState);
        setStyle(0, R$style.center_DialogStyle);
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        androidx.appcompat.app.w wVar = new androidx.appcompat.app.w(requireContext, getTheme());
        Window window = wVar.getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setDimAmount(0.5f);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes == null) {
                attributes = new WindowManager.LayoutParams();
            }
            attributes.width = com.transsion.baseui.util.a.a.b(requireContext);
            window.setBackgroundDrawable(null);
            window.setAttributes(attributes);
        }
        wVar.setCancelable(false);
        wVar.setCanceledOnTouchOutside(false);
        return wVar;
    }

    public void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        HashMap hashMap = new HashMap();
        hashMap.put("type", "others");
        u0(hashMap);
        this.isReport = false;
    }

    public void onDismiss(DialogInterface dialog) {
        Intrinsics.h(dialog, "dialog");
        super.onDismiss(dialog);
        Function0 function0 = this.dismissListener;
        if (function0 != null) {
        }
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(view, savedInstanceState);
        q0(view);
    }

    public void show(FragmentManager manager, String tag) {
        Intrinsics.h(manager, "manager");
        super.show(manager, tag);
        qi.h.a.z("local_file_do_not_exist", new HashMap());
    }

    public final void v0(Function1 call) {
        Intrinsics.h(call, "call");
        this.callback = call;
    }
}
