package kr.nurniyazov.shopsystem.controller;

import kr.nurniyazov.shopsystem.model.Product;
import kr.nurniyazov.shopsystem.service.product.ProductService;
import kr.nurniyazov.shopsystem.util.Util;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@Scope(value = "session")
@RequestMapping("/products")
public class ProductController {

    private List<Product> cart = new ArrayList<>();
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getProducts(@RequestParam(required = false, defaultValue = "1") Integer page,
                              @RequestParam(required = false, defaultValue = "5") Integer size,
                              Model model) {
        Page<Product> productPage = productService.getProducts(page, size);
        Util.generateModel(model, "products", productPage, page, size);
        return "products";
    }

    @GetMapping(value = "/add")
    public String getAddPage(@RequestParam("type") String type,
                             @RequestParam(required = false, defaultValue = "1") Integer page,
                             @RequestParam(required = false, defaultValue = "5") Integer size,
                             Model model) {
        Page<Product> productPage = productService.getProducts(page, size);
        Util.generateModel(model, "products", productPage, page, size);
        model.addAttribute("cartProducts", cart);
        model.addAttribute("total", cart.stream().mapToDouble(product -> product.getCount() * product.getPrice()).sum());
        model.addAttribute("type", type);
        return "add";
    }

    @PostMapping(value = "/{id}/add")
    public String addProduct(@PathVariable Integer id,
                             @RequestParam("count") Integer count,
                             @RequestParam("type") String type,
                             @RequestParam(required = false, defaultValue = "1") Integer page,
                             @RequestParam(required = false, defaultValue = "5") Integer size) throws Exception {
        Product product = productService.getAndCheckProduct(id, count, type);
        cart.add(product);
        return "redirect:/products/add?type=" + type + "&page=" + page + "&size=" + size;
    }

    @PostMapping(value = "/order")
    public String addOrder(@RequestParam("type") String type,
                           @RequestParam(required = false, defaultValue = "1") Integer page,
                           @RequestParam(required = false, defaultValue = "5") Integer size,
                           Model model) {
        productService.order(cart, type);
        Page<Product> products = productService.getProducts(page, size);
        Util.generateModel(model, "products", products, page, size);
        cart = new ArrayList<>();
        return "redirect:/products/add?type=" + type + "&page=" + page + "&size=" + size;
    }

}
