
package visao.tableModel;

import modelo.entidade.Cidade;
import modelo.entidade.Estado;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author wender
 */
public class CidadeTableModel extends AbstractTableModel {

    private List<Cidade> listaCidade;
    
    private String[] colunas = new String[]{
        "Id", "Nome", "Estado"};

    /**
     * Creates a new instance of DevmediaTableModel
     *
     * @param listaCidade
     */
    public CidadeTableModel(List<Cidade> listaCidade) {
        this.listaCidade = listaCidade;
    }

    public CidadeTableModel() {
        this.listaCidade = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return listaCidade.size();
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

    public void setValueAt(Cidade aValue, int rowIndex) {
        Cidade cidade = listaCidade.get(rowIndex);

        cidade.setId(aValue.getId());
        cidade.setNome(aValue.getNome());
        cidade.setEstado(aValue.getEstado());
        
        fireTableCellUpdated(rowIndex, 0);
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);
        
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Cidade cidade = listaCidade.get(rowIndex);

        switch (columnIndex) {
            case 0:
                cidade.setId(Long.parseLong(aValue.toString()));
            case 1:
                cidade.setNome(aValue.toString());
            case 2:
                //cidade.setEstado(aValue.toString());            
            default:
                System.err.println("Índice da coluna inválido");
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cidade cidadeSelecionado = listaCidade.get(rowIndex);
        String valueObject = null;
        switch (columnIndex) {
            case 0:
                if (cidadeSelecionado.getId() != null) {
                    valueObject = String.valueOf(cidadeSelecionado.getId());
                } else {
                    valueObject = "";
                }
                break;
            case 1:
                valueObject = cidadeSelecionado.getNome();
                break;
            case 2:
                valueObject = cidadeSelecionado.getEstado().getNome();
                break;            
            default:
                System.err.println("Índice inválido para propriedade do bean Estado.class");
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
    public Cidade getCidade(int indiceLinha) {
        return listaCidade.get(indiceLinha);
    }

    public void addCidade(Cidade c) {
        listaCidade.add(c);

        int ultimoIndice = getRowCount() - 1;

        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void removeCidade(int indiceLinha) {
        listaCidade.remove(indiceLinha);

        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    public void addListaDeCidade(List<Cidade> novasCidades) {
        limpar();
        int tamanhoAntigo = getRowCount();
        listaCidade.addAll(novasCidades);
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }

    public void limpar() {
        listaCidade.clear();
        fireTableDataChanged();
    }

    public boolean isEmpty() {
        return listaCidade.isEmpty();
    }

}
