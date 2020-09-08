<%@ page import="backend.product.entity.Product" %>
<%@ page session="false" %>
<html>
<head>
    <title>Amazon Price Notifier | Details</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Welcome to amazon price notifier</h2>
        <ol>
            <li><a href="<%=request.getContextPath()%>/products/create">Create</a></li>
            <li><a href="<%=request.getContextPath()%>/products/list">List</a></li>
        </ol>
        <hr>
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

    <!-- JS, Popper.js, and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</body>
</html>
