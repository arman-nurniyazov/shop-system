package kr.nurniyazov.shopsystem.service.product;

import kr.nurniyazov.shopsystem.enums.OperationType;
import kr.nurniyazov.shopsystem.model.Product;
import kr.nurniyazov.shopsystem.model.Transaction;
import kr.nurniyazov.shopsystem.repository.ProductRepository;
import kr.nurniyazov.shopsystem.repository.TransactionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final TransactionRepository transactionRepository;

    public ProductServiceImpl(ProductRepository productRepository, TransactionRepository transactionRepository) {
        this.productRepository = productRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Page<Product> getProducts(int page, int size) {
        return productRepository.findAll(PageRequest.of(page - 1, size, Sort.by(Sort.Direction.ASC, "id")));
    }

    @Override
    public Product getAndCheckProduct(int id, int count, String type) throws Exception {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(!optionalProduct.isPresent() || count < 0) {
            throw new Exception();
        }
        Product product = optionalProduct.get();
        if(type.equals("input") && product.getCount() < count) {
            throw new Exception();
        }
        product.setCount(count);
        return product;
    }

    @Override
    public void order(List<Product> products, String type) {
        products.forEach(product -> {
            Optional<Product> optionalProduct = productRepository.findById(product.getId());
            Product updatedProduct = optionalProduct.get();
            updatedProduct.setCount(type.equals("input") ?
                    updatedProduct.getCount() - product.getCount() : updatedProduct.getCount() + product.getCount());
            productRepository.save(updatedProduct);
            transactionRepository.save(new Transaction(product.getId(), product.getCount(),
                    type.equals("input") ? OperationType.INPUT : OperationType.OUTPUT));
        });
    }
}
