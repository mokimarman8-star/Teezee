package com.transsion.publish.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.blankj.utilcode.util.h;
import com.tn.lib.widget.R;
import com.tn.lib.widget.TnTextView;
import com.transsion.gslb.BuildConfig;
import com.transsion.publish.R$id;
import com.transsion.publish.R$layout;
import com.transsion.publish.R$styleable;
import com.transsion.push.PushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0015R\u0014\u0010\u001e\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/transsion/publish/view/CustomHeader;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BuildConfig.FLAVOR, "title", BuildConfig.FLAVOR, "setTitle", "(Ljava/lang/String;)V", "Landroid/view/View$OnClickListener;", PushConstants.PUSH_SERVICE_TYPE_CLICK, "setOnBackClick", "(Landroid/view/View$OnClickListener;)V", "setOnEditClick", "onSearchClick", "Landroid/widget/ImageView;", "a", "Landroid/widget/ImageView;", "iBack", "Lcom/tn/lib/widget/TnTextView;", "b", "Lcom/tn/lib/widget/TnTextView;", "vTitle", "c", "iSearch", "d", "vEdit", "Publish_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class CustomHeader extends RelativeLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private final ImageView iBack;

    /* renamed from: b, reason: from kotlin metadata */
    private final TnTextView vTitle;

    /* renamed from: c, reason: from kotlin metadata */
    private final ImageView iSearch;

    /* renamed from: d, reason: from kotlin metadata */
    private final TnTextView vEdit;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i;
        int i2;
        Intrinsics.h(context, "context");
        LayoutInflater.from(context).inflate(R$layout.common_layout_header, (ViewGroup) this, true);
        View findViewById = findViewById(R$id.iv_back);
        Intrinsics.g(findViewById, "findViewById(...)");
        this.iBack = (ImageView) findViewById;
        TnTextView findViewById2 = findViewById(R$id.tv_title);
        Intrinsics.g(findViewById2, "findViewById(...)");
        this.vTitle = findViewById2;
        View findViewById3 = findViewById(R$id.iv_search);
        Intrinsics.g(findViewById3, "findViewById(...)");
        this.iSearch = (ImageView) findViewById3;
        TnTextView findViewById4 = findViewById(R$id.tv_edit);
        Intrinsics.g(findViewById4, "findViewById(...)");
        this.vEdit = findViewById4;
        if (attributeSet != null) {
            int attributeCount = attributeSet.getAttributeCount();
            for (int i3 = 0; i3 < attributeCount; i3++) {
                if (Intrinsics.c(attributeSet.getAttributeName(i3), "titleValue")) {
                    i = attributeSet.getAttributeResourceValue(i3, 0);
                    break;
                }
            }
        }
        i = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CustomHeader);
        Intrinsics.g(obtainStyledAttributes, "obtainStyledAttributes(...)");
        if (i != 0) {
            this.vTitle.setTextById(i);
        }
        if (attributeSet != null) {
            int attributeCount2 = attributeSet.getAttributeCount();
            for (int i4 = 0; i4 < attributeCount2; i4++) {
                if (Intrinsics.c(attributeSet.getAttributeName(i4), "rightValue")) {
                    i2 = attributeSet.getAttributeResourceValue(i4, 0);
                    break;
                }
            }
        }
        i2 = 0;
        this.vEdit.setTextColor(h.a(R.color.cl01));
        this.vEdit.setTypeface(Typeface.DEFAULT_BOLD);
        if (i2 != 0) {
            this.vEdit.setTextById(i2);
        }
        boolean z = obtainStyledAttributes.getBoolean(R$styleable.CustomHeader_showSearch, false);
        boolean z2 = obtainStyledAttributes.getBoolean(R$styleable.CustomHeader_showEdit, false);
        this.iSearch.setVisibility(z ? 0 : 8);
        this.vEdit.setVisibility(z2 ? 0 : 8);
        this.iBack.setImageResource(obtainStyledAttributes.getBoolean(R$styleable.CustomHeader_isBack, true) ? R.mipmap.libui_ic_back_black : R.mipmap.libui_ic_back_black);
        obtainStyledAttributes.recycle();
    }

    public final void onSearchClick(View.OnClickListener click) {
        this.iSearch.setOnClickListener(click);
    }

    public final void setOnBackClick(View.OnClickListener click) {
        this.iBack.setOnClickListener(click);
    }

    public final void setOnEditClick(View.OnClickListener click) {
        this.vEdit.setOnClickListener(click);
    }

    public final void setTitle(String title) {
        this.vTitle.setText(title);
    }
}
