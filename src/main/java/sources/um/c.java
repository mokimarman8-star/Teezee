package um;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.transsion.ninegridview.R$id;
import com.transsion.ninegridview.R$layout;
import com.transsion.photoview.PhotoView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c implements f4.a {
    private final FrameLayout a;
    public final FrameLayout b;
    public final AppCompatImageView c;
    public final FrameLayout d;
    public final PhotoView e;

    private c(FrameLayout frameLayout, FrameLayout frameLayout2, AppCompatImageView appCompatImageView, FrameLayout frameLayout3, PhotoView photoView) {
        this.a = frameLayout;
        this.b = frameLayout2;
        this.c = appCompatImageView;
        this.d = frameLayout3;
        this.e = photoView;
    }

    public static c a(View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        int i = R$id.thumb;
        AppCompatImageView a = f4.b.a(view, i);
        if (a != null) {
            i = R$id.video_container;
            FrameLayout frameLayout2 = (FrameLayout) f4.b.a(view, i);
            if (frameLayout2 != null) {
                i = R$id.video_cover;
                PhotoView photoView = (PhotoView) f4.b.a(view, i);
                if (photoView != null) {
                    return new c(frameLayout, frameLayout, a, frameLayout2, photoView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static c c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static c d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_gif_image_preview, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
