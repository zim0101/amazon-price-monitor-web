<%@ page import="backend.product.entity.Product" %>
<%@ page import="java.util.Set" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/layouts/header.jsp" %>
<%@ include file="/layouts/navbar.jsp" %>


<div class="container">
    <% Set<Product> products = (Set<Product>) request.getAttribute("products"); %>
    <div>

        <div class="page-section">
            <h3>Product List</h3>
        </div>

        <div class="page-section">
            <%-- searching --%>
            <div class="row">
                <div class="col-4">
                    <form action="<%= request.getContextPath()%>/products/filter-by-product-name"
                          method="get">
                        <div class="form-group d-flex flex-row">
                            <div class="p-2">
                                <label for="searchString">Search By Name</label>
                            </div>
                            <div class="p-2">
                                <input type="text" id="searchString" class="form-control"
                                       name="search_string" placeholder="search by name">
                            </div>
                            <div class="p-2">
                                <button type="submit" class="btn btn-outline-info">Go</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="col-4">
                    <form action="<%= request.getContextPath()%>/products/filter-by-product-price"
                          method="get">
                        <div class="form-group d-flex flex-row">
                            <div class="p-2">
                                <label for="price">Search By Price</label>
                            </div>
                            <div class="p-2">
                                <input type="text" id="price" class="form-control"
                                       name="price" placeholder="search by price">
                            </div>
                            <div class="p-2">
                                <button type="submit" class="btn btn-outline-info">Go</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="col-4">
                    <form action="<%= request.getContextPath()%>/products/filter-by-price-range"
                          method="get">
                        <div class="form-group d-flex flex-row">
                            <div class="p-2">
                                <label for="minPrice">Min Price</label>
                            </div>
                            <div class="p-2">
                                <input type="text" id="minPrice" class="form-control"
                                       name="min_price" placeholder="Min">
                            </div>

                            <div class="p-2">
                                <label for="maxPrice">Max Price</label>
                            </div>
                            <div class="p-2">
                                <input type="text" id="maxPrice" class="form-control"
                                       name="max_price" placeholder="Max">
                            </div>
                            <div class="p-2">
                                <button type="submit" class="btn btn-outline-info">Go</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <%-- Ordering --%>
            <div class="row">
                <div class="col-12">
                    <form action="<%= request.getContextPath()%>/products/sort" method="get">
                        <div class="form-group d-flex flex-row">
                            <div class="p-2">
                                <label for="orderBy">Order By</label>
                            </div>
                            <div class="p-2">
                                <select class="form-control" name="order_by" id="orderBy">
                                    <option value="name">Name</option>
                                    <option value="price">Price</option>
                                </select>
                            </div>
                            <div class="p-2">
                                <label for="orderOption">Order Option</label>
                            </div>
                            <div class="p-2">
                                <select class="form-control" name="order_option" id="orderOption">
                                    <option value="ASC">Ascending</option>
                                    <option value="DESC">Descending</option>
                                </select>
                            </div>
                            <div class="p-2">
                                <button type="submit" class="btn btn-outline-info">Sort Products</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
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
