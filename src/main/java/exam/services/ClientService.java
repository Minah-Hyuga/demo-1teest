package exam.services;

import exam.data.entities.Client;
import exam.data.repository.ClientRepository;

public class ClientService {
    private ClientRepository clientRepository;

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
