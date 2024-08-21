package com.sf.cm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CertificateController {
	@Autowired
	private CertificateService service;
	
	//Retrieval
	@GetMapping("/certificates")
	public List<Certificate> list(){
		return service.listAll();
	}
	
	//Retrieval by Id
	@GetMapping("/certificates/{id}")
	public ResponseEntity <Certificate> searchCertificateById(@PathVariable("id") Integer id){
		try {
			Certificate certificate = service.searchCertificateById(id);
			return new ResponseEntity <Certificate>(certificate, HttpStatus.OK);			
		}
		catch(Exception e) {
			return new ResponseEntity <Certificate>(HttpStatus.NOT_FOUND);
		}
	}
	
	//Create a certificate
	@PostMapping("/certificates")
	public void add(@RequestBody Certificate certificate) {
		service.addCertificate(certificate);
	}
	
	//Update
	@PutMapping("certificates/{id}")
	public ResponseEntity <?> updateCertificate(@RequestBody Certificate certificate, @PathVariable Integer id){
		try {
			Certificate certificateId = service.searchCertificateById(id);
			service.addCertificate(certificate);
			return new ResponseEntity <> (HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity <> (HttpStatus.NOT_FOUND);
		}
	}
	
	//Delete a certificate by Id
	@DeleteMapping("certificates/{id}")
	public void delete(@PathVariable Integer id) {
		service.deleteCertificate(id);
	}
}
