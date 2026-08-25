package com.transsnet.downloader.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import com.therouter.TheRouter;
import com.transsion.baselib.report.k;
import com.transsion.baseui.activity.BaseActivity;
import com.transsnet.downloader.R;
import com.transsnet.downloader.fragment.DownloadMainFragment;
import com.transsnet.downloader.manager.DownloadStatusIconManager;
import com.transsnet.downloader.viewmodel.DownloadViewModel;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import ij.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.HttpUrl;
import qi.h;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000e\u0010\tJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0013J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0019\u0010\u0004J\u0019\u0010\u001c\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001f\u0010 R \u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070#0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010+\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b*\u0010 ¨\u0006.²\u0006\f\u0010-\u001a\u00020,8\nX\u008a\u0084\u0002"}, d2 = {"Lcom/transsnet/downloader/activity/DownloadPanelActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Lbx/b;", "<init>", "()V", "Landroid/content/Intent;", "intent", HttpUrl.FRAGMENT_ENCODE_SET, "b0", "(Landroid/content/Intent;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onNewIntent", "c0", "()Lbx/b;", HttpUrl.FRAGMENT_ENCODE_SET, "isTranslucent", "()Z", "isChangeStatusBar", "isStatusDark", HttpUrl.FRAGMENT_ENCODE_SET, "statusColor", "()I", "onDestroy", "Landroid/view/MotionEvent;", "event", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", HttpUrl.FRAGMENT_ENCODE_SET, "a", "Ljava/lang/String;", "PAGE_NAME", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/Function0;", "b", "Ljava/util/List;", "touchListeners", "c", "I", "index", "d", "focusResourceId", "Lcom/transsnet/downloader/viewmodel/DownloadViewModel;", "downloadViewModel", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class DownloadPanelActivity extends BaseActivity<bx.b> {

    /* renamed from: a, reason: from kotlin metadata */
    private final String PAGE_NAME = "download_panel_activity";

    /* renamed from: b, reason: from kotlin metadata */
    private final List touchListeners = new ArrayList();

    /* renamed from: c, reason: from kotlin metadata */
    public int index;

    /* renamed from: d, reason: from kotlin metadata */
    public String focusResourceId;

    private final void b0(Intent intent) {
        int intExtra = intent.getIntExtra("from_page", 0);
        int intExtra2 = intent.getIntExtra("download_status", 0);
        if (intExtra > 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("from_page", String.valueOf(intExtra));
            hashMap.put("download_status", String.valueOf(intExtra2));
            h.a.o(this.PAGE_NAME, hashMap);
        }
    }

    private static final DownloadViewModel d0(Lazy lazy) {
        return (DownloadViewModel) lazy.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public bx.b getViewBinding() {
        bx.b c = bx.b.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event != null && event.getAction() == 0) {
            Iterator it = this.touchListeners.iterator();
            while (it.hasNext()) {
                ((Function0) it.next()).invoke();
            }
        }
        return super.dispatchTouchEvent(event);
    }

    public boolean isChangeStatusBar() {
        return false;
    }

    public boolean isStatusDark() {
        return !y.a.a();
    }

    public boolean isTranslucent() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        TheRouter.l(this);
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            final Function0 function0 = null;
            d0(new ViewModelLazy(Reflection.b(DownloadViewModel.class), new Function0<x0>() { // from class: com.transsnet.downloader.activity.DownloadPanelActivity$onCreate$$inlined$viewModels$default$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final x0 invoke() {
                    return this.getViewModelStore();
                }
            }, new Function0<v0.c>() { // from class: com.transsnet.downloader.activity.DownloadPanelActivity$onCreate$$inlined$viewModels$default$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final v0.c invoke() {
                    return this.getDefaultViewModelProviderFactory();
                }
            }, new Function0<p1.a>() { // from class: com.transsnet.downloader.activity.DownloadPanelActivity$onCreate$$inlined$viewModels$default$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final p1.a invoke() {
                    p1.a aVar;
                    Function0 function02 = Function0.this;
                    return (function02 == null || (aVar = (p1.a) function02.invoke()) == null) ? this.getDefaultViewModelCreationExtras() : aVar;
                }
            })).R().q(this.focusResourceId);
            getSupportFragmentManager().p().s(R.id.container, DownloadMainFragment.INSTANCE.a(this.index)).k();
        }
        DownloadStatusIconManager.h.a().w(true);
        k.a.w(1, this);
    }

    protected void onDestroy() {
        super.onDestroy();
        this.touchListeners.clear();
    }

    protected void onNewIntent(Intent intent) {
        Intrinsics.h(intent, "intent");
        super/*androidx.activity.ComponentActivity*/.onNewIntent(intent);
        b0(intent);
    }

    public int statusColor() {
        return com.tn.lib.widget.R.color.text_01;
    }
}
