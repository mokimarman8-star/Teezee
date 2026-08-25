package androidx.recyclerview.widget;

import androidx.recyclerview.widget.a;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class l {

    /* renamed from: a, reason: collision with root package name */
    final a f12979a;

    interface a {
        a.b a(int i5, int i6, int i7, Object obj);

        void b(a.b bVar);
    }

    l(a aVar) {
        this.f12979a = aVar;
    }

    private int a(List list) {
        boolean z5 = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (((a.b) list.get(size)).f12920a != 8) {
                z5 = true;
            } else if (z5) {
                return size;
            }
        }
        return -1;
    }

    private void c(List list, int i5, a.b bVar, int i6, a.b bVar2) {
        int i7 = bVar.f12923d;
        int i8 = bVar2.f12921b;
        int i9 = i7 < i8 ? -1 : 0;
        int i10 = bVar.f12921b;
        if (i10 < i8) {
            i9++;
        }
        if (i8 <= i10) {
            bVar.f12921b = i10 + bVar2.f12923d;
        }
        int i11 = bVar2.f12921b;
        if (i11 <= i7) {
            bVar.f12923d = i7 + bVar2.f12923d;
        }
        bVar2.f12921b = i11 + i9;
        list.set(i5, bVar2);
        list.set(i6, bVar);
    }

    private void d(List list, int i5, int i6) {
        a.b bVar = (a.b) list.get(i5);
        a.b bVar2 = (a.b) list.get(i6);
        int i7 = bVar2.f12920a;
        if (i7 == 1) {
            c(list, i5, bVar, i6, bVar2);
        } else if (i7 == 2) {
            e(list, i5, bVar, i6, bVar2);
        } else {
            if (i7 != 4) {
                return;
            }
            f(list, i5, bVar, i6, bVar2);
        }
    }

    void b(List list) {
        while (true) {
            int a5 = a(list);
            if (a5 == -1) {
                return;
            } else {
                d(list, a5, a5 + 1);
            }
        }
    }

    void e(List list, int i5, a.b bVar, int i6, a.b bVar2) {
        boolean z5;
        int i7 = bVar.f12921b;
        int i8 = bVar.f12923d;
        boolean z6 = false;
        if (i7 < i8) {
            if (bVar2.f12921b == i7 && bVar2.f12923d == i8 - i7) {
                z5 = false;
                z6 = true;
            } else {
                z5 = false;
            }
        } else if (bVar2.f12921b == i8 + 1 && bVar2.f12923d == i7 - i8) {
            z5 = true;
            z6 = true;
        } else {
            z5 = true;
        }
        int i9 = bVar2.f12921b;
        if (i8 < i9) {
            bVar2.f12921b = i9 - 1;
        } else {
            int i10 = bVar2.f12923d;
            if (i8 < i9 + i10) {
                bVar2.f12923d = i10 - 1;
                bVar.f12920a = 2;
                bVar.f12923d = 1;
                if (bVar2.f12923d == 0) {
                    list.remove(i6);
                    this.f12979a.b(bVar2);
                    return;
                }
                return;
            }
        }
        int i11 = bVar.f12921b;
        int i12 = bVar2.f12921b;
        a.b bVar3 = null;
        if (i11 <= i12) {
            bVar2.f12921b = i12 + 1;
        } else {
            int i13 = bVar2.f12923d;
            if (i11 < i12 + i13) {
                bVar3 = this.f12979a.a(2, i11 + 1, (i12 + i13) - i11, null);
                bVar2.f12923d = bVar.f12921b - bVar2.f12921b;
            }
        }
        if (z6) {
            list.set(i5, bVar2);
            list.remove(i6);
            this.f12979a.b(bVar);
            return;
        }
        if (z5) {
            if (bVar3 != null) {
                int i14 = bVar.f12921b;
                if (i14 > bVar3.f12921b) {
                    bVar.f12921b = i14 - bVar3.f12923d;
                }
                int i15 = bVar.f12923d;
                if (i15 > bVar3.f12921b) {
                    bVar.f12923d = i15 - bVar3.f12923d;
                }
            }
            int i16 = bVar.f12921b;
            if (i16 > bVar2.f12921b) {
                bVar.f12921b = i16 - bVar2.f12923d;
            }
            int i17 = bVar.f12923d;
            if (i17 > bVar2.f12921b) {
                bVar.f12923d = i17 - bVar2.f12923d;
            }
        } else {
            if (bVar3 != null) {
                int i18 = bVar.f12921b;
                if (i18 >= bVar3.f12921b) {
                    bVar.f12921b = i18 - bVar3.f12923d;
                }
                int i19 = bVar.f12923d;
                if (i19 >= bVar3.f12921b) {
                    bVar.f12923d = i19 - bVar3.f12923d;
                }
            }
            int i20 = bVar.f12921b;
            if (i20 >= bVar2.f12921b) {
                bVar.f12921b = i20 - bVar2.f12923d;
            }
            int i21 = bVar.f12923d;
            if (i21 >= bVar2.f12921b) {
                bVar.f12923d = i21 - bVar2.f12923d;
            }
        }
        list.set(i5, bVar2);
        if (bVar.f12921b != bVar.f12923d) {
            list.set(i6, bVar);
        } else {
            list.remove(i6);
        }
        if (bVar3 != null) {
            list.add(i5, bVar3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void f(List list, int i5, a.b bVar, int i6, a.b bVar2) {
        a.b a5;
        int i7;
        int i8;
        int i9 = bVar.f12923d;
        int i10 = bVar2.f12921b;
        a.b bVar3 = null;
        if (i9 < i10) {
            bVar2.f12921b = i10 - 1;
        } else {
            int i11 = bVar2.f12923d;
            if (i9 < i10 + i11) {
                bVar2.f12923d = i11 - 1;
                a5 = this.f12979a.a(4, bVar.f12921b, 1, bVar2.f12922c);
                i7 = bVar.f12921b;
                i8 = bVar2.f12921b;
                if (i7 > i8) {
                    bVar2.f12921b = i8 + 1;
                } else {
                    int i12 = bVar2.f12923d;
                    if (i7 < i8 + i12) {
                        int i13 = (i8 + i12) - i7;
                        bVar3 = this.f12979a.a(4, i7 + 1, i13, bVar2.f12922c);
                        bVar2.f12923d -= i13;
                    }
                }
                list.set(i6, bVar);
                if (bVar2.f12923d <= 0) {
                    list.set(i5, bVar2);
                } else {
                    list.remove(i5);
                    this.f12979a.b(bVar2);
                }
                if (a5 != null) {
                    list.add(i5, a5);
                }
                if (bVar3 == null) {
                    list.add(i5, bVar3);
                    return;
                }
                return;
            }
        }
        a5 = null;
        i7 = bVar.f12921b;
        i8 = bVar2.f12921b;
        if (i7 > i8) {
        }
        list.set(i6, bVar);
        if (bVar2.f12923d <= 0) {
        }
        if (a5 != null) {
        }
        if (bVar3 == null) {
        }
    }
}
