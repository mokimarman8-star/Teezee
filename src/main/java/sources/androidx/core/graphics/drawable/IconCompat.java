package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.util.i;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k, reason: collision with root package name */
    static final PorterDuff.Mode f6998k = PorterDuff.Mode.SRC_IN;

    /* renamed from: a, reason: collision with root package name */
    public int f6999a;

    /* renamed from: b, reason: collision with root package name */
    Object f7000b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f7001c;

    /* renamed from: d, reason: collision with root package name */
    public Parcelable f7002d;

    /* renamed from: e, reason: collision with root package name */
    public int f7003e;

    /* renamed from: f, reason: collision with root package name */
    public int f7004f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f7005g;

    /* renamed from: h, reason: collision with root package name */
    PorterDuff.Mode f7006h;

    /* renamed from: i, reason: collision with root package name */
    public String f7007i;

    /* renamed from: j, reason: collision with root package name */
    public String f7008j;

    static class a {
        static IconCompat a(Object obj) {
            i.g(obj);
            int d5 = d(obj);
            if (d5 == 2) {
                return IconCompat.k(null, c(obj), b(obj));
            }
            if (d5 == 4) {
                return IconCompat.h(e(obj));
            }
            if (d5 == 6) {
                return IconCompat.e(e(obj));
            }
            IconCompat iconCompat = new IconCompat(-1);
            iconCompat.f7000b = obj;
            return iconCompat;
        }

        static int b(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.a(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getResId", null).invoke(obj, null)).intValue();
            } catch (IllegalAccessException e5) {
                Log.e("IconCompat", "Unable to get icon resource", e5);
                return 0;
            } catch (NoSuchMethodException e6) {
                Log.e("IconCompat", "Unable to get icon resource", e6);
                return 0;
            } catch (InvocationTargetException e7) {
                Log.e("IconCompat", "Unable to get icon resource", e7);
                return 0;
            }
        }

        static String c(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.b(obj);
            }
            try {
                return (String) obj.getClass().getMethod("getResPackage", null).invoke(obj, null);
            } catch (IllegalAccessException e5) {
                Log.e("IconCompat", "Unable to get icon package", e5);
                return null;
            } catch (NoSuchMethodException e6) {
                Log.e("IconCompat", "Unable to get icon package", e6);
                return null;
            } catch (InvocationTargetException e7) {
                Log.e("IconCompat", "Unable to get icon package", e7);
                return null;
            }
        }

        static int d(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.c(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getType", null).invoke(obj, null)).intValue();
            } catch (IllegalAccessException e5) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e5);
                return -1;
            } catch (NoSuchMethodException e6) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e6);
                return -1;
            } catch (InvocationTargetException e7) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e7);
                return -1;
            }
        }

        static Uri e(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.d(obj);
            }
            try {
                return (Uri) obj.getClass().getMethod("getUri", null).invoke(obj, null);
            } catch (IllegalAccessException e5) {
                Log.e("IconCompat", "Unable to get icon uri", e5);
                return null;
            } catch (NoSuchMethodException e6) {
                Log.e("IconCompat", "Unable to get icon uri", e6);
                return null;
            } catch (InvocationTargetException e7) {
                Log.e("IconCompat", "Unable to get icon uri", e7);
                return null;
            }
        }

        static Drawable f(Icon icon, Context context) {
            return icon.loadDrawable(context);
        }

        static Icon g(IconCompat iconCompat, Context context) {
            Icon createWithBitmap;
            switch (iconCompat.f6999a) {
                case -1:
                    return (Icon) iconCompat.f7000b;
                case 0:
                default:
                    throw new IllegalArgumentException("Unknown type");
                case 1:
                    createWithBitmap = Icon.createWithBitmap((Bitmap) iconCompat.f7000b);
                    break;
                case 2:
                    createWithBitmap = Icon.createWithResource(iconCompat.n(), iconCompat.f7003e);
                    break;
                case 3:
                    createWithBitmap = Icon.createWithData((byte[]) iconCompat.f7000b, iconCompat.f7003e, iconCompat.f7004f);
                    break;
                case 4:
                    createWithBitmap = Icon.createWithContentUri((String) iconCompat.f7000b);
                    break;
                case 5:
                    if (Build.VERSION.SDK_INT < 26) {
                        createWithBitmap = Icon.createWithBitmap(IconCompat.d((Bitmap) iconCompat.f7000b, false));
                        break;
                    } else {
                        createWithBitmap = b.a((Bitmap) iconCompat.f7000b);
                        break;
                    }
                case 6:
                    int i5 = Build.VERSION.SDK_INT;
                    if (i5 >= 30) {
                        createWithBitmap = d.a(iconCompat.q());
                        break;
                    } else {
                        if (context == null) {
                            throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + iconCompat.q());
                        }
                        InputStream r5 = iconCompat.r(context);
                        if (r5 == null) {
                            throw new IllegalStateException("Cannot load adaptive icon from uri: " + iconCompat.q());
                        }
                        if (i5 < 26) {
                            createWithBitmap = Icon.createWithBitmap(IconCompat.d(BitmapFactory.decodeStream(r5), false));
                            break;
                        } else {
                            createWithBitmap = b.a(BitmapFactory.decodeStream(r5));
                            break;
                        }
                    }
            }
            ColorStateList colorStateList = iconCompat.f7005g;
            if (colorStateList != null) {
                createWithBitmap.setTintList(colorStateList);
            }
            PorterDuff.Mode mode = iconCompat.f7006h;
            if (mode != IconCompat.f6998k) {
                createWithBitmap.setTintMode(mode);
            }
            return createWithBitmap;
        }
    }

    static class b {
        static Icon a(Bitmap bitmap) {
            return Icon.createWithAdaptiveBitmap(bitmap);
        }
    }

    static class c {
        static int a(Object obj) {
            return ((Icon) obj).getResId();
        }

        static String b(Object obj) {
            return ((Icon) obj).getResPackage();
        }

        static int c(Object obj) {
            return ((Icon) obj).getType();
        }

        static Uri d(Object obj) {
            return ((Icon) obj).getUri();
        }
    }

    static class d {
        static Icon a(Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri(uri);
        }
    }

    public IconCompat() {
        this.f6999a = -1;
        this.f7001c = null;
        this.f7002d = null;
        this.f7003e = 0;
        this.f7004f = 0;
        this.f7005g = null;
        this.f7006h = f6998k;
        this.f7007i = null;
    }

    IconCompat(int i5) {
        this.f7001c = null;
        this.f7002d = null;
        this.f7003e = 0;
        this.f7004f = 0;
        this.f7005g = null;
        this.f7006h = f6998k;
        this.f7007i = null;
        this.f6999a = i5;
    }

    public static IconCompat b(Icon icon) {
        return a.a(icon);
    }

    public static IconCompat c(Icon icon) {
        if (a.d(icon) == 2 && a.b(icon) == 0) {
            return null;
        }
        return a.a(icon);
    }

    static Bitmap d(Bitmap bitmap, boolean z5) {
        int min = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f5 = min;
        float f6 = 0.5f * f5;
        float f7 = 0.9166667f * f6;
        if (z5) {
            float f8 = 0.010416667f * f5;
            paint.setColor(0);
            paint.setShadowLayer(f8, 0.0f, f5 * 0.020833334f, 1023410176);
            canvas.drawCircle(f6, f6, f7, paint);
            paint.setShadowLayer(f8, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f6, f6, f7, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - min)) / 2.0f, (-(bitmap.getHeight() - min)) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f6, f6, f7, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }

    public static IconCompat e(Uri uri) {
        androidx.core.util.d.c(uri);
        return f(uri.toString());
    }

    public static IconCompat f(String str) {
        androidx.core.util.d.c(str);
        IconCompat iconCompat = new IconCompat(6);
        iconCompat.f7000b = str;
        return iconCompat;
    }

    public static IconCompat g(Bitmap bitmap) {
        androidx.core.util.d.c(bitmap);
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.f7000b = bitmap;
        return iconCompat;
    }

    public static IconCompat h(Uri uri) {
        androidx.core.util.d.c(uri);
        return i(uri.toString());
    }

    public static IconCompat i(String str) {
        androidx.core.util.d.c(str);
        IconCompat iconCompat = new IconCompat(4);
        iconCompat.f7000b = str;
        return iconCompat;
    }

    public static IconCompat j(Context context, int i5) {
        androidx.core.util.d.c(context);
        return k(context.getResources(), context.getPackageName(), i5);
    }

    public static IconCompat k(Resources resources, String str, int i5) {
        androidx.core.util.d.c(str);
        if (i5 == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.f7003e = i5;
        if (resources != null) {
            try {
                iconCompat.f7000b = resources.getResourceName(i5);
            } catch (Resources.NotFoundException unused) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        } else {
            iconCompat.f7000b = str;
        }
        iconCompat.f7008j = str;
        return iconCompat;
    }

    static Resources o(Context context, String str) {
        if ("android".equals(str)) {
            return Resources.getSystem();
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 8192);
            if (applicationInfo != null) {
                return packageManager.getResourcesForApplication(applicationInfo);
            }
            return null;
        } catch (PackageManager.NameNotFoundException e5) {
            Log.e("IconCompat", String.format("Unable to find pkg=%s for icon", str), e5);
            return null;
        }
    }

    private static String y(int i5) {
        switch (i5) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    public void a(Context context) {
        Object obj;
        if (this.f6999a != 2 || (obj = this.f7000b) == null) {
            return;
        }
        String str = (String) obj;
        if (str.contains(":")) {
            String str2 = str.split(":", -1)[1];
            String str3 = str2.split("/", -1)[0];
            String str4 = str2.split("/", -1)[1];
            String str5 = str.split(":", -1)[0];
            if ("0_resource_name_obfuscated".equals(str4)) {
                return;
            }
            String n5 = n();
            int identifier = o(context, n5).getIdentifier(str4, str3, str5);
            if (this.f7003e != identifier) {
                StringBuilder sb = new StringBuilder();
                sb.append("Id has changed for ");
                sb.append(n5);
                sb.append(" ");
                sb.append(str);
                this.f7003e = identifier;
            }
        }
    }

    public Bitmap l() {
        int i5 = this.f6999a;
        if (i5 == -1) {
            Object obj = this.f7000b;
            if (obj instanceof Bitmap) {
                return (Bitmap) obj;
            }
            return null;
        }
        if (i5 == 1) {
            return (Bitmap) this.f7000b;
        }
        if (i5 == 5) {
            return d((Bitmap) this.f7000b, true);
        }
        throw new IllegalStateException("called getBitmap() on " + this);
    }

    public int m() {
        int i5 = this.f6999a;
        if (i5 == -1) {
            return a.b(this.f7000b);
        }
        if (i5 == 2) {
            return this.f7003e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String n() {
        int i5 = this.f6999a;
        if (i5 == -1) {
            return a.c(this.f7000b);
        }
        if (i5 == 2) {
            String str = this.f7008j;
            return (str == null || TextUtils.isEmpty(str)) ? ((String) this.f7000b).split(":", -1)[0] : this.f7008j;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int p() {
        int i5 = this.f6999a;
        return i5 == -1 ? a.d(this.f7000b) : i5;
    }

    public Uri q() {
        int i5 = this.f6999a;
        if (i5 == -1) {
            return a.e(this.f7000b);
        }
        if (i5 == 4 || i5 == 6) {
            return Uri.parse((String) this.f7000b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public InputStream r(Context context) {
        Uri q5 = q();
        String scheme = q5.getScheme();
        if ("content".equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(q5);
            } catch (Exception e5) {
                Log.w("IconCompat", "Unable to load image from URI: " + q5, e5);
                return null;
            }
        }
        try {
            return new FileInputStream(new File((String) this.f7000b));
        } catch (FileNotFoundException e6) {
            Log.w("IconCompat", "Unable to load image from path: " + q5, e6);
            return null;
        }
    }

    public Drawable s(Context context) {
        a(context);
        return a.f(x(context), context);
    }

    public void t() {
        this.f7006h = PorterDuff.Mode.valueOf(this.f7007i);
        switch (this.f6999a) {
            case -1:
                Parcelable parcelable = this.f7002d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                this.f7000b = parcelable;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                Parcelable parcelable2 = this.f7002d;
                if (parcelable2 != null) {
                    this.f7000b = parcelable2;
                    return;
                }
                byte[] bArr = this.f7001c;
                this.f7000b = bArr;
                this.f6999a = 3;
                this.f7003e = 0;
                this.f7004f = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f7001c, Charset.forName("UTF-16"));
                this.f7000b = str;
                if (this.f6999a == 2 && this.f7008j == null) {
                    this.f7008j = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.f7000b = this.f7001c;
                return;
        }
    }

    public String toString() {
        if (this.f6999a == -1) {
            return String.valueOf(this.f7000b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(y(this.f6999a));
        switch (this.f6999a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f7000b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f7000b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f7008j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(m())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f7003e);
                if (this.f7004f != 0) {
                    sb.append(" off=");
                    sb.append(this.f7004f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f7000b);
                break;
        }
        if (this.f7005g != null) {
            sb.append(" tint=");
            sb.append(this.f7005g);
        }
        if (this.f7006h != f6998k) {
            sb.append(" mode=");
            sb.append(this.f7006h);
        }
        sb.append(")");
        return sb.toString();
    }

    public void u(boolean z5) {
        this.f7007i = this.f7006h.name();
        switch (this.f6999a) {
            case -1:
                if (z5) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                this.f7002d = (Parcelable) this.f7000b;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (!z5) {
                    this.f7002d = (Parcelable) this.f7000b;
                    return;
                }
                Bitmap bitmap = (Bitmap) this.f7000b;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                this.f7001c = byteArrayOutputStream.toByteArray();
                return;
            case 2:
                this.f7001c = ((String) this.f7000b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f7001c = (byte[]) this.f7000b;
                return;
            case 4:
            case 6:
                this.f7001c = this.f7000b.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
    }

    public Bundle v() {
        Bundle bundle = new Bundle();
        switch (this.f6999a) {
            case -1:
                bundle.putParcelable("obj", (Parcelable) this.f7000b);
                break;
            case 0:
            default:
                throw new IllegalArgumentException("Invalid icon");
            case 1:
            case 5:
                bundle.putParcelable("obj", (Bitmap) this.f7000b);
                break;
            case 2:
            case 4:
            case 6:
                bundle.putString("obj", (String) this.f7000b);
                break;
            case 3:
                bundle.putByteArray("obj", (byte[]) this.f7000b);
                break;
        }
        bundle.putInt("type", this.f6999a);
        bundle.putInt("int1", this.f7003e);
        bundle.putInt("int2", this.f7004f);
        bundle.putString("string1", this.f7008j);
        ColorStateList colorStateList = this.f7005g;
        if (colorStateList != null) {
            bundle.putParcelable("tint_list", colorStateList);
        }
        PorterDuff.Mode mode = this.f7006h;
        if (mode != f6998k) {
            bundle.putString("tint_mode", mode.name());
        }
        return bundle;
    }

    public Icon w() {
        return x(null);
    }

    public Icon x(Context context) {
        return a.g(this, context);
    }
}
