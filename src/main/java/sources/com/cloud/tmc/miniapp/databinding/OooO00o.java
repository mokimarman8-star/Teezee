package com.cloud.tmc.miniapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniapp.widget.AddScreenView;
import com.cloud.tmc.miniapp.widget.ImmersiveTitleBarView;
import com.cloud.tmc.miniapp.widget.PageContainerView;
import com.cloud.tmc.miniapp.widget.StatusLayout;
import com.cloud.tmc.miniapp.widget.TabBarView;
import f4.a;
import f4.b;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO00o implements a {

    @NonNull
    public final ConstraintLayout OooO00o;

    @NonNull
    public final PageContainerView OooO0O0;

    @NonNull
    public final FrameLayout OooO0OO;

    @NonNull
    public final ImageView OooO0Oo;

    @NonNull
    public final TabBarView OooO0o;

    @NonNull
    public final ProgressBar OooO0o0;

    @NonNull
    public final ImmersiveTitleBarView OooO0oO;

    @NonNull
    public final View OooO0oo;

    public OooO00o(@NonNull ConstraintLayout constraintLayout, @NonNull AddScreenView addScreenView, @NonNull PageContainerView pageContainerView, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ProgressBar progressBar, @NonNull StatusLayout statusLayout, @NonNull TabBarView tabBarView, @NonNull ImmersiveTitleBarView immersiveTitleBarView, @NonNull View view) {
        this.OooO00o = constraintLayout;
        this.OooO0O0 = pageContainerView;
        this.OooO0OO = frameLayout;
        this.OooO0Oo = imageView;
        this.OooO0o0 = progressBar;
        this.OooO0o = tabBarView;
        this.OooO0oO = immersiveTitleBarView;
        this.OooO0oo = view;
    }

    @NonNull
    public static OooO00o OooO00o(@NonNull LayoutInflater layoutInflater) {
        View a;
        ConstraintLayout inflate = layoutInflater.inflate(R.layout.fragment_mini, (ViewGroup) null, false);
        int i = R.id.addScreenView;
        AddScreenView addScreenView = (AddScreenView) b.a(inflate, i);
        if (addScreenView != null) {
            i = R.id.fl;
            PageContainerView pageContainerView = (PageContainerView) b.a(inflate, i);
            if (pageContainerView != null) {
                i = R.id.fl_fullscreen;
                FrameLayout frameLayout = (FrameLayout) b.a(inflate, i);
                if (frameLayout != null) {
                    i = R.id.fl_loading_mask;
                    FrameLayout frameLayout2 = (FrameLayout) b.a(inflate, i);
                    if (frameLayout2 != null) {
                        i = R.id.iv_fullscreen_back;
                        ImageView imageView = (ImageView) b.a(inflate, i);
                        if (imageView != null) {
                            i = R.id.iv_loading;
                            ImageView imageView2 = (ImageView) b.a(inflate, i);
                            if (imageView2 != null) {
                                i = R.id.pb;
                                ProgressBar progressBar = (ProgressBar) b.a(inflate, i);
                                if (progressBar != null) {
                                    i = R.id.sl_status;
                                    StatusLayout statusLayout = (StatusLayout) b.a(inflate, i);
                                    if (statusLayout != null) {
                                        i = R.id.tabBar;
                                        TabBarView tabBarView = (TabBarView) b.a(inflate, i);
                                        if (tabBarView != null) {
                                            i = R.id.titleBar;
                                            ImmersiveTitleBarView immersiveTitleBarView = (ImmersiveTitleBarView) b.a(inflate, i);
                                            if (immersiveTitleBarView != null && (a = b.a(inflate, (i = R.id.view_mask))) != null) {
                                                return new OooO00o(inflate, addScreenView, pageContainerView, frameLayout, frameLayout2, imageView, imageView2, progressBar, statusLayout, tabBarView, immersiveTitleBarView, a);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @NonNull
    public View getRoot() {
        return this.OooO00o;
    }
}
