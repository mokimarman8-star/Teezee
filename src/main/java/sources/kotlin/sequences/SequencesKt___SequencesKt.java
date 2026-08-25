package kotlin.sequences;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt___SequencesKt$asIterable$;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
class SequencesKt___SequencesKt extends g {
    public static Sequence A(Sequence sequence, Function1 function1) {
        Intrinsics.h(sequence, "<this>");
        Intrinsics.h(function1, "predicate");
        return new TakeWhileSequence(sequence, function1);
    }

    public static final Collection B(Sequence sequence, Collection collection) {
        Intrinsics.h(sequence, "<this>");
        Intrinsics.h(collection, "destination");
        Iterator it = sequence.iterator();
        while (it.hasNext()) {
            collection.add(it.next());
        }
        return collection;
    }

    public static List C(Sequence sequence) {
        Intrinsics.h(sequence, "<this>");
        Iterator it = sequence.iterator();
        if (!it.hasNext()) {
            return CollectionsKt.l();
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return CollectionsKt.e(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public static List D(Sequence sequence) {
        Intrinsics.h(sequence, "<this>");
        return (List) B(sequence, new ArrayList());
    }

    public static Iterable n(Sequence sequence) {
        Intrinsics.h(sequence, "<this>");
        return new SequencesKt___SequencesKt$asIterable$.inlined.Iterable.1(sequence);
    }

    public static Sequence o(Sequence sequence, int i) {
        Intrinsics.h(sequence, "<this>");
        if (i >= 0) {
            return i == 0 ? sequence : sequence instanceof DropTakeSequence ? ((DropTakeSequence) sequence).a(i) : new DropSequence(sequence, i);
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    public static final Sequence p(Sequence sequence, Function1 function1) {
        Intrinsics.h(sequence, "<this>");
        Intrinsics.h(function1, "predicate");
        return new FilteringSequence(sequence, true, function1);
    }

    public static final Sequence q(Sequence sequence, Function1 function1) {
        Intrinsics.h(sequence, "<this>");
        Intrinsics.h(function1, "predicate");
        return new FilteringSequence(sequence, false, function1);
    }

    public static Sequence r(Sequence sequence) {
        Intrinsics.h(sequence, "<this>");
        Sequence q = q(sequence, new h());
        Intrinsics.f(q, "null cannot be cast to non-null type kotlin.sequences.Sequence<T of kotlin.sequences.SequencesKt___SequencesKt.filterNotNull>");
        return q;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean s(Object obj) {
        return obj == null;
    }

    public static Object t(Sequence sequence) {
        Intrinsics.h(sequence, "<this>");
        Iterator it = sequence.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static final Appendable u(Sequence sequence, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1) {
        Intrinsics.h(sequence, "<this>");
        Intrinsics.h(appendable, "buffer");
        Intrinsics.h(charSequence, "separator");
        Intrinsics.h(charSequence2, "prefix");
        Intrinsics.h(charSequence3, "postfix");
        Intrinsics.h(charSequence4, "truncated");
        appendable.append(charSequence2);
        int i2 = 0;
        for (Object obj : sequence) {
            i2++;
            if (i2 > 1) {
                appendable.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            StringsKt.a(appendable, obj, function1);
        }
        if (i >= 0 && i2 > i) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static final String v(Sequence sequence, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1) {
        Intrinsics.h(sequence, "<this>");
        Intrinsics.h(charSequence, "separator");
        Intrinsics.h(charSequence2, "prefix");
        Intrinsics.h(charSequence3, "postfix");
        Intrinsics.h(charSequence4, "truncated");
        return ((StringBuilder) u(sequence, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, function1)).toString();
    }

    public static /* synthetic */ String w(Sequence sequence, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i2 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i2 & 4) == 0 ? charSequence3 : "";
        if ((i2 & 8) != 0) {
            i = -1;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            function1 = null;
        }
        return v(sequence, charSequence, charSequence5, charSequence6, i3, charSequence7, function1);
    }

    public static Object x(Sequence sequence) {
        Intrinsics.h(sequence, "<this>");
        Iterator it = sequence.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Sequence is empty.");
        }
        Object next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static Sequence y(Sequence sequence, Function1 function1) {
        Intrinsics.h(sequence, "<this>");
        Intrinsics.h(function1, "transform");
        return new TransformingSequence(sequence, function1);
    }

    public static Sequence z(Sequence sequence, Function1 function1) {
        Intrinsics.h(sequence, "<this>");
        Intrinsics.h(function1, "transform");
        return SequencesKt.r(new TransformingSequence(sequence, function1));
    }
}
