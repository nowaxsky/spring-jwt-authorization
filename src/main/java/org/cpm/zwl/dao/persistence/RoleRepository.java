package org.cpm.zwl.dao.persistence;

import java.util.Optional;
import org.cpm.zwl.dao.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

  Optional<Role> findByRoleId(String roleId);
}
