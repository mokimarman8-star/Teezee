package l3;

import android.text.TextUtils;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f16427a;

    /* renamed from: b, reason: collision with root package name */
    public final int f16428b;

    /* renamed from: c, reason: collision with root package name */
    public final int f16429c;

    /* renamed from: d, reason: collision with root package name */
    public final int f16430d;

    /* renamed from: e, reason: collision with root package name */
    public final int f16431e;

    private a(int i5, int i6, int i7, int i8, int i9) {
        this.f16427a = i5;
        this.f16428b = i6;
        this.f16429c = i7;
        this.f16430d = i8;
        this.f16431e = i9;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static a a(String str) {
        char c5;
        androidx.media3.common.util.a.a(str.startsWith("Format:"));
        String[] split = TextUtils.split(str.substring(7), ",");
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        for (int i9 = 0; i9 < split.length; i9++) {
            String e5 = com.google.common.base.a.e(split[i9].trim());
            e5.hashCode();
            switch (e5.hashCode()) {
                case 100571:
                    if (e5.equals("end")) {
                        c5 = 0;
                        break;
                    }
                    c5 = 65535;
                    break;
                case 3556653:
                    if (e5.equals("text")) {
                        c5 = 1;
                        break;
                    }
                    c5 = 65535;
                    break;
                case 109757538:
                    if (e5.equals("start")) {
                        c5 = 2;
                        break;
                    }
                    c5 = 65535;
                    break;
                case 109780401:
                    if (e5.equals("style")) {
                        c5 = 3;
                        break;
                    }
                    c5 = 65535;
                    break;
                default:
                    c5 = 65535;
                    break;
            }
            switch (c5) {
                case 0:
                    i6 = i9;
                    break;
                case 1:
                    i8 = i9;
                    break;
                case 2:
                    i5 = i9;
                    break;
                case 3:
                    i7 = i9;
                    break;
            }
        }
        if (i5 == -1 || i6 == -1 || i8 == -1) {
            return null;
        }
        return new a(i5, i6, i7, i8, split.length);
    }
}
