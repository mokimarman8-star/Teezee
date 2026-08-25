package androidx.compose.ui.semantics;

import kotlin.jvm.functions.Function2;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class SemanticsPropertiesAndroid {

    /* renamed from: a, reason: collision with root package name */
    public static final SemanticsPropertiesAndroid f4941a = new SemanticsPropertiesAndroid();

    /* renamed from: b, reason: collision with root package name */
    private static final SemanticsPropertyKey f4942b = new SemanticsPropertyKey("TestTagsAsResourceId", false, new Function2<Boolean, Boolean, Boolean>() { // from class: androidx.compose.ui.semantics.SemanticsPropertiesAndroid$TestTagsAsResourceId$1
        public final Boolean invoke(Boolean bool, boolean z5) {
            return bool;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke((Boolean) obj, ((Boolean) obj2).booleanValue());
        }
    });

    /* renamed from: c, reason: collision with root package name */
    public static final int f4943c = 8;

    private SemanticsPropertiesAndroid() {
    }

    public final SemanticsPropertyKey a() {
        return f4942b;
    }
}
