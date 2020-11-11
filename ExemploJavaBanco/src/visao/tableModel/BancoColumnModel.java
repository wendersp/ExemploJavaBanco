
package visao.tableModel;

import java.awt.FontMetrics;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

public class BancoColumnModel extends DefaultTableColumnModel {
 
    public BancoColumnModel(FontMetrics fm) {
        addColumn(criaColuna(0, 80, fm, false, "Código"));
        addColumn(criaColuna(1, 80, fm, false, "Número"));
        addColumn(criaColuna(2, 200, fm, true, "Nome"));                       
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