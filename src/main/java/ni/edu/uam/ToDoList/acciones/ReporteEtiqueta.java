package ni.edu.uam.ToDoList.acciones;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import ni.edu.uam.ToDoList.modelo.Etiqueta;
import org.openxava.actions.JasperReportBaseAction;
import org.openxava.jpa.XPersistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReporteEtiqueta extends JasperReportBaseAction {

    @Override
    protected JRDataSource getDataSource() throws Exception {
        List<Etiqueta> datos = XPersistence.getManager()
                .createQuery("select e from Etiqueta e", Etiqueta.class)
                .getResultList();
        return new JRBeanCollectionDataSource(datos);
    }
    @Override
    protected String getJRXML() throws Exception {
        return "Etiqueta.jrxml";
    }
    @Override
    @SuppressWarnings("rawtypes")
    protected Map getParameters() throws Exception {
        return new HashMap();
    }
}
