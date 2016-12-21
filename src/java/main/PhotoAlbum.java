/*
 */
package main;

import java.util.*;
import javax.servlet.http.HttpSession;

public class PhotoAlbum {

    public static String ATTRIBUTE_NAME = "Photo_Album";

    public static PhotoAlbum getPhotoAlbum(HttpSession session) {
        return (PhotoAlbum) session.getAttribute(ATTRIBUTE_NAME);
    }

    private List<byte[]> photoDataList = new ArrayList<>();
    private List<String> names = new ArrayList<>();

    public void setSession(HttpSession session) {
        session.setAttribute(ATTRIBUTE_NAME, this);
    }
    
    public List<String> getPhotoNames(){
        return names;
    }

    public void addPhoto(String name, byte[] bytes) {
        photoDataList.add(bytes);
        names.add(name);
    }

    public byte[] getPhotoData(int i) {
        return photoDataList.get(i);
    }

    public String getPhotoName(int i) {
        return names.get(i);
    }

    public int getPhotoCount() {
        return photoDataList.size();
    }

    public void removePhoto(int i) {
        photoDataList.remove(i);
        names.remove(i);
    }
}
