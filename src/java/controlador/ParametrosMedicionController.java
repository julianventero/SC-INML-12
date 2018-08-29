package controlador;

import modelo.ParametrosMedicion;
import controlador.util.JsfUtil;
import controlador.util.JsfUtil.PersistAction;
import fachada.ParametrosMedicionFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("parametrosMedicionController")
@SessionScoped
public class ParametrosMedicionController implements Serializable {

    @EJB
    private fachada.ParametrosMedicionFacade ejbFacade;
    private List<ParametrosMedicion> items = null;
    private ParametrosMedicion selected;

    public ParametrosMedicionController() {
    }

    public ParametrosMedicion getSelected() {
        return selected;
    }

    public void setSelected(ParametrosMedicion selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ParametrosMedicionFacade getFacade() {
        return ejbFacade;
    }

    public ParametrosMedicion prepareCreate() {
        selected = new ParametrosMedicion();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("Created"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("Updated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("Deleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ParametrosMedicion> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public ParametrosMedicion getParametrosMedicion(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<ParametrosMedicion> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ParametrosMedicion> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ParametrosMedicion.class)
    public static class ParametrosMedicionControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ParametrosMedicionController controller = (ParametrosMedicionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "parametrosMedicionController");
            return controller.getParametrosMedicion(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof ParametrosMedicion) {
                ParametrosMedicion o = (ParametrosMedicion) object;
                return getStringKey(o.getIdPARAMETROSMEDICION());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ParametrosMedicion.class.getName()});
                return null;
            }
        }

    }

}
