package com.hisavana.common.utils;

import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import com.cloud.hisavana.sdk.common.http.DownLoadRequest;
import com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import n7.b;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class MediationImageLoader {
    public static void loadImage(String str, ImageView imageView) {
        if (imageView != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    AdLogUtil.Log().d("ContentValues", "loadImageView,url:" + str);
                    if (b.e(str, false, imageView)) {
                        AdLogUtil.Log().d("ContentValues", "loadImageView,mediation picasso || glide");
                    } else {
                        DownLoadRequest.o(str, (AdsDTO) null, 9, (DrawableResponseListener) null, imageView);
                        AdLogUtil.Log().d("ContentValues", "loadImageView,mediation ssp");
                    }
                }
            } catch (Throwable th) {
                AdLogUtil.Log().d("ContentValues", "ALL " + Log.getStackTraceString(th));
            }
        }
    }
}
