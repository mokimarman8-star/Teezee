package kotlinx.serialization.json.internal;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class b {
    public static final byte a(char c) {
        if (c < '~') {
            return i.c[c];
        }
        return (byte) 0;
    }

    public static final char b(int i) {
        if (i < 117) {
            return i.b[i];
        }
        return (char) 0;
    }
}
