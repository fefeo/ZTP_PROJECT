//package com.example.ZTP_PROJ6.security;
//
//
//
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//public class MyAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
//
//    private Log log = LogFactory.getLog(MyAuthenticationSuccessHandler.class);
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//                                        Authentication authentication)
//            throws IOException, ServletException {
//        // This is actually not an error, but an OK message. It is sent to avoid redirects.
//        response.sendError(HttpServletResponse.SC_OK);
//    }
//}