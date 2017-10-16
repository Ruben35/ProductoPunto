/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author RubenHH
 */
public class Servlet extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int punto[][] = new int[2][3];
        punto[0][0] = Integer.parseInt(request.getParameter("x1"));
        punto[0][1] = Integer.parseInt(request.getParameter("y1"));
        punto[0][2] = Integer.parseInt(request.getParameter("z1"));
        punto[1][0] = Integer.parseInt(request.getParameter("x2"));
        punto[1][1] = Integer.parseInt(request.getParameter("y2"));
        punto[1][2] = Integer.parseInt(request.getParameter("z2"));
        int sumx=1;
        int sumy=1;
        int sumz=1;
        int res;
        
        try (PrintWriter out = response.getWriter()) {
            out.print("<html>");
            out.print("<head><title>niio</title></head>");
            out.print("<body>");            
            out.print("<p>");
            for (int i = 0; i < 2; i++) {
                if(i==0)
                    out.print("Vector 1:<br>");
                if(i==1)
                    out.print("Vector 2:<br>");
                for (int j = 0; j < 3; j++) {
                    if (j==0)
                        out.print("x:");
                    if (j==1)
                        out.print("y:");
                    if (j==2)
                        out.print("z:");
                    out.print(punto[i][j]+"&nbsp; &nbsp;");
                }
                out.print("<br><br>");
            }
            out.print("</p>");
            out.print("<p>");
            out.print("Suma:<br>");
            for (int i = 0; i < 2; i++) {                
                for (int j = 0; j < 3; j++) {                   
                    if (j==0) 
                        sumx = sumx * punto[i][j];
                    if (j==1) 
                        sumy = sumy * punto[i][j];
                    if (j==2) 
                        sumz = sumz * punto[i][j];
                }                
            }
            res = sumx + sumy + sumz;
            out.print(res);
            out.print("</p>");            
            out.print("</body>");
            out.print("</html>");
        }
    }

}
