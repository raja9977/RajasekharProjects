//package com.raja.react.controller;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.raja.react.entity.ReactEntity;
//import com.raja.react.repository.ReactRepository;
//
//@RestController
//@RequestMapping("/api/v1")
//@CrossOrigin(origins = "*")
//
//public class ReactController {
//	@Autowired
//	ReactRepository reactRepository;
//	
//
//	@PostMapping("/save")
//	public ResponseEntity<?> save(@RequestBody ReactEntity reactEntity) {
//		ReactEntity pro = reactRepository.save(reactEntity);
//		return ResponseEntity.status(HttpStatus.CREATED)
//								.header("success", "all")
//								.body(pro);
//	}
//	
//	@GetMapping("/products")
//	public ResponseEntity<?> getAllProducts(){
//		List<ReactEntity> pro = reactRepository.findAll();
//		return ResponseEntity.status(HttpStatus.OK)
//							 .header("status", "products")
//							 .body(pro);
//	}
//	
//	@DeleteMapping("/deletebyid/{id}")
//	public ResponseEntity<?> deleteById(@PathVariable Long id){
//		Optional<ReactEntity> pro = reactRepository.findById(id);
//		if(pro.isPresent()) {
//			reactRepository.deleteById(id);
//			return ResponseEntity.noContent().build();
//		}
//		else {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND)
//					 .header("status", "not")
//					 .body("not found");
//		}
//	}
//	
//	
//	
//	@PutMapping("/editproduct/{id}")
//	public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody ReactEntity newReactEntity){
//		Optional<ReactEntity> optional = reactRepository.findById(id);
//		if(optional.isPresent()) {
//			ReactEntity existingPro = optional.get();
//			existingPro.setName(newReactEntity.getName());
//			existingPro.setQuantity(newReactEntity.getQuantity());
//			existingPro.setPrice(newReactEntity.getPrice());
//			existingPro.setCategory(newReactEntity.getCategory());
//			existingPro.setImage(newReactEntity.getImage());
//			
//			ReactEntity updatedPro = reactRepository.save(existingPro);
//
//			
//			return ResponseEntity.status(HttpStatus.OK)
//								 .header("ststus", "updation done")
//								 .body(updatedPro);
//		}
//		else {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND)
//								 .header("ststus", "not found")
//								 .body("not found");
//		}
//	}
//	
//}
//


package com.raja.react.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.raja.react.entity.ReactEntity;
import com.raja.react.repository.ReactRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class ReactController {
    @Autowired
    ReactRepository reactRepository;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ReactEntity reactEntity) {
        ReactEntity pro = reactRepository.save(reactEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(pro);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ReactEntity>> getAllProducts() {
        List<ReactEntity> pro = reactRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(pro);
    }

    @DeleteMapping("/deletebyid/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        Optional<ReactEntity> pro = reactRepository.findById(id);
        if (pro.isPresent()) {
            reactRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
    }

    @PutMapping("/editproduct/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody ReactEntity newReactEntity) {
        Optional<ReactEntity> optional = reactRepository.findById(id);
        if (optional.isPresent()) {
            ReactEntity existingPro = optional.get();
            existingPro.setName(newReactEntity.getName());
            existingPro.setQuantity(newReactEntity.getQuantity());
            existingPro.setPrice(newReactEntity.getPrice());
            existingPro.setCategory(newReactEntity.getCategory());
            existingPro.setImage(newReactEntity.getImage());

            ReactEntity updatedPro = reactRepository.save(existingPro);
            return ResponseEntity.ok(updatedPro);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
    }
}
