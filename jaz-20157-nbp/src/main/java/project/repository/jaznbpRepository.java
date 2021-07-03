package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.model.jaznbp;

@Repository
public interface jaznbpRepository extends JpaRepository<jaznbp, Long> {

}
