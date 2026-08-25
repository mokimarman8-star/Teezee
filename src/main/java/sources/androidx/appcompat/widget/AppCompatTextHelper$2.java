package androidx.appcompat.widget;

import android.graphics.Typeface;
import android.widget.TextView;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class AppCompatTextHelper$2 implements Runnable {
    final /* synthetic */ AppCompatTextHelper this$0;
    final /* synthetic */ int val$style;
    final /* synthetic */ TextView val$textView;
    final /* synthetic */ Typeface val$typeface;

    AppCompatTextHelper$2(AppCompatTextHelper appCompatTextHelper, TextView textView, Typeface typeface, int i5) {
        this.this$0 = appCompatTextHelper;
        this.val$textView = textView;
        this.val$typeface = typeface;
        this.val$style = i5;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.val$textView.setTypeface(this.val$typeface, this.val$style);
    }
}
