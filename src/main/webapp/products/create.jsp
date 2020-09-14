<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/layouts/header.jsp" %>
<%@ include file="/layouts/navbar.jsp" %>
    <div class="container">
        <div class="page-section">
            <h4>Entry Product</h4>
        </div>
        <form method="post">
            <div class="form-group">
                <label for="name">Name</label>
                <input class="form-control" type="text" id="name" name="name" value="">
            </div>
            <div class="form-group">
                <label for="price">Price</label>
                <input class="form-control" type="number" id="price" name="price" value="">
            </div>
            <div class="form-group">
                <label for="url">Url</label>
                <input class="form-control" type="text" id="url" name="url" value="">
            </div>
            <div class="form-group">
                <label for="priceSelector">Price Selector</label>
                <input class="form-control" type="text" id="priceSelector" name="price_selector" value="">
            </div>
            <div class="form-group">
                <label for="nameSelector">Name Selector</label>
                <input class="form-control" type="text" id="nameSelector" name="name_selector" value="">
            </div>
            <button class="btn btn-outline-success" type="submit">Save</button>
        </form>
    </div>
<%@ include file="/layouts/footer.jsp" %>
<%@ include file="/layouts/end.jsp" %>
