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
import com.loyalty.dxvalley.models.Packagess;
import com.loyalty.dxvalley.services.PackagesService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api/packages")
@RestController
@RequiredArgsConstructor
public class PackagessController {
    
    @Autowired
    private final PackagesService packagessService;

    @GetMapping("/getPackages")
        List<Packagess> getPackagesses(){
            return this.packagessService.getPackage();
        }

     @GetMapping("/{packageId}") 
     Packagess getPackages(@PathVariable Long packageId) {
        return packagessService.getPackagesById(packageId);
     }
     

     @PostMapping("/addPackages")
    public ResponseEntity<CreateResponse> addPackagess (@RequestBody Packagess packagess) {
        packagessService.addPackages(packagess);
        CreateResponse response = new CreateResponse("Success","Packages created successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }   
    
      @PutMapping("/edit/{packageId}")
      Packagess editPackagess(@RequestBody Packagess tempPackagess, @PathVariable Long packageId) {
        Packagess packagess = this.packagessService.getPackagesById(packageId);
        packagess.setPackageName(tempPackagess.getPackageName());
        packagess.setPackageDescription(tempPackagess.getPackageDescription());
        packagess.setLogo(tempPackagess.getLogo()); 
        packagess.setIsEnabeled(tempPackagess.getIsEnabeled());
        return packagessService.editPackages(packagess);
        
    }


    
}
