package com.telran.utils;

import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> registeredNewUserFromCSV() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(DataProviders.class
                .getResourceAsStream("/Data/data_reg.csv")));

        List<Object[]> userData = new ArrayList<Object[]>();
        String line = reader.readLine();

        while (line != null) {
            userData.add(line.split(","));
            line = reader.readLine();
        }
        reader.close();
        return userData.iterator();
    }


    @DataProvider
    public Iterator<Object[]> registeredNewUserWIthInvalidPasswordFromCSV() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(DataProviders.class
                .getResourceAsStream("/Data/Data_negativePassword.csv")));

        List<Object[]> userData = new ArrayList<Object[]>();
        String line = reader.readLine();

        while (line != null) {
            userData.add(line.split(","));
            line = reader.readLine();
        }
        reader.close();
        return userData.iterator();
        }

    }