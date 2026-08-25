package androidx.datastore.migrations;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.datastore.flow.f;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class SharedPreferencesMigration implements f {

    /* renamed from: a, reason: collision with root package name */
    private final Function2 f7486a;

    /* renamed from: b, reason: collision with root package name */
    private final Function3 f7487b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f7488c;

    /* renamed from: d, reason: collision with root package name */
    private final String f7489d;

    /* renamed from: e, reason: collision with root package name */
    private final Lazy f7490e;

    /* renamed from: f, reason: collision with root package name */
    private final Set f7491f;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@"}, d2 = {"<anonymous>", "", "T", "it"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.datastore.migrations.SharedPreferencesMigration$3", f = "SharedPreferencesMigration.android.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.datastore.migrations.SharedPreferencesMigration$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<Object, Continuation<? super Boolean>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(continuation);
        }

        public final Object invoke(Object obj, Continuation<? super Boolean> continuation) {
            return create(obj, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return Boxing.a(true);
        }
    }

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f7492a = new a();

        private a() {
        }

        @JvmStatic
        public static final boolean a(Context context, String str) {
            Intrinsics.h(context, "context");
            Intrinsics.h(str, "name");
            return context.deleteSharedPreferences(str);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigration(final Context context, final String str, Set set, Function2 function2, Function3 function3) {
        this(new Function0<SharedPreferences>() { // from class: androidx.datastore.migrations.SharedPreferencesMigration.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final SharedPreferences m337invoke() {
                SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
                Intrinsics.g(sharedPreferences, "context.getSharedPrefere…me, Context.MODE_PRIVATE)");
                return sharedPreferences;
            }
        }, set, function2, function3, context, str);
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "sharedPreferencesName");
        Intrinsics.h(set, "keysToMigrate");
        Intrinsics.h(function2, "shouldRunMigration");
        Intrinsics.h(function3, "migrate");
    }

    public /* synthetic */ SharedPreferencesMigration(Context context, String str, Set set, Function2 function2, Function3 function3, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, (i5 & 4) != 0 ? androidx.datastore.migrations.a.a() : set, (i5 & 8) != 0 ? new AnonymousClass3(null) : function2, function3);
    }

    private SharedPreferencesMigration(Function0 function0, Set set, Function2 function2, Function3 function3, Context context, String str) {
        this.f7486a = function2;
        this.f7487b = function3;
        this.f7488c = context;
        this.f7489d = str;
        this.f7490e = LazyKt.b(function0);
        this.f7491f = set == androidx.datastore.migrations.a.a() ? null : CollectionsKt.V0(set);
    }

    private final void d(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            a.a(context, str);
            return;
        }
        File g5 = g(context, str);
        File f5 = f(g5);
        g5.delete();
        f5.delete();
    }

    private final SharedPreferences e() {
        return (SharedPreferences) this.f7490e.getValue();
    }

    private final File f(File file) {
        return new File(file.getPath() + ".bak");
    }

    private final File g(Context context, String str) {
        return new File(new File(context.getApplicationInfo().dataDir, "shared_prefs"), str + ".xml");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0069, code lost:
    
        if (r5.isEmpty() == false) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // androidx.datastore.flow.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(Object obj, Continuation continuation) {
        SharedPreferencesMigration$shouldMigrate$1 sharedPreferencesMigration$shouldMigrate$1;
        Object obj2;
        int i5;
        SharedPreferencesMigration sharedPreferencesMigration;
        if (continuation instanceof SharedPreferencesMigration$shouldMigrate$1) {
            sharedPreferencesMigration$shouldMigrate$1 = (SharedPreferencesMigration$shouldMigrate$1) continuation;
            int i6 = sharedPreferencesMigration$shouldMigrate$1.label;
            if ((i6 & EditorInfoCompat.IME_FLAG_FORCE_ASCII) != 0) {
                sharedPreferencesMigration$shouldMigrate$1.label = i6 - EditorInfoCompat.IME_FLAG_FORCE_ASCII;
                obj2 = sharedPreferencesMigration$shouldMigrate$1.result;
                Object f5 = IntrinsicsKt.f();
                i5 = sharedPreferencesMigration$shouldMigrate$1.label;
                boolean z5 = true;
                if (i5 != 0) {
                    ResultKt.b(obj2);
                    Function2 function2 = this.f7486a;
                    sharedPreferencesMigration$shouldMigrate$1.L$0 = this;
                    sharedPreferencesMigration$shouldMigrate$1.label = 1;
                    obj2 = function2.invoke(obj, sharedPreferencesMigration$shouldMigrate$1);
                    if (obj2 == f5) {
                        return f5;
                    }
                    sharedPreferencesMigration = this;
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    sharedPreferencesMigration = (SharedPreferencesMigration) sharedPreferencesMigration$shouldMigrate$1.L$0;
                    ResultKt.b(obj2);
                }
                if (((Boolean) obj2).booleanValue()) {
                    return Boxing.a(false);
                }
                Set set = sharedPreferencesMigration.f7491f;
                if (set != null) {
                    Set set2 = set;
                    SharedPreferences e5 = sharedPreferencesMigration.e();
                    if (!(set2 instanceof Collection) || !set2.isEmpty()) {
                        Iterator it = set2.iterator();
                        while (it.hasNext()) {
                            if (e5.contains((String) it.next())) {
                                break;
                            }
                        }
                    }
                    z5 = false;
                    return Boxing.a(z5);
                }
                Map<String, ?> all = sharedPreferencesMigration.e().getAll();
                Intrinsics.g(all, "sharedPrefs.all");
            }
        }
        sharedPreferencesMigration$shouldMigrate$1 = new SharedPreferencesMigration$shouldMigrate$1(this, continuation);
        obj2 = sharedPreferencesMigration$shouldMigrate$1.result;
        Object f52 = IntrinsicsKt.f();
        i5 = sharedPreferencesMigration$shouldMigrate$1.label;
        boolean z52 = true;
        if (i5 != 0) {
        }
        if (((Boolean) obj2).booleanValue()) {
        }
    }

    @Override // androidx.datastore.flow.f
    public Object b(Continuation continuation) {
        Context context;
        String str;
        SharedPreferences.Editor edit = e().edit();
        Set set = this.f7491f;
        if (set == null) {
            edit.clear();
        } else {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                edit.remove((String) it.next());
            }
        }
        if (!edit.commit()) {
            throw new IOException("Unable to delete migrated keys from SharedPreferences.");
        }
        if (e().getAll().isEmpty() && (context = this.f7488c) != null && (str = this.f7489d) != null) {
            d(context, str);
        }
        Set set2 = this.f7491f;
        if (set2 != null) {
            set2.clear();
        }
        return Unit.a;
    }

    @Override // androidx.datastore.flow.f
    public Object c(Object obj, Continuation continuation) {
        return this.f7487b.invoke(new b(e(), this.f7491f), obj, continuation);
    }
}
