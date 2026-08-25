package com.hisavana.mediation.ad;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.hisavana.sdk.api.view.MediaView;
import com.cloud.hisavana.sdk.common.bean.AdImage;
import com.hisavana.common.base.BaseNativeViewHolder;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.mediation.R$styleable;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class TMediaView extends FrameLayout {
    public static final ImageView.ScaleType[] b = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    public ImageView.ScaleType a;

    public TMediaView(@NonNull Context context) {
        this(context, null);
    }

    public TMediaView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TMediaView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = ImageView.ScaleType.FIT_CENTER;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.TMediaView, i, 0);
        int i2 = obtainStyledAttributes.getInt(R$styleable.TMediaView_sspScaleType, 3);
        if (i2 >= 0) {
            ImageView.ScaleType[] scaleTypeArr = b;
            if (i2 < scaleTypeArr.length) {
                this.a = scaleTypeArr[i2];
            }
        }
        obtainStyledAttributes.recycle();
    }

    public void attachLayout(@NonNull BaseNativeViewHolder baseNativeViewHolder, TAdNativeInfo tAdNativeInfo) {
        if (baseNativeViewHolder == null) {
            return;
        }
        removeAllViews();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        View mediaView = baseNativeViewHolder.getMediaView(getContext(), tAdNativeInfo, this);
        layoutParams.gravity = 17;
        if (mediaView != null) {
            addView(mediaView, layoutParams);
        }
    }

    public View getMediaView() {
        if (getChildCount() > 0) {
            return getChildAt(0);
        }
        return null;
    }

    public void setMediaView(AdImage adImage) {
        MediaView mediaView = getMediaView();
        if (mediaView == null) {
            AdLogUtil.Log().w("TMediaView", "childView is null");
        } else if (mediaView instanceof MediaView) {
            mediaView.setMediaView(adImage, this.a, false);
        }
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.a = scaleType;
    }
}
