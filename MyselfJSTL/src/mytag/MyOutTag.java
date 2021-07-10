package mytag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import java.io.IOException;

public class MyOutTag implements Tag {

    //现在我们要模仿<c:out value="">   这个是头标签
    //
    // </c:out>这个标签 这个是结束标签

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override  //浏览器加载头标签以后做的事情
    public int doStartTag() throws JspException {
        return Tag.EVAL_BODY_INCLUDE;
//        return Tag.SKIP_BODY;
    }

    @Override  //浏览器加载结束标签之前做的事情。
    public int doEndTag() throws JspException {
        //获取out对象
        JspWriter out = pageContext.getOut();
        try {
            out.write(value+"dpj很帅");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Tag.EVAL_PAGE;
//        return Tag.SKIP_PAGE;
    }


//==================================
    private Tag parent;
    @Override
    public void setParent(Tag parent) {
        this.parent = parent;
    }

    @Override
    public Tag getParent() {
        return this.parent;
    }
//===================================
    private PageContext pageContext;
    @Override
    public void setPageContext(PageContext pageContext) {
        this.pageContext = pageContext;
    }

    public PageContext getPageContext() {
        return pageContext;
    }

    @Override
    public void release() {

    }
}
