package com.hisavana.common.utils;

import android.graphics.Bitmap;
import com.hisavana.common.constant.ComConstants;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class BitmapUtil {
    public static void recycle(Bitmap bitmap) {
        if (bitmap == null || !ComConstants.LITE) {
            return;
        }
        bitmap.recycle();
    }
}
