package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.navigation.Navigator;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import org.mvel2.ast.ASTNode;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001f B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ7\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Landroidx/navigation/ActivityNavigator;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/ActivityNavigator$b;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "l", "()Landroidx/navigation/ActivityNavigator$b;", "", "k", "()Z", "destination", "Landroid/os/Bundle;", "args", "Landroidx/navigation/l;", "navOptions", "Landroidx/navigation/Navigator$a;", "navigatorExtras", "Landroidx/navigation/NavDestination;", "m", "(Landroidx/navigation/ActivityNavigator$b;Landroid/os/Bundle;Landroidx/navigation/l;Landroidx/navigation/Navigator$a;)Landroidx/navigation/NavDestination;", "c", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Landroid/app/Activity;", "d", "Landroid/app/Activity;", "hostActivity", "e", "a", "b", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Navigator.b("activity")
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class ActivityNavigator extends Navigator {
    public static final a e = new a((DefaultConstructorMarker) null);

    /* renamed from: c, reason: from kotlin metadata */
    private final Context context;

    /* renamed from: d, reason: from kotlin metadata */
    private final Activity hostActivity;

    public ActivityNavigator(Context context) {
        Object obj;
        Intrinsics.h(context, "context");
        this.context = context;
        Iterator it = SequencesKt.h(context, new Function1<Context, Context>() { // from class: androidx.navigation.ActivityNavigator$hostActivity$1
            public final Context invoke(Context context2) {
                Intrinsics.h(context2, "it");
                if (context2 instanceof ContextWrapper) {
                    return ((ContextWrapper) context2).getBaseContext();
                }
                return null;
            }
        }).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (((Context) obj) instanceof Activity) {
                    break;
                }
            }
        }
        this.hostActivity = (Activity) obj;
    }

    @Override // androidx.navigation.Navigator
    public boolean k() {
        Activity activity = this.hostActivity;
        if (activity == null) {
            return false;
        }
        activity.finish();
        return true;
    }

    @Override // androidx.navigation.Navigator
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public b a() {
        return new b(this);
    }

    @Override // androidx.navigation.Navigator
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public NavDestination d(b destination, Bundle args, l navOptions, Navigator.a navigatorExtras) {
        Intent intent;
        int intExtra;
        Intrinsics.h(destination, "destination");
        if (destination.C() == null) {
            throw new IllegalStateException(("Destination " + destination.n() + " does not have an Intent set.").toString());
        }
        Intent intent2 = new Intent(destination.C());
        if (args != null) {
            intent2.putExtras(args);
            String B = destination.B();
            if (B != null && B.length() != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(B);
                while (matcher.find()) {
                    String group = matcher.group(1);
                    if (!args.containsKey(group)) {
                        throw new IllegalArgumentException("Could not find " + ((Object) group) + " in " + args + " to fill data pattern " + ((Object) B));
                    }
                    matcher.appendReplacement(stringBuffer, "");
                    stringBuffer.append(Uri.encode(String.valueOf(args.get(group))));
                }
                matcher.appendTail(stringBuffer);
                intent2.setData(Uri.parse(stringBuffer.toString()));
            }
        }
        if (this.hostActivity == null) {
            intent2.addFlags(ASTNode.DEOP);
        }
        if (navOptions != null && navOptions.g()) {
            intent2.addFlags(ASTNode.DISCARD);
        }
        Activity activity = this.hostActivity;
        if (activity != null && (intent = activity.getIntent()) != null && (intExtra = intent.getIntExtra("android-support-navigation:ActivityNavigator:current", 0)) != 0) {
            intent2.putExtra("android-support-navigation:ActivityNavigator:source", intExtra);
        }
        intent2.putExtra("android-support-navigation:ActivityNavigator:current", destination.n());
        Resources resources = this.context.getResources();
        if (navOptions != null) {
            int c = navOptions.c();
            int d = navOptions.d();
            if ((c <= 0 || !Intrinsics.c(resources.getResourceTypeName(c), "animator")) && (d <= 0 || !Intrinsics.c(resources.getResourceTypeName(d), "animator"))) {
                intent2.putExtra("android-support-navigation:ActivityNavigator:popEnterAnim", c);
                intent2.putExtra("android-support-navigation:ActivityNavigator:popExitAnim", d);
            } else {
                Log.w("ActivityNavigator", "Activity destinations do not support Animator resource. Ignoring popEnter resource " + ((Object) resources.getResourceName(c)) + " and popExit resource " + ((Object) resources.getResourceName(d)) + " when launching " + destination);
            }
        }
        this.context.startActivity(intent2);
        if (navOptions == null || this.hostActivity == null) {
            return null;
        }
        int a = navOptions.a();
        int b = navOptions.b();
        if ((a <= 0 || !Intrinsics.c(resources.getResourceTypeName(a), "animator")) && (b <= 0 || !Intrinsics.c(resources.getResourceTypeName(b), "animator"))) {
            if (a < 0 && b < 0) {
                return null;
            }
            this.hostActivity.overridePendingTransition(RangesKt.e(a, 0), RangesKt.e(b, 0));
            return null;
        }
        Log.w("ActivityNavigator", "Activity destinations do not support Animator resource. Ignoring enter resource " + ((Object) resources.getResourceName(a)) + " and exit resource " + ((Object) resources.getResourceName(b)) + "when launching " + destination);
        return null;
    }
}
