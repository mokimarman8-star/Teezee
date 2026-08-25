package com.transsion.push.service;

import android.os.AsyncTask;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class JobIntentService$a extends AsyncTask {
    final /* synthetic */ JobIntentService a;

    JobIntentService$a(JobIntentService jobIntentService) {
        this.a = jobIntentService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        while (true) {
            JobIntentService$e a = this.a.a();
            if (a == null) {
                return null;
            }
            try {
                this.a.e(a.getIntent());
                a.a();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onCancelled(Void r1) {
        this.a.f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r1) {
        this.a.f();
    }
}
