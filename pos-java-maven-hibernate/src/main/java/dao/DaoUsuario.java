package dao;

import java.util.List;

import javax.persistence.Query;

import model.UsuarioPessoa;
/*Removendo em cascata com SQL*/
/*Metodo de deletar usuario que tenha telefone salvo no banco de dados, onde o telefone do usuario tbm serao deletados*/

public class DaoUsuario<E> extends DaoGeneric<UsuarioPessoa> {

	public void removerUsuario(UsuarioPessoa pessoa) throws Exception {
		getEntityManager().getTransaction().begin();

		getEntityManager().remove(pessoa);

		getEntityManager().getTransaction().commit();

	}

	public List<UsuarioPessoa> pesquisar(String campoPesquisa) {
		Query query = super.getEntityManager()
				.createQuery("from UsuarioPessoa where nome like '%" + campoPesquisa + "%'");
		return query.getResultList();
	}
}
