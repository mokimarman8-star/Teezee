package com.transsion.postdetail.ui.fragment.preload;

import androidx.lifecycle.b0;
import com.transsion.postdetail.viewmodel.ImmVideoRequestEntity;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class VideoImmersiveDataLoader extends am.b {
    private ImmVideoRequestEntity f;
    private final Lazy g;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public VideoImmersiveDataLoader() {
        this(r0, 1, r0);
        ImmVideoRequestEntity immVideoRequestEntity = null;
    }

    public VideoImmersiveDataLoader(ImmVideoRequestEntity immVideoRequestEntity) {
        this.f = immVideoRequestEntity;
        this.g = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ui.fragment.preload.c
            public final Object invoke() {
                ao.b o;
                o = VideoImmersiveDataLoader.o();
                return o;
            }
        });
    }

    public /* synthetic */ VideoImmersiveDataLoader(ImmVideoRequestEntity immVideoRequestEntity, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : immVideoRequestEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ao.b n() {
        return (ao.b) this.g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ao.b o() {
        return (ao.b) kg.c.e.a().h(ao.b.class);
    }

    @Override // am.b
    public void h(b0 b0Var) {
        j(i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new VideoImmersiveDataLoader$loadDataFromService$1(this, null), 3, (Object) null));
    }

    public final ImmVideoRequestEntity m() {
        return this.f;
    }
}
