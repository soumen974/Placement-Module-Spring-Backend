package com.placementmodule.Placement.Module.repository;

import com.placementmodule.Placement.Module.model.UserAuth;
import org.apache.juli.logging.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthRepository extends JpaRepository<UserAuth, Log> {
}
