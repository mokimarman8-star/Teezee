package com.transsnet.downloader;

import android.R;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import ck.a;
import com.blankj.utilcode.util.Utils;
import com.therouter.TheRouter;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.shorttv.bean.Cover;
import com.transsion.shorttv.bean.PlayUrl;
import com.transsion.shorttv.bean.ShortTVFavInfo;
import com.transsion.shorttv.bean.ShortTVItem;
import com.transsion.shorttv.bean.SkuInfo;
import com.transsion.shorttv.bean.SubjectDl;
import com.transsion.shorttv.bean.Trailer;
import com.transsnet.downloader.fragment.DownloadReDetectorMainDialog;
import com.transsnet.downloader.fragment.TransferInnerMainFragment;
import com.transsnet.downloader.manager.f;
import com.transsnet.downloader.manager.g;
import com.transsnet.downloader.ugc.dialog.UGCDownloadDialog;
import com.transsnet.downloader.util.DownloadUtil;
import com.transsnet.downloader.view.DownloadingTipsDialogFragment;
import com.transsnet.downloader.viewmodel.DownloadListManager;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.AddToDownloadEvent;
import ep.b;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kg.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import org.mvel2.ast.ASTNode;
import qi.h;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class DownloadManagerApi implements a {
    public static final a j = new a((DefaultConstructorMarker) null);
    private static final Lazy k = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.transsnet.downloader.q
        public final Object invoke() {
            DownloadManagerApi u;
            u = DownloadManagerApi.u();
            return u;
        }
    });
    private DownloadBean e;
    private final Set a = new CopyOnWriteArraySet();
    private final Set b = new CopyOnWriteArraySet();
    private final Set c = new CopyOnWriteArraySet();
    private final Lazy d = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.l
        public final Object invoke() {
            cx.a C0;
            C0 = DownloadManagerApi.C0();
            return C0;
        }
    });
    private final Lazy f = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.m
        public final Object invoke() {
            g c0;
            c0 = DownloadManagerApi.c0();
            return c0;
        }
    });
    private final Lazy g = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.n
        public final Object invoke() {
            ep.a q0;
            q0 = DownloadManagerApi.q0();
            return q0;
        }
    });
    private final Lazy h = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.o
        public final Object invoke() {
            b r0;
            r0 = DownloadManagerApi.r0();
            return r0;
        }
    });
    private final Lazy i = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.p
        public final Object invoke() {
            si.a W;
            W = DownloadManagerApi.W();
            return W;
        }
    });

    public static /* synthetic */ void B0(DownloadManagerApi downloadManagerApi, String str, String str2, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = true;
        }
        boolean z4 = z2;
        if ((i & 16) != 0) {
            z3 = false;
        }
        downloadManagerApi.A0(str, str2, z, z4, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cx.a C0() {
        return (cx.a) c.e.a().h(cx.a.class);
    }

    private final void D0(FragmentActivity fragmentActivity, int i, String str, DownloadBean downloadBean, boolean z, String str2) {
        if (((FrameLayout) fragmentActivity.findViewById(R.id.content)) != null) {
            a.a.f(wf.a.a, "downloadAna", "downloadBean.size = " + downloadBean.getSize() + "， formatSize = " + str + ", fileCount = " + i, false, 4, (Object) null);
            if (z) {
                boolean z2 = ((ViewGroup) fragmentActivity.getWindow().getDecorView().findViewById(R.id.content)).getChildAt(0) instanceof ViewGroup;
            } else {
                new Handler(Looper.getMainLooper()).postDelayed(new e(downloadBean, str2, i, fragmentActivity), 300L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(DownloadBean downloadBean, String str, int i, FragmentActivity fragmentActivity) {
        downloadBean.setPageFrom(str);
        DownloadingTipsDialogFragment a = DownloadingTipsDialogFragment.k.a(i);
        a.O0(downloadBean);
        a.k0(fragmentActivity, "DownloadingTipsDialogFragment");
    }

    private final void G(FragmentActivity fragmentActivity, Subject subject, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, int i, boolean z2) {
        Integer type;
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
        String h = h.a.h();
        ResourceDetectors resourceDetector = subject.getResourceDetector();
        if (resourceDetector == null || (type = resourceDetector.getType()) == null || type.intValue() != 1) {
            f.a.a().j(fragmentActivity, subject, new s(str, h, subject, str2, str3, str4, str5, str6, i, z2, supportFragmentManager, this, fragmentActivity));
            return;
        }
        DownloadReDetectorMainDialog a = DownloadReDetectorMainDialog.v.a(str, h, subject, str2, str3, str4, str5, str6, i, z2);
        a.show(supportFragmentManager, "download");
        a.z0(new r(this, fragmentActivity, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(DownloadManagerApi downloadManagerApi, FragmentActivity fragmentActivity, String str, int i, String str2, DownloadBean downloadBean, boolean z) {
        Intrinsics.h(str2, "formatSize");
        Intrinsics.h(downloadBean, "downloadBean");
        downloadManagerApi.D0(fragmentActivity, i, str2, downloadBean, z, str);
        a.a.f(wf.a.a, "downloadAna", "group get success, show anima", false, 4, (Object) null);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(String str, String str2, Subject subject, String str3, String str4, String str5, String str6, String str7, int i, boolean z, FragmentManager fragmentManager, DownloadManagerApi downloadManagerApi, FragmentActivity fragmentActivity) {
        DownloadReDetectorMainDialog a = DownloadReDetectorMainDialog.v.a(str, str2, subject, str3, str4, str5, str6, str7, i, z);
        a.show(fragmentManager, "download_anima");
        a.z0(new g(downloadManagerApi, fragmentActivity, str));
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(DownloadManagerApi downloadManagerApi, FragmentActivity fragmentActivity, String str, int i, String str2, DownloadBean downloadBean, boolean z) {
        Intrinsics.h(str2, "formatSize");
        Intrinsics.h(downloadBean, "bean");
        downloadManagerApi.D0(fragmentActivity, i, str2, downloadBean, z, str);
        return Unit.a;
    }

    public static /* synthetic */ void N(DownloadManagerApi downloadManagerApi, FragmentActivity fragmentActivity, Subject subject, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, int i, boolean z2, int i2, Object obj) {
        downloadManagerApi.L(fragmentActivity, subject, str, (i2 & 8) != 0 ? "" : str2, str3, str4, (i2 & 64) != 0 ? "" : str5, (i2 & ASTNode.ASSIGN) != 0 ? null : str6, (i2 & ASTNode.COLLECTION) != 0 ? null : str7, (i2 & ASTNode.THISREF) != 0 ? false : z, (i2 & 1024) != 0 ? 0 : i, (i2 & ASTNode.BLOCK_IF) != 0 ? true : z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(DownloadManagerApi downloadManagerApi, FragmentActivity fragmentActivity, DownloadBean downloadBean, String str, Ref$ObjectRef ref$ObjectRef, String str2, String str3) {
        downloadManagerApi.X(fragmentActivity, new c(downloadManagerApi, fragmentActivity, downloadBean, str, ref$ObjectRef, str2, str3));
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit R(DownloadManagerApi downloadManagerApi, FragmentActivity fragmentActivity, DownloadBean downloadBean, String str, Ref$ObjectRef ref$ObjectRef, String str2, String str3) {
        downloadManagerApi.i0(fragmentActivity, downloadBean, str, (String) ref$ObjectRef.element, str2, str3);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit S(DownloadManagerApi downloadManagerApi, FragmentActivity fragmentActivity, DownloadBean downloadBean, String str, Ref$ObjectRef ref$ObjectRef, String str2, String str3) {
        downloadManagerApi.i0(fragmentActivity, downloadBean, str, (String) ref$ObjectRef.element, str2, str3);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V(DownloadManagerApi downloadManagerApi, FragmentActivity fragmentActivity, Subject subject, String str, String str2, String str3, String str4, String str5) {
        Z(downloadManagerApi, fragmentActivity, subject, str, str2, str3, str4, str5, null, ASTNode.ASSIGN, null);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final si.a W() {
        AppDatabase.f1 f1Var = AppDatabase.p;
        Application a = Utils.a();
        Intrinsics.g(a, "getApp(...)");
        return f1Var.b(a).n1();
    }

    private final void X(FragmentActivity fragmentActivity, Function0 function0) {
        function0.invoke();
    }

    private final void Y(FragmentActivity fragmentActivity, Subject subject, String str, String str2, String str3, String str4, String str5, String str6) {
        X(fragmentActivity, new i(fragmentActivity, str, str2, subject, str3, str4, str5, str6, this));
    }

    static /* synthetic */ void Z(DownloadManagerApi downloadManagerApi, FragmentActivity fragmentActivity, Subject subject, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        downloadManagerApi.Y(fragmentActivity, subject, str, str2, str3, str4, (i & 64) != 0 ? null : str5, (i & ASTNode.ASSIGN) != 0 ? null : str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a0(FragmentActivity fragmentActivity, String str, String str2, Subject subject, String str3, String str4, String str5, String str6, DownloadManagerApi downloadManagerApi) {
        String h = h.a.h();
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
        DownloadReDetectorMainDialog b = DownloadReDetectorMainDialog.v.b(str, str2, h, subject, str3, str4, str5);
        b.show(supportFragmentManager, "download_anima");
        b.z0(new j(downloadManagerApi, fragmentActivity, str2));
        DownloadListManager.m.a().p(DownloadUtil.a.j(subject, str2, h, str3, "", str6));
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0(DownloadManagerApi downloadManagerApi, FragmentActivity fragmentActivity, String str, int i, String str2, DownloadBean downloadBean, boolean z) {
        Intrinsics.h(str2, "formatSize");
        Intrinsics.h(downloadBean, "downloadBean");
        downloadManagerApi.D0(fragmentActivity, i, str2, downloadBean, z, str);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g c0() {
        return com.transsnet.downloader.manager.p.a.a(Utils.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h0(Function4 function4, DownloadManagerApi downloadManagerApi, FragmentActivity fragmentActivity, String str, int i, String str2, DownloadBean downloadBean, boolean z) {
        Intrinsics.h(str2, "formatSize");
        Intrinsics.h(downloadBean, "downloadBean");
        if (function4 != null) {
            function4.invoke(Integer.valueOf(i), str2, downloadBean, Boolean.valueOf(z));
        } else {
            downloadManagerApi.D0(fragmentActivity, i, str2, downloadBean, z, str);
        }
        return Unit.a;
    }

    private final void i0(FragmentActivity fragmentActivity, DownloadBean downloadBean, String str, String str2, String str3, String str4) {
        com.transsnet.downloader.manager.p.a.a(Utils.a()).r(downloadBean != null ? downloadBean.getResourceId() : null, new f(fragmentActivity, str3, str4, downloadBean, this, str, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j0(FragmentActivity fragmentActivity, String str, String str2, DownloadBean downloadBean, DownloadManagerApi downloadManagerApi, String str3, String str4, DownloadBean downloadBean2) {
        if (downloadBean2 != null) {
            fh.b.a.d(R$string.already_in_downloads);
        } else {
            String h = h.a.h();
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
            DownloadReDetectorMainDialog d = DownloadReDetectorMainDialog.v.d(str, str2);
            d.show(supportFragmentManager, "download_anima");
            d.z0(new h(downloadManagerApi, fragmentActivity, str3));
            if (downloadBean != null) {
                downloadBean.setPageFrom(str3);
                downloadBean.setLastPageFrom(h);
                downloadBean.setOps(str4);
                DownloadListManager.m.a().p(downloadBean);
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k0(DownloadManagerApi downloadManagerApi, FragmentActivity fragmentActivity, String str, int i, String str2, DownloadBean downloadBean, boolean z) {
        Intrinsics.h(str2, "formatSize");
        Intrinsics.h(downloadBean, "downloadBean");
        downloadManagerApi.D0(fragmentActivity, i, str2, downloadBean, z, str);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final si.a m0() {
        return (si.a) this.i.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final g n0() {
        return (g) this.f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ep.a o0() {
        return (ep.a) this.g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b p0() {
        return (b) this.h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ep.a q0() {
        return (ep.a) TheRouter.d(ep.a.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b r0() {
        return (b) TheRouter.d(b.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DownloadManagerApi u() {
        Object d = TheRouter.d(ck.a.class, new Object[0]);
        Intrinsics.f(d, "null cannot be cast to non-null type com.transsnet.downloader.DownloadManagerApi");
        return (DownloadManagerApi) d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x009b, code lost:
    
        if (r1.isCompleted() == true) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u0(android.content.Context r6, java.lang.String r7) {
        /*
            r5 = this;
            com.transsion.baselib.db.download.DownloadBean r0 = r5.e
            if (r0 != 0) goto L5
            return
        L5:
            com.transsnet.downloader.manager.g r0 = r5.n0()
            com.transsion.baselib.db.download.DownloadBean r1 = r5.e
            kotlin.jvm.internal.Intrinsics.e(r1)
            r0.l(r1)
            com.transsnet.downloader.manager.p$a r0 = com.transsnet.downloader.manager.p.a
            android.app.Application r1 = com.blankj.utilcode.util.Utils.a()
            com.transsnet.downloader.manager.g r0 = r0.a(r1)
            com.transsion.baselib.db.download.DownloadBean r1 = r5.e
            kotlin.jvm.internal.Intrinsics.e(r1)
            java.lang.String r0 = r0.h(r1)
            java.lang.String r1 = "/video/detail"
            com.therouter.router.Navigator r1 = com.therouter.TheRouter.c(r1)
            com.transsion.baselib.db.download.DownloadBean r2 = r5.e
            r3 = 0
            if (r2 == 0) goto L34
            java.lang.String r2 = r2.getPath()
            goto L35
        L34:
            r2 = r3
        L35:
            java.lang.String r4 = "extra_local_path"
            com.therouter.router.Navigator r1 = r1.K(r4, r2)
            com.transsion.baselib.db.download.DownloadBean r2 = r5.e
            if (r2 == 0) goto L44
            java.lang.String r2 = r2.getUrl()
            goto L45
        L44:
            r2 = r3
        L45:
            java.lang.String r4 = "extra_url"
            com.therouter.router.Navigator r1 = r1.K(r4, r2)
            java.lang.String r2 = "extra_proxy_url"
            com.therouter.router.Navigator r0 = r1.K(r2, r0)
            com.transsion.baselib.db.download.DownloadBean r1 = r5.e
            if (r1 == 0) goto L5a
            java.lang.String r1 = r1.getResourceId()
            goto L5b
        L5a:
            r1 = r3
        L5b:
            java.lang.String r2 = "extra_resource_id"
            com.therouter.router.Navigator r0 = r0.K(r2, r1)
            com.transsion.baselib.db.download.DownloadBean r1 = r5.e
            if (r1 == 0) goto L6a
            java.lang.String r1 = r1.getSubjectId()
            goto L6b
        L6a:
            r1 = r3
        L6b:
            java.lang.String r2 = "extra_subject_id"
            com.therouter.router.Navigator r0 = r0.K(r2, r1)
            com.transsion.baselib.db.download.DownloadBean r1 = r5.e
            if (r1 == 0) goto L7a
            java.lang.String r1 = r1.getName()
            goto L7b
        L7a:
            r1 = r3
        L7b:
            java.lang.String r2 = "extra_name"
            com.therouter.router.Navigator r0 = r0.K(r2, r1)
            com.transsion.baselib.db.download.DownloadBean r1 = r5.e
            if (r1 == 0) goto L8a
            java.lang.String r1 = r1.getPostId()
            goto L8b
        L8a:
            r1 = r3
        L8b:
            java.lang.String r2 = "extra_post_id"
            com.therouter.router.Navigator r0 = r0.K(r2, r1)
            com.transsion.baselib.db.download.DownloadBean r1 = r5.e
            r2 = 0
            if (r1 == 0) goto L9e
            boolean r1 = r1.isCompleted()
            r4 = 1
            if (r1 != r4) goto L9e
            goto L9f
        L9e:
            r4 = r2
        L9f:
            java.lang.String r1 = "extra_completed"
            com.therouter.router.Navigator r0 = r0.z(r1, r4)
            com.transsion.baselib.db.download.DownloadBean r1 = r5.e
            if (r1 == 0) goto Lad
            boolean r2 = r1.isSeries()
        Lad:
            java.lang.String r1 = "extra_is_series"
            com.therouter.router.Navigator r0 = r0.z(r1, r2)
            java.lang.String r1 = "extra_page_from"
            com.therouter.router.Navigator r7 = r0.K(r1, r7)
            r0 = 2
            com.therouter.router.Navigator.x(r7, r6, r3, r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.DownloadManagerApi.u0(android.content.Context, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v0(Context context) {
        i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new opnAudio.1(this, context, (Continuation) null), 3, (Object) null);
    }

    public static /* synthetic */ boolean x0(DownloadManagerApi downloadManagerApi, String str, String str2, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        return downloadManagerApi.w0(str, str2, z, z2);
    }

    public static /* synthetic */ void z0(DownloadManagerApi downloadManagerApi, String str, Context context, String str2, String str3, int i, Object obj) {
        if ((i & 8) != 0) {
            str3 = null;
        }
        downloadManagerApi.y0(str, context, str2, str3);
    }

    public final void A0(String str, String str2, boolean z, boolean z2, boolean z3) {
        TypeIntrinsics.a(this.a).remove(str2);
        TypeIntrinsics.a(this.b).remove(str);
        if (z2) {
            AddToDownloadEvent addToDownloadEvent = new AddToDownloadEvent(str, str2, false, z);
            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = AddToDownloadEvent.class.getName();
            Intrinsics.g(name, "getName(...)");
            flowEventBus.postEvent(name, addToDownloadEvent, 0L);
        }
        if (z3) {
            i.f((CoroutineContext) null, new removePlayAvailable.1(str, this, z2, str2, z, (Continuation) null), 1, (Object) null);
        }
    }

    public final void K(FragmentActivity fragmentActivity, Subject subject, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z) {
        Intrinsics.h(fragmentActivity, "activity");
        Intrinsics.h(str4, "resource");
        N(this, fragmentActivity, subject, str, str2, str3, str4, str5, str6, str7, z, 0, false, ASTNode.BLOCK_IF, null);
    }

    public final void L(FragmentActivity fragmentActivity, Subject subject, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, int i, boolean z2) {
        String string;
        Intrinsics.h(fragmentActivity, "activity");
        Intrinsics.h(str4, "resource");
        if (subject == null) {
            return;
        }
        com.transsion.baseui.util.c cVar = com.transsion.baseui.util.c.a;
        String subjectId = subject.getSubjectId();
        if (cVar.a(subjectId != null ? subjectId.hashCode() : 9527, 2000L)) {
            return;
        }
        if (str3 == null || str3.length() == 0) {
            Bundle extras = fragmentActivity.getIntent().getExtras();
            string = extras != null ? extras.getString("ops") : null;
        } else {
            string = str3;
        }
        if (yg.l.a.e()) {
            G(fragmentActivity, subject, str, str2, string, str4, str5, str6, str7, z, i, z2);
        } else {
            fh.b.a.d(com.tn.lib.widget.R$string.no_network_toast);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void O(FragmentActivity fragmentActivity, DownloadBean downloadBean, String str, String str2, String str3, Subject subject, String str4) {
        String resourceId;
        Intrinsics.h(fragmentActivity, "activity");
        Intrinsics.h(str3, "resource");
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = str2;
        String str5 = str2;
        if (str5 == null || str5.length() == 0) {
            Bundle extras = fragmentActivity.getIntent().getExtras();
            ref$ObjectRef.element = extras != null ? extras.getString("ops") : 0;
        }
        if (com.transsion.baseui.util.c.a.a((downloadBean == null || (resourceId = downloadBean.getResourceId()) == null) ? 9526 : resourceId.hashCode(), 2000L)) {
            return;
        }
        if (!yg.l.a.e()) {
            fh.b.a.d(com.tn.lib.widget.R$string.no_network_toast);
        } else if (subject != null) {
            f.a.a().j(fragmentActivity, subject, new a(this, fragmentActivity, downloadBean, str, ref$ObjectRef, str3, str4));
        } else {
            X(fragmentActivity, new k(this, fragmentActivity, downloadBean, str, ref$ObjectRef, str3, str4));
        }
    }

    public final void T(String str, String str2, boolean z, int i, boolean z2, boolean z3) {
        if (z3 && str != null) {
            this.c.add(str);
        }
        if (z) {
            if (str2 != null) {
                this.a.add(str2);
                AddToDownloadEvent addToDownloadEvent = new AddToDownloadEvent(null, str2, true, z);
                FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
                String name = AddToDownloadEvent.class.getName();
                Intrinsics.g(name, "getName(...)");
                flowEventBus.postEvent(name, addToDownloadEvent, 0L);
            }
            if (!CollectionsKt.b0(this.b, str) || z2) {
                return;
            }
            return;
        }
        if (str2 != null) {
            this.a.add(str2);
            if (str != null) {
                this.b.add(str);
            }
            if (z2) {
                AddToDownloadEvent addToDownloadEvent2 = new AddToDownloadEvent(str, str2, true, z);
                FlowEventBus flowEventBus2 = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
                String name2 = AddToDownloadEvent.class.getName();
                Intrinsics.g(name2, "getName(...)");
                flowEventBus2.postEvent(name2, addToDownloadEvent2, 0L);
            }
        }
    }

    public final void U(FragmentActivity fragmentActivity, Subject subject, String str, String str2, String str3, String str4, String str5) {
        Bundle extras;
        String subjectId;
        Intrinsics.h(fragmentActivity, "activity");
        Intrinsics.h(str, "linkUrl");
        Intrinsics.h(str4, "resource");
        if (com.transsion.baseui.util.c.a.a((subject == null || (subjectId = subject.getSubjectId()) == null) ? 9528 : subjectId.hashCode(), 2000L)) {
            return;
        }
        if ((str3 == null || str3.length() == 0) && (extras = fragmentActivity.getIntent().getExtras()) != null) {
            extras.getString("ops");
        }
        if (!yg.l.a.e()) {
            fh.b.a.d(com.tn.lib.widget.R$string.no_network_toast);
        } else if (subject != null) {
            f.a.a().j(fragmentActivity, subject, new b(this, fragmentActivity, subject, str, str2, str3, str4, str5));
        } else {
            Z(this, fragmentActivity, subject, str, str2, str3, str4, str5, null, ASTNode.ASSIGN, null);
        }
    }

    @Override // ck.a
    public Fragment a() {
        return TransferInnerMainFragment.v.a();
    }

    public final void d0(FragmentActivity fragmentActivity, String str, String str2, String str3, String str4, boolean z, Subject subject, String str5, Boolean bool) {
        String string;
        String ops;
        Intrinsics.h(fragmentActivity, "activity");
        if (str3 == null || str3.length() == 0) {
            Bundle extras = fragmentActivity.getIntent().getExtras();
            string = extras != null ? extras.getString("ops") : null;
        } else {
            string = str3;
        }
        rr.a.a.a(fragmentActivity, str, str3, str4, z, new com.transsion.shorttv.bean.Subject(subject != null ? subject.getSubjectId() : null, subject != null ? subject.getSubjectType() : null, (String) null, (String) null, (Cover) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (List) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (List) null, (Long) null, (Boolean) null, (subject == null || (ops = subject.getOps()) == null) ? string : ops, (SubjectDl) null, (List) null, (Cover) null, (Trailer) null, false, false, (BiddingNativeManager) null, (String) null, (Long) null, (String) null, (String) null, false, false, (ShortTVItem) null, (ShortTVFavInfo) null, 0, false, false, 0L, (String) null, (List) null, 0L, (List) null, 0, false, (Integer) null, 0, (String) null, (List) null, (String) null, (String) null, (Long) null, false, (Integer) null, (PlayUrl) null, 0, 0, (List) null, 0, (SkuInfo) null, 0, (Set) null, -524292, 1073741823, (DefaultConstructorMarker) null), str5, bool);
    }

    public final void f0(FragmentActivity fragmentActivity, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, boolean z, Function4 function4) {
        UGCDownloadDialog b;
        Intrinsics.h(fragmentActivity, "activity");
        String h = h.a.h();
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
        if (str != null && str.length() != 0) {
            b = UGCDownloadDialog.v.a(str, str3, str4, str5, h, str6, str7, str2, str8, str9, str10, z);
        } else if (str2 == null || str2.length() == 0) {
            return;
        } else {
            b = UGCDownloadDialog.v.b(str2, str4, str5, h, str6, str7, str8, str9, str10, z);
        }
        b.s1(new d(function4, this, fragmentActivity, str5));
        b.show(supportFragmentManager, "download_anima");
    }

    public final Object l0(Continuation continuation) {
        return i.g(y0.b(), new fetchLatestDownloadData.2((Continuation) null), continuation);
    }

    public final void s0(FragmentActivity fragmentActivity, DownloadBean downloadBean, String str) {
        Intrinsics.h(fragmentActivity, "activity");
        Intrinsics.h(downloadBean, "downloadBean");
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null) {
            resourceId = downloadBean.getUrl();
        }
        t0(fragmentActivity, resourceId, str);
    }

    public final void t0(FragmentActivity fragmentActivity, String str, String str2) {
        Intrinsics.h(fragmentActivity, "activity");
        Intrinsics.h(str, "resourceId");
        i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new openDownloadVideo.1(str, str2, fragmentActivity, (Continuation) null), 3, (Object) null);
    }

    public final boolean w0(String str, String str2, boolean z, boolean z2) {
        boolean z3 = CollectionsKt.b0(this.a, str2) || CollectionsKt.b0(this.b, str);
        return z ? str != null ? this.b.contains(str) : z3 : (!z2 || str == null) ? z3 : this.c.contains(str);
    }

    public final void y0(String str, Context context, String str2, String str3) {
        Intrinsics.h(context, "context");
        i.f((CoroutineContext) null, new playNow.1(str, this, context, str2, str3, (Continuation) null), 1, (Object) null);
    }
}
