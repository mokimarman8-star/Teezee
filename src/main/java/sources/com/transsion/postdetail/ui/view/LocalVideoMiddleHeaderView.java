package com.transsion.postdetail.ui.view;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.viewmodel.LocalVideoDetailViewModel;
import com.transsion.push.PushConstants;
import com.transsion.wrapperad.view.cardpage.NativeCardPageAdHelper;
import com.transsion.wrapperad.view.cardpage.NativeCardPageView;
import com.transsnet.downloader.DownloadManagerApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import ni.f;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\fJ\u0017\u0010\u000f\u001a\n \u000e*\u0004\u0018\u00010\r0\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0013J\u000f\u0010\u0016\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0013J\u001f\u0010\u001a\u001a\u00020\u00112\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0018H\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\nH\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\u00112\b\u0010$\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b%\u0010!J)\u0010*\u001a\u00020\u00112\b\u0010$\u001a\u0004\u0018\u00010\u00182\b\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b*\u0010+J#\u0010.\u001a\u00020\u00112\u0014\u0010-\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\u00110,¢\u0006\u0004\b.\u0010/J\u001b\u00101\u001a\u00020\u00112\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001100¢\u0006\u0004\b1\u00102J\u0017\u00104\u001a\u0004\u0018\u00010\u00182\u0006\u00103\u001a\u00020\r¢\u0006\u0004\b4\u00105J\r\u00106\u001a\u00020\u0011¢\u0006\u0004\b6\u0010\u0013J\u000f\u00107\u001a\u00020\u0011H\u0016¢\u0006\u0004\b7\u0010\u0013J\r\u00108\u001a\u00020\u0011¢\u0006\u0004\b8\u0010\u0013R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010?\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u001b\u0010E\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR&\u0010L\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\u0011\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u001e\u0010O\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010R\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010T\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010>R\u001b\u0010Y\u001a\u00020U8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bV\u0010B\u001a\u0004\bW\u0010XR\u0018\u0010]\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u001a\u0010a\u001a\u00020\n8\u0006X\u0086D¢\u0006\f\n\u0004\b^\u0010>\u001a\u0004\b_\u0010`R\u001a\u0010d\u001a\u00020\n8\u0006X\u0086D¢\u0006\f\n\u0004\bb\u0010>\u001a\u0004\bc\u0010`R\u001a\u0010g\u001a\u00020\n8\u0006X\u0086D¢\u0006\f\n\u0004\be\u0010>\u001a\u0004\bf\u0010`¨\u0006h"}, d2 = {"Lcom/transsion/postdetail/ui/view/LocalVideoMiddleHeaderView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lim/f;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BuildConfig.FLAVOR, "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BuildConfig.FLAVOR, "kotlin.jvm.PlatformType", "getClassTag", "()Ljava/lang/String;", BuildConfig.FLAVOR, "z", "()V", "r", "y", "w", BuildConfig.FLAVOR, "Lcom/transsion/baselib/db/download/DownloadBean;", "list", "H", "(Ljava/util/List;)V", "bean", "position", "E", "(Lcom/transsion/baselib/db/download/DownloadBean;I)V", "F", "(Lcom/transsion/baselib/db/download/DownloadBean;)V", "G", "(I)V", "downloadBean", "updateDownloadBean", "Lcom/transsion/wrapperad/view/cardpage/NativeCardPageView;", "nativeSlideshowView", "Landroidx/lifecycle/LifecycleCoroutineScope;", "scope", "init", "(Lcom/transsion/baselib/db/download/DownloadBean;Lcom/transsion/wrapperad/view/cardpage/NativeCardPageView;Landroidx/lifecycle/LifecycleCoroutineScope;)V", "Lkotlin/Function1;", "callback", "setItemClickCallback", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function0;", "setAllListClickCallback", "(Lkotlin/jvm/functions/Function0;)V", "resourceId", "getDownloadBean", "(Ljava/lang/String;)Lcom/transsion/baselib/db/download/DownloadBean;", PushConstants.PROVIDER_FIELD_DESTROY, "onMemberStateChange", "destroyAdHelper", "Lwn/x;", "a", "Lwn/x;", "viewBinding", "b", "I", "scrollOffset", "Lcom/transsion/postdetail/viewmodel/LocalVideoDetailViewModel;", "c", "Lkotlin/Lazy;", "getViewModel", "()Lcom/transsion/postdetail/viewmodel/LocalVideoDetailViewModel;", "viewModel", "Lcom/transsion/postdetail/ui/adapter/c;", "d", "Lcom/transsion/postdetail/ui/adapter/c;", "seriesAdapter", "e", "Lkotlin/jvm/functions/Function1;", "itemClickCallback", "f", "Lkotlin/jvm/functions/Function0;", "showAllCallback", "g", "Lcom/transsion/baselib/db/download/DownloadBean;", "mDownloadBean", "h", "refreshTime", "Landroid/os/Handler;", "i", "getMHandler", "()Landroid/os/Handler;", "mHandler", "Lcom/transsion/wrapperad/view/cardpage/NativeCardPageAdHelper;", "j", "Lcom/transsion/wrapperad/view/cardpage/NativeCardPageAdHelper;", "adHelper", "k", "getMaxStep", "()I", "maxStep", "l", "getStep", "step", "m", "getDefault", "default", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class LocalVideoMiddleHeaderView extends ConstraintLayout implements im.f {

    /* renamed from: a, reason: from kotlin metadata */
    private final wn.x viewBinding;

    /* renamed from: b, reason: from kotlin metadata */
    private final int scrollOffset;

    /* renamed from: c, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: d, reason: from kotlin metadata */
    private com.transsion.postdetail.ui.adapter.c seriesAdapter;

    /* renamed from: e, reason: from kotlin metadata */
    private Function1 itemClickCallback;

    /* renamed from: f, reason: from kotlin metadata */
    private Function0 showAllCallback;

    /* renamed from: g, reason: from kotlin metadata */
    private DownloadBean mDownloadBean;

    /* renamed from: h, reason: from kotlin metadata */
    private int refreshTime;

    /* renamed from: i, reason: from kotlin metadata */
    private final Lazy mHandler;

    /* renamed from: j, reason: from kotlin metadata */
    private NativeCardPageAdHelper adHelper;

    /* renamed from: k, reason: from kotlin metadata */
    private final int maxStep;

    /* renamed from: l, reason: from kotlin metadata */
    private final int step;

    /* renamed from: m, reason: from kotlin metadata */
    private final int default;

    public static final class a extends DiffUtil.e {
        a() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(DownloadBean downloadBean, DownloadBean downloadBean2) {
            Intrinsics.h(downloadBean, "oldItem");
            Intrinsics.h(downloadBean2, "newItem");
            return Intrinsics.c(downloadBean.getResourceId(), downloadBean2.getResourceId()) && downloadBean.getStatus() == downloadBean2.getStatus() && downloadBean.getProgress() == downloadBean2.getProgress() && Intrinsics.c(downloadBean.getUpdateTimeStamp(), downloadBean2.getUpdateTimeStamp());
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(DownloadBean downloadBean, DownloadBean downloadBean2) {
            Intrinsics.h(downloadBean, "oldItem");
            Intrinsics.h(downloadBean2, "newItem");
            return Intrinsics.c(downloadBean.getResourceId(), downloadBean2.getResourceId());
        }
    }

    public static final class b extends RecyclerView.l {
        final /* synthetic */ int a;

        b(int i) {
            this.a = i;
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.x xVar) {
            Intrinsics.h(rect, "outRect");
            Intrinsics.h(view, "view");
            Intrinsics.h(recyclerView, "parent");
            Intrinsics.h(xVar, "state");
            super.getItemOffsets(rect, view, recyclerView, xVar);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            if (recyclerView.getAdapter() != null) {
                if (childAdapterPosition == 0) {
                    if (uf.c.f()) {
                        rect.right = 0;
                        rect.left = this.a;
                        return;
                    } else {
                        rect.left = 0;
                        rect.right = this.a;
                        return;
                    }
                }
                if (childAdapterPosition != r4.getItemCount() - 1) {
                    int i = this.a;
                    rect.right = i;
                    rect.left = i;
                } else if (uf.c.f()) {
                    int i2 = this.a;
                    rect.right = i2;
                    rect.left = i2 * 3;
                } else {
                    int i3 = this.a;
                    rect.left = i3;
                    rect.right = i3 * 3;
                }
            }
        }
    }

    static final class c implements androidx.lifecycle.c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        c(Function1 function1) {
            Intrinsics.h(function1, "function");
            this.a = function1;
        }

        public final Function a() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof androidx.lifecycle.c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.a.invoke(obj);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocalVideoMiddleHeaderView(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocalVideoMiddleHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LocalVideoMiddleHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        JsonElement jsonElement;
        Intrinsics.h(context, "context");
        this.scrollOffset = (com.blankj.utilcode.util.y.e() / 2) - com.blankj.utilcode.util.a0.a(80.0f);
        this.viewModel = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ui.view.u
            public final Object invoke() {
                LocalVideoDetailViewModel I;
                I = LocalVideoMiddleHeaderView.I(LocalVideoMiddleHeaderView.this);
                return I;
            }
        });
        int i2 = 15;
        this.refreshTime = 15;
        this.mHandler = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ui.view.v
            public final Object invoke() {
                Handler D;
                D = LocalVideoMiddleHeaderView.D();
                return D;
            }
        });
        View.inflate(getContext(), R$layout.layout_local_video_middle_header, this);
        wn.x a2 = wn.x.a(this);
        Intrinsics.g(a2, "bind(...)");
        this.viewBinding = a2;
        JsonObject b2 = com.transsion.ad.scene.d.a.b("MediaPlayerMidDescScene");
        if (b2 != null && (jsonElement = b2.get("refreshTime")) != null) {
            i2 = jsonElement.getAsInt();
        }
        this.refreshTime = i2;
        im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
        if (bVar != null) {
            bVar.D(this);
        }
        this.maxStep = 128;
        this.step = 2;
        this.default = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(LocalVideoMiddleHeaderView localVideoMiddleHeaderView, List list) {
        localVideoMiddleHeaderView.H(list);
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            AppCompatTextView appCompatTextView = localVideoMiddleHeaderView.viewBinding.i;
            Intrinsics.g(appCompatTextView, "tvEpTitle");
            uf.c.g(appCompatTextView);
            RecyclerView recyclerView = localVideoMiddleHeaderView.viewBinding.h;
            Intrinsics.g(recyclerView, "recyclerViewEp");
            uf.c.g(recyclerView);
            AppCompatTextView appCompatTextView2 = localVideoMiddleHeaderView.viewBinding.d;
            Intrinsics.g(appCompatTextView2, "innerTvName");
            uf.c.g(appCompatTextView2);
            AppCompatTextView appCompatTextView3 = localVideoMiddleHeaderView.viewBinding.c;
            Intrinsics.g(appCompatTextView3, "innerTvInfo");
            uf.c.g(appCompatTextView3);
            AppCompatImageView appCompatImageView = localVideoMiddleHeaderView.viewBinding.b;
            Intrinsics.g(appCompatImageView, "innerIcon");
            uf.c.g(appCompatImageView);
            return Unit.a;
        }
        DownloadBean downloadBean = localVideoMiddleHeaderView.mDownloadBean;
        String uploadBy = downloadBean != null ? downloadBean.getUploadBy() : null;
        if (uploadBy == null || uploadBy.length() == 0) {
            AppCompatTextView appCompatTextView4 = localVideoMiddleHeaderView.viewBinding.d;
            Intrinsics.g(appCompatTextView4, "innerTvName");
            uf.c.g(appCompatTextView4);
            AppCompatTextView appCompatTextView5 = localVideoMiddleHeaderView.viewBinding.c;
            Intrinsics.g(appCompatTextView5, "innerTvInfo");
            uf.c.g(appCompatTextView5);
        } else {
            AppCompatTextView appCompatTextView6 = localVideoMiddleHeaderView.viewBinding.d;
            Intrinsics.g(appCompatTextView6, "innerTvName");
            uf.c.k(appCompatTextView6);
            AppCompatTextView appCompatTextView7 = localVideoMiddleHeaderView.viewBinding.c;
            Intrinsics.g(appCompatTextView7, "innerTvInfo");
            uf.c.k(appCompatTextView7);
            AppCompatTextView appCompatTextView8 = localVideoMiddleHeaderView.viewBinding.d;
            DownloadBean downloadBean2 = localVideoMiddleHeaderView.mDownloadBean;
            appCompatTextView8.setText(downloadBean2 != null ? downloadBean2.getUploadBy() : null);
        }
        AppCompatImageView appCompatImageView2 = localVideoMiddleHeaderView.viewBinding.b;
        Intrinsics.g(appCompatImageView2, "innerIcon");
        uf.c.k(appCompatImageView2);
        AppCompatTextView appCompatTextView9 = localVideoMiddleHeaderView.viewBinding.i;
        Intrinsics.g(appCompatTextView9, "tvEpTitle");
        uf.c.k(appCompatTextView9);
        RecyclerView recyclerView2 = localVideoMiddleHeaderView.viewBinding.h;
        Intrinsics.g(recyclerView2, "recyclerViewEp");
        uf.c.k(recyclerView2);
        if (list.size() > 3) {
            BLTextView bLTextView = localVideoMiddleHeaderView.viewBinding.j;
            Intrinsics.g(bLTextView, "tvMore");
            uf.c.k(bLTextView);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(LocalVideoMiddleHeaderView localVideoMiddleHeaderView, DownloadBean downloadBean) {
        com.transsion.postdetail.ui.adapter.c cVar;
        List data;
        List data2;
        int i = 0;
        if (downloadBean != null) {
            downloadBean.setPlaying(false);
        }
        com.transsion.postdetail.ui.adapter.c cVar2 = localVideoMiddleHeaderView.seriesAdapter;
        int i2 = -1;
        if (cVar2 != null && (data2 = cVar2.getData()) != null) {
            Iterator it = data2.iterator();
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (Intrinsics.c(((DownloadBean) it.next()).getResourceId(), downloadBean != null ? downloadBean.getResourceId() : null)) {
                    i2 = i3;
                    break;
                }
                i3++;
            }
        }
        if (i2 >= 0) {
            com.transsion.postdetail.ui.adapter.c cVar3 = localVideoMiddleHeaderView.seriesAdapter;
            if (cVar3 != null && (data = cVar3.getData()) != null) {
                i = data.size();
            }
            if (i2 < i && (cVar = localVideoMiddleHeaderView.seriesAdapter) != null) {
                cVar.notifyItemChanged(i2, Boolean.FALSE);
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(LocalVideoMiddleHeaderView localVideoMiddleHeaderView, DownloadBean downloadBean) {
        com.transsion.postdetail.ui.adapter.c cVar;
        List data;
        List data2;
        if (downloadBean != null) {
            downloadBean.setPlaying(true);
        }
        com.transsion.postdetail.ui.adapter.c cVar2 = localVideoMiddleHeaderView.seriesAdapter;
        int i = -1;
        int i2 = 0;
        if (cVar2 != null && (data2 = cVar2.getData()) != null) {
            Iterator it = data2.iterator();
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (Intrinsics.c(((DownloadBean) it.next()).getResourceId(), downloadBean != null ? downloadBean.getResourceId() : null)) {
                    i = i3;
                    break;
                }
                i3++;
            }
        }
        if (i >= 0) {
            com.transsion.postdetail.ui.adapter.c cVar3 = localVideoMiddleHeaderView.seriesAdapter;
            if (cVar3 != null && (data = cVar3.getData()) != null) {
                i2 = data.size();
            }
            if (i < i2 && (cVar = localVideoMiddleHeaderView.seriesAdapter) != null) {
                cVar.notifyItemChanged(i, Boolean.TRUE);
            }
        }
        Intrinsics.e(downloadBean);
        localVideoMiddleHeaderView.F(downloadBean);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler D() {
        return new Handler(Looper.getMainLooper());
    }

    private final void E(DownloadBean bean, int position) {
        Function1 function1 = this.itemClickCallback;
        if (function1 != null) {
            function1.invoke(bean);
        }
    }

    private final void F(DownloadBean bean) {
        List data;
        List data2;
        com.transsion.postdetail.ui.adapter.c cVar = this.seriesAdapter;
        int i = -1;
        int i2 = 0;
        if (cVar != null && (data2 = cVar.getData()) != null) {
            Iterator it = data2.iterator();
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (Intrinsics.c(((DownloadBean) it.next()).getResourceId(), bean.getResourceId())) {
                    i = i3;
                    break;
                }
                i3++;
            }
        }
        if (i > 0) {
            com.transsion.postdetail.ui.adapter.c cVar2 = this.seriesAdapter;
            if (cVar2 != null && (data = cVar2.getData()) != null) {
                i2 = data.size();
            }
            if (i < i2) {
                G(i);
            }
        }
    }

    private final void G(int position) {
        if (position < 0) {
            return;
        }
        try {
            this.viewBinding.h.scrollToPosition(position);
            LinearLayoutManager layoutManager = this.viewBinding.h.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                LinearLayoutManager linearLayoutManager = layoutManager;
                int i = this.scrollOffset;
                if (i <= 0) {
                    i = 0;
                }
                linearLayoutManager.scrollToPositionWithOffset(position, i);
            }
        } catch (Throwable unused) {
        }
    }

    private final void H(List list) {
        com.transsion.postdetail.ui.adapter.c cVar = this.seriesAdapter;
        if (cVar != null) {
            cVar.n1(list);
        }
        DownloadBean downloadBean = this.mDownloadBean;
        if (downloadBean != null) {
            F(downloadBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final LocalVideoDetailViewModel I(LocalVideoMiddleHeaderView localVideoMiddleHeaderView) {
        FragmentActivity context = localVideoMiddleHeaderView.getContext();
        Intrinsics.f(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        return (LocalVideoDetailViewModel) new androidx.lifecycle.v0(context, new v0.d()).a(LocalVideoDetailViewModel.class);
    }

    private final String getClassTag() {
        return LocalVideoMiddleHeaderView.class.getSimpleName();
    }

    private final Handler getMHandler() {
        return (Handler) this.mHandler.getValue();
    }

    private final LocalVideoDetailViewModel getViewModel() {
        return (LocalVideoDetailViewModel) this.viewModel.getValue();
    }

    private final void r() {
        this.viewBinding.j.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LocalVideoMiddleHeaderView.v(LocalVideoMiddleHeaderView.this, view);
            }
        });
        this.viewBinding.f.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LocalVideoMiddleHeaderView.s(LocalVideoMiddleHeaderView.this, view);
            }
        });
        this.viewBinding.g.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LocalVideoMiddleHeaderView.t(LocalVideoMiddleHeaderView.this, view);
            }
        });
        this.viewBinding.b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LocalVideoMiddleHeaderView.u(LocalVideoMiddleHeaderView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void s(LocalVideoMiddleHeaderView localVideoMiddleHeaderView, View view) {
        Navigator c2 = TheRouter.c("/movie/detail");
        DownloadBean downloadBean = localVideoMiddleHeaderView.mDownloadBean;
        Navigator F = c2.F("subject_type", downloadBean != null ? downloadBean.getSubjectType() : SubjectType.MOVIE.getValue());
        DownloadBean downloadBean2 = localVideoMiddleHeaderView.mDownloadBean;
        Navigator.x(F.K("id", downloadBean2 != null ? downloadBean2.getSubjectId() : null).z("autoPlay", true), localVideoMiddleHeaderView.getContext(), (mf.c) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void t(LocalVideoMiddleHeaderView localVideoMiddleHeaderView, View view) {
        String str;
        DownloadBean downloadBean = localVideoMiddleHeaderView.mDownloadBean;
        if (downloadBean != null) {
            DownloadManagerApi a2 = DownloadManagerApi.j.a();
            FragmentActivity context = localVideoMiddleHeaderView.getContext();
            Intrinsics.f(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            FragmentActivity fragmentActivity = context;
            Subject subject = (Subject) localVideoMiddleHeaderView.getViewModel().g().f();
            Subject a3 = subject == null ? dn.a.a(downloadBean) : subject;
            DownloadBean downloadBean2 = localVideoMiddleHeaderView.mDownloadBean;
            String ops = downloadBean2 != null ? downloadBean2.getOps() : null;
            DownloadBean downloadBean3 = localVideoMiddleHeaderView.mDownloadBean;
            if (downloadBean3 == null || (str = downloadBean3.getSourceUrl()) == null) {
                str = BuildConfig.FLAVOR;
            }
            String str2 = str;
            DownloadBean downloadBean4 = (DownloadBean) localVideoMiddleHeaderView.getViewModel().e().f();
            DownloadManagerApi.N(a2, fragmentActivity, a3, "local_video_detail_middle", (String) null, ops, str2, (String) null, (String) null, (String) null, false, downloadBean4 != null ? downloadBean4.getSe() : 0, false, 968, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void u(LocalVideoMiddleHeaderView localVideoMiddleHeaderView, View view) {
        Navigator K = TheRouter.c("/profile/user_center_labels_feedback").K("feedback_from_page", "SUBJECT_PLAY");
        DownloadBean downloadBean = localVideoMiddleHeaderView.mDownloadBean;
        Navigator.x(K.K("subject_id", downloadBean != null ? downloadBean.getSubjectId() : null), localVideoMiddleHeaderView.getContext(), (mf.c) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(LocalVideoMiddleHeaderView localVideoMiddleHeaderView, View view) {
        Function0 function0 = localVideoMiddleHeaderView.showAllCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final void w() {
        com.transsion.postdetail.ui.adapter.c cVar = new com.transsion.postdetail.ui.adapter.c(new ArrayList(), false, 2, null);
        cVar.w1(new r6.d() { // from class: com.transsion.postdetail.ui.view.d0
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                LocalVideoMiddleHeaderView.x(LocalVideoMiddleHeaderView.this, baseQuickAdapter, view, i);
            }
        });
        cVar.R0(new a());
        this.seriesAdapter = cVar;
        RecyclerView recyclerView = this.viewBinding.h;
        int b2 = lj.a.b(4);
        recyclerView.setLayoutManager(new NpaLinearLayoutManager(recyclerView.getContext(), 0, false));
        recyclerView.setAdapter(this.seriesAdapter);
        recyclerView.addItemDecoration(new b(b2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(LocalVideoMiddleHeaderView localVideoMiddleHeaderView, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "view");
        if (com.transsion.baseui.util.c.a.a(view.getId(), 2000L) || baseQuickAdapter.getData().isEmpty()) {
            return;
        }
        Object obj = baseQuickAdapter.getData().get(i);
        Intrinsics.f(obj, "null cannot be cast to non-null type com.transsion.baselib.db.download.DownloadBean");
        localVideoMiddleHeaderView.E((DownloadBean) obj, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void y() {
        String cover;
        String str;
        setPadding(0, 0, 0, lj.a.b(16));
        DownloadBean downloadBean = this.mDownloadBean;
        if (downloadBean == null || !downloadBean.isInnerSubjectRes()) {
            BLLinearLayout bLLinearLayout = this.viewBinding.f;
            Intrinsics.g(bLLinearLayout, "llDetail");
            uf.c.g(bLLinearLayout);
            BLLinearLayout bLLinearLayout2 = this.viewBinding.g;
            Intrinsics.g(bLLinearLayout2, "llDownload");
            uf.c.g(bLLinearLayout2);
        } else {
            DownloadBean downloadBean2 = this.mDownloadBean;
            if (downloadBean2 != null && (cover = downloadBean2.getCover()) != null && !Intrinsics.c(this.viewBinding.e.getTag(), cover)) {
                this.viewBinding.e.setTag(cover);
                f.a aVar = ni.f.a;
                Context context = getContext();
                Intrinsics.g(context, "getContext(...)");
                f.b g = aVar.m(context).g(cover);
                DownloadBean downloadBean3 = this.mDownloadBean;
                if (downloadBean3 == null || (str = downloadBean3.getThumbnail()) == null) {
                    str = BuildConfig.FLAVOR;
                }
                f.b l = g.l(str);
                ShapeableImageView shapeableImageView = this.viewBinding.e;
                Intrinsics.g(shapeableImageView, "ivCover");
                l.d(shapeableImageView);
            }
        }
        DownloadBean downloadBean4 = this.mDownloadBean;
        if (downloadBean4 == null || !downloadBean4.isSeries()) {
            AppCompatTextView appCompatTextView = this.viewBinding.i;
            Intrinsics.g(appCompatTextView, "tvEpTitle");
            uf.c.g(appCompatTextView);
            RecyclerView recyclerView = this.viewBinding.h;
            Intrinsics.g(recyclerView, "recyclerViewEp");
            uf.c.g(recyclerView);
            AppCompatTextView appCompatTextView2 = this.viewBinding.d;
            Intrinsics.g(appCompatTextView2, "innerTvName");
            uf.c.g(appCompatTextView2);
            AppCompatTextView appCompatTextView3 = this.viewBinding.c;
            Intrinsics.g(appCompatTextView3, "innerTvInfo");
            uf.c.g(appCompatTextView3);
            AppCompatImageView appCompatImageView = this.viewBinding.b;
            Intrinsics.g(appCompatImageView, "innerIcon");
            uf.c.g(appCompatImageView);
        }
        w();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void z() {
        androidx.lifecycle.b0 i = getViewModel().i();
        FragmentActivity context = getContext();
        Intrinsics.f(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        i.j(context, new c(new Function1() { // from class: com.transsion.postdetail.ui.view.w
            public final Object invoke(Object obj) {
                Unit A;
                A = LocalVideoMiddleHeaderView.A(LocalVideoMiddleHeaderView.this, (List) obj);
                return A;
            }
        }));
        androidx.lifecycle.b0 f = getViewModel().f();
        FragmentActivity context2 = getContext();
        Intrinsics.f(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        f.j(context2, new c(new Function1() { // from class: com.transsion.postdetail.ui.view.x
            public final Object invoke(Object obj) {
                Unit B;
                B = LocalVideoMiddleHeaderView.B(LocalVideoMiddleHeaderView.this, (DownloadBean) obj);
                return B;
            }
        }));
        androidx.lifecycle.b0 e = getViewModel().e();
        FragmentActivity context3 = getContext();
        Intrinsics.f(context3, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        e.j(context3, new c(new Function1() { // from class: com.transsion.postdetail.ui.view.y
            public final Object invoke(Object obj) {
                Unit C;
                C = LocalVideoMiddleHeaderView.C(LocalVideoMiddleHeaderView.this, (DownloadBean) obj);
                return C;
            }
        }));
    }

    public final void destroy() {
        getMHandler().removeCallbacksAndMessages(null);
        destroyAdHelper();
        im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
        if (bVar != null) {
            bVar.v(this);
        }
    }

    public final void destroyAdHelper() {
        NativeCardPageAdHelper nativeCardPageAdHelper = this.adHelper;
        if (nativeCardPageAdHelper != null) {
            nativeCardPageAdHelper.x();
        }
        this.adHelper = null;
    }

    public final int getDefault() {
        return this.default;
    }

    public final DownloadBean getDownloadBean(String resourceId) {
        List data;
        Intrinsics.h(resourceId, "resourceId");
        com.transsion.postdetail.ui.adapter.c cVar = this.seriesAdapter;
        Object obj = null;
        if (cVar == null || (data = cVar.getData()) == null) {
            return null;
        }
        Iterator it = data.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (Intrinsics.c(((DownloadBean) next).getResourceId(), resourceId)) {
                obj = next;
                break;
            }
        }
        return (DownloadBean) obj;
    }

    public final int getMaxStep() {
        return this.maxStep;
    }

    public final int getStep() {
        return this.step;
    }

    public final void init(DownloadBean downloadBean, NativeCardPageView nativeSlideshowView, LifecycleCoroutineScope scope) {
        NativeCardPageAdHelper G;
        Intrinsics.h(scope, "scope");
        this.mDownloadBean = downloadBean;
        NativeCardPageAdHelper nativeCardPageAdHelper = new NativeCardPageAdHelper(scope);
        this.adHelper = nativeCardPageAdHelper;
        if (nativeSlideshowView != null && (G = nativeCardPageAdHelper.G("MediaPlayerMidDescScene")) != null) {
            com.transsion.ad.strategy.c cVar = com.transsion.ad.strategy.c.a;
            DownloadBean downloadBean2 = this.mDownloadBean;
            NativeCardPageAdHelper F = G.F(cVar.a(downloadBean2 != null ? downloadBean2.getGenre() : null));
            if (F != null) {
                F.u(nativeSlideshowView);
            }
        }
        y();
        z();
        r();
    }

    @Override // im.f
    public void onMemberStateChange() {
        im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
        if (bVar == null || !bVar.e()) {
            return;
        }
        destroyAdHelper();
    }

    public final void setAllListClickCallback(Function0<Unit> callback) {
        Intrinsics.h(callback, "callback");
        this.showAllCallback = callback;
    }

    public final void setItemClickCallback(Function1<? super DownloadBean, Unit> callback) {
        Intrinsics.h(callback, "callback");
        this.itemClickCallback = callback;
    }

    public final void updateDownloadBean(DownloadBean downloadBean) {
        this.mDownloadBean = downloadBean;
    }
}
