package com.blankj.utilcode.util;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class Utils$Task<Result> extends ThreadUtils$SimpleTask<Result> {
    private Utils$b mConsumer;

    public Utils$Task(Utils$b utils$b) {
        this.mConsumer = utils$b;
    }

    @Override // com.blankj.utilcode.util.ThreadUtils$Task
    public void onSuccess(Result result) {
        Utils$b utils$b = this.mConsumer;
        if (utils$b != null) {
            utils$b.accept(result);
        }
    }
}
