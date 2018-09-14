package controlador;

import modelo.Preguntas;
import controlador.util.JsfUtil;
import controlador.util.JsfUtil.PersistAction;
import fachada.PreguntasFacade;

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

@Named("preguntasController")
@SessionScoped
public class PreguntasController implements Serializable {

    @EJB
    private fachada.PreguntasFacade ejbFacade;
    private List<Preguntas> items = null;
    private Preguntas selected;
    
    
    
    @EJB
    private fachada.PreguntasFacade ejbFacadePreguntas;
    private List<Preguntas> ItemsPreguntas;
    private Preguntas selectedPreguntas;
    
    public PreguntasController() {
        
    }

    public Preguntas getSelected() {
        return selected;
    }

    public void setSelected(Preguntas selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private PreguntasFacade getFacade() {
        return ejbFacade;
    }

    public Preguntas prepareCreate() {
        selected = new Preguntas();
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

    public List<Preguntas> getItems() {
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

    public Preguntas getPreguntas(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Preguntas> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Preguntas> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Preguntas.class)
    public static class PreguntasControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PreguntasController controller = (PreguntasController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "preguntasController");
            return controller.getPreguntas(getKey(value));
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
            if (object instanceof Preguntas) {
                Preguntas o = (Preguntas) object;
                return getStringKey(o.getIdPREGUNTAS());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Preguntas.class.getName()});
                return null;
            }
        }

    }

    public fachada.PreguntasFacade getEjbFacadePreguntas() {
        return ejbFacadePreguntas;
    }

    public List<Preguntas> getItemsPreguntas() {
        if (ItemsPreguntas == null) {
            ItemsPreguntas= ejbFacadePreguntas.verPreguntas2(1);
        }
            return ItemsPreguntas;
    }
    
    public Preguntas getSelectedPreguntas() {
        return selectedPreguntas;
    }

    
}
