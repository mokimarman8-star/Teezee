package io.reactivex.rxjava3.internal.schedulers;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class TrampolineScheduler$a implements Comparable {
    final Runnable a;
    final long b;
    final int c;
    volatile boolean d;

    TrampolineScheduler$a(Runnable runnable, Long l, int i) {
        this.a = runnable;
        this.b = l.longValue();
        this.c = i;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(TrampolineScheduler$a trampolineScheduler$a) {
        int compare = Long.compare(this.b, trampolineScheduler$a.b);
        return compare == 0 ? Integer.compare(this.c, trampolineScheduler$a.c) : compare;
    }
}
