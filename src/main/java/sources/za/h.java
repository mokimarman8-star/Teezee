package za;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Build;
import androidx.compose.ui.platform.l;
import androidx.compose.ui.text.font.y;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class h {
    public static Typeface a(Context context, Typeface typeface) {
        return b(context.getResources().getConfiguration(), typeface);
    }

    public static Typeface b(Configuration configuration, Typeface typeface) {
        int weight;
        if (Build.VERSION.SDK_INT < 31 || l.a(configuration) == Integer.MAX_VALUE || l.a(configuration) == 0 || typeface == null) {
            return null;
        }
        weight = typeface.getWeight();
        return y.a(typeface, d1.a.b(weight + l.a(configuration), 1, 1000), typeface.isItalic());
    }
}
