package controlador;

import modelo.Muestra;
import controlador.util.JsfUtil;
import controlador.util.JsfUtil.PersistAction;
import fachada.EncuestaFacade;
import fachada.MuestraFacade;

import java.io.Serializable;
import java.util.Date;
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
import modelo.Cliente;
import modelo.Encuesta;
import modelo.EncuestaPreguntas;
import modelo.ParametrosMedicion;
import modelo.PreguntasParametrosMedicion;
import modelo.Respuesta;
import modelo.Seccional;
import modelo.ServicioForense;

@Named("muestraController")
@SessionScoped
public class MuestraController implements Serializable {

    
    

    
    @EJB
    private fachada.MuestraFacade ejbFacade;
    @EJB //EJB para mandar los datos al facade de Respuesta y ser guardados
    private fachada.RespuestaFacade ejbRespuestaFacade;
    @EJB//EJB para tarer el nombre de la encuesta de acuerdo al servico forense seleccionado
    private fachada.EncuestaFacade ejbFacadeEncuesta;
    private List<Muestra> items = null;
    private Muestra selected;
    private ServicioForense servicio;
    private List<Encuesta> encuestas;
    private String idPregunta;
    //Atributo para traer el id Encuesta_Preguntas de cada pregunta que seleccionen y guardarlo en Respuestas
    private List<EncuestaPreguntas> ItemsidEncuestaPreguntas;
    
    public List<EncuestaPreguntas> getItemsidEncuestaPreguntas() {
        try{
        ItemsidEncuestaPreguntas=ejbFacadeEncuestaPreguntas.traerIdEncuestaPreguntas(selected.getENCUESTAidENCUESTA().getIdENCUESTA(), idPregunta);
        System.out.println(""+ItemsidEncuestaPreguntas);
        }
        catch(Exception e){
        }
        return ItemsidEncuestaPreguntas;
    }
    
    
    //Atributos para almacenar los datos del modelo respuesta(Fecha realizacion encuesta,Cliente,Seccional) y se guarden
    private Cliente idcliente;
    private Date fecharealizacion;
    private Seccional idseccional;
    private ParametrosMedicion parametromedicion;//este atributo guarda el parametro de medición que seleccionen
    //Atributo de tipo respuesta, para poder almacenar los datos del modelo respuesta (Fecha realizacion encuesta,Cliente,Seccional)
    private Respuesta selectedr;

    //EJB PARA TRAERME LAS PREGUNTAS RESPECTO A LA ENCUESTA QUE SELECCIONEN
    @EJB
    private fachada.EncuestaPreguntasFacade ejbFacadeEncuestaPreguntas;
    private List<EncuestaPreguntas> ItemsEncuestaPreguntas;
    private EncuestaPreguntas selectedEncuestaPreguntas;
    //EJB PARA TRAER LOS PARAMETROS DE MEDICION RESPECTO A LAS PREGUNTAS
    @EJB
    private fachada.ParametrosMedicionFacade ejbFacadeParametrosMedicionFacade;
    private List<ParametrosMedicion> ItemsParametrosMedicion;
    private ParametrosMedicion selectedParametrosMedicion;

    //METODOS DEL EJB PARA TRAERME LAS PREGUNTAS RESPECTO A LA ENCUESTA QUE SELECCIONEN
    public fachada.EncuestaPreguntasFacade getEjbFacadeEncuestaPreguntas() {
        return ejbFacadeEncuestaPreguntas;
    }

    public List<EncuestaPreguntas> getItemsEncuestaPreguntas() {
        if (ItemsEncuestaPreguntas == null) {
            try{
            ItemsEncuestaPreguntas = ejbFacadeEncuestaPreguntas.verPreguntas(selected.getENCUESTAidENCUESTA().getIdENCUESTA());
            }
            catch (Exception e) {

        }
        }
        return ItemsEncuestaPreguntas;
    }
    
