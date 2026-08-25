package com.transsion.json.b;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class k extends a {
    @Override // com.transsion.json.b.n
    public void a(Object obj) {
        if (obj instanceof Double) {
            Double d = (Double) obj;
            if (Double.isInfinite(d.doubleValue()) || Double.isNaN(d.doubleValue())) {
                b().r("null");
                return;
            }
        }
        if (obj instanceof Float) {
            Float f = (Float) obj;
            if (Float.isInfinite(f.floatValue()) || Float.isNaN(f.floatValue())) {
                b().r("null");
                return;
            }
        }
        b().r(obj.toString());
    }
}
