<%@ page import="backend.product.entity.Product" %>
<%@ page session="false" %>
<%@ include file="/layouts/header.jsp" %>
    <div class="container">
        <%@ include file="/layouts/navbar.jsp" %>
        <% Product product = (Product) request.getAttribute("product"); %>
        <div>
            <h2>Product Details</h2>
            <table>
                <tr>
                    <th>Name</th>
                    <th>Price</th>
                    <th>URL</th>
                </tr>
                <tr>
                    <td><%= product.getName() %> </td>
                    <td><%= product.getPrice() %> </td>
                    <td><a target="_blank" href="<%= product.getUrl() %>">url</a></td>
                </tr>
            </table>
        </div>
    </div>
<%@ include file="/layouts/footer.jsp" %>
