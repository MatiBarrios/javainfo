package com.proyecto1;

import com.proyecto1.service.menu.impl.MenuServiceImpl;

public class App 
{
    public static void main( String[] args )
    {

        MenuServiceImpl menu = new MenuServiceImpl();
        menu.menu();

    }
}