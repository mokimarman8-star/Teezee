package com.cloud.tmc.miniapp.action;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface HandlerAction {
    public static final Companion Companion = Companion.$$INSTANCE;

    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Handler HANDLER = new Handler(Looper.getMainLooper());

        private Companion() {
        }

        public final Handler getHANDLER() {
            return HANDLER;
        }
    }

    public static final class DefaultImpls {
        public static Handler getHandler(HandlerAction handlerAction) {
            return HandlerAction.Companion.getHANDLER();
        }

        public static boolean post(HandlerAction handlerAction, Runnable runnable) {
            Intrinsics.h(runnable, "runnable");
            return handlerAction.postDelayed(runnable, 0L);
        }

        public static boolean postAtTime(HandlerAction handlerAction, Runnable runnable, long j) {
            Intrinsics.h(runnable, "runnable");
            return HandlerAction.Companion.getHANDLER().postAtTime(runnable, handlerAction, j);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean postDelayed(HandlerAction handlerAction, Object obj, long j, Runnable runnable) {
            Intrinsics.h(runnable, "runnable");
            Handler handler = HandlerAction.Companion.getHANDLER();
            if (obj != 0) {
                handlerAction = obj;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            if (j < 0) {
                j = 0;
            }
            return handler.postAtTime(runnable, handlerAction, uptimeMillis + j);
        }

        public static boolean postDelayed(HandlerAction handlerAction, Runnable runnable, long j) {
            Intrinsics.h(runnable, "runnable");
            long uptimeMillis = SystemClock.uptimeMillis();
            if (j < 0) {
                j = 0;
            }
            return handlerAction.postAtTime(runnable, uptimeMillis + j);
        }

        public static void removeCallbacks(HandlerAction handlerAction) {
            HandlerAction.Companion.getHANDLER().removeCallbacksAndMessages(handlerAction);
        }

        public static void removeCallbacks(HandlerAction handlerAction, Runnable runnable) {
            Intrinsics.h(runnable, "runnable");
            HandlerAction.Companion.getHANDLER().removeCallbacks(runnable);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static void removeCallbacksAndMessages(HandlerAction handlerAction, Object obj) {
            Handler handler = HandlerAction.Companion.getHANDLER();
            if (obj != 0) {
                handlerAction = obj;
            }
            handler.removeCallbacksAndMessages(handlerAction);
        }
    }

    Handler getHandler();

    boolean post(Runnable runnable);

    boolean postAtTime(Runnable runnable, long j);

    boolean postDelayed(Object obj, long j, Runnable runnable);

    boolean postDelayed(Runnable runnable, long j);

    void removeCallbacks();

    void removeCallbacks(Runnable runnable);

    void removeCallbacksAndMessages(Object obj);
}
