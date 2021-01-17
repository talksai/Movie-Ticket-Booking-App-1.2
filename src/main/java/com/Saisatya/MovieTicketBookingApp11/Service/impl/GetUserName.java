package com.Saisatya.MovieTicketBookingApp11.Service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class GetUserName {
    public String getUserName(){
        Authentication princeple= SecurityContextHolder.getContext().getAuthentication();
        String name =princeple.getName();
        return name;
    }
}
