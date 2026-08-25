package androidx.core.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.contentcapture.ContentCaptureSession;
import androidx.core.view.contentcapture.ContentCaptureSessionCompat;
import java.util.List;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class ViewCompat$m {
    static View.AccessibilityDelegate a(View view) {
        return view.getAccessibilityDelegate();
    }

    static ContentCaptureSession b(View view) {
        return view.getContentCaptureSession();
    }

    static List<Rect> c(View view) {
        return view.getSystemGestureExclusionRects();
    }

    static void d(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i5, int i6) {
        view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i5, i6);
    }

    static void e(View view, ContentCaptureSessionCompat contentCaptureSessionCompat) {
        view.setContentCaptureSession(contentCaptureSessionCompat == null ? null : contentCaptureSessionCompat.toContentCaptureSession());
    }

    static void f(View view, List<Rect> list) {
        view.setSystemGestureExclusionRects(list);
    }

    static void g(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }
}
