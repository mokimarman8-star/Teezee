package com.transsion.flow.bean;

import com.transsion.baselib.db.download.SubtitleBean;
import com.transsion.gslb.BuildConfig;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SubtitleItem$a {
    private SubtitleItem$a() {
    }

    public /* synthetic */ SubtitleItem$a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final SubtitleBean a(SubtitleItem subtitleItem, String str, String str2, int i, int i2) {
        int i3;
        String lanName;
        Intrinsics.h(subtitleItem, "item");
        Intrinsics.h(str, "postId");
        Integer type = subtitleItem.getType();
        if (type != null) {
            i3 = type.intValue();
        } else {
            String lan = subtitleItem.getLan();
            i3 = (lan == null || lan.length() <= 0 || (lanName = subtitleItem.getLanName()) == null || lanName.length() <= 0) ? 2 : 1;
        }
        int i4 = i3;
        String id = subtitleItem.getId();
        String str3 = (id == null && (id = subtitleItem.getUrl()) == null) ? BuildConfig.FLAVOR : id;
        String url = subtitleItem.getUrl();
        String lan2 = subtitleItem.getLan();
        String lanName2 = subtitleItem.getLanName();
        return new SubtitleBean(str3, str, url, BuildConfig.FLAVOR, lan2, lanName2 == null ? BuildConfig.FLAVOR : lanName2, subtitleItem.getName(), subtitleItem.getSize(), subtitleItem.getDelay(), 0, i4, null, str2, i, i2, 0, 35328, null);
    }
}
