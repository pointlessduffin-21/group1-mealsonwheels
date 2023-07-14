package com.merrymeals.mealsonwheels.Security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // Get the authenticated user details from the Authentication object
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        // Set session attributes or perform any other actions
        HttpSession session = request.getSession();
        session.setAttribute("user", userDetails);

        // Redirect the user to the desired page
        response.sendRedirect("/login_success");
    }
}

