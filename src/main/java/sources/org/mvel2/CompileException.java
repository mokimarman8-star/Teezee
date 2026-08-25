package org.mvel2;

import java.util.Collections;
import java.util.List;
import org.mvel2.util.m;
import org.mvel2.util.s;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class CompileException extends RuntimeException {
    private int column;
    private int cursor;
    private List<c> errors;
    private Object evaluationContext;
    private char[] expr;
    private int lastLineStart;
    private int lineNumber;
    private int msgOffset;

    public CompileException(String str, List<c> list, char[] cArr, int i, ParserContext parserContext) {
        super(str);
        this.msgOffset = 0;
        this.lineNumber = 1;
        this.column = 0;
        this.lastLineStart = 0;
        this.expr = cArr;
        this.cursor = i;
        if (!list.isEmpty()) {
            c next = list.iterator().next();
            this.cursor = next.c();
            this.lineNumber = next.e();
            this.column = next.b();
        }
        this.errors = list;
    }

    public CompileException(String str, char[] cArr, int i) {
        super(str);
        this.msgOffset = 0;
        this.lineNumber = 1;
        this.column = 0;
        this.lastLineStart = 0;
        this.expr = cArr;
        this.cursor = i;
    }

    public CompileException(String str, char[] cArr, int i, Throwable th) {
        super(str, th);
        this.msgOffset = 0;
        this.lineNumber = 1;
        this.column = 0;
        this.lastLineStart = 0;
        this.expr = cArr;
        this.cursor = i;
    }

    private void calcRowAndColumn() {
        int i;
        char[] cArr;
        int i2 = this.lineNumber;
        if (i2 > 1 || (i = this.column) > 1) {
            return;
        }
        if ((i2 != 0 && i != 0) || (cArr = this.expr) == null || cArr.length == 0) {
            return;
        }
        int i3 = 1;
        int i4 = 1;
        for (int i6 = 0; i6 < this.cursor; i6++) {
            char[] cArr2 = this.expr;
            if (i6 >= cArr2.length) {
                break;
            }
            char c = cArr2[i6];
            if (c == '\n') {
                i3++;
                i4 = 1;
            } else if (c != '\r') {
                i4++;
            }
        }
        this.lineNumber = i3;
        this.column = i4;
    }

    private String generateErrorMessage() {
        s d = new s().d("[Error: " + super.getMessage() + "]\n");
        int length = d.length();
        d.d("[Near : {... ");
        d.b(showCodeNearError(this.expr, this.cursor)).d(" ....}]\n").d(m.A0(' ', d.length() - length));
        if (this.msgOffset < 0) {
            this.msgOffset = 0;
        }
        d.d(m.A0(' ', this.msgOffset)).a('^');
        calcRowAndColumn();
        if (this.evaluationContext != null) {
            d.d("\n").d("In ").c(this.evaluationContext);
        } else if (this.lineNumber != -1) {
            d.d("\n").d("[Line: " + this.lineNumber + ", Column: " + this.column + "]");
        }
        return d.toString();
    }

    private CharSequence showCodeNearError(char[] cArr, int i) {
        String str;
        int i2;
        String substring;
        if (cArr == null) {
            return "Unknown";
        }
        int i3 = i - 20;
        int i4 = i + 30;
        if (i4 > cArr.length) {
            i4 = cArr.length;
            i3 = i - 50;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        String trim = String.copyValueOf(cArr, i3, i4 - i3).trim();
        if (i < i4) {
            int i6 = i;
            if (i > 0) {
                while (i6 > 0 && !m.q0(cArr[i6 - 1])) {
                    i6--;
                }
            }
            i2 = i - i6;
            str = new String(cArr, i6, cArr.length - i6);
            for (int i7 = 0; i7 < str.length(); i7++) {
                char charAt = str.charAt(i7);
                if (charAt == '\n' || charAt == ')') {
                    str = str.substring(0, i7);
                    break;
                }
            }
            if (str.length() >= 30) {
                str = str.substring(0, 30);
            }
        } else {
            str = null;
            i2 = 0;
        }
        while (true) {
            int indexOf = trim.indexOf(10);
            int lastIndexOf = trim.lastIndexOf(10);
            if (indexOf == -1) {
                break;
            }
            int indexOf2 = str == null ? 0 : trim.indexOf(str);
            if (indexOf == -1 || indexOf != lastIndexOf) {
                substring = indexOf < indexOf2 ? trim.substring(indexOf + 1, lastIndexOf) : trim.substring(0, indexOf);
            } else if (indexOf > indexOf2) {
                substring = trim.substring(0, indexOf);
            } else if (indexOf < indexOf2) {
                substring = trim.substring(indexOf + 1, trim.length());
            }
            trim = substring;
        }
        String trim2 = trim.trim();
        if (str != null) {
            this.msgOffset = trim2.indexOf(str) + i2;
        } else {
            this.msgOffset = trim.length() - (trim.length() - trim2.length());
        }
        if (this.msgOffset == 0 && i2 == 0) {
            this.msgOffset = i;
        }
        return trim2;
    }

    public CharSequence getCodeNearError() {
        return showCodeNearError(this.expr, this.cursor);
    }

    public int getColumn() {
        return this.column;
    }

    public int getCursor() {
        return this.cursor;
    }

    public int getCursorOffet() {
        return this.msgOffset;
    }

    public List<c> getErrors() {
        List<c> list = this.errors;
        return list != null ? list : Collections.emptyList();
    }

    public char[] getExpr() {
        return this.expr;
    }

    public int getLastLineStart() {
        return this.lastLineStart;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return generateErrorMessage();
    }

    public void setColumn(int i) {
        this.column = i;
    }

    public void setCursor(int i) {
        this.cursor = i;
    }

    public void setErrors(List<c> list) {
        this.errors = list;
    }

    public void setEvaluationContext(Object obj) {
        this.evaluationContext = obj;
    }

    public void setExpr(char[] cArr) {
        this.expr = cArr;
    }

    public void setLastLineStart(int i) {
        this.lastLineStart = i;
    }

    public void setLineNumber(int i) {
        this.lineNumber = i;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return generateErrorMessage();
    }
}
