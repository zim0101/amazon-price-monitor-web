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


@WebServlet(urlPatterns = "/products/create")
public class CreateProductServlet extends HttpServlet {

    /**
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws ServletException Servlet Exception
     * @throws IOException IO Exception
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws IOException IO Exception
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        ProductRepositoryImpl repository = new ProductRepositoryImpl();
        Product product = new Product(
                request.getParameter("name"),
                Double.parseDouble(request.getParameter("price")),
                "Amazon",
                request.getParameter("url"),
                request.getParameter("price_selector"),
                request.getParameter("name_selector")
        );
        repository.create(product);
        response.sendRedirect(request.getContextPath() + "/products/list");
    }
}
