package vp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search_pugc.speech.SpeechRecognizerView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class i implements f4.a {
    private final ConstraintLayout a;
    public final EditText b;
    public final ImageView c;
    public final AppCompatImageView d;
    public final LinearLayout e;
    public final SpeechRecognizerView f;
    public final ImageView g;
    public final FrameLayout h;
    public final View i;
    public final TextView j;

    private i(ConstraintLayout constraintLayout, EditText editText, ImageView imageView, AppCompatImageView appCompatImageView, LinearLayout linearLayout, SpeechRecognizerView speechRecognizerView, ImageView imageView2, FrameLayout frameLayout, View view, TextView textView) {
        this.a = constraintLayout;
        this.b = editText;
        this.c = imageView;
        this.d = appCompatImageView;
        this.e = linearLayout;
        this.f = speechRecognizerView;
        this.g = imageView2;
        this.h = frameLayout;
        this.i = view;
        this.j = textView;
    }

    public static i a(View view) {
        AppCompatImageView a;
        View a2;
        int i = R$id.comment_input_edit_text;
        EditText editText = (EditText) f4.b.a(view, i);
        if (editText != null) {
            i = R$id.comment_input_search_icon;
            ImageView imageView = (ImageView) f4.b.a(view, i);
            if (imageView != null && (a = f4.b.a(view, (i = R$id.iv_cancel))) != null) {
                i = R$id.ll_top;
                LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
                if (linearLayout != null) {
                    i = R$id.sRView;
                    SpeechRecognizerView speechRecognizerView = (SpeechRecognizerView) f4.b.a(view, i);
                    if (speechRecognizerView != null) {
                        i = R$id.search_edit_clear;
                        ImageView imageView2 = (ImageView) f4.b.a(view, i);
                        if (imageView2 != null) {
                            i = R$id.search_fragment_container;
                            FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
                            if (frameLayout != null && (a2 = f4.b.a(view, (i = R$id.top_line))) != null) {
                                i = R$id.tv_search;
                                TextView textView = (TextView) f4.b.a(view, i);
                                if (textView != null) {
                                    return new i((ConstraintLayout) view, editText, imageView, a, linearLayout, speechRecognizerView, imageView2, frameLayout, a2, textView);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static i c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static i d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_search_subject, viewGroup, false);
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
