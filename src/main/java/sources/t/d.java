package t;

import java.util.List;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface d extends List, b, KMappedMarker {

    /* JADX INFO: Access modifiers changed from: private */
    static final class a extends AbstractList implements d {

        /* renamed from: a, reason: collision with root package name */
        private final d f17813a;

        /* renamed from: b, reason: collision with root package name */
        private final int f17814b;

        /* renamed from: c, reason: collision with root package name */
        private final int f17815c;

        /* renamed from: d, reason: collision with root package name */
        private int f17816d;

        public a(d dVar, int i5, int i6) {
            this.f17813a = dVar;
            this.f17814b = i5;
            this.f17815c = i6;
            w.d.c(i5, i6, dVar.size());
            this.f17816d = i6 - i5;
        }

        @Override // java.util.List
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public d subList(int i5, int i6) {
            w.d.c(i5, i6, this.f17816d);
            d dVar = this.f17813a;
            int i7 = this.f17814b;
            return new a(dVar, i5 + i7, i7 + i6);
        }

        @Override // java.util.List
        public Object get(int i5) {
            w.d.a(i5, this.f17816d);
            return this.f17813a.get(this.f17814b + i5);
        }

        public int getSize() {
            return this.f17816d;
        }
    }
}
