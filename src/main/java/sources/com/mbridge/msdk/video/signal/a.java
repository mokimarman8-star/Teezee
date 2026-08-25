package com.mbridge.msdk.video.signal;

import android.app.Activity;
import com.mbridge.msdk.out.NativeListener;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public interface a extends e {

    /* renamed from: com.mbridge.msdk.video.signal.a$a, reason: collision with other inner class name */
    public interface InterfaceC0166a extends NativeListener.NativeTrackingListener {
        void a();

        void a(int i, String str);

        void a(boolean z);

        void onInitSuccess();
    }

    void a(int i);

    void a(int i, String str);

    void a(InterfaceC0166a interfaceC0166a);

    void a(String str);

    void a(boolean z);

    boolean a();

    int b();

    void b(int i);

    void b(boolean z);

    String c();

    void c(int i);

    int d();

    void d(int i);

    String e();

    void e(int i);

    String f(int i);

    void f();

    String g();

    void g(int i);

    void h();

    int i();

    void release();

    void setActivity(Activity activity);

    void setAdEvents(com.iab.omid.library.mmadbridge.adsession.a aVar);

    void setAdSession(com.iab.omid.library.mmadbridge.adsession.b bVar);

    void setRewardUnitSetting(com.mbridge.msdk.videocommon.setting.c cVar);

    void setUnitId(String str);

    void setVideoEvents(com.iab.omid.library.mmadbridge.adsession.media.a aVar);

    void setWebViewFront(int i);
}
