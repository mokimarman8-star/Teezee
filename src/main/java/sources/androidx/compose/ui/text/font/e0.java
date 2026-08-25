package androidx.compose.ui.text.font;

import androidx.compose.runtime.a3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface e0 extends a3 {

    public static final class a implements e0 {

        /* renamed from: a, reason: collision with root package name */
        private final Object f5118a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f5119b;

        public a(Object obj, boolean z5) {
            this.f5118a = obj;
            this.f5119b = z5;
        }

        public /* synthetic */ a(Object obj, boolean z5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, (i5 & 2) != 0 ? true : z5);
        }

        @Override // androidx.compose.ui.text.font.e0
        public boolean a() {
            return this.f5119b;
        }

        @Override // androidx.compose.runtime.a3
        public Object getValue() {
            return this.f5118a;
        }
    }

    boolean a();
}
