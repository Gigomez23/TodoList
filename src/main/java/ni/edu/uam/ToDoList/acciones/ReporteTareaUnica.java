package ni.edu.uam.ToDoList.acciones;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import ni.edu.uam.ToDoList.modelo.TareaUnica;
import org.openxava.actions.JasperReportBaseAction;
import org.openxava.annotations.Required;
import org.openxava.jpa.XPersistence;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReporteTareaUnica extends JasperReportBaseAction {

    @Override
    protected JRDataSource getDataSource() throws Exception {
        List<TareaUnica> datos = XPersistence.getManager()
                .createQuery("select t from TareaUnica t", TareaUnica.class)
                .getResultList();
        return new JRBeanCollectionDataSource(datos);
    }
    @Override
    protected String getJRXML() throws Exception {
        return "TareaUnica.jrxml";
    }
    @Override
    @SuppressWarnings("rawtypes")
    protected Map getParameters() throws Exception {
        return new HashMap();
    }
}
