package androidx.compose.runtime.snapshots;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class a {
    private static final void a(Appendable appendable, Object obj, Function1 function1) {
        if (function1 != null) {
            appendable.append((CharSequence) function1.invoke(obj));
            return;
        }
        if (obj == null ? true : obj instanceof CharSequence) {
            appendable.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            appendable.append(((Character) obj).charValue());
        } else {
            appendable.append(String.valueOf(obj));
        }
    }

    private static final Appendable b(List list, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, Function1 function1) {
        appendable.append(charSequence2);
        int size = list.size();
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            Object obj = list.get(i7);
            i6++;
            if (i6 > 1) {
                appendable.append(charSequence);
            }
            if (i5 >= 0 && i6 > i5) {
                break;
            }
            a(appendable, obj, function1);
        }
        if (i5 >= 0 && i6 > i5) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static final String c(List list, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, Function1 function1) {
        return ((StringBuilder) b(list, new StringBuilder(), charSequence, charSequence2, charSequence3, i5, charSequence4, function1)).toString();
    }

    public static /* synthetic */ String d(List list, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, Function1 function1, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i6 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i6 & 4) == 0 ? charSequence3 : "";
        if ((i6 & 8) != 0) {
            i5 = -1;
        }
        int i7 = i5;
        if ((i6 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i6 & 32) != 0) {
            function1 = null;
        }
        return c(list, charSequence, charSequence5, charSequence6, i7, charSequence7, function1);
    }

    public static final Set e(List list) {
        HashSet hashSet = new HashSet(list.size());
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            hashSet.add(list.get(i5));
        }
        return hashSet;
    }
}
