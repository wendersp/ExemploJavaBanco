
package visao.tableModel;

import modelo.entidade.Estado;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.entidade.Banco;

/**
 *
 * @author wender
 */
public class BancoTableModel extends AbstractTableModel {

    private List<Banco> listaBanco;
    
    private String[] colunas = new String[]{
        "Id", "Numero", "Nome"};

    /**
     * Creates a new instance of DevmediaTableModel
     *
     * @param listaBanco 
     */
    public BancoTableModel(List<Banco> listaBanco) {
        this.listaBanco = listaBanco;
    }

    public BancoTableModel() {
        this.listaBanco = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return listaBanco.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    public void setValueAt(Banco aValue, int rowIndex) {
        Banco banco = listaBanco.get(rowIndex);

        banco.setId(aValue.getId());
        banco.setNumero(aValue.getNumero());
        banco.setNome(aValue.getNome());
        

        fireTableCellUpdated(rowIndex, 0);
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);
        
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Banco banco = listaBanco.get(rowIndex);

        switch (columnIndex) {
            case 0:
                banco.setId(Long.parseLong(aValue.toString()));
            case 1:
                banco.setNumero(Integer.parseInt(aValue.toString()));
            case 2:
                banco.setNome(aValue.toString());            
            default:
                System.err.println("Índice da coluna inválido");
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Banco bancoSelecionado = listaBanco.get(rowIndex);
        String valueObject = null;
        switch (columnIndex) {
            case 0:
                if (bancoSelecionado.getId() != null) {
                    valueObject = String.valueOf(bancoSelecionado.getId());
                } else {
                    valueObject = "";
                }
                break;
            case 1:
                valueObject = String.valueOf(bancoSelecionado.getNumero());
                break;
            case 2:
                valueObject = bancoSelecionado.getNome();
                break;            
            default:
                System.err.println("Índice inválido para propriedade do bean Banco.class");
        }

        return valueObject;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    /**
     *
     * @param indiceLinha
     * @return
     */
    public Banco getBanco(int indiceLinha) {
        return listaBanco.get(indiceLinha);
    }

    public void addBanco(Banco b) {
        listaBanco.add(b);

        int ultimoIndice = getRowCount() - 1;

        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void removeBanco(int indiceLinha) {
        listaBanco.remove(indiceLinha);

        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    public void addListaDeBanco(List<Banco> novosBancos) {
        limpar();
        int tamanhoAntigo = getRowCount();
        listaBanco.addAll(novosBancos);
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }

    public void limpar() {
        listaBanco.clear();
        fireTableDataChanged();
    }

    public boolean isEmpty() {
        return listaBanco.isEmpty();
    }

}
