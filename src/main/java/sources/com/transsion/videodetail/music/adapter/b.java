package com.transsion.videodetail.music.adapter;

import android.text.TextUtils;
import androidx.recyclerview.widget.DiffUtil;
import com.transsion.baselib.db.music.MusicLikedDbBean;
import com.transsion.videodetail.music.bean.MusicLikedMultiItemEntity;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b extends DiffUtil.a {
    private final List a;
    private final List b;

    public b(List oldList, List newList) {
        Intrinsics.h(oldList, "oldList");
        Intrinsics.h(newList, "newList");
        this.a = oldList;
        this.b = newList;
    }

    public boolean a(int i, int i2) {
        return Intrinsics.c(this.a.get(i), this.b.get(i2));
    }

    public boolean b(int i, int i2) {
        MusicLikedDbBean musicLikedDbBean = ((MusicLikedMultiItemEntity) this.a.get(i)).getMusicLikedDbBean();
        String subjectId = musicLikedDbBean != null ? musicLikedDbBean.getSubjectId() : null;
        MusicLikedDbBean musicLikedDbBean2 = ((MusicLikedMultiItemEntity) this.b.get(i2)).getMusicLikedDbBean();
        return TextUtils.equals(subjectId, musicLikedDbBean2 != null ? musicLikedDbBean2.getSubjectId() : null);
    }

    public int d() {
        return this.b.size();
    }

    public int e() {
        return this.a.size();
    }
}
