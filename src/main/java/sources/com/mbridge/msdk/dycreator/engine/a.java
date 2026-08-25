package com.mbridge.msdk.dycreator.engine;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class a {
    private static final Class[] e = {Context.class, AttributeSet.class};
    private static final HashMap<String, Constructor> f = new HashMap<>();
    private static String g = "com.mbridge.msdk.dycreator.baseview.MB";
    protected final Context b;
    private long d;
    private final boolean a = true;
    private final Object[] c = new Object[2];

    public a(Context context) {
        this.b = context;
    }

    private void a(XmlPullParser xmlPullParser, View view) throws XmlPullParserException, IOException {
        int next;
        view.requestFocus();
        int depth = xmlPullParser.getDepth();
        do {
            next = xmlPullParser.next();
            if (next == 3 && xmlPullParser.getDepth() <= depth) {
                return;
            }
        } while (next != 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0071, code lost:
    
        if (r8 != null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x007f, code lost:
    
        b(r0, r2, r1);
        r7.addView(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x007c, code lost:
    
        r2.setLayoutParams(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x007a, code lost:
    
        if (r8 == null) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(XmlPullParser xmlPullParser, View view, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int next;
        ViewGroup.LayoutParams generateLayoutParams;
        int next2;
        if (!(view instanceof ViewGroup)) {
            throw new InflateException("<include /> can only be used inside of a ViewGroup");
        }
        int attributeResourceValue = attributeSet.getAttributeResourceValue(null, TtmlNode.TAG_LAYOUT, 0);
        if (attributeResourceValue == 0) {
            String attributeValue = attributeSet.getAttributeValue(null, TtmlNode.TAG_LAYOUT);
            if (attributeValue == null) {
                throw new InflateException("You must specifiy a layout in the include tag: <include layout=\"@layout/layoutID\" />");
            }
            throw new InflateException("You must specifiy a valid layout reference. The layout ID " + attributeValue + " is not valid.");
        }
        XmlResourceParser layout = a().getResources().getLayout(attributeResourceValue);
        try {
            AttributeSet asAttributeSet = Xml.asAttributeSet(layout);
            do {
                next = layout.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next != 2) {
                throw new InflateException(layout.getPositionDescription() + ": No start tag found!");
            }
            String name = layout.getName();
            if ("merge".equals(name)) {
                b(layout, view, asAttributeSet);
            } else {
                View a = a(name, asAttributeSet);
                ViewGroup viewGroup = (ViewGroup) view;
                try {
                    generateLayoutParams = viewGroup.generateLayoutParams(attributeSet);
                } catch (RuntimeException unused) {
                    generateLayoutParams = viewGroup.generateLayoutParams(asAttributeSet);
                }
            }
            layout.close();
            int depth = xmlPullParser.getDepth();
            do {
                next2 = xmlPullParser.next();
                if (next2 == 3 && xmlPullParser.getDepth() <= depth) {
                    return;
                }
            } while (next2 != 1);
        } catch (Throwable th) {
            layout.close();
            throw th;
        }
    }

    private void b(XmlPullParser xmlPullParser, View view, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next == 2) {
                String name = xmlPullParser.getName();
                if ("requestFocus".equals(name)) {
                    a(xmlPullParser, view);
                } else if ("include".equals(name)) {
                    if (xmlPullParser.getDepth() == 0) {
                        throw new InflateException("<include /> cannot be the root element");
                    }
                    a(xmlPullParser, view, attributeSet);
                } else {
                    if ("merge".equals(name)) {
                        throw new InflateException("<merge /> must be the root element");
                    }
                    View a = a(name, attributeSet);
                    ViewGroup viewGroup = (ViewGroup) view;
                    ViewGroup.LayoutParams generateLayoutParams = viewGroup.generateLayoutParams(attributeSet);
                    b(xmlPullParser, a, attributeSet);
                    viewGroup.addView(a, generateLayoutParams);
                }
            }
        }
    }

    public Context a() {
        return this.b;
    }

    View a(String str, AttributeSet attributeSet) {
        if (str.equals(MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW)) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        PrintStream printStream = System.out;
        printStream.println("******** Creating view: " + str);
        try {
            View b = -1 == str.indexOf(46) ? b(str, attributeSet) : a(str, (String) null, attributeSet);
            printStream.println("Created view is: " + b);
            return b;
        } catch (InflateException e2) {
            throw e2;
        } catch (ClassNotFoundException e3) {
            InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException.initCause(e3);
            throw inflateException;
        } catch (Exception e4) {
            InflateException inflateException2 = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException2.initCause(e4);
            throw inflateException2;
        }
    }

    public View a(String str, ViewGroup viewGroup) {
        return a(str, viewGroup, viewGroup != null);
    }

    public View a(String str, ViewGroup viewGroup, boolean z) {
        this.d = System.currentTimeMillis();
        System.out.println("INFLATING from resource: " + str);
        return a(a(str), viewGroup, z);
    }

    public final View a(String str, String str2, AttributeSet attributeSet) throws ClassNotFoundException, InflateException {
        String str3;
        HashMap<String, Constructor> hashMap = f;
        Constructor<?> constructor = hashMap.get(str);
        Class<?> cls = null;
        if (constructor == null) {
            try {
                ClassLoader classLoader = this.b.getClassLoader();
                if (str2 != null) {
                    str3 = str2 + str;
                } else {
                    str3 = str;
                }
                cls = classLoader.loadClass(str3);
                constructor = cls.getConstructor(e);
                hashMap.put(str, constructor);
            } catch (ClassNotFoundException e2) {
                throw e2;
            } catch (NoSuchMethodException e3) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(attributeSet.getPositionDescription());
                sb2.append(": Error inflating class ");
                if (str2 != null) {
                    str = str2 + str;
                }
                sb2.append(str);
                InflateException inflateException = new InflateException(sb2.toString());
                inflateException.initCause(e3);
                throw inflateException;
            } catch (Exception e4) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(attributeSet.getPositionDescription());
                sb3.append(": Error inflating class ");
                sb3.append(cls == null ? "<unknown>" : cls.getName());
                InflateException inflateException2 = new InflateException(sb3.toString());
                inflateException2.initCause(e4);
                throw inflateException2;
            }
        }
        Object[] objArr = this.c;
        objArr[1] = attributeSet;
        return (View) constructor.newInstance(objArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [android.view.View, android.view.ViewGroup, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [android.view.View] */
    public View a(XmlPullParser xmlPullParser, ViewGroup viewGroup, boolean z) {
        int next;
        ViewGroup.LayoutParams layoutParams;
        synchronized (this.c) {
            try {
                AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
                this.c[0] = this.b;
                do {
                    next = xmlPullParser.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new InflateException(xmlPullParser.getPositionDescription() + ": No start tag found!");
                }
                String name = xmlPullParser.getName();
                PrintStream printStream = System.out;
                printStream.println("**************************");
                printStream.println("Creating root view: " + name);
                printStream.println("**************************");
                if (!"merge".equals(name)) {
                    View a = a(name, asAttributeSet);
                    if (viewGroup != 0) {
                        printStream.println("Creating params from root: " + ((Object) viewGroup));
                        layoutParams = viewGroup.generateLayoutParams(asAttributeSet);
                        if (!z) {
                            a.setLayoutParams(layoutParams);
                        }
                    } else {
                        layoutParams = null;
                    }
                    printStream.println("-----> start inflating children");
                    b(xmlPullParser, a, asAttributeSet);
                    printStream.println("-----> done inflating children");
                    if (viewGroup != 0 && z) {
                        viewGroup.addView(a, layoutParams);
                    }
                    if (viewGroup == 0 || !z) {
                        viewGroup = a;
                    }
                } else {
                    if (viewGroup == 0 || !z) {
                        throw new InflateException("<merge /> can be used only with a valid ViewGroup root and attachToRoot=true");
                    }
                    b(xmlPullParser, viewGroup, asAttributeSet);
                }
            } catch (IOException e2) {
                InflateException inflateException = new InflateException(xmlPullParser.getPositionDescription() + ": " + e2.getMessage());
                inflateException.initCause(e2);
                throw inflateException;
            } catch (XmlPullParserException e3) {
                InflateException inflateException2 = new InflateException(e3.getMessage());
                inflateException2.initCause(e3);
                throw inflateException2;
            } finally {
            }
        }
        return viewGroup;
    }

    public XmlPullParser a(String str) {
        XmlPullParser newPullParser = Xml.newPullParser();
        try {
            newPullParser.setInput(new FileInputStream(str), "utf-8");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return newPullParser;
    }

    protected View b(String str, AttributeSet attributeSet) throws ClassNotFoundException {
        return (str.equals("MBStarLevelLayoutView") || str.equals("LuckPan")) ? a(str, TtmlNode.ANONYMOUS_REGION_ID, attributeSet) : a(str, g, attributeSet);
    }
}
