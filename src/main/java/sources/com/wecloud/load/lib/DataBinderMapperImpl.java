package com.wecloud.load.lib;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class DataBinderMapperImpl extends androidx.databinding.e {
    private static final SparseIntArray a = new SparseIntArray(0);

    private static class a {
        static final HashMap a = new HashMap(0);
    }

    public List a() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.transsion.base.report.DataBinderMapperImpl());
        arrayList.add(new com.transsion.baseui.utils.DataBinderMapperImpl());
        return arrayList;
    }

    public ViewDataBinding b(androidx.databinding.f fVar, View view, int i) {
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
