package com.bytedance.sdk.component.Jcg.TKC;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class TKC {
    private Sj Sj;
    private sP sP;

    public enum Sj {
        DEBUG,
        INFO,
        ERROR,
        OFF
    }

    /* renamed from: com.bytedance.sdk.component.Jcg.TKC.TKC$TKC, reason: collision with other inner class name */
    private static class C0041TKC {
        private static final TKC Sj = new TKC();
    }

    public interface sP {
    }

    private TKC() {
        this.Sj = Sj.OFF;
        this.sP = new com.bytedance.sdk.component.Jcg.TKC.sP();
    }

    public static void Sj(Sj sj) {
        synchronized (TKC.class) {
            C0041TKC.Sj.Sj = sj;
        }
    }
}
