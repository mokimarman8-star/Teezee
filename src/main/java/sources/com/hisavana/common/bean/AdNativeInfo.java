package com.hisavana.common.bean;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.cloud.hisavana.sdk.common.bean.SSPWebRecommendInfo;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.common.utils.BitmapUtil;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class AdNativeInfo extends TAdNativeInfo {
    private String adCallToAction;
    private String adCreateId;
    private int adFormat;
    private String adId;
    private int adSource;
    private String appInfo;
    private String brand;
    private String cId;
    private String deepLink;
    private String description;
    private String description2;
    private String display;
    private double ecpmPrice;
    private String ext;
    private Image icon;
    private Drawable iconDrawable;
    private List<TAdNativeInfo.Image> imageList;
    private boolean isIconAd;
    private boolean isInternalAd;
    private boolean isOfflineAd;
    private boolean mIsRelease;
    private String materialStyle;
    private double maxPrice;
    private String mediatorSourceName;
    private String mediatorSourceUnitId;
    public int mime;
    private NativeAdWrapper nativeAdWrapper;
    private String packageName;
    private String pkgs;
    private String price;
    private String rating;
    private String requestId;
    private String saleprice;
    private String sceneId;
    private String sceneToken;
    private double secondPrice;
    private String showId;
    private String socialContext;
    private String sourceSize;
    private String sponsoredTranslation;
    private String title;
    private String triggerId;
    private Long triggerTs;
    private int ttl;
    private int hisavanaSource = 0;
    private int FillSource = 0;
    private int adType = 1;
    private boolean useRecommendStatus = false;
    private List<SSPWebRecommendInfo> sspWebRecommendInfos = null;
    private int pullNewestLive = -1;
    private long startCacheTime = System.currentTimeMillis();

    public static class Image extends TAdNativeInfo.Image {
        private boolean cached;
        private Drawable drawable;
        private int height;
        private float ratio;
        private String url;
        private int width;

        @Override // com.hisavana.common.bean.TAdNativeInfo.Image
        public boolean canUse() {
            try {
                Drawable drawable = this.drawable;
                if (drawable == null) {
                    return false;
                }
                Bitmap bitmap = drawable instanceof BitmapDrawable ? ((BitmapDrawable) drawable).getBitmap() : null;
                if (bitmap != null) {
                    if (bitmap.isRecycled()) {
                        return false;
                    }
                }
                return true;
            } catch (Throwable th) {
                AdLogUtil.Log().e(Log.getStackTraceString(th));
                return false;
            }
        }

        @Override // com.hisavana.common.bean.TAdNativeInfo.Image
        public Drawable getDrawable() {
            return this.drawable;
        }

        @Override // com.hisavana.common.bean.TAdNativeInfo.Image
        public int getHeight() {
            return this.height;
        }

        @Override // com.hisavana.common.bean.TAdNativeInfo.Image
        public float getRatio() {
            return this.ratio;
        }

        @Override // com.hisavana.common.bean.TAdNativeInfo.Image
        public String getUrl() {
            return this.url;
        }

        @Override // com.hisavana.common.bean.TAdNativeInfo.Image
        public int getWidth() {
            return this.width;
        }

        @Override // com.hisavana.common.bean.TAdNativeInfo.Image
        public boolean isCached() {
            return this.cached;
        }

        @Override // com.hisavana.common.bean.TAdNativeInfo.Image
        public void release() {
            try {
                Drawable drawable = this.drawable;
                if (drawable == null || !(drawable instanceof BitmapDrawable)) {
                    return;
                }
                BitmapUtil.recycle(((BitmapDrawable) drawable).getBitmap());
                this.drawable = null;
            } catch (Throwable th) {
                AdLogUtil.Log().e(Log.getStackTraceString(th));
            }
        }

        public void setCached(boolean z) {
            this.cached = z;
        }

        @Override // com.hisavana.common.bean.TAdNativeInfo.Image
        public void setDrawable(Drawable drawable) {
            this.drawable = drawable;
        }

        public void setHeight(int i) {
            this.height = i;
        }

        public void setRatio(float f) {
            this.ratio = f;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public void setWidth(int i) {
            this.width = i;
        }

        public String toString() {
            return "Image{url='" + this.url + "', drawable=" + this.drawable + ", width=" + this.width + ", height=" + this.height + ", ratio=" + this.ratio + '}';
        }
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public void destroyAd() {
        release();
        this.icon = null;
        List<TAdNativeInfo.Image> list = this.imageList;
        if (list != null) {
            list.clear();
        }
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public void detachContext() {
        NativeAdWrapper nativeAdWrapper = this.nativeAdWrapper;
        if (nativeAdWrapper != null) {
            nativeAdWrapper.detachContext();
        }
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public String getAdCallToAction() {
        return this.adCallToAction;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public String getAdCreateId() {
        return this.adCreateId;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public int getAdFormat() {
        return this.adFormat;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public String getAdId() {
        return this.adId;
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public int getAdSource() {
        return this.adSource;
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public int getAdType() {
        return this.adType;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public String getAppInfo() {
        return this.appInfo;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public String getBrand() {
        return this.brand;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public String getDeepLink() {
        return null;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public String getDescription() {
        return this.description;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public String getDescription2() {
        return this.description2;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public String getDisplay() {
        return this.display;
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public double getEcpmPrice() {
        return this.ecpmPrice;
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public String getExt() {
        return this.ext;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public int getFillSource() {
        return this.FillSource;
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public String getFilterSource() {
        if (!isIconAd()) {
            return TtmlNode.ANONYMOUS_REGION_ID;
        }
        if (!TextUtils.isEmpty(this.packageName)) {
            return this.packageName;
        }
        Image image = this.icon;
        return image == null ? TtmlNode.ANONYMOUS_REGION_ID : image.getUrl();
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public Image getIcon() {
        return this.icon;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public Drawable getIconDrawable() {
        return this.iconDrawable;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public List<TAdNativeInfo.Image> getImageList() {
        return this.imageList;
    }

    public String getMaterialStyle() {
        return this.materialStyle;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public double getMaxPrice() {
        return this.maxPrice;
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public String getMediatorSourceName() {
        return this.mediatorSourceName;
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public String getMediatorSourceUnitId() {
        return this.mediatorSourceUnitId;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public int getMime() {
        return this.mime;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public NativeAdWrapper getNativeAdWrapper() {
        return this.nativeAdWrapper;
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public Network getNetwork() {
        NativeAdWrapper nativeAdWrapper = this.nativeAdWrapper;
        if (nativeAdWrapper == null || nativeAdWrapper.getAdImpl() == null) {
            return null;
        }
        return this.nativeAdWrapper.getAdImpl().getNetwork();
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public String getPackageName() {
        return this.packageName;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public String getPkgs() {
        return this.pkgs;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo, com.hisavana.common.interfacz.ICacheAd
    public String getPlacementId() {
        NativeAdWrapper nativeAdWrapper = this.nativeAdWrapper;
        if (nativeAdWrapper == null || nativeAdWrapper.getAdImpl() == null) {
            return null;
        }
        return this.nativeAdWrapper.getAdImpl().getPlacementId();
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public int getPullNewestLive() {
        return this.pullNewestLive;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public String getRating() {
        return this.rating;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public List<SSPWebRecommendInfo> getRecommendInfoList() {
        return this.sspWebRecommendInfos;
    }

    public String getRequestId() {
        return this.requestId;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public String getSaleprice() {
        return this.saleprice;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public String getSceneId() {
        return this.sceneId;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public String getSceneToken() {
        return this.sceneToken;
    }

    public double getSecondPrice() {
        return this.secondPrice;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public String getShowId() {
        return this.showId;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public String getSocialContext() {
        return this.socialContext;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public String getSourceSize() {
        return this.sourceSize;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public String getSponsoredTranslation() {
        return this.sponsoredTranslation;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public String getTitle() {
        return this.title;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public String getTriggerId() {
        return this.triggerId;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public Long getTriggerTs() {
        Long l = this.triggerTs;
        return Long.valueOf(l == null ? 0L : l.longValue());
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public int getTtl() {
        return this.ttl;
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public long getValidTimeLimit() {
        int i = this.ttl;
        if (i <= 0) {
            return Long.MAX_VALUE;
        }
        return (i * ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS) - Math.abs(System.currentTimeMillis() - this.startCacheTime);
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public boolean isAdxAd() {
        return this.hisavanaSource == 2;
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public boolean isEwAd() {
        return this.hisavanaSource == 1;
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public boolean isExpired() {
        NativeAdWrapper nativeAdWrapper = this.nativeAdWrapper;
        return nativeAdWrapper == null || nativeAdWrapper.isExpired() || getValidTimeLimit() <= 0;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo, com.hisavana.common.interfacz.ICacheAd
    public boolean isIconAd() {
        return this.adType == 6;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public boolean isIconValid() {
        NativeAdWrapper nativeAdWrapper = this.nativeAdWrapper;
        return nativeAdWrapper != null && nativeAdWrapper.isIconValid();
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public boolean isImageValid() {
        NativeAdWrapper nativeAdWrapper = this.nativeAdWrapper;
        return nativeAdWrapper != null && nativeAdWrapper.isImageValid();
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public boolean isInternalAd() {
        return this.isInternalAd;
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public boolean isMatchVulgarBrand() {
        NativeAdWrapper nativeAdWrapper = this.nativeAdWrapper;
        return nativeAdWrapper != null && nativeAdWrapper.isMatchVulgarBrand();
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public boolean isMaterielValid() {
        NativeAdWrapper nativeAdWrapper = this.nativeAdWrapper;
        return nativeAdWrapper != null && nativeAdWrapper.isMaterielValid();
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public boolean isOfflineAd() {
        return this.isOfflineAd;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public boolean isRelease() {
        return this.mIsRelease;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public boolean isUseRecommend() {
        return this.useRecommendStatus;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public void registerView(ViewGroup viewGroup, List<View> list) {
        NativeAdWrapper nativeAdWrapper = this.nativeAdWrapper;
        if (nativeAdWrapper != null) {
            nativeAdWrapper.registerViewForInteraction(viewGroup, list, this);
        }
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public void release() {
        try {
            if (this.mIsRelease) {
                return;
            }
            NativeAdWrapper nativeAdWrapper = this.nativeAdWrapper;
            if (nativeAdWrapper != null) {
                nativeAdWrapper.unregisterView(this);
                this.nativeAdWrapper.destroy();
            }
            if (getIcon() != null) {
                getIcon().release();
            }
            List<TAdNativeInfo.Image> imageList = getImageList();
            if (imageList != null && imageList.size() > 0) {
                for (TAdNativeInfo.Image image : imageList) {
                    if (image != null) {
                        image.release();
                    }
                }
            }
            Drawable drawable = this.iconDrawable;
            if (drawable != null && (drawable instanceof BitmapDrawable)) {
                BitmapUtil.recycle(((BitmapDrawable) drawable).getBitmap());
                this.iconDrawable = null;
            }
            this.mIsRelease = true;
        } catch (Throwable th) {
            AdLogUtil.Log().e(Log.getStackTraceString(th));
        }
    }

    public void setAdCallToAction(String str) {
        this.adCallToAction = str;
    }

    public void setAdCreateId(String str) {
        this.adCreateId = str;
    }

    public void setAdFormat(int i) {
        this.adFormat = i;
    }

    public void setAdId(String str) {
        this.adId = str;
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public void setAdSource(int i) {
        this.adSource = i;
    }

    public void setAdType(int i) {
        this.adType = i;
    }

    public void setAppInfo(String str) {
        this.appInfo = str;
    }

    public void setBrand(String str) {
        this.brand = str;
    }

    public void setDeepLink(String str) {
        this.deepLink = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setDescription2(String str) {
        this.description2 = str;
    }

    public void setDisplay(String str) {
        this.display = str;
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public void setEcpmPrice(double d) {
        this.ecpmPrice = d;
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public void setExt(String str) {
        this.ext = str;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public void setFillSource(int i) {
        this.FillSource = i;
    }

    public void setHisavanaSource(int i) {
        this.hisavanaSource = i;
    }

    public void setIcon(Image image) {
        this.icon = image;
    }

    public void setIconAd(boolean z) {
        this.isIconAd = z;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public void setIconDrawable(Drawable drawable) {
        this.iconDrawable = drawable;
    }

    public void setImageList(List<TAdNativeInfo.Image> list) {
        this.imageList = list;
    }

    public void setInternalAd(boolean z) {
        this.isInternalAd = z;
    }

    public void setMaterialStyle(String str) {
        this.materialStyle = str;
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public void setMaxPrice(double d) {
        this.maxPrice = d;
    }

    public void setMediatorSourceName(String str) {
        this.mediatorSourceName = str;
    }

    public void setMediatorSourceUnitId(String str) {
        this.mediatorSourceUnitId = str;
    }

    public void setMime(int i) {
        this.mime = i;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public void setNativeAdWrapper(NativeAdWrapper nativeAdWrapper) {
        this.nativeAdWrapper = nativeAdWrapper;
    }

    public void setOfflineAd(boolean z) {
        this.isOfflineAd = z;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setPkgs(String str) {
        this.pkgs = str;
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public void setPreload(boolean z) {
    }

    public void setPullNewestLive(int i) {
        this.pullNewestLive = i;
    }

    public void setRating(String str) {
        this.rating = str;
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public void setRequestType(int i) {
    }

    public void setSaleprice(String str) {
        this.saleprice = str;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public void setSceneId(String str) {
        this.sceneId = str;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public void setSceneToken(String str) {
        this.sceneToken = str;
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public void setSecondPrice(double d) {
        AdLogUtil.Log().d("ssp_second_price", "*----> AdNativeInfo setSecondPrice price" + d);
        this.secondPrice = d;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public void setShowId(String str) {
        this.showId = str;
    }

    public void setSocialContext(String str) {
        this.socialContext = str;
    }

    public void setSourceSize(String str) {
        this.sourceSize = str;
    }

    public void setSponsoredTranslation(String str) {
        this.sponsoredTranslation = str;
    }

    public void setSspWebRecommendInfos(List<SSPWebRecommendInfo> list) {
        this.sspWebRecommendInfos = list;
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public void setTimeOut(boolean z) {
    }

    public void setTitle(String str) {
        this.title = str;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public void setTriggerId(String str) {
        this.triggerId = str;
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public void setTriggerTs(Long l) {
        this.triggerTs = l;
    }

    public void setTtl(int i) {
        this.ttl = i;
    }

    public void setUseRecommend(boolean z) {
        this.useRecommendStatus = z;
    }

    public void setcId(String str) {
        this.cId = str;
    }

    public String toString() {
        return "TAdNativeInfo{adId='" + this.adId + "', cId='" + this.cId + "', title='" + this.title + "', description='" + this.description + "', description2='" + this.description2 + "', imageList=" + this.imageList + ", icon=" + this.icon + ", nativeAdWrapper=" + this.nativeAdWrapper + ", adCallToAction='" + this.adCallToAction + "', rating='" + this.rating + "', pkgs='" + this.pkgs + "', adSource=" + this.adSource + ", socialContext='" + this.socialContext + "', sponsoredTranslation='" + this.sponsoredTranslation + "', price='" + this.price + "', saleprice='" + this.saleprice + "', display='" + this.display + "', brand='" + this.brand + "', adType=" + this.adType + ", ttl=" + this.ttl + ", mIsRelease=" + this.mIsRelease + ", adCreateId=" + this.adCreateId + ", isDefaultAd=" + this.isInternalAd + ", mediatorSourceName=" + this.mediatorSourceName + ", mediatorSourceUnitId=" + this.mediatorSourceUnitId + '}';
    }

    @Override // com.hisavana.common.bean.TAdNativeInfo
    public void unregisterView() {
        NativeAdWrapper nativeAdWrapper = this.nativeAdWrapper;
        if (nativeAdWrapper != null) {
            nativeAdWrapper.unregisterView(this);
        }
    }
}
