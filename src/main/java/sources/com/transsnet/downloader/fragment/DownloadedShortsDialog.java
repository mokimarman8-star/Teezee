package com.transsnet.downloader.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsnet.downloader.R;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0003R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/transsnet/downloader/fragment/DownloadedShortsDialog;", "Lcom/transsion/baseui/dialog/BaseDialog;", "<init>", "()V", HttpUrl.FRAGMENT_ENCODE_SET, "r0", HttpUrl.FRAGMENT_ENCODE_SET, "b0", "()Z", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "onResume", "onPause", "Landroid/os/Handler;", "c", "Landroid/os/Handler;", "handler", "Ljava/lang/Runnable;", "d", "Ljava/lang/Runnable;", "dismissRunnable", "e", "a", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class DownloadedShortsDialog extends BaseDialog {

    /* renamed from: e, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: from kotlin metadata */
    private final Handler handler;

    /* renamed from: d, reason: from kotlin metadata */
    private final Runnable dismissRunnable;

    /* renamed from: com.transsnet.downloader.fragment.DownloadedShortsDialog$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadedShortsDialog a(String str) {
            DownloadedShortsDialog downloadedShortsDialog = new DownloadedShortsDialog();
            downloadedShortsDialog.setArguments(androidx.core.os.d.b(new Pair[]{TuplesKt.a("extra_target_resource_id", str)}));
            return downloadedShortsDialog;
        }
    }

    public DownloadedShortsDialog() {
        super(R.layout.dialog_download_shorts_downloaded);
        this.handler = new Handler(Looper.getMainLooper());
        this.dismissRunnable = new Runnable() { // from class: com.transsnet.downloader.fragment.k5
            @Override // java.lang.Runnable
            public final void run() {
                DownloadedShortsDialog.p0(DownloadedShortsDialog.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(DownloadedShortsDialog downloadedShortsDialog) {
        try {
            if (downloadedShortsDialog.isAdded() && downloadedShortsDialog.isResumed()) {
                downloadedShortsDialog.dismissAllowingStateLoss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(DownloadedShortsDialog downloadedShortsDialog, View view) {
        downloadedShortsDialog.r0();
        Bundle arguments = downloadedShortsDialog.getArguments();
        Navigator.x(TheRouter.c("/download/panel_activity").F("extra_page_index", 0).K("extra_target_resource_id", arguments != null ? arguments.getString("extra_target_resource_id") : null), downloadedShortsDialog.getContext(), (mf.c) null, 2, (Object) null);
        downloadedShortsDialog.dismissAllowingStateLoss();
    }

    private final void r0() {
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_name", "short_download_view");
        hashMap.put("module_name", "view");
        qi.h.a.o(HttpUrl.FRAGMENT_ENCODE_SET, hashMap);
    }

    public boolean b0() {
        return true;
    }

    public void onPause() {
        super.onPause();
        this.handler.removeCallbacks(this.dismissRunnable);
    }

    public void onResume() {
        super.onResume();
        this.handler.removeCallbacks(this.dismissRunnable);
        this.handler.postDelayed(this.dismissRunnable, 5000L);
    }

    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.clearFlags(2);
        window.addFlags(8);
        window.addFlags(32);
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 49;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Object systemService = requireContext().getSystemService("window");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
        attributes.width = com.blankj.utilcode.util.a0.a(336.0f);
        attributes.height = -2;
        boolean z = getResources().getConfiguration().orientation == 2;
        zg.h hVar = zg.h.a;
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        attributes.y = hVar.a(requireContext, z ? 24.0f : 10.0f);
        window.setAttributes(attributes);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(view, savedInstanceState);
        TextView textView = (TextView) view.findViewById(R.id.btn_view);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.l5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DownloadedShortsDialog.q0(DownloadedShortsDialog.this, view2);
                }
            });
        }
    }
}
