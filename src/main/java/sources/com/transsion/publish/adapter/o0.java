package com.transsion.publish.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.viewpager.widget.PagerAdapter;
import com.bumptech.glide.Glide;
import com.transsion.publish.R$id;
import com.transsion.publish.R$layout;
import com.transsion.publish.api.PhotoEntity;
import com.transsion.publish.view.ZoomImageView;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class o0 extends PagerAdapter {
    private List a;
    private int b;

    public o0(List list) {
        this.a = list != null ? CollectionsKt.U0(list) : null;
    }

    private final View a(Context context, int i) {
        return LayoutInflater.from(context).inflate(i, (ViewGroup) null, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void b(ZoomImageView zoomImageView, String str) {
        Glide.with(zoomImageView).load(str).into(zoomImageView);
    }

    public final void c(List list) {
        this.a = list;
        this.b = getCount();
        notifyDataSetChanged();
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Intrinsics.h(viewGroup, "container");
        Intrinsics.h(obj, "object");
        viewGroup.removeView((View) obj);
    }

    public int getCount() {
        List list = this.a;
        Intrinsics.e(list);
        return list.size();
    }

    public int getItemPosition(Object obj) {
        Intrinsics.h(obj, "object");
        int i = this.b;
        if (i <= 0) {
            return super.getItemPosition(obj);
        }
        this.b = i - 1;
        return -2;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        ViewParent parent;
        Intrinsics.h(viewGroup, "container");
        Context context = viewGroup.getContext();
        View a = context != null ? a(context, R$layout.item_travelga_image) : null;
        List list = this.a;
        Intrinsics.e(list);
        String localPath = ((PhotoEntity) list.get(i)).getLocalPath();
        Object findViewById = a != null ? a.findViewById(R$id.src_pic) : null;
        Intrinsics.f(findViewById, "null cannot be cast to non-null type com.transsion.publish.view.ZoomImageView");
        ZoomImageView zoomImageView = (ZoomImageView) findViewById;
        if (localPath != null) {
            b(zoomImageView, localPath);
        }
        if (a != null) {
            try {
                parent = a.getParent();
            } catch (Exception unused) {
            }
        } else {
            parent = null;
        }
        if (parent != null) {
            if ((a != null ? a.getParent() : null) instanceof ViewGroup) {
                ViewParent parent2 = a != null ? a.getParent() : null;
                Intrinsics.f(parent2, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent2).removeView(a);
            }
        }
        viewGroup.addView(a);
        return a;
    }

    public boolean isViewFromObject(View view, Object obj) {
        Intrinsics.h(view, "view");
        Intrinsics.h(obj, "object");
        return view == obj;
    }
}
