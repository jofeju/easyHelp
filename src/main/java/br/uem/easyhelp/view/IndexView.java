package br.uem.easyhelp.view;

import br.uem.easyhelp.metadata.entity.User;
import br.uem.easyhelp.metadata.type.UserType;
import br.uem.easyhelp.util.FacesUtil;
import br.uem.easyhelp.web.session.SessionContext;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class IndexView implements Serializable {
    public User getLoggedUser() {
        return SessionContext.getInstance().getLoggedUser();
    }

    public boolean isLoggedUserAdmin() {
        return SessionContext.getInstance().getLoggedUser().getType() == UserType.ADMIN;
    }

    public String signout() {
        SessionContext.getInstance().invalidateSession();
        return FacesUtil.LOGIN_FACE;
    }
}
