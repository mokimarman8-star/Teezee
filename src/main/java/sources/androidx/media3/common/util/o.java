package androidx.media3.common.util;

import android.opengl.GLES20;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    private final int f9095a;

    /* renamed from: b, reason: collision with root package name */
    private final a[] f9096b;

    /* renamed from: c, reason: collision with root package name */
    private final b[] f9097c;

    /* renamed from: d, reason: collision with root package name */
    private final Map f9098d;

    /* renamed from: e, reason: collision with root package name */
    private final Map f9099e;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f9100a;

        /* renamed from: b, reason: collision with root package name */
        private final int f9101b;

        private a(String str, int i5) {
            this.f9100a = str;
            this.f9101b = i5;
        }

        public static a a(int i5, int i6) {
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(i5, 35722, iArr, 0);
            int i7 = iArr[0];
            byte[] bArr = new byte[i7];
            GLES20.glGetActiveAttrib(i5, i6, i7, new int[1], 0, new int[1], 0, new int[1], 0, bArr, 0);
            String str = new String(bArr, 0, o.h(bArr));
            return new a(str, o.f(i5, str));
        }
    }

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f9102a;

        /* renamed from: b, reason: collision with root package name */
        private final int f9103b;

        /* renamed from: c, reason: collision with root package name */
        private final int f9104c;

        /* renamed from: d, reason: collision with root package name */
        private final float[] f9105d = new float[16];

        /* renamed from: e, reason: collision with root package name */
        private final int[] f9106e = new int[4];

        /* renamed from: f, reason: collision with root package name */
        private int f9107f = 9729;

        private b(String str, int i5, int i6) {
            this.f9102a = str;
            this.f9103b = i5;
            this.f9104c = i6;
        }

        public static b a(int i5, int i6) {
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(i5, 35719, iArr, 0);
            int[] iArr2 = new int[1];
            int i7 = iArr[0];
            byte[] bArr = new byte[i7];
            GLES20.glGetActiveUniform(i5, i6, i7, new int[1], 0, new int[1], 0, iArr2, 0, bArr, 0);
            String str = new String(bArr, 0, o.h(bArr));
            return new b(str, o.i(i5, str), iArr2[0]);
        }
    }

    public o(String str, String str2) {
        int glCreateProgram = GLES20.glCreateProgram();
        this.f9095a = glCreateProgram;
        GlUtil.b();
        d(glCreateProgram, 35633, str);
        d(glCreateProgram, 35632, str2);
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = {0};
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        GlUtil.c(iArr[0] == 1, "Unable to link shader program: \n" + GLES20.glGetProgramInfoLog(glCreateProgram));
        GLES20.glUseProgram(glCreateProgram);
        this.f9098d = new HashMap();
        int[] iArr2 = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35721, iArr2, 0);
        this.f9096b = new a[iArr2[0]];
        for (int i5 = 0; i5 < iArr2[0]; i5++) {
            a a5 = a.a(this.f9095a, i5);
            this.f9096b[i5] = a5;
            this.f9098d.put(a5.f9100a, a5);
        }
        this.f9099e = new HashMap();
        int[] iArr3 = new int[1];
        GLES20.glGetProgramiv(this.f9095a, 35718, iArr3, 0);
        this.f9097c = new b[iArr3[0]];
        for (int i6 = 0; i6 < iArr3[0]; i6++) {
            b a6 = b.a(this.f9095a, i6);
            this.f9097c[i6] = a6;
            this.f9099e.put(a6.f9102a, a6);
        }
        GlUtil.b();
    }

    private static void d(int i5, int i6, String str) {
        int glCreateShader = GLES20.glCreateShader(i6);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = {0};
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        GlUtil.c(iArr[0] == 1, GLES20.glGetShaderInfoLog(glCreateShader) + ", source: \n" + str);
        GLES20.glAttachShader(i5, glCreateShader);
        GLES20.glDeleteShader(glCreateShader);
        GlUtil.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int f(int i5, String str) {
        return GLES20.glGetAttribLocation(i5, str);
    }

    private int g(String str) {
        return f(this.f9095a, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int h(byte[] bArr) {
        for (int i5 = 0; i5 < bArr.length; i5++) {
            if (bArr[i5] == 0) {
                return i5;
            }
        }
        return bArr.length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int i(int i5, String str) {
        return GLES20.glGetUniformLocation(i5, str);
    }

    public int e(String str) {
        int g5 = g(str);
        GLES20.glEnableVertexAttribArray(g5);
        GlUtil.b();
        return g5;
    }

    public int j(String str) {
        return i(this.f9095a, str);
    }
}
