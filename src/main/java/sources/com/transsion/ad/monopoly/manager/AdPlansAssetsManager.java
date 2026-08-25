package com.transsion.ad.monopoly.manager;

import android.app.Application;
import android.text.TextUtils;
import ci.f;
import com.blankj.utilcode.util.Utils;
import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.model.MbAdImage;
import com.transsion.ad.monopoly.model.MbAdPlansBean;
import com.transsion.ad.monopoly.model.MbAdPlansDto;
import com.transsion.ad.monopoly.model.MbAdVideo;
import com.transsion.ad.monopoly.plan.AdPlansTransform;
import com.transsion.gslb.BuildConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AdPlansAssetsManager extends c {
    public static final AdPlansAssetsManager b = new AdPlansAssetsManager();

    private AdPlansAssetsManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MbAdPlansDto e(MbAdPlansDto mbAdPlansDto) {
        List<AdPlans> adPlans;
        MbAdPlansBean data = mbAdPlansDto.getData();
        if (data != null && (adPlans = data.getAdPlans()) != null) {
            for (AdPlans adPlans2 : adPlans) {
                AdPlansAssetsManager adPlansAssetsManager = b;
                String advertiserAvatar = adPlans2.getAdvertiserAvatar();
                if (advertiserAvatar == null) {
                    advertiserAvatar = BuildConfig.FLAVOR;
                }
                String g = adPlansAssetsManager.g(advertiserAvatar);
                if (!TextUtils.isEmpty(g)) {
                    adPlans2.setAdvertiserAvatarPath(g);
                }
                List<AdMaterialList> adMaterialList = adPlans2.getAdMaterialList();
                if (adMaterialList != null) {
                    for (AdMaterialList adMaterialList2 : adMaterialList) {
                        MbAdVideo video = adMaterialList2.getVideo();
                        if (video != null) {
                            AdPlansAssetsManager adPlansAssetsManager2 = b;
                            String url = video.getUrl();
                            if (url == null) {
                                url = BuildConfig.FLAVOR;
                            }
                            String g2 = adPlansAssetsManager2.g(url);
                            if (!TextUtils.isEmpty(g2)) {
                                video.setPath(g2);
                                adMaterialList2.setDownloadMaterialSuccess(true);
                            }
                        }
                        MbAdImage image = adMaterialList2.getImage();
                        if (image != null) {
                            AdPlansAssetsManager adPlansAssetsManager3 = b;
                            String url2 = image.getUrl();
                            if (url2 == null) {
                                url2 = BuildConfig.FLAVOR;
                            }
                            String g3 = adPlansAssetsManager3.g(url2);
                            if (!TextUtils.isEmpty(g3)) {
                                image.setPath(g3);
                                adMaterialList2.setDownloadMaterialSuccess(true);
                            }
                        }
                    }
                }
            }
        }
        return mbAdPlansDto;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object f(MbAdPlansDto mbAdPlansDto, Continuation continuation) {
        MbAdPlansBean data = mbAdPlansDto.getData();
        if (data != null) {
            ArrayList arrayList = new ArrayList();
            List<AdPlans> adPlans = data.getAdPlans();
            if (adPlans != null) {
                Iterator<T> it = adPlans.iterator();
                while (it.hasNext()) {
                    MbAdDbPlans a = AdPlansTransform.a.a((AdPlans) it.next());
                    a.setVersion(data.getVersion());
                    arrayList.add(a);
                }
            }
            Object k = AdPlansStorageManager.a.k(arrayList, continuation);
            if (k == IntrinsicsKt.f()) {
                return k;
            }
        }
        return Unit.a;
    }

    private final String g(String str) {
        File file = new File(com.transsion.ad.a.a.b(), System.currentTimeMillis() + ".mineType");
        f fVar = f.a;
        Application a = Utils.a();
        Intrinsics.g(a, "getApp(...)");
        if (fVar.a(a, str, file)) {
            return file.getAbsolutePath();
        }
        return null;
    }

    @Override // com.transsion.ad.monopoly.manager.c
    public Object b(Continuation continuation) {
        Object g = i.g(y0.b(), new AdPlansAssetsManager$innerCopy$2(null), continuation);
        return g == IntrinsicsKt.f() ? g : Unit.a;
    }
}
