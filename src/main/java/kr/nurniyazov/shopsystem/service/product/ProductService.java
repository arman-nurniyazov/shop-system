package kr.nurniyazov.shopsystem.service.product;

import kr.nurniyazov.shopsystem.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    Page<Product> getProducts(int page, int size);

    Product getAndCheckProduct(int id, int count, String type) throws Exception;

    void order(List<Product> products, String type);

}
