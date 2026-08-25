package com.hisavana.mediation.ad;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.sdk.commonutil.util.h;
import com.hisavana.mediation.R$styleable;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class TStoreMarkView extends FrameLayout {
    public int a;
    public int b;

    public TStoreMarkView(@NonNull Context context) {
        this(context, null);
    }

    public TStoreMarkView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TStoreMarkView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.TStoreMarkView);
            this.b = obtainStyledAttributes.getColor(R$styleable.TStoreMarkView_storeTextColor, -1);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.TStoreMarkView_storeTextSize, 0);
            this.a = dimensionPixelSize == 0 ? 8 : h.h(dimensionPixelSize);
            obtainStyledAttributes.recycle();
        }
    }

    public int getTextColor() {
        return this.b;
    }

    public int getTextSize() {
        return this.a;
    }
}
