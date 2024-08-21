package com.sf.cm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CertificateService {
	@Autowired
	private CertificateRepository repository;
	
	public List<Certificate> listAll(){
		return repository.findAll();
	}
	
	public Certificate searchCertificateById(Integer id) {
		return repository.findById(id).get();
	} 
	
	public void addCertificate(Certificate certificate) {
		repository.save(certificate);
	}
	
	public void deleteCertificate(Integer id) {
		repository.deleteById(id);
	}
}
