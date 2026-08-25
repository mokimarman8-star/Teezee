package com.transsion.ad.monopoly.manager;

import android.text.TextUtils;
import ci.h;
import ci.p;
import com.cloud.hisavana.sdk.common.util.a0;
import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.model.MbAdImage;
import com.transsion.ad.monopoly.model.MbAdPlansBean;
import com.transsion.ad.monopoly.model.MbAdPlansDto;
import com.transsion.ad.monopoly.model.MbAdVideo;
import com.transsion.ad.monopoly.plan.AdPlanSourceManager;
import com.transsion.ad.monopoly.plan.AdPlansTransform;
import com.transsion.ad.ps.distribute.PSAdPlanRequestManager;
import com.transsion.ad.scene.d;
import com.transsion.ad.strategy.e;
import com.transsion.ad.strategy.g;
import com.transsion.ad.strategy.u;
import com.transsion.gslb.BuildConfig;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import yh.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AdPlansRequestManager {
    public static final AdPlansRequestManager a = new AdPlansRequestManager();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.ad.monopoly.manager.a
        public final Object invoke() {
            yh.a s;
            s = AdPlansRequestManager.s();
            return s;
        }
    });
    private static AtomicBoolean c = new AtomicBoolean(false);

    private AdPlansRequestManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b2, code lost:
    
        r4.element = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x006d -> B:10:0x0070). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h(List list, Continuation continuation) {
        AdPlansRequestManager$checkDownloadMaterial$1 adPlansRequestManager$checkDownloadMaterial$1;
        int i;
        Iterator it;
        Ref.BooleanRef booleanRef;
        List<AdMaterialList> adMaterialList;
        if (continuation instanceof AdPlansRequestManager$checkDownloadMaterial$1) {
            adPlansRequestManager$checkDownloadMaterial$1 = (AdPlansRequestManager$checkDownloadMaterial$1) continuation;
            int i2 = adPlansRequestManager$checkDownloadMaterial$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                adPlansRequestManager$checkDownloadMaterial$1.label = i2 - Integer.MIN_VALUE;
                Object obj = adPlansRequestManager$checkDownloadMaterial$1.result;
                Object f = IntrinsicsKt.f();
                i = adPlansRequestManager$checkDownloadMaterial$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                    booleanRef2.element = true;
                    it = list.iterator();
                    booleanRef = booleanRef2;
                    if (it.hasNext()) {
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AdPlans adPlans = (AdPlans) adPlansRequestManager$checkDownloadMaterial$1.L$2;
                    it = (Iterator) adPlansRequestManager$checkDownloadMaterial$1.L$1;
                    booleanRef = (Ref.BooleanRef) adPlansRequestManager$checkDownloadMaterial$1.L$0;
                    ResultKt.b(obj);
                    MbAdDbPlans mbAdDbPlans = (MbAdDbPlans) obj;
                    if (mbAdDbPlans == null) {
                        booleanRef.element = false;
                    } else {
                        AdPlans b2 = AdPlansTransform.a.b(mbAdDbPlans);
                        if (b2 == null || (adMaterialList = b2.getAdMaterialList()) == null || !(!adMaterialList.isEmpty())) {
                            booleanRef.element = false;
                        } else {
                            List<AdMaterialList> adMaterialList2 = b2.getAdMaterialList();
                            if (adMaterialList2 != null) {
                                int i3 = 0;
                                for (Object obj2 : adMaterialList2) {
                                    int i4 = i3 + 1;
                                    if (i3 < 0) {
                                        CollectionsKt.u();
                                    }
                                    if (!((AdMaterialList) obj2).getDownloadMaterialSuccess()) {
                                        break;
                                    }
                                    i3 = i4;
                                }
                            }
                            if (AdPlanSourceManager.a.b(adPlans) && b2.getExtImage() != null) {
                                MbAdImage extImage = b2.getExtImage();
                                if (!TextUtils.isEmpty(extImage != null ? extImage.getUrl() : null)) {
                                    MbAdImage extImage2 = b2.getExtImage();
                                    if (TextUtils.isEmpty(extImage2 != null ? extImage2.getPath() : null)) {
                                        booleanRef.element = false;
                                    }
                                }
                            }
                        }
                    }
                    if (it.hasNext()) {
                        adPlans = (AdPlans) it.next();
                        AdPlansStorageManager adPlansStorageManager = AdPlansStorageManager.a;
                        String id = adPlans.getId();
                        adPlansRequestManager$checkDownloadMaterial$1.L$0 = booleanRef;
                        adPlansRequestManager$checkDownloadMaterial$1.L$1 = it;
                        adPlansRequestManager$checkDownloadMaterial$1.L$2 = adPlans;
                        adPlansRequestManager$checkDownloadMaterial$1.label = 1;
                        obj = adPlansStorageManager.h(id, adPlansRequestManager$checkDownloadMaterial$1);
                        if (obj == f) {
                            return f;
                        }
                        MbAdDbPlans mbAdDbPlans2 = (MbAdDbPlans) obj;
                        if (mbAdDbPlans2 == null) {
                        }
                        if (it.hasNext()) {
                            return Boxing.a(booleanRef.element);
                        }
                    }
                }
            }
        }
        adPlansRequestManager$checkDownloadMaterial$1 = new AdPlansRequestManager$checkDownloadMaterial$1(this, continuation);
        Object obj3 = adPlansRequestManager$checkDownloadMaterial$1.result;
        Object f2 = IntrinsicsKt.f();
        i = adPlansRequestManager$checkDownloadMaterial$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object i(MbAdPlansDto mbAdPlansDto, String str, Continuation continuation) {
        AdPlansRequestManager$checkResult$1 adPlansRequestManager$checkResult$1;
        Object obj;
        int i;
        MbAdPlansBean data;
        MbAdPlansDto mbAdPlansDto2;
        String str2;
        Object g;
        xh.a aVar;
        String str3;
        if (continuation instanceof AdPlansRequestManager$checkResult$1) {
            adPlansRequestManager$checkResult$1 = (AdPlansRequestManager$checkResult$1) continuation;
            int i2 = adPlansRequestManager$checkResult$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                adPlansRequestManager$checkResult$1.label = i2 - Integer.MIN_VALUE;
                obj = adPlansRequestManager$checkResult$1.result;
                Object f = IntrinsicsKt.f();
                i = adPlansRequestManager$checkResult$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    if (((mbAdPlansDto == null || (data = mbAdPlansDto.getData()) == null) ? null : data.getAdPlans()) != null) {
                        List<AdPlans> adPlans = mbAdPlansDto.getData().getAdPlans();
                        adPlansRequestManager$checkResult$1.L$0 = mbAdPlansDto;
                        adPlansRequestManager$checkResult$1.L$1 = str;
                        adPlansRequestManager$checkResult$1.label = 1;
                        obj = h(adPlans, adPlansRequestManager$checkResult$1);
                        if (obj == f) {
                            return f;
                        }
                    }
                    return Unit.a;
                }
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        str2 = (String) adPlansRequestManager$checkResult$1.L$3;
                        str = (String) adPlansRequestManager$checkResult$1.L$2;
                        str3 = (String) adPlansRequestManager$checkResult$1.L$1;
                        xh.a aVar2 = (xh.a) adPlansRequestManager$checkResult$1.L$0;
                        ResultKt.b(obj);
                        aVar = aVar2;
                        List list = (List) obj;
                        xh.a.c(aVar, str3 + " --> checkResult() --> 更新完计划且下载完素材,新计划可用 --> lastVersion = " + str + " --> newVersion = " + str2 + " --> size = " + (list != null ? Boxing.d(list.size()) : null), 0, false, 6, null);
                        return Unit.a;
                    }
                    str2 = (String) adPlansRequestManager$checkResult$1.L$2;
                    str = (String) adPlansRequestManager$checkResult$1.L$1;
                    mbAdPlansDto2 = (MbAdPlansDto) adPlansRequestManager$checkResult$1.L$0;
                    ResultKt.b(obj);
                    k(mbAdPlansDto2.getData().getAdPlans());
                    xh.a aVar3 = xh.a.a;
                    String p = p();
                    AdPlansStorageManager adPlansStorageManager = AdPlansStorageManager.a;
                    adPlansRequestManager$checkResult$1.L$0 = aVar3;
                    adPlansRequestManager$checkResult$1.L$1 = p;
                    adPlansRequestManager$checkResult$1.L$2 = str;
                    adPlansRequestManager$checkResult$1.L$3 = str2;
                    adPlansRequestManager$checkResult$1.label = 3;
                    g = adPlansStorageManager.g(adPlansRequestManager$checkResult$1);
                    if (g != f) {
                        return f;
                    }
                    aVar = aVar3;
                    obj = g;
                    str3 = p;
                    List list2 = (List) obj;
                    if (list2 != null) {
                    }
                    xh.a.c(aVar, str3 + " --> checkResult() --> 更新完计划且下载完素材,新计划可用 --> lastVersion = " + str + " --> newVersion = " + str2 + " --> size = " + (list2 != null ? Boxing.d(list2.size()) : null), 0, false, 6, null);
                    return Unit.a;
                }
                str = (String) adPlansRequestManager$checkResult$1.L$1;
                mbAdPlansDto = (MbAdPlansDto) adPlansRequestManager$checkResult$1.L$0;
                ResultKt.b(obj);
                if (((Boolean) obj).booleanValue()) {
                    String valueOf = String.valueOf(mbAdPlansDto.getData().getVersion());
                    ai.c.a.i(str, valueOf);
                    e.a.c().putString("non_ad_plan_version", valueOf);
                    adPlansRequestManager$checkResult$1.L$0 = mbAdPlansDto;
                    adPlansRequestManager$checkResult$1.L$1 = str;
                    adPlansRequestManager$checkResult$1.L$2 = valueOf;
                    adPlansRequestManager$checkResult$1.label = 2;
                    if (j(valueOf, str, adPlansRequestManager$checkResult$1) == f) {
                        return f;
                    }
                    mbAdPlansDto2 = mbAdPlansDto;
                    str2 = valueOf;
                    k(mbAdPlansDto2.getData().getAdPlans());
                    xh.a aVar32 = xh.a.a;
                    String p2 = p();
                    AdPlansStorageManager adPlansStorageManager2 = AdPlansStorageManager.a;
                    adPlansRequestManager$checkResult$1.L$0 = aVar32;
                    adPlansRequestManager$checkResult$1.L$1 = p2;
                    adPlansRequestManager$checkResult$1.L$2 = str;
                    adPlansRequestManager$checkResult$1.L$3 = str2;
                    adPlansRequestManager$checkResult$1.label = 3;
                    g = adPlansStorageManager2.g(adPlansRequestManager$checkResult$1);
                    if (g != f) {
                    }
                }
                return Unit.a;
            }
        }
        adPlansRequestManager$checkResult$1 = new AdPlansRequestManager$checkResult$1(this, continuation);
        obj = adPlansRequestManager$checkResult$1.result;
        Object f2 = IntrinsicsKt.f();
        i = adPlansRequestManager$checkResult$1.label;
        if (i != 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object j(String str, String str2, Continuation continuation) {
        AdPlansRequestManager$deleteExpireAdPlan$1 adPlansRequestManager$deleteExpireAdPlan$1;
        int i;
        if (continuation instanceof AdPlansRequestManager$deleteExpireAdPlan$1) {
            adPlansRequestManager$deleteExpireAdPlan$1 = (AdPlansRequestManager$deleteExpireAdPlan$1) continuation;
            int i2 = adPlansRequestManager$deleteExpireAdPlan$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                adPlansRequestManager$deleteExpireAdPlan$1.label = i2 - Integer.MIN_VALUE;
                Object obj = adPlansRequestManager$deleteExpireAdPlan$1.result;
                Object f = IntrinsicsKt.f();
                i = adPlansRequestManager$deleteExpireAdPlan$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    if (TextUtils.isEmpty(str)) {
                        return Unit.a;
                    }
                    AdPlansStorageManager adPlansStorageManager = AdPlansStorageManager.a;
                    adPlansRequestManager$deleteExpireAdPlan$1.L$0 = str;
                    adPlansRequestManager$deleteExpireAdPlan$1.L$1 = str2;
                    adPlansRequestManager$deleteExpireAdPlan$1.label = 1;
                    if (adPlansStorageManager.c(str, adPlansRequestManager$deleteExpireAdPlan$1) == f) {
                        return f;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str2 = (String) adPlansRequestManager$deleteExpireAdPlan$1.L$1;
                    str = (String) adPlansRequestManager$deleteExpireAdPlan$1.L$0;
                    ResultKt.b(obj);
                }
                xh.a.c(xh.a.a, p() + " --> deleteExpireAdPlan() --> newVersion = " + str + " -- lastVersion = " + str2 + " --> 删除过期计划 -- success", 0, false, 6, null);
                return Unit.a;
            }
        }
        adPlansRequestManager$deleteExpireAdPlan$1 = new AdPlansRequestManager$deleteExpireAdPlan$1(this, continuation);
        Object obj2 = adPlansRequestManager$deleteExpireAdPlan$1.result;
        Object f2 = IntrinsicsKt.f();
        i = adPlansRequestManager$deleteExpireAdPlan$1.label;
        if (i != 0) {
        }
        xh.a.c(xh.a.a, p() + " --> deleteExpireAdPlan() --> newVersion = " + str + " -- lastVersion = " + str2 + " --> 删除过期计划 -- success", 0, false, 6, null);
        return Unit.a;
    }

    private final void k(List list) {
        HashSet hashSet = new HashSet();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AdPlans adPlans = (AdPlans) it.next();
            List<AdMaterialList> adMaterialList = adPlans.getAdMaterialList();
            if (adMaterialList != null) {
                for (AdMaterialList adMaterialList2 : adMaterialList) {
                    if (Intrinsics.c(AdMaterialList.NON_AD_TYPE_TEXT, adMaterialList2.getType())) {
                        MbAdImage image = adMaterialList2.getImage();
                        hashSet.add(image != null ? image.getPath() : null);
                    } else {
                        MbAdVideo video = adMaterialList2.getVideo();
                        hashSet.add(video != null ? video.getPath() : null);
                    }
                }
            }
            if (!TextUtils.isEmpty(adPlans.getAdvertiserAvatarPath())) {
                hashSet.add(adPlans.getAdvertiserAvatarPath());
            }
        }
        h.a.b(new File(com.transsion.ad.a.a.b() + File.separatorChar), hashSet);
        xh.a.c(xh.a.a, p() + " --> deleteExpireMaterial() --> 删除过期资源 -- success", 0, false, 6, null);
    }

    private final boolean l(AdPlans adPlans) {
        List<AdMaterialList> adMaterialList;
        Integer size;
        String str = null;
        String m = m(adPlans != null ? adPlans.getAdvertiserAvatar() : null);
        if (adPlans != null) {
            adPlans.setAdvertiserAvatarPath(m);
        }
        n(adPlans != null ? adPlans.getExtImage() : null);
        if (adPlans != null && (adMaterialList = adPlans.getAdMaterialList()) != null) {
            Iterator<T> it = adMaterialList.iterator();
            if (it.hasNext()) {
                AdMaterialList adMaterialList2 = (AdMaterialList) it.next();
                if (Intrinsics.c(adMaterialList2.getType(), AdMaterialList.NON_AD_TYPE_TEXT)) {
                    MbAdImage image = adMaterialList2.getImage();
                    if (image != null) {
                        str = image.getUrl();
                    }
                } else {
                    MbAdVideo video = adMaterialList2.getVideo();
                    if (video != null) {
                        str = video.getUrl();
                    }
                }
                String c2 = a0.c(str);
                String str2 = com.transsion.ad.a.a.b() + File.separatorChar + c2 + ".mineType";
                File file = new File(str2);
                if (Intrinsics.c(adMaterialList2.getType(), AdMaterialList.NON_AD_TYPE_VIDEO)) {
                    MbAdVideo video2 = adMaterialList2.getVideo();
                    int intValue = (video2 == null || (size = video2.getSize()) == null) ? 1 : size.intValue();
                    if (file.isFile() && file.exists() && file.length() > 0) {
                        MbAdVideo video3 = adMaterialList2.getVideo();
                        if (video3 != null) {
                            video3.setPath(str2);
                        }
                        adMaterialList2.setDownloadMaterialSuccess(true);
                        return true;
                    }
                    boolean a2 = g.a.a(str, str2);
                    long length = file.length();
                    if (a2 && length >= intValue) {
                        MbAdVideo video4 = adMaterialList2.getVideo();
                        if (video4 != null) {
                            video4.setPath(str2);
                        }
                        adMaterialList2.setDownloadMaterialSuccess(true);
                        return true;
                    }
                    xh.a.c(xh.a.a, a.p() + " --> downloadAdPlan() --> 视频素材下载失败 -- adPlans.id = " + adPlans.getId() + " downloadFileSuccess = " + a2 + " -- localFileSize = " + length + " -- remoteFileSize = " + intValue + " destination = " + str2, 6, false, 4, null);
                    return false;
                }
                if (file.isFile() && file.exists() && file.length() > 0) {
                    MbAdImage image2 = adMaterialList2.getImage();
                    if (image2 != null) {
                        image2.setPath(str2);
                    }
                    adMaterialList2.setDownloadMaterialSuccess(true);
                    return true;
                }
                boolean a3 = g.a.a(str, str2);
                long length2 = file.length();
                if (a3 && length2 > 0) {
                    MbAdImage image3 = adMaterialList2.getImage();
                    if (image3 != null) {
                        image3.setPath(str2);
                    }
                    adMaterialList2.setDownloadMaterialSuccess(true);
                    return true;
                }
                xh.a.c(xh.a.a, a.p() + " --> downloadAdPlan() --> 图片素材下载失败 -- adPlans.id = " + adPlans.getId() + " downloadFileSuccess = " + a3 + " -- localFileSize = " + length2 + " -- destination = " + str2, 6, false, 4, null);
            }
        }
        return false;
    }

    private final String m(String str) {
        String c2 = a0.c(str);
        String str2 = com.transsion.ad.a.a.b() + File.separatorChar + c2 + ".mineType";
        return (h.a.c(str2) || g.a.a(str, str2)) ? str2 : BuildConfig.FLAVOR;
    }

    private final void n(MbAdImage mbAdImage) {
        if (mbAdImage == null || TextUtils.isEmpty(mbAdImage.getUrl())) {
            return;
        }
        String url = mbAdImage.getUrl();
        String c2 = a0.c(url);
        String str = com.transsion.ad.a.a.b() + File.separatorChar + c2 + ".mineType";
        if (h.a.c(str)) {
            mbAdImage.setPath(str);
        } else if (g.a.a(url, str)) {
            mbAdImage.setPath(str);
        }
    }

    private final Object o(AdPlans adPlans, Continuation continuation) {
        Object w;
        AdPlanSourceManager adPlanSourceManager = AdPlanSourceManager.a;
        if (!adPlanSourceManager.i(adPlans) && !adPlanSourceManager.d(adPlans) && !adPlanSourceManager.f(adPlans)) {
            return (l(adPlans) && (w = w(adPlans, continuation)) == IntrinsicsKt.f()) ? w : Unit.a;
        }
        xh.a.c(xh.a.a, p() + " --> downloadMaterialAndSaveAdPlans() --> PS虚拟计划和、Hi虚拟计划 --> 不需要下载素材的 --> " + adPlans.getAdSource() + " --> adPlan.name = " + adPlans.getName() + " --> adPlan.id = " + adPlans.getId(), 0, false, 6, null);
        AdMaterialList adMaterialList = new AdMaterialList(null, null, null, null, null, null, null, null, null, false, null, null, null, 8191, null);
        adMaterialList.setDownloadMaterialSuccess(true);
        adPlans.setAdMaterialList(CollectionsKt.e(adMaterialList));
        Object w2 = w(adPlans, continuation);
        return w2 == IntrinsicsKt.f() ? w2 : Unit.a;
    }

    private final String p() {
        String simpleName = AdPlansRequestManager.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final yh.a q() {
        return (yh.a) b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x01c1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x01af A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object r(MbAdPlansDto mbAdPlansDto, String str, Continuation continuation) {
        AdPlansRequestManager$handleResponse$1 adPlansRequestManager$handleResponse$1;
        Object f;
        int i;
        List<AdPlans> adPlans;
        MbAdPlansDto mbAdPlansDto2;
        String str2;
        MbAdPlansDto mbAdPlansDto3 = mbAdPlansDto;
        String str3 = str;
        if (continuation instanceof AdPlansRequestManager$handleResponse$1) {
            adPlansRequestManager$handleResponse$1 = (AdPlansRequestManager$handleResponse$1) continuation;
            int i2 = adPlansRequestManager$handleResponse$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                adPlansRequestManager$handleResponse$1.label = i2 - Integer.MIN_VALUE;
                Object obj = adPlansRequestManager$handleResponse$1.result;
                f = IntrinsicsKt.f();
                i = adPlansRequestManager$handleResponse$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    if (mbAdPlansDto3 == null) {
                        xh.a.c(xh.a.a, p() + " --> handleResponse() --> mbAdConfig == null --> lastVersion = " + str3, 6, false, 4, null);
                        return Boxing.a(false);
                    }
                    MbAdPlansBean data = mbAdPlansDto.getData();
                    String valueOf = String.valueOf(data != null ? data.getVersion() : null);
                    MbAdPlansBean data2 = mbAdPlansDto.getData();
                    Integer d = (data2 == null || (adPlans = data2.getAdPlans()) == null) ? null : Boxing.d(adPlans.size());
                    if (!Intrinsics.c(mbAdPlansDto.getCode(), "0")) {
                        xh.a.c(xh.a.a, p() + " --> handleResponse() --> mbAdConfig.code != 0 --> lastVersion = " + str3 + " --> newVersion = " + valueOf, 6, false, 4, null);
                        return Boxing.a(false);
                    }
                    u.a.d(mbAdPlansDto.getData());
                    com.transsion.ad.strategy.c.a.e(mbAdPlansDto.getData());
                    d.a.g(mbAdPlansDto3);
                    if (TextUtils.equals(str3, valueOf)) {
                        xh.a.c(xh.a.a, p() + " --> handleResponse() --> 版本号一致，服务端不会下发list 省流量 --> lastVersion = " + str3 + " --> newVersion = " + valueOf, 0, false, 6, null);
                        return Boxing.a(true);
                    }
                    ai.c.a.h(str3, valueOf);
                    xh.a aVar = xh.a.a;
                    xh.a.c(aVar, p() + " --> handleResponse() --> lastVersion = " + str3 + " --> newVersion = " + valueOf + " --> size = " + d + " --> 开始增量更新", 0, false, 6, null);
                    String p = p();
                    StringBuilder sb = new StringBuilder();
                    sb.append(p);
                    sb.append(" --> handleResponse() --> 保证计划关闭的及时性，将不是最新版本的计划标记为不可用 --> isValid = false");
                    xh.a.c(aVar, sb.toString(), 0, false, 6, null);
                    AdPlansStorageManager adPlansStorageManager = AdPlansStorageManager.a;
                    adPlansRequestManager$handleResponse$1.L$0 = mbAdPlansDto3;
                    adPlansRequestManager$handleResponse$1.L$1 = str3;
                    adPlansRequestManager$handleResponse$1.label = 1;
                    if (adPlansStorageManager.l(false, valueOf, adPlansRequestManager$handleResponse$1) == f) {
                        return f;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.b(obj);
                            return Boxing.a(true);
                        }
                        str2 = (String) adPlansRequestManager$handleResponse$1.L$1;
                        mbAdPlansDto2 = (MbAdPlansDto) adPlansRequestManager$handleResponse$1.L$0;
                        ResultKt.b(obj);
                        adPlansRequestManager$handleResponse$1.L$0 = null;
                        adPlansRequestManager$handleResponse$1.L$1 = null;
                        adPlansRequestManager$handleResponse$1.label = 3;
                        if (i(mbAdPlansDto2, str2, adPlansRequestManager$handleResponse$1) == f) {
                            return f;
                        }
                        return Boxing.a(true);
                    }
                    String str4 = (String) adPlansRequestManager$handleResponse$1.L$1;
                    MbAdPlansDto mbAdPlansDto4 = (MbAdPlansDto) adPlansRequestManager$handleResponse$1.L$0;
                    ResultKt.b(obj);
                    str3 = str4;
                    mbAdPlansDto3 = mbAdPlansDto4;
                }
                adPlansRequestManager$handleResponse$1.L$0 = mbAdPlansDto3;
                adPlansRequestManager$handleResponse$1.L$1 = str3;
                adPlansRequestManager$handleResponse$1.label = 2;
                if (v(mbAdPlansDto3, adPlansRequestManager$handleResponse$1) != f) {
                    return f;
                }
                String str5 = str3;
                mbAdPlansDto2 = mbAdPlansDto3;
                str2 = str5;
                adPlansRequestManager$handleResponse$1.L$0 = null;
                adPlansRequestManager$handleResponse$1.L$1 = null;
                adPlansRequestManager$handleResponse$1.label = 3;
                if (i(mbAdPlansDto2, str2, adPlansRequestManager$handleResponse$1) == f) {
                }
                return Boxing.a(true);
            }
        }
        adPlansRequestManager$handleResponse$1 = new AdPlansRequestManager$handleResponse$1(this, continuation);
        Object obj2 = adPlansRequestManager$handleResponse$1.result;
        f = IntrinsicsKt.f();
        i = adPlansRequestManager$handleResponse$1.label;
        if (i != 0) {
        }
        adPlansRequestManager$handleResponse$1.L$0 = mbAdPlansDto3;
        adPlansRequestManager$handleResponse$1.L$1 = str3;
        adPlansRequestManager$handleResponse$1.label = 2;
        if (v(mbAdPlansDto3, adPlansRequestManager$handleResponse$1) != f) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final yh.a s() {
        return (yh.a) kg.c.e.a().h(yh.a.class);
    }

    public static /* synthetic */ Object u(AdPlansRequestManager adPlansRequestManager, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        return adPlansRequestManager.t(str, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x0250 -> B:13:0x0253). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object v(MbAdPlansDto mbAdPlansDto, Continuation continuation) {
        AdPlansRequestManager$saveAndDownload$1 adPlansRequestManager$saveAndDownload$1;
        int i;
        MbAdPlansBean data;
        List<AdPlans> adPlans;
        Iterator it;
        AdPlansRequestManager$saveAndDownload$1 adPlansRequestManager$saveAndDownload$12;
        String str;
        MbAdPlansDto mbAdPlansDto2;
        MbAdPlansBean data2;
        MbAdPlansDto mbAdPlansDto3;
        String str2;
        AdPlans adPlans2;
        MbAdDbPlans mbAdDbPlans;
        Iterator it2;
        String str3;
        MbAdPlansDto mbAdPlansDto4;
        List<AdMaterialList> adMaterialList;
        if (continuation instanceof AdPlansRequestManager$saveAndDownload$1) {
            adPlansRequestManager$saveAndDownload$1 = (AdPlansRequestManager$saveAndDownload$1) continuation;
            int i2 = adPlansRequestManager$saveAndDownload$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                adPlansRequestManager$saveAndDownload$1.label = i2 - Integer.MIN_VALUE;
                Object obj = adPlansRequestManager$saveAndDownload$1.result;
                Object f = IntrinsicsKt.f();
                i = adPlansRequestManager$saveAndDownload$1.label;
                boolean z = true;
                z = true;
                if (i != 0) {
                    ResultKt.b(obj);
                    String valueOf = String.valueOf((mbAdPlansDto == null || (data2 = mbAdPlansDto.getData()) == null) ? null : data2.getVersion());
                    if (mbAdPlansDto != null && (data = mbAdPlansDto.getData()) != null && (adPlans = data.getAdPlans()) != null) {
                        it = adPlans.iterator();
                        adPlansRequestManager$saveAndDownload$12 = adPlansRequestManager$saveAndDownload$1;
                        str = valueOf;
                        mbAdPlansDto2 = mbAdPlansDto;
                        if (it.hasNext()) {
                        }
                    }
                    return Unit.a;
                }
                if (i != 1) {
                    if (i != 2 && i != 3) {
                        if (i != 4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        it2 = (Iterator) adPlansRequestManager$saveAndDownload$1.L$2;
                        str3 = (String) adPlansRequestManager$saveAndDownload$1.L$1;
                        mbAdPlansDto4 = (MbAdPlansDto) adPlansRequestManager$saveAndDownload$1.L$0;
                        ResultKt.b(obj);
                        mbAdPlansDto2 = mbAdPlansDto4;
                        Iterator it3 = it2;
                        adPlansRequestManager$saveAndDownload$12 = adPlansRequestManager$saveAndDownload$1;
                        str = str3;
                        it = it3;
                        z = true;
                        if (it.hasNext()) {
                        }
                        return Unit.a;
                    }
                    it2 = (Iterator) adPlansRequestManager$saveAndDownload$1.L$2;
                    str3 = (String) adPlansRequestManager$saveAndDownload$1.L$1;
                    MbAdPlansDto mbAdPlansDto5 = (MbAdPlansDto) adPlansRequestManager$saveAndDownload$1.L$0;
                    ResultKt.b(obj);
                    mbAdPlansDto2 = mbAdPlansDto5;
                    Iterator it32 = it2;
                    adPlansRequestManager$saveAndDownload$12 = adPlansRequestManager$saveAndDownload$1;
                    str = str3;
                    it = it32;
                    z = true;
                    if (it.hasNext()) {
                        AdPlans adPlans3 = (AdPlans) it.next();
                        AdPlansStorageManager adPlansStorageManager = AdPlansStorageManager.a;
                        String id = adPlans3.getId();
                        adPlansRequestManager$saveAndDownload$12.L$0 = mbAdPlansDto2;
                        adPlansRequestManager$saveAndDownload$12.L$1 = str;
                        adPlansRequestManager$saveAndDownload$12.L$2 = it;
                        adPlansRequestManager$saveAndDownload$12.L$3 = adPlans3;
                        adPlansRequestManager$saveAndDownload$12.label = z ? 1 : 0;
                        Object h = adPlansStorageManager.h(id, adPlansRequestManager$saveAndDownload$12);
                        if (h == f) {
                            return f;
                        }
                        mbAdPlansDto3 = mbAdPlansDto2;
                        obj = h;
                        str2 = str;
                        adPlansRequestManager$saveAndDownload$1 = adPlansRequestManager$saveAndDownload$12;
                        adPlans2 = adPlans3;
                        mbAdDbPlans = (MbAdDbPlans) obj;
                        adPlans2.setVersion(str2);
                        adPlans2.setValid(z);
                        adPlans2.setCtxAttributeConfig(mbAdPlansDto3.getData().getCtxAttributeConfig());
                        adPlans2.setCountryCode(mbAdPlansDto3.getData().getCountryCode());
                        if (mbAdDbPlans == null) {
                            xh.a aVar = xh.a.a;
                            AdPlansRequestManager adPlansRequestManager = a;
                            xh.a.c(aVar, adPlansRequestManager.p() + " --> saveAndDownload() --> 广告计划不存在数据库 --> 下载素材、保存数据库 --> adPlan.name = " + adPlans2.getName() + " --> adPlan.id = " + adPlans2.getId(), 0, false, 6, null);
                            adPlansRequestManager$saveAndDownload$1.L$0 = mbAdPlansDto3;
                            adPlansRequestManager$saveAndDownload$1.L$1 = str2;
                            adPlansRequestManager$saveAndDownload$1.L$2 = it;
                            adPlansRequestManager$saveAndDownload$1.L$3 = null;
                            adPlansRequestManager$saveAndDownload$1.label = 4;
                            if (adPlansRequestManager.o(adPlans2, adPlansRequestManager$saveAndDownload$1) == f) {
                                return f;
                            }
                            it2 = it;
                            str3 = str2;
                            mbAdPlansDto4 = mbAdPlansDto3;
                            mbAdPlansDto2 = mbAdPlansDto4;
                            Iterator it322 = it2;
                            adPlansRequestManager$saveAndDownload$12 = adPlansRequestManager$saveAndDownload$1;
                            str = str3;
                            it = it322;
                            z = true;
                            if (it.hasNext()) {
                            }
                        } else {
                            AdPlans b2 = AdPlansTransform.a.b(mbAdDbPlans);
                            AdMaterialList adMaterialList2 = (b2 == null || (adMaterialList = b2.getAdMaterialList()) == null) ? null : (AdMaterialList) CollectionsKt.u0(adMaterialList);
                            boolean downloadMaterialSuccess = adMaterialList2 != null ? adMaterialList2.getDownloadMaterialSuccess() : false;
                            if (b2 != null) {
                                b2.setCtxAttributeConfig(adPlans2.getCtxAttributeConfig());
                            }
                            mbAdDbPlans.setVersion(adPlans2.getVersion());
                            mbAdDbPlans.setValid(adPlans2.isValid());
                            Integer showedTimes = TextUtils.equals(mbAdDbPlans.getShowDate(), p.a.c()) ? mbAdDbPlans.getShowedTimes() : null;
                            adPlans2.setShowDate(mbAdDbPlans.getShowDate());
                            adPlans2.setShowedTimes(showedTimes);
                            if (downloadMaterialSuccess && TextUtils.equals(mbAdDbPlans.getAdPlanUpdateTime(), adPlans2.getAdPlanUpdateTime())) {
                                adPlans2.setAdMaterialList(b2 != null ? b2.getAdMaterialList() : null);
                                adPlans2.setAdvertiserAvatarPath(b2 != null ? b2.getAdvertiserAvatarPath() : null);
                                xh.a.c(xh.a.a, a.p() + " --> saveAndDownload() --> 广告计划已存在数据库 --> 内容 无无无 变化 --> 将DB数据赋值给DataBean --> adPlan.name = " + adPlans2.getName() + " --> adPlan.id = " + adPlans2.getId(), 0, false, 2, null);
                                AdPlansStorageManager adPlansStorageManager2 = AdPlansStorageManager.a;
                                adPlansRequestManager$saveAndDownload$1.L$0 = mbAdPlansDto3;
                                adPlansRequestManager$saveAndDownload$1.L$1 = str2;
                                adPlansRequestManager$saveAndDownload$1.L$2 = it;
                                adPlansRequestManager$saveAndDownload$1.L$3 = null;
                                adPlansRequestManager$saveAndDownload$1.label = 3;
                                if (adPlansStorageManager2.j(mbAdDbPlans, adPlansRequestManager$saveAndDownload$1) == f) {
                                    return f;
                                }
                            } else {
                                xh.a aVar2 = xh.a.a;
                                AdPlansRequestManager adPlansRequestManager2 = a;
                                xh.a.c(aVar2, adPlansRequestManager2.p() + " --> saveAndDownload() --> 广告计划已存在数据库 --> 内容 有有有 变化 --> 下载素材、更新数据库 --> adPlan.name = " + adPlans2.getName() + " --> adPlan.id = " + adPlans2.getId(), 0, false, 2, null);
                                adPlansRequestManager$saveAndDownload$1.L$0 = mbAdPlansDto3;
                                adPlansRequestManager$saveAndDownload$1.L$1 = str2;
                                adPlansRequestManager$saveAndDownload$1.L$2 = it;
                                adPlansRequestManager$saveAndDownload$1.L$3 = null;
                                adPlansRequestManager$saveAndDownload$1.label = 2;
                                if (adPlansRequestManager2.o(adPlans2, adPlansRequestManager$saveAndDownload$1) == f) {
                                    return f;
                                }
                            }
                            it2 = it;
                            str3 = str2;
                            mbAdPlansDto2 = mbAdPlansDto3;
                            Iterator it3222 = it2;
                            adPlansRequestManager$saveAndDownload$12 = adPlansRequestManager$saveAndDownload$1;
                            str = str3;
                            it = it3222;
                            z = true;
                            if (it.hasNext()) {
                            }
                        }
                    }
                    return Unit.a;
                }
                adPlans2 = (AdPlans) adPlansRequestManager$saveAndDownload$1.L$3;
                it = (Iterator) adPlansRequestManager$saveAndDownload$1.L$2;
                str2 = (String) adPlansRequestManager$saveAndDownload$1.L$1;
                mbAdPlansDto3 = (MbAdPlansDto) adPlansRequestManager$saveAndDownload$1.L$0;
                ResultKt.b(obj);
                mbAdDbPlans = (MbAdDbPlans) obj;
                adPlans2.setVersion(str2);
                adPlans2.setValid(z);
                adPlans2.setCtxAttributeConfig(mbAdPlansDto3.getData().getCtxAttributeConfig());
                adPlans2.setCountryCode(mbAdPlansDto3.getData().getCountryCode());
                if (mbAdDbPlans == null) {
                }
            }
        }
        adPlansRequestManager$saveAndDownload$1 = new AdPlansRequestManager$saveAndDownload$1(this, continuation);
        Object obj2 = adPlansRequestManager$saveAndDownload$1.result;
        Object f2 = IntrinsicsKt.f();
        i = adPlansRequestManager$saveAndDownload$1.label;
        boolean z2 = true;
        z2 = true;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object w(AdPlans adPlans, Continuation continuation) {
        AdPlansRequestManager$updateAdPlanToDatabase$1 adPlansRequestManager$updateAdPlanToDatabase$1;
        int i;
        if (continuation instanceof AdPlansRequestManager$updateAdPlanToDatabase$1) {
            adPlansRequestManager$updateAdPlanToDatabase$1 = (AdPlansRequestManager$updateAdPlanToDatabase$1) continuation;
            int i2 = adPlansRequestManager$updateAdPlanToDatabase$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                adPlansRequestManager$updateAdPlanToDatabase$1.label = i2 - Integer.MIN_VALUE;
                Object obj = adPlansRequestManager$updateAdPlanToDatabase$1.result;
                Object f = IntrinsicsKt.f();
                i = adPlansRequestManager$updateAdPlanToDatabase$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    MbAdDbPlans a2 = AdPlansTransform.a.a(adPlans);
                    AdPlansStorageManager adPlansStorageManager = AdPlansStorageManager.a;
                    adPlansRequestManager$updateAdPlanToDatabase$1.label = 1;
                    if (adPlansStorageManager.j(a2, adPlansRequestManager$updateAdPlanToDatabase$1) == f) {
                        return f;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                return Boxing.a(true);
            }
        }
        adPlansRequestManager$updateAdPlanToDatabase$1 = new AdPlansRequestManager$updateAdPlanToDatabase$1(this, continuation);
        Object obj2 = adPlansRequestManager$updateAdPlanToDatabase$1.result;
        Object f2 = IntrinsicsKt.f();
        i = adPlansRequestManager$updateAdPlanToDatabase$1.label;
        if (i != 0) {
        }
        return Boxing.a(true);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:0|1|(2:3|(15:5|6|7|(1:(1:(1:(7:12|13|14|15|(3:17|(1:19)|20)|21|22)(2:25|26))(11:27|28|29|(1:31)|32|(1:34)|14|15|(0)|21|22))(4:35|36|37|38))(2:46|(2:48|49)(6:50|51|52|(1:54)(1:59)|55|(1:57)(1:58)))|39|(1:41)|29|(0)|32|(0)|14|15|(0)|21|22))|64|6|7|(0)(0)|39|(0)|29|(0)|32|(0)|14|15|(0)|21|22|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x003d, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x012e A[Catch: all -> 0x003d, TryCatch #2 {all -> 0x003d, blocks: (B:13:0x0038, B:14:0x0145, B:28:0x004c, B:29:0x0126, B:31:0x012e, B:32:0x0138, B:39:0x0114, B:55:0x00f6), top: B:7:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0144 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0125 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object t(String str, Function1 function1, Continuation continuation) {
        AdPlansRequestManager$requestNonAdPlanList$1 adPlansRequestManager$requestNonAdPlanList$1;
        Object obj;
        Object f;
        int i;
        Object obj2;
        Throwable th2;
        String str2;
        String str3;
        PSAdPlanRequestManager pSAdPlanRequestManager;
        Function1 function12 = BuildConfig.FLAVOR;
        if (continuation instanceof AdPlansRequestManager$requestNonAdPlanList$1) {
            adPlansRequestManager$requestNonAdPlanList$1 = (AdPlansRequestManager$requestNonAdPlanList$1) continuation;
            int i2 = adPlansRequestManager$requestNonAdPlanList$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                adPlansRequestManager$requestNonAdPlanList$1.label = i2 - Integer.MIN_VALUE;
                obj = adPlansRequestManager$requestNonAdPlanList$1.result;
                f = IntrinsicsKt.f();
                i = adPlansRequestManager$requestNonAdPlanList$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    if (c.get()) {
                        xh.a.c(xh.a.a, p() + " --> requestNonAdPlanList() --> 正在请求中.... 稍后再试", 5, false, 4, null);
                        return Unit.a;
                    }
                    c.set(true);
                    try {
                        Result.Companion companion = Result.Companion;
                        e eVar = e.a;
                        String string = eVar.c().getString("non_ad_plan_version", BuildConfig.FLAVOR);
                        String string2 = eVar.c().getString("non_ad_scene_version", BuildConfig.FLAVOR);
                        xh.a aVar = xh.a.a;
                        AdPlansRequestManager adPlansRequestManager = a;
                        xh.a.c(aVar, adPlansRequestManager.p() + " --> requestNonAdPlanList() --> 开始请求广告配置接口 --> lastVersion = " + string + " --> lastSceneVersion = " + string2 + " --> url = " + str, 0, false, 6, null);
                        yh.a q = adPlansRequestManager.q();
                        if (string == null) {
                            str2 = BuildConfig.FLAVOR;
                            function12 = function1;
                        } else {
                            function12 = function1;
                            str2 = string;
                        }
                        adPlansRequestManager$requestNonAdPlanList$1.L$0 = function12;
                        adPlansRequestManager$requestNonAdPlanList$1.L$1 = string;
                        adPlansRequestManager$requestNonAdPlanList$1.label = 1;
                        Object a2 = a.C0104a.a(q, str, str2, string2, false, adPlansRequestManager$requestNonAdPlanList$1, 8, null);
                        if (a2 == f) {
                            return f;
                        }
                        str3 = string;
                        obj = a2;
                    } catch (Throwable th3) {
                        th = th3;
                        function12 = function1;
                        Result.Companion companion2 = Result.Companion;
                        obj2 = Result.constructor-impl(ResultKt.a(th));
                        th2 = Result.exceptionOrNull-impl(obj2);
                        if (th2 != null) {
                        }
                        return Unit.a;
                    }
                } else {
                    if (i != 1) {
                        if (i == 2) {
                            function12 = (Function1) adPlansRequestManager$requestNonAdPlanList$1.L$0;
                            ResultKt.b(obj);
                            boolean booleanValue = ((Boolean) obj).booleanValue();
                            if (function12 != null) {
                            }
                            pSAdPlanRequestManager = PSAdPlanRequestManager.a;
                            adPlansRequestManager$requestNonAdPlanList$1.L$0 = function12;
                            adPlansRequestManager$requestNonAdPlanList$1.label = 3;
                            if (pSAdPlanRequestManager.b(adPlansRequestManager$requestNonAdPlanList$1) == f) {
                                return f;
                            }
                            c.set(false);
                            obj2 = Result.constructor-impl(Unit.a);
                            th2 = Result.exceptionOrNull-impl(obj2);
                            if (th2 != null) {
                            }
                            return Unit.a;
                        }
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        function12 = (Function1) adPlansRequestManager$requestNonAdPlanList$1.L$0;
                        ResultKt.b(obj);
                        c.set(false);
                        obj2 = Result.constructor-impl(Unit.a);
                        th2 = Result.exceptionOrNull-impl(obj2);
                        if (th2 != null) {
                            c.set(false);
                            if (function12 != null) {
                            }
                            xh.a.c(xh.a.a, a.p() + " --> requestNonAdPlanList() --> fail fail fail --> 请求非标广告计划列表失败 it = " + th2, 6, false, 4, null);
                        }
                        return Unit.a;
                    }
                    String str4 = (String) adPlansRequestManager$requestNonAdPlanList$1.L$1;
                    Function1 function13 = (Function1) adPlansRequestManager$requestNonAdPlanList$1.L$0;
                    try {
                        ResultKt.b(obj);
                        str3 = str4;
                        function12 = function13;
                    } catch (Throwable th4) {
                        th = th4;
                        function12 = function13;
                        Result.Companion companion22 = Result.Companion;
                        obj2 = Result.constructor-impl(ResultKt.a(th));
                        th2 = Result.exceptionOrNull-impl(obj2);
                        if (th2 != null) {
                        }
                        return Unit.a;
                    }
                }
                AdPlansRequestManager adPlansRequestManager2 = a;
                adPlansRequestManager$requestNonAdPlanList$1.L$0 = function12;
                adPlansRequestManager$requestNonAdPlanList$1.L$1 = null;
                adPlansRequestManager$requestNonAdPlanList$1.label = 2;
                obj = adPlansRequestManager2.r((MbAdPlansDto) obj, str3, adPlansRequestManager$requestNonAdPlanList$1);
                if (obj == f) {
                    return f;
                }
                boolean booleanValue2 = ((Boolean) obj).booleanValue();
                if (function12 != null) {
                }
                pSAdPlanRequestManager = PSAdPlanRequestManager.a;
                adPlansRequestManager$requestNonAdPlanList$1.L$0 = function12;
                adPlansRequestManager$requestNonAdPlanList$1.label = 3;
                if (pSAdPlanRequestManager.b(adPlansRequestManager$requestNonAdPlanList$1) == f) {
                }
                c.set(false);
                obj2 = Result.constructor-impl(Unit.a);
                th2 = Result.exceptionOrNull-impl(obj2);
                if (th2 != null) {
                }
                return Unit.a;
            }
        }
        adPlansRequestManager$requestNonAdPlanList$1 = new AdPlansRequestManager$requestNonAdPlanList$1(this, continuation);
        obj = adPlansRequestManager$requestNonAdPlanList$1.result;
        f = IntrinsicsKt.f();
        i = adPlansRequestManager$requestNonAdPlanList$1.label;
        if (i != 0) {
        }
        AdPlansRequestManager adPlansRequestManager22 = a;
        adPlansRequestManager$requestNonAdPlanList$1.L$0 = function12;
        adPlansRequestManager$requestNonAdPlanList$1.L$1 = null;
        adPlansRequestManager$requestNonAdPlanList$1.label = 2;
        obj = adPlansRequestManager22.r((MbAdPlansDto) obj, str3, adPlansRequestManager$requestNonAdPlanList$1);
        if (obj == f) {
        }
        boolean booleanValue22 = ((Boolean) obj).booleanValue();
        if (function12 != null) {
        }
        pSAdPlanRequestManager = PSAdPlanRequestManager.a;
        adPlansRequestManager$requestNonAdPlanList$1.L$0 = function12;
        adPlansRequestManager$requestNonAdPlanList$1.label = 3;
        if (pSAdPlanRequestManager.b(adPlansRequestManager$requestNonAdPlanList$1) == f) {
        }
        c.set(false);
        obj2 = Result.constructor-impl(Unit.a);
        th2 = Result.exceptionOrNull-impl(obj2);
        if (th2 != null) {
        }
        return Unit.a;
    }
}
