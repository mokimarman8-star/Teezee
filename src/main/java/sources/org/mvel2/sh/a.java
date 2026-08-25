package org.mvel2.sh;

import e00.c;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import org.mvel2.ParserContext;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.integration.impl.MapVariableResolverFactory;
import org.mvel2.util.n;
import org.mvel2.util.s;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class a {
    private static final String[] m = new String[0];
    private final Map a;
    private Map b;
    private Map c;
    ParserContext d;
    VariableResolverFactory e;
    private int f;
    private boolean g;
    private int h;
    private PrintStream i;
    private String j;
    s k;
    final BufferedReader l;

    /* renamed from: org.mvel2.sh.a$a, reason: collision with other inner class name */
    public static final class C0009a {
    }

    public a() {
        HashMap hashMap = new HashMap();
        this.a = hashMap;
        this.d = new ParserContext();
        this.g = false;
        this.h = 0;
        PrintStream printStream = System.out;
        this.i = printStream;
        this.k = new s();
        this.l = new BufferedReader(new InputStreamReader(System.in));
        printStream.println("Starting session...");
        this.b = new HashMap();
        this.c = new HashMap();
        hashMap.putAll(new d00.a().a());
        hashMap.putAll(new c().a());
        this.c.put("$PROMPT", "[@{ new java.text.SimpleDateFormat('hh:mmaa').format(new java.util.Date(System.currentTimeMillis()))}] mvel2$ ");
        this.c.put("$OS_NAME", System.getProperty("os.name"));
        this.c.put("$OS_VERSION", System.getProperty("os.version"));
        this.c.put("$JAVA_VERSION", n.f());
        this.c.put("$CWD", new File(".").getAbsolutePath());
        this.c.put("$COMMAND_PASSTRU", "false");
        this.c.put("$PRINTOUTPUT", "true");
        this.c.put("$ECHO", "false");
        this.c.put("$SHOW_TRACES", "true");
        this.c.put("$USE_OPTIMIZER_ALWAYS", "false");
        this.c.put("$PATH", "");
        try {
            ResourceBundle bundle = ResourceBundle.getBundle(".mvelsh.properties");
            Enumeration<String> keys = bundle.getKeys();
            while (keys.hasMoreElements()) {
                Map map = this.c;
                String nextElement = keys.nextElement();
                map.put(nextElement, bundle.getString(nextElement));
            }
        } catch (MissingResourceException unused) {
            System.out.println("No config file found.  Loading default config.");
            if (!n.a(System.getProperty("os.name").toLowerCase(), "windows")) {
                this.c.put("$PATH", "/bin:/usr/bin:/sbin:/usr/sbin");
            }
        }
        this.e = new MapVariableResolverFactory((Map<String, Object>) this.b, new MapVariableResolverFactory(this.c));
    }

    public String j(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append(" ");
        }
        return stringBuffer.toString();
    }
}
