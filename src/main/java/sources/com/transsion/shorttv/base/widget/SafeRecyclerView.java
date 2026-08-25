package com.transsion.shorttv.base.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0014¨\u0006\u0012"}, d2 = {"Lcom/transsion/shorttv/base/widget/SafeRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", BuildConfig.FLAVOR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onLayout", BuildConfig.FLAVOR, "changed", BuildConfig.FLAVOR, "l", "t", "r", "b", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SafeRecyclerView extends RecyclerView {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SafeRecyclerView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SafeRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SafeRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
    }

    public /* synthetic */ SafeRecyclerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(SafeRecyclerView safeRecyclerView) {
        safeRecyclerView.requestLayout();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        String message;
        try {
            super.onLayout(changed, l, t, r, b);
        } catch (IllegalArgumentException e) {
            String message2 = e.getMessage();
            if ((message2 == null || !StringsKt.c0(message2, "recycled", false, 2, (Object) null)) && ((message = e.getMessage()) == null || !StringsKt.c0(message, "Scrapped", false, 2, (Object) null))) {
                throw e;
            }
            post(new Runnable() { // from class: com.transsion.shorttv.base.widget.l
                @Override // java.lang.Runnable
                public final void run() {
                    SafeRecyclerView.b(SafeRecyclerView.this);
                }
            });
        }
    }
}
