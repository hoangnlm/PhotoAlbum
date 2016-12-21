/*
 */
package main;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @created on Dec 21, 2016, 3:47:30 PM
 * @author HoangNLM
 */
public class PhotoTag extends SimpleTagSupport {

    private int index;
    private int width = 50;
    private int height = 50;

    public void setIndex(int index) {
        this.index = index;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Called by the container to invoke this tag. The implementation of this method is provided by the tag library developer, and handles all tag processing, body iteration, etc.
     *
     * @throws javax.servlet.jsp.JspException
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        try {
            out.println("<a href='photo.jsp?photo=" + index + "'>");
            out.println("<img src='photo.jsp?photo=" + index + "' alt='photo' height ='" + height + "'  width='" + width + "'>");
            out.println("</a>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in PhotoTag tag", ex);
        }
    }
}
