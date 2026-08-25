package com.transsion.moviedetail.staff;

import android.graphics.Bitmap;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.c0;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.gyf.immersionbar.ImmersionBar;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.widget.R;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetail.R$mipmap;
import com.transsion.moviedetail.p001enum.SeenStatus;
import com.transsion.moviedetail.staff.bean.MovieStaffList;
import com.transsion.moviedetail.staff.bean.MovieStaffSubject;
import com.transsion.moviedetail.staff.bean.MovieStaffSubjectList;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.moviedetailapi.bean.StaffType;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.ninegridview.ImageInfo;
import com.transsion.ninegridview.R$string;
import com.transsion.ninegridview.helper.FileHelper;
import com.transsion.ninegridview.preview.ImagePreviewActivity;
import com.transsion.postdetail.bean.Pager;
import com.transsion.share.bean.PostType;
import com.transsion.share.share.ShareDialogFragment;
import com.transsion.share.share.a;
import com.transsion.usercenterapi.ReportType;
import com.transsnet.downloader.DownloadManagerApi;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import ni.f;
import wf.a;
import zg.c;

@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u0019\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0014\u0010\u0004J\u0017\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001a\u0010\u0004J\u0017\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0005H\u0002¢\u0006\u0004\b!\u0010\u0004J\u000f\u0010\"\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\"\u0010\u0004J\u000f\u0010#\u001a\u00020\u0005H\u0002¢\u0006\u0004\b#\u0010\u0004J+\u0010*\u001a\u00020\u00052\u0006\u0010%\u001a\u00020$2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(0&H\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020$H\u0002¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0005H\u0002¢\u0006\u0004\b.\u0010\u0004J\u000f\u0010/\u001a\u00020\u0005H\u0002¢\u0006\u0004\b/\u0010\u0004J\u0019\u00101\u001a\u00020\u00052\b\u00100\u001a\u0004\u0018\u00010$H\u0002¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0002H\u0016¢\u0006\u0004\b3\u00104J\u0019\u00105\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b5\u0010\nJ\u000f\u00106\u001a\u00020\u0005H\u0014¢\u0006\u0004\b6\u0010\u0004J\u000f\u00107\u001a\u00020\u0015H\u0016¢\u0006\u0004\b7\u0010 J\u000f\u00108\u001a\u00020\u0015H\u0016¢\u0006\u0004\b8\u0010 J\u0011\u0010:\u001a\u0004\u0018\u000109H\u0016¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u0005H\u0016¢\u0006\u0004\b<\u0010\u0004J\u001f\u0010A\u001a\u00020\u00052\u0006\u0010>\u001a\u00020=2\u0006\u0010@\u001a\u00020?H\u0016¢\u0006\u0004\bA\u0010BJ\u0017\u0010D\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u0007H\u0014¢\u0006\u0004\bD\u0010\nJ\u000f\u0010E\u001a\u00020\u0005H\u0016¢\u0006\u0004\bE\u0010\u0004J\u000f\u0010F\u001a\u00020\u0005H\u0016¢\u0006\u0004\bF\u0010\u0004R\u0018\u0010I\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u001b\u0010O\u001a\u00020J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010V\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010Y\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010\\\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010`\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010d\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010h\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010k\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010m\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010jR\u0016\u0010o\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010jR\u0018\u0010s\u001a\u0004\u0018\u00010p8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010rR*\u0010x\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u001b0tj\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b`u8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010w¨\u0006y"}, d2 = {"Lcom/transsion/moviedetail/staff/MovieStaffActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Llm/c;", "<init>", "()V", BuildConfig.FLAVOR, "initData", "Landroid/os/Bundle;", "savedInstanceState", "N0", "(Landroid/os/Bundle;)V", "Lcom/transsion/moviedetail/staff/bean/MovieStaffSubjectList;", "it", "y0", "(Lcom/transsion/moviedetail/staff/bean/MovieStaffSubjectList;)V", "u0", "Lcom/transsion/moviedetailapi/bean/Staff;", "info", "Y0", "(Lcom/transsion/moviedetailapi/bean/Staff;)V", "z0", BuildConfig.FLAVOR, "isExpanded", "V0", "(Z)V", "F0", "I0", BuildConfig.FLAVOR, "module", "U0", "(Ljava/lang/String;)V", "S0", "()Z", "d1", "W0", "t0", BuildConfig.FLAVOR, "position", "Lkotlin/Pair;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "data", "T0", "(ILkotlin/Pair;)V", "w0", "()I", "b1", "c1", "itemCount", "X0", "(Ljava/lang/Integer;)V", "x0", "()Llm/c;", "onCreate", "onDestroy", "isTranslucent", "isStatusDark", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "onDisconnected", "Landroid/net/Network;", "network", "Landroid/net/NetworkCapabilities;", "networkCapabilities", "onConnected", "(Landroid/net/Network;Landroid/net/NetworkCapabilities;)V", "outState", "onSaveInstanceState", "onPause", "onResume", "a", "Ljava/lang/String;", "id", "Lcom/transsion/moviedetail/staff/y;", "b", "Lkotlin/Lazy;", "v0", "()Lcom/transsion/moviedetail/staff/y;", "mMovieStaffViewModel", "Lcom/transsion/moviedetail/staff/s;", "c", "Lcom/transsion/moviedetail/staff/s;", "mMovieStaffAdapter", "d", "Lcom/transsion/moviedetailapi/bean/Staff;", "staff", "e", "Ljava/lang/Integer;", "staffType", "f", "I", "showCount", "Lcom/transsion/moviedetail/staff/w;", "g", "Lcom/transsion/moviedetail/staff/w;", "mMovieStaffSubRecyclerVIewScrollListener", "Lcom/transsion/moviedetail/staff/v;", "h", "Lcom/transsion/moviedetail/staff/v;", "mMovieStaffScrollListener", "Lqm/a;", "i", "Lqm/a;", "mMovieStaffItemMore", "j", "Z", "mIsLoadFinish", "k", "dealWith80", "l", "dealWithElse", "Lcom/transsion/share/share/ShareDialogFragment;", "m", "Lcom/transsion/share/share/ShareDialogFragment;", "mShareDialog", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "n", "Ljava/util/HashSet;", "subjectIdSet", "MovieDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class MovieStaffActivity extends BaseActivity<lm.c> {

    /* renamed from: a, reason: from kotlin metadata */
    public String id;

    /* renamed from: b, reason: from kotlin metadata */
    private final Lazy mMovieStaffViewModel;

    /* renamed from: c, reason: from kotlin metadata */
    private s mMovieStaffAdapter;

    /* renamed from: d, reason: from kotlin metadata */
    private Staff staff;

    /* renamed from: e, reason: from kotlin metadata */
    private Integer staffType;

    /* renamed from: g, reason: from kotlin metadata */
    private w mMovieStaffSubRecyclerVIewScrollListener;

    /* renamed from: h, reason: from kotlin metadata */
    private v mMovieStaffScrollListener;

    /* renamed from: i, reason: from kotlin metadata */
    private qm.a mMovieStaffItemMore;

    /* renamed from: j, reason: from kotlin metadata */
    private boolean mIsLoadFinish;

    /* renamed from: k, reason: from kotlin metadata */
    private boolean dealWith80;

    /* renamed from: l, reason: from kotlin metadata */
    private boolean dealWithElse;

    /* renamed from: m, reason: from kotlin metadata */
    private ShareDialogFragment mShareDialog;

    /* renamed from: f, reason: from kotlin metadata */
    private int showCount = 9;

    /* renamed from: n, reason: from kotlin metadata */
    private HashSet subjectIdSet = new HashSet();

    public static final class a extends GridLayoutManager.c {
        final /* synthetic */ int f;
        final /* synthetic */ int g;
        final /* synthetic */ int h;
        final /* synthetic */ int i;

        a(int i, int i2, int i3, int i4) {
            this.f = i;
            this.g = i2;
            this.h = i3;
            this.i = i4;
        }

        public int f(int i) {
            if (i < 0) {
                return this.i;
            }
            BaseQuickAdapter baseQuickAdapter = MovieStaffActivity.this.mMovieStaffAdapter;
            if (baseQuickAdapter == null) {
                Intrinsics.y("mMovieStaffAdapter");
                baseQuickAdapter = null;
            }
            if (!(baseQuickAdapter.getItem(i) instanceof Subject)) {
                return this.i;
            }
            int i2 = this.f;
            int i3 = i % i2;
            return (i3 == 0 || i3 == i2 + (-1)) ? this.g + this.h : this.g;
        }
    }

    static final class b implements c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        b(Function1 function1) {
            Intrinsics.h(function1, "function");
            this.a = function1;
        }

        public final Function a() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof c0) && (obj instanceof FunctionAdapter)) {
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

    public static final class c implements com.transsion.share.share.a {
        c() {
        }

        @Override // com.transsion.share.share.a
        public void a(String str, PostType postType) {
            Intrinsics.h(str, "id");
        }

        @Override // com.transsion.share.share.a
        public void b(String str) {
            a.C0056a.b(this, str);
        }

        @Override // com.transsion.share.share.a
        public void c(String str, String str2, String str3, String str4) {
            Intrinsics.h(str, "url");
            Intrinsics.h(str2, "fileName");
            Intrinsics.h(str3, "fileSize");
            Intrinsics.h(str4, "fileImage");
        }

        @Override // com.transsion.share.share.a
        public void d(String str) {
            Intrinsics.h(str, "id");
        }

        @Override // com.transsion.share.share.a
        public void e(String str) {
            a.C0056a.c(this, str);
        }
    }

    public MovieStaffActivity() {
        final Function0 function0 = null;
        this.mMovieStaffViewModel = new ViewModelLazy(Reflection.b(y.class), new Function0<x0>() { // from class: com.transsion.moviedetail.staff.MovieStaffActivity$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final x0 m61invoke() {
                return this.getViewModelStore();
            }
        }, new Function0<v0.c>() { // from class: com.transsion.moviedetail.staff.MovieStaffActivity$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final v0.c m60invoke() {
                return this.getDefaultViewModelProviderFactory();
            }
        }, new Function0<p1.a>() { // from class: com.transsion.moviedetail.staff.MovieStaffActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final p1.a invoke() {
                p1.a aVar;
                Function0 function02 = function0;
                return (function02 == null || (aVar = (p1.a) function02.invoke()) == null) ? this.getDefaultViewModelCreationExtras() : aVar;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void A0(MovieStaffActivity movieStaffActivity, AppBarLayout appBarLayout, int i) {
        v vVar = movieStaffActivity.mMovieStaffScrollListener;
        if (vVar != null) {
            Intrinsics.e(appBarLayout);
            vVar.d(appBarLayout, i);
        }
        if (Math.abs(i) <= a0.a(260.0f)) {
            if (movieStaffActivity.dealWithElse) {
                return;
            }
            movieStaffActivity.dealWithElse = true;
            movieStaffActivity.dealWith80 = false;
            movieStaffActivity.V0(true);
            lm.c cVar = (lm.c) movieStaffActivity.getMViewBinding();
            ShapeableImageView shapeableImageView = cVar.f;
            Intrinsics.g(shapeableImageView, "ivCoverSmall");
            uf.c.g(shapeableImageView);
            AppCompatTextView appCompatTextView = cVar.r;
            Intrinsics.g(appCompatTextView, "tvTitle");
            uf.c.g(appCompatTextView);
            cVar.g.setSelected(false);
            cVar.m.setBackgroundResource(R.color.transparent);
            cVar.e.setImageResource(R.mipmap.icon_white_back);
            Log.e("zxb_log_download", "initAppBar: setDownloadIcon  333333");
            cVar.h.setImageResource(R$mipmap.movie_share_night);
            ImmersionBar with = ImmersionBar.with(movieStaffActivity);
            with.statusBarDarkFont(false);
            with.init();
            return;
        }
        if (movieStaffActivity.dealWith80) {
            return;
        }
        movieStaffActivity.dealWith80 = true;
        movieStaffActivity.dealWithElse = false;
        movieStaffActivity.V0(false);
        lm.c cVar2 = (lm.c) movieStaffActivity.getMViewBinding();
        ShapeableImageView shapeableImageView2 = cVar2.f;
        Intrinsics.g(shapeableImageView2, "ivCoverSmall");
        uf.c.k(shapeableImageView2);
        AppCompatTextView appCompatTextView2 = cVar2.r;
        Intrinsics.g(appCompatTextView2, "tvTitle");
        uf.c.k(appCompatTextView2);
        cVar2.g.setSelected(true);
        if (ij.y.a.a()) {
            cVar2.m.setBackgroundResource(R.color.gray_0);
            cVar2.e.setImageResource(R.mipmap.icon_white_back);
            AppCompatTextView appCompatTextView3 = cVar2.r;
            appCompatTextView3.setTextColor(androidx.core.content.b.getColor(appCompatTextView3.getContext(), R.color.white));
            Log.e("zxb_log_download", "initAppBar: setDownloadIcon  11111");
            cVar2.h.setImageResource(R$mipmap.movie_share_night);
            ImmersionBar with2 = ImmersionBar.with(movieStaffActivity);
            with2.statusBarDarkFont(false);
            with2.init();
            return;
        }
        cVar2.m.setBackgroundResource(R.color.white);
        cVar2.e.setImageResource(com.transsion.baseui.R.mipmap.movie_detail_icon_black_back);
        AppCompatTextView appCompatTextView4 = cVar2.r;
        appCompatTextView4.setTextColor(androidx.core.content.b.getColor(appCompatTextView4.getContext(), R.color.text_01));
        Log.e("zxb_log_download", "initAppBar: setDownloadIcon   22222");
        cVar2.h.setImageResource(R$mipmap.movie_share_light);
        ImmersionBar with3 = ImmersionBar.with(movieStaffActivity);
        with3.statusBarDarkFont(true);
        with3.init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B0(MovieStaffActivity movieStaffActivity, int i, int i2) {
        w wVar = movieStaffActivity.mMovieStaffSubRecyclerVIewScrollListener;
        if (wVar != null) {
            wVar.d(i, i2);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C0(MovieStaffActivity movieStaffActivity, int i, Pair pair) {
        Intrinsics.h(pair, "data");
        movieStaffActivity.T0(i, pair);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void D0(final MovieStaffActivity movieStaffActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        String staffId;
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "view");
        BaseQuickAdapter baseQuickAdapter2 = movieStaffActivity.mMovieStaffAdapter;
        if (baseQuickAdapter2 == null) {
            Intrinsics.y("mMovieStaffAdapter");
            baseQuickAdapter2 = null;
        }
        Object item = baseQuickAdapter2.getItem(i);
        if (!(item instanceof qm.a)) {
            if (item instanceof Subject) {
                HashMap hashMap = new HashMap();
                hashMap.put("module_name", "subject");
                Subject subject = (Subject) item;
                String subjectId = subject.getSubjectId();
                String str = BuildConfig.FLAVOR;
                if (subjectId == null) {
                    subjectId = BuildConfig.FLAVOR;
                }
                hashMap.put("subject_id", subjectId);
                String ops = subject.getOps();
                if (ops == null) {
                    ops = BuildConfig.FLAVOR;
                }
                hashMap.put("ops", ops);
                Staff staff = movieStaffActivity.staff;
                if (staff != null && (staffId = staff.getStaffId()) != null) {
                    str = staffId;
                }
                hashMap.put("staff_id", str);
                com.transsion.baselib.helper.a.a.i("staff_info", hashMap);
                Integer subjectType = subject.getSubjectType();
                int value = SubjectType.SHORT_TV.getValue();
                if (subjectType != null && subjectType.intValue() == value) {
                    DownloadManagerApi.e0(DownloadManagerApi.j.a(), movieStaffActivity, movieStaffActivity.getPageName(), BuildConfig.FLAVOR, subject.getOps(), "download_subject", false, subject, (String) null, (Boolean) null, 384, (Object) null);
                    return;
                }
                Navigator c2 = TheRouter.c("/movie/detail");
                Integer subjectType2 = subject.getSubjectType();
                Navigator.x(c2.F("subject_type", subjectType2 != null ? subjectType2.intValue() : SubjectType.MOVIE.getValue()).K("id", subject.getSubjectId()).K("ops", subject.getOps()), movieStaffActivity, (mf.c) null, 2, (Object) null);
                return;
            }
            return;
        }
        if (!yg.l.a.e()) {
            com.tn.lib.widget.toast.core.h.a.k(com.transsion.usercenter.R.string.network_fail);
            return;
        }
        if (!movieStaffActivity.mIsLoadFinish) {
            y v0 = movieStaffActivity.v0();
            Staff staff2 = movieStaffActivity.staff;
            v0.q(staff2 != null ? staff2.getStaffId() : null, movieStaffActivity.showCount);
            return;
        }
        qm.a aVar = movieStaffActivity.mMovieStaffItemMore;
        if (aVar != null) {
            BaseQuickAdapter baseQuickAdapter3 = movieStaffActivity.mMovieStaffAdapter;
            if (baseQuickAdapter3 == null) {
                Intrinsics.y("mMovieStaffAdapter");
                baseQuickAdapter3 = null;
            }
            int indexOf = baseQuickAdapter3.getData().indexOf(aVar);
            if (aVar.d()) {
                List b2 = aVar.b();
                if (b2 == null) {
                    b2 = Collections.emptyList();
                }
                aVar.e(aVar.a() + b2.size());
                BaseQuickAdapter baseQuickAdapter4 = movieStaffActivity.mMovieStaffAdapter;
                if (baseQuickAdapter4 == null) {
                    Intrinsics.y("mMovieStaffAdapter");
                    baseQuickAdapter4 = null;
                }
                List data = baseQuickAdapter4.getData();
                Intrinsics.e(b2);
                data.addAll(indexOf, b2);
                RecyclerView.Adapter adapter = movieStaffActivity.mMovieStaffAdapter;
                if (adapter == null) {
                    Intrinsics.y("mMovieStaffAdapter");
                } else {
                    r3 = adapter;
                }
                r3.notifyItemRangeChanged(indexOf, b2.size() + 1);
                ((lm.c) movieStaffActivity.getMViewBinding()).k.postDelayed(new Runnable() { // from class: com.transsion.moviedetail.staff.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        MovieStaffActivity.E0(MovieStaffActivity.this);
                    }
                }, 200L);
                return;
            }
            v vVar = movieStaffActivity.mMovieStaffScrollListener;
            if (vVar != null) {
                vVar.e(movieStaffActivity.showCount, indexOf);
            }
            ArrayList arrayList = new ArrayList();
            BaseQuickAdapter baseQuickAdapter5 = movieStaffActivity.mMovieStaffAdapter;
            if (baseQuickAdapter5 == null) {
                Intrinsics.y("mMovieStaffAdapter");
                baseQuickAdapter5 = null;
            }
            arrayList.addAll(baseQuickAdapter5.getData().subList(0, movieStaffActivity.showCount));
            BaseQuickAdapter baseQuickAdapter6 = movieStaffActivity.mMovieStaffAdapter;
            if (baseQuickAdapter6 == null) {
                Intrinsics.y("mMovieStaffAdapter");
                baseQuickAdapter6 = null;
            }
            List data2 = baseQuickAdapter6.getData();
            BaseQuickAdapter baseQuickAdapter7 = movieStaffActivity.mMovieStaffAdapter;
            if (baseQuickAdapter7 == null) {
                Intrinsics.y("mMovieStaffAdapter");
                baseQuickAdapter7 = null;
            }
            arrayList.addAll(data2.subList(indexOf, baseQuickAdapter7.getData().size()));
            int a2 = aVar.a();
            BaseQuickAdapter baseQuickAdapter8 = movieStaffActivity.mMovieStaffAdapter;
            if (baseQuickAdapter8 == null) {
                Intrinsics.y("mMovieStaffAdapter");
                baseQuickAdapter8 = null;
            }
            aVar.e(a2 - (baseQuickAdapter8.getData().size() - arrayList.size()));
            BaseQuickAdapter baseQuickAdapter9 = movieStaffActivity.mMovieStaffAdapter;
            if (baseQuickAdapter9 == null) {
                Intrinsics.y("mMovieStaffAdapter");
                baseQuickAdapter9 = null;
            }
            aVar.f(CollectionsKt.U0(baseQuickAdapter9.getData().subList(movieStaffActivity.showCount, indexOf)));
            BaseQuickAdapter baseQuickAdapter10 = movieStaffActivity.mMovieStaffAdapter;
            if (baseQuickAdapter10 == null) {
                Intrinsics.y("mMovieStaffAdapter");
                baseQuickAdapter10 = null;
            }
            baseQuickAdapter10.getData().clear();
            BaseQuickAdapter baseQuickAdapter11 = movieStaffActivity.mMovieStaffAdapter;
            if (baseQuickAdapter11 == null) {
                Intrinsics.y("mMovieStaffAdapter");
                baseQuickAdapter11 = null;
            }
            baseQuickAdapter11.getData().addAll(arrayList);
            RecyclerView.Adapter adapter2 = movieStaffActivity.mMovieStaffAdapter;
            if (adapter2 == null) {
                Intrinsics.y("mMovieStaffAdapter");
            } else {
                r3 = adapter2;
            }
            r3.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(MovieStaffActivity movieStaffActivity) {
        v vVar = movieStaffActivity.mMovieStaffScrollListener;
        if (vVar != null) {
            RecyclerView recyclerView = ((lm.c) movieStaffActivity.getMViewBinding()).k;
            Intrinsics.g(recyclerView, "rv");
            vVar.onScrolled(recyclerView, 0, 0);
        }
    }

    private final void F0() {
        ((lm.c) getMViewBinding()).g.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.staff.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MovieStaffActivity.G0(MovieStaffActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(MovieStaffActivity movieStaffActivity, View view) {
        movieStaffActivity.U0("save_picture");
        FileHelper fileHelper = FileHelper.a;
        c.a aVar = zg.c.a;
        AppCompatImageView appCompatImageView = ((lm.c) movieStaffActivity.getMViewBinding()).i;
        Intrinsics.g(appCompatImageView, "ivStaff");
        Bitmap a2 = aVar.a(appCompatImageView);
        Staff staff = movieStaffActivity.staff;
        fileHelper.r(movieStaffActivity, a2, fileHelper.j(staff != null ? staff.getAvatarUrl() : null), new Function2() { // from class: com.transsion.moviedetail.staff.i
            public final Object invoke(Object obj, Object obj2) {
                Unit H0;
                H0 = MovieStaffActivity.H0(((Boolean) obj).booleanValue(), (File) obj2);
                return H0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H0(boolean z, File file) {
        Intrinsics.h(file, "<unused var>");
        if (z) {
            fh.b.a.d(R$string.has_been_saved);
        } else {
            fh.b.a.d(R$string.image_save_success);
        }
        return Unit.a;
    }

    private final void I0() {
        lm.c cVar = (lm.c) getMViewBinding();
        cVar.e.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.staff.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MovieStaffActivity.J0(MovieStaffActivity.this, view);
            }
        });
        cVar.h.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.staff.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MovieStaffActivity.K0(MovieStaffActivity.this, view);
            }
        });
        cVar.j.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.staff.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MovieStaffActivity.L0(MovieStaffActivity.this, view);
            }
        });
        cVar.i.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.staff.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MovieStaffActivity.M0(MovieStaffActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(MovieStaffActivity movieStaffActivity, View view) {
        movieStaffActivity.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(MovieStaffActivity movieStaffActivity, View view) {
        movieStaffActivity.W0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(MovieStaffActivity movieStaffActivity, View view) {
        if (com.transsion.baseui.util.c.a.a(view.getId(), 1000L)) {
            return;
        }
        movieStaffActivity.d1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void M0(MovieStaffActivity movieStaffActivity, View view) {
        Staff staff = movieStaffActivity.staff;
        if (staff != null) {
            movieStaffActivity.U0("preview");
            ImageInfo imageInfo = new ImageInfo();
            imageInfo.bigImageUrl = staff.getAvatarUrl();
            ImagePreviewActivity.INSTANCE.a(movieStaffActivity, 0, CollectionsKt.q(new ImageInfo[]{imageInfo}));
        }
    }

    private final void N0(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            v0().n();
            List list = (List) v0().u().f();
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    List<MovieStaffSubject> items = ((MovieStaffSubjectList) it.next()).getItems();
                    if (items != null) {
                        arrayList.addAll(items);
                    }
                }
                y0(new MovieStaffSubjectList(arrayList, ((MovieStaffSubjectList) list.get(list.size() - 1)).getPager()));
            }
        }
        v0().t().j(this, new b(new Function1() { // from class: com.transsion.moviedetail.staff.l
            public final Object invoke(Object obj) {
                Unit O0;
                O0 = MovieStaffActivity.O0(MovieStaffActivity.this, (Staff) obj);
                return O0;
            }
        }));
        v0().v().j(this, new b(new Function1() { // from class: com.transsion.moviedetail.staff.m
            public final Object invoke(Object obj) {
                Unit P0;
                P0 = MovieStaffActivity.P0(MovieStaffActivity.this, (MovieStaffSubjectList) obj);
                return P0;
            }
        }));
        v0().w().j(this, new b(new Function1() { // from class: com.transsion.moviedetail.staff.n
            public final Object invoke(Object obj) {
                Unit Q0;
                Q0 = MovieStaffActivity.Q0(MovieStaffActivity.this, (Integer) obj);
                return Q0;
            }
        }));
        v0().s().j(this, new b(new Function1() { // from class: com.transsion.moviedetail.staff.o
            public final Object invoke(Object obj) {
                Unit R0;
                R0 = MovieStaffActivity.R0(MovieStaffActivity.this, (MovieStaffList) obj);
                return R0;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O0(MovieStaffActivity movieStaffActivity, Staff staff) {
        movieStaffActivity.Y0(staff);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P0(MovieStaffActivity movieStaffActivity, MovieStaffSubjectList movieStaffSubjectList) {
        movieStaffActivity.y0(movieStaffSubjectList);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q0(MovieStaffActivity movieStaffActivity, Integer num) {
        if (num == null) {
            return Unit.a;
        }
        Staff staff = movieStaffActivity.staff;
        if (staff != null) {
            staff.setSeenStatus(num.intValue());
        }
        ((lm.c) movieStaffActivity.getMViewBinding()).j.setImageResource(num.intValue() == 0 ? R$mipmap.movie_staff_icon_want_to_see_white : R$mipmap.movie_detail_icon_want_to_see_selected);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R0(MovieStaffActivity movieStaffActivity, MovieStaffList movieStaffList) {
        if (movieStaffList != null) {
            List<Staff> items = movieStaffList.getItems();
            if (items != null && !items.isEmpty()) {
                BaseQuickAdapter baseQuickAdapter = movieStaffActivity.mMovieStaffAdapter;
                BaseQuickAdapter baseQuickAdapter2 = null;
                if (baseQuickAdapter == null) {
                    Intrinsics.y("mMovieStaffAdapter");
                    baseQuickAdapter = null;
                }
                List data = baseQuickAdapter.getData();
                w wVar = movieStaffActivity.mMovieStaffSubRecyclerVIewScrollListener;
                if (wVar != null) {
                    wVar.e(movieStaffList.getItems());
                }
                if (data.isEmpty() || !(data.get(data.size() - 1) instanceof MovieStaffList)) {
                    BaseQuickAdapter baseQuickAdapter3 = movieStaffActivity.mMovieStaffAdapter;
                    if (baseQuickAdapter3 == null) {
                        Intrinsics.y("mMovieStaffAdapter");
                    } else {
                        baseQuickAdapter2 = baseQuickAdapter3;
                    }
                    baseQuickAdapter2.p(movieStaffList);
                }
            }
            movieStaffActivity.t0();
        }
        return Unit.a;
    }

    private final boolean S0() {
        Staff staff = this.staff;
        return staff != null && staff.getSeenStatus() == SeenStatus.WANT_TO_SEE.ordinal();
    }

    private final void T0(int position, Pair data) {
        w wVar;
        String f;
        Object first = data.getFirst();
        long longValue = ((Number) data.getSecond()).longValue();
        a.a.f(wf.a.a, "staff_info", "reportBrowseEvent  position:" + position + "  duration:" + longValue, false, 4, (Object) null);
        if (first instanceof MovieStaffSubject) {
            MovieStaffSubject movieStaffSubject = (MovieStaffSubject) first;
            if (this.subjectIdSet.add(movieStaffSubject.getSubjectId())) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("item_type", "subject");
                String subjectId = movieStaffSubject.getSubjectId();
                String str = BuildConfig.FLAVOR;
                if (subjectId == null) {
                    subjectId = BuildConfig.FLAVOR;
                }
                linkedHashMap.put("subject_id", subjectId);
                String ops = movieStaffSubject.getOps();
                if (ops == null) {
                    ops = BuildConfig.FLAVOR;
                }
                linkedHashMap.put("ops", ops);
                Boolean hasResource = movieStaffSubject.getHasResource();
                linkedHashMap.put("has_resource", String.valueOf(hasResource != null ? hasResource.booleanValue() : false));
                linkedHashMap.put("position", String.valueOf(position));
                linkedHashMap.put("browse_duration", String.valueOf(longValue));
                com.transsion.baselib.helper.a aVar = com.transsion.baselib.helper.a.a;
                qi.b logViewConfig = getLogViewConfig();
                if (logViewConfig != null && (f = logViewConfig.f()) != null) {
                    str = f;
                }
                aVar.e(str, linkedHashMap);
                return;
            }
            return;
        }
        if (!(first instanceof MovieStaffList) || (wVar = this.mMovieStaffSubRecyclerVIewScrollListener) == null) {
            return;
        }
        int a2 = wVar.a();
        int b2 = wVar.b();
        if (a2 < 0 || b2 < 0 || b2 < a2 || a2 > b2) {
            return;
        }
        while (true) {
            wVar.c(a2, longValue);
            if (a2 == b2) {
                return;
            } else {
                a2++;
            }
        }
    }

    private final void U0(String module) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", module);
        Staff staff = this.staff;
        if (staff == null || (str = staff.getStaffId()) == null) {
            str = BuildConfig.FLAVOR;
        }
        hashMap.put("staff_id", str);
        com.transsion.baselib.helper.a.a.i("staff_info", hashMap);
    }

    private final void V0(boolean isExpanded) {
        if (!isExpanded) {
            ((lm.c) getMViewBinding()).m.getLayoutParams().height = a0.a(44.0f) + com.blankj.utilcode.util.d.c();
            ((lm.c) getMViewBinding()).m.setPadding(0, com.blankj.utilcode.util.d.c(), 0, 0);
            CollapsingToolbarLayout.c layoutParams = ((lm.c) getMViewBinding()).m.getLayoutParams();
            if (layoutParams instanceof CollapsingToolbarLayout.c) {
                ((FrameLayout.LayoutParams) layoutParams).topMargin = 0;
                return;
            }
            return;
        }
        ((lm.c) getMViewBinding()).m.getLayoutParams().height = a0.a(44.0f);
        ((lm.c) getMViewBinding()).m.setPadding(0, 0, 0, 0);
        CollapsingToolbarLayout.c layoutParams2 = ((lm.c) getMViewBinding()).m.getLayoutParams();
        if (layoutParams2 instanceof CollapsingToolbarLayout.c) {
            ((FrameLayout.LayoutParams) layoutParams2).topMargin = com.blankj.utilcode.util.d.c();
        }
    }

    private final void W0() {
        String str;
        ShareDialogFragment shareDialogFragment;
        ShareDialogFragment a2;
        if (this.staff == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "share");
        Staff staff = this.staff;
        if (staff == null || (str = staff.getStaffId()) == null) {
            str = BuildConfig.FLAVOR;
        }
        hashMap.put("staff_id", str);
        com.transsion.baselib.helper.a.a.i("staff_info", hashMap);
        if (this.mShareDialog == null) {
            ShareDialogFragment.Companion companion = ShareDialogFragment.INSTANCE;
            PostType postType = PostType.STAFF_TYPE;
            Staff staff2 = this.staff;
            String staffId = staff2 != null ? staff2.getStaffId() : null;
            String value = ReportType.STAFF.getValue();
            Staff staff3 = this.staff;
            String name = staff3 != null ? staff3.getName() : null;
            Staff staff4 = this.staff;
            a2 = companion.a(postType, staffId, BuildConfig.FLAVOR, value, (r29 & 16) != 0 ? BuildConfig.FLAVOR : name, (r29 & 32) != 0 ? BuildConfig.FLAVOR : staff4 != null ? staff4.getDescription() : null, (r29 & 64) != 0 ? false : false, (r29 & 128) != 0 ? false : false, (r29 & 256) != 0 ? false : false, "staff_info", (r29 & 1024) != 0 ? BuildConfig.FLAVOR : null, (r29 & 2048) != 0 ? BuildConfig.FLAVOR : null);
            this.mShareDialog = a2;
            if (a2 != null) {
                a2.G0(new c());
            }
        }
        try {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            supportFragmentManager.g0();
            ShareDialogFragment shareDialogFragment2 = this.mShareDialog;
            if ((shareDialogFragment2 == null || !shareDialogFragment2.isAdded()) && supportFragmentManager.k0("share") == null && (shareDialogFragment = this.mShareDialog) != null) {
                shareDialogFragment.show(supportFragmentManager, "share");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void X0(Integer itemCount) {
        TextView textView = ((lm.c) getMViewBinding()).o;
        Integer num = this.staffType;
        textView.setText(getString((num != null && num.intValue() == 6) ? com.transsion.moviedetail.R$string.staff_music_title : com.transsion.moviedetail.R$string.movie_staff_filmography, Integer.valueOf(itemCount != null ? itemCount.intValue() : 0)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void Y0(Staff info) {
        if (info == null) {
            return;
        }
        t0();
        this.staff = info;
        c1();
        ((lm.c) getMViewBinding()).q.setText(info.getName());
        ((lm.c) getMViewBinding()).r.setText(info.getName());
        List<StaffType> staffTypes = info.getStaffTypes();
        String str = BuildConfig.FLAVOR;
        if (staffTypes != null) {
            for (StaffType staffType : staffTypes) {
                if (str.length() > 0) {
                    str = ((Object) str) + "/";
                }
                str = ((Object) str) + staffType.getName();
            }
        }
        ViewGroup.LayoutParams layoutParams = ((lm.c) getMViewBinding()).o.getLayoutParams();
        Intrinsics.f(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        ((lm.c) getMViewBinding()).p.setText(str);
        String description = info.getDescription();
        if (description == null || description.length() == 0) {
            ConstraintLayout constraintLayout = ((lm.c) getMViewBinding()).d;
            Intrinsics.g(constraintLayout, "infoExtendView");
            uf.c.g(constraintLayout);
            ((lm.c) getMViewBinding()).o.setPadding(((lm.c) getMViewBinding()).o.getPaddingLeft(), 0, ((lm.c) getMViewBinding()).o.getPaddingRight(), ((lm.c) getMViewBinding()).o.getPaddingBottom());
        } else {
            ((lm.c) getMViewBinding()).d.showData(info.getDescription());
            ConstraintLayout constraintLayout2 = ((lm.c) getMViewBinding()).d;
            Intrinsics.g(constraintLayout2, "infoExtendView");
            uf.c.k(constraintLayout2);
            layoutParams2.topMargin = 0;
        }
        String avatarUrl = info.getAvatarUrl();
        if (((lm.c) getMViewBinding()).i.getTag() == null || !Intrinsics.c(((lm.c) getMViewBinding()).i.getTag(), avatarUrl)) {
            ((lm.c) getMViewBinding()).i.setTag(avatarUrl);
            if (avatarUrl == null || avatarUrl.length() == 0) {
                AppCompatImageView appCompatImageView = ((lm.c) getMViewBinding()).i;
                ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER_INSIDE;
                appCompatImageView.setScaleType(scaleType);
                ((lm.c) getMViewBinding()).i.setImageResource(R$mipmap.movie_staff_empty);
                ((lm.c) getMViewBinding()).f.setScaleType(scaleType);
                ((lm.c) getMViewBinding()).f.setImageResource(R$mipmap.movie_staff_empty);
            } else {
                AppCompatImageView appCompatImageView2 = ((lm.c) getMViewBinding()).i;
                ImageView.ScaleType scaleType2 = ImageView.ScaleType.CENTER_CROP;
                appCompatImageView2.setScaleType(scaleType2);
                ((lm.c) getMViewBinding()).f.setScaleType(scaleType2);
                int e = com.blankj.utilcode.util.y.e();
                f.a aVar = ni.f.a;
                f.b b2 = aVar.m(this).g(avatarUrl).m(e).c((e * 480) / 360).b(new Function3() { // from class: com.transsion.moviedetail.staff.f
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit Z0;
                        Z0 = MovieStaffActivity.Z0(MovieStaffActivity.this, ((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), ((Long) obj3).longValue());
                        return Z0;
                    }
                });
                AppCompatImageView appCompatImageView3 = ((lm.c) getMViewBinding()).i;
                Intrinsics.g(appCompatImageView3, "ivStaff");
                b2.d(appCompatImageView3);
                f.b b3 = aVar.m(this).g(avatarUrl).m(com.blankj.utilcode.util.i.e(24.0f)).c(com.blankj.utilcode.util.i.e(32.0f)).b(new Function3() { // from class: com.transsion.moviedetail.staff.g
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit a1;
                        a1 = MovieStaffActivity.a1(MovieStaffActivity.this, ((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), ((Long) obj3).longValue());
                        return a1;
                    }
                });
                ShapeableImageView shapeableImageView = ((lm.c) getMViewBinding()).f;
                Intrinsics.g(shapeableImageView, "ivCoverSmall");
                b3.d(shapeableImageView);
            }
        }
        ((lm.c) getMViewBinding()).j.setImageResource(info.getSeenStatus() == 0 ? R$mipmap.movie_staff_icon_want_to_see_white : R$mipmap.movie_detail_icon_want_to_see_selected);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z0(MovieStaffActivity movieStaffActivity, boolean z, boolean z2, long j) {
        if (!z) {
            ((lm.c) movieStaffActivity.getMViewBinding()).i.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ((lm.c) movieStaffActivity.getMViewBinding()).i.setImageResource(R$mipmap.movie_staff_empty);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a1(MovieStaffActivity movieStaffActivity, boolean z, boolean z2, long j) {
        if (!z) {
            ((lm.c) movieStaffActivity.getMViewBinding()).f.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ((lm.c) movieStaffActivity.getMViewBinding()).f.setImageResource(R$mipmap.movie_staff_empty);
        }
        return Unit.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
    
        if (r0.intValue() == 6) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void b1() {
        Integer num = this.staffType;
        int i = num != null ? 6 : 9;
        this.showCount = i;
    }

    private final void c1() {
        Staff staff;
        Integer staffType;
        StaffType staffType2;
        if (this.staffType == null && (staff = this.staff) != null) {
            if (staff.getStaffType() == null) {
                List staffTypes = staff.getStaffTypes();
                staffType = (staffTypes == null || (staffType2 = (StaffType) CollectionsKt.v0(staffTypes)) == null) ? null : Integer.valueOf(staffType2.getId());
            } else {
                staffType = staff.getStaffType();
            }
            this.staffType = staffType;
            b1();
        }
    }

    private final void d1() {
        String staffId;
        String staffId2;
        boolean S0 = S0();
        String str = BuildConfig.FLAVOR;
        if (S0) {
            y v0 = v0();
            Staff staff = this.staff;
            v0.y(staff != null ? staff.getStaffId() : null, 0);
            HashMap hashMap = new HashMap();
            hashMap.put("module_name", "want_to_see_cancel");
            Staff staff2 = this.staff;
            if (staff2 != null && (staffId2 = staff2.getStaffId()) != null) {
                str = staffId2;
            }
            hashMap.put("staff_id", str);
            com.transsion.baselib.helper.a.a.i("staff_info", hashMap);
            return;
        }
        y v02 = v0();
        Staff staff3 = this.staff;
        v02.y(staff3 != null ? staff3.getStaffId() : null, 1);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("module_name", "want_to_see");
        Staff staff4 = this.staff;
        if (staff4 != null && (staffId = staff4.getStaffId()) != null) {
            str = staffId;
        }
        hashMap2.put("staff_id", str);
        com.transsion.baselib.helper.a.a.i("staff_info", hashMap2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initData() {
        Staff staff = this.staff;
        RecyclerView.Adapter adapter = null;
        this.mMovieStaffAdapter = new s(staff != null ? staff.getStaffId() : null, this.staffType, new Function2() { // from class: com.transsion.moviedetail.staff.b
            public final Object invoke(Object obj, Object obj2) {
                Unit B0;
                B0 = MovieStaffActivity.B0(MovieStaffActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return B0;
            }
        });
        this.mMovieStaffSubRecyclerVIewScrollListener = new w();
        s sVar = this.mMovieStaffAdapter;
        if (sVar == null) {
            Intrinsics.y("mMovieStaffAdapter");
            sVar = null;
        }
        v vVar = new v(sVar, new Function2() { // from class: com.transsion.moviedetail.staff.j
            public final Object invoke(Object obj, Object obj2) {
                Unit C0;
                C0 = MovieStaffActivity.C0(MovieStaffActivity.this, ((Integer) obj).intValue(), (Pair) obj2);
                return C0;
            }
        });
        ((lm.c) getMViewBinding()).k.addOnScrollListener(vVar);
        this.mMovieStaffScrollListener = vVar;
        BaseQuickAdapter baseQuickAdapter = this.mMovieStaffAdapter;
        if (baseQuickAdapter == null) {
            Intrinsics.y("mMovieStaffAdapter");
            baseQuickAdapter = null;
        }
        baseQuickAdapter.M0(false);
        BaseQuickAdapter baseQuickAdapter2 = this.mMovieStaffAdapter;
        if (baseQuickAdapter2 == null) {
            Intrinsics.y("mMovieStaffAdapter");
            baseQuickAdapter2 = null;
        }
        baseQuickAdapter2.w1(new r6.d() { // from class: com.transsion.moviedetail.staff.k
            public final void a(BaseQuickAdapter baseQuickAdapter3, View view, int i) {
                MovieStaffActivity.D0(MovieStaffActivity.this, baseQuickAdapter3, view, i);
            }
        });
        ((lm.c) getMViewBinding()).k.setAnimation(null);
        RecyclerView recyclerView = ((lm.c) getMViewBinding()).k;
        RecyclerView.Adapter adapter2 = this.mMovieStaffAdapter;
        if (adapter2 == null) {
            Intrinsics.y("mMovieStaffAdapter");
        } else {
            adapter = adapter2;
        }
        recyclerView.setAdapter(adapter);
        int e = com.blankj.utilcode.util.y.e();
        int e2 = com.blankj.utilcode.util.i.e(8.0f);
        int w0 = w0() + (com.transsion.baseui.util.b.a(this) ? 1 : 0);
        ((lm.c) getMViewBinding()).k.addItemDecoration(new u(com.blankj.utilcode.util.i.e(12.0f), com.blankj.utilcode.util.i.e(4.0f), 0, com.blankj.utilcode.util.i.e(12.0f), w0));
        RecyclerView recyclerView2 = ((lm.c) getMViewBinding()).k;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, e, 1, false);
        gridLayoutManager.d0(new a(w0, (e - (e2 * 2)) / w0, e2, e));
        recyclerView2.setLayoutManager(gridLayoutManager);
        X0(0);
        Y0(this.staff);
    }

    private final void t0() {
        qi.b logViewConfig;
        qi.b logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 == null || !logViewConfig2.i()) {
            Staff staff = this.staff;
            String mySeeTime = staff != null ? staff.getMySeeTime() : null;
            if (mySeeTime == null || mySeeTime.length() == 0 || v0().s().f() == null || v0().v().f() == null || (logViewConfig = getLogViewConfig()) == null) {
                return;
            }
            logViewConfig.k(true);
        }
    }

    private final void u0() {
        if (v0().t().f() == null) {
            y v0 = v0();
            Staff staff = this.staff;
            v0.p(staff != null ? staff.getStaffId() : null);
        }
        if (v0().u().f() == null) {
            y v02 = v0();
            Staff staff2 = this.staff;
            v02.q(staff2 != null ? staff2.getStaffId() : null, this.showCount);
        }
        if (v0().s().f() == null) {
            y v03 = v0();
            Staff staff3 = this.staff;
            v03.o(staff3 != null ? staff3.getStaffId() : null);
        }
    }

    private final y v0() {
        return (y) this.mMovieStaffViewModel.getValue();
    }

    private final int w0() {
        Integer num = this.staffType;
        return (num != null && num.intValue() == 6) ? 2 : 3;
    }

    private final void y0(MovieStaffSubjectList it) {
        Integer totalCount;
        if (it == null) {
            return;
        }
        t0();
        Pager pager = it.getPager();
        this.mIsLoadFinish = pager != null ? Intrinsics.c(pager.getHasMore(), Boolean.FALSE) : false;
        List<MovieStaffSubject> items = it.getItems();
        Pager pager2 = it.getPager();
        BaseQuickAdapter baseQuickAdapter = null;
        X0(pager2 != null ? pager2.getTotalCount() : null);
        List<MovieStaffSubject> list = items;
        if (list == null || list.isEmpty()) {
            return;
        }
        qm.a aVar = this.mMovieStaffItemMore;
        if (aVar == null) {
            Pager pager3 = it.getPager();
            aVar = new qm.a((pager3 == null || (totalCount = pager3.getTotalCount()) == null) ? 0 : totalCount.intValue(), 0, 2, null);
        }
        this.mMovieStaffItemMore = aVar;
        BaseQuickAdapter baseQuickAdapter2 = this.mMovieStaffAdapter;
        if (baseQuickAdapter2 == null) {
            Intrinsics.y("mMovieStaffAdapter");
            baseQuickAdapter2 = null;
        }
        int indexOf = baseQuickAdapter2.getData().indexOf(aVar);
        if (indexOf < 0) {
            BaseQuickAdapter baseQuickAdapter3 = this.mMovieStaffAdapter;
            if (baseQuickAdapter3 == null) {
                Intrinsics.y("mMovieStaffAdapter");
                baseQuickAdapter3 = null;
            }
            List U0 = CollectionsKt.U0(baseQuickAdapter3.getData());
            Pager pager4 = it.getPager();
            if ((pager4 != null ? Intrinsics.c(pager4.getHasMore(), Boolean.TRUE) : false) || items.size() >= this.showCount) {
                int h = RangesKt.h(this.showCount, items.size());
                U0.addAll(0, items.subList(0, h));
                U0.add(h, aVar);
                aVar.e(h);
            } else {
                U0.addAll(0, items);
            }
            BaseQuickAdapter baseQuickAdapter4 = this.mMovieStaffAdapter;
            if (baseQuickAdapter4 == null) {
                Intrinsics.y("mMovieStaffAdapter");
            } else {
                baseQuickAdapter = baseQuickAdapter4;
            }
            baseQuickAdapter.q1(U0);
            return;
        }
        aVar.e(aVar.a() + items.size());
        Pager pager5 = it.getPager();
        if (pager5 != null ? Intrinsics.c(pager5.getHasMore(), Boolean.TRUE) : false) {
            BaseQuickAdapter baseQuickAdapter5 = this.mMovieStaffAdapter;
            if (baseQuickAdapter5 == null) {
                Intrinsics.y("mMovieStaffAdapter");
            } else {
                baseQuickAdapter = baseQuickAdapter5;
            }
            baseQuickAdapter.o(indexOf, items);
            return;
        }
        BaseQuickAdapter baseQuickAdapter6 = this.mMovieStaffAdapter;
        if (baseQuickAdapter6 == null) {
            Intrinsics.y("mMovieStaffAdapter");
            baseQuickAdapter6 = null;
        }
        baseQuickAdapter6.getData().addAll(indexOf, items);
        BaseQuickAdapter baseQuickAdapter7 = this.mMovieStaffAdapter;
        if (baseQuickAdapter7 == null) {
            Intrinsics.y("mMovieStaffAdapter");
        } else {
            baseQuickAdapter = baseQuickAdapter7;
        }
        baseQuickAdapter.notifyItemRangeChanged(indexOf, items.size() + 1);
    }

    private final void z0() {
        ((lm.c) getMViewBinding()).b.addOnOffsetChangedListener(new AppBarLayout.g() { // from class: com.transsion.moviedetail.staff.q
            public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                MovieStaffActivity.A0(MovieStaffActivity.this, appBarLayout, i);
            }
        });
    }

    public boolean isStatusDark() {
        return false;
    }

    public boolean isTranslucent() {
        return true;
    }

    public qi.b newLogViewConfig() {
        return new qi.b("staff_info", false, 2, null);
    }

    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.h(network, "network");
        Intrinsics.h(networkCapabilities, "networkCapabilities");
        super/*com.transsion.baseui.activity.BaseCommonActivity*/.onConnected(network, networkCapabilities);
        u0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        HashMap g;
        TheRouter.l(this);
        super.onCreate(savedInstanceState);
        com.transsion.baselib.report.k.a.w(3, this);
        Staff serializableExtra = getIntent().getSerializableExtra("staff");
        this.staff = serializableExtra;
        if (serializableExtra == null) {
            Staff staff = new Staff();
            staff.setStaffId(this.id);
            this.staff = staff;
        }
        c1();
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (g = logViewConfig.g()) != null) {
            Staff staff2 = this.staff;
        }
        CollapsingToolbarLayout.c layoutParams = ((lm.c) getMViewBinding()).m.getLayoutParams();
        if (layoutParams instanceof CollapsingToolbarLayout.c) {
            ((FrameLayout.LayoutParams) layoutParams).topMargin = com.blankj.utilcode.util.d.c();
        }
        ((lm.c) getMViewBinding()).h.init(this);
        z0();
        initData();
        N0(savedInstanceState);
        I0();
        F0();
        u0();
    }

    protected void onDestroy() {
        super.onDestroy();
        yg.l.a.m(this);
    }

    public void onDisconnected() {
        super/*com.transsion.baseui.activity.BaseCommonActivity*/.onDisconnected();
    }

    public void onPause() {
        super.onPause();
        v vVar = this.mMovieStaffScrollListener;
        if (vVar != null) {
            vVar.f();
        }
    }

    public void onResume() {
        super.onResume();
        v vVar = this.mMovieStaffScrollListener;
        if (vVar != null) {
            vVar.g();
        }
    }

    protected void onSaveInstanceState(Bundle outState) {
        Intrinsics.h(outState, "outState");
        super/*androidx.activity.ComponentActivity*/.onSaveInstanceState(outState);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public lm.c getViewBinding() {
        lm.c c2 = lm.c.c(getLayoutInflater());
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }
}
