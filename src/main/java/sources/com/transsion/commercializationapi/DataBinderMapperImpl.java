package com.transsion.commercializationapi;

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
        ArrayList arrayList = new ArrayList(7);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.tn.lib.net.DataBinderMapperImpl());
        arrayList.add(new com.tn.lib.thread.DataBinderMapperImpl());
        arrayList.add(new com.transsion.base.image.DataBinderMapperImpl());
        arrayList.add(new com.transsion.base.report.DataBinderMapperImpl());
        arrayList.add(new com.transsion.baseui.utils.DataBinderMapperImpl());
        arrayList.add(new com.transsion.memberapi.DataBinderMapperImpl());
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
