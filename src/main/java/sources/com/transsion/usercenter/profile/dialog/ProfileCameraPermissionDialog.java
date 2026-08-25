package com.transsion.usercenter.profile.dialog;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.baseui.dialog.BaseViewBindingDialog;
import com.transsion.usercenter.R$style;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import xu.c0;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ!\u0010\r\u001a\u00020\u00072\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\n¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R.\u0010\u001c\u001a\u001c\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/transsion/usercenter/profile/dialog/ProfileCameraPermissionDialog;", "Lcom/transsion/baseui/dialog/BaseViewBindingDialog;", "Lxu/c0;", "<init>", "()V", "Landroid/view/View;", "view", HttpUrl.FRAGMENT_ENCODE_SET, "r0", "(Landroid/view/View;)V", "Lkotlin/Function1;", HttpUrl.FRAGMENT_ENCODE_SET, "callback", "u0", "(Lkotlin/jvm/functions/Function1;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "d", "Lkotlin/jvm/functions/Function1;", "Lkotlin/Function3;", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "n0", "()Lkotlin/jvm/functions/Function3;", "bindingInflater", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class ProfileCameraPermissionDialog extends BaseViewBindingDialog<c0> {

    /* renamed from: d, reason: from kotlin metadata */
    private Function1 callback;

    private final void r0(View view) {
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        c0 c0Var = (c0) o0();
        if (c0Var != null && (appCompatTextView2 = c0Var.b) != null) {
            appCompatTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.profile.dialog.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ProfileCameraPermissionDialog.s0(ProfileCameraPermissionDialog.this, view2);
                }
            });
        }
        c0 c0Var2 = (c0) o0();
        if (c0Var2 == null || (appCompatTextView = c0Var2.c) == null) {
            return;
        }
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.profile.dialog.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ProfileCameraPermissionDialog.t0(ProfileCameraPermissionDialog.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(ProfileCameraPermissionDialog profileCameraPermissionDialog, View view) {
        Function1 function1 = profileCameraPermissionDialog.callback;
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
        profileCameraPermissionDialog.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(ProfileCameraPermissionDialog profileCameraPermissionDialog, View view) {
        Function1 function1 = profileCameraPermissionDialog.callback;
        if (function1 != null) {
            function1.invoke(Boolean.TRUE);
        }
        profileCameraPermissionDialog.dismissAllowingStateLoss();
    }

    public Function3 n0() {
        return ProfileCameraPermissionDialog$bindingInflater$1.INSTANCE;
    }

    public void onCreate(Bundle savedInstanceState) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(savedInstanceState);
        setStyle(0, R$style.BaseDialogStyle);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(view, savedInstanceState);
        r0(view);
    }

    public final void u0(Function1 callback) {
        Intrinsics.h(callback, "callback");
        this.callback = callback;
    }
}
