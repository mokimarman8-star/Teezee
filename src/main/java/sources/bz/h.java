package bz;

import com.google.gson.Gson;
import java.util.ArrayList;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class h {
    private final ArrayList a;

    public h(ArrayList arrayList) {
        this.a = arrayList;
    }

    public i a() {
        return f.a(l.d().a(), new Gson().toJson(this.a), 0);
    }
}
