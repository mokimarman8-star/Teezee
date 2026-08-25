package com.transsion.publish.adapter;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.Utils;
import com.transsion.baseui.R;
import com.transsion.gslb.BuildConfig;
import com.transsion.publish.R$drawable;
import com.transsion.publish.R$layout;
import com.transsion.publish.R$string;
import com.transsion.publish.api.PhotoEntity;
import com.transsion.publish.ui.ClippingImageActivity;
import com.transsion.publish.ui.GalleryActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import ni.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e0 extends RecyclerView.Adapter {
    private final Function1 a;
    private List b;
    private FrameLayout.LayoutParams c;
    private int d;
    private List e;
    private int f;
    private int g;
    private Activity h;
    private int i;

    public static final class a implements View.OnClickListener {
        final /* synthetic */ PhotoEntity b;
        final /* synthetic */ f0 c;

        a(PhotoEntity photoEntity, f0 f0Var) {
            this.b = photoEntity;
            this.c = f0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e0 e0Var;
            Activity activity;
            if (com.transsion.baseui.util.c.a.a(view != null ? view.getId() : 0, 500L)) {
                return;
            }
            if (e0.this.g == 5 || e0.this.g == 7) {
                String localPath = this.b.getLocalPath();
                if (localPath == null || (activity = (e0Var = e0.this).h) == null) {
                    return;
                }
                ClippingImageActivity.Companion.b(ClippingImageActivity.INSTANCE, activity, localPath, e0Var.g, null, 8, null);
                return;
            }
            if (e0.this.t()) {
                e0.this.s(this.b, this.c, true);
            } else if (this.b.getEnableSelect()) {
                e0.this.s(this.b, this.c, true);
            } else {
                e0.this.m(this.b, this.c);
            }
        }
    }

    public e0(Function1 function1) {
        Intrinsics.h(function1, "selectItem");
        this.a = function1;
        this.b = new ArrayList();
        this.e = new ArrayList();
        this.f = 9;
        this.i = 10240;
        this.d = (com.blankj.utilcode.util.y.b() - (com.blankj.utilcode.util.a0.a(3.0f) * 5)) / 4;
        int i = this.d;
        this.c = new FrameLayout.LayoutParams(i, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(PhotoEntity photoEntity, f0 f0Var) {
        o(photoEntity);
        this.e.add(photoEntity);
        this.a.invoke(Integer.valueOf(this.e.size()));
        photoEntity.setEnableSelect(true);
        f0Var.h().setText(p(photoEntity));
        f0Var.h().setBackgroundResource(R$drawable.bg_linear_r16);
        if (t()) {
            notifyDataSetChanged();
        }
    }

    private final void o(PhotoEntity photoEntity) {
        PhotoEntity photoEntity2 = null;
        for (PhotoEntity photoEntity3 : this.e) {
            if (TextUtils.equals(photoEntity3.getLocalPath(), photoEntity.getLocalPath())) {
                photoEntity2 = photoEntity3;
            }
        }
        if (this.e.contains(photoEntity)) {
            this.e.remove(photoEntity);
        }
        if (photoEntity2 != null) {
            this.e.remove(photoEntity2);
        }
    }

    private final String p(PhotoEntity photoEntity) {
        int i = 0;
        for (Object obj : this.e) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.u();
            }
            if (Intrinsics.c(photoEntity.getLocalPath(), ((PhotoEntity) obj).getLocalPath())) {
                return String.valueOf(i2);
            }
            i = i2;
        }
        return "-1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(PhotoEntity photoEntity, f0 f0Var, boolean z) {
        if (photoEntity.getEnableSelect()) {
            o(photoEntity);
            this.a.invoke(Integer.valueOf(this.e.size()));
            photoEntity.setEnableSelect(false);
            f0Var.h().setText(BuildConfig.FLAVOR);
            f0Var.h().setBackgroundResource(R$drawable.ic_select_number_bro);
            if (z) {
                notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean t() {
        return this.e.size() >= this.f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(f0 f0Var, e0 e0Var, PhotoEntity photoEntity, int i, View view) {
        Activity activity;
        String str;
        if (f0Var.i().getVisibility() == 0) {
            Activity activity2 = e0Var.h;
            if (activity2 == null || (str = activity2.getString(R$string.add_img_max_tips)) == null) {
                str = BuildConfig.FLAVOR;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            String format = String.format(str, Arrays.copyOf(new Object[]{Integer.valueOf(e0Var.f)}, 1));
            Intrinsics.g(format, "format(...)");
            com.tn.lib.widget.toast.core.h.a.l(format);
            return;
        }
        int i2 = e0Var.g;
        if (i2 != 5 && i2 != 7) {
            com.transsion.publish.n.b.a().f(e0Var.b);
            GalleryActivity.Companion companion = GalleryActivity.INSTANCE;
            Context context = ((RecyclerView.a0) f0Var).itemView.getContext();
            Intrinsics.g(context, "getContext(...)");
            companion.a(context, e0Var.e, i, 1, e0Var.f);
            return;
        }
        if (photoEntity.getImageSize() > e0Var.i) {
            fh.b.a.e(Utils.a().getResources().getString(R$string.add_media_max_size_tips, 10));
            return;
        }
        String localPath = photoEntity.getLocalPath();
        if (localPath == null || (activity = e0Var.h) == null) {
            return;
        }
        ClippingImageActivity.Companion.b(ClippingImageActivity.INSTANCE, activity, localPath, e0Var.g, null, 8, null);
    }

    public final void A(PhotoEntity photoEntity) {
        if (photoEntity == null || this.e.contains(photoEntity)) {
            return;
        }
        this.e.add(photoEntity);
    }

    public final void addData(List list) {
        Intrinsics.h(list, "data");
        int size = this.b.size();
        this.b.addAll(list);
        notifyItemRangeInserted(size, list.size());
    }

    public int getItemCount() {
        return this.b.size();
    }

    public final void n() {
        List list = this.e;
        if (list != null) {
            list.clear();
        }
    }

    public final List q() {
        return this.b;
    }

    public final List r() {
        return this.e;
    }

    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(final f0 f0Var, final int i) {
        Intrinsics.h(f0Var, "holder");
        final PhotoEntity photoEntity = (PhotoEntity) this.b.get(i);
        ((RecyclerView.a0) f0Var).itemView.setLayoutParams(this.c);
        if (TextUtils.isEmpty(photoEntity.getThumbPath())) {
            String localPath = photoEntity.getLocalPath();
            if (localPath != null && localPath.length() > 0) {
                File file = new File(photoEntity.getLocalPath());
                f.a aVar = ni.f.a;
                Context context = f0Var.f().getContext();
                Intrinsics.g(context, "getContext(...)");
                aVar.m(context).g(Uri.fromFile(file).toString()).i(R.mipmap.home_ic_default_res).j(0).m(this.d).c(this.d).d(f0Var.f());
            }
        } else {
            File file2 = new File(photoEntity.getThumbPath());
            f.a aVar2 = ni.f.a;
            Context context2 = f0Var.f().getContext();
            Intrinsics.g(context2, "getContext(...)");
            aVar2.m(context2).g(Uri.fromFile(file2).toString()).i(R.mipmap.home_ic_default_res).j(0).m(this.d).c(this.d).d(f0Var.f());
        }
        if (this.g != 0) {
            f0Var.i().setVisibility(8);
            f0Var.h().setBackgroundResource(0);
        } else if (!t()) {
            f0Var.i().setVisibility(8);
            if (photoEntity.getEnableSelect()) {
                f0Var.h().setText(p(photoEntity));
                f0Var.h().setBackgroundResource(R$drawable.bg_linear_r16);
            } else {
                f0Var.h().setText(BuildConfig.FLAVOR);
                f0Var.h().setBackgroundResource(R$drawable.ic_select_number_bro);
            }
        } else if (photoEntity.getEnableSelect()) {
            f0Var.i().setVisibility(8);
            f0Var.h().setText(p(photoEntity));
            f0Var.h().setBackgroundResource(R$drawable.bg_linear_r16);
        } else {
            f0Var.i().setVisibility(0);
            f0Var.h().setText(BuildConfig.FLAVOR);
            f0Var.h().setBackgroundResource(R$drawable.ic_select_number_bro);
        }
        ((RecyclerView.a0) f0Var).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.adapter.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e0.v(f0.this, this, photoEntity, i, view);
            }
        });
        f0Var.g().setOnClickListener(new a(photoEntity, f0Var));
    }

    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public f0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.h(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.item_select_image, (ViewGroup) null);
        Intrinsics.e(inflate);
        return new f0(inflate);
    }

    public final void x() {
        List list = this.b;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((PhotoEntity) it.next()).setEnableSelect(false);
            }
        }
    }

    public final void y(int i, Activity activity) {
        Intrinsics.h(activity, "activity");
        this.g = i;
        this.h = activity;
    }

    public final void z(int i) {
        this.f = i;
    }
}
