package com.transsion.home.adapter.suboperate.provider;

import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.bean.AppointSubject;
import com.transsion.home.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c extends BaseItemProvider {
    private final Function1 e;
    private final int f;
    private final SimpleDateFormat g;

    public c(Function1 function1, int i) {
        Intrinsics.h(function1, "onAppointmentCLick");
        this.e = function1;
        this.f = i;
        this.g = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(c cVar, OperateItem operateItem) {
        List data;
        BaseProviderMultiAdapter g = cVar.g();
        if (g != null && (data = g.getData()) != null) {
            data.remove(operateItem);
        }
        BaseProviderMultiAdapter g2 = cVar.g();
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
                SimpleDateFormat simpleDateFormat = this.g;
                String appointmentDate = appointSubject.getAppointmentDate();
                if (appointmentDate == null) {
                    appointmentDate = BuildConfig.FLAVOR;
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
        return PostItemType.APPOINTMENT_LIST.ordinal();
    }

    public int m() {
        return R.layout.item_sub_operation_appointment;
    }

    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, final OperateItem operateItem) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(operateItem, "item");
        ((TextView) baseViewHolder.getView(R.id.sub_operation_appointment_title)).setText(operateItem.getTitle());
        RecyclerView view = baseViewHolder.getView(R.id.sub_operation_appointment_recycle);
        com.transsion.home.adapter.suboperate.adapter.f fVar = new com.transsion.home.adapter.suboperate.adapter.f(0, this.e, this.f, operateItem, 1, null);
        view.setAdapter(fVar);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(k(), 0, false);
        linearLayoutManager.setItemPrefetchEnabled(true);
        view.setLayoutManager(linearLayoutManager);
        if (view.getItemDecorationCount() == 0) {
            view.addItemDecoration(new tf.f(8.0f, 0.0f, 12.0f, 2, (DefaultConstructorMarker) null));
        }
        List<AppointSubject> subjects = operateItem.getSubjects();
        if (subjects == null) {
            subjects = new ArrayList<>();
        }
        List B = B(subjects);
        fVar.n1(B);
        if (B.isEmpty()) {
            ((RecyclerView.a0) baseViewHolder).itemView.post(new Runnable() { // from class: com.transsion.home.adapter.suboperate.provider.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.A(c.this, operateItem);
                }
            });
        }
    }
}
