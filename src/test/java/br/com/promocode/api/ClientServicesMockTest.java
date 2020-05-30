package br.com.promocode.api;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.com.promocode.api.repository.ClientRepository;
import br.com.promocode.api.controller.ClientController;
import br.com.promocode.api.entity.Client;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PromocodeApplication.class)
public class ClientServicesMockTest {

	@MockBean
	ClientRepository clientRepositoryMock;

	@Autowired
	ClientController clientController;
	Client client = new Client();
	List<Client> clients;

	// teste OK porém comparando objetos
	// temos que montar nossa estratégia
	@Test
	public void testFindAll() {
		System.out.println("chegou");
		client = new Client();
		client.setClientId(1000);
		client.setAddress("rua de teste");;
		client.setCnpj("99999999/9999-99");
		client.setEmail("teste@teste.com");
		client.setMobile("99999-9999");
		client.setName("Teste Teste");
		client.setRegisterDate(new Date());
		List<Client> c = new ArrayList<Client>();
		c.add(client);
		// clients.add(client);
		Mockito.when(clientRepositoryMock.findAll()).thenReturn(c);
		assertEquals(c, clientController.Get());
	}

	// implementar testes NOK
	@Test
	public void testFindAll2() {
		System.out.println("chegou");
		client = new Client();
		client.setClientId(1000);
		client.setAddress("rua de teste");;
		client.setCnpj("99999999/9999-99");
		client.setEmail("teste@teste.com");
		client.setMobile("99999-9999");
		client.setName("Teste Teste");
		client.setRegisterDate(new Date());
		List<Client> c = new ArrayList<Client>();
		c.add(client);
		// clients.add(client);
		Mockito.when(clientRepositoryMock.findAll()).thenReturn(c);
		assertEquals("a", "b");
	}

	
	
}