package com.transsion.postdetail.ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.w;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.c0;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import com.therouter.TheRouter;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.baselib.report.k;
import com.transsion.baseui.R$color;
import com.transsion.baseui.activity.BaseNewActivity;
import com.transsion.flow.bean.MediaType;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.helper.ImmVideoHelper;
import com.transsion.postdetail.ui.fragment.PostAudioDetailFragment;
import com.transsion.postdetail.ui.fragment.PostImageTextDetailFragment;
import com.transsion.postdetail.ui.fragment.VideoFragment;
import com.transsion.postdetail.viewmodel.PostDetailViewModel;
import java.util.ArrayList;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import yg.l;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 V2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001WB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u001b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\u0019\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001e\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\u0005H\u0016¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\u0005H\u0016¢\u0006\u0004\b!\u0010\u0004J\u000f\u0010\"\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\"\u0010\u0015J\u000f\u0010#\u001a\u00020\u0013H\u0016¢\u0006\u0004\b#\u0010\u0015J\u000f\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0013H\u0016¢\u0006\u0004\b'\u0010\u0015J\u000f\u0010(\u001a\u00020\u0005H\u0016¢\u0006\u0004\b(\u0010\u0004J\u000f\u0010)\u001a\u00020\bH\u0016¢\u0006\u0004\b)\u0010\u001dR\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010-\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b,\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b.\u0010+R\u0016\u00102\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00104\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b3\u0010+R\u0016\u00107\u001a\u00020$8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b8\u00101R\u0018\u0010;\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b:\u0010+R*\u0010A\u001a\u0016\u0012\u0004\u0012\u00020=\u0018\u00010<j\n\u0012\u0004\u0012\u00020=\u0018\u0001`>8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010C\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bB\u00101R\u0016\u0010E\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bD\u00101R\u0018\u0010H\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010J\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bI\u00101R\u001b\u0010P\u001a\u00020K8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u0018\u0010S\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010U\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010R¨\u0006X"}, d2 = {"Lcom/transsion/postdetail/ui/activity/PostDetailVideoActivity;", "Lcom/transsion/baseui/activity/BaseNewActivity;", "Lwn/c;", "<init>", "()V", BuildConfig.FLAVOR, "G0", "H0", BuildConfig.FLAVOR, "mediaType", "Landroidx/fragment/app/Fragment;", "K0", "(Ljava/lang/String;)Landroidx/fragment/app/Fragment;", "I0", "J0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", BuildConfig.FLAVOR, "A0", "()Z", "isMonitorNetworkState", "onBackPressed", "onResume", "onStop", "D0", "()Lwn/c;", "f0", "()Ljava/lang/String;", "l0", "m0", "k0", "p0", "isTranslucent", "isStatusDark", BuildConfig.FLAVOR, "statusColor", "()I", "o0", "retryLoadData", "getPageName", "i", "Ljava/lang/String;", "j", "postId", "k", "itemType", "l", "Z", "fromComment", "m", "ops", "n", "I", "tabId", "o", "videoLoadMore", "p", "pageFrom", "Ljava/util/ArrayList;", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "Lkotlin/collections/ArrayList;", "q", "Ljava/util/ArrayList;", "downloadedShortsList", "r", "prioritizeDownloaded", "s", "isFromDownloaded", "t", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "itemObject", "u", "isBuiltIn", "Lcom/transsion/postdetail/viewmodel/PostDetailViewModel;", "v", "Lkotlin/Lazy;", "E0", "()Lcom/transsion/postdetail/viewmodel/PostDetailViewModel;", "viewModel", "w", "Landroidx/fragment/app/Fragment;", "mFragment", "x", "target", "y", "a", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PostDetailVideoActivity extends BaseNewActivity<wn.c> {

    /* renamed from: i, reason: from kotlin metadata */
    public String mediaType;

    /* renamed from: j, reason: from kotlin metadata */
    public String postId;

    /* renamed from: k, reason: from kotlin metadata */
    public String itemType;

    /* renamed from: l, reason: from kotlin metadata */
    public boolean fromComment;

    /* renamed from: m, reason: from kotlin metadata */
    public String ops;

    /* renamed from: n, reason: from kotlin metadata */
    public int tabId;

    /* renamed from: o, reason: from kotlin metadata */
    public boolean videoLoadMore = true;

    /* renamed from: p, reason: from kotlin metadata */
    public String pageFrom;

    /* renamed from: q, reason: from kotlin metadata */
    public ArrayList downloadedShortsList;

    /* renamed from: r, reason: from kotlin metadata */
    public boolean prioritizeDownloaded;

    /* renamed from: s, reason: from kotlin metadata */
    public boolean isFromDownloaded;

    /* renamed from: t, reason: from kotlin metadata */
    public PostSubjectItem itemObject;

    /* renamed from: u, reason: from kotlin metadata */
    public boolean isBuiltIn;

    /* renamed from: v, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: w, reason: from kotlin metadata */
    private Fragment mFragment;

    /* renamed from: x, reason: from kotlin metadata */
    private Fragment target;

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

    public PostDetailVideoActivity() {
        final Function0 function0 = null;
        this.viewModel = new ViewModelLazy(Reflection.b(PostDetailViewModel.class), new Function0<x0>() { // from class: com.transsion.postdetail.ui.activity.PostDetailVideoActivity$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final x0 m97invoke() {
                return this.getViewModelStore();
            }
        }, new Function0<v0.c>() { // from class: com.transsion.postdetail.ui.activity.PostDetailVideoActivity$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final v0.c m96invoke() {
                return this.getDefaultViewModelProviderFactory();
            }
        }, new Function0<p1.a>() { // from class: com.transsion.postdetail.ui.activity.PostDetailVideoActivity$special$$inlined$viewModels$default$3
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

    private final PostDetailViewModel E0() {
        return (PostDetailViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(PostDetailVideoActivity postDetailVideoActivity, PostSubjectItem postSubjectItem) {
        if (postSubjectItem == null) {
            postDetailVideoActivity.v0();
        } else {
            Media media = postSubjectItem.getMedia();
            String mediaType = media != null ? media.getMediaType() : null;
            postDetailVideoActivity.mediaType = mediaType;
            if (Intrinsics.c(mediaType, MediaType.VIDEO.getValue())) {
                ImmVideoHelper.h.a().s(postSubjectItem);
            }
            postDetailVideoActivity.itemObject = postSubjectItem;
            postDetailVideoActivity.H0();
        }
        return Unit.a;
    }

    private final void G0() {
        Media media;
        Media media2;
        w0();
        if (!this.isBuiltIn && !this.isFromDownloaded && !l.a.e()) {
            y0();
            return;
        }
        if (this.isFromDownloaded && TextUtils.isEmpty(this.mediaType)) {
            PostSubjectItem postSubjectItem = this.itemObject;
            String str = null;
            if (TextUtils.isEmpty((postSubjectItem == null || (media2 = postSubjectItem.getMedia()) == null) ? null : media2.getMediaType())) {
                str = MediaType.VIDEO.getValue();
            } else {
                PostSubjectItem postSubjectItem2 = this.itemObject;
                if (postSubjectItem2 != null && (media = postSubjectItem2.getMedia()) != null) {
                    str = media.getMediaType();
                }
            }
            this.mediaType = str;
        }
        if (this.postId == null || !TextUtils.isEmpty(this.mediaType)) {
            H0();
            return;
        }
        PostDetailViewModel E0 = E0();
        String str2 = this.postId;
        if (str2 == null) {
            str2 = BuildConfig.FLAVOR;
        }
        E0.x(str2);
    }

    private final void H0() {
        u0();
        J0();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
        w p = supportFragmentManager.p();
        Intrinsics.g(p, "beginTransaction()");
        Fragment K0 = K0(this.mediaType);
        if (K0 != null) {
            p.s(R$id.container, K0);
        } else {
            K0 = null;
        }
        this.target = K0;
        p.j();
    }

    private final void I0() {
        ep.b bVar;
        if (!TextUtils.equals(MediaType.VIDEO.getValue(), this.mediaType) || (bVar = (ep.b) TheRouter.d(ep.b.class, new Object[0])) == null) {
            return;
        }
        bVar.e();
    }

    private final void J0() {
        ep.b bVar;
        if (!TextUtils.equals(MediaType.VIDEO.getValue(), this.mediaType) || (bVar = (ep.b) TheRouter.d(ep.b.class, new Object[0])) == null) {
            return;
        }
        bVar.c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Fragment K0(String mediaType) {
        Fragment a;
        if (Intrinsics.c(mediaType, MediaType.AUDIO.getValue())) {
            setRequestedOrientation(1);
            a = PostAudioDetailFragment.INSTANCE.a(this.postId, this.fromComment, this.ops, this.itemObject);
        } else if (Intrinsics.c(mediaType, MediaType.VIDEO.getValue())) {
            PostSubjectItem postSubjectItem = this.itemObject;
            if (postSubjectItem != null) {
                ImmVideoHelper.h.a().s(postSubjectItem);
            }
            a = VideoFragment.INSTANCE.a(this.postId, this.itemType, Integer.valueOf(this.tabId), this.videoLoadMore, (r30 & 16) != 0 ? true : this.fromComment, (r30 & 32) != 0 ? BuildConfig.FLAVOR : this.ops, (r30 & 64) != 0 ? false : false, (r30 & 128) != 0 ? BuildConfig.FLAVOR : null, (r30 & 256) != 0 ? null : this.pageFrom, (r30 & DownloadException.EXCEPTION_IO_SSL_PEER_UNVERIFIED) != 0 ? false : false, (r30 & 1024) != 0 ? null : this.downloadedShortsList, (r30 & 2048) != 0 ? false : this.prioritizeDownloaded, (r30 & 4096) != 0 ? false : this.isFromDownloaded);
        } else {
            setRequestedOrientation(1);
            a = PostImageTextDetailFragment.INSTANCE.a(this.postId, this.fromComment, this.ops, this.itemObject, this.pageFrom);
        }
        this.mFragment = a;
        return a;
    }

    public boolean A0() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: D0, reason: merged with bridge method [inline-methods] */
    public wn.c getViewBinding() {
        wn.c c = wn.c.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public String f0() {
        return BuildConfig.FLAVOR;
    }

    public String getPageName() {
        return "postdetail";
    }

    public boolean isMonitorNetworkState() {
        return (this.isBuiltIn || this.isFromDownloaded) ? false : true;
    }

    public boolean isStatusDark() {
        return false;
    }

    public boolean isTranslucent() {
        return true;
    }

    public void k0() {
    }

    public void l0() {
        s0();
    }

    public void m0() {
        E0().A().j(this, new b(new Function1() { // from class: com.transsion.postdetail.ui.activity.d
            public final Object invoke(Object obj) {
                Unit F0;
                F0 = PostDetailVideoActivity.F0(PostDetailVideoActivity.this, (PostSubjectItem) obj);
                return F0;
            }
        }));
    }

    public boolean o0() {
        return false;
    }

    public void onBackPressed() {
        PostAudioDetailFragment postAudioDetailFragment = this.mFragment;
        if (postAudioDetailFragment instanceof PostAudioDetailFragment) {
            Intrinsics.f(postAudioDetailFragment, "null cannot be cast to non-null type com.transsion.postdetail.ui.fragment.PostAudioDetailFragment");
            postAudioDetailFragment.p1();
        }
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        TheRouter.l(this);
        super.onCreate(savedInstanceState);
        k.a.w(3, this);
        if ((this.isBuiltIn || this.isFromDownloaded) && !l.a.e()) {
            p0();
        }
    }

    public void onResume() {
        super.onResume();
        J0();
    }

    protected void onStop() {
        super.onStop();
        I0();
    }

    public void p0() {
        G0();
    }

    public void retryLoadData() {
        if (this.target == null) {
            G0();
        }
    }

    public int statusColor() {
        return R$color.base_color_black;
    }
}
