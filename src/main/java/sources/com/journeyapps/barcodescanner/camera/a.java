package com.journeyapps.barcodescanner.camera;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.journeyapps.barcodescanner.camera.a;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class a {
    private static final String i = "a";
    private static final Collection j;
    private boolean a;
    private boolean b;
    private final boolean c;
    private final Camera d;
    private Handler e;
    private int f = 1;
    private final Handler.Callback g;
    private final Camera.AutoFocusCallback h;

    /* renamed from: com.journeyapps.barcodescanner.camera.a$a, reason: collision with other inner class name */
    class C0061a implements Handler.Callback {
        C0061a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != a.this.f) {
                return false;
            }
            a.this.h();
            return true;
        }
    }

    class b implements Camera.AutoFocusCallback {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            a.this.b = false;
            a.this.f();
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            a.this.e.post(new Runnable() { // from class: com.journeyapps.barcodescanner.camera.b
                @Override // java.lang.Runnable
                public final void run() {
                    a.b.this.b();
                }
            });
        }
    }

    static {
        ArrayList arrayList = new ArrayList(2);
        j = arrayList;
        arrayList.add("auto");
        arrayList.add("macro");
    }

    public a(Camera camera, CameraSettings cameraSettings) {
        C0061a c0061a = new C0061a();
        this.g = c0061a;
        this.h = new b();
        this.e = new Handler(c0061a);
        this.d = camera;
        String focusMode = camera.getParameters().getFocusMode();
        boolean z = cameraSettings.c() && j.contains(focusMode);
        this.c = z;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Current focus mode '");
        sb2.append(focusMode);
        sb2.append("'; use auto focus? ");
        sb2.append(z);
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void f() {
        if (!this.a && !this.e.hasMessages(this.f)) {
            Handler handler = this.e;
            handler.sendMessageDelayed(handler.obtainMessage(this.f), 2000L);
        }
    }

    private void g() {
        this.e.removeMessages(this.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (!this.c || this.a || this.b) {
            return;
        }
        try {
            this.d.autoFocus(this.h);
            this.b = true;
        } catch (RuntimeException e) {
            Log.w(i, "Unexpected exception while focusing", e);
            f();
        }
    }

    public void i() {
        this.a = false;
        h();
    }

    public void j() {
        this.a = true;
        this.b = false;
        g();
        if (this.c) {
            try {
                this.d.cancelAutoFocus();
            } catch (RuntimeException e) {
                Log.w(i, "Unexpected exception while cancelling focusing", e);
            }
        }
    }
}
