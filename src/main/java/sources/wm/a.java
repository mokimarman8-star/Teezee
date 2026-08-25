package wm;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.flow.bean.MediaType;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.GifBean;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.ninegridview.R$id;
import com.transsion.ninegridview.video.NineGridItemView;
import com.transsion.ninegridview.video.NineGridVideoView;
import com.transsion.player.orplayer.ORPlayerPreloadManager;
import com.transsion.player.orplayer.f;
import com.transsion.player.ui.ORPlayerView;
import gn.e;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    public static final C0099a i = new C0099a(null);
    private final f a;
    private final ORPlayerView b;
    private int d;
    private PostSubjectItem e;
    private View f;
    private boolean g;
    private int c = -1;
    private final Map h = new LinkedHashMap();

    /* renamed from: wm.a$a, reason: collision with other inner class name */
    public static final class C0099a {
        private C0099a() {
        }

        public /* synthetic */ C0099a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(f fVar, ORPlayerView oRPlayerView) {
        this.a = fVar;
        this.b = oRPlayerView;
    }

    private final void A(NineGridItemView nineGridItemView) {
        ShapeableImageView findViewById = nineGridItemView != null ? nineGridItemView.findViewById(R$id.video_cover) : null;
        FrameLayout frameLayout = nineGridItemView != null ? (FrameLayout) nineGridItemView.findViewById(R$id.video_container) : null;
        ORPlayerView oRPlayerView = this.b;
        ViewParent parent = oRPlayerView != null ? oRPlayerView.getParent() : null;
        if (parent instanceof FrameLayout) {
            FrameLayout frameLayout2 = (FrameLayout) parent;
            frameLayout2.removeView(this.b);
            ViewParent parent2 = frameLayout2.getParent();
            if (parent2 instanceof FrameLayout) {
                FrameLayout frameLayout3 = (FrameLayout) parent2;
                ShapeableImageView findViewById2 = frameLayout3.findViewById(R$id.video_cover);
                if (findViewById2 != null) {
                    uf.c.k(findViewById2);
                }
                AppCompatImageView findViewById3 = frameLayout3.findViewById(R$id.label_gif);
                if (findViewById3 != null) {
                    uf.c.k(findViewById3);
                }
            }
        }
        ORPlayerView oRPlayerView2 = this.b;
        if (oRPlayerView2 != null) {
            oRPlayerView2.setId(R$id.player_view);
        }
        ORPlayerView oRPlayerView3 = this.b;
        if (oRPlayerView3 != null) {
            oRPlayerView3.setLayoutParams(new FrameLayout.LayoutParams(findViewById != null ? findViewById.getWidth() : 0, findViewById != null ? findViewById.getHeight() : 0));
        }
        if (frameLayout != null) {
            frameLayout.addView(this.b);
        }
        if (nineGridItemView != null) {
            nineGridItemView.requestLayout();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0049, code lost:
    
        if ((r2.length() > 0) == true) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int c(Media media) {
        List image;
        List image2;
        if (((media == null || (image2 = media.getImage()) == null) ? 0 : image2.size()) <= 0 || media == null || (image = media.getImage()) == null) {
            return -1;
        }
        int i2 = 0;
        for (Object obj : image) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.u();
            }
            GifBean gifBean = ((Image) obj).getGifBean();
            boolean z = (gifBean == null || (r2 = gifBean.getVideoUrl()) == null) ? false : true;
            if (z) {
                return i2;
            }
            i2 = i3;
        }
        return -1;
    }

    private final NineGridItemView d(Media media, View view) {
        List image;
        String videoUrl;
        if (media == null || (image = media.getImage()) == null) {
            return null;
        }
        int i2 = 0;
        for (Object obj : image) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.u();
            }
            GifBean gifBean = ((Image) obj).getGifBean();
            if (gifBean != null && (videoUrl = gifBean.getVideoUrl()) != null && videoUrl.length() > 0) {
                NineGridItemView k = k(view, i2);
                if (o(k)) {
                    this.d = i2;
                    return k;
                }
            }
            i2 = i3;
        }
        return null;
    }

    private final int g(Media media) {
        List image;
        Image image2;
        GifBean gifBean;
        String videoUrl;
        List image3;
        int size = (media == null || (image3 = media.getImage()) == null) ? 0 : image3.size();
        if (size > 0) {
            for (int i2 = size - 1; -1 < i2; i2--) {
                if (media != null && (image = media.getImage()) != null && (image2 = (Image) image.get(i2)) != null && (gifBean = image2.getGifBean()) != null && (videoUrl = gifBean.getVideoUrl()) != null && videoUrl.length() > 0) {
                    return i2;
                }
            }
        }
        return -1;
    }

    private final int i(Media media, int i2) {
        List image;
        GifBean gifBean;
        String videoUrl;
        if (i2 == g(media)) {
            return c(media);
        }
        if (media == null || (image = media.getImage()) == null) {
            return -1;
        }
        int i3 = 0;
        for (Object obj : image) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.u();
            }
            Image image2 = (Image) obj;
            if (i2 < i3 && (gifBean = image2.getGifBean()) != null && (videoUrl = gifBean.getVideoUrl()) != null && videoUrl.length() > 0) {
                return i3;
            }
            i3 = i4;
        }
        return -1;
    }

    private final String j(Media media, int i2) {
        List image;
        Image image2;
        GifBean gifBean;
        List image3;
        int i3 = i(media, i2);
        int size = (media == null || (image3 = media.getImage()) == null) ? 0 : image3.size();
        if (i3 < 0 || i3 >= size || i3 == this.d || media == null || (image = media.getImage()) == null || (image2 = (Image) image.get(i3)) == null || (gifBean = image2.getGifBean()) == null) {
            return null;
        }
        return gifBean.getVideoUrl();
    }

    private final NineGridItemView k(View view, int i2) {
        NineGridVideoView nineGridVideoView = view != null ? (NineGridVideoView) view.findViewById(R$id.nine_grid) : null;
        int childCount = nineGridVideoView != null ? nineGridVideoView.getChildCount() : 0;
        if (i2 >= 0 && i2 < childCount) {
            View childAt = nineGridVideoView != null ? nineGridVideoView.getChildAt(i2) : null;
            if (childAt instanceof NineGridItemView) {
                return (NineGridItemView) childAt;
            }
        }
        return null;
    }

    private final void m(NineGridItemView nineGridItemView) {
        AppCompatImageView findViewById;
        ShapeableImageView findViewById2;
        if (nineGridItemView != null && (findViewById2 = nineGridItemView.findViewById(R$id.video_cover)) != null) {
            uf.c.g(findViewById2);
        }
        if (nineGridItemView == null || (findViewById = nineGridItemView.findViewById(R$id.label_gif)) == null) {
            return;
        }
        uf.c.h(findViewById);
    }

    private final void t(GifBean gifBean, NineGridItemView nineGridItemView, boolean z) {
        if (nineGridItemView == null) {
            return;
        }
        a.a.f(wf.a.a, "ItemChangeListener", "play url = " + gifBean.getVideoUrl(), false, 4, (Object) null);
        A(nineGridItemView);
        f fVar = this.a;
        if (fVar != null) {
            String videoUrl = gifBean.getVideoUrl();
            String str = videoUrl == null ? BuildConfig.FLAVOR : videoUrl;
            String videoUrl2 = gifBean.getVideoUrl();
            if (videoUrl2 == null) {
                videoUrl2 = BuildConfig.FLAVOR;
            }
            fVar.setDataSource(new e(str, videoUrl2, 0, null, null, 28, null));
        }
        f fVar2 = this.a;
        if (fVar2 != null) {
            fVar2.prepare();
        }
        f fVar3 = this.a;
        if (fVar3 != null) {
            fVar3.play();
        }
        f fVar4 = this.a;
        if (fVar4 != null) {
            fVar4.setLooping(z);
        }
    }

    private final void u(Media media) {
        int e = e(media) - 1;
        for (int i2 = 0; i2 < e; i2++) {
            String j = j(media, this.d + i2);
            if (j != null && j.length() > 0) {
                ORPlayerPreloadManager.i.a().j(j, com.transsion.ninegridview.a.h.a().l());
            }
        }
    }

    private final void z(View view) {
        ORPlayerView oRPlayerView = view != null ? (ORPlayerView) view.findViewById(R$id.player_view) : null;
        ViewParent parent = oRPlayerView != null ? oRPlayerView.getParent() : null;
        if (parent instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) parent;
            frameLayout.removeView(oRPlayerView);
            ViewParent parent2 = frameLayout.getParent();
            if (parent2 instanceof FrameLayout) {
                FrameLayout frameLayout2 = (FrameLayout) parent2;
                ShapeableImageView findViewById = frameLayout2.findViewById(R$id.video_cover);
                if (findViewById != null) {
                    uf.c.k(findViewById);
                }
                AppCompatImageView findViewById2 = frameLayout2.findViewById(R$id.label_gif);
                if (findViewById2 != null) {
                    uf.c.k(findViewById2);
                }
            }
        }
    }

    public final void a() {
        this.c = -1;
        this.d = 0;
        this.e = null;
        this.f = null;
        ORPlayerPreloadManager.i.a().c();
    }

    public final int b() {
        return this.c;
    }

    public final int e(Media media) {
        List<Image> image;
        GifBean gifBean;
        String videoUrl;
        int i2 = 0;
        if (Intrinsics.c(media != null ? media.getMediaType() : null, MediaType.IMAGE.getValue()) && (image = media.getImage()) != null) {
            for (Image image2 : image) {
                if (image2.getGifBean() != null && (gifBean = image2.getGifBean()) != null && (videoUrl = gifBean.getVideoUrl()) != null && videoUrl.length() > 0) {
                    i2++;
                }
            }
        }
        return i2;
    }

    public final int f() {
        return this.d;
    }

    public final float h(NineGridVideoView nineGridVideoView, Media media) {
        List image;
        Image image2;
        List image3;
        Intrinsics.h(nineGridVideoView, "nineGridView");
        int size = (media == null || (image3 = media.getImage()) == null) ? 0 : image3.size();
        float f = 0.0f;
        for (int i2 = 0; i2 < size; i2++) {
            int i3 = i(media, i2);
            if (i3 < 0 || i3 >= size) {
                break;
            }
            GifBean gifBean = (media == null || (image = media.getImage()) == null || (image2 = (Image) image.get(i3)) == null) ? null : image2.getGifBean();
            if (gifBean != null && gifBean.getVideoUrl() != null) {
                NineGridItemView k = k(nineGridVideoView, i3);
                if (k == null) {
                    return f;
                }
                float l = l(k);
                if (f < l) {
                    f = l;
                }
            }
        }
        return f;
    }

    public final float l(View view) {
        Intrinsics.h(view, "view");
        if (!view.getGlobalVisibleRect(new Rect())) {
            return 0.0f;
        }
        return (r0.height() * 1.0f) / (view.getHeight() * 1.0f);
    }

    public final boolean n() {
        f fVar = this.a;
        if (fVar != null) {
            return fVar.isPlaying();
        }
        return false;
    }

    public final boolean o(View view) {
        if (view == null) {
            return false;
        }
        if (view.getGlobalVisibleRect(new Rect())) {
            if ((r1.height() * 1.0f) / (view.getHeight() * 1.0f) > 0.5f) {
                return true;
            }
        }
        return false;
    }

    public void p() {
        m(k(this.f, this.d));
    }

    public void q() {
        String videoUrl;
        List image;
        Image image2;
        List image3;
        PostSubjectItem postSubjectItem = this.e;
        Media media = postSubjectItem != null ? postSubjectItem.getMedia() : null;
        int size = (media == null || (image3 = media.getImage()) == null) ? 0 : image3.size();
        int e = e(media);
        while (size > 0) {
            int i2 = i(media, this.d);
            this.d = i2;
            if (i2 < 0 || i2 >= size) {
                return;
            }
            GifBean gifBean = (media == null || (image = media.getImage()) == null || (image2 = (Image) image.get(this.d)) == null) ? null : image2.getGifBean();
            if (gifBean != null && (videoUrl = gifBean.getVideoUrl()) != null) {
                NineGridItemView k = k(this.f, this.d);
                if (o(k) || this.g) {
                    t(gifBean, k, size == 1);
                    this.h.put(videoUrl, Boolean.TRUE);
                    return;
                }
                this.h.put(videoUrl, Boolean.FALSE);
            }
            if (!this.h.containsValue(Boolean.TRUE) && this.h.size() >= e) {
                this.c = -1;
                f fVar = this.a;
                if (fVar == null || !fVar.isPlaying()) {
                    return;
                }
                this.a.pause();
                return;
            }
        }
    }

    public void r() {
        f fVar = this.a;
        if (fVar != null && fVar.isPlaying()) {
            this.a.pause();
            z(this.f);
        }
        a();
    }

    public void s(PostSubjectItem postSubjectItem, View view, int i2) {
        String videoUrl;
        Image image;
        this.f = view;
        GifBean gifBean = null;
        Media media = postSubjectItem != null ? postSubjectItem.getMedia() : null;
        ORPlayerPreloadManager.i.a().h();
        this.h.clear();
        if (Intrinsics.c(media != null ? media.getMediaType() : null, MediaType.IMAGE.getValue())) {
            List image2 = media.getImage();
            int size = image2 != null ? image2.size() : 0;
            NineGridItemView d = d(postSubjectItem.getMedia(), view);
            int i3 = this.d;
            if (i3 < 0 || i3 >= size) {
                return;
            }
            List image3 = media.getImage();
            if (image3 != null && (image = (Image) image3.get(this.d)) != null) {
                gifBean = image.getGifBean();
            }
            if (gifBean == null || (videoUrl = gifBean.getVideoUrl()) == null || videoUrl.length() <= 0) {
                return;
            }
            t(gifBean, d, e(media) == 1);
            this.c = i2;
            this.e = postSubjectItem;
            if (size > 1) {
                u(media);
            }
        }
    }

    public final void v(Media media) {
        List image;
        Image image2;
        GifBean gifBean;
        List image3;
        int c = c(media);
        int size = (media == null || (image3 = media.getImage()) == null) ? 0 : image3.size();
        if (c < 0 || c >= size) {
            return;
        }
        String videoUrl = (media == null || (image = media.getImage()) == null || (image2 = (Image) image.get(c)) == null || (gifBean = image2.getGifBean()) == null) ? null : gifBean.getVideoUrl();
        if (videoUrl == null || videoUrl.length() <= 0) {
            return;
        }
        ORPlayerPreloadManager.i.a().j(videoUrl, com.transsion.ninegridview.a.h.a().l());
    }

    public final void w() {
        s(this.e, this.f, this.c);
    }

    public final void x(int i2) {
        this.c = i2;
    }

    public final void y(boolean z) {
        this.g = z;
    }
}
