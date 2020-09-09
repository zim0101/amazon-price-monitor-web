<%@ page import="backend.product.entity.Product" %>
<%@ page import="java.util.Set" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/layouts/header.jsp" %>
<div class="container">
<%@ include file="/layouts/navbar.jsp" %>
    <% Set<Product> products = (Set<Product>) request.getAttribute("products"); %>
    <div>
        <h2>Product List</h2>
        <table>
            <tr>
                <th>Name</th>
                <th>Price</th>
                <th>URL</th>
                <th>Action</th>
            </tr>
            <% for(Product product: products) { %>
                <tr>
                    <td><%= product.getName() %> </td>
                    <td><%= product.getPrice() %> </td>
                    <td><a target="_blank" href="<%= product.getUrl() %>">url</a></td>
                    <td>
                        <a class="btn btn-outline-success"
                           href="<%= request.getContextPath()%>/products/details?id=<%=
                        product.getId() %>">
                            Details
                        </a>
                        <a class="btn btn-outline-primary"
                           href="<%= request.getContextPath()%>/products/edit?id=<%=
                            product.getId() %>">
                            Edit
                        </a>
                        <form action="<%=request.getContextPath()%>/products/delete"
                              method="post">
                            <input type="hidden" name="id" value="<%=product.getId()%>">
                            <button type="submit" class="btn btn-outline-danger">Delete</button>
                        </form>
                    </td>
                </tr>
            <% } %>

        </table>
    </div>
</div>
<%@ include file="/layouts/footer.jsp" %>
