package com.transsion.publish.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.PermissionUtils;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.transsion.baseui.R;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.gslb.BuildConfig;
import com.transsion.publish.R$id;
import com.transsion.publish.R$string;
import com.transsion.publish.api.PhotoEntity;
import com.transsion.publish.bean.BigImageBean;
import com.transsion.publish.bean.PreviewMediaConfirmEvent;
import com.transsion.publish.view.CustomHeader;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import f.g;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import wf.a;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u001d\u0010\u000b\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u001f\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0016\u0010\u0004J\u0019\u0010\u0018\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001a\u0010\u0004J/\u0010\u001f\u001a\u00020\u00052\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0005H\u0002¢\u0006\u0004\b!\u0010\u0004J\u000f\u0010\"\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\"\u0010\u0004J\u0017\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0012H\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020&H\u0016¢\u0006\u0004\b)\u0010(J\u000f\u0010*\u001a\u00020&H\u0016¢\u0006\u0004\b*\u0010(J\u0019\u0010-\u001a\u00020\u00052\b\u0010,\u001a\u0004\u0018\u00010+H\u0014¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0002H\u0016¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0005H\u0014¢\u0006\u0004\b1\u0010\u0004J)\u00104\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u00122\b\u0010\n\u001a\u0004\u0018\u00010\u0017H\u0014¢\u0006\u0004\b4\u00105J\u000f\u00107\u001a\u000206H\u0016¢\u0006\u0004\b7\u00108R\u0014\u0010;\u001a\u00020\u00108\u0002X\u0082D¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010M\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010JR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u001e\u0010T\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010X\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010_\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010a\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010^R\u001e\u0010f\u001a\n\u0012\u0004\u0012\u00020c\u0018\u00010b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u001e\u0010h\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010eR\u001e\u0010j\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010eR\u0016\u0010m\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010l¨\u0006o"}, d2 = {"Lcom/transsion/publish/ui/SelectImageActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Llo/d;", "<init>", "()V", BuildConfig.FLAVOR, "initData", "N0", BuildConfig.FLAVOR, "Landroid/net/Uri;", "data", "K0", "(Ljava/util/List;)V", "L0", "initView", "J0", BuildConfig.FLAVOR, "uri", BuildConfig.FLAVOR, "source", "M0", "(Ljava/lang/String;I)V", "A0", "Landroid/content/Intent;", "x0", "(Landroid/content/Intent;)V", "H0", BuildConfig.FLAVOR, "Lcom/transsion/publish/api/PhotoEntity;", "photos", "selectList", "v0", "(Ljava/util/List;Ljava/util/List;)V", "showLoading", "z0", "size", "w0", "(I)V", BuildConfig.FLAVOR, "isTranslucent", "()Z", "isStatusDark", "isChangeStatusBar", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "y0", "()Llo/d;", "onDestroy", "requestCode", "resultCode", "onActivityResult", "(IILandroid/content/Intent;)V", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "a", "Ljava/lang/String;", "tag", "Landroidx/recyclerview/widget/RecyclerView;", "b", "Landroidx/recyclerview/widget/RecyclerView;", "videoRecycler", "Lcom/transsion/publish/adapter/e0;", "c", "Lcom/transsion/publish/adapter/e0;", "videoAdapter", "Lno/b;", "d", "Lno/b;", "selectPhotoManager", "Landroid/widget/LinearLayout;", "e", "Landroid/widget/LinearLayout;", "noContentView", "f", "lockView", "Landroid/widget/ProgressBar;", "g", "Landroid/widget/ProgressBar;", "selectVideoLoading", "h", "Ljava/util/List;", "selectImages", "Lio/reactivex/rxjava3/disposables/c;", "i", "Lio/reactivex/rxjava3/disposables/c;", "disposable", BuildConfig.FLAVOR, "j", "J", "showDuration", "k", "I", "keyType", "l", "maxLimit", "Landroidx/activity/result/b;", "Landroidx/activity/result/e;", "m", "Landroidx/activity/result/b;", "imageSelectLauncher", "n", "singleSelectLauncher", "o", "clipLauncher", "p", "Z", "underOS33", "q", "Publish_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SelectImageActivity extends BaseActivity<lo.d> {

    /* renamed from: q, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: from kotlin metadata */
    private RecyclerView videoRecycler;

    /* renamed from: c, reason: from kotlin metadata */
    private com.transsion.publish.adapter.e0 videoAdapter;

    /* renamed from: d, reason: from kotlin metadata */
    private no.b selectPhotoManager;

    /* renamed from: e, reason: from kotlin metadata */
    private LinearLayout noContentView;

    /* renamed from: f, reason: from kotlin metadata */
    private LinearLayout lockView;

    /* renamed from: g, reason: from kotlin metadata */
    private ProgressBar selectVideoLoading;

    /* renamed from: h, reason: from kotlin metadata */
    private List selectImages;

    /* renamed from: i, reason: from kotlin metadata */
    private io.reactivex.rxjava3.disposables.c disposable;

    /* renamed from: j, reason: from kotlin metadata */
    private long showDuration;

    /* renamed from: k, reason: from kotlin metadata */
    private int keyType;

    /* renamed from: m, reason: from kotlin metadata */
    private androidx.activity.result.b imageSelectLauncher;

    /* renamed from: n, reason: from kotlin metadata */
    private androidx.activity.result.b singleSelectLauncher;

    /* renamed from: o, reason: from kotlin metadata */
    private androidx.activity.result.b clipLauncher;

    /* renamed from: p, reason: from kotlin metadata */
    private boolean underOS33;

    /* renamed from: a, reason: from kotlin metadata */
    private final String tag = "ImageSelect";

    /* renamed from: l, reason: from kotlin metadata */
    private int maxLimit = 1;

    /* renamed from: com.transsion.publish.ui.SelectImageActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, int i, int i2, List list) {
            Intrinsics.h(context, "context");
            Intent intent = new Intent(context, (Class<?>) SelectImageActivity.class);
            intent.setFlags(268435456);
            intent.putExtra("key_type", i);
            if (list != null) {
                intent.putExtra("key_list", (Serializable) list);
            }
            intent.putExtra("key_limited", i2);
            context.startActivity(intent);
        }
    }

    public static final class b implements io.reactivex.rxjava3.core.o {
        b() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(List list) {
            Intrinsics.h(list, "t");
            if (list.isEmpty() || (list.size() == 1 && TextUtils.isEmpty(((PhotoEntity) list.get(0)).getLocalPath()))) {
                LinearLayout linearLayout = SelectImageActivity.this.noContentView;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
            } else {
                SelectImageActivity selectImageActivity = SelectImageActivity.this;
                List list2 = selectImageActivity.selectImages;
                selectImageActivity.v0(list, list2 != null ? CollectionsKt.U0(list2) : null);
                com.transsion.publish.adapter.e0 e0Var = SelectImageActivity.this.videoAdapter;
                if (e0Var != null) {
                    e0Var.addData(list);
                }
            }
            SelectImageActivity.this.z0();
        }

        public void onComplete() {
            io.reactivex.rxjava3.disposables.c cVar = SelectImageActivity.this.disposable;
            if (cVar != null) {
                cVar.dispose();
            }
        }

        public void onError(Throwable th2) {
            Intrinsics.h(th2, "e");
            a.a.f(wf.a.a, "SelectVideoManager", "onError e:" + th2, false, 4, (Object) null);
        }

        public void onSubscribe(io.reactivex.rxjava3.disposables.c cVar) {
            Intrinsics.h(cVar, "d");
            SelectImageActivity.this.disposable = cVar;
        }
    }

    public static final class c implements PermissionUtils.b {
        c() {
        }

        public void onDenied() {
            LinearLayout linearLayout = SelectImageActivity.this.lockView;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            ProgressBar progressBar = SelectImageActivity.this.selectVideoLoading;
            if (progressBar != null) {
                uf.c.g(progressBar);
            }
        }

        public void onGranted() {
            LinearLayout linearLayout = SelectImageActivity.this.lockView;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            SelectImageActivity.this.H0();
        }
    }

    public SelectImageActivity() {
        this.underOS33 = Build.VERSION.SDK_INT < 33;
    }

    private final void A0() {
        if (this.clipLauncher != null) {
            return;
        }
        this.clipLauncher = registerForActivityResult(new f.j(), new androidx.activity.result.a() { // from class: com.transsion.publish.ui.n0
            public final void a(Object obj) {
                SelectImageActivity.B0(SelectImageActivity.this, (ActivityResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(SelectImageActivity selectImageActivity, ActivityResult activityResult) {
        Intrinsics.h(activityResult, "result");
        selectImageActivity.x0(activityResult.getData());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C0(SelectImageActivity selectImageActivity, PreviewMediaConfirmEvent previewMediaConfirmEvent) {
        Intrinsics.h(previewMediaConfirmEvent, "it");
        selectImageActivity.J0();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D0(SelectImageActivity selectImageActivity, BigImageBean bigImageBean) {
        Intrinsics.h(bigImageBean, "it");
        Integer from = bigImageBean.getFrom();
        if (from == null || from.intValue() != 3) {
            Integer from2 = bigImageBean.getFrom();
            if (from2 == null || from2.intValue() != 1) {
                return Unit.a;
            }
            Integer operator = bigImageBean.getOperator();
            if (operator != null && operator.intValue() == 1) {
                com.transsion.publish.adapter.e0 e0Var = selectImageActivity.videoAdapter;
                if (e0Var != null) {
                    e0Var.n();
                }
                com.transsion.publish.adapter.e0 e0Var2 = selectImageActivity.videoAdapter;
                if (e0Var2 != null) {
                    e0Var2.x();
                }
                com.transsion.publish.adapter.e0 e0Var3 = selectImageActivity.videoAdapter;
                selectImageActivity.v0(e0Var3 != null ? e0Var3.q() : null, bigImageBean.getSelect());
                com.transsion.publish.adapter.e0 e0Var4 = selectImageActivity.videoAdapter;
                if (e0Var4 != null) {
                    e0Var4.notifyDataSetChanged();
                }
            }
            return Unit.a;
        }
        Integer operator2 = bigImageBean.getOperator();
        if (operator2 != null && operator2.intValue() == 2) {
            com.transsion.publish.adapter.e0 e0Var5 = selectImageActivity.videoAdapter;
            if (e0Var5 != null) {
                e0Var5.n();
            }
            com.transsion.publish.adapter.e0 e0Var6 = selectImageActivity.videoAdapter;
            if (e0Var6 != null) {
                e0Var6.x();
            }
            com.transsion.publish.adapter.e0 e0Var7 = selectImageActivity.videoAdapter;
            if (e0Var7 != null) {
                e0Var7.notifyDataSetChanged();
            }
            return Unit.a;
        }
        com.transsion.publish.adapter.e0 e0Var8 = selectImageActivity.videoAdapter;
        if (e0Var8 != null) {
            e0Var8.n();
        }
        com.transsion.publish.adapter.e0 e0Var9 = selectImageActivity.videoAdapter;
        if (e0Var9 != null) {
            e0Var9.x();
        }
        com.transsion.publish.adapter.e0 e0Var10 = selectImageActivity.videoAdapter;
        selectImageActivity.v0(e0Var10 != null ? e0Var10.q() : null, bigImageBean.getSelect());
        com.transsion.publish.adapter.e0 e0Var11 = selectImageActivity.videoAdapter;
        if (e0Var11 != null) {
            e0Var11.notifyDataSetChanged();
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(SelectImageActivity selectImageActivity, View view) {
        selectImageActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(SelectImageActivity selectImageActivity, View view) {
        Intrinsics.h(view, "it");
        selectImageActivity.J0();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(View view) {
        PermissionUtils.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void H0() {
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.k(true);
        }
        showLoading();
        this.selectPhotoManager = new no.b(this);
        io.reactivex.rxjava3.core.j.g(new io.reactivex.rxjava3.core.l() { // from class: com.transsion.publish.ui.m0
            public final void a(io.reactivex.rxjava3.core.k kVar) {
                SelectImageActivity.I0(SelectImageActivity.this, kVar);
            }
        }).b(12).v(io.reactivex.rxjava3.android.schedulers.b.c()).E(ey.a.c()).subscribe(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(SelectImageActivity selectImageActivity, io.reactivex.rxjava3.core.k kVar) {
        Intrinsics.h(kVar, "emitter");
        a.a.f(wf.a.a, "SelectVideoManager", "loadLocalVideo success", false, 4, (Object) null);
        no.b bVar = selectImageActivity.selectPhotoManager;
        if (bVar != null) {
            bVar.a(kVar);
        }
        if (kVar.isDisposed()) {
            return;
        }
        kVar.onComplete();
    }

    private final void J0() {
        com.transsion.publish.adapter.e0 e0Var = this.videoAdapter;
        List r = e0Var != null ? e0Var.r() : null;
        List list = r;
        if (list == null || list.isEmpty()) {
            finish();
            return;
        }
        if (this.keyType != 0) {
            String localPath = ((PhotoEntity) r.get(0)).getLocalPath();
            if (localPath != null) {
                M0(localPath, this.keyType);
                return;
            }
            return;
        }
        jo.b bVar = new jo.b();
        bVar.o(0);
        bVar.n(1);
        bVar.r(CollectionsKt.U0(list));
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = jo.b.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.postEvent(name, bVar, 0L);
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void K0(List data) {
        jo.b bVar = new jo.b();
        bVar.o(Integer.valueOf(this.keyType));
        bVar.n(1);
        bVar.r(new ArrayList());
        Iterator it = data.iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            PhotoEntity photoEntity = new PhotoEntity();
            ko.a b2 = qo.g.a.b(this, uri);
            if (b2 != null) {
                photoEntity.setLocalPath(b2.c());
                photoEntity.setImageTitle(b2.e());
                photoEntity.setWidth(b2.f());
                photoEntity.setHeight(b2.b());
                photoEntity.setImageSize(b2.d());
            }
            List h = bVar.h();
            if (h != null) {
                h.add(photoEntity);
            }
            try {
                Result.Companion companion = Result.Companion;
                getContentResolver().takePersistableUriPermission(uri, 1);
                Result.constructor-impl(Unit.a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.a(th2));
            }
        }
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = jo.b.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.postEvent(name, bVar, 0L);
        finish();
    }

    private final void L0() {
        int i = Build.VERSION.SDK_INT;
        String str = i >= 34 ? "android.permission.READ_MEDIA_VISUAL_USER_SELECTED" : i >= 33 ? "android.permission.READ_MEDIA_IMAGES" : "android.permission.READ_EXTERNAL_STORAGE";
        if (PermissionUtils.s(new String[]{str})) {
            H0();
        } else {
            PermissionUtils.x(new String[]{str}).m(new c()).y();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void M0(String uri, int source) {
        ClippingImageActivity.INSTANCE.a(this, uri, source, this.clipLauncher);
    }

    private final void N0() {
        int i = this.maxLimit;
        if (i > 1) {
            androidx.activity.result.b registerForActivityResult = registerForActivityResult(new f.e(i), new androidx.activity.result.a() { // from class: com.transsion.publish.ui.p0
                public final void a(Object obj) {
                    SelectImageActivity.O0(SelectImageActivity.this, (List) obj);
                }
            });
            this.imageSelectLauncher = registerForActivityResult;
            if (registerForActivityResult != null) {
                registerForActivityResult.a(androidx.activity.result.f.b(g.d.a, 0, false, (g.b) null, 14, (Object) null));
                return;
            }
            return;
        }
        androidx.activity.result.b registerForActivityResult2 = registerForActivityResult(new f.b(), new androidx.activity.result.a() { // from class: com.transsion.publish.ui.q0
            public final void a(Object obj) {
                SelectImageActivity.P0(SelectImageActivity.this, (Uri) obj);
            }
        });
        this.singleSelectLauncher = registerForActivityResult2;
        if (registerForActivityResult2 != null) {
            registerForActivityResult2.a("image/*");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(SelectImageActivity selectImageActivity, List list) {
        Intrinsics.h(list, "data");
        a.a.f(wf.a.a, selectImageActivity.tag, "imageSelect keyType:" + selectImageActivity.keyType + ", data：" + list, false, 4, (Object) null);
        selectImageActivity.K0(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void P0(SelectImageActivity selectImageActivity, Uri uri) {
        String c2;
        a.a.f(wf.a.a, selectImageActivity.tag, "singleSelect keyType:" + selectImageActivity.keyType + ", uri：" + uri, false, 4, (Object) null);
        if (uri == null) {
            selectImageActivity.finish();
            return;
        }
        if (selectImageActivity.keyType == 0) {
            selectImageActivity.K0(CollectionsKt.e(uri));
            return;
        }
        ko.a b2 = qo.g.a.b(selectImageActivity, uri);
        if (b2 == null || (c2 = b2.c()) == null) {
            return;
        }
        selectImageActivity.M0(c2, selectImageActivity.keyType);
    }

    private final void initData() {
        Function1 function1 = new Function1() { // from class: com.transsion.publish.ui.o0
            public final Object invoke(Object obj) {
                Unit C0;
                C0 = SelectImageActivity.C0(SelectImageActivity.this, (PreviewMediaConfirmEvent) obj);
                return C0;
            }
        };
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = PreviewMediaConfirmEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().p(), false, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        List list;
        List<PhotoEntity> list2 = this.selectImages;
        PhotoEntity photoEntity = null;
        if (list2 != null) {
            for (PhotoEntity photoEntity2 : list2) {
                if (photoEntity2.getIsAdd()) {
                    photoEntity = photoEntity2;
                }
            }
        }
        if (photoEntity != null && (list = this.selectImages) != null) {
            list.remove(photoEntity);
        }
        ((CustomHeader) findViewById(R$id.sv_title_bar)).setOnBackClick(new View.OnClickListener() { // from class: com.transsion.publish.ui.i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectImageActivity.E0(SelectImageActivity.this, view);
            }
        });
        List list3 = this.selectImages;
        w0(list3 != null ? list3.size() : 0);
        TextView textView = ((lo.d) getMViewBinding()).b;
        Intrinsics.g(textView, "confirmTV");
        uf.c.c(textView, 0L, new Function1() { // from class: com.transsion.publish.ui.j0
            public final Object invoke(Object obj) {
                Unit F0;
                F0 = SelectImageActivity.F0(SelectImageActivity.this, (View) obj);
                return F0;
            }
        }, 1, (Object) null);
        this.selectVideoLoading = (ProgressBar) findViewById(R$id.select_video_loading);
        this.noContentView = (LinearLayout) findViewById(R$id.sv_no_content_view);
        this.lockView = (LinearLayout) findViewById(R$id.sv_lock_view);
        TextView textView2 = (TextView) findViewById(R$id.sv_tv_grant);
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.ui.k0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SelectImageActivity.G0(view);
                }
            });
        }
        this.videoRecycler = findViewById(R$id.select_video_recycler);
        com.transsion.publish.adapter.e0 e0Var = new com.transsion.publish.adapter.e0(new SelectImageActivity$initView$5(this));
        this.videoAdapter = e0Var;
        e0Var.y(this.keyType, this);
        com.transsion.publish.adapter.e0 e0Var2 = this.videoAdapter;
        if (e0Var2 != null) {
            e0Var2.z(this.maxLimit);
        }
        RecyclerView recyclerView = this.videoRecycler;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new NpaGridLayoutManager(this, 4, 1, false));
        }
        RecyclerView recyclerView2 = this.videoRecycler;
        if (recyclerView2 != null) {
            recyclerView2.addItemDecoration(new qo.f(com.blankj.utilcode.util.a0.a(2.0f)));
        }
        RecyclerView recyclerView3 = this.videoRecycler;
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(this.videoAdapter);
        }
        Function1 function1 = new Function1() { // from class: com.transsion.publish.ui.l0
            public final Object invoke(Object obj) {
                Unit D0;
                D0 = SelectImageActivity.D0(SelectImageActivity.this, (BigImageBean) obj);
                return D0;
            }
        };
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = BigImageBean.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().p(), false, function1);
    }

    private final void showLoading() {
        ProgressBar progressBar = this.selectVideoLoading;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        ProgressBar progressBar2 = this.selectVideoLoading;
        if (progressBar2 != null) {
            uf.c.k(progressBar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v0(List photos, List selectList) {
        List list;
        if ((selectList != null && selectList.isEmpty()) || (list = photos) == null || list.isEmpty() || selectList == null) {
            return;
        }
        int i = 0;
        for (Object obj : selectList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.u();
            }
            PhotoEntity photoEntity = (PhotoEntity) obj;
            if (photos != null) {
                Iterator it = photos.iterator();
                while (it.hasNext()) {
                    PhotoEntity photoEntity2 = (PhotoEntity) it.next();
                    if (Intrinsics.c(photoEntity2 != null ? photoEntity2.getLocalPath() : null, photoEntity.getLocalPath())) {
                        photoEntity2.setEnableSelect(true);
                        com.transsion.publish.adapter.e0 e0Var = this.videoAdapter;
                        if (e0Var != null) {
                            e0Var.A(photoEntity);
                        }
                    }
                }
            }
            i = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void w0(int size) {
        TextView textView = ((lo.d) getMViewBinding()).c;
        Intrinsics.g(textView, "selectNumTV");
        textView.setVisibility(size > 0 ? 0 : 8);
        ((lo.d) getMViewBinding()).c.setText(getString(R$string.image_select_num_tips, Integer.valueOf(size), Integer.valueOf(this.maxLimit)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void x0(Intent data) {
        Bundle extras;
        Bundle extras2;
        if (data != null && (extras2 = data.getExtras()) != null && !extras2.containsKey("clip_result")) {
            finish();
            return;
        }
        Serializable serializable = (data == null || (extras = data.getExtras()) == null) ? null : extras.getSerializable("clip_result");
        if (serializable == null) {
            a.a.f(wf.a.a, "clip_result", "null...", false, 4, (Object) null);
            finish();
            return;
        }
        if (serializable instanceof PhotoEntity) {
            a.a.f(wf.a.a, "clip_result", "result:" + serializable, false, 4, (Object) null);
            int i = this.keyType;
            if (i == 0 || i == 5) {
                jo.b bVar = new jo.b();
                bVar.o(5);
                bVar.n(1);
                bVar.l((PhotoEntity) serializable);
                FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
                String name = jo.b.class.getName();
                Intrinsics.g(name, "getName(...)");
                applicationScopeViewModel.postEvent(name, bVar, 0L);
            } else {
                Intent intent = new Intent();
                intent.putExtra("clip_result", ((PhotoEntity) serializable).getLocalPath());
                setResult(-1, intent);
            }
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z0() {
        ProgressBar progressBar = this.selectVideoLoading;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        ProgressBar progressBar2 = this.selectVideoLoading;
        if (progressBar2 != null) {
            uf.c.g(progressBar2);
        }
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
        return new qi.b("select_image", false, 2, null);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super/*androidx.fragment.app.FragmentActivity*/.onActivityResult(requestCode, resultCode, data);
        a.a.f(wf.a.a, this.tag, "onActivityResult keyType:" + this.keyType + ", requestCodeP:" + requestCode + ", data:" + (data != null ? data.getData() : null), false, 4, (Object) null);
        if (requestCode != 10002) {
            return;
        }
        x0(data);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.showDuration = System.currentTimeMillis();
        this.maxLimit = getIntent().getIntExtra("key_limited", 1);
        this.keyType = getIntent().getIntExtra("key_type", 0);
        if (getIntent().hasExtra("key_list")) {
            Serializable serializableExtra = getIntent().getSerializableExtra("key_list");
            Intrinsics.f(serializableExtra, "null cannot be cast to non-null type kotlin.collections.MutableList<com.transsion.publish.api.PhotoEntity>");
            this.selectImages = TypeIntrinsics.c(serializableExtra);
        }
        if (this.underOS33) {
            initView();
            initData();
            L0();
        } else {
            N0();
            View findViewById = findViewById(R.id.llRootView);
            Intrinsics.g(findViewById, "findViewById(...)");
            uf.c.h(findViewById);
        }
        A0();
    }

    protected void onDestroy() {
        super.onDestroy();
        io.reactivex.rxjava3.disposables.c cVar = this.disposable;
        if (cVar != null) {
            cVar.dispose();
        }
        com.transsion.publish.n.b.a().d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    public lo.d getViewBinding() {
        lo.d c2 = lo.d.c(getLayoutInflater());
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }
}
