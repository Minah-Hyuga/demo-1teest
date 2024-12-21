package exam.data.repository;

import exam.data.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByTelephone(String telephone);
}
