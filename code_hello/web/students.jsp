<%-- 
    Document   : students
    Created on : 12-Jun-2023, 12:20:17 pm
    Author     : ASHISH
--%>
<%@page import="java.sql.ResultSet"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<c:if test="${process eq 'load'}">
    <ul class="nav nav-pills">
        <li class="nav-item"><a class="nav-link active" area-current="page" href="#" onclick="masterloader('add')">Add Students</a></li>
        <li class="nav-item"><a class="nav-link" href="#" onclick="masterloader('edit')">Edit Students</a></li>
        <li class="nav-item"><a class="nav-link" href="#" onclick="masterloader('delete')">Delete Students</a></li>
        <li class="nav-item"><a class="nav-link" href="#" onclick="masterloader('view')">View Students</a></li>
    </ul><br/>
    <div id="studentload">

    </div>
</c:if>
<c:if test="${process eq 'view' or process eq 'delete' or process eq 'edit'}">
    <table class="table">
        <thead>
            <tr>
                <th>#</th>
                <th>Name</th>
                <th>Address</th>
                <th>Email</th>
                <th>State</th>
                <th>City</th>
                    <c:if test="${process eq 'edit' or process eq 'delete'}">
                    <th>Action</th>
                    </c:if>
            </tr>
        </thead>
        <tbody>
            <%
                ResultSet rs = (ResultSet) request.getAttribute("result");
                int tmp = 0;
                while (rs.next()) {
            %>
            <tr>
                <td><%= ++tmp%></td>
                <td><%=rs.getString("name")%></td>
                <td><%=rs.getString("address")%></td>
                <td><%=rs.getString("email")%></td>
                <td><%=rs.getString("state")%></td>
                <td><%=rs.getString("city")%></td>
                <c:if test="${process eq 'edit'}">
                    <td><button type="button" onclick="populateModal(this, 'loadEditModal')" class="btn btn-secondary" style="width: 68px" data-bs-target="#" data-row-id="<%=rs.getString("id")%>">Edit</button></td>
                </c:if>

                <c:if test="${process eq 'delete'}">
                    <td><button type="button" onclick="makeDelete(this)" data-row-id="<%=rs.getString("id")%>" class="btn btn-warning" style="width: 68px" data-bs-target="#">Delete</button></td>
                </c:if>
            </tr
            <%
                }
            %>
        </tbody>
    </table>
    <div id="modal">

    </div>
</c:if>
<c:if test="${process eq 'add'}">
    <div class="mx-auto" style="width:75%">
        <h2>Add Students Form</h2>
        <form id="studForm">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" class="form-control" id="name" name="name">
            </div>
            <div class="form-group">
                <label for="address">Address:</label>
                <input type="text" class="form-control" id="address" name="address">
            </div>
            <div class="form-group">
                <label for="email">Email address:</label>
                <input type="email" class="form-control" id="email" name="email">
            </div>
            <div class="form-group">
                <label for="state">State:</label>
                <input type="text" class="form-control" id="state" name="state">
            </div>
            <div class="form-group">
                <label for="city">City:</label>
                <input type="text" class="form-control" id="city" name="city">
            </div>
            <button class="btn btn-primary" onclick="return ValidateStudentForm()">Add Students</button>
            <button type="reset" class="btn btn-warning">RESET</button>
        </form>
    </div>
    <div id="processAjax">

    </div>
</c:if>
<c:if test="${process eq 'insert'}">
    <input type="hidden" id="status" value="${result}"/>

</c:if>

<c:if test="${process eq 'loadEditModal'}">

    <%
        ResultSet result = (ResultSet) request.getAttribute("result");
        if (result.next()) {

    %>
    <!--Modal--> 
    <div class="modal fade" id="staticBackdrop">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="staticBackdropLabel">Edit Students info</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <!--<form id="editForm">-->
                <div class="modal-body">
                    <form id="editForm">
                            <input type="hidden" disabled="true" class="form-control" id="id" name="id" value="<%=result.getInt("id")%>">
                        <div class="form-group">
                            <label for="name">Name:</label>
                            <input type="text" class="form-control" id="name" name="name" value="<%=result.getString("name")%>">
                        </div>
                        <div class="form-group">
                            <label for="address">Address:</label>
                            <input type="text" class="form-control" id="address" name="address" value="<%=result.getString("address")%>">
                        </div>
                        <div class="form-group">
                            <label for="email">Email address:</label>
                            <input type="email" class="form-control" id="email" name="email" value="<%=result.getString("email")%>">
                        </div>
                        <div class="form-group">
                            <label for="state">State:</label>
                            <input type="text" class="form-control" id="state" name="state" value="<%=result.getString("state")%>">
                        </div>
                        <div class="form-group">
                            <label for="city">City:</label>
                            <input type="text" class="form-control" id="city" name="city" value="<%=result.getString("city")%>">
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" id="closeModal" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button id="btn" onclick="makeEdit()" type="submit" class="btn btn-primary">Submit</button>
                </div>
                <!--                </form>-->
                <input type="hidden" id="mAjax">
            </div>
        </div>
    </div>

    <%
        }
    %>
</c:if>

