package m5;

import java.util.Hashtable;
import java.util.TreeMap;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class d {
    public String a = "";
    public String b = "";
    public String c = "";
    public String d = "";
    public String e = "";
    public String f = "";
    public boolean k = true;
    public int l = 0;
    public boolean m = false;
    public Hashtable g = new Hashtable();
    public Hashtable h = new Hashtable();
    public TreeMap i = new TreeMap();
    public String j = "List of non fatal errors produced during parsing:\n\n";

    public void a() {
        Hashtable hashtable = new Hashtable();
        for (b bVar : this.i.values()) {
            a aVar = bVar.a;
            if (aVar != null) {
                String str = aVar.a;
                if (!hashtable.containsKey(str)) {
                    hashtable.put(str, bVar.a);
                }
            }
        }
        this.g = hashtable;
    }
}
