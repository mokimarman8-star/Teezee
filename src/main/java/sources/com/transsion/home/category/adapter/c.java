package com.transsion.home.category.adapter;

import android.content.Context;
import android.view.View;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.flow.R$mipmap;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.R$drawable;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.moviedetailapi.bean.StaffType;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import ni.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c extends BaseItemProvider {
    public int l() {
        return 1;
    }

    public int m() {
        return R.layout.item_cast;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, Staff staff) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(staff, "item");
        ShapeableImageView viewOrNull = baseViewHolder.getViewOrNull(R.id.iv_cover);
        if (viewOrNull != null) {
            int i = R$mipmap.movie_staff_default_avatar;
            String avatarUrl = staff.getAvatarUrl();
            if (avatarUrl == null || avatarUrl.length() == 0) {
                viewOrNull.setImageResource(i);
            } else {
                f.a aVar = ni.f.a;
                Context context = viewOrNull.getContext();
                Intrinsics.g(context, "getContext(...)");
                f.b m = aVar.m(context);
                String avatarUrl2 = staff.getAvatarUrl();
                if (avatarUrl2 == null) {
                    avatarUrl2 = BuildConfig.FLAVOR;
                }
                m.g(avatarUrl2).i(i).d(viewOrNull);
            }
        }
        baseViewHolder.setText(R.id.tv_title, staff.getName());
        int i2 = R.id.tv_subject_num;
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String string = k().getString(R.string.subject_num);
        Intrinsics.g(string, "getString(...)");
        String format = String.format(string, Arrays.copyOf(new Object[]{staff.getSubjectNum()}, 1));
        Intrinsics.g(format, "format(...)");
        baseViewHolder.setText(i2, format);
        StringBuilder sb = new StringBuilder();
        List staffTypes = staff.getStaffTypes();
        if (staffTypes != null) {
            Iterator it = staffTypes.iterator();
            while (it.hasNext()) {
                sb.append(((StaffType) it.next()).getName());
                sb.append("•");
            }
        }
        baseViewHolder.setText(R.id.tv_desc, StringsKt.q1(sb, new char[]{8226}));
        BaseProviderMultiAdapter g = g();
        Integer valueOf = g != null ? Integer.valueOf(g.g0(staff)) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            View viewOrNull2 = baseViewHolder.getViewOrNull(R.id.divider);
            if (viewOrNull2 != null) {
                uf.c.k(viewOrNull2);
            }
            View viewOrNull3 = baseViewHolder.getViewOrNull(R.id.bg_gradient);
            if (viewOrNull3 != null) {
                uf.c.k(viewOrNull3);
            }
            View viewOrNull4 = baseViewHolder.getViewOrNull(R.id.item_root);
            if (viewOrNull4 != null) {
                viewOrNull4.setBackgroundResource(R$drawable.bg_category_first_item);
                return;
            }
            return;
        }
        View viewOrNull5 = baseViewHolder.getViewOrNull(R.id.divider);
        if (viewOrNull5 != null) {
            uf.c.g(viewOrNull5);
        }
        View viewOrNull6 = baseViewHolder.getViewOrNull(R.id.bg_gradient);
        if (viewOrNull6 != null) {
            uf.c.g(viewOrNull6);
        }
        View viewOrNull7 = baseViewHolder.getViewOrNull(R.id.item_root);
        if (viewOrNull7 != null) {
            viewOrNull7.setBackgroundColor(androidx.core.content.b.getColor(k(), com.tn.lib.widget.R.color.bg_01));
        }
    }
}
