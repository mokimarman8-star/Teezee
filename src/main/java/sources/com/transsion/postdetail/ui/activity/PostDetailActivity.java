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
import com.transsion.baseui.activity.BaseNewActivity;
import com.transsion.flow.bean.MediaType;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.postdetail.R;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.helper.ImmVideoHelper;
import com.transsion.postdetail.ui.fragment.PostAudioDetailFragment;
import com.transsion.postdetail.ui.fragment.PostDetailFragment;
import com.transsion.postdetail.ui.fragment.VideoFragment;
import com.transsion.postdetail.viewmodel.PostDetailViewModel;
import ep.k;
import ij.y;
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

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 R2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001SB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u001b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\u0004J\u0019\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001e\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\u0005H\u0016¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\u0007H\u0016¢\u0006\u0004\b!\u0010\tJ\u000f\u0010\"\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\"\u0010\tJ\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0007H\u0016¢\u0006\u0004\b&\u0010\tJ\u000f\u0010'\u001a\u00020\u0007H\u0016¢\u0006\u0004\b'\u0010\tJ\u000f\u0010(\u001a\u00020\u0005H\u0016¢\u0006\u0004\b(\u0010\u0004J\u000f\u0010)\u001a\u00020\u000bH\u0016¢\u0006\u0004\b)\u0010\u001cJ\u000f\u0010*\u001a\u00020\u000bH\u0016¢\u0006\u0004\b*\u0010\u001cR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b-\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b/\u0010,R\u0016\u00103\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00105\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b4\u0010,R\u0016\u00108\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b9\u00102R\u0018\u0010<\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b;\u0010,R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010B\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bA\u0010,R\u0016\u0010D\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bC\u00102R\u001b\u0010J\u001a\u00020E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u0018\u0010M\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010O\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010LR\u0016\u0010Q\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010,¨\u0006T"}, d2 = {"Lcom/transsion/postdetail/ui/activity/PostDetailActivity;", "Lcom/transsion/baseui/activity/BaseNewActivity;", "Lwn/c;", "<init>", "()V", BuildConfig.FLAVOR, "J0", BuildConfig.FLAVOR, "I0", "()Z", "K0", BuildConfig.FLAVOR, "mediaType", "Landroidx/fragment/app/Fragment;", "N0", "(Ljava/lang/String;)Landroidx/fragment/app/Fragment;", "L0", "M0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onBackPressed", "onResume", "onStop", "E0", "()Lwn/c;", "f0", "()Ljava/lang/String;", "l0", "m0", "k0", "p0", "isTranslucent", "isChangeStatusBar", BuildConfig.FLAVOR, "statusColor", "()I", "isStatusDark", "o0", "retryLoadData", "getPageName", "a0", "i", "Ljava/lang/String;", "j", "postId", "k", "itemType", "l", "Z", "fromComment", "m", "ops", "n", "I", "tabId", "o", "videoLoadMore", "p", "pageFrom", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "q", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "itemObject", "r", "commentId", "s", "needBackToRoom", "Lcom/transsion/postdetail/viewmodel/PostDetailViewModel;", "t", "Lkotlin/Lazy;", "F0", "()Lcom/transsion/postdetail/viewmodel/PostDetailViewModel;", "viewModel", "u", "Landroidx/fragment/app/Fragment;", "mFragment", "v", "target", "w", "emptyDesc", "x", "a", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PostDetailActivity extends BaseNewActivity<wn.c> {

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

    /* renamed from: p, reason: from kotlin metadata */
    public String pageFrom;

    /* renamed from: q, reason: from kotlin metadata */
    public PostSubjectItem itemObject;

    /* renamed from: r, reason: from kotlin metadata */
    public String commentId;

    /* renamed from: s, reason: from kotlin metadata */
    public boolean needBackToRoom;

    /* renamed from: t, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: u, reason: from kotlin metadata */
    private Fragment mFragment;

    /* renamed from: v, reason: from kotlin metadata */
    private Fragment target;

    /* renamed from: o, reason: from kotlin metadata */
    public boolean videoLoadMore = true;

    /* renamed from: w, reason: from kotlin metadata */
    private String emptyDesc = BuildConfig.FLAVOR;

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

    public PostDetailActivity() {
        final Function0 function0 = null;
        this.viewModel = new ViewModelLazy(Reflection.b(PostDetailViewModel.class), new Function0<x0>() { // from class: com.transsion.postdetail.ui.activity.PostDetailActivity$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final x0 m94invoke() {
                return this.getViewModelStore();
            }
        }, new Function0<v0.c>() { // from class: com.transsion.postdetail.ui.activity.PostDetailActivity$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final v0.c m93invoke() {
                return this.getDefaultViewModelProviderFactory();
            }
        }, new Function0<p1.a>() { // from class: com.transsion.postdetail.ui.activity.PostDetailActivity$special$$inlined$viewModels$default$3
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

    private final PostDetailViewModel F0() {
        return (PostDetailViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G0(PostDetailActivity postDetailActivity, PostSubjectItem postSubjectItem) {
        if (postSubjectItem == null) {
            postDetailActivity.v0();
        } else {
            Media media = postSubjectItem.getMedia();
            String mediaType = media != null ? media.getMediaType() : null;
            postDetailActivity.mediaType = mediaType;
            if (Intrinsics.c(mediaType, MediaType.VIDEO.getValue())) {
                ImmVideoHelper.h.a().s(postSubjectItem);
            }
            postDetailActivity.itemObject = postSubjectItem;
            postDetailActivity.t0();
            postDetailActivity.K0();
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit H0(PostDetailActivity postDetailActivity, String str) {
        if (Intrinsics.c(str, "404")) {
            String string = postDetailActivity.getString(R.string.post_delete_tips);
            Intrinsics.g(string, "getString(...)");
            postDetailActivity.emptyDesc = string;
        }
        return Unit.a;
    }

    private final boolean I0() {
        return Intrinsics.c(MediaType.VIDEO.getValue(), this.mediaType) || Intrinsics.c(MediaType.AUDIO.getValue(), this.mediaType) || y.a.a();
    }

    private final void J0() {
        String str;
        w0();
        if (!l.a.e()) {
            y0();
            return;
        }
        if (this.postId == null || !((str = this.mediaType) == null || str.length() == 0)) {
            K0();
            return;
        }
        PostDetailViewModel F0 = F0();
        String str2 = this.postId;
        if (str2 == null) {
            str2 = BuildConfig.FLAVOR;
        }
        F0.x(str2);
    }

    private final void K0() {
        M0();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
        w p = supportFragmentManager.p();
        Intrinsics.g(p, "beginTransaction()");
        Fragment N0 = N0(this.mediaType);
        if (N0 != null) {
            p.s(R$id.container, N0);
        } else {
            N0 = null;
        }
        this.target = N0;
        p.j();
    }

    private final void L0() {
        ep.b bVar;
        if (!TextUtils.equals(MediaType.VIDEO.getValue(), this.mediaType) || (bVar = (ep.b) TheRouter.d(ep.b.class, new Object[0])) == null) {
            return;
        }
        bVar.e();
    }

    private final void M0() {
        ep.b bVar;
        if (!TextUtils.equals(MediaType.VIDEO.getValue(), this.mediaType) || (bVar = (ep.b) TheRouter.d(ep.b.class, new Object[0])) == null) {
            return;
        }
        bVar.c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Fragment N0(String mediaType) {
        Fragment a;
        if (Intrinsics.c(mediaType, MediaType.VIDEO.getValue())) {
            u0();
            PostSubjectItem postSubjectItem = this.itemObject;
            if (postSubjectItem != null) {
                ImmVideoHelper.h.a().s(postSubjectItem);
            }
            a = VideoFragment.INSTANCE.a(this.postId, this.itemType, Integer.valueOf(this.tabId), this.videoLoadMore, (r30 & 16) != 0 ? true : this.fromComment, (r30 & 32) != 0 ? BuildConfig.FLAVOR : this.ops, (r30 & 64) != 0 ? false : false, (r30 & 128) != 0 ? BuildConfig.FLAVOR : this.commentId, (r30 & 256) != 0 ? null : this.pageFrom, (r30 & DownloadException.EXCEPTION_IO_SSL_PEER_UNVERIFIED) != 0 ? false : this.needBackToRoom, (r30 & 1024) != 0 ? null : null, (r30 & 2048) != 0 ? false : false, (r30 & 4096) != 0 ? false : false);
        } else {
            setRequestedOrientation(1);
            a = PostDetailFragment.INSTANCE.a(this.postId, this.fromComment, this.ops, this.itemObject, this.commentId, this.pageFrom);
        }
        this.mFragment = a;
        return a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: E0, reason: merged with bridge method [inline-methods] */
    public wn.c getViewBinding() {
        wn.c c = wn.c.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    /* renamed from: a0, reason: from getter */
    public String getEmptyDesc() {
        return this.emptyDesc;
    }

    public String f0() {
        return BuildConfig.FLAVOR;
    }

    public String getPageName() {
        return "postdetail";
    }

    public boolean isChangeStatusBar() {
        return I0();
    }

    public boolean isStatusDark() {
        if (I0()) {
            return false;
        }
        return super.isStatusDark();
    }

    public boolean isTranslucent() {
        return true;
    }

    public void k0() {
    }

    public void l0() {
    }

    public void m0() {
        F0().A().j(this, new b(new Function1() { // from class: com.transsion.postdetail.ui.activity.b
            public final Object invoke(Object obj) {
                Unit G0;
                G0 = PostDetailActivity.G0(PostDetailActivity.this, (PostSubjectItem) obj);
                return G0;
            }
        }));
        F0().y().j(this, new b(new Function1() { // from class: com.transsion.postdetail.ui.activity.c
            public final Object invoke(Object obj) {
                Unit H0;
                H0 = PostDetailActivity.H0(PostDetailActivity.this, (String) obj);
                return H0;
            }
        }));
    }

    public boolean o0() {
        if (Intrinsics.c(MediaType.VIDEO.getValue(), this.mediaType)) {
            return false;
        }
        return super.o0();
    }

    public void onBackPressed() {
        if (this.needBackToRoom) {
            k.i(k.a, null, null, null, false, 15, null);
            finish();
            return;
        }
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
        com.transsion.baselib.report.k.a.w(3, this);
    }

    public void onResume() {
        super.onResume();
        M0();
    }

    protected void onStop() {
        super.onStop();
        L0();
    }

    public void p0() {
        J0();
    }

    public void retryLoadData() {
        if (this.target == null) {
            J0();
        }
    }

    public int statusColor() {
        return I0() ? com.tn.lib.widget.R.color.gray_0_1 : super.statusColor();
    }
}
