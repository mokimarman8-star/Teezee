package lo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.publish.R$id;
import com.transsion.publish.R$layout;
import com.transsion.publish.view.CustomHeader;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class f implements f4.a {
    private final ConstraintLayout a;
    public final ProgressBar b;
    public final RecyclerView c;
    public final LinearLayout d;
    public final LinearLayout e;
    public final CustomHeader f;
    public final TextView g;

    private f(ConstraintLayout constraintLayout, ProgressBar progressBar, RecyclerView recyclerView, LinearLayout linearLayout, LinearLayout linearLayout2, CustomHeader customHeader, TextView textView) {
        this.a = constraintLayout;
        this.b = progressBar;
        this.c = recyclerView;
        this.d = linearLayout;
        this.e = linearLayout2;
        this.f = customHeader;
        this.g = textView;
    }

    public static f a(View view) {
        RecyclerView a;
        int i = R$id.select_video_loading;
        ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
        if (progressBar != null && (a = f4.b.a(view, (i = R$id.select_video_recycler))) != null) {
            i = R$id.sv_lock_view;
            LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
            if (linearLayout != null) {
                i = R$id.sv_no_content_view;
                LinearLayout linearLayout2 = (LinearLayout) f4.b.a(view, i);
                if (linearLayout2 != null) {
                    i = R$id.sv_title_bar;
                    CustomHeader customHeader = (CustomHeader) f4.b.a(view, i);
                    if (customHeader != null) {
                        i = R$id.sv_tv_grant;
                        TextView textView = (TextView) f4.b.a(view, i);
                        if (textView != null) {
                            return new f((ConstraintLayout) view, progressBar, a, linearLayout, linearLayout2, customHeader, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static f c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static f d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_select_music, viewGroup, false);
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
