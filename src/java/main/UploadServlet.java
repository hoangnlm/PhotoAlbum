/*
 */
package main;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author HoangNLM
 */
@WebServlet(name = "UploadServlet", urlPatterns = {"/UploadServlet"})
@MultipartConfig
public class UploadServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private void uploadPhoto(HttpServletRequest request, PhotoAlbum pa) throws IOException, ServletException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String filename = null;
        System.out.println("parts:" + request.getParts());
        for (Part p : request.getParts()) {
            copyBytes(p.getInputStream(), baos);
            filename = p.getSubmittedFileName();
        }
        if (!"".equals(filename)) {
            String photoName = filename.substring(0, filename.lastIndexOf("."));
            pa.addPhoto(photoName, baos.toByteArray());
        }
    }

    private void copyBytes(InputStream is, OutputStream os) throws IOException {
        int i;
        while ((i = is.read()) != -1) {
            os.write(i);
        }
        is.close();
        os.close();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PhotoAlbum pa = PhotoAlbum.getPhotoAlbum(request.getSession());
        if (request.getContentType() != null
                && request.getContentType().startsWith("multipart/form-data")) {
            uploadPhoto(request, pa);
        }
        request.getRequestDispatcher("album.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
