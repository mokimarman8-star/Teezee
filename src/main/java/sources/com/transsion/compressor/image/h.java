package com.transsion.compressor.image;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class h implements Handler.Callback {
    private static Random h;
    private String a;
    private final boolean b;
    private final int c;
    private final e d;
    private final com.transsion.compressor.image.a e;
    private final List f;
    private final Handler g;

    public static class a {
        private final Context a;
        private String b;
        private boolean c;
        private e e;
        private com.transsion.compressor.image.a f;
        private int d = 100;
        private final List g = new ArrayList();

        /* renamed from: com.transsion.compressor.image.h$a$a, reason: collision with other inner class name */
        class C0022a extends c {
            final /* synthetic */ String b;

            C0022a(String str) {
                this.b = str;
            }

            @Override // com.transsion.compressor.image.c
            public InputStream a() {
                return new FileInputStream(this.b);
            }

            @Override // com.transsion.compressor.image.d
            public String getPath() {
                return this.b;
            }
        }

        a(Context context) {
            this.a = context;
        }

        static /* bridge */ /* synthetic */ f e(a aVar) {
            aVar.getClass();
            return null;
        }

        private h h() {
            return new h(this);
        }

        public void i() {
            try {
                File e = j.e(this.a);
                if (e != null) {
                    this.b = e.getAbsolutePath();
                }
                j.d(new File(this.b));
            } catch (Exception unused) {
            }
        }

        public a j(com.transsion.compressor.image.a aVar) {
            this.f = aVar;
            return this;
        }

        public void k() {
            h().g(this.a);
        }

        public a l(String str) {
            this.g.add(new C0022a(str));
            return this;
        }

        public a m(e eVar) {
            this.e = eVar;
            return this;
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                h = com.bytedance.sdk.component.utils.a.a();
            } else {
                h = new Random();
            }
        } catch (NoSuchAlgorithmException e) {
            j.f(Log.getStackTraceString(e));
        }
    }

    private h(a aVar) {
        this.a = aVar.b;
        a.e(aVar);
        this.f = aVar.g;
        this.d = aVar.e;
        this.c = aVar.d;
        this.e = aVar.f;
        this.b = aVar.c;
        this.g = new Handler(Looper.getMainLooper(), this);
    }

    private File c(Context context, d dVar) {
        try {
            return d(context, dVar);
        } finally {
            dVar.close();
        }
    }

    private File d(Context context, d dVar) {
        Checker checker = Checker.SINGLE;
        File e = e(context, checker.extSuffix(dVar));
        com.transsion.compressor.image.a aVar = this.e;
        return aVar != null ? (aVar.a(dVar.getPath()) && checker.needCompress(this.c, dVar.getPath())) ? new b(dVar, e, this.b).a() : new File(dVar.getPath()) : checker.needCompress(this.c, dVar.getPath()) ? new b(dVar, e, this.b).a() : new File(dVar.getPath());
    }

    private File e(Context context, String str) {
        File e;
        if (TextUtils.isEmpty(this.a) && (e = j.e(context)) != null) {
            this.a = e.getAbsolutePath();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append(File.separator);
        sb.append(System.currentTimeMillis());
        sb.append(h.nextInt(1000));
        if (TextUtils.isEmpty(str)) {
            str = ".jpg";
        }
        sb.append(str);
        File file = new File(sb.toString());
        j.c(file);
        return file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(d dVar, Context context) {
        try {
            Message obtainMessage = this.g.obtainMessage(1);
            obtainMessage.obj = dVar.getPath();
            this.g.sendMessage(obtainMessage);
            File c = c(context, dVar);
            int[] a2 = j.a(c);
            Message obtainMessage2 = this.g.obtainMessage(0, c);
            Bundle bundle = new Bundle();
            bundle.putIntArray("tag_image_info", a2);
            bundle.putLong("tag_image_size", c.length() / 1024);
            obtainMessage2.setData(bundle);
            this.g.sendMessage(obtainMessage2);
        } catch (IOException e) {
            Handler handler = this.g;
            handler.sendMessage(handler.obtainMessage(2, e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(final Context context) {
        e eVar;
        e eVar2;
        if (context == null && (eVar2 = this.d) != null) {
            eVar2.onError(new NullPointerException("context cannot be null"));
        }
        if (this.f.size() == 0 && (eVar = this.d) != null) {
            eVar.onError(new NullPointerException("image file cannot be null"));
            return;
        }
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            final d dVar = (d) it.next();
            AsyncTask.SERIAL_EXECUTOR.execute(new Runnable() { // from class: com.transsion.compressor.image.g
                @Override // java.lang.Runnable
                public final void run() {
                    h.this.f(dVar, context);
                }
            });
            it.remove();
        }
    }

    public static a h(Context context) {
        return new a(context.getApplicationContext());
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        e eVar = this.d;
        if (eVar == null) {
            return true;
        }
        int i = message.what;
        if (i == 0) {
            File file = (File) message.obj;
            Bundle data = message.getData();
            this.d.b(file, data.getIntArray("tag_image_info"), data.getLong("tag_image_size"));
            return false;
        }
        if (i == 1) {
            eVar.a((String) message.obj);
            return false;
        }
        if (i != 2) {
            return false;
        }
        eVar.onError((Throwable) message.obj);
        return false;
    }
}
