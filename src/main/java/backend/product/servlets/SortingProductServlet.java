package backend.product.servlets;


import backend.product.entity.Product;
import backend.product.repository.ProductRepositoryImpl;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import java.util.Set;


@WebServlet(urlPatterns = "/products/sort")
public class SortingProductServlet extends HttpServlet {

    /**
     * ProductRepositoryImpl
     */
    ProductRepositoryImpl repository;

    @Override
    public void init() {
        repository = new ProductRepositoryImpl();
    }

    /**
     * Sort products.
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Optional<Set<Product>> products = sortProducts(
                request.getParameter("order_by"),
                request.getParameter("order_option")
        );

        dispatchWithProducts(request, response, products.orElse(null));
    }

    /**
     * Sort products.
     *
     * @param orderBy String
     * @param orderOption String
     * @return Optional<Set<Product>>
     */
    private Optional<Set<Product>> sortProducts(String orderBy, String orderOption) {
        return switch (orderBy) {
            case "name" -> orderByName(orderOption);
            case "price" -> orderByPrice(orderOption);
            default -> throw new IllegalStateException("Unexpected value: " + orderBy);
        };
    }

    /**
     * Sort products by name.
     *
     * @param orderOption String, ASC/DESC
     * @return Optional<Set<Product>>
     */
    private Optional<Set<Product>> orderByName(String orderOption) {
        return switch (orderOption) {
            case "ASC" -> repository.findAll();
            case "DESC" -> repository.getProductsInDescendingOrderByName();
            default -> throw new IllegalStateException("Unexpected value: " + orderOption);
        };
    }

    /**
     * Sort products by price.
     *
     * @param orderOption String, ASC/DESC
     * @return Optional<Set<Product>>
     */
    private Optional<Set<Product>> orderByPrice(String orderOption) {
        return switch (orderOption) {
            case "ASC" ->repository.findAll();
            case "DESC" -> repository.getProductsInDescendingOrderByPrice();
            default -> throw new IllegalStateException("Unexpected value: " + orderOption);
        };
    }

    /**
     * Forwards request to list page with products.
     *
     * @param request HttpServletRequest
     */
    private void dispatchWithProducts(HttpServletRequest request, HttpServletResponse response,
                                      Set<Product> products)
            throws ServletException, IOException {
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }
}
