package androidx.media3.common.util;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.opengl.Matrix;
import android.os.Build;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class GlUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f9021a = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f9022b = {12352, 4, 12324, 10, 12323, 10, 12322, 10, 12321, 2, 12325, 0, 12326, 0, 12344};

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f9023c = {12445, 13120, 12344, 12344};

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f9024d = {12445, 13632, 12344, 12344};

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f9025e = {12344};

    public static final class GlException extends Exception {
        public GlException(String str) {
            super(str);
        }
    }

    public static void a(int i5, int i6, int i7) {
        GLES20.glBindTexture(i5, i6);
        b();
        GLES20.glTexParameteri(i5, 10240, i7);
        b();
        GLES20.glTexParameteri(i5, 10241, i7);
        b();
        GLES20.glTexParameteri(i5, 10242, 33071);
        b();
        GLES20.glTexParameteri(i5, 10243, 33071);
        b();
    }

    public static void b() {
        StringBuilder sb = new StringBuilder();
        boolean z5 = false;
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError == 0) {
                break;
            }
            if (z5) {
                sb.append('\n');
            }
            String gluErrorString = GLU.gluErrorString(glGetError);
            if (gluErrorString == null) {
                gluErrorString = "error code: 0x" + Integer.toHexString(glGetError);
            }
            sb.append("glError: ");
            sb.append(gluErrorString);
            z5 = true;
        }
        if (z5) {
            throw new GlException(sb.toString());
        }
    }

    public static void c(boolean z5, String str) {
        if (!z5) {
            throw new GlException(str);
        }
    }

    private static FloatBuffer d(int i5) {
        return ByteBuffer.allocateDirect(i5 * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }

    public static FloatBuffer e(float[] fArr) {
        return (FloatBuffer) d(fArr.length).put(fArr).flip();
    }

    public static int f() {
        int g5 = g();
        a(36197, g5, 9729);
        return g5;
    }

    public static int g() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        b();
        return iArr[0];
    }

    private static boolean h(String str) {
        String eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
        return eglQueryString != null && eglQueryString.contains(str);
    }

    public static boolean i(Context context) {
        int i5 = a1.f9026a;
        if (i5 < 24) {
            return false;
        }
        if (i5 < 26 && ("samsung".equals(Build.MANUFACTURER) || "XT1650".equals(Build.MODEL))) {
            return false;
        }
        if (i5 >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) {
            return h("EGL_EXT_protected_content");
        }
        return false;
    }

    public static boolean j() {
        return h("EGL_KHR_surfaceless_context");
    }

    public static void k(float[] fArr) {
        Matrix.setIdentityM(fArr, 0);
    }
}
