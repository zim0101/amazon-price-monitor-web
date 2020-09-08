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


@WebServlet(urlPatterns = "/products/details")
public class ProductDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductRepositoryImpl repository = new ProductRepositoryImpl();
        int id = Integer.parseInt(request.getParameter("id"));
        Optional<Product> product = repository.findOne(id);
        request.setAttribute("product", product.orElse(null));
        RequestDispatcher dispatcher = request.getRequestDispatcher("details.jsp");
        dispatcher.forward(request, response);
    }
}
