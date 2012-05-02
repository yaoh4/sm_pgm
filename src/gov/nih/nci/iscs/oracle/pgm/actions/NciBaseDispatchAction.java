package gov.nih.nci.iscs.oracle.pgm.actions;

import gov.nih.nci.iscs.i2e.oracle.common.userlogin.NciUser;
import gov.nih.nci.iscs.i2e.oracle.common.userlogin.NciUserImpl;
import javax.servlet.http.*;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.actions.LookupDispatchAction;

import sun.misc.BASE64Decoder;

public abstract class NciBaseDispatchAction extends LookupDispatchAction  {

    public NciBaseDispatchAction()
    {}

    public boolean verifyUser(HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        boolean returnValue = false;
        HttpSession session = request.getSession(true);
        NciUser nu = (NciUser)session.getAttribute("nciuser");
        if(nu != null && nu.isValid())
        {
            returnValue = verifyUserForApp(request, response);
        } else
        {
            // get the User header from Site Minder
             String remoteUser = request.getHeader("SM_USER");
            // when deployed locally and authenticated from apache,
            // check the user from remote user  
             if (remoteUser== null){
                 remoteUser = request.getRemoteUser();
             }
            if (remoteUser == null) {
                String authUser = request.getHeader("Authorization");
                
                if (StringUtils.isNotEmpty(authUser)) {
                        BASE64Decoder decoder = new BASE64Decoder();

                        authUser = new String(decoder.decodeBuffer(authUser.substring(6)));
                        remoteUser = authUser.substring(0, authUser.indexOf(":"));
               }

            }
            if(remoteUser != null && !remoteUser.equals(""))
            {
                NciUserImpl nui = new NciUserImpl();
                StringBuffer ru = new StringBuffer(50);
                if(remoteUser.indexOf("cn=") >= 0)
                {
                    int cnIdx = remoteUser.indexOf("cn=");
                    for(int i = cnIdx + 3; i < remoteUser.length() && remoteUser.charAt(i) != ','; i++)
                        ru.append(remoteUser.charAt(i));

                } else
                {
                    ru.append(remoteUser);
                }
                nui.setUserId(ru.toString());
                setUserAttributes(nui, request);
                session.setAttribute("nciuser", nui);
                returnValue = verifyUserForApp(request, response);
            }
        }
        return returnValue;
    }

    public abstract boolean verifyUserForApp(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws Exception;

    public abstract void setUserAttributes(NciUser nciuser, HttpServletRequest httpservletrequest)
        throws Exception;

    public static String USER_LOGIN_FAILURE = "UserLoginFailure";

}