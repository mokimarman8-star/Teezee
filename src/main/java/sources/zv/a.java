package zv;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a {
    public static final a a = new a();

    private a() {
    }

    public final void a(TextView textView, String content, Drawable drawable) {
        Intrinsics.h(content, "content");
        if (drawable != null) {
            SpannableString spannableString = new SpannableString(content);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            spannableString.setSpan(Build.VERSION.SDK_INT >= 29 ? new ImageSpan(drawable, 2) : new ImageSpan(drawable, 1), 0, 1, 17);
            if (textView != null) {
                textView.setText(spannableString);
            }
        }
    }
}
