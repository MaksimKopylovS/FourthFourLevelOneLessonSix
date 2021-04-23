package max_sk.HomeWork.service;

import lombok.RequiredArgsConstructor;
import max_sk.HomeWork.model.Product;
import max_sk.HomeWork.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final EntityManager entityManager;

    @Transactional
    public List<Product> productList(){
        String query = "select * from product";
        List<Object[]> list = entityManager.createNativeQuery(query).getResultList();
        List<Product> productList = new ArrayList<>();

        for(Object[] objects : list){
            productList.add(new Product((BigInteger) objects[0], (String) objects[1], (Integer) objects[2], (Date) objects[3], (Date) objects[4]));
        }
        return productList;
    }
}
