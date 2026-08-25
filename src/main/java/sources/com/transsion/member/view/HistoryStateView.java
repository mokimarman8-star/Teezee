package com.transsion.member.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.blankj.utilcode.util.a0;
import com.tn.lib.view.StateView;
import com.transsion.baseui.R;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ!\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\r\u0010\bR$\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t8T@TX\u0094\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/transsion/member/view/HistoryStateView;", "Lcom/tn/lib/view/StateView;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BuildConfig.FLAVOR, "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BuildConfig.FLAVOR, "b", "value", "getNoContentResId", "()I", "setNoContentResId", "(I)V", "noContentResId", "Member_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class HistoryStateView extends StateView {
    public static final int $stable = 8;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HistoryStateView(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HistoryStateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HistoryStateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void b(Context context, AttributeSet attrs) {
        Intrinsics.h(context, "context");
        super.b(context, attrs);
        eh.b mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            mViewBinding.f.setBackgroundResource(R.drawable.bg_radius_8_color_white_10p);
            mViewBinding.f.setTextColor(getResources().getColor(com.tn.lib.widget.R.color.common_white));
            ViewGroup.LayoutParams layoutParams = mViewBinding.f.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = a0.a(40.0f);
            mViewBinding.f.setLayoutParams(layoutParams);
            int a = a0.a(20.0f);
            mViewBinding.f.setTypeface(Typeface.defaultFromStyle(1));
            mViewBinding.f.setPadding(a, 0, a, 0);
            mViewBinding.e.setTextColor(getResources().getColor(com.tn.lib.widget.R.color.gray_dark_40));
        }
    }

    protected int getNoContentResId() {
        return com.tn.lib.widget.R.mipmap.ic_no_content_dark;
    }

    protected void setNoContentResId(int i) {
        super.setNoContentResId(i);
    }
}
