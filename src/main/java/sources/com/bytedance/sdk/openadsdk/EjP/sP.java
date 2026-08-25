package com.bytedance.sdk.openadsdk.EjP;

import com.bytedance.sdk.openadsdk.EjP.TKC.Sj;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class sP {
    public static final String Sj = Sj.InterfaceC0063Sj.Sj;
    public static final String sP = Sj.InterfaceC0063Sj.sP;
    public static final String TKC = Sj.InterfaceC0063Sj.TKC;
    public static final String EjP = Sj.InterfaceC0063Sj.EjP;
    public static final String HiB = Sj.InterfaceC0063Sj.HiB;
    public static final String vS = Sj.InterfaceC0063Sj.vS;
    public static final Set<String> Jcg = new HashSet(Arrays.asList("click", "show", "insight_log"));

    public static class Sj {
        public static String EjP = "saLandingPageLinks";
        public static String Sj = "openDetailPage";
        public static String TKC = "direct";
        public static String sP = "openAdLandPageLinks";
    }

    /* renamed from: com.bytedance.sdk.openadsdk.EjP.sP$sP, reason: collision with other inner class name */
    public static class C0064sP {
        public static int Sj = 1;
        public static int TKC = 100;
        public static int sP = 2;
    }

    public static boolean Sj(String str) {
        return "embeded_ad".equals(str) || "banner_ad".equals(str) || "interaction".equals(str) || "slide_banner_ad".equals(str);
    }
}
