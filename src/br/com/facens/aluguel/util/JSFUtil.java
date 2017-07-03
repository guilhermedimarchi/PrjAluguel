package br.com.facens.aluguel.util;

import java.util.Locale;
import java.util.ResourceBundle;



import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public abstract class JSFUtil {
	
	
	public static String getMsg(String id) 
	{    
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getViewRoot().setLocale(new Locale("pt","BR"));
        String msg = "";    
        Locale locale = facesContext.getViewRoot().getLocale();    
        ResourceBundle bundle = ResourceBundle.getBundle("application", locale);    
        try {    
            msg = bundle.getString(id);    
        } catch (Exception e) {    
        }    
        return msg;    
    }
	
	public static void addMessage(String idTitulo, String idMensagem) {
		
		
		String titulo   = getMsg(idTitulo);
		String mensagem = getMsg(idMensagem);
		
		System.out.println(titulo);
		System.out.println(mensagem);
		
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(titulo,mensagem));
		
	}
	
	
}
