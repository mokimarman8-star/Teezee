package com.transsion.moviedetail.music;

import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.activity.result.a;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Group;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.google.android.material.imageview.ShapeableImageView;
import com.therouter.TheRouter;
import com.tn.lib.util.networkinfo.NetworkType;
import com.tn.lib.view.SecondariesSeekBar;
import com.tn.lib.view.s;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.flow.bean.PreVideoAddress;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetail.music.MusicTrailerV2Fragment;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Trailer;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.e;
import com.transsion.player.orplayer.f;
import com.transsion.postdetail.R;
import com.transsion.postdetail.R$drawable;
import com.transsion.postdetail.util.m;
import f.i;
import java.util.LinkedHashMap;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import lm.j;
import ni.f;
import on.e0;
import qn.d;
import wf.a;
import yg.l;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 ~2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001MB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0005J\u0019\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\u0005J\u0019\u0010\u001e\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001e\u0010\u000eJ\u0017\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0006H\u0002¢\u0006\u0004\b#\u0010\u0005J\u0017\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u001aH\u0002¢\u0006\u0004\b%\u0010&J\r\u0010'\u001a\u00020\u0006¢\u0006\u0004\b'\u0010\u0005J\u000f\u0010(\u001a\u00020\u0006H\u0016¢\u0006\u0004\b(\u0010\u0005J\u0017\u0010+\u001a\u00020\u00022\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0012H\u0016¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u000bH\u0016¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0006H\u0016¢\u0006\u0004\b1\u0010\u0005J\u000f\u00102\u001a\u00020\u0006H\u0016¢\u0006\u0004\b2\u0010\u0005J\u000f\u00103\u001a\u00020\u0006H\u0016¢\u0006\u0004\b3\u0010\u0005J\u000f\u00104\u001a\u00020\u0006H\u0016¢\u0006\u0004\b4\u0010\u0005J\u000f\u00105\u001a\u00020\u0006H\u0016¢\u0006\u0004\b5\u0010\u0005J\u000f\u00106\u001a\u00020\u0006H\u0016¢\u0006\u0004\b6\u0010\u0005J\u000f\u00107\u001a\u00020\u0006H\u0016¢\u0006\u0004\b7\u0010\u0005J\u000f\u00108\u001a\u00020\u0006H\u0016¢\u0006\u0004\b8\u0010\u0005J\u000f\u00109\u001a\u00020\u0006H\u0016¢\u0006\u0004\b9\u0010\u0005J\u0019\u0010<\u001a\u00020\u00062\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\b<\u0010=J\u0019\u0010>\u001a\u00020\u00062\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\b>\u0010=J!\u0010@\u001a\u00020\u00062\u0006\u0010?\u001a\u00020\u001f2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\b@\u0010AJ\u0019\u0010B\u001a\u00020\u00062\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\bB\u0010=J\u000f\u0010C\u001a\u00020\u0006H\u0016¢\u0006\u0004\bC\u0010\u0005J!\u0010D\u001a\u00020\u00062\u0006\u0010?\u001a\u00020\u001f2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\bD\u0010AJ\u0019\u0010E\u001a\u00020\u00062\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\bE\u0010=J\u0019\u0010F\u001a\u00020\u00062\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\bF\u0010=J\u0019\u0010G\u001a\u00020\u00062\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\bG\u0010=J!\u0010J\u001a\u00020\u00062\u0006\u0010I\u001a\u00020H2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\bJ\u0010KR\u0018\u0010O\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010R\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010U\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010X\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010Z\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010QR\u0016\u0010\\\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010QR\u0018\u0010I\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010b\u001a\u0004\u0018\u00010_8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010f\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u001b\u0010l\u001a\u00020g8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bh\u0010i\u001a\u0004\bj\u0010kR\u0014\u0010p\u001a\u00020m8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010oR\u001c\u0010t\u001a\b\u0012\u0004\u0012\u00020\u00120q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010v\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010WR\u0014\u0010x\u001a\u00020m8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010oR\"\u0010}\u001a\u0010\u0012\f\u0012\n z*\u0004\u0018\u00010\u00120\u00120y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b{\u0010|¨\u0006\u007f"}, d2 = {"Lcom/transsion/moviedetail/music/MusicTrailerV2Fragment;", "Lcom/transsion/baseui/fragment/PageStatusFragment;", "Llm/j;", "Lcom/transsion/player/orplayer/e;", "<init>", "()V", BuildConfig.FLAVOR, "Q0", "D0", "K0", "H0", BuildConfig.FLAVOR, "isPlay", "I0", "(Z)V", "Lcom/transsion/player/mediasession/MediaItem;", "y0", "()Lcom/transsion/player/mediasession/MediaItem;", BuildConfig.FLAVOR, "pageName", "Landroid/content/Intent;", "w0", "(Ljava/lang/String;)Landroid/content/Intent;", "Landroid/app/PendingIntent;", "z0", "()Landroid/app/PendingIntent;", BuildConfig.FLAVOR, "A0", "()I", "L0", "S0", BuildConfig.FLAVOR, "delay", "O0", "(J)V", "E0", "type", "N0", "(I)V", "v0", "receiveArguments", "Landroid/view/LayoutInflater;", "inflater", "B0", "(Landroid/view/LayoutInflater;)Llm/j;", "getPageStateLayoutTitle", "()Ljava/lang/String;", "isShowPageStateLayoutTitle", "()Z", "initViewData", "initViewModel", "initListener", "loadDefaultData", "onDestroy", "onResume", "onStop", "retryLoadData", "onDisconnected", "Lgn/e;", "mediaSource", "onPrepare", "(Lgn/e;)V", "onLoadingBegin", "progress", "onBufferedPosition", "(JLgn/e;)V", "onLoadingEnd", "onRenderFirstFrame", "onProgress", "onVideoStart", "onVideoPause", "onCompletion", "Lcom/transsion/player/orplayer/PlayError;", "errorInfo", "onPlayError", "(Lcom/transsion/player/orplayer/PlayError;Lgn/e;)V", "Lcom/transsion/moviedetailapi/bean/Trailer;", "a", "Lcom/transsion/moviedetailapi/bean/Trailer;", "trailer", "b", "J", "duration", "c", "Z", "formUserSeek", "d", "I", "playState", "e", "bufferPosition", "f", "currentPosition", "g", "Lcom/transsion/player/orplayer/PlayError;", "Landroid/view/View;", "h", "Landroid/view/View;", "errorLayout", "Lcom/transsion/player/orplayer/f;", "i", "Lcom/transsion/player/orplayer/f;", "orPlayer", "Landroid/os/Handler;", "j", "Lkotlin/Lazy;", "x0", "()Landroid/os/Handler;", "loadingHandler", "Ljava/lang/Runnable;", "k", "Ljava/lang/Runnable;", "showErrorRunnable", BuildConfig.FLAVOR, "l", "[Ljava/lang/String;", "loadingDot", "m", "loadingDotIndex", "n", "loadingRunnable", "Landroidx/activity/result/b;", "kotlin.jvm.PlatformType", "o", "Landroidx/activity/result/b;", "requestPermissionLauncher", "p", "MovieDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class MusicTrailerV2Fragment extends PageStatusFragment<j> implements e {

    /* renamed from: a, reason: from kotlin metadata */
    private Trailer trailer;

    /* renamed from: b, reason: from kotlin metadata */
    private long duration;

    /* renamed from: c, reason: from kotlin metadata */
    private boolean formUserSeek;

    /* renamed from: d, reason: from kotlin metadata */
    private int playState;

    /* renamed from: e, reason: from kotlin metadata */
    private long bufferPosition;

    /* renamed from: f, reason: from kotlin metadata */
    private long currentPosition;

    /* renamed from: g, reason: from kotlin metadata */
    private PlayError errorInfo;

    /* renamed from: h, reason: from kotlin metadata */
    private View errorLayout;

    /* renamed from: i, reason: from kotlin metadata */
    private f orPlayer;

    /* renamed from: m, reason: from kotlin metadata */
    private int loadingDotIndex;

    /* renamed from: o, reason: from kotlin metadata */
    private final androidx.activity.result.b requestPermissionLauncher;

    /* renamed from: j, reason: from kotlin metadata */
    private final Lazy loadingHandler = LazyKt.b(new Function0() { // from class: nm.b
        public final Object invoke() {
            Handler F0;
            F0 = MusicTrailerV2Fragment.F0();
            return F0;
        }
    });

    /* renamed from: k, reason: from kotlin metadata */
    private final Runnable showErrorRunnable = new Runnable() { // from class: nm.c
        @Override // java.lang.Runnable
        public final void run() {
            MusicTrailerV2Fragment.P0(MusicTrailerV2Fragment.this);
        }
    };

    /* renamed from: l, reason: from kotlin metadata */
    private String[] loadingDot = {".", "..", "..."};

    /* renamed from: n, reason: from kotlin metadata */
    private final Runnable loadingRunnable = new Runnable() { // from class: nm.d
        @Override // java.lang.Runnable
        public final void run() {
            MusicTrailerV2Fragment.G0(MusicTrailerV2Fragment.this);
        }
    };

    public static final class b implements View.OnClickListener {
        private long a;

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MusicTrailerV2Fragment.this.playState != 10) {
                MusicTrailerV2Fragment.this.K0();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.a;
            if (j == 0 || currentTimeMillis - j > 500) {
                this.a = currentTimeMillis;
            } else {
                this.a = 0L;
                MusicTrailerV2Fragment.this.H0();
            }
        }
    }

    public static final class c implements s {
        private long a;

        c() {
        }

        public void a(SecondariesSeekBar secondariesSeekBar) {
            Group group;
            Intrinsics.h(secondariesSeekBar, "seekBar");
            MusicTrailerV2Fragment.this.formUserSeek = false;
            j jVar = (j) MusicTrailerV2Fragment.this.getMViewBinding();
            if (jVar != null && (group = jVar.b) != null) {
                group.setVisibility(0);
            }
            f fVar = MusicTrailerV2Fragment.this.orPlayer;
            if (fVar != null) {
                fVar.seekTo((this.a * MusicTrailerV2Fragment.this.duration) / 100);
            }
        }

        public void b(SecondariesSeekBar secondariesSeekBar, long j, boolean z) {
            Intrinsics.h(secondariesSeekBar, "seekBar");
            if (z) {
                this.a = j;
            }
        }

        public void c(SecondariesSeekBar secondariesSeekBar) {
            Intrinsics.h(secondariesSeekBar, "seekBar");
            MusicTrailerV2Fragment.this.formUserSeek = true;
        }
    }

    public MusicTrailerV2Fragment() {
        androidx.activity.result.b registerForActivityResult = registerForActivityResult(new i(), new a() { // from class: nm.e
            public final void a(Object obj) {
                MusicTrailerV2Fragment.M0((Boolean) obj);
            }
        });
        Intrinsics.g(registerForActivityResult, "registerForActivityResult(...)");
        this.requestPermissionLauncher = registerForActivityResult;
    }

    private final int A0() {
        return Build.VERSION.SDK_INT >= 31 ? 67108864 : 134217728;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(MusicTrailerV2Fragment musicTrailerV2Fragment, View view) {
        musicTrailerV2Fragment.K0();
    }

    private final void D0() {
        SecondariesSeekBar secondariesSeekBar;
        j jVar = (j) getMViewBinding();
        if (jVar == null || (secondariesSeekBar = jVar.k) == null) {
            return;
        }
        secondariesSeekBar.setOnSeekBarChangeListener(new c());
    }

    private final void E0() {
        x0().postDelayed(this.loadingRunnable, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler F0() {
        Looper myLooper = Looper.myLooper();
        Intrinsics.e(myLooper);
        return new Handler(myLooper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(MusicTrailerV2Fragment musicTrailerV2Fragment) {
        TextView textView;
        int i = musicTrailerV2Fragment.loadingDotIndex;
        if (i >= 2) {
            musicTrailerV2Fragment.loadingDotIndex = 0;
        } else {
            musicTrailerV2Fragment.loadingDotIndex = i + 1;
        }
        j jVar = (j) musicTrailerV2Fragment.getMViewBinding();
        if (jVar != null && (textView = jVar.h) != null) {
            textView.setText(Utils.a().getString(R.string.play_loading) + musicTrailerV2Fragment.loadingDot[musicTrailerV2Fragment.loadingDotIndex]);
        }
        musicTrailerV2Fragment.E0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H0() {
        this.playState = 20;
        f fVar = this.orPlayer;
        if (fVar != null) {
            fVar.pause();
        }
    }

    private final void I0(boolean isPlay) {
        this.playState = 10;
        S0(isPlay);
    }

    static /* synthetic */ void J0(MusicTrailerV2Fragment musicTrailerV2Fragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        musicTrailerV2Fragment.I0(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K0() {
        PreVideoAddress videoAddress;
        String url;
        int i = this.playState;
        if (i == -1) {
            L0();
            return;
        }
        if (i != 0) {
            if (i == 10) {
                H0();
                return;
            } else if (i == 20 || i == 22) {
                J0(this, false, 1, null);
                return;
            } else if (i != 30) {
                return;
            }
        }
        f fVar = this.orPlayer;
        if (fVar != null) {
            Trailer trailer = this.trailer;
            if (trailer != null && (videoAddress = trailer.getVideoAddress()) != null && (url = videoAddress.getUrl()) != null) {
                Trailer trailer2 = this.trailer;
                fVar.setDataSource(new gn.e(trailer2 != null ? trailer2.getSubjectId() : null, url, 0, null, y0(), 12, null));
            }
            fVar.prepare();
        }
        I0(false);
    }

    private final void L0() {
        a.a.g(wf.a.a, "MusicTrailerV2Fragment --> reloadVideo() --> video error，reload~~", false, 2, (Object) null);
        this.bufferPosition = 0L;
        f fVar = this.orPlayer;
        if (fVar != null) {
            fVar.stop();
            fVar.reset();
            fVar.prepare();
        }
        f fVar2 = this.orPlayer;
        if (fVar2 != null) {
            fVar2.seekTo(this.currentPosition);
        }
        T0(this, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(Boolean bool) {
        Intrinsics.h(bool, "granted");
        if (bool.booleanValue()) {
            a.a.g(wf.a.a, "User allow the permission.", false, 2, (Object) null);
        } else {
            a.a.g(wf.a.a, "User deny the permission.", false, 2, (Object) null);
        }
    }

    private final void N0(int type) {
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        Group group;
        ShapeableImageView shapeableImageView;
        ShapeableImageView shapeableImageView2;
        ViewStub viewStub;
        if (this.errorLayout == null) {
            j jVar = (j) getMViewBinding();
            this.errorLayout = (jVar == null || (viewStub = jVar.m) == null) ? null : viewStub.inflate();
        }
        if (type == 1) {
            Intrinsics.g(Utils.a().getString(R.string.downloading_play_timeout), "getString(...)");
            Intrinsics.g(Utils.a().getString(R.string.downloading_play_timeout_reload), "getString(...)");
            this.playState = -1;
        } else {
            Intrinsics.g(Utils.a().getString(R.string.downloading_play_load_failed), "getString(...)");
            Intrinsics.g(Utils.a().getString(R.string.turn_on_network), "getString(...)");
            this.playState = 22;
        }
        f fVar = this.orPlayer;
        if (fVar != null) {
            fVar.pause();
        }
        j jVar2 = (j) getMViewBinding();
        if (jVar2 != null && (shapeableImageView2 = jVar2.d) != null) {
            uf.c.k(shapeableImageView2);
        }
        j jVar3 = (j) getMViewBinding();
        if (jVar3 != null && (shapeableImageView = jVar3.e) != null) {
            uf.c.g(shapeableImageView);
        }
        j jVar4 = (j) getMViewBinding();
        if (jVar4 != null && (group = jVar4.b) != null) {
            uf.c.g(group);
        }
        View view = this.errorLayout;
        if (view != null) {
            uf.c.k(view);
        }
        View view2 = this.errorLayout;
        if (view2 != null) {
            view2.setTag(Integer.valueOf(type));
        }
        j jVar5 = (j) getMViewBinding();
        if (jVar5 != null && (appCompatImageView2 = jVar5.j) != null) {
            appCompatImageView2.setImageResource(R$drawable.post_icon_play);
        }
        j jVar6 = (j) getMViewBinding();
        if (jVar6 == null || (appCompatImageView = jVar6.j) == null) {
            return;
        }
        appCompatImageView.setKeepScreenOn(false);
    }

    private final void O0(long delay) {
        x0().removeCallbacks(this.showErrorRunnable);
        x0().postDelayed(this.showErrorRunnable, delay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(MusicTrailerV2Fragment musicTrailerV2Fragment) {
        musicTrailerV2Fragment.N0(0);
    }

    private final void Q0() {
        ShapeableImageView shapeableImageView;
        String str;
        Cover cover;
        Cover cover2;
        String thumbnail;
        TextView textView;
        PreVideoAddress videoAddress;
        Integer duration;
        SecondariesSeekBar secondariesSeekBar;
        if (!isAdded() || getActivity() == null) {
            return;
        }
        j jVar = (j) getMViewBinding();
        if (jVar != null && (secondariesSeekBar = jVar.k) != null) {
            secondariesSeekBar.setMax(100L);
        }
        Trailer trailer = this.trailer;
        long intValue = (trailer == null || (videoAddress = trailer.getVideoAddress()) == null || (duration = videoAddress.getDuration()) == null) ? 0L : duration.intValue() * 1000;
        this.duration = intValue;
        if (intValue > 0) {
            String str2 = "00:00/" + m.d(intValue);
            j jVar2 = (j) getMViewBinding();
            if (jVar2 != null && (textView = jVar2.l) != null) {
                textView.setText(str2);
            }
        }
        Trailer trailer2 = this.trailer;
        com.transsion.base.image.blurhash.e.d(com.transsion.base.image.blurhash.e.a, (trailer2 == null || (cover2 = trailer2.getCover()) == null || (thumbnail = cover2.getThumbnail()) == null) ? BuildConfig.FLAVOR : thumbnail, 0, 0, new Function1() { // from class: nm.a
            public final Object invoke(Object obj) {
                Unit R0;
                R0 = MusicTrailerV2Fragment.R0(MusicTrailerV2Fragment.this, (BitmapDrawable) obj);
                return R0;
            }
        }, 6, null);
        j jVar3 = (j) getMViewBinding();
        if (jVar3 == null || (shapeableImageView = jVar3.e) == null) {
            return;
        }
        shapeableImageView.setVisibility(0);
        RequestManager with = Glide.with(requireContext());
        f.a aVar = ni.f.a;
        Trailer trailer3 = this.trailer;
        if (trailer3 == null || (cover = trailer3.getCover()) == null || (str = cover.getUrl()) == null) {
            str = BuildConfig.FLAVOR;
        }
        with.load(f.a.e(aVar, str, com.transsion.core.utils.e.f(), false, false, 12, null)).into(shapeableImageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R0(MusicTrailerV2Fragment musicTrailerV2Fragment, BitmapDrawable bitmapDrawable) {
        ShapeableImageView shapeableImageView;
        Intrinsics.h(bitmapDrawable, "it");
        j jVar = (j) musicTrailerV2Fragment.getMViewBinding();
        if (jVar != null && (shapeableImageView = jVar.d) != null) {
            shapeableImageView.setImageDrawable(bitmapDrawable);
        }
        return Unit.a;
    }

    private final void S0(boolean isPlay) {
        AppCompatImageView appCompatImageView;
        Group group;
        AppCompatImageView appCompatImageView2;
        Group group2;
        com.transsion.player.orplayer.f fVar;
        this.playState = 10;
        this.errorInfo = null;
        if (isPlay && (fVar = this.orPlayer) != null) {
            fVar.play();
        }
        j jVar = (j) getMViewBinding();
        if (jVar != null && (group2 = jVar.b) != null) {
            uf.c.k(group2);
        }
        View view = this.errorLayout;
        if (view != null) {
            uf.c.g(view);
        }
        j jVar2 = (j) getMViewBinding();
        if (jVar2 != null && (appCompatImageView2 = jVar2.f) != null) {
            uf.c.g(appCompatImageView2);
        }
        j jVar3 = (j) getMViewBinding();
        if (jVar3 != null && (group = jVar3.c) != null) {
            uf.c.k(group);
        }
        j jVar4 = (j) getMViewBinding();
        if (jVar4 != null && (appCompatImageView = jVar4.j) != null) {
            appCompatImageView.setImageResource(R$drawable.post_icon_pause);
        }
        x0().removeCallbacks(this.showErrorRunnable);
        Q0();
    }

    static /* synthetic */ void T0(MusicTrailerV2Fragment musicTrailerV2Fragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        musicTrailerV2Fragment.S0(z);
    }

    private final Intent w0(String pageName) {
        to.a aVar = (to.a) TheRouter.d(to.a.class, new Object[0]);
        StringBuilder sb = new StringBuilder("oneroom://com.community.oneroom?type=");
        sb.append("/movie/detail");
        sb.append("&");
        sb.append("id");
        sb.append("=");
        Trailer trailer = this.trailer;
        sb.append(trailer != null ? trailer.getSubjectId() : null);
        sb.append("&");
        sb.append("subject_type");
        sb.append("=");
        Trailer trailer2 = this.trailer;
        sb.append(trailer2 != null ? Integer.valueOf(trailer2.getSubjectType()) : null);
        sb.append("extra_page_from");
        sb.append("=");
        sb.append(pageName);
        if (aVar == null) {
            return null;
        }
        Application a = Utils.a();
        Intrinsics.g(a, "getApp(...)");
        Intent a2 = aVar.a(a);
        if (a2 == null) {
            return null;
        }
        a2.addFlags(603979776);
        a2.setData(Uri.parse(sb.toString()));
        return a2;
    }

    private final Handler x0() {
        return (Handler) this.loadingHandler.getValue();
    }

    private final MediaItem y0() {
        PreVideoAddress videoAddress;
        Cover cover;
        Trailer trailer = this.trailer;
        String str = null;
        String musicName = trailer != null ? trailer.getMusicName() : null;
        Trailer trailer2 = this.trailer;
        String url = (trailer2 == null || (cover = trailer2.getCover()) == null) ? null : cover.getUrl();
        Trailer trailer3 = this.trailer;
        if (trailer3 != null && (videoAddress = trailer3.getVideoAddress()) != null) {
            str = videoAddress.getUrl();
        }
        return new MediaItem(musicName, BuildConfig.FLAVOR, url, null, null, null, z0(), w0("media_music_float_notification"), null, str, Boolean.TRUE, null, null, null, 14648, null);
    }

    private final PendingIntent z0() {
        return PendingIntent.getActivity(Utils.a(), 0, w0("media_notification"), A0());
    }

    /* renamed from: B0, reason: merged with bridge method [inline-methods] */
    public j getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        j c2 = j.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }

    @Override // com.transsion.player.orplayer.e
    public void canNonSubscriberPlay(boolean z, int i, int i2, d dVar) {
        e.a.a(this, z, i, i2, dVar);
    }

    public String getPageStateLayoutTitle() {
        return BuildConfig.FLAVOR;
    }

    public void initListener() {
        com.transsion.player.orplayer.f fVar;
        D0();
        j jVar = (j) getMViewBinding();
        if (jVar != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: nm.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MusicTrailerV2Fragment.C0(MusicTrailerV2Fragment.this, view);
                }
            };
            jVar.f.setOnClickListener(onClickListener);
            jVar.j.setOnClickListener(onClickListener);
            jVar.i.setOnClickListener(new b());
            if (NetworkType.NETWORK_WIFI != l.a.d() || (fVar = this.orPlayer) == null || fVar.isPlaying()) {
                return;
            }
            K0();
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void initPlayer() {
        e.a.b(this);
    }

    public void initViewData() {
        String subjectId;
        v0();
        Trailer trailer = this.trailer;
        if (trailer == null || (subjectId = trailer.getSubjectId()) == null) {
            return;
        }
        e0 e0Var = e0.a;
        com.transsion.player.orplayer.f d = e0Var.d(subjectId);
        if (d == null) {
            d = e0Var.m();
        } else if (d.isPlaying()) {
            S0(false);
        }
        d.addPlayerListener(this);
        this.orPlayer = d;
    }

    public void initViewModel() {
    }

    public boolean isShowPageStateLayoutTitle() {
        return false;
    }

    public void loadDefaultData() {
        super.loadDefaultData();
        Q0();
    }

    @Override // com.transsion.player.orplayer.e
    public void onAliyunDecodeErrorChangeSoftwareDecoder(gn.e eVar) {
        e.a.c(this, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onBufferedPosition(long progress, gn.e mediaSource) {
        SecondariesSeekBar secondariesSeekBar;
        e.a.d(this, progress, mediaSource);
        if (this.bufferPosition >= progress || this.duration <= 0) {
            return;
        }
        this.bufferPosition = progress;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(0, Integer.valueOf((int) ((progress * 100) / this.duration)));
        j jVar = (j) getMViewBinding();
        if (jVar == null || (secondariesSeekBar = jVar.k) == null) {
            return;
        }
        secondariesSeekBar.setSecondariesProgress(linkedHashMap);
    }

    @Override // com.transsion.player.orplayer.e
    public void onCompletion(gn.e mediaSource) {
        e.a.e(this, mediaSource);
        a.a.g(wf.a.a, "MusicTrailerV2Fragment --> onCompletion()", false, 2, (Object) null);
        j jVar = (j) getMViewBinding();
        if (jVar != null) {
            this.currentPosition = 0L;
            this.playState = 30;
            AppCompatImageView appCompatImageView = jVar.f;
            Intrinsics.g(appCompatImageView, "ivPlay");
            uf.c.k(appCompatImageView);
            jVar.j.setImageResource(R$drawable.post_icon_play);
            Group group = jVar.c;
            Intrinsics.g(group, "groupProgress");
            uf.c.g(group);
            ShapeableImageView shapeableImageView = jVar.e;
            Intrinsics.g(shapeableImageView, "ivMovieCover");
            uf.c.k(shapeableImageView);
            ShapeableImageView shapeableImageView2 = jVar.d;
            Intrinsics.g(shapeableImageView2, "ivMovieBlurCover");
            uf.c.k(shapeableImageView2);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        com.transsion.player.orplayer.f fVar = this.orPlayer;
        if (fVar != null) {
            fVar.removePlayerListener(this);
        }
    }

    public void onDisconnected() {
        com.transsion.player.orplayer.f fVar;
        a.a.g(wf.a.a, "MusicTrailerV2Fragment --> onDisconnected()", false, 2, (Object) null);
        if (this.playState != 10 || (fVar = this.orPlayer) == null || fVar.isPlaying()) {
            return;
        }
        O0(500L);
    }

    @Override // com.transsion.player.orplayer.e
    public void onFocusChange(boolean z) {
        e.a.g(this, z);
    }

    @Override // com.transsion.player.orplayer.e
    public void onIsPlayingChanged(boolean z) {
        e.a.h(this, z);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingBegin(gn.e mediaSource) {
        Group group;
        e.a.i(this, mediaSource);
        a.a.g(wf.a.a, "MusicTrailerV2Fragment --> onLoadingBegin()", false, 2, (Object) null);
        if (!l.a.e()) {
            O0(1000L);
            return;
        }
        j jVar = (j) getMViewBinding();
        if (jVar != null && (group = jVar.b) != null) {
            uf.c.k(group);
        }
        x0().post(this.loadingRunnable);
        View view = this.errorLayout;
        if (view != null) {
            uf.c.g(view);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingEnd(gn.e mediaSource) {
        Group group;
        e.a.k(this, mediaSource);
        a.a.g(wf.a.a, "MusicTrailerV2Fragment --> onLoadingEnd()", false, 2, (Object) null);
        j jVar = (j) getMViewBinding();
        if (jVar != null && (group = jVar.b) != null) {
            uf.c.g(group);
        }
        View view = this.errorLayout;
        if (view != null) {
            uf.c.g(view);
        }
        x0().removeCallbacks(this.loadingRunnable);
        x0().removeCallbacks(this.showErrorRunnable);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingProgress(int i, float f, gn.e eVar) {
        e.a.m(this, i, f, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoopingStart() {
        e.a.o(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onMediaItemTransition(String str) {
        e.a.p(this, str);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayError(PlayError errorInfo, gn.e mediaSource) {
        Intrinsics.h(errorInfo, "errorInfo");
        e.a.q(this, errorInfo, mediaSource);
        a.a.g(wf.a.a, "MusicTrailerV2Fragment --> onPlayError() --> errorInfo.errorCode = " + errorInfo.getErrorCode(), false, 2, (Object) null);
        Integer errorCode = errorInfo.getErrorCode();
        if (errorCode != null && errorCode.intValue() == 537067524) {
            if (l.a.e()) {
                N0(1);
            } else {
                O0(500L);
            }
        }
        this.errorInfo = errorInfo;
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerRelease(gn.e eVar) {
        e.a.t(this, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerReset() {
        e.a.v(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPrepare(gn.e mediaSource) {
        e.a.w(this, mediaSource);
        com.transsion.player.orplayer.f fVar = this.orPlayer;
        if (fVar != null) {
            fVar.play();
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onProgress(long progress, gn.e mediaSource) {
        SecondariesSeekBar secondariesSeekBar;
        TextView textView;
        com.transsion.player.orplayer.f fVar;
        Group group;
        e.a.y(this, progress, mediaSource);
        j jVar = (j) getMViewBinding();
        if (jVar != null && (group = jVar.b) != null) {
            group.setVisibility(8);
        }
        if (this.formUserSeek) {
            return;
        }
        this.currentPosition = progress;
        if (this.duration <= 0 && (fVar = this.orPlayer) != null) {
            this.duration = fVar.getDuration();
        }
        String str = m.d(progress) + "/" + m.d(this.duration);
        j jVar2 = (j) getMViewBinding();
        if (jVar2 != null && (textView = jVar2.l) != null) {
            textView.setText(str);
        }
        j jVar3 = (j) getMViewBinding();
        if (jVar3 == null || (secondariesSeekBar = jVar3.k) == null) {
            return;
        }
        secondariesSeekBar.setProgress((progress * 100) / this.duration);
    }

    @Override // com.transsion.player.orplayer.e
    public void onRenderFirstFrame() {
        e.a.A(this);
        a.a.g(wf.a.a, "MusicTrailerV2Fragment --> onRenderFirstFrame()", false, 2, (Object) null);
    }

    public void onResume() {
        super.onResume();
    }

    @Override // com.transsion.player.orplayer.e
    public void onSetDataSource() {
        e.a.B(this);
    }

    public void onStop() {
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        super/*androidx.fragment.app.Fragment*/.onStop();
        Activity b2 = com.blankj.utilcode.util.a.b();
        a.a.g(wf.a.a, "zxb_lob --> topActivity = " + b2, false, 2, (Object) null);
        if (b2 != null) {
            String simpleName = b2.getClass().getSimpleName();
            Intrinsics.g(simpleName, "getSimpleName(...)");
            if (StringsKt.c0(simpleName, "LocalVideoDetailActivity", false, 2, (Object) null)) {
                this.playState = 0;
                j jVar = (j) getMViewBinding();
                if (jVar != null && (appCompatImageView2 = jVar.j) != null) {
                    appCompatImageView2.setImageResource(R$drawable.post_icon_play);
                }
                j jVar2 = (j) getMViewBinding();
                if (jVar2 == null || (appCompatImageView = jVar2.j) == null) {
                    return;
                }
                appCompatImageView.setKeepScreenOn(false);
            }
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksAudioBitrateChange(int i) {
        e.a.C(this, i);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksChange(qn.c cVar) {
        e.a.D(this, cVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksVideoBitrateChange(int i) {
        e.a.E(this, i);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoPause(gn.e mediaSource) {
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        e.a.F(this, mediaSource);
        a.a.g(wf.a.a, "MusicTrailerV2Fragment --> onVideoPause()", false, 2, (Object) null);
        this.playState = 20;
        j jVar = (j) getMViewBinding();
        if (jVar != null && (appCompatImageView2 = jVar.j) != null) {
            appCompatImageView2.setImageResource(R$drawable.post_icon_play);
        }
        j jVar2 = (j) getMViewBinding();
        if (jVar2 == null || (appCompatImageView = jVar2.j) == null) {
            return;
        }
        appCompatImageView.setKeepScreenOn(false);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoSizeChanged(int i, int i2) {
        e.a.H(this, i, i2);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoStart(gn.e mediaSource) {
        e.a.I(this, mediaSource);
        a.a.g(wf.a.a, "MusicTrailerV2Fragment --> onVideoStart()", false, 2, (Object) null);
        j jVar = (j) getMViewBinding();
        if (jVar != null) {
            Group group = jVar.b;
            Intrinsics.g(group, "groupLoading");
            uf.c.g(group);
            jVar.j.setImageResource(R$drawable.post_icon_pause);
            jVar.j.setKeepScreenOn(true);
            S0(false);
        }
    }

    public void receiveArguments() {
        Bundle arguments = getArguments();
        Trailer trailer = (Trailer) (arguments != null ? arguments.getSerializable("trailer") : null);
        this.trailer = trailer;
        com.transsion.player.mediasession.i.a.a("MusicTrailerV2Fragment --> receiveArguments() --> trailer = " + trailer);
    }

    public void retryLoadData() {
        int i;
        a.a.g(wf.a.a, "MusicTrailerV2Fragment --> retryLoadData()", false, 2, (Object) null);
        Q0();
        View view = this.errorLayout;
        if (view == null || view.getVisibility() != 0 || (i = this.playState) == 20 || i == 21) {
            return;
        }
        T0(this, false, 1, null);
    }

    @Override // com.transsion.player.orplayer.e
    public void setOnSeekCompleteListener() {
        e.a.K(this);
    }

    public final void v0() {
    }
}
