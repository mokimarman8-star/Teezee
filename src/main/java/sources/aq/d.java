package aq;

import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.flow.R$mipmap;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.moviedetailapi.bean.StaffType;
import com.transsion.search.R$drawable;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.R$string;
import com.transsion.search.bean.SuggestEntity;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ni.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d extends BaseItemProvider {
    public int l() {
        return 3;
    }

    public int m() {
        return R$layout.fragment_search_suggest_staff_layout;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, SuggestEntity suggestEntity) {
        String str;
        List staffTypes;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(suggestEntity, "item");
        f.b m = f.a.m(k());
        Staff staff = suggestEntity.getStaff();
        if (staff == null || (str = staff.getAvatarUrl()) == null) {
            str = BuildConfig.FLAVOR;
        }
        m.g(str).i(R$mipmap.movie_staff_default_avatar).d((ImageView) baseViewHolder.getView(R$id.ivCover));
        int i = R$id.tvTitle;
        Staff staff2 = suggestEntity.getStaff();
        baseViewHolder.setText(i, staff2 != null ? staff2.getName() : null);
        AppCompatTextView viewOrNull = baseViewHolder.getViewOrNull(R$id.tvDes);
        if (viewOrNull != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            Staff staff3 = suggestEntity.getStaff();
            if (staff3 != null && (staffTypes = staff3.getStaffTypes()) != null) {
                int i2 = 0;
                for (Object obj : staffTypes) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt.u();
                    }
                    spannableStringBuilder.append((CharSequence) String.valueOf(((StaffType) obj).getName()));
                    if (i2 < staffTypes.size() - 1) {
                        spannableStringBuilder.append((CharSequence) " · ");
                    }
                    i2 = i3;
                }
            }
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            spannableStringBuilder2.append((CharSequence) "  ");
            spannableStringBuilder2.append((CharSequence) spannableStringBuilder.toString());
            int i4 = R$drawable.search_suggest_staff;
            spannableStringBuilder2.setSpan(Build.VERSION.SDK_INT >= 29 ? new ImageSpan(viewOrNull.getContext(), i4, 2) : new ImageSpan(viewOrNull.getContext(), i4, 1), 0, 1, 34);
            viewOrNull.setText(spannableStringBuilder2);
        }
        int i5 = R$id.tvWorks;
        Staff staff4 = suggestEntity.getStaff();
        Integer subjectNum = staff4 != null ? staff4.getSubjectNum() : null;
        baseViewHolder.setText(i5, subjectNum + " " + k().getString(R$string.search_works));
    }
}
