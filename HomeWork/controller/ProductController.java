package max_sk.HomeWork.controller;

import lombok.RequiredArgsConstructor;
import max_sk.HomeWork.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/s")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public void getProduct(){

        for(int i = 0; i < productService.productList().size(); i++) {
            System.out.println(productService.productList().get(i).toString());
        }
    }
}

