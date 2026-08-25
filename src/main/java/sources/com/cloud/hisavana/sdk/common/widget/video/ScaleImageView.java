package com.cloud.hisavana.sdk.common.widget.video;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.cloud.hisavana.sdk.b4;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000e\u0010\u000bR\u0016\u0010\b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/cloud/hisavana/sdk/common/widget/video/ScaleImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "videoWidth", "videoHeight", "", "setSize", "(II)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "d", "I", "e", "", "f", "Ljava/lang/String;", "TAG", "api_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class ScaleImageView extends AppCompatImageView {

    /* renamed from: d, reason: from kotlin metadata */
    private int videoHeight;

    /* renamed from: e, reason: from kotlin metadata */
    private int videoWidth;

    /* renamed from: f, reason: from kotlin metadata */
    private final String TAG;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScaleImageView(Context context) {
        super(context);
        Intrinsics.h(context, "context");
        this.TAG = "ScaleImageView";
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i;
        float rotation = getRotation();
        if (rotation == 90.0f || rotation == 270.0f) {
            heightMeasureSpec = widthMeasureSpec;
            widthMeasureSpec = heightMeasureSpec;
        }
        int defaultSize = View.getDefaultSize(this.videoWidth, widthMeasureSpec);
        int defaultSize2 = View.getDefaultSize(this.videoHeight, heightMeasureSpec);
        if (this.videoWidth > 0 && this.videoHeight > 0) {
            int mode = View.MeasureSpec.getMode(widthMeasureSpec);
            int size = View.MeasureSpec.getSize(widthMeasureSpec);
            int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
            int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
            b4.b().d(this.TAG, "widthSpecMode --->" + mode);
            b4.b().d(this.TAG, "heightSpecMode --->" + mode2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                b4.b().d(this.TAG, "onMeasure --->1");
                b4.b().d(this.TAG, "widthSpecSize --->" + size + " heightSpecSize--->" + size2);
                int i2 = this.videoWidth;
                int i3 = i2 * size2;
                int i4 = this.videoHeight;
                int i8 = size * i4;
                if (i3 < i8) {
                    defaultSize = i3 / i4;
                } else if (i3 > i8) {
                    int i9 = i8 / i2;
                    defaultSize = size;
                    defaultSize2 = i9;
                    b4.b().d(this.TAG, "width --->" + defaultSize + " height--->" + defaultSize2);
                } else {
                    defaultSize = size;
                }
                defaultSize2 = size2;
                b4.b().d(this.TAG, "width --->" + defaultSize + " height--->" + defaultSize2);
            } else if (mode == 1073741824) {
                b4.b().d(this.TAG, "onMeasure --->2");
                int i10 = this.videoHeight;
                int i11 = this.videoWidth;
                int i12 = (size * i10) / i11;
                if (mode2 != Integer.MIN_VALUE || i12 <= size2) {
                    defaultSize = size;
                    defaultSize2 = i12;
                } else {
                    defaultSize = (i11 * size2) / i10;
                    defaultSize2 = size2;
                }
            } else {
                if (mode2 == 1073741824) {
                    b4.b().d(this.TAG, "onMeasure --->3");
                    int i13 = this.videoWidth;
                    int i14 = this.videoHeight;
                    int i15 = (size2 * i13) / i14;
                    if (mode != Integer.MIN_VALUE || i15 <= size) {
                        defaultSize2 = size2;
                        defaultSize = i15;
                    } else {
                        defaultSize2 = (i14 * size) / i13;
                    }
                } else {
                    int i16 = this.videoWidth;
                    int i17 = this.videoHeight;
                    if (mode2 != Integer.MIN_VALUE || i17 <= size2) {
                        i = i16;
                        size2 = i17;
                    } else {
                        i = (size2 * i16) / i17;
                    }
                    if (mode != Integer.MIN_VALUE || i <= size) {
                        defaultSize = i;
                        defaultSize2 = size2;
                    } else {
                        defaultSize2 = (i17 * size) / i16;
                    }
                }
                defaultSize = size;
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setSize(int videoWidth, int videoHeight) {
        b4.b().d(this.TAG, "videoWidth = " + videoWidth + "    videoHeight=" + videoHeight);
        if (this.videoWidth == videoWidth || this.videoHeight == videoHeight) {
            return;
        }
        this.videoWidth = videoWidth;
        this.videoHeight = videoHeight;
        requestLayout();
    }
}
