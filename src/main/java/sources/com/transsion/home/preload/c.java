package com.transsion.home.preload;

import android.content.Context;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.bean.AppointSubject;
import com.transsion.home.bean.BannerData;
import com.transsion.home.bean.CustomData;
import com.transsion.home.bean.FilterItem;
import com.transsion.home.bean.OperateItem;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import sm.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class c {
    public static final void a(Context context, List list) {
        Cover cover;
        String url;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Subject feedsSubject = ((OperateItem) it.next()).getFeedsSubject();
                if (feedsSubject != null && (cover = feedsSubject.getCover()) != null && (url = cover.getUrl()) != null && context != null) {
                    d.b(url);
                }
            }
        }
    }

    public static final void b(List list) {
        CustomData customData;
        List<BannerData> items;
        String str;
        String str2;
        String str3;
        if (list != null) {
            int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.u();
                }
                OperateItem operateItem = (OperateItem) obj;
                if (i >= 2) {
                    String type = operateItem.getType();
                    if (Intrinsics.c(type, PostItemType.FILTER.getValue())) {
                        List<FilterItem> filters = operateItem.getFilters();
                        if (filters != null) {
                            int i3 = 0;
                            for (Object obj2 : filters) {
                                int i4 = i3 + 1;
                                if (i3 < 0) {
                                    CollectionsKt.u();
                                }
                                FilterItem filterItem = (FilterItem) obj2;
                                if (i3 < 3) {
                                    Cover image = filterItem.getImage();
                                    if (image == null || (str3 = image.getUrl()) == null) {
                                        str3 = BuildConfig.FLAVOR;
                                    }
                                    d.b(str3);
                                }
                                i3 = i4;
                            }
                        }
                    } else if (Intrinsics.c(type, PostItemType.OP_SUBJECTS_MOVIE.getValue())) {
                        List<AppointSubject> subjects = operateItem.getSubjects();
                        if (subjects != null) {
                            int i5 = 0;
                            for (Object obj3 : subjects) {
                                int i6 = i5 + 1;
                                if (i5 < 0) {
                                    CollectionsKt.u();
                                }
                                AppointSubject appointSubject = (AppointSubject) obj3;
                                if (i5 < 4) {
                                    Cover cover = appointSubject.getCover();
                                    if (cover == null || (str2 = cover.getUrl()) == null) {
                                        str2 = BuildConfig.FLAVOR;
                                    }
                                    d.b(str2);
                                }
                                i5 = i6;
                            }
                        }
                    } else if (Intrinsics.c(type, PostItemType.CUSTOM_DATA.getValue()) && (customData = operateItem.getCustomData()) != null && (items = customData.getItems()) != null) {
                        int i7 = 0;
                        for (Object obj4 : items) {
                            int i8 = i7 + 1;
                            if (i7 < 0) {
                                CollectionsKt.u();
                            }
                            BannerData bannerData = (BannerData) obj4;
                            CustomData customData2 = operateItem.getCustomData();
                            if (i7 < (customData2 != null ? customData2.getRowCount() : 0)) {
                                Image image2 = bannerData.getImage();
                                if (image2 == null || (str = image2.getUrl()) == null) {
                                    str = BuildConfig.FLAVOR;
                                }
                                d.b(str);
                            }
                            i7 = i8;
                        }
                    }
                }
                i = i2;
            }
        }
    }
}
