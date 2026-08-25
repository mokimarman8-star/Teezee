package vp;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.search.R$id;
import com.transsion.search_pugc.speech.SpeechRecognizerVolumeCircleView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b implements f4.a {
    private final FrameLayout a;
    public final AppCompatImageView b;
    public final FrameLayout c;
    public final AppCompatTextView d;
    public final AppCompatTextView e;
    public final View f;
    public final SpeechRecognizerVolumeCircleView g;

    private b(FrameLayout frameLayout, AppCompatImageView appCompatImageView, FrameLayout frameLayout2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, View view, SpeechRecognizerVolumeCircleView speechRecognizerVolumeCircleView) {
        this.a = frameLayout;
        this.b = appCompatImageView;
        this.c = frameLayout2;
        this.d = appCompatTextView;
        this.e = appCompatTextView2;
        this.f = view;
        this.g = speechRecognizerVolumeCircleView;
    }

    public static b a(View view) {
        AppCompatTextView a;
        AppCompatTextView a2;
        View a3;
        int i = R$id.ivClose;
        AppCompatImageView a4 = f4.b.a(view, i);
        if (a4 != null) {
            i = R$id.llTop;
            FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
            if (frameLayout != null && (a = f4.b.a(view, (i = R$id.tvResult))) != null && (a2 = f4.b.a(view, (i = R$id.tvTip))) != null && (a3 = f4.b.a(view, (i = R$id.viewBg))) != null) {
                i = R$id.volumeCircleView;
                SpeechRecognizerVolumeCircleView speechRecognizerVolumeCircleView = (SpeechRecognizerVolumeCircleView) f4.b.a(view, i);
                if (speechRecognizerVolumeCircleView != null) {
                    return new b((FrameLayout) view, a4, frameLayout, a, a2, a3, speechRecognizerVolumeCircleView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
