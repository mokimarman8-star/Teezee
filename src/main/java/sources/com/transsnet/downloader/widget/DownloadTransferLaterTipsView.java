package com.transsnet.downloader.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import bx.a1;
import com.noober.background.drawable.DrawableCreator;
import com.noober.background.view.BLFrameLayout;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsnet.downloader.R;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u0015B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u000eJ\u001b\u0010\u0012\u001a\u00020\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0010¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/transsnet/downloader/widget/DownloadTransferLaterTipsView;", "Lcom/noober/background/view/BLFrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", HttpUrl.FRAGMENT_ENCODE_SET, "res", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", HttpUrl.FRAGMENT_ENCODE_SET, "d", "()V", "startCountdown", "Lkotlin/Function0;", "callback", "setCloseCallback", "(Lkotlin/jvm/functions/Function0;)V", "Lbx/a1;", "a", "Lbx/a1;", "viewBinding", "b", "Lkotlin/jvm/functions/Function0;", "closeCallback", "Companion", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class DownloadTransferLaterTipsView extends BLFrameLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private final a1 viewBinding;

    /* renamed from: b, reason: from kotlin metadata */
    private Function0 closeCallback;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadTransferLaterTipsView(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadTransferLaterTipsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DownloadTransferLaterTipsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        View.inflate(context, R.layout.layout_download_transfer_later_tips, this);
        a1 a = a1.a(this);
        Intrinsics.g(a, "bind(...)");
        this.viewBinding = a;
        d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void d() {
        setBackground(new DrawableCreator.Builder().setCornersRadius(com.blankj.utilcode.util.a0.a(8.0f)).setSolidColor(getContext().getResources().getColor(com.tn.lib.widget.R.color.module_dark_80)).build());
        this.viewBinding.b.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.widget.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadTransferLaterTipsView.e(DownloadTransferLaterTipsView.this, view);
            }
        });
        this.viewBinding.c.setMax(15);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void e(DownloadTransferLaterTipsView downloadTransferLaterTipsView, View view) {
        Function0 function0 = downloadTransferLaterTipsView.closeCallback;
        if (function0 != null) {
            function0.invoke();
        }
        downloadTransferLaterTipsView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(DownloadTransferLaterTipsView downloadTransferLaterTipsView, int i) {
        downloadTransferLaterTipsView.viewBinding.c.setProgress(i);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit g(DownloadTransferLaterTipsView downloadTransferLaterTipsView) {
        downloadTransferLaterTipsView.viewBinding.c.setProgress(15);
        downloadTransferLaterTipsView.setVisibility(8);
        Function0 function0 = downloadTransferLaterTipsView.closeCallback;
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.a;
    }

    public final void setCloseCallback(Function0<Unit> callback) {
        Intrinsics.h(callback, "callback");
        this.closeCallback = callback;
    }

    public final void startCountdown() {
        TimeUtilKt.b(15, kotlinx.coroutines.o0.a(kotlinx.coroutines.y0.c()), new Function1() { // from class: com.transsnet.downloader.widget.w
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit f;
                f = DownloadTransferLaterTipsView.f(DownloadTransferLaterTipsView.this, ((Integer) obj).intValue());
                return f;
            }
        }, new Function0() { // from class: com.transsnet.downloader.widget.x
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit g;
                g = DownloadTransferLaterTipsView.g(DownloadTransferLaterTipsView.this);
                return g;
            }
        });
    }
}
