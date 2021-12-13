package proven.friends.servlets;

import proven.friends.model.Friend;
import proven.friends.model.FriendModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FriendServlet extends HttpServlet {

    private FriendModel model;

    @Override
    public void init() {
        this.model = new FriendModel();
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP (code)GET(/code) method.
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
     * Handles the HTTP (code)POST(/code) method.
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
     * <strong>processRequest()</strong>
     * executes actions to manage categories.
     * @param request
     * @param response
     */
    public void processRequest(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        
        listAllFriendsTxt(request, response);
    }
    
    /**
     * serves a list of all friends in text format 
     *
     * @param response
     */
    public void listAllFriendsTxt(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Friend> entityList = (List<Friend>) model.findAll();
        try (PrintWriter out = response.getWriter()) {
        
            for (Friend elem : entityList) {
                System.out.println(elem.toString());

            }
        }
    }
    
}