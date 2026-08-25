package com.transsion.publish.ui;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.PermissionUtils;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.gslb.BuildConfig;
import com.transsion.publish.R$id;
import com.transsion.publish.api.AudioEntity;
import com.transsion.publish.ui.SelectMusicActivity;
import com.transsion.publish.view.CustomHeader;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import wf.a;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 G2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u0019\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0018\u0010\u0004J)\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00104\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00101R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010F\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010?¨\u0006H"}, d2 = {"Lcom/transsion/publish/ui/SelectMusicActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Llo/f;", "<init>", "()V", BuildConfig.FLAVOR, "z0", "initView", "y0", "w0", "showLoading", "s0", BuildConfig.FLAVOR, "isTranslucent", "()Z", "isStatusDark", "isChangeStatusBar", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "r0", "()Llo/f;", "onPause", "onDestroy", BuildConfig.FLAVOR, "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "Landroidx/recyclerview/widget/RecyclerView;", "a", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Lcom/transsion/publish/adapter/b0;", "b", "Lcom/transsion/publish/adapter/b0;", "musicAdapter", "Lno/a;", "c", "Lno/a;", "selectMusicManager", "Landroid/widget/LinearLayout;", "d", "Landroid/widget/LinearLayout;", "noContentView", "e", "lockView", "Landroid/widget/ProgressBar;", "f", "Landroid/widget/ProgressBar;", "selectVideoLoading", "Lqo/d;", "g", "Lqo/d;", "mediaPlayerHelper", BuildConfig.FLAVOR, "h", "Ljava/lang/String;", "MUSIC_PERMISSIONS", "Lio/reactivex/rxjava3/disposables/c;", "i", "Lio/reactivex/rxjava3/disposables/c;", "disposable", "j", "playPath", "k", "Publish_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SelectMusicActivity extends BaseActivity<lo.f> {

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    private RecyclerView recycler;

    /* renamed from: b, reason: from kotlin metadata */
    private com.transsion.publish.adapter.b0 musicAdapter;

    /* renamed from: c, reason: from kotlin metadata */
    private no.a selectMusicManager;

    /* renamed from: d, reason: from kotlin metadata */
    private LinearLayout noContentView;

    /* renamed from: e, reason: from kotlin metadata */
    private LinearLayout lockView;

    /* renamed from: f, reason: from kotlin metadata */
    private ProgressBar selectVideoLoading;

    /* renamed from: g, reason: from kotlin metadata */
    private qo.d mediaPlayerHelper;

    /* renamed from: h, reason: from kotlin metadata */
    private final String MUSIC_PERMISSIONS;

    /* renamed from: i, reason: from kotlin metadata */
    private io.reactivex.rxjava3.disposables.c disposable;

    /* renamed from: j, reason: from kotlin metadata */
    private String playPath;

    /* renamed from: com.transsion.publish.ui.SelectMusicActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.h(context, "context");
            Intent intent = new Intent(context, (Class<?>) SelectMusicActivity.class);
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
    }

    public static final class b implements com.transsion.publish.adapter.x {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(SelectMusicActivity selectMusicActivity, AudioEntity audioEntity, MediaPlayer mediaPlayer) {
            int i;
            List h;
            com.transsion.publish.adapter.b0 b0Var = selectMusicActivity.musicAdapter;
            if (b0Var == null || (h = b0Var.h()) == null) {
                i = -1;
            } else {
                int i2 = 0;
                i = -1;
                for (Object obj : h) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt.u();
                    }
                    if (Intrinsics.c(audioEntity, (AudioEntity) obj)) {
                        i = i2;
                    }
                    i2 = i3;
                }
            }
            if (i != -1) {
                audioEntity.setPlay(false);
                com.transsion.publish.adapter.b0 b0Var2 = selectMusicActivity.musicAdapter;
                if (b0Var2 != null) {
                    b0Var2.notifyItemChanged(i);
                }
            }
        }

        @Override // com.transsion.publish.adapter.x
        public void a(final AudioEntity audioEntity) {
            Context context;
            qo.d dVar;
            qo.d dVar2;
            Intrinsics.h(audioEntity, "info");
            try {
                if (SelectMusicActivity.this.mediaPlayerHelper == null) {
                    SelectMusicActivity.this.mediaPlayerHelper = new qo.d();
                }
                if (Intrinsics.c(SelectMusicActivity.this.playPath, audioEntity.getLocalPath()) && (dVar2 = SelectMusicActivity.this.mediaPlayerHelper) != null && dVar2.b()) {
                    qo.d dVar3 = SelectMusicActivity.this.mediaPlayerHelper;
                    if (dVar3 != null) {
                        dVar3.c();
                        return;
                    }
                    return;
                }
                String localPath = audioEntity.getLocalPath();
                if (localPath != null) {
                    final SelectMusicActivity selectMusicActivity = SelectMusicActivity.this;
                    RecyclerView recyclerView = selectMusicActivity.recycler;
                    if (recyclerView != null && (context = recyclerView.getContext()) != null && (dVar = selectMusicActivity.mediaPlayerHelper) != null) {
                        dVar.d(context, localPath, false, new MediaPlayer.OnCompletionListener() { // from class: com.transsion.publish.ui.d1
                            @Override // android.media.MediaPlayer.OnCompletionListener
                            public final void onCompletion(MediaPlayer mediaPlayer) {
                                SelectMusicActivity.b.c(SelectMusicActivity.this, audioEntity, mediaPlayer);
                            }
                        });
                    }
                }
                SelectMusicActivity.this.playPath = audioEntity.getLocalPath();
            } catch (Exception e) {
                String message = e.getMessage();
                if (message != null) {
                    a.a.f(wf.a.a, "audioTAG", message, false, 4, (Object) null);
                }
            }
        }
    }

    public static final class c implements io.reactivex.rxjava3.core.o {
        c() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(List list) {
            Intrinsics.h(list, "t");
            if (list.isEmpty() || (list.size() == 1 && TextUtils.isEmpty(((AudioEntity) list.get(0)).getLocalPath()))) {
                LinearLayout linearLayout = SelectMusicActivity.this.noContentView;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
            } else {
                com.transsion.publish.adapter.b0 b0Var = SelectMusicActivity.this.musicAdapter;
                if (b0Var != null) {
                    b0Var.addData(list);
                }
            }
            SelectMusicActivity.this.s0();
        }

        public void onComplete() {
            io.reactivex.rxjava3.disposables.c cVar = SelectMusicActivity.this.disposable;
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
            SelectMusicActivity.this.disposable = cVar;
        }
    }

    public static final class d implements PermissionUtils.b {
        d() {
        }

        public void onDenied() {
            LinearLayout linearLayout = SelectMusicActivity.this.lockView;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
        }

        public void onGranted() {
            LinearLayout linearLayout = SelectMusicActivity.this.lockView;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            SelectMusicActivity.this.w0();
        }
    }

    public SelectMusicActivity() {
        this.MUSIC_PERMISSIONS = Build.VERSION.SDK_INT < 33 ? "android.permission.WRITE_EXTERNAL_STORAGE" : "android.permission.READ_MEDIA_AUDIO";
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        CustomHeader customHeader = (CustomHeader) findViewById(R$id.sv_title_bar);
        customHeader.setOnBackClick(new View.OnClickListener() { // from class: com.transsion.publish.ui.z0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectMusicActivity.t0(SelectMusicActivity.this, view);
            }
        });
        customHeader.setOnEditClick(new View.OnClickListener() { // from class: com.transsion.publish.ui.a1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectMusicActivity.u0(SelectMusicActivity.this, view);
            }
        });
        this.selectVideoLoading = (ProgressBar) findViewById(R$id.select_video_loading);
        this.noContentView = (LinearLayout) findViewById(R$id.sv_no_content_view);
        this.lockView = (LinearLayout) findViewById(R$id.sv_lock_view);
        TextView textView = (TextView) findViewById(R$id.sv_tv_grant);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.ui.b1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SelectMusicActivity.v0(view);
                }
            });
        }
        this.recycler = findViewById(R$id.select_video_recycler);
        this.musicAdapter = new com.transsion.publish.adapter.b0();
        RecyclerView recyclerView = this.recycler;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
        RecyclerView recyclerView2 = this.recycler;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.musicAdapter);
        }
        int b2 = (com.blankj.utilcode.util.y.b() - (com.blankj.utilcode.util.a0.a(3.0f) * 5)) / 6;
        RecyclerView recyclerView3 = this.recycler;
        if (recyclerView3 != null) {
            recyclerView3.setPadding(0, 0, 0, b2);
        }
        com.transsion.publish.adapter.b0 b0Var = this.musicAdapter;
        if (b0Var != null) {
            b0Var.p(new b());
        }
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
    public static final void t0(SelectMusicActivity selectMusicActivity, View view) {
        selectMusicActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(SelectMusicActivity selectMusicActivity, View view) {
        selectMusicActivity.y0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(View view) {
        PermissionUtils.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void w0() {
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.k(true);
        }
        showLoading();
        this.selectMusicManager = new no.a(this);
        io.reactivex.rxjava3.core.j.g(new io.reactivex.rxjava3.core.l() { // from class: com.transsion.publish.ui.c1
            public final void a(io.reactivex.rxjava3.core.k kVar) {
                SelectMusicActivity.x0(SelectMusicActivity.this, kVar);
            }
        }).b(12).v(io.reactivex.rxjava3.android.schedulers.b.c()).E(ey.a.c()).subscribe(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(SelectMusicActivity selectMusicActivity, io.reactivex.rxjava3.core.k kVar) {
        Intrinsics.h(kVar, "emitter");
        a.a.f(wf.a.a, "SelectMusicManager", "loadLocalMusic success", false, 4, (Object) null);
        no.a aVar = selectMusicActivity.selectMusicManager;
        if (aVar != null) {
            aVar.a(kVar);
        }
        if (kVar.isDisposed()) {
            return;
        }
        kVar.onComplete();
    }

    private final void y0() {
        com.transsion.publish.adapter.b0 b0Var = this.musicAdapter;
        AudioEntity i = b0Var != null ? b0Var.i() : null;
        if (i == null) {
            finish();
            return;
        }
        jo.b bVar = new jo.b();
        bVar.o(2);
        bVar.n(1);
        bVar.k(i);
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = jo.b.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.postEvent(name, bVar, 0L);
        finish();
    }

    private final void z0() {
        if (PermissionUtils.s(new String[]{this.MUSIC_PERMISSIONS})) {
            w0();
        } else {
            PermissionUtils.x(new String[]{this.MUSIC_PERMISSIONS}).m(new d()).y();
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
        return new qi.b("select_music", false, 2, null);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super/*androidx.fragment.app.FragmentActivity*/.onActivityResult(requestCode, resultCode, data);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        z0();
    }

    protected void onDestroy() {
        super.onDestroy();
        io.reactivex.rxjava3.disposables.c cVar = this.disposable;
        if (cVar != null) {
            cVar.dispose();
        }
        qo.d dVar = this.mediaPlayerHelper;
        if (dVar != null) {
            dVar.f();
        }
    }

    public void onPause() {
        super.onPause();
        qo.d dVar = this.mediaPlayerHelper;
        if (dVar != null) {
            dVar.c();
        }
        com.transsion.publish.adapter.b0 b0Var = this.musicAdapter;
        if (b0Var != null) {
            b0Var.o();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public lo.f getViewBinding() {
        lo.f c2 = lo.f.c(getLayoutInflater());
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }
}
