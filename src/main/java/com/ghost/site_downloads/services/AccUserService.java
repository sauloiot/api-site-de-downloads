package com.ghost.site_downloads.services;

import com.ghost.site_downloads.models.AccUser;
import com.ghost.site_downloads.models.Category;
import com.ghost.site_downloads.repositories.AccUserRepository;
import com.ghost.site_downloads.repositories.CategoryRepository;
import com.ghost.site_downloads.services.exception.DataIntegrityException;
import com.ghost.site_downloads.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccUserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AccUserRepository accUserRepository;

    public AccUser findById(Integer user_id){
        Optional<AccUser> obj = accUserRepository.findById(user_id);
//        obj.ifPresent(accUser -> accUser.setUser_password(bCryptPasswordEncoder.encode(obj.get().getUser_password())));
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                //Pode se usar .getName no lugar de getSimpleName()
                "+-=Custom Error=-+ Object not found! id: " + user_id + ", Type: " + AccUser.class.getSimpleName()
        ));
    }

//    public AccUser findByEmail(String email){
//        Optional<AccUser> obj = Optional.ofNullable(accUserRepository.findByEmail(email));
////        obj.ifPresent(accUser -> accUser.setUser_password(bCryptPasswordEncoder.encode(obj.get().getUser_password())));
//        return null;
//    }

    public AccUser insert(AccUser obj){
        obj.setUser_password(bCryptPasswordEncoder.encode(obj.getUser_password()));
        obj.setUser_id(null);
        return accUserRepository.save(obj);
    }

    public AccUser update(AccUser obj){
        findById(obj.getUser_id());
        return accUserRepository.save(obj);
    }

    public void deleteById(Integer user_id){
        findById(user_id);
        try {
            accUserRepository.deleteById(user_id);
        }catch (DataIntegrityViolationException exception){
            throw new DataIntegrityException("+-=Custom Error=-+ Not is possible delete category with sub-categories");
        }
    }

    public List<AccUser> findAll(){
        return accUserRepository.findAll();
    }

}
