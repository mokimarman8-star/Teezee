package com.transsion.shorttv.ui.adapter.provider;

import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.shorttv.R;
import com.transsion.shorttv.bean.AppointSubject;
import com.transsion.shorttv.bean.OperateItem;
import com.transsion.shorttv.bean.ShortTvItemType;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class i extends BaseItemProvider {
    private final String e;
    private final SimpleDateFormat f;

    public i(String pageName) {
        Intrinsics.h(pageName, "pageName");
        this.e = pageName;
        this.f = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(i iVar, OperateItem operateItem) {
        List data;
        BaseProviderMultiAdapter g = iVar.g();
        if (g != null && (data = g.getData()) != null) {
            data.remove(operateItem);
        }
        BaseProviderMultiAdapter g2 = iVar.g();
        if (g2 != null) {
            g2.notifyDataSetChanged();
        }
    }

    private final List B(List list) {
        Date date = new Date();
        ArrayList arrayList = new ArrayList();
        try {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                AppointSubject appointSubject = (AppointSubject) it.next();
                SimpleDateFormat simpleDateFormat = this.f;
                String appointmentDate = appointSubject.getAppointmentDate();
                if (appointmentDate == null) {
                    appointmentDate = HttpUrl.FRAGMENT_ENCODE_SET;
                }
                Date parse = simpleDateFormat.parse(appointmentDate);
                if (parse != null && parse.after(date)) {
                    arrayList.add(appointSubject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public int l() {
        return ShortTvItemType.APPOINTMENT_LIST.ordinal();
    }

    public int m() {
        return R.layout.short_tv_op_appointment;
    }

    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, final OperateItem item) {
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        ((TextView) helper.getView(R.id.sub_operation_appointment_title)).setText(item.getTitle());
        RecyclerView view = helper.getView(R.id.sub_operation_appointment_recycle);
        com.transsion.shorttv.ui.adapter.q qVar = new com.transsion.shorttv.ui.adapter.q(0, this.e, 1, null);
        view.setAdapter(qVar);
        view.setLayoutManager(new LinearLayoutManager(k(), 0, false));
        if (view.getItemDecorationCount() == 0) {
            view.addItemDecoration(new com.transsion.shorttv.base.widget.m(8.0f, 0.0f, 12.0f, 2, (DefaultConstructorMarker) null));
        }
        List subjects = item.getSubjects();
        if (subjects == null) {
            subjects = new ArrayList();
        }
        List B = B(subjects);
        qVar.n1(B);
        if (B.isEmpty()) {
            ((RecyclerView.a0) helper).itemView.post(new Runnable() { // from class: com.transsion.shorttv.ui.adapter.provider.h
                @Override // java.lang.Runnable
                public final void run() {
                    i.A(i.this, item);
                }
            });
        }
    }
}
