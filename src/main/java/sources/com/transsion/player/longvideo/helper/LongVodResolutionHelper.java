package com.transsion.player.longvideo.helper;

import com.transsion.gslb.BuildConfig;
import com.transsion.player.longvideo.member.ResolutionMemberManager;
import com.transsion.player.longvideo.ui.LongVodPlayerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class LongVodResolutionHelper {
    public static final a b = new a(null);
    private String a = BuildConfig.FLAVOR;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final boolean c(ln.c cVar, String str) {
        Integer v = StringsKt.v(str);
        int intValue = v != null ? v.intValue() : 0;
        Integer v2 = StringsKt.v(cVar.e());
        int intValue2 = v2 != null ? v2.intValue() : 0;
        return intValue2 > 0 && intValue > 0 && intValue2 > intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object d(ln.a aVar, Continuation continuation) {
        LongVodResolutionHelper$getMp4DefaultPlayBean$1 longVodResolutionHelper$getMp4DefaultPlayBean$1;
        Object obj;
        int i;
        Object obj2;
        List list;
        Ref.ObjectRef objectRef;
        ln.c cVar;
        Object obj3;
        if (continuation instanceof LongVodResolutionHelper$getMp4DefaultPlayBean$1) {
            longVodResolutionHelper$getMp4DefaultPlayBean$1 = (LongVodResolutionHelper$getMp4DefaultPlayBean$1) continuation;
            int i2 = longVodResolutionHelper$getMp4DefaultPlayBean$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                longVodResolutionHelper$getMp4DefaultPlayBean$1.label = i2 - Integer.MIN_VALUE;
                obj = longVodResolutionHelper$getMp4DefaultPlayBean$1.result;
                Object f = IntrinsicsKt.f();
                i = longVodResolutionHelper$getMp4DefaultPlayBean$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    List j = aVar.j();
                    if (j.isEmpty()) {
                        return null;
                    }
                    String str = this.a;
                    if (str.length() == 0) {
                        str = com.transsion.baselib.report.launch.b.a.b().getString("key_stream_resolution", BuildConfig.FLAVOR);
                        if (str == null) {
                            str = BuildConfig.FLAVOR;
                        }
                        this.a = str;
                    }
                    a.a.f(wf.a.a, LongVodPlayerView.TAG, "getMp4DefaultPlayBean, savedResolution： " + this.a, false, 4, (Object) null);
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    List<ln.c> list2 = j;
                    for (ln.c cVar2 : list2) {
                        if (!cVar2.j()) {
                            objectRef2.element = cVar2;
                        }
                    }
                    Object obj4 = objectRef2.element;
                    if (obj4 != null) {
                        return obj4;
                    }
                    if (str.length() == 0) {
                        Iterator it = list2.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj3 = null;
                                break;
                            }
                            obj3 = it.next();
                            if (Intrinsics.c(((ln.c) obj3).e(), "480")) {
                                break;
                            }
                        }
                        objectRef2.element = (ln.c) obj3;
                    } else {
                        for (ln.c cVar3 : list2) {
                            if (Intrinsics.c(cVar3.e(), str)) {
                                objectRef2.element = cVar3;
                            }
                        }
                        if (objectRef2.element == null) {
                            Iterator it2 = list2.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    obj2 = null;
                                    break;
                                }
                                obj2 = it2.next();
                                if (c((ln.c) obj2, str)) {
                                    break;
                                }
                            }
                            objectRef2.element = (ln.c) obj2;
                        }
                    }
                    if (objectRef2.element == null) {
                        objectRef2.element = CollectionsKt.u0(j);
                    }
                    if (this.a.length() == 0 && (cVar = (ln.c) objectRef2.element) != null) {
                        g(cVar.e());
                    }
                    a.a aVar2 = wf.a.a;
                    ln.c cVar4 = (ln.c) objectRef2.element;
                    a.a.f(aVar2, LongVodPlayerView.TAG, "getMp4DefaultPlayBean, bean.resolutions： " + (cVar4 != null ? cVar4.e() : null), false, 4, (Object) null);
                    ResolutionMemberManager resolutionMemberManager = ResolutionMemberManager.a;
                    longVodResolutionHelper$getMp4DefaultPlayBean$1.L$0 = j;
                    longVodResolutionHelper$getMp4DefaultPlayBean$1.L$1 = objectRef2;
                    longVodResolutionHelper$getMp4DefaultPlayBean$1.label = 1;
                    Object f2 = resolutionMemberManager.f(aVar, longVodResolutionHelper$getMp4DefaultPlayBean$1);
                    if (f2 == f) {
                        return f;
                    }
                    list = j;
                    obj = f2;
                    objectRef = objectRef2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    objectRef = (Ref.ObjectRef) longVodResolutionHelper$getMp4DefaultPlayBean$1.L$1;
                    list = (List) longVodResolutionHelper$getMp4DefaultPlayBean$1.L$0;
                    ResultKt.b(obj);
                }
                if (!((Boolean) obj).booleanValue()) {
                    com.transsion.player.longvideo.member.r rVar = com.transsion.player.longvideo.member.r.a;
                    if (rVar.q(((ln.c) objectRef.element).e()) && !ij.o.a.i() && !ij.g.a.b()) {
                        a.a aVar3 = wf.a.a;
                        a.a.f(aVar3, "vipResolution", "getMp4DefaultPlayBean() --> 当前没有解锁，需要降级到720P以下，当前bean.resolutions = " + ((ln.c) objectRef.element).e(), false, 4, (Object) null);
                        Object obj5 = objectRef.element;
                        ((ln.c) obj5).m(((ln.c) obj5).e());
                        ln.c g = com.transsion.player.longvideo.member.r.g(rVar, list, 0, 2, null);
                        objectRef.element = g;
                        a.a.f(aVar3, "vipResolution", "getMp4DefaultPlayBean() --> 降级后的bean.resolutions = " + (g != null ? g.e() : null), false, 4, (Object) null);
                    }
                }
                return objectRef.element;
            }
        }
        longVodResolutionHelper$getMp4DefaultPlayBean$1 = new LongVodResolutionHelper$getMp4DefaultPlayBean$1(this, continuation);
        obj = longVodResolutionHelper$getMp4DefaultPlayBean$1.result;
        Object f3 = IntrinsicsKt.f();
        i = longVodResolutionHelper$getMp4DefaultPlayBean$1.label;
        if (i != 0) {
        }
        if (!((Boolean) obj).booleanValue()) {
        }
        return objectRef.element;
    }

    public final Object b(ln.a aVar, Continuation continuation) {
        if (aVar.j().isEmpty()) {
            return null;
        }
        ln.c cVar = (ln.c) CollectionsKt.i0(aVar.j());
        com.transsion.player.longvideo.member.k.a.a("LongVodResolutionHelper --> getDefaultPlayStream() --> 是MP4格式 = " + aVar.w());
        return aVar.w() ? d(aVar, continuation) : cVar;
    }

    public final ln.c e(ln.a aVar, ln.b bVar) {
        Intrinsics.h(aVar, "bean");
        Intrinsics.h(bVar, "config");
        for (ln.c cVar : aVar.j()) {
            if (StringsKt.c0(bVar.d(), cVar.e(), false, 2, (Object) null)) {
                return cVar;
            }
        }
        return null;
    }

    public final List f(ln.c cVar, List list) {
        Intrinsics.h(cVar, "playStream");
        Intrinsics.h(list, "mp4Streams");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ln.c cVar2 = (ln.c) it.next();
            arrayList.add(new ln.b(Intrinsics.c(cVar2.e(), cVar.e()), cVar2.e() + "P", null, 4, null));
        }
        return arrayList;
    }

    public final void g(String str) {
        Intrinsics.h(str, "resolution");
        a.a.f(wf.a.a, LongVodPlayerView.TAG, "save, resolution： " + str, false, 4, (Object) null);
        this.a = str;
        com.transsion.baselib.report.launch.b.a.b().putString("key_stream_resolution", str);
    }
}
