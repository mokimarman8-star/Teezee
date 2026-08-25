package com.therouter.inject;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.therouter.TheRouterKt;
import dalvik.system.DexFile;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class DebugOnlyKt {
    private static final ArrayList a = new ArrayList();
    private static final ArrayList b = new ArrayList();
    private static final HashMap c = new HashMap();
    private static volatile int d = -1;

    public static final void a(Context context) {
        Enumeration<String> entries;
        if (context == null || d >= 0) {
            return;
        }
        d = 0;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
            Intrinsics.g(applicationInfo, "getApplicationInfo(...)");
            entries = new DexFile(applicationInfo.sourceDir).entries();
        } catch (Exception e) {
            TheRouterKt.c("RouterInject", "getAllDI error", new Function0<Unit>() { // from class: com.therouter.inject.DebugOnlyKt$getAllDI$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m69invoke();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m69invoke() {
                    e.printStackTrace();
                }
            });
            return;
        }
        while (entries.hasMoreElements()) {
            String nextElement = entries.nextElement();
            Intrinsics.e(nextElement);
            if (StringsKt.W(nextElement, "a.ServiceProvider__TheRouter__", false, 2, (Object) null) && !StringsKt.c0(nextElement, "$", false, 2, (Object) null)) {
                try {
                    Class<?> cls = Class.forName(nextElement);
                    if (b.class.isAssignableFrom(cls) && !Intrinsics.c(b.class, cls)) {
                        ArrayList arrayList = a;
                        Object newInstance = cls.newInstance();
                        Intrinsics.f(newInstance, "null cannot be cast to non-null type com.therouter.inject.Interceptor");
                        arrayList.add((b) newInstance);
                    }
                } catch (Exception e2) {
                    TheRouterKt.c("RouterInject", "create class error for " + nextElement, new Function0<Unit>() { // from class: com.therouter.inject.DebugOnlyKt$getAllDI$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m66invoke();
                            return Unit.a;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m66invoke() {
                            e2.printStackTrace();
                        }
                    });
                }
            } else if (StringsKt.W(nextElement, "a.RouterMap__TheRouter__", false, 2, (Object) null) && !StringsKt.c0(nextElement, "$", false, 2, (Object) null)) {
                try {
                    Class<?> cls2 = Class.forName(nextElement);
                    if (com.therouter.router.d.class.isAssignableFrom(cls2) && !Intrinsics.c(com.therouter.router.d.class, cls2)) {
                        ArrayList arrayList2 = b;
                        Object newInstance2 = cls2.newInstance();
                        Intrinsics.f(newInstance2, "null cannot be cast to non-null type com.therouter.router.IRouterMapAPT");
                        arrayList2.add((com.therouter.router.d) newInstance2);
                    }
                } catch (Exception e3) {
                    TheRouterKt.c("RouterInject", "create class error for " + nextElement, new Function0<Unit>() { // from class: com.therouter.inject.DebugOnlyKt$getAllDI$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m67invoke();
                            return Unit.a;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m67invoke() {
                            e3.printStackTrace();
                        }
                    });
                }
            } else if (StringsKt.G(nextElement, "__TheRouter__Autowired", false, 2, (Object) null) && !StringsKt.c0(nextElement, "$", false, 2, (Object) null)) {
                try {
                    Class<?> cls3 = Class.forName(nextElement);
                    Class<?> cls4 = Class.forName(StringsKt.Q(nextElement, "__TheRouter__Autowired", TtmlNode.ANONYMOUS_REGION_ID, false, 4, (Object) null));
                    HashMap hashMap = c;
                    Intrinsics.e(cls4);
                    Method declaredMethod = cls3.getDeclaredMethod("autowiredInject", Object.class);
                    Intrinsics.g(declaredMethod, "getDeclaredMethod(...)");
                    hashMap.put(cls4, declaredMethod);
                } catch (Exception e4) {
                    TheRouterKt.c("RouterInject", "create class error for " + nextElement, new Function0<Unit>() { // from class: com.therouter.inject.DebugOnlyKt$getAllDI$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m68invoke();
                            return Unit.a;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m68invoke() {
                            e4.printStackTrace();
                        }
                    });
                }
            }
            TheRouterKt.c("RouterInject", "getAllDI error", new Function0<Unit>() { // from class: com.therouter.inject.DebugOnlyKt$getAllDI$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m69invoke();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m69invoke() {
                    e.printStackTrace();
                }
            });
            return;
        }
        d = 1;
    }

    public static final HashMap b() {
        return c;
    }

    public static final ArrayList c() {
        return b;
    }

    public static final ArrayList d() {
        return a;
    }
}
