package com.cloud.tmc.miniapp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.R;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class AddScreenView extends AppCompatImageView {
    public int OooO00o;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AddScreenView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AddScreenView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AddScreenView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        this.OooO00o = 1;
        try {
            OooO00o();
        } catch (Throwable th) {
            TmcLogger.e("AddScreenView", "addScreenView init fail!", th);
        }
    }

    public /* synthetic */ AddScreenView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void OooO00o() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.width = getResources().getDimensionPixelSize(R.dimen.mini_dp_32);
            layoutParams2.height = getResources().getDimensionPixelSize(R.dimen.mini_dp_32);
            layoutParams2.gravity = 17;
            setLayoutParams(layoutParams2);
        }
        setPadding(getResources().getDimensionPixelSize(R.dimen.mini_dp_4), getResources().getDimensionPixelSize(R.dimen.mini_dp_4), getResources().getDimensionPixelSize(R.dimen.mini_dp_4), getResources().getDimensionPixelSize(R.dimen.mini_dp_4));
        setThemeMode(this.OooO00o);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setThemeMode(int i) {
        this.OooO00o = i;
        if (i == 0) {
            setBackgroundResource(R.drawable.shape_bg_title_bar_white_mode);
            setImageResource(R.drawable.mini_ic_title_add_screen_white_mode);
            setForeground(androidx.core.content.b.getDrawable(getContext(), R.drawable.shape_fg_title_bar_white_mode));
            return;
        }
        if (i != 1) {
            return;
        }
        setBackgroundResource(R.drawable.shape_bg_title_bar_circle_btn_black_mode);
        setImageResource(R.drawable.mini_ic_title_add_screen_black_mode);
        setForeground(androidx.core.content.b.getDrawable(getContext(), R.drawable.shape_fg_title_bar_black_mode));
    }
}
