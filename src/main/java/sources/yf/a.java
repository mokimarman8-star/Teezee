package yf;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class a implements j8.b {
    private ThreadLocal a = new C0164a();

    /* renamed from: yf.a$a, reason: collision with other inner class name */
    public static final class C0164a extends ThreadLocal {
        C0164a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        }
    }

    public String a(int i, long j) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) this.a.get();
        if (simpleDateFormat != null) {
            simpleDateFormat.setTimeZone(TimeZone.getDefault());
        }
        if (simpleDateFormat == null) {
            return UUID.randomUUID() + ".log";
        }
        return simpleDateFormat.format(new Date(j)) + ".log";
    }

    public boolean b() {
        return true;
    }
}
