package fp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.tn.lib.view.RoomCacheAnimationView;
import com.tn.lib.view.bubbleview.BubbleTextView;
import com.transsion.baseui.widget.GradientTextView;
import com.transsion.baseui.widget.NestedSwipeRefreshLayout;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;
import com.transsion.room.widget.CommunityRoomsView;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class q implements f4.a {
    private final NestedSwipeRefreshLayout a;
    public final BubbleTextView b;
    public final AppBarLayout c;
    public final RoomCacheAnimationView d;
    public final AppCompatImageView e;
    public final MagicIndicator f;
    public final NestedSwipeRefreshLayout g;
    public final CollapsingToolbarLayout h;
    public final GradientTextView i;
    public final CommunityRoomsView j;
    public final ViewPager2 k;

    private q(NestedSwipeRefreshLayout nestedSwipeRefreshLayout, BubbleTextView bubbleTextView, AppBarLayout appBarLayout, RoomCacheAnimationView roomCacheAnimationView, AppCompatImageView appCompatImageView, MagicIndicator magicIndicator, NestedSwipeRefreshLayout nestedSwipeRefreshLayout2, CollapsingToolbarLayout collapsingToolbarLayout, GradientTextView gradientTextView, CommunityRoomsView communityRoomsView, ViewPager2 viewPager2) {
        this.a = nestedSwipeRefreshLayout;
        this.b = bubbleTextView;
        this.c = appBarLayout;
        this.d = roomCacheAnimationView;
        this.e = appCompatImageView;
        this.f = magicIndicator;
        this.g = nestedSwipeRefreshLayout2;
        this.h = collapsingToolbarLayout;
        this.i = gradientTextView;
        this.j = communityRoomsView;
        this.k = viewPager2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static q a(View view) {
        AppBarLayout a;
        RoomCacheAnimationView a2;
        AppCompatImageView a3;
        MagicIndicator a4;
        ViewPager2 a5;
        int i = R$id.activity_tip;
        BubbleTextView a6 = f4.b.a(view, i);
        if (a6 != null && (a = f4.b.a(view, (i = R$id.appBar))) != null && (a2 = f4.b.a(view, (i = R$id.iv_cache))) != null && (a3 = f4.b.a(view, (i = R$id.iv_publish))) != null && (a4 = f4.b.a(view, (i = R$id.magic_indicator))) != null) {
            NestedSwipeRefreshLayout nestedSwipeRefreshLayout = (NestedSwipeRefreshLayout) view;
            i = R$id.toolbar_layout;
            CollapsingToolbarLayout a7 = f4.b.a(view, i);
            if (a7 != null) {
                i = R$id.tv_post;
                GradientTextView gradientTextView = (GradientTextView) f4.b.a(view, i);
                if (gradientTextView != null) {
                    i = R$id.v_recommend_rooms;
                    CommunityRoomsView communityRoomsView = (CommunityRoomsView) f4.b.a(view, i);
                    if (communityRoomsView != null && (a5 = f4.b.a(view, (i = R$id.view_pager))) != null) {
                        return new q(nestedSwipeRefreshLayout, a6, a, a2, a3, a4, nestedSwipeRefreshLayout, a7, gradientTextView, communityRoomsView, a5);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static q c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static q d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_room_home, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public NestedSwipeRefreshLayout getRoot() {
        return this.a;
    }
}
