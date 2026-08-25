package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class AppCompatRatingBar extends RatingBar {

    /* renamed from: a, reason: collision with root package name */
    private final l f759a;

    public AppCompatRatingBar(@NonNull Context context) {
        this(context, null);
    }

    public AppCompatRatingBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.ratingBarStyle);
    }

    public AppCompatRatingBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        f0.a(this, getContext());
        l lVar = new l(this);
        this.f759a = lVar;
        lVar.c(attributeSet, i5);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        Bitmap b5 = this.f759a.b();
        if (b5 != null) {
            setMeasuredDimension(View.resolveSizeAndState(b5.getWidth() * getNumStars(), i5, 0), getMeasuredHeight());
        }
    }
}
