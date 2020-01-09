package br.uem.easyhelp.view.converter;

import br.uem.easyhelp.metadata.entity.Developer;
import java.io.Serializable;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Douglas
 */
@FacesConverter("empresaConverter")
public class EmpresaConverter implements Converter, Serializable {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s != null) {
            return this.getAttributesFrom(uiComponent).get(s);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o != null && !"".equals(o)) {
            Developer entity = (Developer) o;

            this.addAttribute(uiComponent, entity);

            String id = Integer.toString(entity.getId());
            if (id != null) {
                return id;
            }
        }

        return (String) o;

    }

    protected void addAttribute(UIComponent component, Developer o) {
        String key = Integer.toString(o.getId());
        this.getAttributesFrom(component).put(key, o);
    }

    protected Map<String, Object> getAttributesFrom(UIComponent component) {
        return component.getAttributes();
    }
}