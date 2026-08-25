package io.reactivex.rxjava3.internal.operators.observable;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class i extends ay.a {
    final ObservableGroupBy$State b;

    protected i(Object obj, ObservableGroupBy$State observableGroupBy$State) {
        super(obj);
        this.b = observableGroupBy$State;
    }

    public static i J(Object obj, int i, ObservableGroupBy$GroupByObserver observableGroupBy$GroupByObserver, boolean z) {
        return new i(obj, new ObservableGroupBy$State(i, observableGroupBy$GroupByObserver, obj, z));
    }

    @Override // io.reactivex.rxjava3.core.j
    protected void D(io.reactivex.rxjava3.core.o oVar) {
        this.b.subscribe(oVar);
    }

    public void onComplete() {
        this.b.onComplete();
    }

    public void onError(Throwable th) {
        this.b.onError(th);
    }

    public void onNext(Object obj) {
        this.b.onNext(obj);
    }
}
