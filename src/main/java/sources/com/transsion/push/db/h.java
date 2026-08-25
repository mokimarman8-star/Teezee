package com.transsion.push.db;

import com.transsion.push.utils.PushLogUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class h {

    private static final class a {
        private static final h a = new h();
    }

    public static h b() {
        return a.a;
    }

    public void a(List list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        try {
            throw null;
        } catch (Exception e) {
            PushLogUtils.LOG.g("delete msg fail, e:" + e.getMessage());
        }
    }

    public void c(String str) {
        try {
            throw null;
        } catch (Exception e) {
            PushLogUtils.LOG.i("insert report record fail, e:" + e.getMessage());
        }
    }

    public List d() {
        new ArrayList();
        throw null;
    }
}
