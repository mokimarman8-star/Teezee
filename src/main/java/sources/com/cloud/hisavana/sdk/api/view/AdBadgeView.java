package com.cloud.hisavana.sdk.api.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.b;
import com.cloud.hisavana.sdk.R$color;
import com.cloud.hisavana.sdk.R$string;
import com.cloud.hisavana.sdk.common.constant.Constants;
import com.cloud.sdk.commonutil.util.h;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class AdBadgeView extends TextView {

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Constants.AdDisplayRule.values().length];
            a = iArr;
            try {
                iArr[Constants.AdDisplayRule.UNIVERSAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Constants.AdDisplayRule.RU.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public AdBadgeView(Context context) {
        super(context);
        b();
    }

    public AdBadgeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public AdBadgeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    private String a(int i) {
        String charSequence = getResources().getText(R$string.ad_icon).toString();
        if (i <= 0) {
            return charSequence;
        }
        return charSequence + " " + i + "+";
    }

    private void b() {
        setGravity(17);
        setMaxWidth(h.a(80.0f));
        setTextSize(9.0f);
        setTypeface(Typeface.create("sans-serif-regular", 0));
        setLines(1);
        int a2 = h.a(2.2f);
        setPadding(a2, 0, a2, 0);
        setTextColor(b.getColor(getContext(), R$color.ad_badge_text));
        setBackgroundColor(b.getColor(getContext(), R$color.ad_badge_bg));
        setDisplayStyle(Constants.AdDisplayRule.UNIVERSAL, 0);
    }

    public void setDisplayStyle(Constants.AdDisplayRule adDisplayRule, int i) {
        int i2 = a.a[adDisplayRule.ordinal()];
        if (i2 == 1) {
            setText(R$string.ad_icon);
        } else {
            if (i2 != 2) {
                return;
            }
            setText(a(i));
        }
    }
}
