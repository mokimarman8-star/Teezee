package com.journeyapps.barcodescanner.camera;

import android.graphics.Rect;
import android.hardware.Camera;
import com.google.logging.type.LogSeverity;
import com.journeyapps.barcodescanner.camera.CameraSettings;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class c {
    private static final Pattern a = Pattern.compile(";");

    private static List a(int i) {
        int i2 = -i;
        return Collections.singletonList(new Camera.Area(new Rect(i2, i2, i, i), 1));
    }

    private static String b(String str, Collection collection, String... strArr) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Requesting ");
        sb2.append(str);
        sb2.append(" value from among: ");
        sb2.append(Arrays.toString(strArr));
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Supported ");
        sb3.append(str);
        sb3.append(" values: ");
        sb3.append(collection);
        if (collection == null) {
            return null;
        }
        for (String str2 : strArr) {
            if (collection.contains(str2)) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Can set ");
                sb4.append(str);
                sb4.append(" to: ");
                sb4.append(str2);
                return str2;
            }
        }
        return null;
    }

    public static void c(Camera.Parameters parameters) {
        String b;
        if ("barcode".equals(parameters.getSceneMode()) || (b = b("scene mode", parameters.getSupportedSceneModes(), "barcode")) == null) {
            return;
        }
        parameters.setSceneMode(b);
    }

    public static void d(Camera.Parameters parameters, boolean z) {
        int minExposureCompensation = parameters.getMinExposureCompensation();
        int maxExposureCompensation = parameters.getMaxExposureCompensation();
        float exposureCompensationStep = parameters.getExposureCompensationStep();
        if (minExposureCompensation == 0 && maxExposureCompensation == 0) {
            return;
        }
        if (exposureCompensationStep > 0.0f) {
            int round = Math.round((z ? 0.0f : 1.5f) / exposureCompensationStep);
            float f = exposureCompensationStep * round;
            int max = Math.max(Math.min(round, maxExposureCompensation), minExposureCompensation);
            if (parameters.getExposureCompensation() == max) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Exposure compensation already set to ");
                sb2.append(max);
                sb2.append(" / ");
                sb2.append(f);
                return;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Setting exposure compensation to ");
            sb3.append(max);
            sb3.append(" / ");
            sb3.append(f);
            parameters.setExposureCompensation(max);
        }
    }

    public static void e(Camera.Parameters parameters) {
        f(parameters, 10, 20);
    }

    public static void f(Camera.Parameters parameters, int i, int i2) {
        int[] iArr;
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Supported FPS ranges: ");
        sb2.append(n(supportedPreviewFpsRange));
        if (supportedPreviewFpsRange == null || supportedPreviewFpsRange.isEmpty()) {
            return;
        }
        Iterator<int[]> it = supportedPreviewFpsRange.iterator();
        while (true) {
            if (!it.hasNext()) {
                iArr = null;
                break;
            }
            iArr = it.next();
            int i3 = iArr[0];
            int i4 = iArr[1];
            if (i3 >= i * 1000 && i4 <= i2 * 1000) {
                break;
            }
        }
        if (iArr == null) {
            return;
        }
        int[] iArr2 = new int[2];
        parameters.getPreviewFpsRange(iArr2);
        if (Arrays.equals(iArr2, iArr)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("FPS range already set to ");
            sb3.append(Arrays.toString(iArr));
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Setting FPS range to ");
            sb4.append(Arrays.toString(iArr));
            parameters.setPreviewFpsRange(iArr[0], iArr[1]);
        }
    }

    public static void g(Camera.Parameters parameters, CameraSettings.FocusMode focusMode, boolean z) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        String b = (z || focusMode == CameraSettings.FocusMode.AUTO) ? b("focus mode", supportedFocusModes, "auto") : focusMode == CameraSettings.FocusMode.CONTINUOUS ? b("focus mode", supportedFocusModes, "continuous-picture", "continuous-video", "auto") : focusMode == CameraSettings.FocusMode.INFINITY ? b("focus mode", supportedFocusModes, "infinity") : focusMode == CameraSettings.FocusMode.MACRO ? b("focus mode", supportedFocusModes, "macro") : null;
        if (!z && b == null) {
            b = b("focus mode", supportedFocusModes, "macro", "edof");
        }
        if (b != null) {
            if (!b.equals(parameters.getFocusMode())) {
                parameters.setFocusMode(b);
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Focus mode already set to ");
            sb2.append(b);
        }
    }

    public static void h(Camera.Parameters parameters) {
        if (parameters.getMaxNumFocusAreas() > 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Old focus areas: ");
            sb2.append(m(parameters.getFocusAreas()));
            List<Camera.Area> a2 = a(LogSeverity.WARNING_VALUE);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Setting focus area to : ");
            sb3.append(m(a2));
            parameters.setFocusAreas(a2);
        }
    }

    public static void i(Camera.Parameters parameters) {
        String b;
        if ("negative".equals(parameters.getColorEffect()) || (b = b("color effect", parameters.getSupportedColorEffects(), "negative")) == null) {
            return;
        }
        parameters.setColorEffect(b);
    }

    public static void j(Camera.Parameters parameters) {
        if (parameters.getMaxNumMeteringAreas() > 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Old metering areas: ");
            sb2.append(parameters.getMeteringAreas());
            List<Camera.Area> a2 = a(LogSeverity.WARNING_VALUE);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Setting metering area to : ");
            sb3.append(m(a2));
            parameters.setMeteringAreas(a2);
        }
    }

    public static void k(Camera.Parameters parameters, boolean z) {
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        String b = z ? b("flash mode", supportedFlashModes, "torch", "on") : b("flash mode", supportedFlashModes, "off");
        if (b != null) {
            if (b.equals(parameters.getFlashMode())) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Flash mode already set to ");
                sb2.append(b);
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Setting flash mode to ");
                sb3.append(b);
                parameters.setFlashMode(b);
            }
        }
    }

    public static void l(Camera.Parameters parameters) {
        if (!parameters.isVideoStabilizationSupported() || parameters.getVideoStabilization()) {
            return;
        }
        parameters.setVideoStabilization(true);
    }

    private static String m(Iterable iterable) {
        if (iterable == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Camera.Area area = (Camera.Area) it.next();
            sb2.append(area.rect);
            sb2.append(':');
            sb2.append(area.weight);
            sb2.append(' ');
        }
        return sb2.toString();
    }

    private static String n(Collection collection) {
        if (collection == null || collection.isEmpty()) {
            return "[]";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            sb2.append(Arrays.toString((int[]) it.next()));
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(']');
        return sb2.toString();
    }
}
