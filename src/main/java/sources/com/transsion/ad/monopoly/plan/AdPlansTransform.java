package com.transsion.ad.monopoly.plan;

import com.blankj.utilcode.util.o;
import com.google.gson.reflect.TypeToken;
import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.model.CtxAttributeConfig;
import com.transsion.ad.monopoly.model.MbAdImage;
import com.transsion.gslb.BuildConfig;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AdPlansTransform {
    public static final AdPlansTransform a = new AdPlansTransform();

    private AdPlansTransform() {
    }

    public final MbAdDbPlans a(AdPlans adPlans) {
        String str;
        if (adPlans == null || (str = adPlans.getId()) == null) {
            str = BuildConfig.FLAVOR;
        }
        String str2 = str;
        String version = adPlans != null ? adPlans.getVersion() : null;
        String name = adPlans != null ? adPlans.getName() : null;
        String startTime = adPlans != null ? adPlans.getStartTime() : null;
        String endTime = adPlans != null ? adPlans.getEndTime() : null;
        String extraConfig = adPlans != null ? adPlans.getExtraConfig() : null;
        Integer displayTimes = adPlans != null ? adPlans.getDisplayTimes() : null;
        Integer showedTimes = adPlans != null ? adPlans.getShowedTimes() : null;
        String showDate = adPlans != null ? adPlans.getShowDate() : null;
        String advertiserName = adPlans != null ? adPlans.getAdvertiserName() : null;
        String advertiserAvatar = adPlans != null ? adPlans.getAdvertiserAvatar() : null;
        String advertiserAvatarPath = adPlans != null ? adPlans.getAdvertiserAvatarPath() : null;
        String j = o.j(adPlans != null ? adPlans.getBrand() : null);
        String j2 = o.j(adPlans != null ? adPlans.getDenyBrand() : null);
        String j3 = o.j(adPlans != null ? adPlans.getModel() : null);
        String j4 = o.j(adPlans != null ? adPlans.getDenyModel() : null);
        String j5 = o.j(adPlans != null ? adPlans.getCountry() : null);
        String j6 = o.j(adPlans != null ? adPlans.getScenes() : null);
        String adPlanUpdateTime = adPlans != null ? adPlans.getAdPlanUpdateTime() : null;
        String adSource = adPlans != null ? adPlans.getAdSource() : null;
        String extAdSlot = adPlans != null ? adPlans.getExtAdSlot() : null;
        Integer sort = adPlans != null ? adPlans.getSort() : null;
        return new MbAdDbPlans(str2, version, name, startTime, endTime, extraConfig, displayTimes, showedTimes, showDate, advertiserName, advertiserAvatar, advertiserAvatarPath, j, j2, j3, j4, j5, j6, adSource, extAdSlot, o.j(adPlans != null ? adPlans.getAdMaterialList() : null), adPlanUpdateTime, sort, adPlans != null ? adPlans.getAdShowLevel() : null, adPlans != null ? adPlans.getFilterClientVersion() : null, adPlans != null ? adPlans.getAdPlanCreateTime() : null, adPlans != null ? adPlans.getAppStarDesc() : null, adPlans != null ? adPlans.getAppSizeDesc() : null, adPlans != null ? adPlans.getCtxEnableExpr() : null, adPlans != null ? adPlans.getCtxDisableExpr() : null, o.j(adPlans != null ? adPlans.getCtxAttributeConfig() : null), adPlans != null ? adPlans.getDispatchTimeStart() : null, adPlans != null ? adPlans.getDispatchTimeEnd() : null, o.j(adPlans != null ? adPlans.getExtImage() : null), adPlans != null ? adPlans.getBidEcpmCent() : null, adPlans != null ? adPlans.getEcpmCent() : null, adPlans != null ? adPlans.isValid() : false, adPlans != null ? adPlans.getH5LinkPreload() : false, adPlans != null ? adPlans.getH5LinkOpenByCct() : false, adPlans != null ? adPlans.getCountryCode() : null);
    }

    public final AdPlans b(MbAdDbPlans mbAdDbPlans) {
        Object obj;
        if (mbAdDbPlans == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            String id = mbAdDbPlans.getId();
            String version = mbAdDbPlans.getVersion();
            String name = mbAdDbPlans.getName();
            String advertiserName = mbAdDbPlans.getAdvertiserName();
            String advertiserAvatar = mbAdDbPlans.getAdvertiserAvatar();
            String advertiserAvatarPath = mbAdDbPlans.getAdvertiserAvatarPath();
            Integer displayTimes = mbAdDbPlans.getDisplayTimes();
            Integer showedTimes = mbAdDbPlans.getShowedTimes();
            String showDate = mbAdDbPlans.getShowDate();
            String[] strArr = (String[]) o.d(mbAdDbPlans.getScenes(), String[].class);
            List G0 = strArr != null ? ArraysKt.G0(strArr) : null;
            String[] strArr2 = (String[]) o.d(mbAdDbPlans.getCountry(), String[].class);
            List G02 = strArr2 != null ? ArraysKt.G0(strArr2) : null;
            String[] strArr3 = (String[]) o.d(mbAdDbPlans.getBrand(), String[].class);
            List G03 = strArr3 != null ? ArraysKt.G0(strArr3) : null;
            String[] strArr4 = (String[]) o.d(mbAdDbPlans.getDenyBrand(), String[].class);
            List G04 = strArr4 != null ? ArraysKt.G0(strArr4) : null;
            String[] strArr5 = (String[]) o.d(mbAdDbPlans.getModel(), String[].class);
            List G05 = strArr5 != null ? ArraysKt.G0(strArr5) : null;
            String[] strArr6 = (String[]) o.d(mbAdDbPlans.getDenyModel(), String[].class);
            List G06 = strArr6 != null ? ArraysKt.G0(strArr6) : null;
            String startTime = mbAdDbPlans.getStartTime();
            String endTime = mbAdDbPlans.getEndTime();
            String extraConfig = mbAdDbPlans.getExtraConfig();
            String adPlanUpdateTime = mbAdDbPlans.getAdPlanUpdateTime();
            String adSource = mbAdDbPlans.getAdSource();
            String extAdSlot = mbAdDbPlans.getExtAdSlot();
            Integer sort = mbAdDbPlans.getSort();
            String adShowLevel = mbAdDbPlans.getAdShowLevel();
            obj = Result.constructor-impl(new AdPlans(id, name, sort, advertiserName, advertiserAvatar, advertiserAvatarPath, showedTimes, showDate, G0, displayTimes, G02, G03, G04, G05, G06, mbAdDbPlans.getFilterClientVersion(), startTime, endTime, extraConfig, (List) o.e(mbAdDbPlans.getAdMaterialList(), new TypeToken<List<? extends AdMaterialList>>() { // from class: com.transsion.ad.monopoly.plan.AdPlansTransform$transformPlanDb2Bean$1$adPlans$1
            }.getType()), mbAdDbPlans.getAdPlanCreateTime(), adPlanUpdateTime, adShowLevel, mbAdDbPlans.getAppStarDesc(), mbAdDbPlans.getAppSizeDesc(), mbAdDbPlans.getCtxEnableExpr(), mbAdDbPlans.getCtxDisableExpr(), (CtxAttributeConfig) o.d(mbAdDbPlans.getCtxAttributeConfig(), CtxAttributeConfig.class), mbAdDbPlans.getDispatchTimeStart(), mbAdDbPlans.getDispatchTimeEnd(), adSource, extAdSlot, (MbAdImage) o.d(mbAdDbPlans.getExtImage(), MbAdImage.class), version, mbAdDbPlans.getBidEcpmCent(), mbAdDbPlans.getEcpmCent(), mbAdDbPlans.isValid(), mbAdDbPlans.getH5LinkPreload(), mbAdDbPlans.getH5LinkOpenByCct(), mbAdDbPlans.getCountryCode()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        return (AdPlans) (Result.exceptionOrNull-impl(obj) == null ? obj : null);
    }
}
