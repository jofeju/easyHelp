package br.uem.easyhelp.view.converter;

import br.uem.easyhelp.metadata.entity.Jogo;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.io.Serializable;
import java.util.Map;

/**
 * @author Douglas
 */
@FacesConverter("jogoConverter")
public class JogoConverter implements Converter, Serializable {
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
            Jogo entity = (Jogo) o;

            this.addAttribute(uiComponent, entity);

            String id = entity.getId();
            if (id != null) {
                return id;
            }
        }

        return (String) o;

    }

    protected void addAttribute(UIComponent component, Jogo o) {
        String key = o.getId();
        this.getAttributesFrom(component).put(key, o);
    }

    protected Map<String, Object> getAttributesFrom(UIComponent component) {
        return component.getAttributes();
    }
}
