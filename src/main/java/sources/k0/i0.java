package k0;

import android.text.Layout;
import android.text.Spanned;
import android.text.TextPaint;
import java.text.BreakIterator;
import java.util.Comparator;
import java.util.PriorityQueue;
import kotlin.Pair;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class i0 {
    public static final float c(CharSequence charSequence, TextPaint textPaint) {
        BreakIterator lineInstance = BreakIterator.getLineInstance(textPaint.getTextLocale());
        int i5 = 0;
        lineInstance.setText(new b0(charSequence, 0, charSequence.length()));
        PriorityQueue<Pair> priorityQueue = new PriorityQueue(10, new Comparator() { // from class: k0.h0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int d5;
                d5 = i0.d((Pair) obj, (Pair) obj2);
                return d5;
            }
        });
        int next = lineInstance.next();
        while (true) {
            int i6 = i5;
            i5 = next;
            if (i5 == -1) {
                break;
            }
            if (priorityQueue.size() < 10) {
                priorityQueue.add(new Pair(Integer.valueOf(i6), Integer.valueOf(i5)));
            } else {
                Pair pair = (Pair) priorityQueue.peek();
                if (pair != null && ((Number) pair.getSecond()).intValue() - ((Number) pair.getFirst()).intValue() < i5 - i6) {
                    priorityQueue.poll();
                    priorityQueue.add(new Pair(Integer.valueOf(i6), Integer.valueOf(i5)));
                }
            }
            next = lineInstance.next();
        }
        float f5 = 0.0f;
        for (Pair pair2 : priorityQueue) {
            f5 = Math.max(f5, Layout.getDesiredWidth(charSequence, ((Number) pair2.component1()).intValue(), ((Number) pair2.component2()).intValue(), textPaint));
        }
        return f5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int d(Pair pair, Pair pair2) {
        return (((Number) pair.getSecond()).intValue() - ((Number) pair.getFirst()).intValue()) - (((Number) pair2.getSecond()).intValue() - ((Number) pair2.getFirst()).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001a, code lost:
    
        if (k0.m0.a(r2, l0.e.class) == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean e(float f5, CharSequence charSequence, TextPaint textPaint) {
        if (f5 != 0.0f) {
            if (charSequence instanceof Spanned) {
                Spanned spanned = (Spanned) charSequence;
                if (!m0.a(spanned, l0.f.class)) {
                }
                return true;
            }
            if (textPaint.getLetterSpacing() != 0.0f) {
                return true;
            }
        }
        return false;
    }
}
