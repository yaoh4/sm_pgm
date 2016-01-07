package gov.nih.nci.iscs.oracle.pgm.plugins;

import gov.nih.nci.iscs.oracle.common.helper.ApplicationInfo;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.context.ApplicationContextFactory;
import gov.nih.nci.iscs.oracle.pgm.service.impl.ApplicationLinksServiceImpl;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;
import org.springframework.context.ApplicationContext;

/**
 * This class initializes the resources required by the application, incuding
 * data sources and ldap connections.
 * @author Oracle
 */
public class PgmApplicationPlugin implements PlugIn {
    private static Logger logger = LogManager.getLogger(PgmApplicationPlugin.class);
    private static String[] stBaseSearchDN = {"OU=nci,O=nih", "OU=next,O=nih"};
    public PgmApplicationPlugin() {
    }
  /**
   * This method is invoked by the struts framework at application initialization.
   * @param servlet
   * @param config
   * @throws javax.servlet.ServletException
   */
    public void init(ActionServlet servlet, ModuleConfig config)
        throws ServletException {
        ApplicationInfo pgmAi = ApplicationInfo.getInstance(ApplicationConstants.APPLICATION_KEY);


        try {

			  ApplicationContext  contextFactory = ApplicationContextFactory.getApplicationContext();
			  logger.info(" contextFactory is " + contextFactory);
              ServletContext sc = servlet.getServletContext();
			  logger.info(" ServletContext is " + sc);
              sc.setAttribute(ApplicationConstants.PGM_CONTEXT_FACTORY, contextFactory);
			  logger.info(" setting contextFactory ApplicationConstants.PGM_CONTEXT_FACTORY is " + ApplicationConstants.PGM_CONTEXT_FACTORY);
              sc.setAttribute("applicationInfo", pgmAi);

			  logger.info(" setting applicationInfo is " + pgmAi);

            // application links
            ApplicationLinksServiceImpl mApplicationLinksServiceImpl =  new ApplicationLinksServiceImpl(contextFactory);
            Map mApplicationMap  = mApplicationLinksServiceImpl.getApplicationLinks();
            sc.setAttribute(ApplicationConstants.APP_LINK_LIST, mApplicationMap);

        } catch (Exception ex) {
            logger.error(ex);
            throw new ServletException(ex);
        }
    }

    public void destroy() {
        ;

    }
}