    public EncuestaPreguntas getSelectedEncuestaPreguntas() {
        return selectedEncuestaPreguntas;
    }
    //METODOS DEL EJB PARA TRAER LOS PARAMETROS DE MEDICION RESPECTO A LA PREGUNTA QUE SELECCIONEN
    public fachada.ParametrosMedicionFacade getEjbFacadeParametrosMedicionFacade() {
        return ejbFacadeParametrosMedicionFacade;
    }

    public Cliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Cliente idcliente) {
        this.idcliente = idcliente;
    }

    public Date getFecharealizacion() {
        return fecharealizacion;
    }

    public void setFecharealizacion(Date fecharealizacion) {
        this.fecharealizacion = fecharealizacion;
    }

    public Seccional getIdseccional() {
        return idseccional;
    }

    public void setIdseccional(Seccional idseccional) {
        this.idseccional = idseccional;
    }
    
    public String getIdPregunta() {
        return idPregunta;
    }
    
    public ParametrosMedicion getParametromedicion() {
        return parametromedicion;
    }

    public void setParametromedicion(ParametrosMedicion parametromedicion) {
        this.parametromedicion = parametromedicion;
    }
    
    public Respuesta getSelectedr() {
        return selectedr;
    }
    public void setSelectedr(Respuesta selectedr) {
        try{
            this.selectedr = selectedr;
        }
        catch(Exception e){
        }
    }
    
    public void setIdPregunta(String idPregunta) {
        this.idPregunta = idPregunta;
        getItemsParametrosMedicion();
    }

    public List<ParametrosMedicion> getItemsParametrosMedicion() {

        try {
            ItemsParametrosMedicion = ejbFacadeParametrosMedicionFacade.parametrosXpregunta(idPregunta);
        } catch (Exception e) {

        }

        return ItemsParametrosMedicion;
    }

    public ParametrosMedicion getSelectedParametrosMedicion() {
        return selectedParametrosMedicion;
    }

    public MuestraController() {
    }

    public Muestra getSelected() {
        return selected;
    }

    public void setSelected(Muestra selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private MuestraFacade getFacade() {
        return ejbFacade;
    }

    public EncuestaFacade getEjbFacadeEncuesta() {
        return ejbFacadeEncuesta;
    }

    public Muestra prepareCreate() {
        selected = new Muestra();
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

    public List<Muestra> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    public List<Encuesta> getEncuestas() {
        if (servicio != null) {
            encuestas = ejbFacadeEncuesta.buscarXServicio(servicio.getIdSERVICIOFORENSE().toString());
        }
        return encuestas;
    }

    public void setEncuestas(List<Encuesta> encuestas) {
        this.encuestas = encuestas;
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

    public Muestra getMuestra(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Muestra> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Muestra> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    public ServicioForense getServicio() {
        return servicio;
    }

    public void setServicio(ServicioForense servicio) {
        this.servicio = servicio;
    }

    @FacesConverter(forClass = Muestra.class)
    public static class MuestraControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            MuestraController controller = (MuestraController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "muestraController");
            return controller.getMuestra(getKey(value));
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
            if (object instanceof Muestra) {
                Muestra o = (Muestra) object;
                return getStringKey(o.getIdMUESTRA());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Muestra.class.getName()});
                return null;
            }
        }

    }

    public void datosRespuesta(){
        System.out.println(""+fecharealizacion);
        System.out.println(""+idseccional);
        System.out.println(""+idcliente);
    }
    
       
    public void guardarRespuesta() {
        Respuesta a=new Respuesta();
        Cliente w =new Cliente();
        Seccional s = new Seccional();
        EncuestaPreguntas ep = new EncuestaPreguntas();
        ep.setIdENCUESTAPREGUNTAS(1);
        w.setIdCLIENTE(1);
        s.setIdSECCIONAL(1);
       a.setCLIENTEidCLIENTE(idcliente);
       a.setSECCIONALidSECCIONAL(idseccional);
       a.setENCUESTAPREGUNTASidENCUESTAPREGUNTAS(ep);
       a.setPARAMETROSMEDICIONidPARAMETROSMEDICION(parametromedicion);
       a.setFechaRealizacion(fecharealizacion);
       ejbRespuestaFacade.create(a);
    }
}
