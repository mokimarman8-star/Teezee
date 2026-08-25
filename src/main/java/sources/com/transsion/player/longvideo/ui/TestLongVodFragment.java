package com.transsion.player.longvideo.ui;

import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.AppDatabase$f1;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.gslb.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0004R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/transsion/player/longvideo/ui/TestLongVodFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lmn/n;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "c0", "(Landroid/view/LayoutInflater;)Lmn/n;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", BuildConfig.FLAVOR, "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "lazyLoadData", "onPause", "onResume", "onStop", "Lkn/a;", "a", "Lkn/a;", "playerControl", "Lcom/transsion/baselib/db/video/VideoDetailPlayDao;", "b", "Lkotlin/Lazy;", "getVideoDetailPlayDao", "()Lcom/transsion/baselib/db/video/VideoDetailPlayDao;", "videoDetailPlayDao", "LongVideo_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class TestLongVodFragment extends BaseFragment<mn.n> {

    /* renamed from: a, reason: from kotlin metadata */
    private kn.a playerControl;

    /* renamed from: b, reason: from kotlin metadata */
    private final Lazy videoDetailPlayDao = LazyKt.b(new Function0() { // from class: com.transsion.player.longvideo.ui.d1
        public final Object invoke() {
            VideoDetailPlayDao d0;
            d0 = TestLongVodFragment.d0();
            return d0;
        }
    });

    public static final class a extends androidx.activity.u {
        a() {
            super(true);
        }

        public void handleOnBackPressed() {
            kn.a aVar = TestLongVodFragment.this.playerControl;
            if (aVar != null) {
                aVar.onBackPressed();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoDetailPlayDao d0() {
        AppDatabase$f1 appDatabase$f1 = AppDatabase.p;
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        return appDatabase$f1.b(a2).C1();
    }

    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public mn.n getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        mn.n c = mn.n.c(inflater);
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public void initView(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        mn.n nVar = (mn.n) getMViewBinding();
        this.playerControl = nVar != null ? nVar.e : null;
        kotlinx.coroutines.i.d(androidx.lifecycle.v.a(this), (CoroutineContext) null, (CoroutineStart) null, new TestLongVodFragment$initView$2(null), 3, (Object) null);
        requireActivity().getOnBackPressedDispatcher().i(this, new a());
    }

    public void lazyLoadData() {
    }

    public void onPause() {
        super.onPause();
        kn.a aVar = this.playerControl;
        if (aVar != null) {
            aVar.onViewPause();
        }
    }

    public void onResume() {
        super.onResume();
        kn.a aVar = this.playerControl;
        if (aVar != null) {
            aVar.onViewResume();
        }
    }

    public void onStop() {
        super/*androidx.fragment.app.Fragment*/.onStop();
        kn.a aVar = this.playerControl;
        if (aVar != null) {
            aVar.onSaveHistory();
        }
    }
}
