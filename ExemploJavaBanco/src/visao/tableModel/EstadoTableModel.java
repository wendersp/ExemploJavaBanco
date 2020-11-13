package visao.tableModel;

import modelo.entidade.Estado;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import uteis.Uteis;

/**
 *
 * @author wender
 */
public class EstadoTableModel extends AbstractTableModel {

    private List<Estado> listaEstado;

    private String[] colunas = new String[]{"Id", "Nome", "Sigla", "Data"};

    /**
     * Creates a new instance of DevmediaTableModel
     *
     * @param listaEstado
     */
    public EstadoTableModel(List<Estado> listaEstado) {
        this.listaEstado = listaEstado;
    }

    public EstadoTableModel() {
        this.listaEstado = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return listaEstado.size();
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

    public void setValueAt(Estado aValue, int rowIndex) {
        Estado estado = listaEstado.get(rowIndex);

        estado.setId(aValue.getId());
        estado.setNome(aValue.getNome());
        estado.setSigla(aValue.getSigla());
        estado.setData(aValue.getData());

        fireTableCellUpdated(rowIndex, 0);
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);
        fireTableCellUpdated(rowIndex, 3);

    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Estado estado = listaEstado.get(rowIndex);

        switch (columnIndex) {
            case 0:
                estado.setId(Integer.parseInt(aValue.toString()));
                break;
            case 1:
                estado.setNome(aValue.toString());
                break;
            case 2:
                estado.setSigla(aValue.toString());
                break;
            case 3:
                estado.setData(Uteis.parseDate(aValue.toString()));
                break;
            default:
                System.err.println("Índice da coluna inválido");
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Estado estadoSelecionado = listaEstado.get(rowIndex);
        String valueObject = null;        
        switch (columnIndex) {
            case 0:
                if (estadoSelecionado.getId() != null) {
                    valueObject = String.valueOf(estadoSelecionado.getId());
                } else {
                    valueObject = "";
                }
                break;
            case 1:
                valueObject = estadoSelecionado.getNome();
                break;
            case 2:
                valueObject = estadoSelecionado.getSigla();
                break;
            case 3:
                valueObject = Uteis.parseDate(estadoSelecionado.getData());
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
    public Estado getEstado(int indiceLinha) {
        return listaEstado.get(indiceLinha);
    }

    public void addEstado(Estado p) {
        listaEstado.add(p);

        int ultimoIndice = getRowCount() - 1;

        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void removeEstado(int indiceLinha) {
        listaEstado.remove(indiceLinha);

        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    public void addListaDeEstado(List<Estado> novosEstadoes) {
        limpar();
        int tamanhoAntigo = getRowCount();
        listaEstado.addAll(novosEstadoes);
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }

    public void limpar() {
        listaEstado.clear();
        fireTableDataChanged();
    }

    public boolean isEmpty() {
        return listaEstado.isEmpty();
    }

}
