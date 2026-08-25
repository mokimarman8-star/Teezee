package xv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.videodetail.R$id;
import com.transsion.videodetail.R$layout;
import com.transsion.videodetail.music.widget.MusicLikedListEmptyView;
import com.transsion.videodetail.music.widget.MusicLikedListLoadingView;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class e implements f4.a {
    private final ConstraintLayout a;
    public final MusicLikedListEmptyView b;
    public final FrameLayout c;
    public final RecyclerView d;
    public final MusicLikedListLoadingView e;
    public final AppCompatTextView f;
    public final AppCompatTextView g;
    public final View h;

    private e(ConstraintLayout constraintLayout, MusicLikedListEmptyView musicLikedListEmptyView, FrameLayout frameLayout, RecyclerView recyclerView, MusicLikedListLoadingView musicLikedListLoadingView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, View view) {
        this.a = constraintLayout;
        this.b = musicLikedListEmptyView;
        this.c = frameLayout;
        this.d = recyclerView;
        this.e = musicLikedListLoadingView;
        this.f = appCompatTextView;
        this.g = appCompatTextView2;
        this.h = view;
    }

    public static e a(View view) {
        RecyclerView a;
        AppCompatTextView a2;
        AppCompatTextView a3;
        View a4;
        int i = R$id.emptyView;
        MusicLikedListEmptyView musicLikedListEmptyView = (MusicLikedListEmptyView) f4.b.a(view, i);
        if (musicLikedListEmptyView != null) {
            i = R$id.flPlayer;
            FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
            if (frameLayout != null && (a = f4.b.a(view, (i = R$id.likedRv))) != null) {
                i = R$id.loadingView;
                MusicLikedListLoadingView musicLikedListLoadingView = (MusicLikedListLoadingView) f4.b.a(view, i);
                if (musicLikedListLoadingView != null && (a2 = f4.b.a(view, (i = R$id.tvPlayAll))) != null && (a3 = f4.b.a(view, (i = R$id.tvVideosCount))) != null && (a4 = f4.b.a(view, (i = R$id.viewTopPlaceholder))) != null) {
                    return new e((ConstraintLayout) view, musicLikedListEmptyView, frameLayout, a, musicLikedListLoadingView, a2, a3, a4);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static e c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static e d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_liked_music_layout, viewGroup, false);
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
