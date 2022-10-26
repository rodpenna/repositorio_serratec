package br.com.residencia.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.ecommerce.dto.PedidoResumoDTO;
import br.com.residencia.ecommerce.entity.ItemPedido;
import br.com.residencia.ecommerce.entity.Pedido;
import br.com.residencia.ecommerce.repository.ItemPedidoRepository;
import br.com.residencia.ecommerce.repository.PedidoRepository;

@Service
public class PedidoService {
	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	ItemPedidoRepository itemPedidoRepository;

	@Autowired
	UniversalService utilService;

	@Autowired
	EmailService emailService;

	public List<PedidoResumoDTO> getAllDTO() {
		List<PedidoResumoDTO> listaObjDTO = new ArrayList<>();
		listaObjDTO = utilService.getAllPedidoDTO();
		return listaObjDTO;
	}

	public PedidoResumoDTO getByIdDTO(Integer id) {
		Pedido obj = pedidoRepository.findById(id).orElse(null);
		return utilService.toPedidoDTO(obj);
	}

	public PedidoResumoDTO saveDTO(Pedido obj) {
		Pedido objFinal = new Pedido();
		if (obj != null) {
			// Enviar o pedido recebido para ser preenchido corretamente
			// ValorTotal = 0 / List = lista / idPedido = null
			Pedido objNovo = utilService.savePedido(obj);

			// Salvando o pedido no sistema e obtendo o ID dele
			// ValorTotal = valor / List = null / idPedido = id
			Pedido objSalvo = pedidoRepository.save(objNovo);

			// Enviando o objeto novamente para ser preenchido a sua List ItemPedido
			// Pegando a lista passada por parametro novamente
			// ValorTotal = valor / List = lista / idPedido = id
			objSalvo.setItemPedido(obj.getItemPedido());
			objSalvo.setCliente(obj.getCliente());
			Pedido objCorrigido = utilService.savePedido(objSalvo);

			// Atualizando o pedido dentro do sistema
			objFinal = pedidoRepository.save(objCorrigido);
		}
		//MANDAR EMAIL!!L!L!!!!!L!
		utilService.mandarEmail(objFinal);
	
		return utilService.toPedidoDTO(objFinal);
	}

	public PedidoResumoDTO updateDTO(Pedido obj, Integer id) {
		Pedido objAtualizado = utilService.updatePedido(obj, id);

		return utilService.toPedidoDTO(objAtualizado);
	}

	public Boolean deleteDTO(Integer id) {
		Pedido obj = pedidoRepository.findById(id).orElse(null);

		// Verifica se o ID passado e valido
		if (obj != null) {
			List<ItemPedido> listaItem = obj.getItemPedido();
			for (ItemPedido item : listaItem) {
				itemPedidoRepository.delete(item);
			}

			// Deleta o dado
			pedidoRepository.deleteById(id);
			// Tenta pegar o objeto no banco
			Pedido objTeste = pedidoRepository.findById(id).orElse(null);
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

	public Boolean deleteItem(Pedido obj, Integer id) {
		Boolean deletado = false;
		Pedido pedido = pedidoRepository.findById(obj.getIdPedido()).orElse(null);
		List<ItemPedido> listaItem = pedido.getItemPedido();

		for (ItemPedido item : listaItem) {
			if (item.getIdItemPedido() == id) {
				itemPedidoRepository.delete(item);
				deletado = true;
			}
		}
		return deletado;
	}

}
