package com.transsion.share.share;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.c0;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.PermissionUtils;
import com.transsion.gslb.BuildConfig;
import com.transsion.push.PushConstants;
import com.transsion.share.R$id;
import com.transsion.share.R$layout;
import com.transsion.share.R$mipmap;
import com.transsion.share.R$string;
import com.transsion.share.R$style;
import com.transsion.share.bean.PostType;
import com.transsion.share.bean.ShareBean;
import com.transsion.share.bean.ShareType;
import com.transsion.share.share.ShareDialogFragment;
import com.transsion.share.share.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import oq.o;
import oq.p;
import qi.h;
import wf.a;
import yg.l;

@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 \u008a\u00012\u00020\u0001:\u0001WB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u0003J\u0019\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0019\u001a\u00020\u00182\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u0003J;\u0010\"\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00162\b\u0010 \u001a\u0004\u0018\u00010\u00162\b\u0010!\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\u00112\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0016H\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0016H\u0002¢\u0006\u0004\b*\u0010)J\u000f\u0010+\u001a\u00020\u0016H\u0002¢\u0006\u0004\b+\u0010)J#\u0010.\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00162\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u0016H\u0002¢\u0006\u0004\b0\u0010)J!\u00104\u001a\u00020\u00062\u0006\u00102\u001a\u0002012\b\u00103\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u0006H\u0003¢\u0006\u0004\b6\u0010\u0003J\u0015\u00109\u001a\u00020\u00062\u0006\u00108\u001a\u000207¢\u0006\u0004\b9\u0010:J\u0019\u0010=\u001a\u00020\u00062\b\u0010<\u001a\u0004\u0018\u00010;H\u0016¢\u0006\u0004\b=\u0010>J!\u0010?\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010<\u001a\u0004\u0018\u00010;H\u0016¢\u0006\u0004\b?\u0010@J\u0019\u0010B\u001a\u00020A2\b\u0010<\u001a\u0004\u0018\u00010;H\u0016¢\u0006\u0004\bB\u0010CJ\u000f\u0010D\u001a\u00020\u0006H\u0016¢\u0006\u0004\bD\u0010\u0003J/\u0010I\u001a\u00020\u00062\u0006\u0010F\u001a\u00020E2\u000e\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u00152\u0006\u0010H\u001a\u00020GH\u0016¢\u0006\u0004\bI\u0010JJ\u000f\u0010K\u001a\u00020\u0006H\u0016¢\u0006\u0004\bK\u0010\u0003J\u000f\u0010L\u001a\u00020\u0006H\u0016¢\u0006\u0004\bL\u0010\u0003J\u0017\u0010O\u001a\u00020\u00062\u0006\u0010N\u001a\u00020MH\u0016¢\u0006\u0004\bO\u0010PJ!\u0010S\u001a\u00020\u00062\b\u0010R\u001a\u0004\u0018\u00010Q2\b\u00103\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\bS\u0010TJ\u000f\u0010U\u001a\u00020\u0006H\u0016¢\u0006\u0004\bU\u0010\u0003R\u0018\u0010Y\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010]\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010a\u001a\u00020^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010d\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010f\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010cR\u0016\u0010h\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010cR\u0018\u0010l\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010o\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u0018\u0010q\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010nR\u0018\u0010s\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010nR\u0018\u0010u\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010nR\u0018\u0010x\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010wR\u001d\u0010~\u001a\u0004\u0018\u00010y8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}R\u001a\u0010\u0081\u0001\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u0018\u0010\u0083\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010nR\u0018\u0010\u0085\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010nR\u0018\u0010\u0087\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010nR\u0018\u0010\u0089\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0088\u0001\u0010n¨\u0006\u008b\u0001"}, d2 = {"Lcom/transsion/share/share/ShareDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "Landroid/view/View;", "view", BuildConfig.FLAVOR, "B0", "(Landroid/view/View;)V", BuildConfig.FLAVOR, "Lnq/a;", "q0", "()Ljava/util/List;", "initViewModel", "shareData", "w0", "(Lnq/a;)V", "Lcom/transsion/share/bean/ShareBean;", "shareBean", "A0", "(Lcom/transsion/share/bean/ShareBean;)V", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "permissions", BuildConfig.FLAVOR, "r0", "([Ljava/lang/String;)Z", "M0", PushConstants.PROVIDER_FIELD_PKG, "Landroid/app/Activity;", "activity", "shortUrl", "desc", "title", "H0", "(Ljava/lang/String;Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/transsion/share/bean/ShareType;", "shareType", "u0", "(Lcom/transsion/share/bean/ShareType;)Lcom/transsion/share/bean/ShareBean;", "o0", "()Ljava/lang/String;", "p0", "n0", "action", "failMsg", "s0", "(Ljava/lang/String;Ljava/lang/String;)V", "v0", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "tag", "L0", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V", "x0", "Lcom/transsion/share/share/a;", "callback", "G0", "(Lcom/transsion/share/share/a;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "onDestroy", BuildConfig.FLAVOR, "requestCode", BuildConfig.FLAVOR, "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "onResume", "onPause", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroid/content/Context;", "context", "K0", "(Landroid/content/Context;Ljava/lang/String;)V", "onStart", "Lmq/b;", "a", "Lmq/b;", "actionViewModel", "Landroidx/recyclerview/widget/RecyclerView;", "b", "Landroidx/recyclerview/widget/RecyclerView;", "shareList", BuildConfig.FLAVOR, "c", "J", "shareDataStartTime", "d", "Z", "isDelete", "e", "isDownload", "f", "isCheckOut", "Lcom/transsion/share/bean/PostType;", "g", "Lcom/transsion/share/bean/PostType;", "postType", "h", "Ljava/lang/String;", "authorId", "i", "reportType", "j", "ops", "k", "downloadName", "l", "Lcom/transsion/share/share/a;", "shareItemCallback", "Lqi/b;", "m", "Lkotlin/Lazy;", "getLogViewConfig", "()Lqi/b;", "logViewConfig", "n", "Lnq/a;", "mShareData", "o", "mSubjectId", "p", "mShareTitle", "q", "mShareScore", "r", "mSource", "s", "ShareLib_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ShareDialogFragment extends DialogFragment {

    /* renamed from: s, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    private mq.b actionViewModel;

    /* renamed from: b, reason: from kotlin metadata */
    private RecyclerView shareList;

    /* renamed from: c, reason: from kotlin metadata */
    private long shareDataStartTime;

    /* renamed from: d, reason: from kotlin metadata */
    private boolean isDelete;

    /* renamed from: e, reason: from kotlin metadata */
    private boolean isDownload;

    /* renamed from: f, reason: from kotlin metadata */
    private boolean isCheckOut;

    /* renamed from: g, reason: from kotlin metadata */
    private PostType postType;

    /* renamed from: h, reason: from kotlin metadata */
    private String authorId;

    /* renamed from: i, reason: from kotlin metadata */
    private String reportType;

    /* renamed from: j, reason: from kotlin metadata */
    private String ops;

    /* renamed from: k, reason: from kotlin metadata */
    private String downloadName;

    /* renamed from: l, reason: from kotlin metadata */
    private a shareItemCallback;

    /* renamed from: m, reason: from kotlin metadata */
    private final Lazy logViewConfig;

    /* renamed from: n, reason: from kotlin metadata */
    private nq.a mShareData;

    /* renamed from: o, reason: from kotlin metadata */
    private String mSubjectId;

    /* renamed from: p, reason: from kotlin metadata */
    private String mShareTitle;

    /* renamed from: q, reason: from kotlin metadata */
    private String mShareScore;

    /* renamed from: r, reason: from kotlin metadata */
    private String mSource;

    /* renamed from: com.transsion.share.share.ShareDialogFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ShareDialogFragment a(PostType postType, String str, String str2, String str3, String str4, String str5, boolean z, boolean z2, boolean z3, String str6, String str7, String str8) {
            Intrinsics.h(postType, "postType");
            Intrinsics.h(str3, "reportType");
            Intrinsics.h(str6, "source");
            ShareDialogFragment shareDialogFragment = new ShareDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("postType", postType);
            bundle.putString("subjectId", str);
            bundle.putBoolean("subject_delete", z2);
            bundle.putBoolean("subject_download", z);
            bundle.putBoolean("subject_checkout", z3);
            bundle.putString("share_title", str4);
            bundle.putString("share_score", str5);
            bundle.putString("source", str6);
            bundle.putString("author_id", str2);
            bundle.putString("report_type", str3);
            bundle.putString("ops", str7);
            bundle.putString("download_name", str8);
            shareDialogFragment.setArguments(bundle);
            return shareDialogFragment;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[ShareType.values().length];
            try {
                iArr[ShareType.DELETE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ShareType.DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ShareType.COPY_LINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ShareType.WHATSAPP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ShareType.TELEGRAM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ShareType.CHECKOUT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            a = iArr;
            int[] iArr2 = new int[PostType.values().length];
            try {
                iArr2[PostType.POST_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[PostType.SUBJECT_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[PostType.GROUP_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[PostType.STAFF_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[PostType.SHORT_TV_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[PostType.LIVE_TYPE.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[PostType.UGC_VIDEO.ordinal()] = 7;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr2[PostType.UGC_SHORT_TV.ordinal()] = 8;
            } catch (NoSuchFieldError unused14) {
            }
            b = iArr2;
        }
    }

    public static final class c implements oq.a {
        c() {
        }

        @Override // oq.a
        public void a(nq.a aVar) {
            Intrinsics.h(aVar, "shareData");
            ShareDialogFragment.this.mShareData = aVar;
            if (aVar.c() == ShareType.DELETE) {
                if (!l.a.e()) {
                    lq.a aVar2 = lq.a.a;
                    String string = ShareDialogFragment.this.getString(R$string.player_no_network_tip2);
                    Intrinsics.g(string, "getString(...)");
                    aVar2.f(string);
                    return;
                }
                a aVar3 = ShareDialogFragment.this.shareItemCallback;
                if (aVar3 != null) {
                    aVar3.a(ShareDialogFragment.this.mSubjectId, ShareDialogFragment.this.postType);
                }
                ShareDialogFragment.t0(ShareDialogFragment.this, "delete", null, 2, null);
                ShareDialogFragment.this.dismiss();
                return;
            }
            if (aVar.c() == ShareType.DOWNLOAD) {
                if (Build.VERSION.SDK_INT >= 29) {
                    ShareDialogFragment.this.w0(aVar);
                    return;
                }
                ShareDialogFragment shareDialogFragment = ShareDialogFragment.this;
                o oVar = o.a;
                if (shareDialogFragment.r0(oVar.c())) {
                    ShareDialogFragment.this.w0(aVar);
                    return;
                } else {
                    ShareDialogFragment.this.requestPermissions(oVar.c(), 11);
                    return;
                }
            }
            if (aVar.c() == ShareType.CHECKOUT) {
                a aVar4 = ShareDialogFragment.this.shareItemCallback;
                if (aVar4 != null) {
                    aVar4.d(ShareDialogFragment.this.mSubjectId);
                }
                ShareDialogFragment.t0(ShareDialogFragment.this, "checkout", null, 2, null);
                ShareDialogFragment.this.dismiss();
                return;
            }
            if (aVar.c() != ShareType.REPORT) {
                ShareDialogFragment.this.w0(aVar);
                return;
            }
            ShareDialogFragment.t0(ShareDialogFragment.this, "report", null, 2, null);
            lq.a aVar5 = lq.a.a;
            Context requireContext = ShareDialogFragment.this.requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            aVar5.e(requireContext, ShareDialogFragment.this.reportType, ShareDialogFragment.this.mSubjectId, ShareDialogFragment.this.shareItemCallback);
            ShareDialogFragment.this.dismiss();
        }
    }

    static final class d implements c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        d(Function1 function1) {
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

    public ShareDialogFragment() {
        super(R$layout.player_share_dialog);
        this.logViewConfig = LazyKt.b(new Function0() { // from class: oq.d
            public final Object invoke() {
                qi.b E0;
                E0 = ShareDialogFragment.E0();
                return E0;
            }
        });
        this.mSubjectId = BuildConfig.FLAVOR;
        this.mShareTitle = BuildConfig.FLAVOR;
        this.mShareScore = BuildConfig.FLAVOR;
        this.mSource = BuildConfig.FLAVOR;
    }

    private final void A0(ShareBean shareBean) {
        FragmentActivity activity;
        FragmentActivity activity2;
        ShareType shareType = shareBean != null ? shareBean.getShareType() : null;
        switch (shareType == null ? -1 : b.a[shareType.ordinal()]) {
            case 1:
                a aVar = this.shareItemCallback;
                if (aVar != null) {
                    a.C0056a.a(aVar, this.mSubjectId, null, 2, null);
                }
                t0(this, "delete ", null, 2, null);
                dismiss();
                break;
            case 2:
                a aVar2 = this.shareItemCallback;
                if (aVar2 != null) {
                    aVar2.c(shareBean.getDownUrl(), shareBean.getTitle(), BuildConfig.FLAVOR, shareBean.getCoverUrl());
                }
                t0(this, "download", null, 2, null);
                dismiss();
                break;
            case 3:
                String shortUrl = shareBean.getShortUrl();
                if (shortUrl != null) {
                    ClipData newPlainText = ClipData.newPlainText("Simple test", shortUrl);
                    Context context = getContext();
                    Object systemService = context != null ? context.getSystemService("clipboard") : null;
                    Intrinsics.f(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                    ((ClipboardManager) systemService).setPrimaryClip(newPlainText);
                    lq.a aVar3 = lq.a.a;
                    String string = getString(R$string.player_copy_link_success);
                    Intrinsics.g(string, "getString(...)");
                    aVar3.f(string);
                    dismiss();
                }
                a aVar4 = this.shareItemCallback;
                if (aVar4 != null) {
                    aVar4.e(this.mSubjectId);
                }
                t0(this, "copylink", null, 2, null);
                break;
            case 4:
                String shortUrl2 = shareBean.getShortUrl();
                if (shortUrl2 != null && (activity = getActivity()) != null) {
                    H0("com.whatsapp", activity, shortUrl2, shareBean.getDesc(), shareBean.getTitle());
                }
                a aVar5 = this.shareItemCallback;
                if (aVar5 != null) {
                    aVar5.e(this.mSubjectId);
                }
                t0(this, "whatsup", null, 2, null);
                break;
            case 5:
                String shortUrl3 = shareBean.getShortUrl();
                if (shortUrl3 != null && (activity2 = getActivity()) != null) {
                    H0("org.telegram.messenger", activity2, shortUrl3, shareBean.getDesc(), shareBean.getTitle());
                }
                a aVar6 = this.shareItemCallback;
                if (aVar6 != null) {
                    aVar6.e(this.mSubjectId);
                }
                t0(this, "Telegram", null, 2, null);
                break;
            case 6:
                a aVar7 = this.shareItemCallback;
                if (aVar7 != null) {
                    aVar7.d(this.mSubjectId);
                }
                t0(this, "checkout", null, 2, null);
                break;
        }
    }

    private final void B0(View view) {
        View findViewById = view.findViewById(R$id.iv_close);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: oq.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ShareDialogFragment.C0(ShareDialogFragment.this, view2);
                }
            });
        }
        this.shareList = view.findViewById(R$id.share_list);
        oq.c cVar = new oq.c(q0());
        RecyclerView recyclerView = this.shareList;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), 0, false));
            recyclerView.setAdapter(cVar);
        }
        cVar.k(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(ShareDialogFragment shareDialogFragment, View view) {
        shareDialogFragment.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D0(ShareDialogFragment shareDialogFragment, ShareBean shareBean) {
        ShareType c2;
        if (shareBean != null) {
            shareDialogFragment.A0(shareBean);
            return Unit.a;
        }
        nq.a aVar = shareDialogFragment.mShareData;
        shareDialogFragment.A0((aVar == null || (c2 = aVar.c()) == null) ? null : shareDialogFragment.u0(c2));
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qi.b E0() {
        return new qi.b("share_panel", false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(ShareDialogFragment shareDialogFragment) {
        shareDialogFragment.x0();
    }

    private final void H0(String pkg, Activity activity, String shortUrl, String desc, String title) {
        if (!TextUtils.isEmpty(desc)) {
            shortUrl = desc + "\n" + shortUrl;
        }
        if (!TextUtils.isEmpty(title)) {
            shortUrl = title + "\n" + shortUrl;
        }
        if (TextUtils.equals(pkg, "com.whatsapp")) {
            p.a.d(activity, shortUrl, new Function1() { // from class: oq.e
                public final Object invoke(Object obj) {
                    Unit I0;
                    I0 = ShareDialogFragment.I0(ShareDialogFragment.this, ((Boolean) obj).booleanValue());
                    return I0;
                }
            });
        } else if (TextUtils.equals(pkg, "org.telegram.messenger")) {
            p.a.c(activity, shortUrl, new Function1() { // from class: oq.f
                public final Object invoke(Object obj) {
                    Unit J0;
                    J0 = ShareDialogFragment.J0(ShareDialogFragment.this, ((Boolean) obj).booleanValue());
                    return J0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I0(ShareDialogFragment shareDialogFragment, boolean z) {
        if (z) {
            shareDialogFragment.dismissAllowingStateLoss();
        } else {
            lq.a aVar = lq.a.a;
            String string = shareDialogFragment.getString(R$string.tip_app_not_install);
            Intrinsics.g(string, "getString(...)");
            aVar.f(string);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J0(ShareDialogFragment shareDialogFragment, boolean z) {
        if (z) {
            shareDialogFragment.dismissAllowingStateLoss();
        } else {
            lq.a aVar = lq.a.a;
            String string = shareDialogFragment.getString(R$string.tip_app_not_install);
            Intrinsics.g(string, "getString(...)");
            aVar.f(string);
        }
        return Unit.a;
    }

    private final void L0(FragmentManager fragmentManager, String tag) {
        try {
            fragmentManager.g0();
            if (!isAdded() && fragmentManager.k0(tag) == null) {
                show(fragmentManager, tag);
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final void M0() {
        String string = getString(R$string.permission_deny_down_tip, new Object[]{"\"" + lq.a.a.b() + "\"", "\"" + getString(R$string.system_settings) + "\""});
        Intrinsics.g(string, "getString(...)");
        o oVar = o.a;
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        oVar.f(requireContext, BuildConfig.FLAVOR, string, new Function0() { // from class: oq.j
            public final Object invoke() {
                Unit N0;
                N0 = ShareDialogFragment.N0(ShareDialogFragment.this);
                return N0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N0(ShareDialogFragment shareDialogFragment) {
        o oVar = o.a;
        FragmentActivity activity = shareDialogFragment.getActivity();
        if (activity == null) {
            return Unit.a;
        }
        o.j(oVar, activity, 0, 2, null);
        return Unit.a;
    }

    private final qi.b getLogViewConfig() {
        return (qi.b) this.logViewConfig.getValue();
    }

    private final void initViewModel() {
        mq.b a = new v0(this).a(mq.b.class);
        a.g().j(getViewLifecycleOwner(), new d(new Function1() { // from class: oq.h
            public final Object invoke(Object obj) {
                Unit D0;
                D0 = ShareDialogFragment.D0(ShareDialogFragment.this, (ShareBean) obj);
                return D0;
            }
        }));
        this.actionViewModel = a;
    }

    private final String n0() {
        PostType postType = this.postType;
        switch (postType == null ? -1 : b.b[postType.ordinal()]) {
            case 1:
                return "/post/detail";
            case 2:
                return "/movie/detail";
            case 3:
                return "/room/detail";
            case 4:
                return "/movie/staff";
            case 5:
                return "/shorts/detail";
            case 6:
                return "/live/detail";
            case 7:
                return "/ugc_video/detail";
            case 8:
                return "/ugc_shorts/detail";
            default:
                return BuildConfig.FLAVOR;
        }
    }

    private final String o0() {
        String string;
        PostType postType = this.postType;
        int i = postType == null ? -1 : b.b[postType.ordinal()];
        if (i == 1) {
            Context context = getContext();
            string = context != null ? context.getString(R$string.share_long_link_post_s) : null;
            Intrinsics.e(string);
            return string;
        }
        if (i == 2) {
            Context context2 = getContext();
            string = context2 != null ? context2.getString(R$string.share_long_link_sub_no_duration, this.mShareTitle, this.mShareScore) : null;
            Intrinsics.e(string);
            return string;
        }
        if (i != 3) {
            return BuildConfig.FLAVOR;
        }
        Context context3 = getContext();
        string = context3 != null ? context3.getString(R$string.share_long_link_group_s) : null;
        Intrinsics.e(string);
        return string;
    }

    private final String p0() {
        String c2 = lq.a.a.c();
        if (TextUtils.isEmpty(c2)) {
            c2 = "0";
        }
        String b2 = gg.a.a.b();
        String n0 = n0();
        Context context = getContext();
        String packageName = context != null ? context.getPackageName() : null;
        String str = b2 + "?type=" + n0 + "&package_name=" + packageName + "&id=" + this.mSubjectId + "&uid=" + c2;
        a.a.f(wf.a.a, "ShareDialogFragment", "share long link:" + str, false, 4, (Object) null);
        return str;
    }

    private final List q0() {
        String str;
        String string;
        ArrayList arrayList = new ArrayList();
        ShareType shareType = ShareType.WHATSAPP;
        int i = R$mipmap.share_ic_whatsapp;
        String string2 = getString(R$string.player_whatsapp);
        Intrinsics.g(string2, "getString(...)");
        arrayList.add(new nq.a(shareType, i, string2));
        ShareType shareType2 = ShareType.TELEGRAM;
        int i2 = R$mipmap.share_ic_telegram;
        String string3 = getString(R$string.player_telegram);
        Intrinsics.g(string3, "getString(...)");
        arrayList.add(new nq.a(shareType2, i2, string3));
        ShareType shareType3 = ShareType.COPY_LINK;
        int i3 = R$mipmap.share_ic_copy_link;
        String string4 = getString(R$string.share_copy_link);
        Intrinsics.g(string4, "getString(...)");
        arrayList.add(new nq.a(shareType3, i3, string4));
        if (this.isDownload) {
            String str2 = this.downloadName;
            if (str2 == null || str2.length() == 0) {
                string = getString(R$string.player_download);
            } else {
                string = this.downloadName;
                if (string == null) {
                    string = getString(R$string.player_download);
                    Intrinsics.g(string, "getString(...)");
                }
            }
            Intrinsics.e(string);
            arrayList.add(new nq.a(ShareType.DOWNLOAD, R$mipmap.share_ic_download, string));
        }
        if (this.isDelete) {
            ShareType shareType4 = ShareType.DELETE;
            int i4 = R$mipmap.share_ic_delete;
            String string5 = getString(R$string.player_delete);
            Intrinsics.g(string5, "getString(...)");
            arrayList.add(new nq.a(shareType4, i4, string5));
        }
        if (this.isCheckOut) {
            ShareType shareType5 = ShareType.CHECKOUT;
            int i5 = R$mipmap.share_ic_checkout;
            String string6 = getString(R$string.player_check_out);
            Intrinsics.g(string6, "getString(...)");
            arrayList.add(new nq.a(shareType5, i5, string6));
        }
        if (!Intrinsics.c(lq.a.a.c(), this.authorId) && (str = this.reportType) != null && str.length() != 0) {
            ShareType shareType6 = ShareType.REPORT;
            int i6 = R$mipmap.share_ic_report;
            String string7 = getString(R$string.player_report);
            Intrinsics.g(string7, "getString(...)");
            arrayList.add(new nq.a(shareType6, i6, string7));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean r0(String[] permissions) {
        return PermissionUtils.s((String[]) Arrays.copyOf(permissions, permissions.length));
    }

    private final void s0(String action, String failMsg) {
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", action);
        if (failMsg != null) {
        }
        hashMap.put(v0(), this.mSubjectId);
        String str = this.ops;
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        hashMap.put("ops", str);
        h.a.o("share_panel", hashMap);
    }

    static /* synthetic */ void t0(ShareDialogFragment shareDialogFragment, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = BuildConfig.FLAVOR;
        }
        shareDialogFragment.s0(str, str2);
    }

    private final ShareBean u0(ShareType shareType) {
        ShareBean shareBean = new ShareBean();
        shareBean.setShareType(shareType);
        shareBean.setShortUrl(p0());
        shareBean.setDesc(o0());
        return shareBean;
    }

    private final String v0() {
        String str = this.mSource;
        switch (str.hashCode()) {
            case -1348386821:
                return !str.equals("UGCVideoDetail") ? "post_id" : "ugc_video_id";
            case 584244349:
                return !str.equals("subjectdetail") ? "post_id" : "subject_id";
            case 1232204688:
                return !str.equals("groupdetail") ? "post_id" : "group_id";
            case 2036233184:
                return !str.equals("usercenter") ? "post_id" : "host_uid";
            case 2092022001:
                str.equals("postdetail");
                return "post_id";
            default:
                return "post_id";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w0(nq.a shareData) {
        String str;
        if (shareData == null) {
            return;
        }
        l lVar = l.a;
        if (!lVar.e() && (shareData.c() == ShareType.DELETE || shareData.c() == ShareType.DOWNLOAD)) {
            lq.a aVar = lq.a.a;
            String string = getString(R$string.player_no_network_tip2);
            Intrinsics.g(string, "getString(...)");
            aVar.f(string);
            return;
        }
        if (!lVar.e()) {
            A0(u0(shareData.c()));
            return;
        }
        this.shareDataStartTime = System.currentTimeMillis();
        Bundle arguments = getArguments();
        String str2 = BuildConfig.FLAVOR;
        if (arguments == null || (str = arguments.getString("subjectId")) == null) {
            str = BuildConfig.FLAVOR;
        }
        this.mSubjectId = str;
        String c2 = lq.a.a.c();
        if (TextUtils.isEmpty(c2)) {
            c2 = "0";
        }
        if (shareData.c() == ShareType.TELEGRAM) {
            str2 = "Telegram";
        } else if (shareData.c() == ShareType.WHATSAPP) {
            str2 = "WhatsApp";
        }
        String str3 = str2;
        mq.b bVar = this.actionViewModel;
        if (bVar != null) {
            bVar.h(shareData.c(), n0(), this.mSubjectId, c2 == null ? "0" : c2, str3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void x0() {
        Window window;
        final View decorView;
        final View view;
        ViewGroup viewGroup;
        Drawable background;
        Drawable background2;
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null || (decorView = window.getDecorView()) == null || (view = getView()) == null) {
            return;
        }
        Intrinsics.g(requireContext(), "requireContext(...)");
        final int a = com.blankj.utilcode.util.d.a();
        boolean z = view instanceof ViewGroup;
        if (z) {
            ViewGroup viewGroup2 = (ViewGroup) view;
            viewGroup2.setFitsSystemWindows(false);
            if (viewGroup2.getBackground() == null) {
                View childAt = viewGroup2.getChildCount() > 0 ? viewGroup2.getChildAt(0) : null;
                if (childAt == null || (background2 = childAt.getBackground()) == null) {
                    view.setBackgroundColor(0);
                } else {
                    viewGroup2.setBackground(background2);
                }
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(decorView, new OnApplyWindowInsetsListener() { // from class: oq.k
            public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                WindowInsetsCompat y0;
                y0 = ShareDialogFragment.y0(a, view, view2, windowInsetsCompat);
                return y0;
            }
        });
        if (a > 0) {
            if (z) {
                ViewGroup viewGroup3 = (ViewGroup) view;
                if (viewGroup3.getChildCount() > 0) {
                    View childAt2 = viewGroup3.getChildAt(0);
                    if (childAt2 instanceof ViewGroup) {
                        viewGroup = (ViewGroup) childAt2;
                        if (viewGroup != null) {
                            int paddingLeft = viewGroup.getPaddingLeft();
                            int paddingTop = viewGroup.getPaddingTop();
                            int paddingRight = viewGroup.getPaddingRight();
                            int paddingBottom = viewGroup.getPaddingBottom();
                            if (paddingBottom >= a) {
                                a = paddingBottom;
                            }
                            if (viewGroup.getPaddingBottom() != a) {
                                viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, a);
                            }
                        }
                        if (z) {
                            ViewGroup viewGroup4 = (ViewGroup) view;
                            if (viewGroup4.getBackground() == null) {
                                View childAt3 = viewGroup4.getChildCount() > 0 ? viewGroup4.getChildAt(0) : null;
                                if (childAt3 != null && (background = childAt3.getBackground()) != null) {
                                    viewGroup4.setBackground(background);
                                }
                            }
                        }
                    }
                    viewGroup = null;
                    if (viewGroup != null) {
                    }
                    if (z) {
                    }
                }
            }
            if (z) {
                viewGroup = (ViewGroup) view;
                if (viewGroup != null) {
                }
                if (z) {
                }
            }
            viewGroup = null;
            if (viewGroup != null) {
            }
            if (z) {
            }
        }
        ViewCompat.requestApplyInsets(decorView);
        decorView.postDelayed(new Runnable() { // from class: oq.l
            @Override // java.lang.Runnable
            public final void run() {
                ShareDialogFragment.z0(decorView);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final WindowInsetsCompat y0(int i, View view, View view2, WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.h(view2, "v");
        Intrinsics.h(windowInsetsCompat, "insets");
        z0.c insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.navigationBars());
        Intrinsics.g(insets, "getInsets(...)");
        z0.c insets2 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemGestures());
        Intrinsics.g(insets2, "getInsets(...)");
        int i2 = insets.d;
        if (i2 > 0 || (i2 = insets2.d) > 0) {
            i = i2;
        } else if (i <= 0) {
            i = 0;
        }
        view2.setPadding(0, 0, 0, 0);
        if (i > 0) {
            boolean z = view instanceof ViewGroup;
            ViewGroup viewGroup = null;
            if (z) {
                ViewGroup viewGroup2 = (ViewGroup) view;
                if (viewGroup2.getChildCount() > 0) {
                    View childAt = viewGroup2.getChildAt(0);
                    if (childAt instanceof ViewGroup) {
                        viewGroup = (ViewGroup) childAt;
                    }
                    if (viewGroup != null) {
                        int paddingLeft = viewGroup.getPaddingLeft();
                        int paddingTop = viewGroup.getPaddingTop();
                        int paddingRight = viewGroup.getPaddingRight();
                        int paddingBottom = viewGroup.getPaddingBottom();
                        if (paddingBottom >= i) {
                            i = paddingBottom;
                        }
                        if (viewGroup.getPaddingBottom() != i) {
                            viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, i);
                        }
                    }
                }
            }
            if (z) {
                viewGroup = (ViewGroup) view;
            }
            if (viewGroup != null) {
            }
        }
        return windowInsetsCompat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(View view) {
        ViewCompat.requestApplyInsets(view);
    }

    public final void G0(a callback) {
        Intrinsics.h(callback, "callback");
        this.shareItemCallback = callback;
    }

    public final void K0(Context context, String tag) {
        if (context instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) context;
            if (fragmentActivity.isFinishing() || fragmentActivity.isDestroyed()) {
                return;
            }
            try {
                FragmentManager supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
                Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
                L0(supportFragmentManager, tag);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.h(newConfig, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(newConfig);
        dismiss();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R$style.shareDialogTheme);
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.g(onCreateDialog, "onCreateDialog(...)");
        Window window = onCreateDialog.getWindow();
        if (window != null) {
            window.setWindowAnimations(R$style.share_dialog_animations);
            window.setGravity(80);
            window.setDimAmount(0.5f);
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes == null) {
                attributes = new WindowManager.LayoutParams();
            }
            attributes.width = -1;
            window.setBackgroundDrawable(null);
            window.setAttributes(attributes);
        }
        return onCreateDialog;
    }

    public void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
    }

    public void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig == null || !logViewConfig.d()) {
            return;
        }
        h.a.x(logViewConfig);
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.h(permissions, "permissions");
        Intrinsics.h(grantResults, "grantResults");
        super/*androidx.fragment.app.Fragment*/.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 11) {
            if (!o.a.k(grantResults)) {
                M0();
                return;
            }
            nq.a aVar = this.mShareData;
            if (aVar != null) {
                w0(aVar);
            }
        }
    }

    public void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.o(SystemClock.elapsedRealtime());
            if (logViewConfig.c()) {
                h.a.y(logViewConfig);
            }
        }
    }

    public void onStart() {
        Dialog dialog;
        Window window;
        super.onStart();
        if (Build.VERSION.SDK_INT < 35 || (dialog = getDialog()) == null || (window = dialog.getWindow()) == null) {
            return;
        }
        WindowCompat.setDecorFitsSystemWindows(window, false);
        window.setNavigationBarColor(0);
        window.setStatusBarColor(0);
        window.getDecorView().post(new Runnable() { // from class: oq.i
            @Override // java.lang.Runnable
            public final void run() {
                ShareDialogFragment.F0(ShareDialogFragment.this);
            }
        });
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        String str;
        Intrinsics.h(view, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        this.isDelete = arguments != null && arguments.getBoolean("subject_delete");
        Bundle arguments2 = getArguments();
        this.isDownload = arguments2 != null && arguments2.getBoolean("subject_download");
        Bundle arguments3 = getArguments();
        this.isCheckOut = arguments3 != null && arguments3.getBoolean("subject_checkout");
        Bundle arguments4 = getArguments();
        if (arguments4 == null || (str = arguments4.getString("subjectId")) == null) {
            str = BuildConfig.FLAVOR;
        }
        this.mSubjectId = str;
        Bundle arguments5 = getArguments();
        this.postType = (PostType) (arguments5 != null ? arguments5.getSerializable("postType") : null);
        Bundle arguments6 = getArguments();
        this.mShareTitle = String.valueOf(arguments6 != null ? arguments6.getString("share_title") : null);
        Bundle arguments7 = getArguments();
        this.mShareScore = String.valueOf(arguments7 != null ? arguments7.getString("share_score") : null);
        Bundle arguments8 = getArguments();
        this.mSource = String.valueOf(arguments8 != null ? arguments8.getString("source") : null);
        Bundle arguments9 = getArguments();
        this.authorId = arguments9 != null ? arguments9.getString("author_id") : null;
        Bundle arguments10 = getArguments();
        this.reportType = arguments10 != null ? arguments10.getString("report_type") : null;
        Bundle arguments11 = getArguments();
        this.ops = arguments11 != null ? arguments11.getString("ops") : null;
        Bundle arguments12 = getArguments();
        this.downloadName = arguments12 != null ? arguments12.getString("download_name") : null;
        B0(view);
        initViewModel();
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.k(true);
        }
        qi.b logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 != null) {
            logViewConfig2.l(false);
        }
    }
}
