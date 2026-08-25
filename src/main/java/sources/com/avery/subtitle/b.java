package com.avery.subtitle;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface b {

    public interface a {
        void onSubtitleChanged(m5.b bVar);
    }

    /* renamed from: com.avery.subtitle.b$b, reason: collision with other inner class name */
    public interface InterfaceC0010b {
        void onRefreshSubtitle();

        void onSubtitlePrepared();
    }

    void destroy();

    void initSubtitle(k5.a aVar, boolean z);

    void pause();

    void refreshImmediately();

    void reset();

    void resume();

    void selectSubtitle(String str, String str2, k5.b bVar);

    void setDefaultSubtitle(String str);

    void setOnSubtitleChangeListener(a aVar);

    void setOnSubtitlePreparedListener(InterfaceC0010b interfaceC0010b);

    void setSubtitlePath(String str, String str2);

    void start();

    void stop();

    void subtitleDelay(long j);
}
