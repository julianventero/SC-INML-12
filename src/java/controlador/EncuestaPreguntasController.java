package controlador;

import modelo.EncuestaPreguntas;
import controlador.util.JsfUtil;
import controlador.util.JsfUtil.PersistAction;
import fachada.EncuestaPreguntasFacade;

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

@Named("encuestaPreguntasController")
@SessionScoped
public class EncuestaPreguntasController implements Serializable {

    @EJB
    private fachada.EncuestaPreguntasFacade ejbFacade;
    private List<EncuestaPreguntas> items = null;
    private EncuestaPreguntas selected;
    
    public EncuestaPreguntasController() {
    }

    public EncuestaPreguntas getSelected() {
        return selected;
    }

    public void setSelected(EncuestaPreguntas selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private EncuestaPreguntasFacade getFacade() {
        return ejbFacade;
    }

    public EncuestaPreguntas prepareCreate() {
        selected = new EncuestaPreguntas();
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

    public List<EncuestaPreguntas> getItems() {
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

    public EncuestaPreguntas getEncuestaPreguntas(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<EncuestaPreguntas> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<EncuestaPreguntas> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = EncuestaPreguntas.class)
    public static class EncuestaPreguntasControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EncuestaPreguntasController controller = (EncuestaPreguntasController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "encuestaPreguntasController");
            return controller.getEncuestaPreguntas(getKey(value));
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
            if (object instanceof EncuestaPreguntas) {
                EncuestaPreguntas o = (EncuestaPreguntas) object;
                return getStringKey(o.getIdENCUESTAPREGUNTAS());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), EncuestaPreguntas.class.getName()});
                return null;
            }
        }

    }

}
