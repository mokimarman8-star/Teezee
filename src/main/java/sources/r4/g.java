package r4;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final String f17626a;

    /* renamed from: b, reason: collision with root package name */
    public final float f17627b;

    /* renamed from: c, reason: collision with root package name */
    public final float f17628c;

    public g(String str, float f5, float f6) {
        this.f17626a = str;
        this.f17628c = f6;
        this.f17627b = f5;
    }

    public boolean a(String str) {
        if (this.f17626a.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.f17626a.endsWith("\r")) {
            String str2 = this.f17626a;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
