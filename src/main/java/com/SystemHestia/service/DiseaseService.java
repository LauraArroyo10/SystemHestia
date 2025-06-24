package com.SystemHestia.service;
import com.SystemHestia.model.Disease;
import com.SystemHestia.repository.DiseaseRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DiseaseService {

    @Autowired
    private DiseaseRepositoryJPA repository;


    //GET ALL
    public List<Disease> getAll() {
        return repository.findAll();
    }


    //GET BY ID
    public Disease findById(Integer id) {
        Optional<Disease> disease = repository.findById(id);
        if (disease.isPresent()) {
            return disease.get();
        }
        return null;
    }


    //POST
    public Disease add(Disease disease) {
        return repository.save(disease);
    }

    public Disease edit(Disease disease) {
        Disease element = getDisease(disease.getId());

        if (element != null && element.getId().equals(disease.getId())) {
            if (disease.getName() != null) {
                element.setName(disease.getName());
            }
            if (disease.getDescription() != null) {
                element.setDescription(disease.getDescription());
            }
            if (disease.getRecommendation() != null) {
                element.setRecommendation(disease.getRecommendation());
            }

            return repository.save(element);
        }
        return null;
    }

    //DELETE
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    //PUT
    public Disease dUpdate(Disease disease) {
        return repository.save(disease);
    }


    // VALIDACIONES
    public boolean existByName(String name) {
        return repository.existsByName(name);
    }

    public boolean existsById(Integer id) {
        return repository.existsById(id);
    }

    // BÚSQUEDAS ADICIONALES
    public Disease getByName(String name) {
        return repository.findByName(name);
    }



    public Disease getDisease(Integer id) {
        Optional<Disease> disease = repository.findById(id);
        if (disease.isPresent()) {
            return disease.get();
        }
        return null;
    }

}//class end





