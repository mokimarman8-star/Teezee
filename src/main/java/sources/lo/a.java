package lo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import com.transsion.publish.R$id;
import com.transsion.publish.R$layout;
import com.transsion.publish.view.clip.ClipImageView;
import com.transsion.publish.view.clip.ClipView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a implements f4.a {
    private final RelativeLayout a;
    public final AppCompatImageButton b;
    public final RelativeLayout c;
    public final ProgressBar d;
    public final ClipView e;
    public final ClipImageView f;
    public final TextView g;

    private a(RelativeLayout relativeLayout, AppCompatImageButton appCompatImageButton, RelativeLayout relativeLayout2, ProgressBar progressBar, ClipView clipView, ClipImageView clipImageView, TextView textView) {
        this.a = relativeLayout;
        this.b = appCompatImageButton;
        this.c = relativeLayout2;
        this.d = progressBar;
        this.e = clipView;
        this.f = clipImageView;
        this.g = textView;
    }

    public static a a(View view) {
        int i = R$id.btn_back;
        AppCompatImageButton a = f4.b.a(view, i);
        if (a != null) {
            i = R$id.clTitle;
            RelativeLayout relativeLayout = (RelativeLayout) f4.b.a(view, i);
            if (relativeLayout != null) {
                i = R$id.clip_loading;
                ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
                if (progressBar != null) {
                    i = R$id.clipview;
                    ClipView clipView = (ClipView) f4.b.a(view, i);
                    if (clipView != null) {
                        i = R$id.src_pic;
                        ClipImageView clipImageView = (ClipImageView) f4.b.a(view, i);
                        if (clipImageView != null) {
                            i = R$id.tvDone;
                            TextView textView = (TextView) f4.b.a(view, i);
                            if (textView != null) {
                                return new a((RelativeLayout) view, a, relativeLayout, progressBar, clipView, clipImageView, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static a c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static a d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_clip_image, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.a;
    }
}
