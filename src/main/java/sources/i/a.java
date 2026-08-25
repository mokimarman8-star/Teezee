package i;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class a implements TransformationMethod {

    /* renamed from: a, reason: collision with root package name */
    private Locale f15535a;

    public a(Context context) {
        this.f15535a = context.getResources().getConfiguration().locale;
    }

    @Override // android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if (charSequence != null) {
            return charSequence.toString().toUpperCase(this.f15535a);
        }
        return null;
    }

    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(View view, CharSequence charSequence, boolean z5, int i5, Rect rect) {
    }
}
