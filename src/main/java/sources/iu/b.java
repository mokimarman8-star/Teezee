package iu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.noober.background.view.BLTextView;
import com.transsion.ugcvideodetail.R$id;
import com.transsion.ugcvideodetail.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b implements f4.a {
    private final LinearLayout a;
    public final ConstraintLayout b;
    public final View c;
    public final FrameLayout d;
    public final ImageView e;
    public final BLTextView f;
    public final TextView g;
    public final TextView h;
    public final View i;
    public final View j;
    public final View k;

    private b(LinearLayout linearLayout, ConstraintLayout constraintLayout, View view, FrameLayout frameLayout, ImageView imageView, BLTextView bLTextView, TextView textView, TextView textView2, View view2, View view3, View view4) {
        this.a = linearLayout;
        this.b = constraintLayout;
        this.c = view;
        this.d = frameLayout;
        this.e = imageView;
        this.f = bLTextView;
        this.g = textView;
        this.h = textView2;
        this.i = view2;
        this.j = view3;
        this.k = view4;
    }

    public static b a(View view) {
        View a;
        BLTextView a2;
        View a3;
        View a4;
        View a5;
        int i = R$id.clImmCommentContent;
        ConstraintLayout a6 = f4.b.a(view, i);
        if (a6 != null && (a = f4.b.a(view, (i = R$id.divider))) != null) {
            i = R$id.fl_comment_container;
            FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
            if (frameLayout != null) {
                i = R$id.iv_close;
                ImageView imageView = (ImageView) f4.b.a(view, i);
                if (imageView != null && (a2 = f4.b.a(view, (i = R$id.tv_comment))) != null) {
                    i = R$id.tvTitle;
                    TextView textView = (TextView) f4.b.a(view, i);
                    if (textView != null) {
                        i = R$id.tvTitleCount;
                        TextView textView2 = (TextView) f4.b.a(view, i);
                        if (textView2 != null && (a3 = f4.b.a(view, (i = R$id.v_bottom))) != null && (a4 = f4.b.a(view, (i = R$id.vTopLine))) != null && (a5 = f4.b.a(view, (i = R$id.vTopSpace))) != null) {
                            return new b((LinearLayout) view, a6, a, frameLayout, imageView, a2, textView, textView2, a3, a4, a5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static b c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.dialog_ugc_imm_video_comment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
