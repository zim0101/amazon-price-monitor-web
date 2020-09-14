package backend.product.repository;

import backend.product.dto.ProductPriceDTO;

import java.util.List;

public interface ProductPriceHistoryRepository {

    List<ProductPriceDTO> getPriceHistory(int id);
}
