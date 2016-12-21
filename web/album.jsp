<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="photo" uri="WEB-INF/tlds/hello.tld"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="photoAlbum" scope = "session" class="main.PhotoAlbum"/>
<jsp:setProperty name="photoAlbum" property="session" value="<%=session%>"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Photo Viewer</title>
    </head>
    <body>
        <h3 align='center'>Photos</h3>
        <table align='center'>
            <tr>
                <c:forEach var="i" begin="1" end="${photoAlbum.photoCount}">
                    <td align='center'>
                        <photo:photo width='150' height='120' index='${i-1}'/>
                    </td>
                </c:forEach>
                    <td bgcolor='#cccccc' width='120' height='120' rowspan="3">
                    <form align='left' action='UploadServlet' method='post' enctype='multipart/form-data'>
                        <input value='Choose' name='myFile'
                               type='file' accept='image/jpeg'/><br/>
                        <input value='Upload' type='submit'/>
                    </form>
                </td>
            </tr>
            <tr>
                <c:forEach var="item" items="${photoAlbum.photoNames}">
                    <td align='center'>
                        ${item}
                    </td>
                </c:forEach>
            </tr>
            <tr>
                <c:forEach var="i" begin="1" end="${photoAlbum.photoCount}">
                    <td align='center'>
                        <a href='RemovePhotoServlet?photo=${i-1}'>remove</a>
                    </td>
                </c:forEach>
            </tr>
        </table>
    </body>
</html>