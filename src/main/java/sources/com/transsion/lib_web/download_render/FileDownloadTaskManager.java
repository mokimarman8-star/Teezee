package com.transsion.lib_web.download_render;

import android.app.Application;
import com.tn.lib.logger.xlog.LogType;
import com.transsion.lib_web.download_render.data.PageData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.m1;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import pl.h;
import xf.c;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class FileDownloadTaskManager {
    public static final FileDownloadTaskManager a = new FileDownloadTaskManager();
    private static final AtomicBoolean b = new AtomicBoolean(false);
    private static AtomicLong c = new AtomicLong(1);
    private static final kotlinx.coroutines.sync.a d = kotlinx.coroutines.sync.g.b(false, 1, (Object) null);
    private static final n0 e;
    private static final n0 f;
    private static final LinkedHashMap g;
    private static final AtomicBoolean h;
    private static String i;
    private static d j;
    private static final List k;

    public static final class a implements d {
        a() {
        }

        @Override // com.transsion.lib_web.download_render.d
        public void a(String str) {
            Intrinsics.h(str, "url");
            FileDownloadTaskManager.i = str;
        }

        @Override // com.transsion.lib_web.download_render.d
        public void b() {
            FileDownloadTaskManager.i = null;
        }
    }

    static {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.g(newSingleThreadExecutor, "newSingleThreadExecutor(...)");
        e = o0.a(m1.c(newSingleThreadExecutor));
        f = o0.a(y0.b());
        g = new LinkedHashMap();
        h = new AtomicBoolean(false);
        j = new a();
        k = new ArrayList();
    }

    private FileDownloadTaskManager() {
    }

    private final void k() {
        h hVar = h.a;
        AtomicBoolean atomicBoolean = h;
        hVar.a("DR_FileDownloadTaskManager", "<startDownloadExecution> isDownloadRunning value: " + atomicBoolean.get() + ", if value is true -> can't load download");
        if (atomicBoolean.compareAndSet(false, true)) {
            i.d(f, (CoroutineContext) null, (CoroutineStart) null, new FileDownloadTaskManager$startDownloadExecution$1(null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02b4 A[Catch: all -> 0x00e3, LOOP:5: B:102:0x02ae->B:104:0x02b4, LOOP_END, TryCatch #0 {all -> 0x00e3, blocks: (B:11:0x0063, B:12:0x007a, B:14:0x0080, B:17:0x0090, B:18:0x00ac, B:20:0x00b2, B:22:0x00de, B:27:0x00ef, B:29:0x00f9, B:33:0x0103, B:35:0x010d, B:37:0x0113, B:38:0x0119, B:40:0x011f, B:41:0x0130, B:53:0x0145, B:54:0x0152, B:56:0x0158, B:59:0x0172, B:64:0x017a, B:65:0x017e, B:68:0x018c, B:70:0x01a6, B:72:0x01b2, B:74:0x01b8, B:76:0x01c0, B:78:0x01c6, B:80:0x01ce, B:82:0x01d4, B:84:0x01dc, B:86:0x01e2, B:88:0x01e8, B:96:0x021a, B:97:0x021e, B:99:0x0224, B:101:0x0291, B:102:0x02ae, B:104:0x02b4, B:106:0x02cd), top: B:10:0x0063 }] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0080 A[Catch: all -> 0x00e3, TRY_LEAVE, TryCatch #0 {all -> 0x00e3, blocks: (B:11:0x0063, B:12:0x007a, B:14:0x0080, B:17:0x0090, B:18:0x00ac, B:20:0x00b2, B:22:0x00de, B:27:0x00ef, B:29:0x00f9, B:33:0x0103, B:35:0x010d, B:37:0x0113, B:38:0x0119, B:40:0x011f, B:41:0x0130, B:53:0x0145, B:54:0x0152, B:56:0x0158, B:59:0x0172, B:64:0x017a, B:65:0x017e, B:68:0x018c, B:70:0x01a6, B:72:0x01b2, B:74:0x01b8, B:76:0x01c0, B:78:0x01c6, B:80:0x01ce, B:82:0x01d4, B:84:0x01dc, B:86:0x01e2, B:88:0x01e8, B:96:0x021a, B:97:0x021e, B:99:0x0224, B:101:0x0291, B:102:0x02ae, B:104:0x02b4, B:106:0x02cd), top: B:10:0x0063 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0158 A[Catch: all -> 0x00e3, TryCatch #0 {all -> 0x00e3, blocks: (B:11:0x0063, B:12:0x007a, B:14:0x0080, B:17:0x0090, B:18:0x00ac, B:20:0x00b2, B:22:0x00de, B:27:0x00ef, B:29:0x00f9, B:33:0x0103, B:35:0x010d, B:37:0x0113, B:38:0x0119, B:40:0x011f, B:41:0x0130, B:53:0x0145, B:54:0x0152, B:56:0x0158, B:59:0x0172, B:64:0x017a, B:65:0x017e, B:68:0x018c, B:70:0x01a6, B:72:0x01b2, B:74:0x01b8, B:76:0x01c0, B:78:0x01c6, B:80:0x01ce, B:82:0x01d4, B:84:0x01dc, B:86:0x01e2, B:88:0x01e8, B:96:0x021a, B:97:0x021e, B:99:0x0224, B:101:0x0291, B:102:0x02ae, B:104:0x02b4, B:106:0x02cd), top: B:10:0x0063 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x018c A[Catch: all -> 0x00e3, TRY_ENTER, TryCatch #0 {all -> 0x00e3, blocks: (B:11:0x0063, B:12:0x007a, B:14:0x0080, B:17:0x0090, B:18:0x00ac, B:20:0x00b2, B:22:0x00de, B:27:0x00ef, B:29:0x00f9, B:33:0x0103, B:35:0x010d, B:37:0x0113, B:38:0x0119, B:40:0x011f, B:41:0x0130, B:53:0x0145, B:54:0x0152, B:56:0x0158, B:59:0x0172, B:64:0x017a, B:65:0x017e, B:68:0x018c, B:70:0x01a6, B:72:0x01b2, B:74:0x01b8, B:76:0x01c0, B:78:0x01c6, B:80:0x01ce, B:82:0x01d4, B:84:0x01dc, B:86:0x01e2, B:88:0x01e8, B:96:0x021a, B:97:0x021e, B:99:0x0224, B:101:0x0291, B:102:0x02ae, B:104:0x02b4, B:106:0x02cd), top: B:10:0x0063 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0224 A[Catch: all -> 0x00e3, LOOP:4: B:97:0x021e->B:99:0x0224, LOOP_END, TryCatch #0 {all -> 0x00e3, blocks: (B:11:0x0063, B:12:0x007a, B:14:0x0080, B:17:0x0090, B:18:0x00ac, B:20:0x00b2, B:22:0x00de, B:27:0x00ef, B:29:0x00f9, B:33:0x0103, B:35:0x010d, B:37:0x0113, B:38:0x0119, B:40:0x011f, B:41:0x0130, B:53:0x0145, B:54:0x0152, B:56:0x0158, B:59:0x0172, B:64:0x017a, B:65:0x017e, B:68:0x018c, B:70:0x01a6, B:72:0x01b2, B:74:0x01b8, B:76:0x01c0, B:78:0x01c6, B:80:0x01ce, B:82:0x01d4, B:84:0x01dc, B:86:0x01e2, B:88:0x01e8, B:96:0x021a, B:97:0x021e, B:99:0x0224, B:101:0x0291, B:102:0x02ae, B:104:0x02b4, B:106:0x02cd), top: B:10:0x0063 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m(List list, Continuation continuation) {
        FileDownloadTaskManager$updateTask$1 fileDownloadTaskManager$updateTask$1;
        int i2;
        List list2;
        kotlinx.coroutines.sync.a aVar;
        FileDownloadTaskManager fileDownloadTaskManager;
        Object obj;
        Iterator it;
        Iterator it2;
        Iterator it3;
        PageData a2;
        PageData a3;
        PageData a4;
        PageData a5;
        LinkedHashSet linkedHashSet;
        PageData a6;
        try {
            if (continuation instanceof FileDownloadTaskManager$updateTask$1) {
                fileDownloadTaskManager$updateTask$1 = (FileDownloadTaskManager$updateTask$1) continuation;
                int i3 = fileDownloadTaskManager$updateTask$1.label;
                if ((i3 & Integer.MIN_VALUE) != 0) {
                    fileDownloadTaskManager$updateTask$1.label = i3 - Integer.MIN_VALUE;
                    Object obj2 = fileDownloadTaskManager$updateTask$1.result;
                    Object f2 = IntrinsicsKt.f();
                    i2 = fileDownloadTaskManager$updateTask$1.label;
                    Object obj3 = null;
                    if (i2 != 0) {
                        ResultKt.b(obj2);
                        h.a.a("DR_FileDownloadTaskManager", "<updateTask> start");
                        kotlinx.coroutines.sync.a aVar2 = d;
                        fileDownloadTaskManager$updateTask$1.L$0 = this;
                        list2 = list;
                        fileDownloadTaskManager$updateTask$1.L$1 = list2;
                        fileDownloadTaskManager$updateTask$1.L$2 = aVar2;
                        fileDownloadTaskManager$updateTask$1.label = 1;
                        if (aVar2.f((Object) null, fileDownloadTaskManager$updateTask$1) == f2) {
                            return f2;
                        }
                        aVar = aVar2;
                        fileDownloadTaskManager = this;
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        aVar = (kotlinx.coroutines.sync.a) fileDownloadTaskManager$updateTask$1.L$2;
                        list2 = (List) fileDownloadTaskManager$updateTask$1.L$1;
                        fileDownloadTaskManager = (FileDownloadTaskManager) fileDownloadTaskManager$updateTask$1.L$0;
                        ResultKt.b(obj2);
                    }
                    LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                    LinkedHashSet linkedHashSet3 = new LinkedHashSet();
                    LinkedHashSet linkedHashSet4 = new LinkedHashSet();
                    int i4 = 0;
                    for (Object obj4 : list2) {
                        int i5 = i4 + 1;
                        if (i4 < 0) {
                            try {
                                CollectionsKt.u();
                            } catch (Throwable th2) {
                                th = th2;
                                obj = obj3;
                                aVar.unlock(obj);
                                throw th;
                            }
                        }
                        PageData pageData = (PageData) obj4;
                        Ref.ObjectRef objectRef = new Ref.ObjectRef();
                        Ref.LongRef longRef = new Ref.LongRef();
                        FileDownloadTaskManager fileDownloadTaskManager2 = fileDownloadTaskManager;
                        longRef.element = -1L;
                        for (Map.Entry entry : g.entrySet()) {
                            LinkedHashSet linkedHashSet5 = linkedHashSet3;
                            long longValue = ((Number) entry.getKey()).longValue();
                            tl.a aVar3 = (tl.a) entry.getValue();
                            if (Intrinsics.c(aVar3.a().getUrl(), pageData.getUrl())) {
                                objectRef.element = aVar3;
                                longRef.element = longValue;
                            }
                            linkedHashSet3 = linkedHashSet5;
                        }
                        LinkedHashSet linkedHashSet6 = linkedHashSet3;
                        if (longRef.element == -1) {
                            linkedHashSet4.add(Boxing.d(i4));
                        } else {
                            String versionCode = pageData.getVersionCode();
                            tl.a aVar4 = (tl.a) objectRef.element;
                            if (Intrinsics.c(versionCode, (aVar4 == null || (a6 = aVar4.a()) == null) ? null : a6.getVersionCode())) {
                                linkedHashSet = linkedHashSet6;
                                linkedHashSet.add(Boxing.e(longRef.element));
                                fileDownloadTaskManager = fileDownloadTaskManager2;
                                linkedHashSet3 = linkedHashSet;
                                i4 = i5;
                                obj3 = null;
                            } else {
                                linkedHashSet2.add(Boxing.e(longRef.element));
                                linkedHashSet4.add(Boxing.d(i4));
                            }
                        }
                        linkedHashSet = linkedHashSet6;
                        fileDownloadTaskManager = fileDownloadTaskManager2;
                        linkedHashSet3 = linkedHashSet;
                        i4 = i5;
                        obj3 = null;
                    }
                    FileDownloadTaskManager fileDownloadTaskManager3 = fileDownloadTaskManager;
                    LinkedHashSet linkedHashSet7 = linkedHashSet3;
                    it = g.entrySet().iterator();
                    while (it.hasNext()) {
                        long longValue2 = ((Number) ((Map.Entry) it.next()).getKey()).longValue();
                        if (!linkedHashSet7.contains(Boxing.e(longValue2))) {
                            linkedHashSet2.add(Boxing.e(longValue2));
                        }
                    }
                    for (it2 = linkedHashSet2.iterator(); it2.hasNext(); it2 = it2) {
                        tl.a aVar5 = (tl.a) g.remove(Boxing.e(((Number) it2.next()).longValue()));
                        h.a.a("DR_FileDownloadTaskManager", "<updateTask> downloadTaskQueue 移除掉的任务 taskId: " + (aVar5 != null ? Boxing.e(aVar5.b()) : null) + ", url:" + ((aVar5 == null || (a5 = aVar5.a()) == null) ? null : a5.getUrl()) + ", versionCode:" + ((aVar5 == null || (a4 = aVar5.a()) == null) ? null : a4.getVersionCode()) + ", priority:" + ((aVar5 == null || (a3 = aVar5.a()) == null) ? null : a3.getPriority()) + ", manifestUrl:" + ((aVar5 == null || (a2 = aVar5.a()) == null) ? null : a2.getManifestUrl()));
                    }
                    it3 = linkedHashSet4.iterator();
                    while (it3.hasNext()) {
                        int intValue = ((Number) it3.next()).intValue();
                        long andAdd = c.getAndAdd(1L);
                        PageData pageData2 = (PageData) list2.get(intValue);
                        h.a.a("DR_FileDownloadTaskManager", "<updateTask> downloadTaskQueue 添加新任务 taskId: " + andAdd + ", url:" + pageData2.getUrl() + ", versionCode:" + pageData2.getVersionCode() + ", priority:" + pageData2.getPriority() + ", manifestUrl:" + pageData2.getManifestUrl());
                        g.put(Boxing.e(andAdd), new tl.a(andAdd, pageData2));
                        it3 = it3;
                        list2 = list2;
                    }
                    LinkedHashMap linkedHashMap = g;
                    Collection values = linkedHashMap.values();
                    Intrinsics.g(values, "<get-values>(...)");
                    List I0 = CollectionsKt.I0(values, new Comparator() { // from class: com.transsion.lib_web.download_render.FileDownloadTaskManager$updateTask$lambda$9$$inlined$sortedByDescending$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            Long priority = ((tl.a) t2).a().getPriority();
                            Long valueOf = Long.valueOf(priority != null ? priority.longValue() : Long.MIN_VALUE);
                            Long priority2 = ((tl.a) t).a().getPriority();
                            return ComparisonsKt.d(valueOf, Long.valueOf(priority2 != null ? priority2.longValue() : Long.MIN_VALUE));
                        }
                    });
                    linkedHashMap.clear();
                    for (Object obj5 : I0) {
                        Intrinsics.g(obj5, "next(...)");
                        tl.a aVar6 = (tl.a) obj5;
                        g.put(Boxing.e(aVar6.b()), aVar6);
                    }
                    Unit unit = Unit.a;
                    aVar.unlock((Object) null);
                    fileDownloadTaskManager3.k();
                    return Unit.a;
                }
            }
            LinkedHashSet linkedHashSet22 = new LinkedHashSet();
            LinkedHashSet linkedHashSet32 = new LinkedHashSet();
            LinkedHashSet linkedHashSet42 = new LinkedHashSet();
            int i42 = 0;
            while (r10.hasNext()) {
            }
            FileDownloadTaskManager fileDownloadTaskManager32 = fileDownloadTaskManager;
            LinkedHashSet linkedHashSet72 = linkedHashSet32;
            it = g.entrySet().iterator();
            while (it.hasNext()) {
            }
            while (it2.hasNext()) {
            }
            it3 = linkedHashSet42.iterator();
            while (it3.hasNext()) {
            }
            LinkedHashMap linkedHashMap2 = g;
            Collection values2 = linkedHashMap2.values();
            Intrinsics.g(values2, "<get-values>(...)");
            List I02 = CollectionsKt.I0(values2, new Comparator() { // from class: com.transsion.lib_web.download_render.FileDownloadTaskManager$updateTask$lambda$9$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    Long priority = ((tl.a) t2).a().getPriority();
                    Long valueOf = Long.valueOf(priority != null ? priority.longValue() : Long.MIN_VALUE);
                    Long priority2 = ((tl.a) t).a().getPriority();
                    return ComparisonsKt.d(valueOf, Long.valueOf(priority2 != null ? priority2.longValue() : Long.MIN_VALUE));
                }
            });
            linkedHashMap2.clear();
            while (r0.hasNext()) {
            }
            Unit unit2 = Unit.a;
            aVar.unlock((Object) null);
            fileDownloadTaskManager32.k();
            return Unit.a;
        } catch (Throwable th3) {
            th = th3;
            obj = null;
        }
        fileDownloadTaskManager$updateTask$1 = new FileDownloadTaskManager$updateTask$1(this, continuation);
        Object obj22 = fileDownloadTaskManager$updateTask$1.result;
        Object f22 = IntrinsicsKt.f();
        i2 = fileDownloadTaskManager$updateTask$1.label;
        Object obj32 = null;
        if (i2 != 0) {
        }
    }

    public final void g(List list) {
        if (!b.get()) {
            h.a.b("DR_FileDownloadTaskManager", "<executeTask> fail, plz init first");
            return;
        }
        if (list != null) {
            if (list.isEmpty()) {
                list = null;
            }
            if (list != null && i.d(e, (CoroutineContext) null, (CoroutineStart) null, new FileDownloadTaskManager$executeTask$2$1(list, null), 3, (Object) null) != null) {
                return;
            }
        }
        h.a.f("DR_FileDownloadTaskManager", "<executeTask> fail: h5Pages is null or empty");
        Unit unit = Unit.a;
    }

    public final d h() {
        return j;
    }

    public final String i() {
        return i;
    }

    public final void j(Application application, boolean z, boolean z2, boolean z3, qi.i iVar, String str) {
        Intrinsics.h(application, "context");
        Intrinsics.h(iVar, "api");
        Intrinsics.h(str, "path");
        if (z2) {
            c.a.g(xf.c.a, application, LogType.TYPE_LOGCAT, z3, (String) null, 0L, 24, (Object) null);
        }
        if (!b.compareAndSet(false, true)) {
            h.a.f("DR_FileDownloadTaskManager", "<init> already done");
        } else {
            h.a.a("DR_FileDownloadTaskManager", "<init> start");
            i.d(e, (CoroutineContext) null, (CoroutineStart) null, new FileDownloadTaskManager$init$1(str, application, z, iVar, null), 3, (Object) null);
        }
    }

    public final void l() {
        new com.transsion.lib_web.download_render.init.b().invoke();
    }
}
