/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package proven.teamplayer.servlets;

import cat.proven.teamplayer.model.Team;
import cat.proven.teamplayer.model.TeamPlayerModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import proven.teamplayer.lib.RequestResult;

/**
 *
 * @author alumne
 */
public class TeamServlet extends HttpServlet {

    /**
     * the model: provides data access.
     */
    private TeamPlayerModel model;

    @Override
    public void init() throws ServletException {
        this.model = new TeamPlayerModel();
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
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "s_all":
                    listAllTeams(request, response);
                 case "f_id":
                    listAllTeams(request, response);
                    break;
            }
        } else { // parameter action needed
//            redirectError(request, response, "no_action");
        }
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

    private void listAllTeams(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Team> entityList = (List<Team>) model.findAllTeams();
        RequestResult result = new RequestResult(entityList, 1);
        request.setAttribute("result", result);
        RequestDispatcher rd = getServletContext()
            .getRequestDispatcher("/WEB-INF/jsp/json-result.jsp");
        rd.forward(request, response);
    }

}
