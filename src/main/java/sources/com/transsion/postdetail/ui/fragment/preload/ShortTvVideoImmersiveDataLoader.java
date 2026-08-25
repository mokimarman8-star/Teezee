package com.transsion.postdetail.ui.fragment.preload;

import androidx.lifecycle.b0;
import com.transsion.flow.bean.ShortTVRespData;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.player.orplayer.ORPlayerPreloadManager;
import com.transsion.postdetail.viewmodel.ImmVideoRequestEntity;
import com.transsion.push.bean.MsgStyle;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ShortTvVideoImmersiveDataLoader extends am.b {
    private ImmVideoRequestEntity f;
    private final Lazy g;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ShortTvVideoImmersiveDataLoader() {
        this(r0, 1, r0);
        ImmVideoRequestEntity immVideoRequestEntity = null;
    }

    public ShortTvVideoImmersiveDataLoader(ImmVideoRequestEntity immVideoRequestEntity) {
        this.f = immVideoRequestEntity;
        this.g = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ui.fragment.preload.a
            public final Object invoke() {
                ao.d q;
                q = ShortTvVideoImmersiveDataLoader.q();
                return q;
            }
        });
    }

    public /* synthetic */ ShortTvVideoImmersiveDataLoader(ImmVideoRequestEntity immVideoRequestEntity, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : immVideoRequestEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ao.d o() {
        return (ao.d) this.g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object p(ShortTVRespData shortTVRespData, Continuation continuation) {
        Object obj;
        Media video;
        Video videoAddress;
        String url;
        Unit unit;
        Media video2;
        Video videoAddress2;
        String url2;
        Object g;
        ImmVideoRequestEntity immVideoRequestEntity = this.f;
        Unit unit2 = null;
        if (!Intrinsics.c(immVideoRequestEntity != null ? immVideoRequestEntity.getPage() : null, MsgStyle.CUSTOM_LEFT_PIC)) {
            return Unit.a;
        }
        List<Subject> items = shortTVRespData != null ? shortTVRespData.getItems() : null;
        if (items == null || items.isEmpty()) {
            return Unit.a;
        }
        if (eo.b.a.b()) {
            Intrinsics.e(shortTVRespData);
            List<Subject> items2 = shortTVRespData.getItems();
            Intrinsics.e(items2);
            ShortTVItem shortTVFirstEp = items2.get(0).getShortTVFirstEp();
            if (shortTVFirstEp != null && (g = i.g(y0.c(), new ShortTvVideoImmersiveDataLoader$initVideoPreload$2$1(shortTVFirstEp, null), continuation)) == IntrinsicsKt.f()) {
                return g;
            }
        } else {
            try {
                Result.Companion companion = Result.Companion;
                Intrinsics.e(shortTVRespData);
                List<Subject> items3 = shortTVRespData.getItems();
                Intrinsics.e(items3);
                ShortTVItem shortTVFirstEp2 = items3.get(0).getShortTVFirstEp();
                if (shortTVFirstEp2 == null || (video2 = shortTVFirstEp2.getVideo()) == null || (videoAddress2 = video2.getVideoAddress()) == null || (url2 = videoAddress2.getUrl()) == null) {
                    unit = null;
                } else {
                    ORPlayerPreloadManager.i.a().i(url2);
                    unit = Unit.a;
                }
                Result.constructor-impl(unit);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.a(th2));
            }
            try {
                Intrinsics.e(shortTVRespData);
                List<Subject> items4 = shortTVRespData.getItems();
                Intrinsics.e(items4);
                ShortTVItem shortTVFirstEp3 = items4.get(1).getShortTVFirstEp();
                if (shortTVFirstEp3 != null && (video = shortTVFirstEp3.getVideo()) != null && (videoAddress = video.getVideoAddress()) != null && (url = videoAddress.getUrl()) != null) {
                    ORPlayerPreloadManager.i.a().i(url);
                    unit2 = Unit.a;
                }
                obj = Result.constructor-impl(unit2);
            } catch (Throwable th3) {
                Result.Companion companion3 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.a(th3));
            }
            Result.box-impl(obj);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ao.d q() {
        return (ao.d) kg.c.e.a().h(ao.d.class);
    }

    @Override // am.b
    public void h(b0 b0Var) {
        j(i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new ShortTvVideoImmersiveDataLoader$loadDataFromService$1(this, null), 3, (Object) null));
    }

    public final ImmVideoRequestEntity n() {
        return this.f;
    }

    public final void r(ImmVideoRequestEntity immVideoRequestEntity) {
        this.f = immVideoRequestEntity;
    }
}
