package jt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import com.transsion.subtitle.R$id;
import com.transsion.subtitle.R$layout;
import com.transsion.subtitle.view.SubtitleOptionsView;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class e implements f4.a {
    private final NestedScrollView a;
    public final SubtitleOptionsView b;

    private e(NestedScrollView nestedScrollView, SubtitleOptionsView subtitleOptionsView) {
        this.a = nestedScrollView;
        this.b = subtitleOptionsView;
    }

    public static e a(View view) {
        int i = R$id.v_options;
        SubtitleOptionsView subtitleOptionsView = (SubtitleOptionsView) f4.b.a(view, i);
        if (subtitleOptionsView != null) {
            return new e((NestedScrollView) view, subtitleOptionsView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static e c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static e d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_subtitle_options, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public NestedScrollView getRoot() {
        return this.a;
    }
}
