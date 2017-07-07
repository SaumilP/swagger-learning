package org.sandcastle.apps.services.internal;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.sandcastle.apps.models.Memory;
import org.sandcastle.apps.services.dto.MemoryResponseDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class MemoryServiceHttpServlet extends HttpServlet {

    private static final long serialVersionUID = -7131719499043898544L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        resp.setContentType("application/json");

        ObjectMapper mapper = new ObjectMapper();

        MemoryResponseDTO response = new MemoryResponseDTO();
        response.setTime(System.currentTimeMillis());
        response.setIp(getIpAddress());
        Memory memory = new Memory();
        response.setData(memory);

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
