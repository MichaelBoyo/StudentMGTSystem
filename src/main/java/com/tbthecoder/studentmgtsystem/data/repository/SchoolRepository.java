package com.tbthecoder.studentmgtsystem.data.repository;

import com.tbthecoder.studentmgtsystem.data.models.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {

}
