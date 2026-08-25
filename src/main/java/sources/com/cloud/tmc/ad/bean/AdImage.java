package com.cloud.tmc.ad.bean;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;
import com.cloud.tmc.ad.bean.response.AdsDTO;
import com.cloud.tmc.ad.utils.CommonLogUtil;
import com.cloud.tmc.kernel.utils.TraceLog;
import java.io.Serializable;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class AdImage implements Serializable {
    public AdsDTO adsDTO;
    private String bgPath;
    private Drawable drawable;
    private String filePath;
    private int h;
    private String imgUrl;
    private boolean isCached;
    private int mType;
    private int mime;
    private int w;

    public AdImage() {
        this.isCached = false;
        this.mType = 2;
    }

    public AdImage(int i, Drawable drawable, String str) {
        this.isCached = false;
        this.mType = 2;
        this.mime = i;
        this.drawable = drawable;
        this.filePath = str;
    }

    public AdImage(Drawable drawable, String str) {
        this.isCached = false;
        this.mType = 2;
        this.mime = 1;
        this.drawable = drawable;
        this.filePath = str;
    }

    private Bitmap getBitmap() {
        Drawable drawable = this.drawable;
        if (drawable == null) {
            return null;
        }
        try {
            return ((BitmapDrawable) drawable).getBitmap();
        } catch (Throwable th) {
            TraceLog.e(CommonLogUtil.TAG_AD, Log.getStackTraceString(th));
            return null;
        }
    }

    public boolean attachView(ImageView imageView) {
        Drawable drawable;
        if (imageView == null || (drawable = this.drawable) == null) {
            return false;
        }
        imageView.setImageDrawable(drawable);
        return true;
    }

    public String getBgPath() {
        return this.bgPath;
    }

    public int getByteSize() {
        Bitmap bitmap = getBitmap();
        if (bitmap != null) {
            return bitmap.getByteCount();
        }
        return 0;
    }

    public Drawable getDrawable() {
        return this.drawable;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public int getH() {
        return this.h;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public int getMime() {
        return this.mime;
    }

    public int getW() {
        return this.w;
    }

    public int getmType() {
        return this.mType;
    }

    public boolean isAdImageRecycled() {
        Bitmap bitmap = getBitmap();
        return this.drawable == null || (bitmap != null && bitmap.isRecycled());
    }

    public boolean isCached() {
        return this.isCached;
    }

    public void setBgPath(String str) {
        this.bgPath = str;
    }

    public void setCached(boolean z) {
        this.isCached = z;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setH(int i) {
        this.h = i;
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
    }

    public void setMime(int i) {
        this.mime = i;
    }

    public void setW(int i) {
        this.w = i;
    }

    public void setmType(int i) {
        this.mType = i;
    }
}
