package com.cloud.hisavana.sdk.api.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.core.content.b;
import com.cloud.hisavana.sdk.R$color;
import com.cloud.hisavana.sdk.R$drawable;
import com.cloud.hisavana.sdk.common.constant.Constants;
import com.cloud.sdk.commonutil.util.h;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class AdCloseView extends ImageView {

    public enum CloseImageType {
        CLOSE,
        EXPAND
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[CloseImageType.values().length];
            b = iArr;
            try {
                iArr[CloseImageType.CLOSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[CloseImageType.EXPAND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Constants.AdDisplayRule.values().length];
            a = iArr2;
            try {
                iArr2[Constants.AdDisplayRule.UNIVERSAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Constants.AdDisplayRule.RU.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public AdCloseView(Context context) {
        super(context);
        b();
    }

    public AdCloseView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public AdCloseView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    private Drawable a(CloseImageType closeImageType) {
        int i = a.b[closeImageType.ordinal()];
        if (i == 1) {
            return b.getDrawable(getContext(), R$drawable.hs_ad_close1);
        }
        if (i != 2) {
            return null;
        }
        return b.getDrawable(getContext(), R$drawable.hs_ad_expand);
    }

    private void b() {
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        int a2 = h.a(2.5f);
        setPadding(a2, a2, a2, a2);
        setBackgroundColor(b.getColor(getContext(), R$color.ad_badge_bg));
        setDisplayStyle(Constants.AdDisplayRule.UNIVERSAL, CloseImageType.CLOSE);
    }

    public void setDisplayStyle(Constants.AdDisplayRule adDisplayRule, CloseImageType closeImageType) {
        int i = a.a[adDisplayRule.ordinal()];
        if (i == 1) {
            setImageDrawable(a(closeImageType));
        } else {
            if (i != 2) {
                return;
            }
            setImageDrawable(a(CloseImageType.EXPAND));
        }
    }
}
