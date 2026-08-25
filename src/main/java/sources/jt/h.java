package jt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.subtitle.R$id;
import com.transsion.subtitle.R$layout;
import com.transsion.subtitle.view.SubtitleSyncAdjustView;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class h implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatImageView b;
    public final Space c;
    public final AppCompatTextView d;
    public final SubtitleSyncAdjustView e;
    public final SubtitleSyncAdjustView f;

    private h(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, Space space, AppCompatTextView appCompatTextView, SubtitleSyncAdjustView subtitleSyncAdjustView, SubtitleSyncAdjustView subtitleSyncAdjustView2) {
        this.a = constraintLayout;
        this.b = appCompatImageView;
        this.c = space;
        this.d = appCompatTextView;
        this.e = subtitleSyncAdjustView;
        this.f = subtitleSyncAdjustView2;
    }

    public static h a(View view) {
        AppCompatTextView a;
        int i = R$id.ivBack;
        AppCompatImageView a2 = f4.b.a(view, i);
        if (a2 != null) {
            i = R$id.space;
            Space space = (Space) f4.b.a(view, i);
            if (space != null && (a = f4.b.a(view, (i = R$id.tvStyle))) != null) {
                i = R$id.viewSyncAdJustaND;
                SubtitleSyncAdjustView subtitleSyncAdjustView = (SubtitleSyncAdjustView) f4.b.a(view, i);
                if (subtitleSyncAdjustView != null) {
                    i = R$id.viewSyncAdJustaST;
                    SubtitleSyncAdjustView subtitleSyncAdjustView2 = (SubtitleSyncAdjustView) f4.b.a(view, i);
                    if (subtitleSyncAdjustView2 != null) {
                        return new h((ConstraintLayout) view, a2, space, a, subtitleSyncAdjustView, subtitleSyncAdjustView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static h c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static h d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_subtitle_sync_adjust_layout, viewGroup, false);
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
