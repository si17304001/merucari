package tera;
public interface ApplicationController{
  RequestContext getRequest(Object request);
  ResponseContext handleRequest(RequestContext req);
  void handleResponse(RequestContext req, ResponseContext res);
}
