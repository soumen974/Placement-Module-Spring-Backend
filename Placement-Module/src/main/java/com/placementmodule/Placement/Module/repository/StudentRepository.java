package com.placementmodule.Placement.Module.repository;

import com.placementmodule.Placement.Module.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
