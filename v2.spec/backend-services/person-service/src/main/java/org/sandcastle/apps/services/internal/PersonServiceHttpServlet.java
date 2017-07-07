package org.sandcastle.apps.services.internal;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.sandcastle.apps.models.Person;
import org.sandcastle.apps.services.dto.PersonResponseDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class PersonServiceHttpServlet extends HttpServlet {

    private static final long serialVersionUID = -3112981464412978587L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        resp.setContentType("application/json");

        ObjectMapper mapper = new ObjectMapper();

        PersonResponseDTO response = new PersonResponseDTO();
        response.setTime(System.currentTimeMillis());
        response.setIp(getIpAddress());
        Person person = new Person();
        response.setData(person);

        PrintWriter out = resp.getWriter();
        mapper.writerWithDefaultPrettyPrinter().writeValue(out, resp);
    }

    private String getIpAddress() {
        String hostName;
        try {
            hostName = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            hostName = "unknown";
        }
        return hostName;
    }
}
