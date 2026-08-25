package androidx.sqlite.db.framework;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public /* synthetic */ class FrameworkSQLiteOpenHelper$OpenHelper$b {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f13400a;

    static {
        int[] iArr = new int[FrameworkSQLiteOpenHelper$OpenHelper$CallbackName.values().length];
        try {
            iArr[FrameworkSQLiteOpenHelper$OpenHelper$CallbackName.ON_CONFIGURE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[FrameworkSQLiteOpenHelper$OpenHelper$CallbackName.ON_CREATE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr[FrameworkSQLiteOpenHelper$OpenHelper$CallbackName.ON_UPGRADE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr[FrameworkSQLiteOpenHelper$OpenHelper$CallbackName.ON_DOWNGRADE.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr[FrameworkSQLiteOpenHelper$OpenHelper$CallbackName.ON_OPEN.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        f13400a = iArr;
    }
}
