package androidx.core.view;

import android.app.Activity;
import android.os.Build;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class DragAndDropPermissionsCompat {
    private final DragAndDropPermissions mDragAndDropPermissions;

    static class a {
        static void a(DragAndDropPermissions dragAndDropPermissions) {
            dragAndDropPermissions.release();
        }

        static DragAndDropPermissions b(Activity activity, DragEvent dragEvent) {
            return activity.requestDragAndDropPermissions(dragEvent);
        }
    }

    private DragAndDropPermissionsCompat(DragAndDropPermissions dragAndDropPermissions) {
        this.mDragAndDropPermissions = dragAndDropPermissions;
    }

    public static DragAndDropPermissionsCompat request(Activity activity, DragEvent dragEvent) {
        DragAndDropPermissions b5;
        if (Build.VERSION.SDK_INT < 24 || (b5 = a.b(activity, dragEvent)) == null) {
            return null;
        }
        return new DragAndDropPermissionsCompat(b5);
    }

    public void release() {
        if (Build.VERSION.SDK_INT >= 24) {
            a.a(this.mDragAndDropPermissions);
        }
    }
}
