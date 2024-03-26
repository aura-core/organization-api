
package com.aura.organizationapi.app.config.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Set;

@Slf4j
public class LogControllerInterceptor implements HandlerInterceptor {

    public static final String REQUEST_LOG_MESSAGE = "{} - {} {}";
    public static final String RESPONSE_LOG_MESSAGE = "{} - {} {}";
    public static final Set<String> IGNORE_PATHS = Set.of("/error");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (ignoreProcessing(request)) {
            return true;
        }
        logRequestInfo(request);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {
        if (ignoreProcessing(request)) {
            return;
        }
        logResponseInfo(request, response);
    }

    private boolean ignoreProcessing(HttpServletRequest request) {
        String uri = request.getRequestURI();
        return IGNORE_PATHS.contains(uri);
    }

    private static void logRequestInfo(HttpServletRequest request) {
        String user = getUserLdap(request);
        String method = request.getMethod();
        String uri = getCompleteEndpoint(request);
        log.info(REQUEST_LOG_MESSAGE, user, method, uri);
    }

    private static void logResponseInfo(HttpServletRequest request, HttpServletResponse response) {
        String user = getUserLdap(request);
        HttpStatus status = HttpStatus.resolve(response.getStatus());
        Assert.notNull(status, "problems getting response status");
        log.info(RESPONSE_LOG_MESSAGE, user, status.value(), status.getReasonPhrase());
    }

    private static String getUserLdap(HttpServletRequest request) {
        return "desconhecido";
    }

    private static String getCompleteEndpoint(HttpServletRequest request) {
        String uri = request.getRequestURI();
        if (request.getQueryString() != null) {
            uri += "?" + request.getQueryString();
        }
        return uri;
    }

}
