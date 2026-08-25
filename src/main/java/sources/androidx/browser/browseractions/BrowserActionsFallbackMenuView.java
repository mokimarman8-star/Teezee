package androidx.browser.browseractions;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.browser.R$dimen;

@Deprecated
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class BrowserActionsFallbackMenuView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private final int f1150a;

    /* renamed from: b, reason: collision with root package name */
    private final int f1151b;

    public BrowserActionsFallbackMenuView(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1150a = getResources().getDimensionPixelOffset(R$dimen.browser_actions_context_menu_min_padding);
        this.f1151b = getResources().getDimensionPixelOffset(R$dimen.browser_actions_context_menu_max_width);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i5, int i6) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(getResources().getDisplayMetrics().widthPixels - (this.f1150a * 2), this.f1151b), 1073741824), i6);
    }
}
