
package visao.tableModel;

import java.awt.FontMetrics;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

public class EstadoColumnModel extends DefaultTableColumnModel {
 
    public EstadoColumnModel(FontMetrics fm) {
        addColumn(criaColuna(0, 80, fm, false, "Código"));
        addColumn(criaColuna(1, 200, fm, true, "Nome"));
        addColumn(criaColuna(2, 80, fm, false, "Sigla"));                       
    }

    private TableColumn criaColuna(int columnIndex, int largura, FontMetrics fm, boolean resizable, String titulo) {
        int larguraTitulo = fm.stringWidth(titulo + "  ");
        if (largura < larguraTitulo) {
            largura = larguraTitulo;
        }

        TableColumn col = new TableColumn(columnIndex);
        col.setCellRenderer(new EstadoCellRenderer());
        col.setHeaderRenderer(null);
        col.setHeaderValue(titulo);
        col.setPreferredWidth(largura);       
        if (!resizable) {
            col.setMaxWidth(largura);
            col.setMinWidth(largura);
        }
        col.setResizable(resizable);
        return col;
    }
}