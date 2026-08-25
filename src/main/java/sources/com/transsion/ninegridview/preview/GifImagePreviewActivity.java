package com.transsion.ninegridview.preview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.y;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.tn.lib.widget.dialog.TRDialog;
import com.tn.lib.widget.dialog.TRDialogListener;
import com.transsion.baseui.R;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.GifBean;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.ninegridview.R$string;
import com.transsion.ninegridview.helper.FileHelper;
import com.transsion.ninegridview.preview.GifImagePreviewActivity;
import com.transsion.player.config.RenderType;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.e;
import com.transsion.player.orplayer.f;
import com.transsion.player.p003enum.ScaleMode;
import com.transsion.player.ui.ORPlayerView;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000¹\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0006*\u0001g\u0018\u0000 j2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001kB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0005J#\u0010\u000f\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0011\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0005J\u000f\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0005J\u000f\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0005J\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b!\u0010 J\u0019\u0010$\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\"H\u0014¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0002H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b)\u0010*J\r\u0010+\u001a\u00020\u0006¢\u0006\u0004\b+\u0010\u0005J/\u00102\u001a\u00020\u00062\u0006\u0010-\u001a\u00020,2\u000e\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0.2\u0006\u00101\u001a\u000200H\u0016¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020(H\u0016¢\u0006\u0004\b4\u0010*J\u000f\u00105\u001a\u00020\u0006H\u0016¢\u0006\u0004\b5\u0010\u0005J\u000f\u00106\u001a\u00020\u0006H\u0016¢\u0006\u0004\b6\u0010\u0005J\u000f\u00107\u001a\u00020\u0006H\u0016¢\u0006\u0004\b7\u0010\u0005J\u000f\u00108\u001a\u00020\u0006H\u0014¢\u0006\u0004\b8\u0010\u0005J\u0017\u0010;\u001a\u00020\u00062\u0006\u0010:\u001a\u000209H\u0016¢\u0006\u0004\b;\u0010<J\u0017\u0010=\u001a\u00020\u00062\u0006\u0010:\u001a\u000209H\u0016¢\u0006\u0004\b=\u0010<J%\u0010B\u001a\u00020,2\u0006\u0010?\u001a\u00020>2\u0006\u0010@\u001a\u00020,2\u0006\u0010A\u001a\u00020,¢\u0006\u0004\bB\u0010CJ%\u0010E\u001a\u00020>2\u0006\u0010?\u001a\u00020>2\u0006\u0010@\u001a\u00020D2\u0006\u0010A\u001a\u00020D¢\u0006\u0004\bE\u0010FJ%\u0010G\u001a\u00020,2\u0006\u0010?\u001a\u00020>2\u0006\u0010@\u001a\u00020,2\u0006\u0010A\u001a\u00020,¢\u0006\u0004\bG\u0010CJ\u000f\u0010I\u001a\u00020HH\u0016¢\u0006\u0004\bI\u0010JR\u0014\u0010K\u001a\u00020,8\u0002X\u0082D¢\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010N\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u001e\u0010R\u001a\n\u0012\u0004\u0012\u00020Q\u0018\u00010P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010T\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010V\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010LR\u0016\u0010W\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010LR\u0016\u0010X\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010LR\u0016\u0010Y\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010LR\u0016\u0010Z\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010LR\u0018\u0010\\\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010_\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0014\u0010b\u001a\u00020a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010d\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010f\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010eR\u0014\u0010h\u001a\u00020g8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010i¨\u0006l"}, d2 = {"Lcom/transsion/ninegridview/preview/GifImagePreviewActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Lum/a;", "Lcom/tn/lib/widget/dialog/TRDialogListener;", "<init>", "()V", BuildConfig.FLAVOR, "initView", "startEnterTheAnimation", "downloadImage", "showPageIndex", "Ljava/io/File;", "file", BuildConfig.FLAVOR, "url", "saveToAlbum", "(Ljava/io/File;Ljava/lang/String;)V", "getNameFromUrl", "(Ljava/lang/String;)Ljava/lang/String;", "requestPermission", "showSettingDialog", "initPlayer", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "Landroid/widget/ImageView;", "imageView", "computeImageWidthAndHeight", "(Landroid/widget/ImageView;)V", "Landroid/animation/ValueAnimator;", "valueAnimator", "addIntoListener", "(Landroid/animation/ValueAnimator;)V", "addOutListener", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "getViewBinding", "()Lum/a;", BuildConfig.FLAVOR, "isTranslucent", "()Z", "finishActivityAnim", BuildConfig.FLAVOR, "requestCode", BuildConfig.FLAVOR, "permissions", BuildConfig.FLAVOR, "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "isAttach", "onBackPressed", "onResume", "onPause", "onDestroy", "Lcom/tn/lib/widget/dialog/TRDialog;", "dialog", "onLeftButtonClick", "(Lcom/tn/lib/widget/dialog/TRDialog;)V", "onRightButtonClick", BuildConfig.FLAVOR, "fraction", "startValue", "endValue", "evaluateInt", "(FII)I", BuildConfig.FLAVOR, "evaluateFloat", "(FLjava/lang/Number;Ljava/lang/Number;)F", "evaluateArgb", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "REQUEST_PERMISSION_STORAGE", "I", "Lcom/transsion/ninegridview/preview/c;", "imagePreviewAdapter", "Lcom/transsion/ninegridview/preview/c;", BuildConfig.FLAVOR, "Lcom/transsion/moviedetailapi/bean/Image;", "imageList", "Ljava/util/List;", "isBuiltInApp", "Ljava/lang/Boolean;", "currentItemIndex", "imageHeight", "imageWidth", "screenWidth", "screenHeight", "Lcom/transsion/player/orplayer/f;", "mPlayer", "Lcom/transsion/player/orplayer/f;", "Lcom/transsion/ninegridview/preview/r;", "mPageChange", "Lcom/transsion/ninegridview/preview/r;", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "pageFrom", "Ljava/lang/String;", "postId", "com/transsion/ninegridview/preview/GifImagePreviewActivity$g", "mOnPageChangeCallback", "Lcom/transsion/ninegridview/preview/GifImagePreviewActivity$g;", "Companion", "a", "NineGridView_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class GifImagePreviewActivity extends BaseActivity<um.a> implements TRDialogListener {
    public static final int ANIMATE_DURATION = 200;
    public static final String CURRENT_ITEM = "CURRENT_ITEM";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String IMAGE_LIST = "image_list";
    public static final String IS_BUILTIN = "IS_BUILTIN";
    private static final String PAGE_NAME = "gif_image_preview";
    public static final String PICTURE_SAVE = "oneroom";
    public static final int PLAY_GIF_AGAIN = 102;
    public static final String POST_ID = "POST_ID";
    public static final int REQUEST_PERMISSION_SETTING = 101;
    private int currentItemIndex;
    private int imageHeight;
    private List<Image> imageList;
    private com.transsion.ninegridview.preview.c imagePreviewAdapter;
    private int imageWidth;
    private r mPageChange;
    private com.transsion.player.orplayer.f mPlayer;
    private String pageFrom;
    private String postId;
    private int screenHeight;
    private int screenWidth;
    private final int REQUEST_PERMISSION_STORAGE = 100;
    private Boolean isBuiltInApp = Boolean.FALSE;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final g mOnPageChangeCallback = new g();

    /* renamed from: com.transsion.ninegridview.preview.GifImagePreviewActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, int i, List list) {
            Intrinsics.h(context, "context");
            Intent intent = new Intent(context, (Class<?>) GifImagePreviewActivity.class);
            Bundle bundle = new Bundle();
            Intrinsics.f(list, "null cannot be cast to non-null type java.io.Serializable");
            bundle.putSerializable(GifImagePreviewActivity.IMAGE_LIST, (Serializable) list);
            bundle.putInt("CURRENT_ITEM", i);
            intent.putExtras(bundle);
            context.startActivity(intent);
        }
    }

    public static final class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Intrinsics.h(animator, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Intrinsics.h(animator, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Intrinsics.h(animator, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Intrinsics.h(animator, "animation");
            ((um.a) GifImagePreviewActivity.this.getMViewBinding()).d.setBackgroundColor(0);
        }
    }

    public static final class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Intrinsics.h(animator, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Intrinsics.h(animator, "animation");
            GifImagePreviewActivity.this.finish();
            GifImagePreviewActivity.this.overridePendingTransition(0, 0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Intrinsics.h(animator, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Intrinsics.h(animator, "animation");
            ((um.a) GifImagePreviewActivity.this.getMViewBinding()).d.setBackgroundColor(0);
        }
    }

    public static final class d implements RequestListener {
        final /* synthetic */ Image b;

        d(Image image) {
            this.b = image;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(File file, Object obj, Target target, DataSource dataSource, boolean z) {
            Intrinsics.h(file, "resource");
            Intrinsics.h(obj, "model");
            Intrinsics.h(target, "target");
            Intrinsics.h(dataSource, "dataSource");
            GifImagePreviewActivity gifImagePreviewActivity = GifImagePreviewActivity.this;
            Image image = this.b;
            gifImagePreviewActivity.saveToAlbum(file, image != null ? image.getUrl() : null);
            return false;
        }

        public boolean onLoadFailed(GlideException glideException, Object obj, Target target, boolean z) {
            Intrinsics.h(target, "target");
            fh.b.a.d(R$string.download_failed);
            return false;
        }
    }

    public static final class e implements Animation.AnimationListener {
        e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Intrinsics.h(animation, "animation");
            GifImagePreviewActivity.this.finish();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Intrinsics.h(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Intrinsics.h(animation, "animation");
        }
    }

    public static final class f implements com.transsion.player.orplayer.e {
        f() {
        }

        @Override // com.transsion.player.orplayer.e
        public void canNonSubscriberPlay(boolean z, int i, int i2, qn.d dVar) {
            e.a.a(this, z, i, i2, dVar);
        }

        @Override // com.transsion.player.orplayer.e
        public void initPlayer() {
            e.a.b(this);
        }

        @Override // com.transsion.player.orplayer.e
        public void onAliyunDecodeErrorChangeSoftwareDecoder(gn.e eVar) {
            e.a.c(this, eVar);
        }

        @Override // com.transsion.player.orplayer.e
        public void onBufferedPosition(long j, gn.e eVar) {
            e.a.d(this, j, eVar);
        }

        @Override // com.transsion.player.orplayer.e
        public void onCompletion(gn.e eVar) {
            e.a.e(this, eVar);
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
        public void onLoadingBegin(gn.e eVar) {
            e.a.i(this, eVar);
        }

        @Override // com.transsion.player.orplayer.e
        public void onLoadingEnd(gn.e eVar) {
            e.a.k(this, eVar);
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
        public void onPlayError(PlayError playError, gn.e eVar) {
            e.a.q(this, playError, eVar);
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
        public void onPrepare(gn.e eVar) {
            e.a.w(this, eVar);
        }

        @Override // com.transsion.player.orplayer.e
        public void onProgress(long j, gn.e eVar) {
            e.a.y(this, j, eVar);
        }

        @Override // com.transsion.player.orplayer.e
        public void onRenderFirstFrame() {
            e.a.A(this);
            r rVar = GifImagePreviewActivity.this.mPageChange;
            if (rVar != null) {
                rVar.g();
            }
        }

        @Override // com.transsion.player.orplayer.e
        public void onSetDataSource() {
            e.a.B(this);
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
        public void onVideoPause(gn.e eVar) {
            e.a.F(this, eVar);
        }

        @Override // com.transsion.player.orplayer.e
        public void onVideoSizeChanged(int i, int i2) {
            e.a.H(this, i, i2);
        }

        @Override // com.transsion.player.orplayer.e
        public void onVideoStart(gn.e eVar) {
            e.a.I(this, eVar);
        }

        @Override // com.transsion.player.orplayer.e
        public void setOnSeekCompleteListener() {
            e.a.K(this);
        }
    }

    public static final class g extends ViewPager2.OnPageChangeCallback {
        g() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(Ref.ObjectRef objectRef, GifImagePreviewActivity gifImagePreviewActivity, int i) {
            objectRef.element = gifImagePreviewActivity.getItemView();
            r rVar = gifImagePreviewActivity.mPageChange;
            if (rVar != null) {
                List list = gifImagePreviewActivity.imageList;
                rVar.f(i, list != null ? (Image) list.get(i) : null, (View) objectRef.element);
            }
        }

        public void onPageSelected(final int i) {
            GifBean gifBean;
            String videoUrl;
            GifImagePreviewActivity.this.currentItemIndex = i;
            GifImagePreviewActivity.this.showPageIndex();
            List list = GifImagePreviewActivity.this.imageList;
            Image image = list != null ? (Image) list.get(i) : null;
            if (image == null || (gifBean = image.getGifBean()) == null || (videoUrl = gifBean.getVideoUrl()) == null || videoUrl.length() <= 0) {
                return;
            }
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            View itemView = GifImagePreviewActivity.this.getItemView();
            objectRef.element = itemView;
            if (itemView == null) {
                Handler handler = GifImagePreviewActivity.this.handler;
                final GifImagePreviewActivity gifImagePreviewActivity = GifImagePreviewActivity.this;
                handler.postDelayed(new Runnable() { // from class: com.transsion.ninegridview.preview.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        GifImagePreviewActivity.g.b(objectRef, gifImagePreviewActivity, i);
                    }
                }, 200L);
            } else {
                r rVar = GifImagePreviewActivity.this.mPageChange;
                if (rVar != null) {
                    List list2 = GifImagePreviewActivity.this.imageList;
                    rVar.f(i, list2 != null ? (Image) list2.get(i) : null, (View) objectRef.element);
                }
            }
        }
    }

    public static final class h implements Animation.AnimationListener {
        h() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Intrinsics.h(animation, "animation");
            ConstraintLayout constraintLayout = ((um.a) GifImagePreviewActivity.this.getMViewBinding()).d;
            Intrinsics.g(constraintLayout, "rootView");
            uf.c.k(constraintLayout);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Intrinsics.h(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Intrinsics.h(animation, "animation");
        }
    }

    private final void addIntoListener(ValueAnimator valueAnimator) {
        valueAnimator.addListener(new b());
    }

    private final void addOutListener(ValueAnimator valueAnimator) {
        valueAnimator.addListener(new c());
    }

    private final void computeImageWidthAndHeight(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        int height = imageView.getHeight();
        int width = imageView.getWidth();
        if (drawable != null) {
            height = drawable.getIntrinsicHeight();
            width = drawable.getIntrinsicWidth();
        }
        float f2 = height;
        float f3 = (this.screenHeight * 1.0f) / f2;
        float f4 = width;
        float f5 = (this.screenWidth * 1.0f) / f4;
        if (f3 > f5) {
            f3 = f5;
        }
        this.imageHeight = (int) (f2 * f3);
        this.imageWidth = (int) (f4 * f3);
    }

    private final void downloadImage() {
        List<Image> list = this.imageList;
        int size = list != null ? list.size() : 0;
        int i = this.currentItemIndex;
        if (i < 0 || i >= size) {
            return;
        }
        List<Image> list2 = this.imageList;
        Image image = list2 != null ? list2.get(i) : null;
        Glide.with(this).downloadOnly().load(image != null ? image.getUrl() : null).listener(new d(image)).preload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getItemView() {
        RecyclerView childAt = ((um.a) getMViewBinding()).g.getChildAt(0);
        Intrinsics.f(childAt, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView.m layoutManager = childAt.getLayoutManager();
        if (layoutManager != null) {
            return layoutManager.findViewByPosition(this.currentItemIndex);
        }
        return null;
    }

    private final String getNameFromUrl(String url) {
        if (url == null) {
            return null;
        }
        String[] strArr = (String[]) StringsKt.S0(url, new String[]{"[?]"}, false, 0, 6, (Object) null).toArray(new String[0]);
        if (!(strArr.length == 0)) {
            String[] strArr2 = (String[]) StringsKt.S0(strArr[0], new String[]{"/"}, false, 0, 6, (Object) null).toArray(new String[0]);
            if (!(strArr2.length == 0)) {
                return strArr2[strArr2.length - 1];
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initPlayer() {
        ORPlayerView oRPlayerView = new ORPlayerView(this, RenderType.TEXTURE_VIEW);
        com.transsion.player.orplayer.f a = new f.a(this).a();
        a.setTextureView(oRPlayerView.getTextureView());
        a.setScaleMode(ScaleMode.SCALE_ASPECT_FILL);
        this.mPageChange = new r(a, oRPlayerView);
        a.setPlayerListener(new f());
        this.mPlayer = a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        HashMap g2;
        String str;
        this.screenWidth = y.e();
        this.screenHeight = y.c();
        Serializable serializableExtra = getIntent().getSerializableExtra(IMAGE_LIST);
        List<Image> list = serializableExtra instanceof List ? (List) serializableExtra : null;
        this.imageList = list;
        if (list == null) {
            this.imageList = new ArrayList();
        }
        this.isBuiltInApp = Boolean.valueOf(getIntent().getBooleanExtra(IS_BUILTIN, false));
        this.postId = getIntent().getStringExtra(POST_ID);
        this.currentItemIndex = getIntent().getIntExtra("CURRENT_ITEM", 0);
        com.transsion.ninegridview.preview.c cVar = new com.transsion.ninegridview.preview.c(this);
        cVar.h(this.imageList);
        cVar.g(this.isBuiltInApp);
        this.imagePreviewAdapter = cVar;
        ViewPager2 viewPager2 = ((um.a) getMViewBinding()).g;
        viewPager2.setAdapter(this.imagePreviewAdapter);
        viewPager2.registerOnPageChangeCallback(this.mOnPageChangeCallback);
        viewPager2.setCurrentItem(this.currentItemIndex, false);
        startEnterTheAnimation();
        showPageIndex();
        ((um.a) getMViewBinding()).b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ninegridview.preview.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GifImagePreviewActivity.initView$lambda$3(GifImagePreviewActivity.this, view);
            }
        });
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (g2 = logViewConfig.g()) != null && (str = this.postId) != null) {
            g2.put("post_id", str);
        }
        initPlayer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$3(GifImagePreviewActivity gifImagePreviewActivity, View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            gifImagePreviewActivity.downloadImage();
        } else if (androidx.core.content.b.checkSelfPermission(gifImagePreviewActivity, "android.permission.WRITE_EXTERNAL_STORAGE") == 0 && androidx.core.content.b.checkSelfPermission(gifImagePreviewActivity, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
            gifImagePreviewActivity.downloadImage();
        } else {
            gifImagePreviewActivity.requestPermission();
        }
        Map m = MapsKt.m(new Pair[]{TuplesKt.a("module_name", "save_picture"), TuplesKt.a("page_from", gifImagePreviewActivity.pageFrom)});
        String str = gifImagePreviewActivity.postId;
        if (str != null) {
            m.put("post_id", str);
        }
        qi.h.a.o(PAGE_NAME, m);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void requestPermission() {
        ActivityCompat.g(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, this.REQUEST_PERMISSION_STORAGE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void saveToAlbum(File file, String url) {
        String nameFromUrl = getNameFromUrl(url);
        if (new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), PICTURE_SAVE + File.separator + nameFromUrl).exists()) {
            fh.b.a.d(R$string.has_been_saved);
        } else {
            if (file == null || nameFromUrl == null) {
                return;
            }
            FileHelper.g(FileHelper.a, file, this, nameFromUrl, PICTURE_SAVE, false, 16, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showPageIndex() {
        TextView textView = ((um.a) getMViewBinding()).e;
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        Integer valueOf = Integer.valueOf(this.currentItemIndex + 1);
        List<Image> list = this.imageList;
        String format = String.format("%d/%d", Arrays.copyOf(new Object[]{valueOf, list != null ? Integer.valueOf(list.size()) : null}, 2));
        Intrinsics.g(format, "format(...)");
        textView.setText(format);
    }

    private final void showSettingDialog() {
        String string = Utils.a().getString(R$string.permission_deny_down_tip, "\"" + Utils.a().getString(R.string.base_app_name) + "\"", "\"" + Utils.a().getString(R$string.system_settings) + "\"");
        Intrinsics.g(string, "getString(...)");
        TRDialog.a g2 = new TRDialog.a().g(string);
        String string2 = Utils.a().getString(R$string.cancel);
        Intrinsics.g(string2, "getString(...)");
        TRDialog.a e2 = g2.e(string2);
        String string3 = Utils.a().getString(R$string.system_settings);
        Intrinsics.g(string3, "getString(...)");
        e2.j(string3).f(this).a().show(getSupportFragmentManager(), "settings");
    }

    private final void startEnterTheAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500L);
        alphaAnimation.setAnimationListener(new h());
        alphaAnimation.setFillAfter(true);
        ((um.a) getMViewBinding()).d.startAnimation(alphaAnimation);
    }

    public final int evaluateArgb(float fraction, int startValue, int endValue) {
        return ((((startValue >> 24) & 255) + ((int) ((((endValue >> 24) & 255) - r0) * fraction))) << 24) | ((((startValue >> 16) & 255) + ((int) ((((endValue >> 16) & 255) - r1) * fraction))) << 16) | ((((startValue >> 8) & 255) + ((int) ((((endValue >> 8) & 255) - r2) * fraction))) << 8) | ((startValue & 255) + ((int) (fraction * ((endValue & 255) - r8))));
    }

    public final float evaluateFloat(float fraction, Number startValue, Number endValue) {
        Intrinsics.h(startValue, "startValue");
        Intrinsics.h(endValue, "endValue");
        float floatValue = startValue.floatValue();
        return floatValue + (fraction * (endValue.floatValue() - floatValue));
    }

    public final int evaluateInt(float fraction, int startValue, int endValue) {
        return (int) (startValue + (fraction * (endValue - startValue)));
    }

    public final void finishActivityAnim() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(500L);
        alphaAnimation.setAnimationListener(new e());
        alphaAnimation.setFillAfter(true);
        ((um.a) getMViewBinding()).d.startAnimation(alphaAnimation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public um.a getViewBinding() {
        um.a c2 = um.a.c(getLayoutInflater());
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }

    public boolean isAttach() {
        return false;
    }

    public boolean isTranslucent() {
        return true;
    }

    public qi.b newLogViewConfig() {
        return new qi.b(PAGE_NAME, false, 2, null);
    }

    public void onBackPressed() {
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        finishActivityAnim();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
        this.pageFrom = qi.h.a.h();
        initView();
    }

    protected void onDestroy() {
        super.onDestroy();
        ((um.a) getMViewBinding()).g.unregisterOnPageChangeCallback(this.mOnPageChangeCallback);
        com.transsion.player.orplayer.f fVar = this.mPlayer;
        if (fVar != null) {
            fVar.release();
        }
    }

    public void onLeftButtonClick(TRDialog dialog) {
        Intrinsics.h(dialog, "dialog");
    }

    public void onPause() {
        super.onPause();
        com.transsion.player.orplayer.f fVar = this.mPlayer;
        if (fVar != null) {
            fVar.pause();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.h(permissions, "permissions");
        Intrinsics.h(grantResults, "grantResults");
        super/*androidx.fragment.app.FragmentActivity*/.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == this.REQUEST_PERMISSION_STORAGE) {
            if (grantResults.length > 1 && grantResults[0] == 0 && grantResults[1] == 0) {
                downloadImage();
            } else {
                if (ActivityCompat.j(this, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                    return;
                }
                showSettingDialog();
            }
        }
    }

    public void onResume() {
        super.onResume();
        com.transsion.player.orplayer.f fVar = this.mPlayer;
        if (fVar != null) {
            fVar.play();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onRightButtonClick(TRDialog dialog) {
        Intrinsics.h(dialog, "dialog");
        com.transsion.ninegridview.helper.b.a.a(this, 101);
    }
}
