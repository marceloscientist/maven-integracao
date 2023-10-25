import dao.ProdutoDAO;
import domain.Produto;

public class Principal {

	public static void main(String[] args) {
			
		ProdutoDAO operacoesProduto = new ProdutoDAO();
		 
		Produto produtoBuscado = operacoesProduto.buscarProduto(8);
		
		System.out.println(produtoBuscado.getNome());
		
	}
}
