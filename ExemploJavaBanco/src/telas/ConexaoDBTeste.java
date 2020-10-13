
package telas;

import dao.ConexaoDB;
import dao.EstadoDao;
import entidade.Estado;


public class ConexaoDBTeste {

   
    public static void main(String[] args) {
   
//        ConexaoDB conexaoDB = new ConexaoDB();        
//        conexaoDB.getConexaoDB();
    
           Estado estado = new Estado();
           estado.setNome("MINAS GERAIS");
           estado.setSigla("MG");
           
           EstadoDao estadoDao = new EstadoDao();
           estadoDao.insert(estado);
        
    }
    
}
