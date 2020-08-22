package com.example.anand.womensecurity;

import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by Anand on 4/20/2018.
 */

public class Mydata {
    public static String signup(String fname,String lname, String email, String pass,String pno)
    {
        final String SERVER_URL = "http://192.168.43.86:80/ws/signup.php"; // The server(Servlet) which will process the request. Note 10.0.2.2 is the localhost IP for emulator
        final String CHAR_SET = "UTF-8"; // Encoding used for the parameters
        OutputStream output = null;
        String response = "";

        try
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = URLEncoder.encode("fname", CHAR_SET) + "=" + URLEncoder.encode(fname, CHAR_SET);
            data += "&" +URLEncoder.encode("lname", CHAR_SET) + "=" + URLEncoder.encode(lname, CHAR_SET);
            data += "&" + URLEncoder.encode("email", CHAR_SET) + "=" + URLEncoder.encode(email, CHAR_SET);
            data += "&" + URLEncoder.encode("pass", CHAR_SET) + "=" + URLEncoder.encode(pass, CHAR_SET);
            data += "&" + URLEncoder.encode("pno", CHAR_SET) + "=" + URLEncoder.encode(pno, CHAR_SET);
            URLConnection connection = new URL(SERVER_URL).openConnection(); // Create a connection to server using URL
            connection.setDoOutput(true); // This means POST method to be used
            connection.setRequestProperty("Accept-Charset", CHAR_SET); //For servers to know what encoding is used for the parameters
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + CHAR_SET);
            output = null;
            output = connection.getOutputStream(); //open a Output stream from the connection for posting data
            output.write(data.getBytes(CHAR_SET)); //Post data
            output.flush();
            output.close();
            InputStream responseStream = connection.getInputStream(); //This is when the request is actually fired
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream,CHAR_SET)); // Connect a BufferReader to the inputStream
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
        }
        catch (UnsupportedEncodingException e)
        {
            response=response+e.getMessage();
            e.printStackTrace();

        }
        catch(IOException io)
        {response=response+io.getMessage();
        }
        finally
        {
            if (output != null) try { output.close(); } catch (IOException ignoreIO) {}
        }


        return response;

    }

    public static String login(String email,String pass)
    {
        final String SERVER_URL = "http://192.168.43.86:80/ws/login.php"; // The server(Servlet) which will process the request. Note 10.0.2.2 is the localhost IP for emulator
        final String CHAR_SET = "UTF-8"; // Encoding used for the parameters
        OutputStream output = null;
        String response = "";
        try
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data="email="+email+"&pass="+pass;
            URL u=new URL(SERVER_URL);
            URLConnection connection = u.openConnection(); // Create a connection to server using URL
            connection.setDoOutput(true); // This means POST method to be used
            output = connection.getOutputStream(); //open a Output stream from the connection for posting data
            output.write(data.getBytes(CHAR_SET)); //Post data
            output.flush();
            output.close();
            InputStream responseStream = connection.getInputStream(); //This is when the request is actually fired
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream,CHAR_SET)); // Connect a BufferReader to the inputStream
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
            output.close();
        }
        catch (Exception e)
        {
//          Toast.makeText(null,e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return response;

    }
    public static String savelatlon(String lat,String lon)
    {
        final String SERVER_URL = "http://192.168.43.86:80/ws/savedangerlocation.php"; // The server(Servlet) which will process the request. Note 10.0.2.2 is the localhost IP for emulator
        final String CHAR_SET = "UTF-8"; // Encoding used for the parameters
        OutputStream output = null;
        String response = "";
        try
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = URLEncoder.encode("latitude", CHAR_SET) + "=" + URLEncoder.encode(lat, CHAR_SET);
            data += "&" +URLEncoder.encode("longtitude", CHAR_SET) + "=" + URLEncoder.encode(lon, CHAR_SET);
            URL u=new URL(SERVER_URL);
            URLConnection connection = u.openConnection(); // Create a connection to server using URL
            connection.setDoOutput(true); // This means POST method to be used
            output = connection.getOutputStream(); //open a Output stream from the connection for posting data
            output.write(data.getBytes(CHAR_SET)); //Post data
            output.flush();
            output.close();
            InputStream responseStream = connection.getInputStream(); //This is when the request is actually fired
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream,CHAR_SET)); // Connect a BufferReader to the inputStream
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
            output.close();
        }
        catch (Exception e)
        {
///         Toast.makeText(null,e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return response;

    }

    public static String savecontact(String pno1,String pno2,String pno3,String pno4,String pno5,String email)
    {
        final String SERVER_URL = "http://192.168.43.86:80/ws/savecontact.php"; // The server(Servlet) which will process the request. Note 10.0.2.2 is the localhost IP for emulator
        final String CHAR_SET = "UTF-8"; // Encoding used for the parameters
        OutputStream output = null;
        String response = "";
        try
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = URLEncoder.encode("pno1", CHAR_SET) + "=" + URLEncoder.encode(pno1, CHAR_SET);
            data += "&" +URLEncoder.encode("pno2", CHAR_SET) + "=" + URLEncoder.encode(pno2, CHAR_SET);
            data += "&" +URLEncoder.encode("pno3", CHAR_SET) + "=" + URLEncoder.encode(pno3, CHAR_SET);
            data += "&" +URLEncoder.encode("pno4", CHAR_SET) + "=" + URLEncoder.encode(pno4, CHAR_SET);
            data += "&" +URLEncoder.encode("pno5", CHAR_SET) + "=" + URLEncoder.encode(pno5, CHAR_SET);
            data += "&" +URLEncoder.encode("email", CHAR_SET) + "=" + URLEncoder.encode(email, CHAR_SET);
            URL u=new URL(SERVER_URL);
            URLConnection connection = u.openConnection(); // Create a connection to server using URL
            connection.setDoOutput(true); // This means POST method to be used
            output = connection.getOutputStream(); //open a Output stream from the connection for posting data
            output.write(data.getBytes(CHAR_SET)); //Post data
            output.flush();
            output.close();
            InputStream responseStream = connection.getInputStream(); //This is when the request is actually fired
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream,CHAR_SET)); // Connect a BufferReader to the inputStream
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
            output.close();
        }
        catch (Exception e)
        {
///         Toast.makeText(null,e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return response;

    }
    public static String recpno(String email)
    {
        final String SERVER_URL = "http://192.168.43.86:80/ws/recpno.php"; // The server(Servlet) which will process the request. Note 10.0.2.2 is the localhost IP for emulator
        final String CHAR_SET = "UTF-8"; // Encoding used for the parameters
        OutputStream output = null;
        String response = "";
        try
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = URLEncoder.encode("email", CHAR_SET) + "=" + URLEncoder.encode(email, CHAR_SET);
            URL u=new URL(SERVER_URL);
            URLConnection connection = u.openConnection(); // Create a connection to server using URL
            connection.setDoOutput(true); // This means POST method to be used
            output = connection.getOutputStream(); //open a Output stream from the connection for posting data
            output.write(data.getBytes(CHAR_SET)); //Post data
            output.flush();
            output.close();
            InputStream responseStream = connection.getInputStream(); //This is when the request is actually fired
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream,CHAR_SET)); // Connect a BufferReader to the inputStream
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
            output.close();
        }
        catch (Exception e)
        {
///         Toast.makeText(null,e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return response;

    }
    public static String reclocation()
    {
        final String SERVER_URL = "http://192.168.43.86:80/ws/reclat.php"; // The server(Servlet) which will process the request. Note 10.0.2.2 is the localhost IP for emulator
        final String CHAR_SET = "UTF-8"; // Encoding used for the parameters
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = "";
            URL u = new URL(SERVER_URL);
            URLConnection connection = u.openConnection(); // Create a connection to server using URL
            connection.setDoOutput(true); // This means POST method to be used
            output = connection.getOutputStream(); //open a Output stream from the connection for posting data
            output.write(data.getBytes(CHAR_SET)); //Post data
            output.flush();
            output.close();
            InputStream responseStream = connection.getInputStream(); //This is when the request is actually fired
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET)); // Connect a BufferReader to the inputStream
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
            output.close();
        }
        catch (Exception ex)
        {
//            Toast.makeText(null,ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return response;
    }
    public static String reclon()
    {
        final String SERVER_URL = "http://192.168.43.86:80/ws/reclon.php"; // The server(Servlet) which will process the request. Note 10.0.2.2 is the localhost IP for emulator
        final String CHAR_SET = "UTF-8"; // Encoding used for the parameters
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = "";
            URL u = new URL(SERVER_URL);
            URLConnection connection = u.openConnection(); // Create a connection to server using URL
            connection.setDoOutput(true); // This means POST method to be used
            output = connection.getOutputStream(); //open a Output stream from the connection for posting data
            output.write(data.getBytes(CHAR_SET)); //Post data
            output.flush();
            output.close();
            InputStream responseStream = connection.getInputStream(); //This is when the request is actually fired
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET)); // Connect a BufferReader to the inputStream
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
            output.close();
        }
        catch (Exception ex)
        {
//            Toast.makeText(null,ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return response;
    }

    public static String savepolicestation(String pname,String lat,String lon,String policepno)
    {
        final String SERVER_URL = "http://192.168.43.86:80/ws/addpolicestation.php"; // The server(Servlet) which will process the request. Note 10.0.2.2 is the localhost IP for emulator
        final String CHAR_SET = "UTF-8"; // Encoding used for the parameters
        OutputStream output = null;
        String response = "";
        try
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = URLEncoder.encode("pname", CHAR_SET) + "=" + URLEncoder.encode(pname, CHAR_SET);
            data += "&" +URLEncoder.encode("latitude", CHAR_SET) + "=" + URLEncoder.encode(lat, CHAR_SET);
            data += "&" +URLEncoder.encode("longtitude", CHAR_SET) + "=" + URLEncoder.encode(lon, CHAR_SET);
            data += "&" +URLEncoder.encode("policepno", CHAR_SET) + "=" + URLEncoder.encode(policepno, CHAR_SET);
            URL u=new URL(SERVER_URL);
            URLConnection connection = u.openConnection(); // Create a connection to server using URL
            connection.setDoOutput(true); // This means POST method to be used
            output = connection.getOutputStream(); //open a Output stream from the connection for posting data
            output.write(data.getBytes(CHAR_SET)); //Post data
            output.flush();
            output.close();
            InputStream responseStream = connection.getInputStream(); //This is when the request is actually fired
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream,CHAR_SET)); // Connect a BufferReader to the inputStream
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
            output.close();
        }
        catch (Exception e)
        {
///         Toast.makeText(null,e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return response;

    }

    public static String recpolat(){
        final String SERVER_URL = "http://192.168.43.86:80/ws/recpolat.php"; // The server(Servlet) which will process the request. Note 10.0.2.2 is the localhost IP for emulator
        final String CHAR_SET = "UTF-8"; // Encoding used for the parameters
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = "";
            URL u = new URL(SERVER_URL);
            URLConnection connection = u.openConnection(); // Create a connection to server using URL
            connection.setDoOutput(true); // This means POST method to be used
            output = connection.getOutputStream(); //open a Output stream from the connection for posting data
            output.write(data.getBytes(CHAR_SET)); //Post data
            output.flush();
            output.close();
            InputStream responseStream = connection.getInputStream(); //This is when the request is actually fired
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET)); // Connect a BufferReader to the inputStream
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
            output.close();
        }
        catch (Exception ex)
        {
//            Toast.makeText(null,ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return response;
    }

    public static String recpolon(){
        final String SERVER_URL = "http://192.168.43.86:80/ws/recpolon.php"; // The server(Servlet) which will process the request. Note 10.0.2.2 is the localhost IP for emulator
        final String CHAR_SET = "UTF-8"; // Encoding used for the parameters
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = "";
            URL u = new URL(SERVER_URL);
            URLConnection connection = u.openConnection(); // Create a connection to server using URL
            connection.setDoOutput(true); // This means POST method to be used
            output = connection.getOutputStream(); //open a Output stream from the connection for posting data
            output.write(data.getBytes(CHAR_SET)); //Post data
            output.flush();
            output.close();
            InputStream responseStream = connection.getInputStream(); //This is when the request is actually fired
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET)); // Connect a BufferReader to the inputStream
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
            output.close();
        }
        catch (Exception ex)
        {
//            Toast.makeText(null,ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return response;
    }

    public static String recpolicepno(){
        final String SERVER_URL = "http://192.168.43.86:80/ws/recpolicepno.php"; // The server(Servlet) which will process the request. Note 10.0.2.2 is the localhost IP for emulator
        final String CHAR_SET = "UTF-8"; // Encoding used for the parameters
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = "";
            URL u = new URL(SERVER_URL);
            URLConnection connection = u.openConnection(); // Create a connection to server using URL
            connection.setDoOutput(true); // This means POST method to be used
            output = connection.getOutputStream(); //open a Output stream from the connection for posting data
            output.write(data.getBytes(CHAR_SET)); //Post data
            output.flush();
            output.close();
            InputStream responseStream = connection.getInputStream(); //This is when the request is actually fired
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET)); // Connect a BufferReader to the inputStream
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
            output.close();
        }
        catch (Exception ex)
        {
//            Toast.makeText(null,ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return response;
    }

    public static String adddangerlocation(String latitude,String longtitude,String name){
        final String SERVER_URL = "http://192.168.43.86:80/ws/adddangerlocation.php"; // The server(Servlet) which will process the request. Note 10.0.2.2 is the localhost IP for emulator
        final String CHAR_SET = "UTF-8"; // Encoding used for the parameters
        OutputStream output = null;
        String response = "";

        try
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = URLEncoder.encode("latitude", CHAR_SET) + "=" + URLEncoder.encode(latitude, CHAR_SET);
            data += "&" +URLEncoder.encode("longtitude", CHAR_SET) + "=" + URLEncoder.encode(longtitude, CHAR_SET);
            data += "&" + URLEncoder.encode("name", CHAR_SET) + "=" + URLEncoder.encode(name, CHAR_SET);
            URLConnection connection = new URL(SERVER_URL).openConnection(); // Create a connection to server using URL
            connection.setDoOutput(true); // This means POST method to be used
            connection.setRequestProperty("Accept-Charset", CHAR_SET); //For servers to know what encoding is used for the parameters
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + CHAR_SET);
            output = null;
            output = connection.getOutputStream(); //open a Output stream from the connection for posting data
            output.write(data.getBytes(CHAR_SET)); //Post data
            output.flush();
            output.close();
            InputStream responseStream = connection.getInputStream(); //This is when the request is actually fired
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream,CHAR_SET)); // Connect a BufferReader to the inputStream
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
        }
        catch (UnsupportedEncodingException e)
        {
            response=response+e.getMessage();
            e.printStackTrace();

        }
        catch(IOException io)
        {response=response+io.getMessage();
        }
        finally
        {
            if (output != null) try { output.close(); } catch (IOException ignoreIO) {}
        }


        return response;

    }
}





