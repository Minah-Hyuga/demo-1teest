package exam.services;

import exam.data.entities.Client;
import exam.data.repository.ClientRepository;
import jakarta.persistence.EntityManager;

public class ClientService {
    private ClientRepository clientRepository;

    public ClientService(EntityManager em) {
        this.clientRepository = new ClientRepository(em);
    }

    public Client findClientByTelephone(String telephone) {
        return clientRepository.findByTelephone(telephone);
    }

    public void saveClient(Client client) {
        clientRepository.save(client);
    }
}
