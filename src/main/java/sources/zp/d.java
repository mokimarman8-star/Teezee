package zp;

import android.text.SpannableStringBuilder;
import android.widget.ImageView;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.flow.R$mipmap;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.moviedetailapi.bean.StaffType;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.R$string;
import com.transsion.search.fragment.result.ResultType;
import com.transsion.search.fragment.result.ResultWrapData;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ni.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d extends BaseItemProvider {
    public int l() {
        return ResultType.STAFF.ordinal();
    }

    public int m() {
        return R$layout.provider_result_staff;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, ResultWrapData resultWrapData) {
        String str;
        String description;
        List staffTypes;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(resultWrapData, "item");
        f.b m = ni.f.a.m(k());
        Staff staff = resultWrapData.getStaff();
        if (staff == null || (str = staff.getAvatarUrl()) == null) {
            str = BuildConfig.FLAVOR;
        }
        m.g(str).m(a0.a(50.0f)).i(R$mipmap.movie_staff_default_avatar).d((ImageView) baseViewHolder.getView(R$id.search_result_provider_staff_cover));
        int i = R$id.search_result_provider_staff_title;
        Staff staff2 = resultWrapData.getStaff();
        baseViewHolder.setText(i, staff2 != null ? staff2.getName() : null);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Staff staff3 = resultWrapData.getStaff();
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
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) " ");
        Staff staff4 = resultWrapData.getStaff();
        Integer subjectNum = staff4 != null ? staff4.getSubjectNum() : null;
        spannableStringBuilder.append((CharSequence) (subjectNum + " " + k().getString(R$string.search_works)));
        spannableStringBuilder.setSpan(com.transsion.search.f.b(k()), length, length + 1, 34);
        baseViewHolder.setText(R$id.search_result_provider_staff_brief, spannableStringBuilder);
        Staff staff5 = resultWrapData.getStaff();
        if (staff5 == null || (description = staff5.getDescription()) == null || description.length() <= 0) {
            baseViewHolder.setGone(R$id.search_result_provider_staff_des, true);
            return;
        }
        baseViewHolder.setVisible(R$id.search_result_provider_staff_des, true);
        int i4 = R$id.search_result_provider_staff_des;
        Staff staff6 = resultWrapData.getStaff();
        baseViewHolder.setText(i4, staff6 != null ? staff6.getDescription() : null);
    }
}
