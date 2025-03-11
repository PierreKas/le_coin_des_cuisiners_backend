package coin.cuisiniers.dashboard_backend.controller;

import lombok.extern.slf4j.Slf4j;
import com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.service.ProductService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/products")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public class ProductController {
    @Autowired
    private ProductService productService;

    //End point to get all products
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts(){
        try {
            List<Product> productList= productService.getAllProducts();
            return new ResponseEntity<>(productList, HttpStatus.OK);
        } catch (Exception e) {
            log.error("error ", e);
          //
            return null;
        }
    }

    //End point to get products with low quantity
    @GetMapping("/low-qty")
    public ResponseEntity<List<Product>> getLowQtyProducts(){
        try {
            List<Product> productList= productService.getLowQtyProducts();
            return new ResponseEntity<>(productList, HttpStatus.OK);
        } catch (Exception e) {
            log.error("error ", e);
            //
            return null;
        }
    }

    //End point to get Out Of Stock products
    @GetMapping("/out-of-stock")
    public ResponseEntity<List<Product>> getOutOfStockProducts(){
        try {
            List<Product> productList= productService.getOutOfStockProducts();
            return new ResponseEntity<>(productList, HttpStatus.OK);
        } catch (Exception e) {
            log.error("error ", e);

            return null;
        }
    }
}
