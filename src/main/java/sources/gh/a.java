package gh;

import android.R;
import android.view.View;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface a {

    /* renamed from: gh.a$a, reason: collision with other inner class name */
    public static final class C0048a {
        public static TextView a(a aVar, View view) {
            Intrinsics.h(view, "view");
            if (view instanceof TextView) {
                if (view.getId() == -1) {
                    view.setId(R.id.message);
                } else if (view.getId() != 16908299) {
                    throw new IllegalArgumentException("You must set the ID value of TextView to android.R.id.message");
                }
                return (TextView) view;
            }
            if (!(view.findViewById(R.id.message) instanceof TextView)) {
                throw new IllegalArgumentException("You must include a TextView with an ID value of android.R.id.message");
            }
            View findViewById = view.findViewById(R.id.message);
            Intrinsics.f(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            return (TextView) findViewById;
        }
    }

    boolean a();

    void b(View view);

    View c();

    void cancel();

    int getDuration();

    int getGravity();

    float getHorizontalMargin();

    float getVerticalMargin();

    int getXOffset();

    int getYOffset();

    void setDuration(int i);

    void setGravity(int i, int i2, int i3);

    void setMargin(float f, float f2);

    void setText(CharSequence charSequence);

    void show();
}
