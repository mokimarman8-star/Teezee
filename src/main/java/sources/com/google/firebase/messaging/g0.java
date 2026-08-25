package com.google.firebase.messaging;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class g0 implements Closeable {
    private final URL a;
    private volatile Future b;
    private Task c;

    private g0(URL url) {
        this.a = url;
    }

    private byte[] h() {
        URLConnection openConnection = this.a.openConnection();
        if (openConnection.getContentLength() > 1048576) {
            throw new IOException("Content-Length exceeds max size of 1048576");
        }
        InputStream inputStream = openConnection.getInputStream();
        try {
            byte[] d = b.d(b.b(inputStream, 1048577L));
            if (inputStream != null) {
                inputStream.close();
            }
            if (Log.isLoggable("FirebaseMessaging", 2)) {
                Log.v("FirebaseMessaging", "Downloaded " + d.length + " bytes from " + this.a);
            }
            if (d.length <= 1048576) {
                return d;
            }
            throw new IOException("Image exceeds max size of 1048576");
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static g0 j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new g0(new URL(str));
        } catch (MalformedURLException unused) {
            Log.w("FirebaseMessaging", "Not downloading image, bad URL: " + str);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(d());
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.b.cancel(true);
    }

    public Bitmap d() {
        if (Log.isLoggable("FirebaseMessaging", 4)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Starting download of: ");
            sb2.append(this.a);
        }
        byte[] h = h();
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(h, 0, h.length);
        if (decodeByteArray == null) {
            throw new IOException("Failed to decode image: " + this.a);
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Successfully downloaded image: ");
            sb3.append(this.a);
        }
        return decodeByteArray;
    }

    public Task k() {
        return (Task) Preconditions.checkNotNull(this.c);
    }

    public void m(ExecutorService executorService) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.b = executorService.submit(new Runnable() { // from class: com.google.firebase.messaging.f0
            @Override // java.lang.Runnable
            public final void run() {
                g0.this.l(taskCompletionSource);
            }
        });
        this.c = taskCompletionSource.getTask();
    }
}
