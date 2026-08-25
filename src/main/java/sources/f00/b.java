package f00;

import java.util.HashMap;
import java.util.Map;
import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.templates.CompiledTemplate;
import org.mvel2.templates.res.CodeNode;
import org.mvel2.templates.res.CommentNode;
import org.mvel2.templates.res.CompiledCodeNode;
import org.mvel2.templates.res.CompiledDeclareNode;
import org.mvel2.templates.res.CompiledEvalNode;
import org.mvel2.templates.res.CompiledExpressionNode;
import org.mvel2.templates.res.CompiledForEachNode;
import org.mvel2.templates.res.CompiledIfNode;
import org.mvel2.templates.res.CompiledIncludeNode;
import org.mvel2.templates.res.CompiledNamedIncludeNode;
import org.mvel2.templates.res.CompiledTerminalExpressionNode;
import org.mvel2.templates.res.DeclareNode;
import org.mvel2.templates.res.EndNode;
import org.mvel2.templates.res.EvalNode;
import org.mvel2.templates.res.ExpressionNode;
import org.mvel2.templates.res.ForEachNode;
import org.mvel2.templates.res.IfNode;
import org.mvel2.templates.res.IncludeNode;
import org.mvel2.templates.res.NamedIncludeNode;
import org.mvel2.templates.res.Node;
import org.mvel2.templates.res.TerminalExpressionNode;
import org.mvel2.templates.res.TerminalNode;
import org.mvel2.templates.res.TextNode;
import org.mvel2.util.g;
import org.mvel2.util.m;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class b {
    private static final Map k;
    private char[] a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private boolean h;
    private Map i;
    private ParserContext j;

    static {
        HashMap hashMap = new HashMap();
        k = hashMap;
        hashMap.put("if", 1);
        hashMap.put("else", 2);
        hashMap.put("elseif", 2);
        hashMap.put("end", 10);
        hashMap.put("foreach", 3);
        hashMap.put("includeNamed", 51);
        hashMap.put("include", 50);
        hashMap.put("comment", 52);
        hashMap.put("code", 53);
        hashMap.put("eval", 55);
        hashMap.put("declare", 54);
        hashMap.put("stop", 70);
    }

    public b(CharSequence charSequence, boolean z, ParserContext parserContext) {
        this.h = false;
        char[] charArray = charSequence.toString().toCharArray();
        this.a = charArray;
        this.b = charArray.length;
        this.h = z;
        this.j = parserContext;
    }

    private char[] a() {
        int i = this.d - this.c;
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = this.a[this.c + i2];
        }
        return cArr;
    }

    private int b() {
        try {
            ParserContext parserContext = new ParserContext();
            char[] cArr = this.a;
            int i = this.d;
            this.c = i;
            this.d = m.e(cArr, i, this.b, '{', parserContext);
            this.f += parserContext.getLineCount();
            int i2 = this.c + 1;
            this.c = this.d + 1;
            return i2;
        } catch (CompileException e) {
            e.setLineNumber(this.f);
            e.setColumn((this.d - this.g) + 1);
            throw e;
        }
    }

    private int c() {
        int i = this.d + 1;
        this.d = i;
        while (true) {
            int i2 = this.d;
            if (i2 == this.b || !m.c0(this.a[i2])) {
                break;
            }
            this.d++;
        }
        int i3 = this.d;
        if (i3 == this.b || this.a[i3] != '{') {
            return -1;
        }
        return i;
    }

    public static CompiledTemplate f(String str) {
        return new b(str, true, ParserContext.create()).d();
    }

    public static CompiledTemplate g(String str, ParserContext parserContext) {
        return new b(str, true, parserContext).d();
    }

    private boolean h(char c) {
        int i = this.d;
        return i != this.b && this.a[i + 1] == c;
    }

    private Node i(Node node) {
        int end = node.getEnd();
        int i = this.e;
        if (end > i) {
            i = node.getEnd();
        }
        int i2 = this.c;
        if (i >= i2) {
            return node;
        }
        int i3 = i2 - 1;
        this.e = i3;
        TextNode textNode = new TextNode(i, i3);
        node.next = textNode;
        return textNode;
    }

    public CompiledTemplate d() {
        return new CompiledTemplate(this.a, e(null, new g()));
    }

    public Node e(Node node, g gVar) {
        String str;
        Node compiledIfNode;
        Node terminus;
        this.f = 1;
        Node textNode = node == null ? new TextNode(0, 0) : node;
        Node node2 = textNode;
        while (true) {
            try {
                int i = this.d;
                if (i >= this.b) {
                    if (!gVar.g()) {
                        CompileException compileException = new CompileException("unclosed @" + ((Node) gVar.k()).getName() + "{} block. expected @end{}", this.a, this.d);
                        compileException.setColumn(this.d - this.g);
                        compileException.setLineNumber(this.f);
                        throw compileException;
                    }
                    int i2 = this.c;
                    char[] cArr = this.a;
                    if (i2 < cArr.length) {
                        TextNode textNode2 = new TextNode(i2, cArr.length);
                        textNode.next = textNode2;
                        textNode = textNode2;
                    }
                    textNode.next = new EndNode();
                    Node node3 = node2;
                    while (node3.getLength() == 0 && (node3 = node3.getNext()) != null) {
                    }
                    return (node3 == null || node3.getLength() != this.a.length - 1) ? node2 : node3 instanceof ExpressionNode ? this.h ? new CompiledTerminalExpressionNode(node3, this.j) : new TerminalExpressionNode(node3) : node3;
                }
                char c = this.a[i];
                if (c == '\n') {
                    this.f++;
                    this.g = i + 1;
                } else if (c == '$' || c == '@') {
                    if (h(c)) {
                        int i3 = this.d + 1;
                        this.d = i3;
                        this.c = i3;
                        textNode = i(textNode);
                        textNode.setEnd(textNode.getEnd() + 1);
                        int i4 = this.d + 1;
                        this.d = i4;
                        this.e = i4;
                        this.c = i4;
                    } else {
                        int c2 = c();
                        if (c2 != -1) {
                            this.c = c2;
                            Map map = k;
                            str = new String(a());
                            Integer num = (Integer) map.get(str);
                            int intValue = num == null ? 0 : num.intValue();
                            if (intValue == 1) {
                                Node i6 = i(textNode);
                                compiledIfNode = this.h ? new CompiledIfNode(this.c, str, this.a, b(), this.c, this.j) : new IfNode(this.c, str, this.a, b(), this.c);
                                i6.next = compiledIfNode;
                                gVar.q(compiledIfNode);
                                compiledIfNode.setTerminus(new TerminalNode());
                            } else if (intValue != 2) {
                                if (intValue != 3) {
                                    if (intValue != 10) {
                                        switch (intValue) {
                                            case 50:
                                                Node i7 = i(textNode);
                                                if (this.h) {
                                                    int i8 = this.c;
                                                    char[] cArr2 = this.a;
                                                    int b = b();
                                                    int i9 = this.d + 1;
                                                    this.c = i9;
                                                    compiledIfNode = new CompiledIncludeNode(i8, str, cArr2, b, i9, this.j);
                                                } else {
                                                    int i10 = this.c;
                                                    char[] cArr3 = this.a;
                                                    int b2 = b();
                                                    int i11 = this.d + 1;
                                                    this.c = i11;
                                                    compiledIfNode = new IncludeNode(i10, str, cArr3, b2, i11);
                                                }
                                                i7.next = compiledIfNode;
                                                break;
                                            case 51:
                                                Node i12 = i(textNode);
                                                if (this.h) {
                                                    int i13 = this.c;
                                                    char[] cArr4 = this.a;
                                                    int b3 = b();
                                                    int i14 = this.d + 1;
                                                    this.c = i14;
                                                    compiledIfNode = new CompiledNamedIncludeNode(i13, str, cArr4, b3, i14, this.j);
                                                } else {
                                                    int i15 = this.c;
                                                    char[] cArr5 = this.a;
                                                    int b4 = b();
                                                    int i16 = this.d + 1;
                                                    this.c = i16;
                                                    compiledIfNode = new NamedIncludeNode(i15, str, cArr5, b4, i16);
                                                }
                                                i12.next = compiledIfNode;
                                                break;
                                            case 52:
                                                Node i17 = i(textNode);
                                                int i18 = this.c;
                                                char[] cArr6 = this.a;
                                                int b5 = b();
                                                int i19 = this.d + 1;
                                                this.c = i19;
                                                compiledIfNode = new CommentNode(i18, str, cArr6, b5, i19);
                                                i17.next = compiledIfNode;
                                                break;
                                            case 53:
                                                Node i20 = i(textNode);
                                                if (this.h) {
                                                    int i21 = this.c;
                                                    char[] cArr7 = this.a;
                                                    int b6 = b();
                                                    int i22 = this.d + 1;
                                                    this.c = i22;
                                                    compiledIfNode = new CompiledCodeNode(i21, str, cArr7, b6, i22, this.j);
                                                } else {
                                                    int i23 = this.c;
                                                    char[] cArr8 = this.a;
                                                    int b7 = b();
                                                    int i24 = this.d + 1;
                                                    this.c = i24;
                                                    compiledIfNode = new CodeNode(i23, str, cArr8, b7, i24);
                                                }
                                                i20.next = compiledIfNode;
                                                break;
                                            case 54:
                                                Node i25 = i(textNode);
                                                if (this.h) {
                                                    int i26 = this.c;
                                                    char[] cArr9 = this.a;
                                                    int b8 = b();
                                                    int i27 = this.d + 1;
                                                    this.c = i27;
                                                    compiledIfNode = new CompiledDeclareNode(i26, str, cArr9, b8, i27, this.j);
                                                } else {
                                                    int i28 = this.c;
                                                    char[] cArr10 = this.a;
                                                    int b9 = b();
                                                    int i29 = this.d + 1;
                                                    this.c = i29;
                                                    compiledIfNode = new DeclareNode(i28, str, cArr10, b9, i29);
                                                }
                                                i25.next = compiledIfNode;
                                                gVar.q(compiledIfNode);
                                                compiledIfNode.setTerminus(new TerminalNode());
                                                break;
                                            case 55:
                                                Node i30 = i(textNode);
                                                if (this.h) {
                                                    int i31 = this.c;
                                                    char[] cArr11 = this.a;
                                                    int b10 = b();
                                                    int i32 = this.d + 1;
                                                    this.c = i32;
                                                    compiledIfNode = new CompiledEvalNode(i31, str, cArr11, b10, i32, this.j);
                                                } else {
                                                    int i33 = this.c;
                                                    char[] cArr12 = this.a;
                                                    int b11 = b();
                                                    int i34 = this.d + 1;
                                                    this.c = i34;
                                                    compiledIfNode = new EvalNode(i33, str, cArr12, b11, i34);
                                                }
                                                i30.next = compiledIfNode;
                                                break;
                                            default:
                                                if (str.length() == 0) {
                                                    Node i35 = i(textNode);
                                                    if (this.h) {
                                                        int i36 = this.c;
                                                        char[] cArr13 = this.a;
                                                        int b12 = b();
                                                        int i37 = this.d + 1;
                                                        this.c = i37;
                                                        compiledIfNode = new CompiledExpressionNode(i36, str, cArr13, b12, i37, this.j);
                                                    } else {
                                                        int i38 = this.c;
                                                        char[] cArr14 = this.a;
                                                        int b13 = b();
                                                        int i39 = this.d + 1;
                                                        this.c = i39;
                                                        compiledIfNode = new ExpressionNode(i38, str, cArr14, b13, i39);
                                                    }
                                                    i35.next = compiledIfNode;
                                                    break;
                                                } else {
                                                    Map map2 = this.i;
                                                    if (map2 != null && map2.containsKey(str)) {
                                                        Class cls = (Class) this.i.get(str);
                                                        try {
                                                            Node i40 = i(textNode);
                                                            terminus = (Node) cls.newInstance();
                                                            i40.next = terminus;
                                                            terminus.setBegin(this.c);
                                                            terminus.setName(str);
                                                            terminus.setCStart(b());
                                                            int i41 = this.d + 1;
                                                            this.c = i41;
                                                            terminus.setCEnd(i41);
                                                            terminus.setEnd(terminus.getCEnd());
                                                            terminus.setContents(m.K0(this.a, terminus.getCStart(), (terminus.getCEnd() - terminus.getCStart()) - 1));
                                                            if (terminus.isOpenNode()) {
                                                                gVar.q(terminus);
                                                                break;
                                                            }
                                                        } catch (IllegalAccessException unused) {
                                                            throw new RuntimeException("unable to instantiate custom node class: " + cls.getName());
                                                        } catch (InstantiationException unused2) {
                                                            throw new RuntimeException("unable to instantiate custom node class: " + cls.getName());
                                                        }
                                                    }
                                                }
                                                break;
                                        }
                                    } else {
                                        Node i42 = i(textNode);
                                        Node node4 = (Node) gVar.n();
                                        terminus = node4.getTerminus();
                                        terminus.setCStart(b());
                                        int i43 = this.c;
                                        this.e = i43;
                                        terminus.setEnd(i43 - 1);
                                        terminus.calculateContents(this.a);
                                        if (node4.demarcate(terminus, this.a)) {
                                            i42.next = terminus;
                                        }
                                    }
                                    textNode = terminus;
                                } else {
                                    Node i44 = i(textNode);
                                    compiledIfNode = this.h ? new CompiledForEachNode(this.c, str, this.a, b(), this.c, this.j) : new ForEachNode(this.c, str, this.a, b(), this.c);
                                    i44.next = compiledIfNode;
                                    gVar.q(compiledIfNode);
                                    compiledIfNode.setTerminus(new TerminalNode());
                                }
                            } else if (!gVar.g() && (gVar.k() instanceof IfNode)) {
                                Node i45 = i(textNode);
                                IfNode ifNode = (IfNode) gVar.n();
                                i45.next = ifNode.getTerminus();
                                ifNode.demarcate(ifNode.getTerminus(), this.a);
                                textNode = this.h ? new CompiledIfNode(this.c, str, this.a, b(), this.c, this.j) : new IfNode(this.c, str, this.a, b(), this.c);
                                ifNode.next = textNode;
                                textNode.setTerminus(ifNode.getTerminus());
                                gVar.q(textNode);
                            }
                            textNode = compiledIfNode;
                        }
                    }
                }
                this.d++;
            } catch (RuntimeException e) {
                CompileException compileException2 = new CompileException(e.getMessage(), this.a, this.d, e);
                compileException2.setExpr(this.a);
                if (e instanceof CompileException) {
                    CompileException compileException3 = (CompileException) e;
                    if (compileException3.getCursor() != -1) {
                        compileException2.setCursor(compileException3.getCursor());
                        if (compileException3.getColumn() == -1) {
                            compileException2.setColumn(compileException2.getCursor() - this.g);
                        } else {
                            compileException2.setColumn(compileException3.getColumn());
                        }
                    }
                }
                compileException2.setLineNumber(this.f);
                throw compileException2;
            }
        }
        throw new RuntimeException("unknown token type: " + str);
    }
}
