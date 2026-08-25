package com.transsnet.downloader.adapter;

import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.therouter.TheRouter;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.memberapi.MemberCheckResult;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.R;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import im.a;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.HttpUrl;
import wf.a;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004BS\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001b\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010 \u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0002H\u0014¢\u0006\u0004\b \u0010!J\u001d\u0010#\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\r¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\u0016¢\u0006\u0004\b%\u0010&J\r\u0010'\u001a\u00020\u0016¢\u0006\u0004\b'\u0010&JE\u0010/\u001a\u00020\u001626\u0010.\u001a2\u0012\u0013\u0012\u00110)¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\r¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u00160(¢\u0006\u0004\b/\u00100R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00107R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010;\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00104R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010\u001aR\u001d\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00020E8\u0006¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IRH\u0010M\u001a4\u0012\u0013\u0012\u00110)¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\r¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u0016\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010L¨\u0006N"}, d2 = {"Lcom/transsnet/downloader/adapter/g;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/baselib/db/download/DownloadBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lt6/i;", HttpUrl.FRAGMENT_ENCODE_SET, "season", HttpUrl.FRAGMENT_ENCODE_SET, "dataList", HttpUrl.FRAGMENT_ENCODE_SET, WebConstants.PAGE_FROM, "subjectId", "subjectType", HttpUrl.FRAGMENT_ENCODE_SET, "showPremiumIfNeed", "Lkotlin/Function0;", "hasMore", "<init>", "(ILjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function0;)V", "Landroidx/appcompat/widget/AppCompatImageView;", "checkView", WebConstants.FIELD_ITEM, HttpUrl.FRAGMENT_ENCODE_SET, "N1", "(Landroidx/appcompat/widget/AppCompatImageView;Lcom/transsion/baselib/db/download/DownloadBean;)V", "J1", "(Lcom/transsion/baselib/db/download/DownloadBean;)V", "K1", "newSubjectId", "P1", "(Ljava/lang/String;)V", "holder", "E1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/baselib/db/download/DownloadBean;)V", "add", "D1", "(Lcom/transsion/baselib/db/download/DownloadBean;Z)V", "L1", "()V", "I1", "Lkotlin/Function2;", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/ParameterName;", "name", "totalSize", "isSelectAll", "listener", "O1", "(Lkotlin/jvm/functions/Function2;)V", "F", "I", "G", "Ljava/lang/String;", "H", "Ljava/lang/Integer;", "Ljava/lang/Boolean;", "J", "Lkotlin/jvm/functions/Function0;", "K", "pageFrom", "Lcom/transsnet/downloader/manager/g;", "L", "Lcom/transsnet/downloader/manager/g;", "downloadManager", "M", "Lcom/transsion/baselib/db/download/DownloadBean;", "H1", "()Lcom/transsion/baselib/db/download/DownloadBean;", "M1", "Ljava/util/concurrent/CopyOnWriteArrayList;", "N", "Ljava/util/concurrent/CopyOnWriteArrayList;", "G1", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "checkedList", "O", "Lkotlin/jvm/functions/Function2;", "itemSelectListener", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class g extends BaseQuickAdapter implements t6.i {

    /* renamed from: F, reason: from kotlin metadata */
    private final int season;

    /* renamed from: G, reason: from kotlin metadata */
    private String subjectId;

    /* renamed from: H, reason: from kotlin metadata */
    private Integer subjectType;

    /* renamed from: I, reason: from kotlin metadata */
    private Boolean showPremiumIfNeed;

    /* renamed from: J, reason: from kotlin metadata */
    private final Function0<Boolean> hasMore;

    /* renamed from: K, reason: from kotlin metadata */
    private String pageFrom;

    /* renamed from: L, reason: from kotlin metadata */
    private com.transsnet.downloader.manager.g downloadManager;

    /* renamed from: M, reason: from kotlin metadata */
    private DownloadBean item;

    /* renamed from: N, reason: from kotlin metadata */
    private final CopyOnWriteArrayList<DownloadBean> checkedList;

    /* renamed from: O, reason: from kotlin metadata */
    private Function2<? super Long, ? super Boolean, Unit> itemSelectListener;

    public static final class a implements im.a {
        final /* synthetic */ AppCompatImageView b;
        final /* synthetic */ DownloadBean c;

        a(AppCompatImageView appCompatImageView, DownloadBean downloadBean) {
            this.b = appCompatImageView;
            this.c = downloadBean;
        }

        public void a(MemberCheckResult memberCheckResult) {
            a.a.f(this, memberCheckResult);
        }

        public void b(MemberCheckResult memberCheckResult) {
            a.a.d(this, memberCheckResult);
        }

        public void c(MemberCheckResult memberCheckResult) {
            a.a.g(this, memberCheckResult);
        }

        public void d(MemberCheckResult memberCheckResult) {
            a.a.e(this, memberCheckResult);
        }

        public void e() {
            a.a.c(this);
            g.this.N1(this.b, this.c);
        }

        public void f(MemberCheckResult memberCheckResult) {
            a.a.a(this, memberCheckResult);
        }

        public void onFail(String errorMsg) {
            Intrinsics.h(errorMsg, "errorMsg");
            a.a.b(this, errorMsg);
            a.a.f(wf.a.a, "co_mem", "DownloadBottomAnaGroupAdapter --> convert() --> 多集多分辨率 --> " + errorMsg, false, 4, (Object) null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(int i, List<DownloadBean> dataList, String page_from, String str, Integer num, Boolean bool, Function0<Boolean> hasMore) {
        super(R.layout.item_bottom_dialog_download_ana_group, dataList);
        Intrinsics.h(dataList, "dataList");
        Intrinsics.h(page_from, "page_from");
        Intrinsics.h(hasMore, "hasMore");
        this.season = i;
        this.subjectId = str;
        this.subjectType = num;
        this.showPremiumIfNeed = bool;
        this.hasMore = hasMore;
        this.pageFrom = HttpUrl.FRAGMENT_ENCODE_SET;
        this.checkedList = new CopyOnWriteArrayList<>();
        this.downloadManager = com.transsnet.downloader.manager.p.a.a(Utils.a());
        this.pageFrom = page_from;
    }

    public /* synthetic */ g(int i, List list, String str, String str2, Integer num, Boolean bool, Function0 function0, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, list, str, str2, num, (i2 & 32) != 0 ? Boolean.FALSE : bool, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F1(g gVar, AppCompatImageView appCompatImageView, DownloadBean downloadBean, View view) {
        if (gVar.h0().r()) {
            return;
        }
        if (appCompatImageView.isSelected() || !Intrinsics.c(gVar.showPremiumIfNeed, Boolean.TRUE)) {
            gVar.N1(appCompatImageView, downloadBean);
            return;
        }
        im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
        if (bVar != null) {
            bVar.g(Integer.valueOf(downloadBean.getResolution()), gVar.new a(appCompatImageView, downloadBean));
        }
    }

    private final void J1(DownloadBean item) {
        HashMap hashMap = new HashMap();
        hashMap.put(WebConstants.FIELD_URL, item.getUrl());
        String postId = item.getPostId();
        String str = HttpUrl.FRAGMENT_ENCODE_SET;
        if (postId == null) {
            postId = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        hashMap.put("post_id", postId);
        hashMap.put(WebConstants.PAGE_FROM, this.pageFrom);
        hashMap.put("sequence", String.valueOf(g0(item)));
        hashMap.put("item_type", String.valueOf(item.getType()));
        String name = item.getName();
        if (name == null) {
            name = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        hashMap.put("item_title", name);
        String str2 = this.subjectId;
        if (str2 != null) {
            str = str2;
        }
        hashMap.put("subject_id", str);
        hashMap.put("subject_type", String.valueOf(this.subjectType));
    }

    private final void K1(DownloadBean item) {
        HashMap hashMap = new HashMap();
        hashMap.put(WebConstants.FIELD_URL, item.getUrl());
        String postId = item.getPostId();
        String str = HttpUrl.FRAGMENT_ENCODE_SET;
        if (postId == null) {
            postId = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        hashMap.put("post_id", postId);
        hashMap.put(WebConstants.PAGE_FROM, this.pageFrom);
        hashMap.put("sequence", String.valueOf(g0(item)));
        hashMap.put("item_type", String.valueOf(item.getType()));
        String name = item.getName();
        if (name == null) {
            name = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        hashMap.put("item_title", name);
        String str2 = this.subjectId;
        if (str2 != null) {
            str = str2;
        }
        hashMap.put("subject_id", str);
        hashMap.put("subject_type", String.valueOf(this.subjectType));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N1(AppCompatImageView checkView, DownloadBean item) {
        if (checkView.isSelected()) {
            D1(item, false);
            checkView.setSelected(false);
        } else {
            D1(item, true);
            checkView.setSelected(true);
        }
        item.setCheck(checkView.isSelected());
        I1();
        K1(item);
    }

    public final void D1(DownloadBean item, boolean add) {
        Intrinsics.h(item, "item");
        if (!add) {
            a.a.f(wf.a.a, "DownloadReDete ", "==remove, epName:" + item.getEpName(), false, 4, (Object) null);
            this.checkedList.remove(item);
            return;
        }
        if (this.checkedList.contains(item)) {
            a.a.f(wf.a.a, "DownloadReDete ", "==add contains, epName:" + item.getEpName(), false, 4, (Object) null);
            return;
        }
        a.a.f(wf.a.a, "DownloadReDete ", "==add, epName:" + item.getEpName(), false, 4, (Object) null);
        this.checkedList.add(item);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0070  */
    /* renamed from: E1, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void F(BaseViewHolder holder, final DownloadBean item) {
        String sizeFormat;
        Integer requireMemberType;
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        Integer num = this.subjectType;
        int value = SubjectType.TV.getValue();
        if (num == null || num.intValue() != value) {
            Integer num2 = this.subjectType;
            int value2 = SubjectType.EDUCATION.getValue();
            if (num2 == null || num2.intValue() != value2) {
                holder.setText(R.id.tv_title, item.getTitleName());
                holder.setText(R.id.tv_ep, " " + item.getEpName());
                if (TextUtils.isEmpty(item.getSizeFormat())) {
                    sizeFormat = item.getSizeFormat();
                } else {
                    Long size = item.getSize();
                    sizeFormat = size != null ? zg.b.a(size.longValue(), 1) : null;
                }
                holder.setText(R.id.tv_size, sizeFormat);
                if (item.getCanPlay()) {
                    Long duration = item.getDuration();
                    r2 = (duration != null ? duration.longValue() : 0L) * 1000;
                } else {
                    Long duration2 = item.getDuration();
                    if (duration2 != null) {
                        r2 = duration2.longValue();
                    }
                }
                holder.setText(R.id.tv_time, TimeUtilKt.o(r2));
                final AppCompatImageView view = holder.getView(R.id.iv_check);
                if (item.isUnable()) {
                    view.setEnabled(true);
                    view.setSelected(item.isCheck());
                    ((RecyclerView.a0) holder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.adapter.f
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            g.F1(g.this, view, item, view2);
                        }
                    });
                } else {
                    ((RecyclerView.a0) holder).itemView.setClickable(false);
                    view.setSelected(false);
                    view.setEnabled(false);
                }
                im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
                boolean z = bVar != null ? bVar.z() : false;
                if (Intrinsics.c(this.showPremiumIfNeed, Boolean.TRUE) || !z || (requireMemberType = item.getRequireMemberType()) == null || requireMemberType.intValue() != 1) {
                    uf.c.g(holder.getView(R.id.iv_premium));
                } else {
                    uf.c.k(holder.getView(R.id.iv_premium));
                }
                J1(item);
            }
        }
        holder.setText(R.id.tv_title, item.getEpTitleName(((Boolean) this.hasMore.invoke()).booleanValue()));
        if (TextUtils.isEmpty(item.getSizeFormat())) {
        }
        holder.setText(R.id.tv_size, sizeFormat);
        if (item.getCanPlay()) {
        }
        holder.setText(R.id.tv_time, TimeUtilKt.o(r2));
        final AppCompatImageView view2 = holder.getView(R.id.iv_check);
        if (item.isUnable()) {
        }
        im.b bVar2 = (im.b) TheRouter.d(im.b.class, new Object[0]);
        if (bVar2 != null) {
        }
        if (Intrinsics.c(this.showPremiumIfNeed, Boolean.TRUE)) {
        }
        uf.c.g(holder.getView(R.id.iv_premium));
        J1(item);
    }

    public final CopyOnWriteArrayList<DownloadBean> G1() {
        return this.checkedList;
    }

    /* renamed from: H1, reason: from getter */
    public final DownloadBean getItem() {
        return this.item;
    }

    public final void I1() {
        long j = 0;
        for (DownloadBean downloadBean : this.checkedList) {
            if (!downloadBean.isUnable()) {
                Long size = downloadBean.getSize();
                j += size != null ? size.longValue() : 0L;
            }
        }
        Function2<? super Long, ? super Boolean, Unit> function2 = this.itemSelectListener;
        if (function2 != null) {
            function2.invoke(Long.valueOf(j), Boolean.FALSE);
        }
        a.a.f(wf.a.a, "downloadAna", "onItemSelect, totalSize = " + j + ", checkList.size = " + this.checkedList.size() + ", itemCount = " + getData().size(), false, 4, (Object) null);
    }

    public final void L1() {
        this.checkedList.clear();
    }

    public final void M1(DownloadBean downloadBean) {
        this.item = downloadBean;
    }

    public final void O1(Function2<? super Long, ? super Boolean, Unit> listener) {
        Intrinsics.h(listener, "listener");
        this.itemSelectListener = listener;
    }

    public final void P1(String newSubjectId) {
        Intrinsics.h(newSubjectId, "newSubjectId");
        this.subjectId = newSubjectId;
    }

    public /* bridge */ /* synthetic */ t6.f b(BaseQuickAdapter baseQuickAdapter) {
        return t6.h.a(this, baseQuickAdapter);
    }
}
