/*
 */
package main;

import java.io.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DisplayPhotoServlet", urlPatterns = {"/DisplayPhotoServlet"})
public class DisplayPhotoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String indexString = request.getParameter("photo");
        int index = Integer.parseInt(indexString.trim());
        response.setContentType("image/jpeg");
        try (OutputStream out = response.getOutputStream()) {
            PhotoAlbum pa = PhotoAlbum.getPhotoAlbum(request.getSession());
            byte[] bytes = pa.getPhotoData(index);
            for (int i = 0; i < bytes.length; i++) {
                out.write(bytes[i]);
            }
        }
    }
}
