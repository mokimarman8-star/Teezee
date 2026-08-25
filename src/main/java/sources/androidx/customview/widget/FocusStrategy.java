package androidx.customview.widget;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract class FocusStrategy {

    private static class SequentialComparator<T> implements Comparator<T> {
        private final a mAdapter;
        private final boolean mIsLayoutRtl;
        private final Rect mTemp1 = new Rect();
        private final Rect mTemp2 = new Rect();

        SequentialComparator(boolean z5, a aVar) {
            this.mIsLayoutRtl = z5;
            this.mAdapter = aVar;
        }

        @Override // java.util.Comparator
        public int compare(T t5, T t6) {
            Rect rect = this.mTemp1;
            Rect rect2 = this.mTemp2;
            this.mAdapter.a(t5, rect);
            this.mAdapter.a(t6, rect2);
            int i5 = rect.top;
            int i6 = rect2.top;
            if (i5 < i6) {
                return -1;
            }
            if (i5 > i6) {
                return 1;
            }
            int i7 = rect.left;
            int i8 = rect2.left;
            if (i7 < i8) {
                return this.mIsLayoutRtl ? 1 : -1;
            }
            if (i7 > i8) {
                return this.mIsLayoutRtl ? -1 : 1;
            }
            int i9 = rect.bottom;
            int i10 = rect2.bottom;
            if (i9 < i10) {
                return -1;
            }
            if (i9 > i10) {
                return 1;
            }
            int i11 = rect.right;
            int i12 = rect2.right;
            if (i11 < i12) {
                return this.mIsLayoutRtl ? 1 : -1;
            }
            if (i11 > i12) {
                return this.mIsLayoutRtl ? -1 : 1;
            }
            return 0;
        }
    }

    public interface a {
        void a(Object obj, Rect rect);
    }

    public interface b {
        Object a(Object obj, int i5);

        int b(Object obj);
    }

    private static boolean a(int i5, Rect rect, Rect rect2, Rect rect3) {
        boolean b5 = b(i5, rect, rect2);
        if (b(i5, rect, rect3) || !b5) {
            return false;
        }
        return !j(i5, rect, rect3) || i5 == 17 || i5 == 66 || k(i5, rect, rect2) < m(i5, rect, rect3);
    }

    private static boolean b(int i5, Rect rect, Rect rect2) {
        if (i5 != 17) {
            if (i5 != 33) {
                if (i5 != 66) {
                    if (i5 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }

    public static Object c(Object obj, b bVar, a aVar, Object obj2, Rect rect, int i5) {
        Rect rect2 = new Rect(rect);
        if (i5 == 17) {
            rect2.offset(rect.width() + 1, 0);
        } else if (i5 == 33) {
            rect2.offset(0, rect.height() + 1);
        } else if (i5 == 66) {
            rect2.offset(-(rect.width() + 1), 0);
        } else {
            if (i5 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            rect2.offset(0, -(rect.height() + 1));
        }
        int b5 = bVar.b(obj);
        Rect rect3 = new Rect();
        Object obj3 = null;
        for (int i6 = 0; i6 < b5; i6++) {
            Object a5 = bVar.a(obj, i6);
            if (a5 != obj2) {
                aVar.a(a5, rect3);
                if (h(i5, rect, rect3, rect2)) {
                    rect2.set(rect3);
                    obj3 = a5;
                }
            }
        }
        return obj3;
    }

    public static Object d(Object obj, b bVar, a aVar, Object obj2, int i5, boolean z5, boolean z6) {
        int b5 = bVar.b(obj);
        ArrayList arrayList = new ArrayList(b5);
        for (int i6 = 0; i6 < b5; i6++) {
            arrayList.add(bVar.a(obj, i6));
        }
        Collections.sort(arrayList, new SequentialComparator(z5, aVar));
        if (i5 == 1) {
            return f(obj2, arrayList, z6);
        }
        if (i5 == 2) {
            return e(obj2, arrayList, z6);
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
    }

    private static Object e(Object obj, ArrayList arrayList, boolean z5) {
        int size = arrayList.size();
        int lastIndexOf = (obj == null ? -1 : arrayList.lastIndexOf(obj)) + 1;
        if (lastIndexOf < size) {
            return arrayList.get(lastIndexOf);
        }
        if (!z5 || size <= 0) {
            return null;
        }
        return arrayList.get(0);
    }

    private static Object f(Object obj, ArrayList arrayList, boolean z5) {
        int size = arrayList.size();
        int indexOf = (obj == null ? size : arrayList.indexOf(obj)) - 1;
        if (indexOf >= 0) {
            return arrayList.get(indexOf);
        }
        if (!z5 || size <= 0) {
            return null;
        }
        return arrayList.get(size - 1);
    }

    private static int g(int i5, int i6) {
        return (i5 * 13 * i5) + (i6 * i6);
    }

    private static boolean h(int i5, Rect rect, Rect rect2, Rect rect3) {
        if (!i(rect, rect2, i5)) {
            return false;
        }
        if (i(rect, rect3, i5) && !a(i5, rect, rect2, rect3)) {
            return !a(i5, rect, rect3, rect2) && g(k(i5, rect, rect2), o(i5, rect, rect2)) < g(k(i5, rect, rect3), o(i5, rect, rect3));
        }
        return true;
    }

    private static boolean i(Rect rect, Rect rect2, int i5) {
        if (i5 == 17) {
            int i6 = rect.right;
            int i7 = rect2.right;
            return (i6 > i7 || rect.left >= i7) && rect.left > rect2.left;
        }
        if (i5 == 33) {
            int i8 = rect.bottom;
            int i9 = rect2.bottom;
            return (i8 > i9 || rect.top >= i9) && rect.top > rect2.top;
        }
        if (i5 == 66) {
            int i10 = rect.left;
            int i11 = rect2.left;
            return (i10 < i11 || rect.right <= i11) && rect.right < rect2.right;
        }
        if (i5 != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        int i12 = rect.top;
        int i13 = rect2.top;
        return (i12 < i13 || rect.bottom <= i13) && rect.bottom < rect2.bottom;
    }

    private static boolean j(int i5, Rect rect, Rect rect2) {
        if (i5 == 17) {
            return rect.left >= rect2.right;
        }
        if (i5 == 33) {
            return rect.top >= rect2.bottom;
        }
        if (i5 == 66) {
            return rect.right <= rect2.left;
        }
        if (i5 == 130) {
            return rect.bottom <= rect2.top;
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    private static int k(int i5, Rect rect, Rect rect2) {
        return Math.max(0, l(i5, rect, rect2));
    }

    private static int l(int i5, Rect rect, Rect rect2) {
        int i6;
        int i7;
        if (i5 == 17) {
            i6 = rect.left;
            i7 = rect2.right;
        } else if (i5 == 33) {
            i6 = rect.top;
            i7 = rect2.bottom;
        } else if (i5 == 66) {
            i6 = rect2.left;
            i7 = rect.right;
        } else {
            if (i5 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            i6 = rect2.top;
            i7 = rect.bottom;
        }
        return i6 - i7;
    }

    private static int m(int i5, Rect rect, Rect rect2) {
        return Math.max(1, n(i5, rect, rect2));
    }

    private static int n(int i5, Rect rect, Rect rect2) {
        int i6;
        int i7;
        if (i5 == 17) {
            i6 = rect.left;
            i7 = rect2.left;
        } else if (i5 == 33) {
            i6 = rect.top;
            i7 = rect2.top;
        } else if (i5 == 66) {
            i6 = rect2.right;
            i7 = rect.right;
        } else {
            if (i5 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            i6 = rect2.bottom;
            i7 = rect.bottom;
        }
        return i6 - i7;
    }

    private static int o(int i5, Rect rect, Rect rect2) {
        if (i5 != 17) {
            if (i5 != 33) {
                if (i5 != 66) {
                    if (i5 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs((rect.left + (rect.width() / 2)) - (rect2.left + (rect2.width() / 2)));
        }
        return Math.abs((rect.top + (rect.height() / 2)) - (rect2.top + (rect2.height() / 2)));
    }
}
