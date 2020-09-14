package backend.product.servlets;

import backend.product.dto.ProductPriceDTO;
import backend.product.repository.ProductPriceHistoryRepositoryImpl;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/products/graph")
public class ProductPriceGraphServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductPriceHistoryRepositoryImpl repository = new ProductPriceHistoryRepositoryImpl();
        List<ProductPriceDTO> productPriceDTOS = repository.getPriceHistory(
                Integer.parseInt(request.getParameter("id")));
        request.setAttribute("productPriceDTOS", productPriceDTOS);
        RequestDispatcher dispatcher = request.getRequestDispatcher("single_price_graph.jsp");
        dispatcher.forward(request, response);
    }
}
