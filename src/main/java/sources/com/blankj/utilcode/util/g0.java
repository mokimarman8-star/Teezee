package com.blankj.utilcode.util;

import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class g0 {
    public static boolean a() {
        return TextUtils.getLayoutDirectionFromLocale(Build.VERSION.SDK_INT >= 24 ? n0.d.a(androidx.appcompat.app.h.a(Utils.a().getResources().getConfiguration()), 0) : Utils.a().getResources().getConfiguration().locale) == 1;
    }

    public static View b(int i) {
        return ((LayoutInflater) Utils.a().getSystemService("layout_inflater")).inflate(i, (ViewGroup) null);
    }
}
