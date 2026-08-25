package com.cloud.tmc.integration.utils;

import android.graphics.Point;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.kernel.log.TmcLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/cloud/tmc/integration/utils/TouchEventUtils;", "", "()V", "TAG", "", "simulateTouchEvent", "", "view", "Landroid/view/View;", "points", "", "Landroid/graphics/Point;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class TouchEventUtils {
    public static final TouchEventUtils INSTANCE = new TouchEventUtils();
    private static final String TAG = "TouchEventUtils";

    private TouchEventUtils() {
    }

    @JvmStatic
    public static final void simulateTouchEvent(View view, List<Point> points) {
        String str;
        String str2;
        String str3;
        String str4;
        Iterator it;
        long j;
        int i;
        Point point;
        View view2;
        View view3 = view;
        Intrinsics.h(view3, "view");
        Intrinsics.h(points, "points");
        long uptimeMillis = SystemClock.uptimeMillis();
        Iterator it2 = points.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            Object next = it2.next();
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.u();
            }
            Point point2 = (Point) next;
            if (i2 == 0) {
                long j2 = uptimeMillis + 50;
                str4 = " eventTime: ";
                boolean dispatchTouchEvent = view3.dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, j2, 0, point2.x, point2.y, 0));
                int i4 = point2.x;
                int i8 = point2.y;
                StringBuilder sb = new StringBuilder();
                sb.append("simulateTouchEvent: ACTION_DOWN ");
                sb.append(dispatchTouchEvent);
                str2 = " x: ";
                sb.append(str2);
                sb.append(i4);
                str3 = " y: ";
                sb.append(str3);
                sb.append(i8);
                sb.append(" downTime: ");
                sb.append(uptimeMillis);
                sb.append(str4);
                sb.append(j2);
                String sb2 = sb.toString();
                str = TAG;
                TmcLogger.d(str, sb2);
            } else {
                str = TAG;
                str2 = " x: ";
                str3 = " y: ";
                str4 = " eventTime: ";
            }
            if (i2 == 0 || i2 == points.size() - 1) {
                it = it2;
                j = uptimeMillis;
                i = i3;
                point = point2;
            } else {
                long j3 = (i2 * 50) + uptimeMillis;
                long j4 = (i3 * 50) + uptimeMillis;
                it = it2;
                i = i3;
                boolean dispatchTouchEvent2 = view3.dispatchTouchEvent(MotionEvent.obtain(j3, j4, 2, point2.x, point2.y, 0));
                int i9 = point2.x;
                int i10 = point2.y;
                point = point2;
                StringBuilder sb3 = new StringBuilder();
                j = uptimeMillis;
                sb3.append("simulateTouchEvent: ACTION_MOVE ");
                sb3.append(dispatchTouchEvent2);
                sb3.append(str2);
                sb3.append(i9);
                sb3.append(str3);
                sb3.append(i10);
                sb3.append("  downTime: ");
                sb3.append(j3);
                sb3.append(str4);
                sb3.append(j4);
                TmcLogger.d(str, sb3.toString());
            }
            if (i2 == points.size() - 1) {
                long j8 = j + (i2 * 50);
                long j9 = j + (i * 50);
                Point point3 = point;
                view2 = view;
                TmcLogger.d(str, "simulateTouchEvent: ACTION_UP " + view2.dispatchTouchEvent(MotionEvent.obtain(j8, j9, 1, point3.x, point3.y, 0)) + str2 + point3.x + str3 + point3.y + "  downTime: " + j8 + str4 + j9);
            } else {
                view2 = view;
            }
            view3 = view2;
            it2 = it;
            i2 = i;
            uptimeMillis = j;
        }
    }
}
