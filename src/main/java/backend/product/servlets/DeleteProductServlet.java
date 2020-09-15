package backend.product.servlets;


import backend.product.repository.ProductRepositoryImpl;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "DeleteProduct", urlPatterns = "/products/delete")
public class DeleteProductServlet extends HttpServlet {

    /**
     * Delete product by table id
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws IOException IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        ProductRepositoryImpl repository = new ProductRepositoryImpl();
        repository.delete(Integer.parseInt(request.getParameter("id")));
        response.sendRedirect(request.getContextPath() + "/products/list");
    }
}
