package com.cloud.hisavana.sdk.common.widget.video;

import android.content.Context;
import android.view.TextureView;
import android.view.View;
import com.cloud.hisavana.sdk.b4;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class MediaTextureView extends TextureView {
    private int a;
    private int b;

    public MediaTextureView(Context context) {
        super(context);
    }

    public void adaptVideoSize(int i, int i2) {
        b4.b().d("MediaTextureView", "videoWidth --->" + i);
        b4.b().d("MediaTextureView", "videoHeight --->" + i2);
        b4.b().d("MediaTextureView", "this.videoWidth --->" + this.b);
        b4.b().d("MediaTextureView", "this.videoHeight --->" + this.a);
        if (this.b == i || this.a == i2) {
            return;
        }
        this.b = i;
        this.a = i2;
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        float rotation = getRotation();
        if (rotation == 90.0f || rotation == 270.0f) {
            i2 = i;
            i = i2;
        }
        int defaultSize = View.getDefaultSize(this.b, i);
        int defaultSize2 = View.getDefaultSize(this.a, i2);
        if (this.b > 0 && this.a > 0) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i3 = this.b;
                int i4 = i3 * size2;
                int i8 = this.a;
                int i9 = size * i8;
                if (i4 < i9) {
                    defaultSize = i4 / i8;
                    defaultSize2 = size2;
                } else {
                    if (i4 > i9) {
                        defaultSize2 = i9 / i3;
                        defaultSize = size;
                    }
                    defaultSize = size;
                    defaultSize2 = size2;
                }
            } else if (mode == 1073741824) {
                int i10 = this.a;
                int i11 = this.b;
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
                    int i13 = this.b;
                    int i14 = this.a;
                    int i15 = (size2 * i13) / i14;
                    if (mode != Integer.MIN_VALUE || i15 <= size) {
                        defaultSize2 = size2;
                        defaultSize = i15;
                    } else {
                        defaultSize2 = (i14 * size) / i13;
                    }
                } else {
                    if (size > 0 || size2 > 0) {
                        int i16 = this.b;
                        int i17 = size / i16;
                        int i18 = this.a;
                        if (i17 >= size2 / i18) {
                            defaultSize = (i16 * size2) / i18;
                            defaultSize2 = size2;
                        } else {
                            defaultSize2 = (i18 * size) / i16;
                        }
                    }
                    defaultSize = size;
                    defaultSize2 = size2;
                }
                defaultSize = size;
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    @Override // android.view.View
    public void setRotation(float f) {
        if (f != getRotation()) {
            super.setRotation(f);
            requestLayout();
        }
    }
}
