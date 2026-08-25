package com.cloud.sdk.commonutil.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import java.lang.reflect.Field;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class HSToastUtil {
    private static Handler a = new Handler(Looper.getMainLooper());
    private static Toast b = null;
    private static Field c;
    private static Field d;

    /* renamed from: com.cloud.sdk.commonutil.util.HSToastUtil$3, reason: invalid class name */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ Context val$context;
        final /* synthetic */ int val$resId;

        AnonymousClass3(int i, Context context) {
            this.val$resId = i;
            this.val$context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (HSToastUtil.b != null) {
                HSToastUtil.b.setText(this.val$resId);
                HSToastUtil.b.setDuration(1);
                HSToastUtil.d(HSToastUtil.b);
            } else {
                Toast unused = HSToastUtil.b = Toast.makeText(this.val$context.getApplicationContext(), this.val$resId, 1);
            }
            HSToastUtil.b.show();
        }
    }

    /* renamed from: com.cloud.sdk.commonutil.util.HSToastUtil$4, reason: invalid class name */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ Context val$context;
        final /* synthetic */ String val$text;

        AnonymousClass4(String str, Context context) {
            this.val$text = str;
            this.val$context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (HSToastUtil.b != null) {
                HSToastUtil.b.setText(this.val$text);
                HSToastUtil.b.setDuration(1);
                HSToastUtil.d(HSToastUtil.b);
            } else {
                Toast unused = HSToastUtil.b = Toast.makeText(this.val$context.getApplicationContext(), this.val$text, 1);
            }
            HSToastUtil.b.show();
        }
    }

    private static class a extends Handler {
        private Handler a;

        a(Handler handler) {
            this.a = handler;
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            try {
                super.dispatchMessage(message);
            } catch (Exception e) {
                c.Log().e("ssp", "dispatchMessage error: " + Log.getStackTraceString(e));
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.a.handleMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Toast toast) {
        try {
            Object obj = c.get(toast);
            Handler handler = (Handler) d.get(obj);
            if (handler != null && !(handler instanceof a)) {
                d.set(obj, new a(handler));
            }
        } catch (Exception e) {
            c.Log().e("ssp", "toast hook error: " + Log.getStackTraceString(e));
        }
        try {
            Field declaredField = Toast.class.getDeclaredField("mTN");
            c = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = c.getType().getDeclaredField("mHandler");
            d = declaredField2;
            declaredField2.setAccessible(true);
        } catch (Exception e2) {
            c.Log().e("ssp", "toast static init error: " + Log.getStackTraceString(e2));
        }
    }

    public static void e(final int i) {
        final Context a2 = e.a();
        if (i > 0) {
            a.post(new Runnable() { // from class: com.cloud.sdk.commonutil.util.HSToastUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    if (HSToastUtil.b != null) {
                        HSToastUtil.b.setText(i);
                        HSToastUtil.b.setDuration(0);
                        HSToastUtil.d(HSToastUtil.b);
                    } else {
                        Toast unused = HSToastUtil.b = Toast.makeText(a2.getApplicationContext(), i, 0);
                    }
                    HSToastUtil.b.show();
                }
            });
        }
    }

    public static void f(final String str) {
        final Context a2 = e.a();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a.post(new Runnable() { // from class: com.cloud.sdk.commonutil.util.HSToastUtil.2
            @Override // java.lang.Runnable
            public void run() {
                if (HSToastUtil.b != null) {
                    HSToastUtil.b.setText(str);
                    HSToastUtil.b.setDuration(0);
                    HSToastUtil.d(HSToastUtil.b);
                } else {
                    Toast unused = HSToastUtil.b = Toast.makeText(a2.getApplicationContext(), str, 0);
                }
                HSToastUtil.b.show();
            }
        });
    }
}
