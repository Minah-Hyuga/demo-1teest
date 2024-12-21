package exam.services;

import exam.data.entities.Client;
import exam.data.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client findClientByTelephone(String telephone) {
        return clientRepository.findByTelephone(telephone);
    }

    public void saveClient(Client client) {
        clientRepository.save(client);
    }
}
