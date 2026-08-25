package androidx.recyclerview.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class DefaultItemAnimator extends q {
    private static final boolean DEBUG = false;
    private static TimeInterpolator sDefaultInterpolator;
    private ArrayList<RecyclerView.a0> mPendingRemovals = new ArrayList<>();
    private ArrayList<RecyclerView.a0> mPendingAdditions = new ArrayList<>();
    private ArrayList<g> mPendingMoves = new ArrayList<>();
    private ArrayList<f> mPendingChanges = new ArrayList<>();
    ArrayList<ArrayList<RecyclerView.a0>> mAdditionsList = new ArrayList<>();
    ArrayList<ArrayList<g>> mMovesList = new ArrayList<>();
    ArrayList<ArrayList<f>> mChangesList = new ArrayList<>();
    ArrayList<RecyclerView.a0> mAddAnimations = new ArrayList<>();
    ArrayList<RecyclerView.a0> mMoveAnimations = new ArrayList<>();
    ArrayList<RecyclerView.a0> mRemoveAnimations = new ArrayList<>();
    ArrayList<RecyclerView.a0> mChangeAnimations = new ArrayList<>();

    private void a(RecyclerView.a0 a0Var) {
        View view = a0Var.itemView;
        ViewPropertyAnimator animate = view.animate();
        this.mRemoveAnimations.add(a0Var);
        animate.setDuration(getRemoveDuration()).alpha(0.0f).setListener(new a(this, a0Var, animate, view)).start();
    }

    private void b(List list, RecyclerView.a0 a0Var) {
        for (int size = list.size() - 1; size >= 0; size--) {
            f fVar = (f) list.get(size);
            if (d(fVar, a0Var) && fVar.a == null && fVar.b == null) {
                list.remove(fVar);
            }
        }
    }

    private void c(f fVar) {
        RecyclerView.a0 a0Var = fVar.a;
        if (a0Var != null) {
            d(fVar, a0Var);
        }
        RecyclerView.a0 a0Var2 = fVar.b;
        if (a0Var2 != null) {
            d(fVar, a0Var2);
        }
    }

    private boolean d(f fVar, RecyclerView.a0 a0Var) {
        boolean z = false;
        if (fVar.b == a0Var) {
            fVar.b = null;
        } else {
            if (fVar.a != a0Var) {
                return false;
            }
            fVar.a = null;
            z = true;
        }
        a0Var.itemView.setAlpha(1.0f);
        a0Var.itemView.setTranslationX(0.0f);
        a0Var.itemView.setTranslationY(0.0f);
        dispatchChangeFinished(a0Var, z);
        return true;
    }

    private void e(RecyclerView.a0 a0Var) {
        if (sDefaultInterpolator == null) {
            sDefaultInterpolator = new ValueAnimator().getInterpolator();
        }
        a0Var.itemView.animate().setInterpolator(sDefaultInterpolator);
        endAnimation(a0Var);
    }

    public boolean animateAdd(RecyclerView.a0 a0Var) {
        e(a0Var);
        a0Var.itemView.setAlpha(0.0f);
        this.mPendingAdditions.add(a0Var);
        return true;
    }

    void animateAddImpl(RecyclerView.a0 a0Var) {
        View view = a0Var.itemView;
        ViewPropertyAnimator animate = view.animate();
        this.mAddAnimations.add(a0Var);
        animate.alpha(1.0f).setDuration(getAddDuration()).setListener(new b(this, a0Var, view, animate)).start();
    }

    @SuppressLint({"UnknownNullness"})
    public boolean animateChange(RecyclerView.a0 a0Var, RecyclerView.a0 a0Var2, int i, int i2, int i3, int i4) {
        if (a0Var == a0Var2) {
            return animateMove(a0Var, i, i2, i3, i4);
        }
        float translationX = a0Var.itemView.getTranslationX();
        float translationY = a0Var.itemView.getTranslationY();
        float alpha = a0Var.itemView.getAlpha();
        e(a0Var);
        int i6 = (int) ((i3 - i) - translationX);
        int i7 = (int) ((i4 - i2) - translationY);
        a0Var.itemView.setTranslationX(translationX);
        a0Var.itemView.setTranslationY(translationY);
        a0Var.itemView.setAlpha(alpha);
        if (a0Var2 != null) {
            e(a0Var2);
            a0Var2.itemView.setTranslationX(-i6);
            a0Var2.itemView.setTranslationY(-i7);
            a0Var2.itemView.setAlpha(0.0f);
        }
        this.mPendingChanges.add(new f(a0Var, a0Var2, i, i2, i3, i4));
        return true;
    }

    void animateChangeImpl(f fVar) {
        RecyclerView.a0 a0Var = fVar.a;
        View view = a0Var == null ? null : a0Var.itemView;
        RecyclerView.a0 a0Var2 = fVar.b;
        View view2 = a0Var2 != null ? a0Var2.itemView : null;
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(getChangeDuration());
            this.mChangeAnimations.add(fVar.a);
            duration.translationX(fVar.e - fVar.c);
            duration.translationY(fVar.f - fVar.d);
            duration.alpha(0.0f).setListener(new d(this, fVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator animate = view2.animate();
            this.mChangeAnimations.add(fVar.b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(getChangeDuration()).alpha(1.0f).setListener(new e(this, fVar, animate, view2)).start();
        }
    }

    @SuppressLint({"UnknownNullness"})
    public boolean animateMove(RecyclerView.a0 a0Var, int i, int i2, int i3, int i4) {
        View view = a0Var.itemView;
        int translationX = i + ((int) view.getTranslationX());
        int translationY = i2 + ((int) a0Var.itemView.getTranslationY());
        e(a0Var);
        int i6 = i3 - translationX;
        int i7 = i4 - translationY;
        if (i6 == 0 && i7 == 0) {
            dispatchMoveFinished(a0Var);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX(-i6);
        }
        if (i7 != 0) {
            view.setTranslationY(-i7);
        }
        this.mPendingMoves.add(new g(a0Var, translationX, translationY, i3, i4));
        return true;
    }

    void animateMoveImpl(RecyclerView.a0 a0Var, int i, int i2, int i3, int i4) {
        View view = a0Var.itemView;
        int i6 = i3 - i;
        int i7 = i4 - i2;
        if (i6 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i7 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator animate = view.animate();
        this.mMoveAnimations.add(a0Var);
        animate.setDuration(getMoveDuration()).setListener(new c(this, a0Var, i6, view, i7, animate)).start();
    }

    @SuppressLint({"UnknownNullness"})
    public boolean animateRemove(RecyclerView.a0 a0Var) {
        e(a0Var);
        this.mPendingRemovals.add(a0Var);
        return true;
    }

    public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.a0 a0Var, @NonNull List<Object> list) {
        return !list.isEmpty() || super/*androidx.recyclerview.widget.RecyclerView.j*/.canReuseUpdatedViewHolder(a0Var, list);
    }

    void cancelAll(List<RecyclerView.a0> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).itemView.animate().cancel();
        }
    }

    void dispatchFinishedWhenDone() {
        if (isRunning()) {
            return;
        }
        dispatchAnimationsFinished();
    }

    public void endAnimation(RecyclerView.a0 a0Var) {
        View view = a0Var.itemView;
        view.animate().cancel();
        int size = this.mPendingMoves.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.mPendingMoves.get(size).a == a0Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                dispatchMoveFinished(a0Var);
                this.mPendingMoves.remove(size);
            }
        }
        b(this.mPendingChanges, a0Var);
        if (this.mPendingRemovals.remove(a0Var)) {
            view.setAlpha(1.0f);
            dispatchRemoveFinished(a0Var);
        }
        if (this.mPendingAdditions.remove(a0Var)) {
            view.setAlpha(1.0f);
            dispatchAddFinished(a0Var);
        }
        for (int size2 = this.mChangesList.size() - 1; size2 >= 0; size2--) {
            ArrayList<f> arrayList = this.mChangesList.get(size2);
            b(arrayList, a0Var);
            if (arrayList.isEmpty()) {
                this.mChangesList.remove(size2);
            }
        }
        for (int size3 = this.mMovesList.size() - 1; size3 >= 0; size3--) {
            ArrayList<g> arrayList2 = this.mMovesList.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (arrayList2.get(size4).a == a0Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    dispatchMoveFinished(a0Var);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.mMovesList.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.mAdditionsList.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.a0> arrayList3 = this.mAdditionsList.get(size5);
            if (arrayList3.remove(a0Var)) {
                view.setAlpha(1.0f);
                dispatchAddFinished(a0Var);
                if (arrayList3.isEmpty()) {
                    this.mAdditionsList.remove(size5);
                }
            }
        }
        this.mRemoveAnimations.remove(a0Var);
        this.mAddAnimations.remove(a0Var);
        this.mChangeAnimations.remove(a0Var);
        this.mMoveAnimations.remove(a0Var);
        dispatchFinishedWhenDone();
    }

    public void endAnimations() {
        int size = this.mPendingMoves.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            g gVar = this.mPendingMoves.get(size);
            View view = gVar.a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            dispatchMoveFinished(gVar.a);
            this.mPendingMoves.remove(size);
        }
        for (int size2 = this.mPendingRemovals.size() - 1; size2 >= 0; size2--) {
            dispatchRemoveFinished(this.mPendingRemovals.get(size2));
            this.mPendingRemovals.remove(size2);
        }
        int size3 = this.mPendingAdditions.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.a0 a0Var = this.mPendingAdditions.get(size3);
            a0Var.itemView.setAlpha(1.0f);
            dispatchAddFinished(a0Var);
            this.mPendingAdditions.remove(size3);
        }
        for (int size4 = this.mPendingChanges.size() - 1; size4 >= 0; size4--) {
            c(this.mPendingChanges.get(size4));
        }
        this.mPendingChanges.clear();
        if (isRunning()) {
            for (int size5 = this.mMovesList.size() - 1; size5 >= 0; size5--) {
                ArrayList<g> arrayList = this.mMovesList.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    g gVar2 = arrayList.get(size6);
                    View view2 = gVar2.a.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    dispatchMoveFinished(gVar2.a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.mMovesList.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.mAdditionsList.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.a0> arrayList2 = this.mAdditionsList.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.a0 a0Var2 = arrayList2.get(size8);
                    a0Var2.itemView.setAlpha(1.0f);
                    dispatchAddFinished(a0Var2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.mAdditionsList.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.mChangesList.size() - 1; size9 >= 0; size9--) {
                ArrayList<f> arrayList3 = this.mChangesList.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    c(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.mChangesList.remove(arrayList3);
                    }
                }
            }
            cancelAll(this.mRemoveAnimations);
            cancelAll(this.mMoveAnimations);
            cancelAll(this.mAddAnimations);
            cancelAll(this.mChangeAnimations);
            dispatchAnimationsFinished();
        }
    }

    public boolean isRunning() {
        return (this.mPendingAdditions.isEmpty() && this.mPendingChanges.isEmpty() && this.mPendingMoves.isEmpty() && this.mPendingRemovals.isEmpty() && this.mMoveAnimations.isEmpty() && this.mRemoveAnimations.isEmpty() && this.mAddAnimations.isEmpty() && this.mChangeAnimations.isEmpty() && this.mMovesList.isEmpty() && this.mAdditionsList.isEmpty() && this.mChangesList.isEmpty()) ? false : true;
    }

    public void runPendingAnimations() {
        boolean isEmpty = this.mPendingRemovals.isEmpty();
        boolean isEmpty2 = this.mPendingMoves.isEmpty();
        boolean isEmpty3 = this.mPendingChanges.isEmpty();
        boolean isEmpty4 = this.mPendingAdditions.isEmpty();
        if (isEmpty && isEmpty2 && isEmpty4 && isEmpty3) {
            return;
        }
        Iterator<RecyclerView.a0> it = this.mPendingRemovals.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        this.mPendingRemovals.clear();
        if (!isEmpty2) {
            ArrayList<g> arrayList = new ArrayList<>();
            arrayList.addAll(this.mPendingMoves);
            this.mMovesList.add(arrayList);
            this.mPendingMoves.clear();
            1 r6 = new 1(this, arrayList);
            if (isEmpty) {
                r6.run();
            } else {
                ViewCompat.postOnAnimationDelayed(arrayList.get(0).a.itemView, r6, getRemoveDuration());
            }
        }
        if (!isEmpty3) {
            ArrayList<f> arrayList2 = new ArrayList<>();
            arrayList2.addAll(this.mPendingChanges);
            this.mChangesList.add(arrayList2);
            this.mPendingChanges.clear();
            2 r62 = new 2(this, arrayList2);
            if (isEmpty) {
                r62.run();
            } else {
                ViewCompat.postOnAnimationDelayed(arrayList2.get(0).a.itemView, r62, getRemoveDuration());
            }
        }
        if (isEmpty4) {
            return;
        }
        final ArrayList<RecyclerView.a0> arrayList3 = new ArrayList<>();
        arrayList3.addAll(this.mPendingAdditions);
        this.mAdditionsList.add(arrayList3);
        this.mPendingAdditions.clear();
        Runnable runnable = new Runnable() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.3
            @Override // java.lang.Runnable
            public void run() {
                Iterator it2 = arrayList3.iterator();
                while (it2.hasNext()) {
                    DefaultItemAnimator.this.animateAddImpl((RecyclerView.a0) it2.next());
                }
                arrayList3.clear();
                DefaultItemAnimator.this.mAdditionsList.remove(arrayList3);
            }
        };
        if (isEmpty && isEmpty2 && isEmpty3) {
            runnable.run();
        } else {
            ViewCompat.postOnAnimationDelayed(arrayList3.get(0).itemView, runnable, (!isEmpty ? getRemoveDuration() : 0L) + Math.max(!isEmpty2 ? getMoveDuration() : 0L, isEmpty3 ? 0L : getChangeDuration()));
        }
    }
}
