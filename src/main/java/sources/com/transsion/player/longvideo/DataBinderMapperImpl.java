package com.transsion.player.longvideo;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class DataBinderMapperImpl extends e {
    private static final SparseIntArray a = new SparseIntArray(0);

    private static class a {
        static final HashMap a = new HashMap(0);
    }

    public List a() {
        ArrayList arrayList = new ArrayList(24);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.avery.subtitle.DataBinderMapperImpl());
        arrayList.add(new com.tn.lib.thread.DataBinderMapperImpl());
        arrayList.add(new com.tn.lib.widget.DataBinderMapperImpl());
        arrayList.add(new com.transsion.ad.DataBinderMapperImpl());
        arrayList.add(new com.transsion.base.dialog.DataBinderMapperImpl());
        arrayList.add(new com.transsion.base.image.DataBinderMapperImpl());
        arrayList.add(new com.transsion.base.report.DataBinderMapperImpl());
        arrayList.add(new com.transsion.baselib.DataBinderMapperImpl());
        arrayList.add(new com.transsion.baseui.DataBinderMapperImpl());
        arrayList.add(new com.transsion.baseui.utils.DataBinderMapperImpl());
        arrayList.add(new com.transsion.commercializationapi.DataBinderMapperImpl());
        arrayList.add(new com.transsion.downloadapi.DataBinderMapperImpl());
        arrayList.add(new com.transsion.mb.config.DataBinderMapperImpl());
        arrayList.add(new com.transsion.mbwidget.DataBinderMapperImpl());
        arrayList.add(new com.transsion.memberapi.DataBinderMapperImpl());
        arrayList.add(new com.transsion.payment.lib.DataBinderMapperImpl());
        arrayList.add(new com.transsion.player.DataBinderMapperImpl());
        arrayList.add(new com.transsion.player.view.DataBinderMapperImpl());
        arrayList.add(new com.transsion.postdetail.DataBinderMapperImpl());
        arrayList.add(new com.transsion.subtitle.DataBinderMapperImpl());
        arrayList.add(new com.transsion.videofloat.DataBinderMapperImpl());
        arrayList.add(new com.transsnet.downloader.DataBinderMapperImpl());
        arrayList.add(new com.transsnet.flow.event.DataBinderMapperImpl());
        return arrayList;
    }

    public ViewDataBinding b(f fVar, View view, int i) {
        if (a.get(i) <= 0 || view.getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public int c(String str) {
        Integer num;
        if (str == null || (num = (Integer) a.a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }
}
