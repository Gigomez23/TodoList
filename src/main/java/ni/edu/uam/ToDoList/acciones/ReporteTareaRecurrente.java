package ni.edu.uam.ToDoList.acciones;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import ni.edu.uam.ToDoList.modelo.TareaRecurrente;
import org.openxava.actions.JasperReportBaseAction;
import org.openxava.jpa.XPersistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReporteTareaRecurrente extends JasperReportBaseAction {
    @Override
    protected JRDataSource getDataSource() throws Exception {
        List<TareaRecurrente> datos = XPersistence.getManager()
                .createQuery("select t from TareaRecurrente t", TareaRecurrente.class)
                .getResultList();
        System.out.println("Datos cargados: " + datos.size());  // Log para verificar
        for (TareaRecurrente t : datos) {
            System.out.println("Estado: " + t.getEstado());  // Verifica que no sea null
        }
        return new JRBeanCollectionDataSource(datos);
    }


    @Override
    protected String getJRXML() throws Exception {
        return "TareaRecurrente.jrxml";
    }
    @Override
    @SuppressWarnings("rawtypes")
    protected Map getParameters() throws Exception {
        return new HashMap();
    }
}
