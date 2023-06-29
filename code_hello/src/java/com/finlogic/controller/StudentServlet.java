/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.finlogic.controller;

import com.finlogic.service.StudentService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASHISH
 */
public class StudentServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            StudentService studentService = new StudentService();
            
            String process = request.getParameter("process");
            if (process.equals("load")) {
                request.setAttribute("process", process);
                RequestDispatcher view = request.getRequestDispatcher("students.jsp");
                view.forward(request, response); 
                
                
            }else if (process.equals("view") || process.equals("edit") || process.equals("delete")) {
                
                ResultSet rs = studentService.getAllStudents();
                request.setAttribute("process", process);
                request.setAttribute("result", rs);
                RequestDispatcher view = request.getRequestDispatcher("students.jsp");
                view.forward(request, response); 
                
            }else if (process.equals("add")) {
                request.setAttribute("process", process);
                RequestDispatcher view = request.getRequestDispatcher("students.jsp");
                view.forward(request, response);
                
            }else if (process.equals("insert")){
                int status = studentService.insertStudent(request.getParameter("name"), 
                        request.getParameter("address"), 
                        request.getParameter("email"), 
                        request.getParameter("state"), 
                        request.getParameter("city"));
                
                request.setAttribute("process", process);
                request.setAttribute("result", status);
                RequestDispatcher view = request.getRequestDispatcher("students.jsp");
                view.forward(request, response); 
                
            }
            else if (process.equals("loadEditModal")) {
                int id =  Integer.parseInt(request.getParameter("id"));
                ResultSet rs = studentService.getStudentDetails(id);
                request.setAttribute("process", process);
                request.setAttribute("result", rs);
                RequestDispatcher view = request.getRequestDispatcher("students.jsp");
                view.forward(request, response);
            }
            else if (process.equals("makeEdit")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                String address = request.getParameter("address");
                String email = request.getParameter("email");
                String state = request.getParameter("state");
                String city = request.getParameter("city");
//                out.print(id);
//                out.print(name);
//                out.print(address);
//                out.print(email);
//                out.print(state);
//                out.print(city);
                int status = studentService.EditStudents(id, name, address, email, state, city);
                out.print(status);
            }
            else if (process.equals("makeDelete")) {
                int id =  Integer.parseInt(request.getParameter("id"));
                if(studentService.deleteStudent(id) > 0){
                    out.print("1");
                }
                else{
                    out.print("0");
                }
            }
        }catch(SQLException exception){
        }
        finally {
            out.close();
        }
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
