package com.transsnet.downloader.dialog;

import android.os.Bundle;
import android.view.View;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsnet.downloader.R;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/transsnet/downloader/dialog/DownloadPermissionDialog;", "Lcom/transsion/baseui/dialog/BaseDialog;", "<init>", "()V", "Landroid/view/View;", "view", HttpUrl.FRAGMENT_ENCODE_SET, "p0", "(Landroid/view/View;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class DownloadPermissionDialog extends BaseDialog {
    public DownloadPermissionDialog() {
        super(R.layout.dialog_download_permission_tips);
    }

    private final void p0(View view) {
        bx.i a = bx.i.a(view);
        Intrinsics.g(a, "bind(...)");
        a.b.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.dialog.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DownloadPermissionDialog.q0(DownloadPermissionDialog.this, view2);
            }
        });
        a.d.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.dialog.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DownloadPermissionDialog.r0(DownloadPermissionDialog.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(DownloadPermissionDialog downloadPermissionDialog, View view) {
        downloadPermissionDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(DownloadPermissionDialog downloadPermissionDialog, View view) {
        com.transsnet.downloader.viewmodel.a0.a.x();
        downloadPermissionDialog.dismiss();
    }

    public void onCreate(Bundle savedInstanceState) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(savedInstanceState);
        setStyle(0, com.transsion.baseui.R.style.NormalDialogTheme);
        setCancelable(false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(view, savedInstanceState);
        p0(view);
    }
}
