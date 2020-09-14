<%@ page import="backend.product.entity.Product" %>
<%@ page import="java.util.Set" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/layouts/header.jsp" %>
<%@ include file="/layouts/navbar.jsp" %>
<div class="container">
    <% Set<Product> products = (Set<Product>) request.getAttribute("products"); %>
    <div>
        <div class="page-section">
            <h4>Product List</h4>
        </div>
        <table class="table table-dark">
            <thead>
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Price</th>
                    <th scope="col">URL</th>
                    <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody>
            <% for(Product product: products) { %>
            <tr>
                <td><%= product.getName() %> </td>
                <td><%= product.getPrice() %> </td>
                <td><a target="_blank" href="<%= product.getUrl() %>">url</a></td>
                <td>
                    <div class="row float-right">
                        <div class="col-3">
                            <a class="btn btn-outline-success"
                               href="<%=request.getContextPath()%>/products/details?id=<%=product.getId()%>">
                                Details
                            </a>
                        </div>
                        <div class="col-3">
                            <a class="btn btn-outline-primary"
                               href="<%= request.getContextPath()%>/products/edit?id=<%=
                                product.getId() %>">
                                Edit
                            </a>
                        </div>
                        <div class="col-3">
                            <form action="<%=request.getContextPath()%>/products/delete"
                                  method="post">
                                <input type="hidden" name="id" value="<%=product.getId()%>">
                                <button type="submit" class="btn btn-outline-danger">Delete</button>
                            </form>
                        </div>
                        <div class="col-3">
                            <a class="btn btn-outline-info"
                               href="<%= request.getContextPath()%>/products/graph?id=<%=
                                product.getId() %>">
                                Graph
                            </a>
                        </div>
                    </div>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</div>
<%@ include file="/layouts/footer.jsp" %>
<%@ include file="/layouts/end.jsp" %>
