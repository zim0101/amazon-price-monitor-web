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


@WebServlet(urlPatterns = {
        "/products/filter-by-product-name",
        "/products/filter-by-product-price",
        "/products/filter-by-price-range"
})
public class FilterProductServlet extends HttpServlet {

    /**
     * ProductRepositoryImpl
     */
    ProductRepositoryImpl repository;

    @Override
    public void init() {
        repository = new ProductRepositoryImpl();
    }

    /**
     * Filters products by options
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        Optional<Set<Product>> products = filterProducts(request, action);

        dispatchWithProducts(request, response, products.orElse(null));
    }

    /**
     * Filter products by options
     *
     * @param request HttpServletRequest
     * @param action String
     * @return Optional<Set<Product>>
     */
    private Optional<Set<Product>> filterProducts(HttpServletRequest request, String action) {
        return switch (action) {
            case "/filter-by-product-name" ->
                    filterByProductName(request);
            case "/filter-by-product-price" ->
                    filterByProductPrice(request);
            case "/filter-by-price-range" ->
                    filterByProductPriceRange(request);
            default -> throw new IllegalStateException("Unexpected value: " + action);
        };
    }

    /**
     * Filter products by Name
     *
     * @param request HttpServletRequest
     * @return Optional<Set<Product>>
     */
    private Optional<Set<Product>> filterByProductName(HttpServletRequest request){

        return repository.filterProductsByName(request.getParameter(
                "search_string"));
    }

    /**
     * Filter products by Price
     *
     * @param request HttpServletRequest
     * @return Optional<Set<Product>>
     */
    private Optional<Set<Product>> filterByProductPrice(HttpServletRequest request){
        return repository.filterProductsByPrice(
                Double.parseDouble(request.getParameter("price")));
    }

    /**
     * Filter products by price range
     *
     * @param request HttpServletRequest
     * @return Optional<Set<Product>>
     */
    private Optional<Set<Product>> filterByProductPriceRange(HttpServletRequest request){
        return repository.filterProductsByPriceRange(
                Double.parseDouble(request.getParameter("min_price")),
                Double.parseDouble(request.getParameter("max_price")));
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("products/list.jsp");
        dispatcher.forward(request, response);
    }
}

