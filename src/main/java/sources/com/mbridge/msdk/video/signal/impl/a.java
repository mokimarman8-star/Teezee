package com.mbridge.msdk.video.signal.impl;

import android.app.Activity;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.NativeListener;
import com.mbridge.msdk.video.signal.a;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class a implements com.mbridge.msdk.video.signal.d {
    protected String j;
    protected com.mbridge.msdk.videocommon.setting.c k;
    protected com.mbridge.msdk.click.a l;
    protected boolean a = false;
    protected boolean b = false;
    protected int c = 0;
    protected int d = 0;
    protected int e = 0;
    protected int f = 0;
    protected int g = 0;
    protected int h = 1;
    protected int i = -1;
    public a.InterfaceC0166a m = new C0167a();
    protected int n = 2;
    protected int o = 2;
    private com.iab.omid.library.mmadbridge.adsession.b p = null;
    private com.iab.omid.library.mmadbridge.adsession.media.a q = null;
    private com.iab.omid.library.mmadbridge.adsession.a r = null;

    /* renamed from: com.mbridge.msdk.video.signal.impl.a$a, reason: collision with other inner class name */
    public static class C0167a implements a.InterfaceC0166a {
        @Override // com.mbridge.msdk.video.signal.a.InterfaceC0166a
        public void a() {
            o0.a("DefaultJSCommon", "videoLocationReady");
        }

        @Override // com.mbridge.msdk.video.signal.a.InterfaceC0166a
        public void a(int i, String str) {
            o0.a("DefaultJSCommon", "onH5Error,code:" + i + "，msg:" + str);
        }

        @Override // com.mbridge.msdk.video.signal.a.InterfaceC0166a
        public void a(boolean z) {
            o0.a("DefaultJSCommon", "onStartInstall");
        }

        public void onDismissLoading(Campaign campaign) {
            o0.a("DefaultJSCommon", "onDismissLoading,campaign:" + campaign);
        }

        public void onDownloadFinish(Campaign campaign) {
            o0.a("DefaultJSCommon", "onDownloadFinish,campaign:" + campaign);
        }

        public void onDownloadProgress(int i) {
            o0.a("DefaultJSCommon", "onDownloadProgress,progress:" + i);
        }

        public void onDownloadStart(Campaign campaign) {
            o0.a("DefaultJSCommon", "onDownloadStart,campaign:" + campaign);
        }

        public void onFinishRedirection(Campaign campaign, String str) {
            o0.a("DefaultJSCommon", "onFinishRedirection,campaign:" + campaign + ",url:" + str);
        }

        @Override // com.mbridge.msdk.video.signal.a.InterfaceC0166a
        public void onInitSuccess() {
            o0.a("DefaultJSCommon", "onInitSuccess");
        }

        public boolean onInterceptDefaultLoadingDialog() {
            o0.a("DefaultJSCommon", "onInterceptDefaultLoadingDialog");
            return false;
        }

        public void onRedirectionFailed(Campaign campaign, String str) {
            o0.a("DefaultJSCommon", "onFinishRedirection,campaign:" + campaign + ",url:" + str);
        }

        public void onShowLoading(Campaign campaign) {
            o0.a("DefaultJSCommon", "onShowLoading,campaign:" + campaign);
        }

        public void onStartRedirection(Campaign campaign, String str) {
            o0.a("DefaultJSCommon", "onStartRedirection,campaign:" + campaign + ",url:" + str);
        }
    }

    public static class b implements a.InterfaceC0166a {
        private com.mbridge.msdk.video.signal.d a;
        private a.InterfaceC0166a b;

        public b(com.mbridge.msdk.video.signal.d dVar, a.InterfaceC0166a interfaceC0166a) {
            this.a = dVar;
            this.b = interfaceC0166a;
        }

        @Override // com.mbridge.msdk.video.signal.a.InterfaceC0166a
        public void a() {
            a.InterfaceC0166a interfaceC0166a = this.b;
            if (interfaceC0166a != null) {
                interfaceC0166a.a();
            }
        }

        @Override // com.mbridge.msdk.video.signal.a.InterfaceC0166a
        public void a(int i, String str) {
            a.InterfaceC0166a interfaceC0166a = this.b;
            if (interfaceC0166a != null) {
                interfaceC0166a.a(i, str);
            }
        }

        @Override // com.mbridge.msdk.video.signal.a.InterfaceC0166a
        public void a(boolean z) {
            a.InterfaceC0166a interfaceC0166a = this.b;
            if (interfaceC0166a != null) {
                interfaceC0166a.a(z);
            }
        }

        public void onDismissLoading(Campaign campaign) {
            a.InterfaceC0166a interfaceC0166a = this.b;
            if (interfaceC0166a != null) {
                interfaceC0166a.onDismissLoading(campaign);
            }
        }

        public void onDownloadFinish(Campaign campaign) {
            a.InterfaceC0166a interfaceC0166a = this.b;
            if (interfaceC0166a != null) {
                interfaceC0166a.onDownloadFinish(campaign);
            }
        }

        public void onDownloadProgress(int i) {
            a.InterfaceC0166a interfaceC0166a = this.b;
            if (interfaceC0166a != null) {
                interfaceC0166a.onDownloadProgress(i);
            }
        }

        public void onDownloadStart(Campaign campaign) {
            a.InterfaceC0166a interfaceC0166a = this.b;
            if (interfaceC0166a != null) {
                interfaceC0166a.onDownloadStart(campaign);
            }
        }

        public void onFinishRedirection(Campaign campaign, String str) {
            a.InterfaceC0166a interfaceC0166a = this.b;
            if (interfaceC0166a != null) {
                interfaceC0166a.onFinishRedirection(campaign, str);
            }
            com.mbridge.msdk.video.signal.d dVar = this.a;
            if (dVar != null) {
                dVar.f();
            }
        }

        @Override // com.mbridge.msdk.video.signal.a.InterfaceC0166a
        public void onInitSuccess() {
            a.InterfaceC0166a interfaceC0166a = this.b;
            if (interfaceC0166a != null) {
                interfaceC0166a.onInitSuccess();
            }
        }

        public boolean onInterceptDefaultLoadingDialog() {
            a.InterfaceC0166a interfaceC0166a = this.b;
            return interfaceC0166a != null && interfaceC0166a.onInterceptDefaultLoadingDialog();
        }

        public void onRedirectionFailed(Campaign campaign, String str) {
            a.InterfaceC0166a interfaceC0166a = this.b;
            if (interfaceC0166a != null) {
                interfaceC0166a.onRedirectionFailed(campaign, str);
            }
            com.mbridge.msdk.video.signal.d dVar = this.a;
            if (dVar != null) {
                dVar.f();
            }
        }

        public void onShowLoading(Campaign campaign) {
            a.InterfaceC0166a interfaceC0166a = this.b;
            if (interfaceC0166a != null) {
                interfaceC0166a.onShowLoading(campaign);
            }
        }

        public void onStartRedirection(Campaign campaign, String str) {
            a.InterfaceC0166a interfaceC0166a = this.b;
            if (interfaceC0166a != null) {
                interfaceC0166a.onStartRedirection(campaign, str);
            }
        }
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void a(int i) {
        this.i = i;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void a(int i, String str) {
        o0.a("DefaultJSCommon", "statistics,type:" + i + ",json:" + str);
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void a(a.InterfaceC0166a interfaceC0166a) {
        o0.a("DefaultJSCommon", "setTrackingListener:" + interfaceC0166a);
        this.m = interfaceC0166a;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void a(String str) {
        o0.a("DefaultJSCommon", "setNotchArea");
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void a(boolean z) {
        o0.a("DefaultJSCommon", "setIsShowingTransparent:" + z);
        this.b = z;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public boolean a() {
        return this.a;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public int b() {
        return this.g;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void b(int i) {
        this.c = i;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void b(boolean z) {
        this.a = z;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public String c() {
        o0.a("DefaultJSCommon", "init");
        return "{}";
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void c(int i) {
        this.e = i;
    }

    @Override // com.mbridge.msdk.video.signal.e
    public void click(int i, String str) {
        o0.a("DefaultJSCommon", "click:type" + i + ",pt:" + str);
    }

    @Override // com.mbridge.msdk.video.signal.a
    public int d() {
        o0.a("DefaultJSCommon", "getAlertDialogRole " + this.h);
        return this.h;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void d(int i) {
        o0.a("DefaultJSCommon", "setAlertDialogRole " + i);
        this.h = i;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public String e() {
        o0.a("DefaultJSCommon", "getNotchArea");
        return null;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void e(int i) {
        this.d = i;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public String f(int i) {
        o0.a("DefaultJSCommon", "getSDKInfo");
        return "{}";
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void f() {
        o0.a("DefaultJSCommon", "finish");
    }

    @Override // com.mbridge.msdk.video.signal.a
    public String g() {
        return "{}";
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void g(int i) {
        this.n = i;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void h() {
    }

    @Override // com.mbridge.msdk.video.signal.e
    public void handlerH5Exception(int i, String str) {
        o0.a("DefaultJSCommon", "handlerH5Exception,code=" + i + ",msg:" + str);
    }

    @Override // com.mbridge.msdk.video.signal.a
    public int i() {
        return this.i;
    }

    public com.iab.omid.library.mmadbridge.adsession.a j() {
        return this.r;
    }

    public com.iab.omid.library.mmadbridge.adsession.b k() {
        return this.p;
    }

    public int l() {
        if (this.c == 0 && this.b) {
            this.c = 1;
        }
        return this.c;
    }

    public int m() {
        if (this.d == 0 && this.b) {
            this.d = 1;
        }
        return this.d;
    }

    public int n() {
        if (this.e == 0 && this.b) {
            this.e = 1;
        }
        return this.e;
    }

    public com.iab.omid.library.mmadbridge.adsession.media.a o() {
        return this.q;
    }

    public boolean p() {
        return this.b;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void release() {
        o0.a("DefaultJSCommon", "release");
        com.mbridge.msdk.click.a aVar = this.l;
        if (aVar != null) {
            aVar.a(false);
            this.l.a((NativeListener.NativeTrackingListener) null);
            this.l.c();
        }
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void setActivity(Activity activity) {
        o0.a("DefaultJSCommon", "setActivity ");
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void setAdEvents(com.iab.omid.library.mmadbridge.adsession.a aVar) {
        this.r = aVar;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void setAdSession(com.iab.omid.library.mmadbridge.adsession.b bVar) {
        this.p = bVar;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void setRewardUnitSetting(com.mbridge.msdk.videocommon.setting.c cVar) {
        o0.a("DefaultJSCommon", "setSetting:" + cVar);
        this.k = cVar;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void setUnitId(String str) {
        o0.a("DefaultJSCommon", "setUnitId:" + str);
        this.j = str;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void setVideoEvents(com.iab.omid.library.mmadbridge.adsession.media.a aVar) {
        this.q = aVar;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void setWebViewFront(int i) {
        this.g = i;
    }
}
