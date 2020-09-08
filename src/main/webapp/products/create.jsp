<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Amazon Price Notifier | Create</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

</head>
<body>
    <div class="container">
        <h2>Welcome to amazon price notifier</h2>
        <ol>
            <li><a href="<%=request.getContextPath()%>/products/create">Create</a></li>
            <li><a href="<%=request.getContextPath()%>/products/list">List</a></li>
        </ol>
        <hr>
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

    <!-- JS, Popper.js, and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</body>
</html>
