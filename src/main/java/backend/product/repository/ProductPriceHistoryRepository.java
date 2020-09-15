package backend.product.repository;

import backend.product.dto.ProductPriceDTO;

import java.util.List;

public interface ProductPriceHistoryRepository {

    /**
     * Get price history of a product by it's id and in ascending order of date.
     *
     * @param id product id
     * @return List of ProductPriceDTO
     */
    List<ProductPriceDTO> getPriceHistory(int id);
}
