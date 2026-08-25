package com.transsion.shorttv.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.shorttv.R;
import com.transsion.shorttv.bean.AppointSubject;
import com.transsion.shorttv.bean.OperateItem;
import com.transsion.web.api.WebConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010B1\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0011B;\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0012J#\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u0006/"}, d2 = {"Lcom/transsion/shorttv/ui/widget/ShortTvOpAppointmentView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", HttpUrl.FRAGMENT_ENCODE_SET, "pageName", "Lcom/transsion/shorttv/bean/OperateItem;", WebConstants.FIELD_ITEM, HttpUrl.FRAGMENT_ENCODE_SET, "tabId", HttpUrl.FRAGMENT_ENCODE_SET, "isTablet", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Ljava/lang/String;Lcom/transsion/shorttv/bean/OperateItem;IZLandroid/content/Context;Landroid/util/AttributeSet;I)V", "(Ljava/lang/String;Lcom/transsion/shorttv/bean/OperateItem;IZLandroid/content/Context;)V", "(Ljava/lang/String;Lcom/transsion/shorttv/bean/OperateItem;IZLandroid/content/Context;Landroid/util/AttributeSet;)V", HttpUrl.FRAGMENT_ENCODE_SET, "Lcom/transsion/shorttv/bean/AppointSubject;", "list", "h", "(Ljava/util/List;)Ljava/util/List;", HttpUrl.FRAGMENT_ENCODE_SET, "updateData", "(Lcom/transsion/shorttv/bean/OperateItem;)V", "a", "Ljava/lang/String;", "b", "Lcom/transsion/shorttv/bean/OperateItem;", "c", "I", "d", "Z", "Lqr/m0;", "e", "Lqr/m0;", "viewBinding", "Lcom/transsion/shorttv/ui/adapter/q;", "f", "Lcom/transsion/shorttv/ui/adapter/q;", "mAdapter", "Ljava/text/SimpleDateFormat;", "g", "Ljava/text/SimpleDateFormat;", "dateFormat", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class ShortTvOpAppointmentView extends ConstraintLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private final String pageName;

    /* renamed from: b, reason: from kotlin metadata */
    private final OperateItem item;

    /* renamed from: c, reason: from kotlin metadata */
    private final int tabId;

    /* renamed from: d, reason: from kotlin metadata */
    private final boolean isTablet;

    /* renamed from: e, reason: from kotlin metadata */
    private final qr.m0 viewBinding;

    /* renamed from: f, reason: from kotlin metadata */
    private com.transsion.shorttv.ui.adapter.q mAdapter;

    /* renamed from: g, reason: from kotlin metadata */
    private final SimpleDateFormat dateFormat;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShortTvOpAppointmentView(String pageName, OperateItem item, int i, boolean z, Context context) {
        this(pageName, item, i, z, context, null);
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(item, "item");
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShortTvOpAppointmentView(String pageName, OperateItem item, int i, boolean z, Context context, AttributeSet attributeSet) {
        this(pageName, item, i, z, context, attributeSet, 0);
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(item, "item");
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ShortTvOpAppointmentView(String pageName, OperateItem item, int i, boolean z, Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(item, "item");
        Intrinsics.h(context, "context");
        this.pageName = pageName;
        this.item = item;
        this.tabId = i;
        this.isTablet = z;
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        View.inflate(context, R.layout.short_tv_op_appointment, this);
        qr.m0 a = qr.m0.a(this);
        Intrinsics.g(a, "bind(...)");
        this.viewBinding = a;
        a.c.setText(item.getTitle());
        com.transsion.shorttv.ui.adapter.q qVar = new com.transsion.shorttv.ui.adapter.q(0, pageName, 1, null);
        this.mAdapter = qVar;
        RecyclerView recyclerView = a.b;
        recyclerView.setAdapter(qVar);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
        if (recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new com.transsion.shorttv.base.widget.m(8.0f, 0.0f, 12.0f, 2, (DefaultConstructorMarker) null));
        }
        List subjects = item.getSubjects();
        qVar.n1(h(subjects == null ? new ArrayList() : subjects));
        com.transsion.shorttv.ui.adapter.q qVar2 = this.mAdapter;
        if (qVar2 != null) {
            qVar2.Z1(item);
        }
    }

    private final List h(List list) {
        Date date = new Date();
        ArrayList arrayList = new ArrayList();
        try {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                AppointSubject appointSubject = (AppointSubject) it.next();
                SimpleDateFormat simpleDateFormat = this.dateFormat;
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

    public final void updateData(OperateItem item) {
        Intrinsics.h(item, "item");
        com.transsion.shorttv.ui.adapter.q qVar = this.mAdapter;
        if (qVar != null) {
            qVar.Z1(item);
        }
        this.viewBinding.c.setText(item.getTitle());
        List subjects = item.getSubjects();
        if (subjects == null) {
            subjects = new ArrayList();
        }
        List h = h(subjects);
        com.transsion.shorttv.ui.adapter.q qVar2 = this.mAdapter;
        if (qVar2 != null) {
            qVar2.n1(h);
        }
    }
}
