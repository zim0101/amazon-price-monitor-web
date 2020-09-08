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


@WebServlet(name = "EditProduct", urlPatterns = "/products/edit")
public class EditProductServlet extends HttpServlet {

    /**
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductRepositoryImpl repository = new ProductRepositoryImpl();
        int id = Integer.parseInt(request.getParameter("id"));
        Optional<Product> product = repository.findOne(id);
        request.setAttribute("product", product.orElse(null));
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws IOException IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        ProductRepositoryImpl repository = new ProductRepositoryImpl();
        Product product = new Product(
                Integer.parseInt(request.getParameter("id")),
                request.getParameter("name"),
                Double.parseDouble(request.getParameter("price")),
                "Amazon",
                request.getParameter("url"),
                request.getParameter("price_selector"),
                request.getParameter("name_selector")
        );
        repository.update(product);
        response.sendRedirect(request.getContextPath() + "/products/list");
    }
}