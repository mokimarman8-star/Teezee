package com.blankj.utilcode.util;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class BusUtils {
    private static final Object a = "nULl";

    /* renamed from: com.blankj.utilcode.util.BusUtils$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ BusUtils this$0;
        final /* synthetic */ Object val$arg;
        final /* synthetic */ Object val$bus;
        final /* synthetic */ a val$busInfo;
        final /* synthetic */ boolean val$sticky;

        AnonymousClass1(BusUtils busUtils, Object obj, Object obj2, a aVar, boolean z) {
            this.val$bus = obj;
            this.val$arg = obj2;
            this.val$sticky = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            BusUtils.a(null, this.val$bus, this.val$arg, null, this.val$sticky);
        }
    }

    public enum ThreadMode {
        MAIN,
        IO,
        CPU,
        CACHED,
        SINGLE,
        POSTING
    }

    private static final class a {
    }

    static /* synthetic */ void a(BusUtils busUtils, Object obj, Object obj2, a aVar, boolean z) {
        throw null;
    }
}
