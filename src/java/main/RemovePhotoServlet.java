/*
 */
package main;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "RemovePhotoServlet",
        urlPatterns = {"/RemovePhotoServlet"}
)
public class RemovePhotoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String indexString = request.getParameter("photo");
        int index = new Integer(indexString.trim());
        PhotoAlbum pa = PhotoAlbum.getPhotoAlbum(request.getSession());
        pa.removePhoto(index);
        RequestDispatcher rd = request.getRequestDispatcher("album.jsp");
        rd.forward(request, response);
    }
}
