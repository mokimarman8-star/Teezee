package com.transsion.publish.ui;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.widget.R;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.gslb.BuildConfig;
import com.transsion.publish.R$drawable;
import com.transsion.publish.R$string;
import com.transsion.publish.api.VsMediaInfo;
import com.transsion.publish.bean.PreviewMediaConfirmEvent;
import com.transsion.publish.bean.PreviewVideoBean;
import com.transsion.push.bean.MsgStyle;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import wf.a;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\b\u0016\u0018\u0000 =2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001a\u0010\u0004J\u0017\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001c\u0010\fJ\u000f\u0010\u001d\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001e\u0010\u0004J\u0019\u0010!\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0014¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0002H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0005H\u0014¢\u0006\u0004\b%\u0010\u0004J\u000f\u0010&\u001a\u00020\u0005H\u0016¢\u0006\u0004\b&\u0010\u0004J\u000f\u0010'\u001a\u00020\tH\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\tH\u0016¢\u0006\u0004\b)\u0010(J\u000f\u0010*\u001a\u00020\tH\u0016¢\u0006\u0004\b*\u0010(J\u000f\u0010+\u001a\u00020\u0005H\u0014¢\u0006\u0004\b+\u0010\u0004J\u000f\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b-\u0010.R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u00106¨\u0006>"}, d2 = {"Lcom/transsion/publish/ui/VideoPreviewActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Llo/g;", "<init>", "()V", BuildConfig.FLAVOR, "initView", "initData", "l0", BuildConfig.FLAVOR, "status", "B0", "(Z)V", "Lcom/transsion/publish/api/VsMediaInfo;", "vsMediaInfo", "z0", "(Lcom/transsion/publish/api/VsMediaInfo;)V", BuildConfig.FLAVOR, "path", "t0", "(Ljava/lang/String;)V", "Landroid/graphics/Bitmap;", "bitmap", "A0", "(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;", "C0", "D0", "select", "k0", "n0", "o0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "m0", "()Llo/g;", "onDestroy", "onResume", "isTranslucent", "()Z", "isStatusDark", "isChangeStatusBar", "onStop", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "a", "Lcom/transsion/publish/api/VsMediaInfo;", BuildConfig.FLAVOR, "b", "Ljava/lang/Integer;", "sourceType", "c", "I", "maxSize", "d", "Z", "isBack", "e", "maxLimit", "f", "Publish_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class VideoPreviewActivity extends BaseActivity<lo.g> {

    /* renamed from: f, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    private VsMediaInfo vsMediaInfo;

    /* renamed from: d, reason: from kotlin metadata */
    private boolean isBack;

    /* renamed from: b, reason: from kotlin metadata */
    private Integer sourceType = 0;

    /* renamed from: c, reason: from kotlin metadata */
    private int maxSize = 1048576000;

    /* renamed from: e, reason: from kotlin metadata */
    private int maxLimit = 1;

    /* renamed from: com.transsion.publish.ui.VideoPreviewActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, VsMediaInfo vsMediaInfo, int i) {
            Intrinsics.h(context, "context");
            Intrinsics.h(vsMediaInfo, "data");
            Intent intent = new Intent(context, (Class<?>) VideoPreviewActivity.class);
            intent.setFlags(268435456);
            intent.putExtra("data", vsMediaInfo);
            intent.putExtra("sourceType", i);
            context.startActivity(intent);
        }
    }

    private final Bitmap A0(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        ImageView imageView = ((lo.g) getMViewBinding()).h;
        Intrinsics.g(imageView, "coverIV");
        return (height <= 0 || width <= 0 || width > imageView.getWidth() || height > imageView.getHeight()) ? bitmap : vf.a.d(bitmap, imageView.getWidth(), imageView.getHeight(), false);
    }

    private final void B0(boolean status) {
        if (status) {
            ((lo.g) getMViewBinding()).o.setText(MsgStyle.CUSTOM_LEFT_PIC);
            ((lo.g) getMViewBinding()).o.setBackgroundResource(R$drawable.bg_linear_r16);
        } else {
            ((lo.g) getMViewBinding()).o.setBackgroundResource(R$drawable.ic_select_number_bro);
        }
        k0(status);
    }

    private final void C0() {
        ((lo.g) getMViewBinding()).q.pause();
        ImageView imageView = ((lo.g) getMViewBinding()).k;
        Intrinsics.g(imageView, "playIV");
        uf.c.k(imageView);
    }

    private final void D0() {
        ((lo.g) getMViewBinding()).q.start();
        ImageView imageView = ((lo.g) getMViewBinding()).k;
        Intrinsics.g(imageView, "playIV");
        uf.c.g(imageView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initData() {
        this.sourceType = Integer.valueOf(getIntent().getIntExtra("sourceType", 2));
        if (getIntent().hasExtra("data")) {
            ProgressBar progressBar = ((lo.g) getMViewBinding()).f;
            Intrinsics.g(progressBar, "clipLoading");
            uf.c.k(progressBar);
            Serializable serializableExtra = getIntent().getSerializableExtra("data");
            Intrinsics.f(serializableExtra, "null cannot be cast to non-null type com.transsion.publish.api.VsMediaInfo");
            VsMediaInfo vsMediaInfo = (VsMediaInfo) serializableExtra;
            this.vsMediaInfo = vsMediaInfo;
            Intrinsics.e(vsMediaInfo);
            z0(vsMediaInfo);
        }
        Integer num = this.sourceType;
        if (num != null && num.intValue() == 1) {
            ((lo.g) getMViewBinding()).j.setVisibility(8);
            ((lo.g) getMViewBinding()).i.setVisibility(0);
            FrameLayout frameLayout = ((lo.g) getMViewBinding()).i;
            Intrinsics.g(frameLayout, "flClear");
            uf.c.c(frameLayout, 0L, new Function1() { // from class: com.transsion.publish.ui.k1
                public final Object invoke(Object obj) {
                    Unit q0;
                    q0 = VideoPreviewActivity.q0(VideoPreviewActivity.this, (View) obj);
                    return q0;
                }
            }, 1, (Object) null);
        } else if (num != null && num.intValue() == 2) {
            ((lo.g) getMViewBinding()).i.setVisibility(8);
            ((lo.g) getMViewBinding()).j.setVisibility(0);
            VsMediaInfo vsMediaInfo2 = this.vsMediaInfo;
            if (vsMediaInfo2 != null) {
                B0(vsMediaInfo2.getEnableSelect());
            }
            Group group = ((lo.g) getMViewBinding()).b;
            Intrinsics.g(group, "bottomGroup");
            uf.c.k(group);
            LinearLayout linearLayout = ((lo.g) getMViewBinding()).j;
            Intrinsics.g(linearLayout, "llSelect");
            uf.c.c(linearLayout, 0L, new Function1() { // from class: com.transsion.publish.ui.l1
                public final Object invoke(Object obj) {
                    Unit r0;
                    r0 = VideoPreviewActivity.r0(VideoPreviewActivity.this, (View) obj);
                    return r0;
                }
            }, 1, (Object) null);
        }
        ProgressBar progressBar2 = ((lo.g) getMViewBinding()).f;
        Intrinsics.g(progressBar2, "clipLoading");
        uf.c.g(progressBar2);
        ((lo.g) getMViewBinding()).q.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.ui.m1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoPreviewActivity.s0(VideoPreviewActivity.this, view);
            }
        });
        ((lo.g) getMViewBinding()).l.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.ui.n1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoPreviewActivity.p0(VideoPreviewActivity.this, view);
            }
        });
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.k(true);
        }
    }

    private final void initView() {
        ((lo.g) getMViewBinding()).d.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.ui.p1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoPreviewActivity.v0(VideoPreviewActivity.this, view);
            }
        });
        ((lo.g) getMViewBinding()).q.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.transsion.publish.ui.q1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer mediaPlayer) {
                VideoPreviewActivity.w0(VideoPreviewActivity.this, mediaPlayer);
            }
        });
        TextView textView = ((lo.g) getMViewBinding()).g;
        Intrinsics.g(textView, "confirmTV");
        uf.c.c(textView, 0L, new Function1() { // from class: com.transsion.publish.ui.r1
            public final Object invoke(Object obj) {
                Unit y0;
                y0 = VideoPreviewActivity.y0(VideoPreviewActivity.this, (View) obj);
                return y0;
            }
        }, 1, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void k0(boolean select) {
        TextView textView = ((lo.g) getMViewBinding()).m;
        Intrinsics.g(textView, "selectNumTV");
        textView.setVisibility((select > 0) != false ? 0 : 8);
        ((lo.g) getMViewBinding()).m.setText(getString(R$string.video_select_num_tips, Integer.valueOf(select ? 1 : 0), Integer.valueOf(this.maxLimit)));
    }

    private final void l0() {
        if (((lo.g) getMViewBinding()).q.isPlaying()) {
            C0();
        } else {
            D0();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void n0() {
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        if (getSupportActionBar() != null) {
            androidx.appcompat.app.a supportActionBar = getSupportActionBar();
            Intrinsics.e(supportActionBar);
            supportActionBar.l();
        }
        if (getActionBar() != null) {
            ActionBar actionBar = getActionBar();
            Intrinsics.e(actionBar);
            actionBar.hide();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void o0() {
        View decorView = getWindow().getDecorView();
        Intrinsics.g(decorView, "getDecorView(...)");
        decorView.setSystemUiVisibility(4102);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(VideoPreviewActivity videoPreviewActivity, View view) {
        videoPreviewActivity.l0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q0(VideoPreviewActivity videoPreviewActivity, View view) {
        Intrinsics.h(view, "it");
        jo.b bVar = new jo.b();
        bVar.o(1);
        bVar.n(2);
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = jo.b.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.postEvent(name, bVar, 0L);
        videoPreviewActivity.finish();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r0(VideoPreviewActivity videoPreviewActivity, View view) {
        Intrinsics.h(view, "it");
        VsMediaInfo vsMediaInfo = videoPreviewActivity.vsMediaInfo;
        if (vsMediaInfo != null) {
            if (vsMediaInfo.getVideoSize() > videoPreviewActivity.maxSize) {
                fh.b.a.e(Utils.a().getResources().getString(R$string.add_media_max_size_tips, 50));
                return Unit.a;
            }
            vsMediaInfo.setEnableSelect(!vsMediaInfo.getEnableSelect());
            PreviewVideoBean previewVideoBean = new PreviewVideoBean();
            previewVideoBean.setFrom(videoPreviewActivity.sourceType);
            previewVideoBean.setSelect(vsMediaInfo);
            if (vsMediaInfo.getEnableSelect()) {
                previewVideoBean.setOperator(1);
            } else {
                previewVideoBean.setOperator(3);
            }
            FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = PreviewVideoBean.class.getName();
            Intrinsics.g(name, "getName(...)");
            applicationScopeViewModel.postEvent(name, previewVideoBean, 0L);
            videoPreviewActivity.B0(vsMediaInfo.getEnableSelect());
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(VideoPreviewActivity videoPreviewActivity, View view) {
        videoPreviewActivity.l0();
    }

    private final void t0(String path) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(path);
        final Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L, 2);
        ((lo.g) getMViewBinding()).getRoot().post(new Runnable() { // from class: com.transsion.publish.ui.o1
            @Override // java.lang.Runnable
            public final void run() {
                VideoPreviewActivity.u0(VideoPreviewActivity.this, frameAtTime);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(VideoPreviewActivity videoPreviewActivity, Bitmap bitmap) {
        ((lo.g) videoPreviewActivity.getMViewBinding()).h.setImageBitmap(videoPreviewActivity.A0(bitmap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(VideoPreviewActivity videoPreviewActivity, View view) {
        videoPreviewActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(final VideoPreviewActivity videoPreviewActivity, MediaPlayer mediaPlayer) {
        if (mediaPlayer != null) {
            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.transsion.publish.ui.s1
                @Override // android.media.MediaPlayer.OnInfoListener
                public final boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                    boolean x0;
                    x0 = VideoPreviewActivity.x0(VideoPreviewActivity.this, mediaPlayer2, i, i2);
                    return x0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean x0(VideoPreviewActivity videoPreviewActivity, MediaPlayer mediaPlayer, int i, int i2) {
        if (i == 3) {
            ImageView imageView = ((lo.g) videoPreviewActivity.getMViewBinding()).h;
            Intrinsics.g(imageView, "coverIV");
            uf.c.g(imageView);
        }
        mediaPlayer.start();
        mediaPlayer.setLooping(true);
        ((lo.g) videoPreviewActivity.getMViewBinding()).q.setBackgroundColor(com.blankj.utilcode.util.h.a(R.color.transparent));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(VideoPreviewActivity videoPreviewActivity, View view) {
        Intrinsics.h(view, "it");
        PreviewMediaConfirmEvent previewMediaConfirmEvent = new PreviewMediaConfirmEvent(1);
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = PreviewMediaConfirmEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.postEvent(name, previewMediaConfirmEvent, 0L);
        videoPreviewActivity.finish();
        return Unit.a;
    }

    private final void z0(VsMediaInfo vsMediaInfo) {
        try {
            String videoPath = vsMediaInfo.getVideoPath();
            t0(videoPath);
            ((lo.g) getMViewBinding()).q.setVideoPath(videoPath);
        } catch (Exception e) {
            String message = e.getMessage();
            if (message != null) {
                a.a.g(wf.a.a, message, false, 2, (Object) null);
            }
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

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public lo.g getViewBinding() {
        lo.g c = lo.g.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public qi.b newLogViewConfig() {
        return new qi.b("video_preview", false, 2, null);
    }

    protected void onCreate(Bundle savedInstanceState) {
        n0();
        o0();
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    protected void onDestroy() {
        super.onDestroy();
        ProgressBar progressBar = ((lo.g) getMViewBinding()).f;
        Intrinsics.g(progressBar, "clipLoading");
        uf.c.g(progressBar);
    }

    public void onResume() {
        super.onResume();
        if (this.isBack) {
            this.isBack = false;
            VsMediaInfo vsMediaInfo = this.vsMediaInfo;
            Intrinsics.e(vsMediaInfo);
            z0(vsMediaInfo);
        }
    }

    protected void onStop() {
        super.onStop();
        this.isBack = true;
        C0();
    }
}
