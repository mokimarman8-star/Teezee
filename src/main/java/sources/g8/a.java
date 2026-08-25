package g8;

import android.util.Log;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class a implements c {
    private boolean a;
    private int b;

    public a() {
        this(false, 4000);
    }

    public a(boolean z, int i) {
        this.a = z;
        this.b = i;
    }

    static int b(String str, int i, int i2) {
        if (i2 == str.length() || str.charAt(i2) == '\n') {
            return i2;
        }
        for (int i3 = i2 - 1; i < i3; i3--) {
            if (str.charAt(i3) == '\n') {
                return i3;
            }
        }
        return i2;
    }

    @Override // g8.c
    public void a(int i, String str, String str2) {
        int length = str2.length();
        int i2 = 0;
        while (i2 < length) {
            if (str2.charAt(i2) == '\n') {
                i2++;
            } else {
                int min = Math.min(this.b + i2, length);
                if (this.a) {
                    int indexOf = str2.indexOf(10, i2);
                    if (indexOf != -1) {
                        min = indexOf;
                    }
                } else {
                    min = b(str2, i2, min);
                }
                c(i, str, str2.substring(i2, min));
                i2 = min;
            }
        }
    }

    void c(int i, String str, String str2) {
        Log.println(i, str, str2);
    }
}
