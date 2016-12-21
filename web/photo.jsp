<%@page import="java.io.OutputStream"%>
<%@page import="main.PhotoAlbum"%>
<%@page contentType="image/jpeg" trimDirectiveWhitespaces="true"%>
<%
    OutputStream binaryOut = response.getOutputStream();
    String indexString = request.getParameter("photo");
    int index = new Integer(indexString.trim());
    PhotoAlbum photo = PhotoAlbum.getPhotoAlbum(session);
    byte[] bytes = photo.getPhotoData(index);
    for (int i = 0; i < bytes.length; i++) {
        binaryOut.write(bytes[i]);
    }
%>