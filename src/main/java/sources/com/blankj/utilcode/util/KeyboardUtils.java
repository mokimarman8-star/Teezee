package com.blankj.utilcode.util;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import java.lang.reflect.Field;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class KeyboardUtils {
    private static int a;

    public static void a(Activity activity) {
        b(activity.getWindow());
    }

    public static void b(Window window) {
        InputMethodManager inputMethodManager = (InputMethodManager) Utils.a().getSystemService("input_method");
        if (inputMethodManager == null) {
            return;
        }
        String[] strArr = {"mLastSrvView", "mCurRootView", "mServedView", "mNextServedView"};
        for (int i = 0; i < 4; i++) {
            try {
                Field declaredField = InputMethodManager.class.getDeclaredField(strArr[i]);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                Object obj = declaredField.get(inputMethodManager);
                if ((obj instanceof View) && ((View) obj).getRootView() == window.getDecorView().getRootView()) {
                    declaredField.set(inputMethodManager, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static int c(Window window) {
        View decorView = window.getDecorView();
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        StringBuilder sb = new StringBuilder();
        sb.append("getDecorViewInvisibleHeight: ");
        sb.append(decorView.getBottom() - rect.bottom);
        int abs = Math.abs(decorView.getBottom() - rect.bottom);
        if (abs > e0.p() + e0.s()) {
            return abs - a;
        }
        a = abs;
        return 0;
    }

    public static void d(Activity activity) {
        if (activity == null) {
            return;
        }
        f(activity.getWindow());
    }

    public static void e(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) Utils.a().getSystemService("input_method");
        if (inputMethodManager == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void f(Window window) {
        if (window == null) {
            return;
        }
        View currentFocus = window.getCurrentFocus();
        if (currentFocus == null) {
            View decorView = window.getDecorView();
            View findViewWithTag = decorView.findViewWithTag("keyboardTagView");
            if (findViewWithTag == null) {
                findViewWithTag = new EditText(window.getContext());
                findViewWithTag.setTag("keyboardTagView");
                ((ViewGroup) decorView).addView(findViewWithTag, 0, 0);
            }
            currentFocus = findViewWithTag;
            currentFocus.requestFocus();
        }
        e(currentFocus);
    }

    public static boolean g(Activity activity) {
        return c(activity.getWindow()) > 0;
    }

    public static void h() {
        InputMethodManager inputMethodManager = (InputMethodManager) Utils.a().getSystemService("input_method");
        if (inputMethodManager == null) {
            return;
        }
        inputMethodManager.toggleSoftInput(2, 1);
    }

    public static void i(View view) {
        j(view, 0);
    }

    public static void j(View view, int i) {
        InputMethodManager inputMethodManager = (InputMethodManager) Utils.a().getSystemService("input_method");
        if (inputMethodManager == null) {
            return;
        }
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        inputMethodManager.showSoftInput(view, i, new 1(new Handler()));
        inputMethodManager.toggleSoftInput(2, 1);
    }

    public static void k() {
        InputMethodManager inputMethodManager = (InputMethodManager) Utils.a().getSystemService("input_method");
        if (inputMethodManager == null) {
            return;
        }
        inputMethodManager.toggleSoftInput(0, 0);
    }
}
