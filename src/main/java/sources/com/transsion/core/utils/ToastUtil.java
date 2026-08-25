package com.transsion.core.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import java.lang.reflect.Field;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class ToastUtil {
    private static Handler a = new Handler(Looper.getMainLooper());
    private static Toast b = null;
    private static Field c;
    private static Field d;

    /* renamed from: com.transsion.core.utils.ToastUtil$3, reason: invalid class name */
    final class AnonymousClass3 implements Runnable {
        final /* synthetic */ Context val$context;
        final /* synthetic */ int val$resid;

        AnonymousClass3(int i, Context context) {
            this.val$resid = i;
            this.val$context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ToastUtil.b != null) {
                ToastUtil.b.setText(this.val$resid);
                ToastUtil.b.setDuration(1);
                ToastUtil.d(ToastUtil.b);
            } else {
                Toast unused = ToastUtil.b = Toast.makeText(this.val$context.getApplicationContext(), this.val$resid, 1);
            }
            ToastUtil.b.show();
        }
    }

    /* renamed from: com.transsion.core.utils.ToastUtil$4, reason: invalid class name */
    final class AnonymousClass4 implements Runnable {
        final /* synthetic */ Context val$context;
        final /* synthetic */ String val$msg;

        AnonymousClass4(String str, Context context) {
            this.val$msg = str;
            this.val$context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ToastUtil.b != null) {
                ToastUtil.b.setText(this.val$msg);
                ToastUtil.b.setDuration(1);
                ToastUtil.d(ToastUtil.b);
            } else {
                Toast unused = ToastUtil.b = Toast.makeText(this.val$context.getApplicationContext(), this.val$msg, 1);
            }
            ToastUtil.b.show();
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
                e.printStackTrace();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.a.handleMessage(message);
        }
    }

    static {
        try {
            Field declaredField = Toast.class.getDeclaredField("mTN");
            c = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = c.getType().getDeclaredField("mHandler");
            d = declaredField2;
            declaredField2.setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Toast toast) {
        try {
            Object obj = c.get(toast);
            Handler handler = (Handler) d.get(obj);
            if (handler == null || (handler instanceof a)) {
                return;
            }
            d.set(obj, new a(handler));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void e(final int i) {
        final Context a2 = yj.a.a();
        if (i <= 0) {
            return;
        }
        a.post(new Runnable() { // from class: com.transsion.core.utils.ToastUtil.1
            @Override // java.lang.Runnable
            public void run() {
                if (ToastUtil.b != null) {
                    ToastUtil.b.setText(i);
                    ToastUtil.b.setDuration(0);
                    ToastUtil.d(ToastUtil.b);
                } else {
                    Toast unused = ToastUtil.b = Toast.makeText(a2.getApplicationContext(), i, 0);
                }
                ToastUtil.b.show();
            }
        });
    }

    public static void f(final String str) {
        final Context a2 = yj.a.a();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a.post(new Runnable() { // from class: com.transsion.core.utils.ToastUtil.2
            @Override // java.lang.Runnable
            public void run() {
                if (ToastUtil.b != null) {
                    ToastUtil.b.setText(str);
                    ToastUtil.b.setDuration(0);
                    ToastUtil.d(ToastUtil.b);
                } else {
                    Toast unused = ToastUtil.b = Toast.makeText(a2.getApplicationContext(), str, 0);
                }
                ToastUtil.b.show();
            }
        });
    }
}
