package com.example.hr.service;

import com.example.hr.entity.EmpEntity;
import com.example.hr.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {
    @Autowired
    private EmpRepo empRepo;
    public void addEmp(EmpEntity e){
        empRepo.save(e);
    }
    public List<EmpEntity> getAllEmp(){
        return empRepo.findAll();
    }

    public EmpEntity getEmpById(int id){
        Optional<EmpEntity> e = empRepo.findById(id);
        if(e.isPresent()){
            return  e.get();
        }
        return null;
    }

    public void deleteEmp(int id){
        empRepo.deleteById(id);
    }

}
