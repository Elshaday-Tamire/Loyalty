package com.loyalty.dxvalley.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.loyalty.dxvalley.models.CreateResponse;
import com.loyalty.dxvalley.models.ProductCataloge;
import com.loyalty.dxvalley.services.ProductCatalogService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api/productCatalog")
@RestController
@RequiredArgsConstructor
public class ProductCatalogeController {
      @Autowired
    private final ProductCatalogService productCatalogService;
    @PostMapping("/addProductCatalog")
    public ResponseEntity<CreateResponse> addProductCatalog (@RequestBody ProductCataloge productCataloge) {
        productCatalogService.addProductCataloge(productCataloge);
        CreateResponse response = new CreateResponse("Success","ProductCatelog created successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    } 
      @PutMapping("/edit/{productCatalogeId}")
      ProductCataloge editProductCatalog(@RequestBody ProductCataloge tempProductCatalog, @PathVariable Long productCatalogeId) {
        ProductCataloge productCatalog = this.productCatalogService.getProductCatalogeById(productCatalogeId);
        productCatalog.setProductName(tempProductCatalog.getProductName());
        productCatalog.setCreatedAt(tempProductCatalog.getCreatedAt());
        productCatalog.setProductLogo(tempProductCatalog.getProductLogo());
        productCatalog.setDescription(tempProductCatalog.getDescription());
        return productCatalogService.editProductCataloge(productCatalog);
 }

  @GetMapping("/getAll")
  List<ProductCataloge> getAll() {
   return productCatalogService.getChallengeCataloges();
  }
}
