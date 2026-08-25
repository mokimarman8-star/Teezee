package bz;

import com.transsion.gslb.GslbSdk;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class l {
    private static final l c = new l();
    private String a = "https://ire-oneid.shalltry.com";
    private String b = "76iRl07s0xSN9jqmEWAt79EBJZulIQIsV64FZr2O";

    public static l d() {
        return c;
    }

    public String a() {
        return GslbSdk.getDomain(this.a, true) + "/one/v1/change";
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.a;
    }

    public String e() {
        return GslbSdk.getDomain(this.a, true) + "/one/v1/log";
    }

    public String f() {
        return GslbSdk.getDomain(this.a, true) + "/one/v1/odid";
    }
}
