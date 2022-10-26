package br.com.residencia.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.ecommerce.dto.ClienteResumoDTO;
import br.com.residencia.ecommerce.entity.Cliente;
import br.com.residencia.ecommerce.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	UniversalService utilService;

	
	public List<ClienteResumoDTO> getAllDTO() {
		List<ClienteResumoDTO> listaObjDTO = new ArrayList<>();
		List<Cliente> listaObj = clienteRepository.findAll();
		for (Cliente obj : listaObj) {
			ClienteResumoDTO objDTO = new ClienteResumoDTO();
			objDTO = utilService.toClienteDTO(obj);
			listaObjDTO.add(objDTO);
		}
		return listaObjDTO;
	}

	public ClienteResumoDTO getByIdDTO(Integer id) {
		Cliente obj = clienteRepository.findById(id).orElse(null);
		return utilService.toClienteDTO(obj);
	}

	public ClienteResumoDTO saveDTO(Cliente obj) {
		Cliente objFinal = new Cliente();
		if (obj != null) {
			// Enviar o pedido recebido para ser preenchido corretamente
			// ValorTotal = 0 / List = lista / idPedido = null
			Cliente objNovo = utilService.saveCliente(obj);

			// Salvando o pedido no sistema e obtendo o ID dele
			// ValorTotal = valor / List = null / idPedido = id
			objFinal = clienteRepository.save(objNovo);

		}
		return utilService.toClienteDTO(objFinal);
	}

	public ClienteResumoDTO updateDTO(Cliente obj, Integer id) {
		Cliente objAtualizado = utilService.updateCliente(obj, id);
		Cliente objFinal = clienteRepository.save(objAtualizado);
		return utilService.toClienteDTO(objFinal);
	}

	public Boolean deleteDTO(Integer id) {
		Cliente obj = clienteRepository.findById(id).orElse(null);

		// Verifica se o ID passado e valido
		if (obj != null) {
			// Deleta o dado
			clienteRepository.deleteById(id);
			// Tenta pegar o objeto no banco
			Cliente objTeste = clienteRepository.findById(id).orElse(null);
			// Verificacao se o objeto foi deletado
			if (objTeste == null) {
				// Se foi deletado retorna verdadeiro
				return true;
			} else {
				// Se nao foi deletado retorna falso
				return false;
			}
		} else {
			// Retorna falso se o objeto nao existir/Erro de ID
			return false;
		}
	}

	// --------------

}
