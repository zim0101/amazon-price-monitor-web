<%@ page import="backend.product.entity.Product" %>
<%@ page session="false" %>
<%@ include file="/layouts/header.jsp" %>
<%@ include file="/layouts/navbar.jsp" %>
    <div class="container">
        <div class="page-section">
            <h4>Product Details</h4>
        </div>
        <% Product product = (Product) request.getAttribute("product"); %>
        <div>
            <table class="table table-dark">
                <thead>
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Price</th>
                        <th scope="col">URL</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><%= product.getName() %> </td>
                        <td><%= product.getPrice() %> </td>
                        <td><a target="_blank" href="<%= product.getUrl() %>">url</a></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
<%@ include file="/layouts/footer.jsp" %>
<%@ include file="/layouts/end.jsp" %>
