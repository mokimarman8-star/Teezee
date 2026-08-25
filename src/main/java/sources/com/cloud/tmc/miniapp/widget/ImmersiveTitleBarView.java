package com.cloud.tmc.miniapp.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.cloud.tmc.integration.constants.IntegrationConstants;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.structure.PageContext;
import com.cloud.tmc.integration.structure.ui.TitleBar;
import com.cloud.tmc.integration.utils.FastClickUtil;
import com.cloud.tmc.integration.utils.MiniBarUtils;
import com.cloud.tmc.integration.utils.ext.CommonExtKt;
import com.cloud.tmc.integration.utils.ext.ViewExtKt;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniutils.util.SystemUtils;
import com.cloud.tmc.miniutils.util.ViewUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class ImmersiveTitleBarView extends FrameLayout implements TitleBar {
    public final Lazy OooO;
    public View.OnClickListener OooO00o;
    public View.OnClickListener OooO0O0;
    public View.OnClickListener OooO0OO;
    public final Lazy OooO0Oo;
    public final Lazy OooO0o;
    public final Lazy OooO0o0;
    public final Lazy OooO0oO;
    public final Lazy OooO0oo;
    public int OooOO0;
    public boolean OooOO0O;
    public int OooOO0o;
    public AddScreenView OooOOO;
    public int OooOOO0;

    public static final class OooO extends Lambda implements Function0<FrameLayout> {
        public OooO() {
            super(0);
        }

        public Object invoke() {
            return (FrameLayout) ImmersiveTitleBarView.this.findViewById(R.id.fl_menu_container);
        }
    }

    public static final class OooO00o extends Lambda implements Function0<Unit> {
        public OooO00o() {
            super(0);
        }

        public Object invoke() {
            ImmersiveTitleBarView immersiveTitleBarView = ImmersiveTitleBarView.this;
            View.OnClickListener onClickListener = immersiveTitleBarView.OooO00o;
            if (onClickListener != null) {
                onClickListener.onClick(immersiveTitleBarView.getCapsule());
            }
            return Unit.a;
        }
    }

    public static final class OooO0O0 extends Lambda implements Function0<Unit> {
        public OooO0O0() {
            super(0);
        }

        public Object invoke() {
            ImmersiveTitleBarView immersiveTitleBarView = ImmersiveTitleBarView.this;
            View.OnClickListener onClickListener = immersiveTitleBarView.OooO0O0;
            if (onClickListener != null) {
                onClickListener.onClick(immersiveTitleBarView.getCapsule());
            }
            return Unit.a;
        }
    }

    public static final class OooO0OO extends Lambda implements Function0<CapsuleView> {
        public OooO0OO() {
            super(0);
        }

        public Object invoke() {
            return (CapsuleView) ImmersiveTitleBarView.this.findViewById(R.id.capsule);
        }
    }

    public static final class OooO0o extends Lambda implements Function0<FrameLayout> {
        public OooO0o() {
            super(0);
        }

        public Object invoke() {
            return (FrameLayout) ImmersiveTitleBarView.this.findViewById(R.id.fl_home);
        }
    }

    public static final class OooOO0 extends Lambda implements Function0<AppCompatImageView> {
        public OooOO0() {
            super(0);
        }

        public Object invoke() {
            return ImmersiveTitleBarView.this.findViewById(R.id.iv_add_screen);
        }
    }

    public static final class OooOO0O extends Lambda implements Function0<AppCompatImageView> {
        public OooOO0O() {
            super(0);
        }

        public Object invoke() {
            return ImmersiveTitleBarView.this.findViewById(R.id.iv_home);
        }
    }

    public static final class OooOOO0 extends Lambda implements Function0<TextView> {
        public OooOOO0() {
            super(0);
        }

        public Object invoke() {
            return (TextView) ImmersiveTitleBarView.this.findViewById(R.id.tv_app_title);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImmersiveTitleBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.h(context, "context");
        this.OooO0Oo = LazyKt.b(new OooO0o());
        this.OooO0o0 = LazyKt.b(new OooOO0O());
        this.OooO0o = LazyKt.b(new OooO0OO());
        this.OooO0oO = LazyKt.b(new OooO());
        this.OooO0oo = LazyKt.b(new OooOO0());
        this.OooO = LazyKt.b(new OooOOO0());
        this.OooOO0o = 1;
        LayoutInflater.from(context).inflate(R.layout.layout_mini_app_title_bar, this);
        getIvHome().setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.widget.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ImmersiveTitleBarView.OooO00o(ImmersiveTitleBarView.this, view);
            }
        });
        try {
            getIvHome().setRotationY(ViewUtils.isLayoutRtl() ? 180.0f : 0.0f);
        } catch (Throwable th) {
            TmcLogger.e("TitleBarView", th);
        }
        CapsuleView capsule = getCapsule();
        capsule.setOnLeftClickListener(new OooO00o());
        capsule.setOnRightClickListener(new OooO0O0());
        OooO00o();
    }

    public static final void OooO00o(ImmersiveTitleBarView immersiveTitleBarView, View view) {
        View.OnClickListener onClickListener;
        Intrinsics.h(immersiveTitleBarView, "this$0");
        if (FastClickUtil.isFastDoubleClick()) {
            return;
        }
        int i = immersiveTitleBarView.OooOO0;
        if (i != 0) {
            if (i == 1 && (onClickListener = immersiveTitleBarView.OooO00o) != null) {
                onClickListener.onClick(view);
                return;
            }
            return;
        }
        View.OnClickListener onClickListener2 = immersiveTitleBarView.OooO0O0;
        if (onClickListener2 != null) {
            onClickListener2.onClick(view);
        }
    }

    public static final void OooO0O0(ImmersiveTitleBarView immersiveTitleBarView, View view) {
        View.OnClickListener onClickListener;
        Intrinsics.h(immersiveTitleBarView, "this$0");
        if (FastClickUtil.isFastDoubleClick() || (onClickListener = immersiveTitleBarView.OooO0OO) == null) {
            return;
        }
        onClickListener.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CapsuleView getCapsule() {
        Object value = this.OooO0o.getValue();
        Intrinsics.g(value, "<get-capsule>(...)");
        return (CapsuleView) value;
    }

    private final FrameLayout getFlHome() {
        Object value = this.OooO0Oo.getValue();
        Intrinsics.g(value, "<get-flHome>(...)");
        return (FrameLayout) value;
    }

    private final FrameLayout getFlMenuContainer() {
        Object value = this.OooO0oO.getValue();
        Intrinsics.g(value, "<get-flMenuContainer>(...)");
        return (FrameLayout) value;
    }

    private final AppCompatImageView getIvAddScreen() {
        Object value = this.OooO0oo.getValue();
        Intrinsics.g(value, "<get-ivAddScreen>(...)");
        return (AppCompatImageView) value;
    }

    private final AppCompatImageView getIvHome() {
        Object value = this.OooO0o0.getValue();
        Intrinsics.g(value, "<get-ivHome>(...)");
        return (AppCompatImageView) value;
    }

    private final TextView getTvAppTitle() {
        Object value = this.OooO.getValue();
        Intrinsics.g(value, "<get-tvAppTitle>(...)");
        return (TextView) value;
    }

    public final void OooO00o() {
        int i = !SystemUtils.darkThemeIsEnabled(getContext()) ? 1 : 0;
        this.OooOO0o = i;
        setThemeMode(i);
        setPadding(0, isInEditMode() ? CommonExtKt.getDp2px(24) : MiniBarUtils.getStatusHeight(), 0, 0);
        try {
            setBackgroundColor(Color.parseColor(IntegrationConstants.INSTANCE.getDefaultNavigationBarBackgroundColor(getContext())));
        } catch (Throwable th) {
            TmcLogger.e("[ImmersiveTitleBarView]: error", th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void attachPage(Page page) {
        AddScreenView addScreenView;
        PageContext pageContext;
        ViewGroup contentView;
        AppCompatImageView appCompatImageView;
        if (page == null || (pageContext = page.getPageContext()) == null || (contentView = pageContext.getContentView()) == null || (appCompatImageView = (AddScreenView) contentView.findViewById(R.id.addScreenView)) == 0) {
            addScreenView = null;
        } else {
            appCompatImageView.setTranslationY(appCompatImageView.getTranslationY() + MiniBarUtils.getStatusHeight());
            appCompatImageView.setTranslationX(ViewUtils.isLayoutRtl() ? getResources().getDimension(R.dimen.mini_dp_100) : getResources().getDimension(R.dimen.mini_dp_m_100));
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.widget.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ImmersiveTitleBarView.OooO0O0(ImmersiveTitleBarView.this, view);
                }
            });
            addScreenView = appCompatImageView;
        }
        this.OooOOO = addScreenView;
    }

    public boolean getAddScreenVisibility() {
        AppCompatImageView appCompatImageView = this.OooOOO;
        return appCompatImageView != null && ViewExtKt.getVisible(appCompatImageView);
    }

    public View getContent() {
        return this;
    }

    public Integer getHomeAction() {
        return Integer.valueOf(this.OooOO0);
    }

    public boolean isTransparent() {
        return this.OooOO0O;
    }

    public void setAddScreenVisibility(boolean z) {
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
        if (this.OooOO0O) {
            return;
        }
        this.OooOOO0 = i;
    }

    public void setHomeAction(int i, boolean z) {
        this.OooOO0 = i;
        if (z) {
            setThemeMode(this.OooOO0o);
        }
    }

    public void setHomeVisibility(boolean z) {
        ViewExtKt.toVisibleOrGone(getFlHome(), z);
    }

    public void setOnAddScreenClickListener(View.OnClickListener onClickListener) {
        this.OooO0OO = onClickListener;
    }

    public void setOnBackClickListener(View.OnClickListener onClickListener) {
        this.OooO00o = onClickListener;
    }

    public void setOnHomeClickListener(View.OnClickListener onClickListener) {
        this.OooO0O0 = onClickListener;
    }

    public void setThemeMode(int i) {
        AddScreenView addScreenView;
        this.OooOO0o = i;
        AppCompatImageView appCompatImageView = this.OooOOO;
        if (appCompatImageView != null && ViewExtKt.getVisible(appCompatImageView) && (addScreenView = this.OooOOO) != null) {
            addScreenView.setThemeMode(i);
        }
        if (ViewExtKt.getVisible(this)) {
            int i2 = 0;
            ViewExtKt.toVisibleOrGone(getIvHome(), this.OooOO0 != 2);
            ViewExtKt.toVisibleOrGone(getCapsule(), this.OooOO0 == 2);
            if (ViewExtKt.getVisible(getCapsule())) {
                CapsuleView.OooO00o(getCapsule(), i, null, 2);
            }
            if (i == 0) {
                getIvHome().setBackgroundResource(R.drawable.shape_bg_title_bar_no_stroke_white_mode);
                AppCompatImageView ivHome = getIvHome();
                int i3 = this.OooOO0;
                if (i3 == 0) {
                    i2 = R.drawable.mini_ic_title_home_white_mode;
                } else if (i3 == 1) {
                    i2 = R.drawable.mini_ic_title_back_white_mode;
                }
                ivHome.setImageResource(i2);
                return;
            }
            if (i != 1) {
                return;
            }
            getIvHome().setBackgroundResource(R.drawable.shape_bg_title_bar_no_stroke_black_mode);
            AppCompatImageView ivHome2 = getIvHome();
            int i4 = this.OooOO0;
            if (i4 == 0) {
                i2 = R.drawable.mini_ic_immersive_title_bar_home_black_mode;
            } else if (i4 == 1) {
                i2 = R.drawable.mini_ic_immersive_title_bar_back_black_mode;
            }
            ivHome2.setImageResource(i2);
        }
    }

    public void setTitle(String str) {
        TextView tvAppTitle = getTvAppTitle();
        if (str != null) {
            tvAppTitle.setText(str);
        }
    }

    public void setTitleBarVisible(boolean z) {
        if (z) {
            setThemeMode(this.OooOO0o);
        }
        ViewExtKt.toVisibleOrGone(this, z);
    }

    public void setTitleColor(boolean z) {
        getTvAppTitle().setTextColor(androidx.core.content.b.getColor(getContext(), z ? R.color.default_navigation_bar_title_white_color : R.color.default_navigation_bar_title_black_color));
    }

    public void setTitleVisible(boolean z) {
        ViewExtKt.toVisibleOrGone(getTvAppTitle(), z);
    }

    public void setTransparent(boolean z) {
        this.OooOO0O = z;
        if (z) {
            setBackgroundColor(0);
        } else {
            setBackgroundColor(this.OooOOO0);
        }
    }
}
