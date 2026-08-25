package vp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatImageView b;
    public final EditText c;
    public final ImageView d;
    public final View e;
    public final ProgressBar f;
    public final TextView g;
    public final RecyclerView h;
    public final TextView i;

    private e(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, EditText editText, ImageView imageView, View view, ProgressBar progressBar, TextView textView, RecyclerView recyclerView, TextView textView2) {
        this.a = constraintLayout;
        this.b = appCompatImageView;
        this.c = editText;
        this.d = imageView;
        this.e = view;
        this.f = progressBar;
        this.g = textView;
        this.h = recyclerView;
        this.i = textView2;
    }

    public static e a(View view) {
        View a;
        RecyclerView a2;
        int i = R$id.clearIV;
        AppCompatImageView a3 = f4.b.a(view, i);
        if (a3 != null) {
            i = R$id.inputET;
            EditText editText = (EditText) f4.b.a(view, i);
            if (editText != null) {
                i = R$id.iv_cancel;
                ImageView imageView = (ImageView) f4.b.a(view, i);
                if (imageView != null && (a = f4.b.a(view, (i = R$id.line))) != null) {
                    i = R$id.loadView;
                    ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
                    if (progressBar != null) {
                        i = R$id.recentTV;
                        TextView textView = (TextView) f4.b.a(view, i);
                        if (textView != null && (a2 = f4.b.a(view, (i = R$id.rv))) != null) {
                            i = R$id.searchTV;
                            TextView textView2 = (TextView) f4.b.a(view, i);
                            if (textView2 != null) {
                                return new e((ConstraintLayout) view, a3, editText, imageView, a, progressBar, textView, a2, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static e c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static e d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_publish_work, viewGroup, false);
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
