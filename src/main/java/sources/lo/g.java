package lo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.transsion.publish.R$id;
import com.transsion.publish.R$layout;
import com.transsion.publish.view.MatchParentVideoView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g implements f4.a {
    private final ConstraintLayout a;
    public final Group b;
    public final View c;
    public final AppCompatImageButton d;
    public final RelativeLayout e;
    public final ProgressBar f;
    public final TextView g;
    public final ImageView h;
    public final FrameLayout i;
    public final LinearLayout j;
    public final ImageView k;
    public final ConstraintLayout l;
    public final TextView m;
    public final TextView n;
    public final TextView o;
    public final TextView p;
    public final MatchParentVideoView q;

    private g(ConstraintLayout constraintLayout, Group group, View view, AppCompatImageButton appCompatImageButton, RelativeLayout relativeLayout, ProgressBar progressBar, TextView textView, ImageView imageView, FrameLayout frameLayout, LinearLayout linearLayout, ImageView imageView2, ConstraintLayout constraintLayout2, TextView textView2, TextView textView3, TextView textView4, TextView textView5, MatchParentVideoView matchParentVideoView) {
        this.a = constraintLayout;
        this.b = group;
        this.c = view;
        this.d = appCompatImageButton;
        this.e = relativeLayout;
        this.f = progressBar;
        this.g = textView;
        this.h = imageView;
        this.i = frameLayout;
        this.j = linearLayout;
        this.k = imageView2;
        this.l = constraintLayout2;
        this.m = textView2;
        this.n = textView3;
        this.o = textView4;
        this.p = textView5;
        this.q = matchParentVideoView;
    }

    public static g a(View view) {
        View a;
        AppCompatImageButton a2;
        int i = R$id.bottomGroup;
        Group a3 = f4.b.a(view, i);
        if (a3 != null && (a = f4.b.a(view, (i = R$id.bottomLine))) != null && (a2 = f4.b.a(view, (i = R$id.btn_back))) != null) {
            i = R$id.clTitle;
            RelativeLayout relativeLayout = (RelativeLayout) f4.b.a(view, i);
            if (relativeLayout != null) {
                i = R$id.clip_loading;
                ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
                if (progressBar != null) {
                    i = R$id.confirmTV;
                    TextView textView = (TextView) f4.b.a(view, i);
                    if (textView != null) {
                        i = R$id.coverIV;
                        ImageView imageView = (ImageView) f4.b.a(view, i);
                        if (imageView != null) {
                            i = R$id.fl_clear;
                            FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
                            if (frameLayout != null) {
                                i = R$id.llSelect;
                                LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
                                if (linearLayout != null) {
                                    i = R$id.playIV;
                                    ImageView imageView2 = (ImageView) f4.b.a(view, i);
                                    if (imageView2 != null) {
                                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                        i = R$id.selectNumTV;
                                        TextView textView2 = (TextView) f4.b.a(view, i);
                                        if (textView2 != null) {
                                            i = R$id.tv_delete;
                                            TextView textView3 = (TextView) f4.b.a(view, i);
                                            if (textView3 != null) {
                                                i = R$id.tvNumber;
                                                TextView textView4 = (TextView) f4.b.a(view, i);
                                                if (textView4 != null) {
                                                    i = R$id.tvSelect;
                                                    TextView textView5 = (TextView) f4.b.a(view, i);
                                                    if (textView5 != null) {
                                                        i = R$id.vv_video;
                                                        MatchParentVideoView matchParentVideoView = (MatchParentVideoView) f4.b.a(view, i);
                                                        if (matchParentVideoView != null) {
                                                            return new g(constraintLayout, a3, a, a2, relativeLayout, progressBar, textView, imageView, frameLayout, linearLayout, imageView2, constraintLayout, textView2, textView3, textView4, textView5, matchParentVideoView);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static g c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static g d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_video_preview, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
