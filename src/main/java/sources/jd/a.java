package jd;

import android.hardware.Camera;
import android.util.Log;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class a {
    private static final String a = "jd.a";

    public static int a(int i) {
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras == 0) {
            Log.w(a, "No cameras!");
            return -1;
        }
        boolean z = i >= 0;
        if (!z) {
            i = 0;
            while (i < numberOfCameras) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i, cameraInfo);
                if (cameraInfo.facing == 0) {
                    break;
                }
                i++;
            }
        }
        return i < numberOfCameras ? i : z ? -1 : 0;
    }

    public static Camera b(int i) {
        int a2 = a(i);
        if (a2 == -1) {
            return null;
        }
        return Camera.open(a2);
    }
}
