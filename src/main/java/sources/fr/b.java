package fr;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class b {
    public static int a(String str) {
        return b(str, 0);
    }

    public static int b(String str, int i) {
        try {
            return Integer.valueOf(str).intValue();
        } catch (Exception unused) {
            return i;
        }
    }
}
