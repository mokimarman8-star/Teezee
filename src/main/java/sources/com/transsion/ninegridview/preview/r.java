package com.transsion.ninegridview.preview;

import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.blankj.utilcode.util.y;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.GifBean;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.ninegridview.R$id;
import com.transsion.photoview.PhotoView;
import com.transsion.player.ui.ORPlayerView;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class r extends ng.a {
    private final com.transsion.player.orplayer.f a;
    private final ORPlayerView b;
    private int c;
    private View d;
    private Image e;

    public r(com.transsion.player.orplayer.f fVar, ORPlayerView oRPlayerView) {
        Intrinsics.h(fVar, "player");
        Intrinsics.h(oRPlayerView, "playerView");
        this.a = fVar;
        this.b = oRPlayerView;
        this.c = -1;
    }

    private final void e(View view) {
        AppCompatImageView appCompatImageView = view != null ? (PhotoView) view.findViewById(R$id.video_cover) : null;
        if (appCompatImageView != null) {
            uf.c.g(appCompatImageView);
        }
    }

    private final void h(GifBean gifBean, View view, boolean z) {
        i(view);
        com.transsion.player.orplayer.f fVar = this.a;
        String videoUrl = gifBean.getVideoUrl();
        String str = videoUrl == null ? BuildConfig.FLAVOR : videoUrl;
        String videoUrl2 = gifBean.getVideoUrl();
        if (videoUrl2 == null) {
            videoUrl2 = BuildConfig.FLAVOR;
        }
        fVar.setDataSource(new gn.e(str, videoUrl2, 0, null, null, 28, null));
        this.a.prepare();
        this.a.play();
        this.a.setLooping(z);
    }

    private final void i(View view) {
        Integer height;
        Integer width;
        AppCompatImageView appCompatImageView;
        FrameLayout frameLayout = view != null ? (FrameLayout) view.findViewById(R$id.video_container) : null;
        ViewParent parent = this.b.getParent();
        if (parent instanceof FrameLayout) {
            FrameLayout frameLayout2 = (FrameLayout) parent;
            frameLayout2.removeView(this.b);
            ViewParent parent2 = frameLayout2.getParent();
            if ((parent2 instanceof FrameLayout) && (appCompatImageView = (PhotoView) ((FrameLayout) parent2).findViewById(R$id.video_cover)) != null) {
                uf.c.k(appCompatImageView);
            }
        }
        this.b.setId(R$id.player_view);
        Image image = this.e;
        float e = (image == null || (width = image.getWidth()) == null) ? y.e() : width.intValue();
        Image image2 = this.e;
        float c = (image2 == null || (height = image2.getHeight()) == null) ? y.c() : height.intValue();
        float e2 = y.e();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) e2, (int) ((c / e) * e2));
        layoutParams.gravity = 17;
        this.b.setLayoutParams(layoutParams);
        if (frameLayout != null) {
            frameLayout.addView(this.b);
        }
    }

    public void c(boolean z, int i, View view) {
    }

    public final void f(int i, Image image, View view) {
        String videoUrl;
        this.c = i;
        this.d = view;
        this.e = image;
        GifBean gifBean = image != null ? image.getGifBean() : null;
        if (gifBean == null || (videoUrl = gifBean.getVideoUrl()) == null || videoUrl.length() <= 0) {
            return;
        }
        h(gifBean, view, true);
    }

    public void g() {
        e(this.d);
    }
}
