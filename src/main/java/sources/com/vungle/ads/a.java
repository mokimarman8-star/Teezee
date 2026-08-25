package com.vungle.ads;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface a {

    /* renamed from: com.vungle.ads.a$a, reason: collision with other inner class name */
    public static final class C0031a {
        public static /* synthetic */ void load$default(a aVar, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: load");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            aVar.load(str);
        }
    }

    Boolean canPlayAd();

    void load(String str);
}
