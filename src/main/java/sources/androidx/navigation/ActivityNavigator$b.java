package androidx.navigation;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.util.AttributeSet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class ActivityNavigator$b extends NavDestination {

    /* renamed from: l, reason: collision with root package name */
    private Intent f12433l;

    /* renamed from: m, reason: collision with root package name */
    private String f12434m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityNavigator$b(Navigator navigator) {
        super(navigator);
        Intrinsics.h(navigator, "activityNavigator");
    }

    public final ComponentName A() {
        Intent intent = this.f12433l;
        if (intent == null) {
            return null;
        }
        return intent.getComponent();
    }

    public final String B() {
        return this.f12434m;
    }

    public final Intent C() {
        return this.f12433l;
    }

    public final ActivityNavigator$b D(String str) {
        if (this.f12433l == null) {
            this.f12433l = new Intent();
        }
        Intent intent = this.f12433l;
        Intrinsics.e(intent);
        intent.setAction(str);
        return this;
    }

    public final ActivityNavigator$b E(ComponentName componentName) {
        if (this.f12433l == null) {
            this.f12433l = new Intent();
        }
        Intent intent = this.f12433l;
        Intrinsics.e(intent);
        intent.setComponent(componentName);
        return this;
    }

    public final ActivityNavigator$b F(Uri uri) {
        if (this.f12433l == null) {
            this.f12433l = new Intent();
        }
        Intent intent = this.f12433l;
        Intrinsics.e(intent);
        intent.setData(uri);
        return this;
    }

    public final ActivityNavigator$b G(String str) {
        this.f12434m = str;
        return this;
    }

    public final ActivityNavigator$b H(String str) {
        if (this.f12433l == null) {
            this.f12433l = new Intent();
        }
        Intent intent = this.f12433l;
        Intrinsics.e(intent);
        intent.setPackage(str);
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ActivityNavigator$b) || !super.equals(obj)) {
            return false;
        }
        Intent intent = this.f12433l;
        Boolean valueOf = intent == null ? null : Boolean.valueOf(intent.filterEquals(((ActivityNavigator$b) obj).f12433l));
        return (valueOf == null ? ((ActivityNavigator$b) obj).f12433l == null : valueOf.booleanValue()) && Intrinsics.c(this.f12434m, ((ActivityNavigator$b) obj).f12434m);
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        Intent intent = this.f12433l;
        int filterHashCode = (hashCode + (intent == null ? 0 : intent.filterHashCode())) * 31;
        String str = this.f12434m;
        return filterHashCode + (str != null ? str.hashCode() : 0);
    }

    public void s(Context context, AttributeSet attributeSet) {
        Intrinsics.h(context, "context");
        Intrinsics.h(attributeSet, "attrs");
        super.s(context, attributeSet);
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.ActivityNavigator);
        Intrinsics.g(obtainAttributes, "context.resources.obtain…tyNavigator\n            )");
        String string = obtainAttributes.getString(R.styleable.ActivityNavigator_targetPackage);
        if (string != null) {
            String packageName = context.getPackageName();
            Intrinsics.g(packageName, "context.packageName");
            string = StringsKt.Q(string, "${applicationId}", packageName, false, 4, (Object) null);
        }
        H(string);
        String string2 = obtainAttributes.getString(R.styleable.ActivityNavigator_android_name);
        if (string2 != null) {
            if (string2.charAt(0) == '.') {
                string2 = Intrinsics.q(context.getPackageName(), string2);
            }
            E(new ComponentName(context, string2));
        }
        D(obtainAttributes.getString(R.styleable.ActivityNavigator_action));
        String string3 = obtainAttributes.getString(R.styleable.ActivityNavigator_data);
        if (string3 != null) {
            F(Uri.parse(string3));
        }
        G(obtainAttributes.getString(R.styleable.ActivityNavigator_dataPattern));
        obtainAttributes.recycle();
    }

    public String toString() {
        ComponentName A = A();
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        if (A != null) {
            sb.append(" class=");
            sb.append(A.getClassName());
        } else {
            String z5 = z();
            if (z5 != null) {
                sb.append(" action=");
                sb.append(z5);
            }
        }
        String sb2 = sb.toString();
        Intrinsics.g(sb2, "sb.toString()");
        return sb2;
    }

    public boolean y() {
        return false;
    }

    public final String z() {
        Intent intent = this.f12433l;
        if (intent == null) {
            return null;
        }
        return intent.getAction();
    }
}
