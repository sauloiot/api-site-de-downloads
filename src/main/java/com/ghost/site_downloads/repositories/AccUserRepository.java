package com.ghost.site_downloads.repositories;

import com.ghost.site_downloads.models.AccUser;
import com.ghost.site_downloads.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccUserRepository extends JpaRepository<AccUser, Integer> {
}
