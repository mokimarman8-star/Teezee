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
public final class d implements f4.a {
    private final ConstraintLayout a;
    public final TextView b;
    public final TextView c;
    public final ProgressBar d;
    public final RecyclerView e;
    public final LinearLayout f;
    public final LinearLayout g;
    public final CustomHeader h;
    public final TextView i;

    private d(ConstraintLayout constraintLayout, TextView textView, TextView textView2, ProgressBar progressBar, RecyclerView recyclerView, LinearLayout linearLayout, LinearLayout linearLayout2, CustomHeader customHeader, TextView textView3) {
        this.a = constraintLayout;
        this.b = textView;
        this.c = textView2;
        this.d = progressBar;
        this.e = recyclerView;
        this.f = linearLayout;
        this.g = linearLayout2;
        this.h = customHeader;
        this.i = textView3;
    }

    public static d a(View view) {
        RecyclerView a;
        int i = R$id.confirmTV;
        TextView textView = (TextView) f4.b.a(view, i);
        if (textView != null) {
            i = R$id.selectNumTV;
            TextView textView2 = (TextView) f4.b.a(view, i);
            if (textView2 != null) {
                i = R$id.select_video_loading;
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
                                TextView textView3 = (TextView) f4.b.a(view, i);
                                if (textView3 != null) {
                                    return new d((ConstraintLayout) view, textView, textView2, progressBar, a, linearLayout, linearLayout2, customHeader, textView3);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static d c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static d d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_select_image, viewGroup, false);
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
