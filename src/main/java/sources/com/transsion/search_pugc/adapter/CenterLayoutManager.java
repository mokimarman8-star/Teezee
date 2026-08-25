package com.transsion.search_pugc.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class CenterLayoutManager extends LinearLayoutManager {

    private static class a extends h {
        public a(Context context) {
            super(context);
        }

        public int s(int i, int i2, int i3, int i4, int i5) {
            return (i3 + ((i4 - i3) / 2)) - (i + ((i2 - i) / 2));
        }

        protected float v(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }
    }

    public CenterLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.x xVar, int i) {
        a aVar = new a(recyclerView.getContext());
        aVar.p(i);
        startSmoothScroll(aVar);
    }
}
