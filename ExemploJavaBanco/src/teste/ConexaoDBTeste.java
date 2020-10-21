package teste;

import dao.EstadoDao;
import entidade.Estado;
import java.util.List;

public class ConexaoDBTeste {

    public static void main(String[] args) {

//        ConexaoDB conexaoDB = new ConexaoDB();        
//        conexaoDB.getConexaoDB();
        //Estado estado = new Estado();
//           estado.setNome("MINAS GERAIS");
//           estado.setSigla("MG");
        EstadoDao estadoDao = new EstadoDao();
//           estadoDao.insert(estado);

        List<Estado> lstEstados = estadoDao.pesquisar("G");

        for (Estado estado : lstEstados) {
            System.out.println("Id...: " + estado.getId());
            System.out.println("Nome.: " + estado.getNome());
            System.out.println("Sigla: " + estado.getSigla());
        }

    }

}
