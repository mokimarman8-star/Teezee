package vp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d implements f4.a {
    private final RelativeLayout a;
    public final EditText b;
    public final ImageView c;
    public final AppCompatImageView d;
    public final LinearLayout e;
    public final ProgressBar f;
    public final RelativeLayout g;
    public final RecyclerView h;
    public final TextView i;
    public final TextView j;

    private d(RelativeLayout relativeLayout, EditText editText, ImageView imageView, AppCompatImageView appCompatImageView, LinearLayout linearLayout, ProgressBar progressBar, RelativeLayout relativeLayout2, RecyclerView recyclerView, TextView textView, TextView textView2) {
        this.a = relativeLayout;
        this.b = editText;
        this.c = imageView;
        this.d = appCompatImageView;
        this.e = linearLayout;
        this.f = progressBar;
        this.g = relativeLayout2;
        this.h = recyclerView;
        this.i = textView;
        this.j = textView2;
    }

    public static d a(View view) {
        AppCompatImageView a;
        RecyclerView a2;
        int i = R$id.comment_input_edit_text;
        EditText editText = (EditText) f4.b.a(view, i);
        if (editText != null) {
            i = R$id.iv_cancel;
            ImageView imageView = (ImageView) f4.b.a(view, i);
            if (imageView != null && (a = f4.b.a(view, (i = R$id.iv_clear))) != null) {
                i = R$id.ll_top;
                LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
                if (linearLayout != null) {
                    i = R$id.load_view;
                    ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
                    if (progressBar != null) {
                        i = R$id.rl_tips;
                        RelativeLayout relativeLayout = (RelativeLayout) f4.b.a(view, i);
                        if (relativeLayout != null && (a2 = f4.b.a(view, (i = R$id.rv))) != null) {
                            i = R$id.tv_clear;
                            TextView textView = (TextView) f4.b.a(view, i);
                            if (textView != null) {
                                i = R$id.tv_search;
                                TextView textView2 = (TextView) f4.b.a(view, i);
                                if (textView2 != null) {
                                    return new d((RelativeLayout) view, editText, imageView, a, linearLayout, progressBar, relativeLayout, a2, textView, textView2);
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
        View inflate = layoutInflater.inflate(R$layout.fragment_publish_search, viewGroup, false);
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
