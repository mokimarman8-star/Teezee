package se;

import android.os.AsyncTask;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class b extends AsyncTask {
    private a a;
    protected final InterfaceC0200b b;

    public interface a {
        void a(b bVar);
    }

    /* renamed from: se.b$b, reason: collision with other inner class name */
    public interface InterfaceC0200b {
        JSONObject a();

        void a(JSONObject jSONObject);
    }

    public b(InterfaceC0200b interfaceC0200b) {
        this.b = interfaceC0200b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void b(ThreadPoolExecutor threadPoolExecutor) {
        executeOnExecutor(threadPoolExecutor, new Object[0]);
    }

    public void c(a aVar) {
        this.a = aVar;
    }
}
