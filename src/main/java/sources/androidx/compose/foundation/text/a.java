package androidx.compose.foundation.text;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class a {
    public static final void a(int i5, int i6) {
        if (i5 <= 0 || i6 <= 0) {
            throw new IllegalArgumentException(("both minLines " + i5 + " and maxLines " + i6 + " must be greater than zero").toString());
        }
        if (i5 <= i6) {
            return;
        }
        throw new IllegalArgumentException(("minLines " + i5 + " must be less than or equal to maxLines " + i6).toString());
    }
}
