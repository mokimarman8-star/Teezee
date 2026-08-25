package com.transsion.home.adapter.suboperate.provider;

import com.transsion.edcation.CourseManager;
import com.transsion.edcation.bean.CourseBean;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.bean.BannerBean;
import com.transsion.home.bean.BannerData;
import com.transsion.home.bean.OperateItem;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.flow.w0;
import kotlinx.coroutines.y0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.home.adapter.suboperate.provider.SubHorizontalBannerProvider$registerCourse$1", f = "SubHorizontalBannerProvider.kt", l = {129}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class SubHorizontalBannerProvider$registerCourse$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SubHorizontalBannerProvider this$0;

    /* renamed from: com.transsion.home.adapter.suboperate.provider.SubHorizontalBannerProvider$registerCourse$1$1, reason: invalid class name */
    static final class AnonymousClass1 implements kotlinx.coroutines.flow.b {
        final /* synthetic */ SubHorizontalBannerProvider a;

        AnonymousClass1(SubHorizontalBannerProvider subHorizontalBannerProvider) {
            this.a = subHorizontalBannerProvider;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00b0 -> B:10:0x00b3). Please report as a decompilation issue!!! */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(CourseBean courseBean, Continuation continuation) {
            SubHorizontalBannerProvider$registerCourse$1$1$emit$1 subHorizontalBannerProvider$registerCourse$1$1$emit$1;
            int i;
            OperateItem operateItem;
            BannerBean banner;
            List<BannerData> banners;
            int i2;
            Iterator it;
            SubHorizontalBannerProvider subHorizontalBannerProvider;
            if (continuation instanceof SubHorizontalBannerProvider$registerCourse$1$1$emit$1) {
                subHorizontalBannerProvider$registerCourse$1$1$emit$1 = (SubHorizontalBannerProvider$registerCourse$1$1$emit$1) continuation;
                int i3 = subHorizontalBannerProvider$registerCourse$1$1$emit$1.label;
                if ((i3 & Integer.MIN_VALUE) != 0) {
                    subHorizontalBannerProvider$registerCourse$1$1$emit$1.label = i3 - Integer.MIN_VALUE;
                    Object obj = subHorizontalBannerProvider$registerCourse$1$1$emit$1.result;
                    Object f = IntrinsicsKt.f();
                    i = subHorizontalBannerProvider$registerCourse$1$1$emit$1.label;
                    if (i != 0) {
                        ResultKt.b(obj);
                        operateItem = this.a.o;
                        if (operateItem != null && (banner = operateItem.getBanner()) != null && (banners = banner.getBanners()) != null) {
                            SubHorizontalBannerProvider subHorizontalBannerProvider2 = this.a;
                            i2 = 0;
                            it = banners.iterator();
                            subHorizontalBannerProvider = subHorizontalBannerProvider2;
                            while (it.hasNext()) {
                            }
                        }
                        return Unit.a;
                    }
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i4 = subHorizontalBannerProvider$registerCourse$1$1$emit$1.I$0;
                    it = (Iterator) subHorizontalBannerProvider$registerCourse$1$1$emit$1.L$2;
                    SubHorizontalBannerProvider subHorizontalBannerProvider3 = (SubHorizontalBannerProvider) subHorizontalBannerProvider$registerCourse$1$1$emit$1.L$1;
                    CourseBean courseBean2 = (CourseBean) subHorizontalBannerProvider$registerCourse$1$1$emit$1.L$0;
                    ResultKt.b(obj);
                    subHorizontalBannerProvider = subHorizontalBannerProvider3;
                    i2 = i4;
                    courseBean = courseBean2;
                    while (it.hasNext()) {
                        Object next = it.next();
                        int i5 = i2 + 1;
                        if (i2 < 0) {
                            CollectionsKt.u();
                        }
                        BannerData bannerData = (BannerData) next;
                        if (Intrinsics.c(courseBean.getSubjectId(), bannerData != null ? bannerData.getSubjectId() : null)) {
                            if (bannerData != null) {
                                bannerData.setSeenStatus(Boxing.d(courseBean.getSeenStatus()));
                            }
                            a2 c = y0.c();
                            SubHorizontalBannerProvider$registerCourse$1$1$1$1 subHorizontalBannerProvider$registerCourse$1$1$1$1 = new SubHorizontalBannerProvider$registerCourse$1$1$1$1(subHorizontalBannerProvider, null);
                            subHorizontalBannerProvider$registerCourse$1$1$emit$1.L$0 = courseBean;
                            subHorizontalBannerProvider$registerCourse$1$1$emit$1.L$1 = subHorizontalBannerProvider;
                            subHorizontalBannerProvider$registerCourse$1$1$emit$1.L$2 = it;
                            subHorizontalBannerProvider$registerCourse$1$1$emit$1.I$0 = i5;
                            subHorizontalBannerProvider$registerCourse$1$1$emit$1.label = 1;
                            if (kotlinx.coroutines.i.g(c, subHorizontalBannerProvider$registerCourse$1$1$1$1, subHorizontalBannerProvider$registerCourse$1$1$emit$1) == f) {
                                return f;
                            }
                            courseBean2 = courseBean;
                            subHorizontalBannerProvider3 = subHorizontalBannerProvider;
                            i4 = i5;
                            subHorizontalBannerProvider = subHorizontalBannerProvider3;
                            i2 = i4;
                            courseBean = courseBean2;
                            while (it.hasNext()) {
                            }
                        } else {
                            i2 = i5;
                        }
                    }
                    return Unit.a;
                }
            }
            subHorizontalBannerProvider$registerCourse$1$1$emit$1 = new SubHorizontalBannerProvider$registerCourse$1$1$emit$1(this, continuation);
            Object obj2 = subHorizontalBannerProvider$registerCourse$1$1$emit$1.result;
            Object f2 = IntrinsicsKt.f();
            i = subHorizontalBannerProvider$registerCourse$1$1$emit$1.label;
            if (i != 0) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SubHorizontalBannerProvider$registerCourse$1(SubHorizontalBannerProvider subHorizontalBannerProvider, Continuation<? super SubHorizontalBannerProvider$registerCourse$1> continuation) {
        super(2, continuation);
        this.this$0 = subHorizontalBannerProvider;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubHorizontalBannerProvider$registerCourse$1(this.this$0, continuation);
    }

    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            w0 j = CourseManager.a.j();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0);
            this.label = 1;
            if (j.a(anonymousClass1, this) == f) {
                return f;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        throw new KotlinNothingValueException();
    }
}
