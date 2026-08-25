package com.bytedance.sdk.component.utils;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.view.View;
import java.util.concurrent.ExecutorService;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class sP {
    private static Sj Sj;

    public interface Sj {
        ExecutorService getAsyncStartActivityThreadPool();

        boolean isEnableAsyncStartActivity();
    }

    /* renamed from: com.bytedance.sdk.component.utils.sP$sP, reason: collision with other inner class name */
    public interface InterfaceC0055sP {
        void Sj();

        void Sj(Throwable th);
    }

    public static Activity Sj(View view) {
        View findViewById;
        Context context;
        if (view == null) {
            return null;
        }
        Context context2 = view.getContext();
        if (context2 instanceof Activity) {
            return (Activity) context2;
        }
        View rootView = view.getRootView();
        if (rootView == null || (findViewById = rootView.findViewById(R.id.content)) == null || (context = findViewById.getContext()) == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            if (baseContext instanceof Activity) {
                return (Activity) baseContext;
            }
        }
        return null;
    }

    public static void Sj(Sj sj) {
        Sj = sj;
    }

    public static boolean Sj(Context context, Intent intent, InterfaceC0055sP interfaceC0055sP) {
        return Sj(context, intent, interfaceC0055sP, false);
    }

    public static boolean Sj(final Context context, final Intent intent, final InterfaceC0055sP interfaceC0055sP, boolean z) {
        Sj sj;
        ExecutorService asyncStartActivityThreadPool;
        if (!z || (sj = Sj) == null || !sj.isEnableAsyncStartActivity() || (asyncStartActivityThreadPool = Sj.getAsyncStartActivityThreadPool()) == null) {
            return TKC(context, intent, interfaceC0055sP);
        }
        asyncStartActivityThreadPool.execute(new com.bytedance.sdk.component.Dq.Dq("startAct") { // from class: com.bytedance.sdk.component.utils.sP.1
            @Override // java.lang.Runnable
            public void run() {
                sP.TKC(context, intent, interfaceC0055sP);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean TKC(Context context, Intent intent, InterfaceC0055sP interfaceC0055sP) {
        if (context != null && intent != null) {
            try {
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                context.startActivity(intent);
                if (interfaceC0055sP == null) {
                    return true;
                }
                interfaceC0055sP.Sj();
                return true;
            } catch (Throwable th) {
                if (interfaceC0055sP != null) {
                    interfaceC0055sP.Sj(th);
                }
            }
        }
        return false;
    }
}
