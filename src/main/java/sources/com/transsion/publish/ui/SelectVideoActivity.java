package com.transsion.publish.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.PermissionUtils;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.gslb.BuildConfig;
import com.transsion.publish.R$id;
import com.transsion.publish.R$string;
import com.transsion.publish.api.VsMediaInfo;
import com.transsion.publish.bean.PreviewMediaConfirmEvent;
import com.transsion.publish.bean.PreviewVideoBean;
import com.transsion.publish.view.CustomHeader;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import wf.a;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\u0004J\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0013J\u0019\u0010\u0018\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00101\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010.R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0017\u0010<\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b9\u00107\u001a\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010C¨\u0006E"}, d2 = {"Lcom/transsion/publish/ui/SelectVideoActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Llo/k;", "<init>", "()V", BuildConfig.FLAVOR, "initData", "A0", "initView", "q0", "y0", "showLoading", "s0", BuildConfig.FLAVOR, "size", "p0", "(I)V", BuildConfig.FLAVOR, "isTranslucent", "()Z", "isStatusDark", "isChangeStatusBar", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "r0", "()Llo/k;", "onDestroy", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "Landroidx/recyclerview/widget/RecyclerView;", "a", "Landroidx/recyclerview/widget/RecyclerView;", "videoRecycler", "Lcom/transsion/publish/adapter/k0;", "b", "Lcom/transsion/publish/adapter/k0;", "videoAdapter", "Lno/c;", "c", "Lno/c;", "selectVideoManager", "Landroid/widget/LinearLayout;", "d", "Landroid/widget/LinearLayout;", "noContentView", "e", "lockView", "Landroid/widget/ProgressBar;", "f", "Landroid/widget/ProgressBar;", "selectVideoLoading", "g", "I", "maxLimit", "h", "getScreenWidth", "()I", "screenWidth", "Lio/reactivex/rxjava3/disposables/c;", "i", "Lio/reactivex/rxjava3/disposables/c;", "disposable", BuildConfig.FLAVOR, "j", "J", "showDuration", "Publish_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SelectVideoActivity extends BaseActivity<lo.k> {

    /* renamed from: a, reason: from kotlin metadata */
    private RecyclerView videoRecycler;

    /* renamed from: b, reason: from kotlin metadata */
    private com.transsion.publish.adapter.k0 videoAdapter;

    /* renamed from: c, reason: from kotlin metadata */
    private no.c selectVideoManager;

    /* renamed from: d, reason: from kotlin metadata */
    private LinearLayout noContentView;

    /* renamed from: e, reason: from kotlin metadata */
    private LinearLayout lockView;

    /* renamed from: f, reason: from kotlin metadata */
    private ProgressBar selectVideoLoading;

    /* renamed from: g, reason: from kotlin metadata */
    private int maxLimit = 1;

    /* renamed from: h, reason: from kotlin metadata */
    private final int screenWidth = com.blankj.utilcode.util.y.e();

    /* renamed from: i, reason: from kotlin metadata */
    private io.reactivex.rxjava3.disposables.c disposable;

    /* renamed from: j, reason: from kotlin metadata */
    private long showDuration;

    public static final class a implements io.reactivex.rxjava3.core.o {
        a() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(List list) {
            Intrinsics.h(list, "t");
            if (list.isEmpty()) {
                LinearLayout linearLayout = SelectVideoActivity.this.noContentView;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
            } else {
                com.transsion.publish.adapter.k0 k0Var = SelectVideoActivity.this.videoAdapter;
                if (k0Var != null) {
                    k0Var.addData(list);
                }
            }
            SelectVideoActivity.this.s0();
        }

        public void onComplete() {
            LinearLayout linearLayout;
            com.transsion.publish.adapter.k0 k0Var;
            io.reactivex.rxjava3.disposables.c cVar = SelectVideoActivity.this.disposable;
            if (cVar != null) {
                cVar.dispose();
            }
            SelectVideoActivity.this.s0();
            if ((SelectVideoActivity.this.videoAdapter == null || ((k0Var = SelectVideoActivity.this.videoAdapter) != null && k0Var.getItemCount() == 0)) && (linearLayout = SelectVideoActivity.this.noContentView) != null) {
                linearLayout.setVisibility(0);
            }
        }

        public void onError(Throwable th2) {
            Intrinsics.h(th2, "e");
            a.a.f(wf.a.a, "SelectVideoManager", "onError e:" + th2, false, 4, (Object) null);
        }

        public void onSubscribe(io.reactivex.rxjava3.disposables.c cVar) {
            Intrinsics.h(cVar, "d");
            SelectVideoActivity.this.disposable = cVar;
        }
    }

    public static final class b implements PermissionUtils.b {
        b() {
        }

        public void onDenied() {
            LinearLayout linearLayout = SelectVideoActivity.this.lockView;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
        }

        public void onGranted() {
            LinearLayout linearLayout = SelectVideoActivity.this.lockView;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            SelectVideoActivity.this.y0();
        }
    }

    private final void A0() {
        if (PermissionUtils.s(new String[]{"android.permission.READ_EXTERNAL_STORAGE"})) {
            y0();
        } else {
            PermissionUtils.x(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}).m(new b()).y();
        }
    }

    private final void initData() {
        Function1 function1 = new Function1() { // from class: com.transsion.publish.ui.e1
            public final Object invoke(Object obj) {
                Unit t0;
                t0 = SelectVideoActivity.t0(SelectVideoActivity.this, (PreviewMediaConfirmEvent) obj);
                return t0;
            }
        };
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = PreviewMediaConfirmEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().p(), false, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        ((CustomHeader) findViewById(R$id.sv_title_bar)).setOnBackClick(new View.OnClickListener() { // from class: com.transsion.publish.ui.g1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectVideoActivity.u0(SelectVideoActivity.this, view);
            }
        });
        p0(0);
        TextView textView = ((lo.k) getMViewBinding()).b;
        Intrinsics.g(textView, "confirmTV");
        uf.c.c(textView, 0L, new Function1() { // from class: com.transsion.publish.ui.h1
            public final Object invoke(Object obj) {
                Unit v0;
                v0 = SelectVideoActivity.v0(SelectVideoActivity.this, (View) obj);
                return v0;
            }
        }, 1, (Object) null);
        this.selectVideoLoading = (ProgressBar) findViewById(R$id.select_video_loading);
        this.noContentView = (LinearLayout) findViewById(R$id.sv_no_content_view);
        this.lockView = (LinearLayout) findViewById(R$id.sv_lock_view);
        TextView textView2 = (TextView) findViewById(R$id.sv_tv_grant);
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.ui.i1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SelectVideoActivity.w0(view);
                }
            });
        }
        this.videoRecycler = findViewById(R$id.select_video_recycler);
        this.videoAdapter = new com.transsion.publish.adapter.k0(new SelectVideoActivity$initView$4(this));
        RecyclerView recyclerView = this.videoRecycler;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 4, 1, false));
        }
        RecyclerView recyclerView2 = this.videoRecycler;
        if (recyclerView2 != null) {
            recyclerView2.addItemDecoration(new qo.f(com.blankj.utilcode.util.a0.a(2.0f)));
        }
        RecyclerView recyclerView3 = this.videoRecycler;
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(this.videoAdapter);
        }
        Function1 function1 = new Function1() { // from class: com.transsion.publish.ui.j1
            public final Object invoke(Object obj) {
                Unit x0;
                x0 = SelectVideoActivity.x0(SelectVideoActivity.this, (PreviewVideoBean) obj);
                return x0;
            }
        };
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = PreviewVideoBean.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().p(), false, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void p0(int size) {
        int e = RangesKt.e(size, 0);
        TextView textView = ((lo.k) getMViewBinding()).c;
        Intrinsics.g(textView, "selectNumTV");
        textView.setVisibility(e > 0 ? 0 : 8);
        ((lo.k) getMViewBinding()).c.setText(getString(R$string.video_select_num_tips, Integer.valueOf(e), Integer.valueOf(this.maxLimit)));
    }

    private final void q0() {
        List m;
        com.transsion.publish.adapter.k0 k0Var = this.videoAdapter;
        VsMediaInfo vsMediaInfo = (k0Var == null || (m = k0Var.m()) == null) ? null : (VsMediaInfo) CollectionsKt.k0(m);
        if (vsMediaInfo != null) {
            jo.b bVar = new jo.b();
            bVar.o(1);
            bVar.n(1);
            bVar.u(vsMediaInfo);
            FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = jo.b.class.getName();
            Intrinsics.g(name, "getName(...)");
            applicationScopeViewModel.postEvent(name, bVar, 0L);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s0() {
        ProgressBar progressBar = this.selectVideoLoading;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    private final void showLoading() {
        ProgressBar progressBar = this.selectVideoLoading;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t0(SelectVideoActivity selectVideoActivity, PreviewMediaConfirmEvent previewMediaConfirmEvent) {
        Intrinsics.h(previewMediaConfirmEvent, "it");
        selectVideoActivity.q0();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(SelectVideoActivity selectVideoActivity, View view) {
        selectVideoActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v0(SelectVideoActivity selectVideoActivity, View view) {
        Intrinsics.h(view, "it");
        selectVideoActivity.q0();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(View view) {
        PermissionUtils.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x0(SelectVideoActivity selectVideoActivity, PreviewVideoBean previewVideoBean) {
        Intrinsics.h(previewVideoBean, "it");
        VsMediaInfo select = previewVideoBean.getSelect();
        if (select == null) {
            return Unit.a;
        }
        com.transsion.publish.adapter.k0 k0Var = selectVideoActivity.videoAdapter;
        if (k0Var != null) {
            k0Var.x(select);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void y0() {
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.k(true);
        }
        showLoading();
        this.selectVideoManager = new no.c(this);
        io.reactivex.rxjava3.core.j.g(new io.reactivex.rxjava3.core.l() { // from class: com.transsion.publish.ui.f1
            public final void a(io.reactivex.rxjava3.core.k kVar) {
                SelectVideoActivity.z0(SelectVideoActivity.this, kVar);
            }
        }).b(12).v(io.reactivex.rxjava3.android.schedulers.b.c()).E(ey.a.c()).subscribe(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(SelectVideoActivity selectVideoActivity, io.reactivex.rxjava3.core.k kVar) {
        Intrinsics.h(kVar, "emitter");
        a.a.f(wf.a.a, "SelectVideoManager", "loadLocalVideo success", false, 4, (Object) null);
        no.c cVar = selectVideoActivity.selectVideoManager;
        if (cVar != null) {
            cVar.a(kVar);
        }
        if (kVar.isDisposed()) {
            return;
        }
        kVar.onComplete();
    }

    public boolean isChangeStatusBar() {
        return false;
    }

    public boolean isStatusDark() {
        return true;
    }

    public boolean isTranslucent() {
        return true;
    }

    public qi.b newLogViewConfig() {
        return new qi.b("select_video", false, 2, null);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.showDuration = System.currentTimeMillis();
        initView();
        initData();
        A0();
    }

    protected void onDestroy() {
        super.onDestroy();
        io.reactivex.rxjava3.disposables.c cVar = this.disposable;
        if (cVar != null) {
            cVar.dispose();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public lo.k getViewBinding() {
        lo.k c = lo.k.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }
}
