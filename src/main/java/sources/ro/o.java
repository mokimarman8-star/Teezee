package ro;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class o {
    private int a = 0;
    private boolean b = false;
    private boolean c = false;
    private int d = 0;
    private boolean e = false;

    public static void a(View view) {
        InputMethodManager inputMethodManager;
        if (view == null || (inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
