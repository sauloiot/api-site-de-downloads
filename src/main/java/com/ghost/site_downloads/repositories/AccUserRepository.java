package com.ghost.site_downloads.repositories;

import com.ghost.site_downloads.models.AccUser;
import com.ghost.site_downloads.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AccUserRepository extends JpaRepository<AccUser, Integer> {
    @Transactional(readOnly = true)
    AccUser findByEmail(String email);
//    @Query("select u from AccUser u where u.email = ?1")
//    AccUser findByEmaill(String email);
}
