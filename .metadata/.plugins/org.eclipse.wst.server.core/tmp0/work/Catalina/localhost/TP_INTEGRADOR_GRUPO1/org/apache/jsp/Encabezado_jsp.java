/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.50
 * Generated at: 2022-11-16 15:23:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Encabezado_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<head>\r\n");
      out.write("\t<!-- Latest compiled and minified CSS -->\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\">\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- jQuery library -->\r\n");
      out.write("\t<script src=\"https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- Popper JS -->\r\n");
      out.write("\t<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- Latest compiled JavaScript -->\r\n");
      out.write("\t<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js\"></script>\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://unpkg.com/bootstrap-table@1.21.1/dist/bootstrap-table.min.css\"/>\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/jquery/dist/jquery.min.js\"></script>\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <script src=\"https://unpkg.com/bootstrap-table@1.21.1/dist/bootstrap-table.min.js\"></script>\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.6.1.js\" integrity=\"sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css\">\r\n");
      out.write("    <script src=\"https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js\" ></script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<div class=\"w-100\">\r\n");
      out.write("\t<nav class=\"navbar navbar-expand-sm bg-dark navbar-dark\">\r\n");
      out.write("\t  <a class=\"navbar-brand\" href=\"#\">Banquito Fiel</a>\r\n");
      out.write("\t  <ul class=\"navbar-nav w-100\">\r\n");
      out.write("\t  \t");
 String usu = (String) session.getAttribute("TipoUsurio");
	  	   if(session.getAttribute("usuarioAdmin").equals(true)) {
		
      out.write("\r\n");
      out.write("\t\t   <li class=\"nav-item dropdown\">\r\n");
      out.write("\t\t      <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbardrop\" data-toggle=\"dropdown\">Clientes</a>\r\n");
      out.write("\t\t      <div class=\"dropdown-menu\">\r\n");
      out.write("\t\t        <a class=\"dropdown-item\" href=\"AltaClientes.jsp\">Alta cliente</a>\r\n");
      out.write("\t\t        <a class=\"dropdown-item\" href=\"BajaClientes.jsp\">Baja cliente</a>\r\n");
      out.write("\r\n");
      out.write("\t\t        <a class=\"dropdown-item\" href=\"ServletAdmin?ParamModifCLI=1\">Modificar cliente</a>\r\n");
      out.write("\t\t        <a class=\"dropdown-item\" href=\"ServletAdmin?ParamListarCLI=1\">Listado clientes</a>\r\n");
      out.write("\r\n");
      out.write("\t\t       \r\n");
      out.write("\t\t      </div>\r\n");
      out.write("\t\t    </li>\r\n");
      out.write("\t\t    <li class=\"nav-item dropdown\">\r\n");
      out.write("\t\t      <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbardrop\" data-toggle=\"dropdown\">Cuentas</a>\r\n");
      out.write("\t\t      <div class=\"dropdown-menu\">\r\n");
      out.write("\t\t        <a class=\"dropdown-item\" href=\"AltaCuenta.jsp\">Alta cuenta</a>\r\n");
      out.write("\t\t        <a class=\"dropdown-item\" href=\"BajaCuenta.jsp\">Baja cuenta</a>\r\n");
      out.write("\t\t        <a class=\"dropdown-item\" href=\"ServletAdmin?modCuenta=1\">Modificacion cuenta</a>\r\n");
      out.write("\t\t        <a class=\"dropdown-item\" href=\"ServletAdmin?ParamLCU=1\">Listado cuentas</a>\r\n");
      out.write("\t\t      </div>\r\n");
      out.write("\t\t    </li>\r\n");
      out.write("\t\t    <li class=\"nav-item\">\r\n");
      out.write("\t\t      <a class=\"nav-link\" href=\"ServletAdmin?LPrestamos=1\">Prestamos</a>\r\n");
      out.write("\t\t    </li>\r\n");
      out.write("\t\t    <li class=\"nav-item\">\r\n");
      out.write("\t\t      <a class=\"nav-link\" href=\"Reportes.jsp\">Informes y/o Reportes</a>\r\n");
      out.write("\t\t    </li>\r\n");
      out.write("\t\t");
 }
		   else {
		
      out.write("\r\n");
      out.write("\t\t   <li class=\"nav-item dropdown\">\r\n");
      out.write("\t\t      <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbardrop\" data-toggle=\"dropdown\">Cuentas</a>\r\n");
      out.write("\t\t      <div class=\"dropdown-menu\">\r\n");
      out.write("\t\t        <a class=\"dropdown-item\" href=\"Cuenta1.jsp\">Cuenta 1</a>\r\n");
      out.write("\t\t        <a class=\"dropdown-item\" href=\"Cuenta2.jsp\">Cuenta 2</a>\r\n");
      out.write("\t\t        <a class=\"dropdown-item\" href=\"Cuenta3.jsp\">Cuenta 3</a>\r\n");
      out.write("\t\t      </div>\r\n");
      out.write("\t\t    </li>\r\n");
      out.write("\t\t    <li class=\"nav-item dropdown\">\r\n");
      out.write("\t\t      <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbardrop\" data-toggle=\"dropdown\">Prestamos</a>\r\n");
      out.write("\t\t      <div class=\"dropdown-menu\">\r\n");
      out.write("\t\t        <a class=\"dropdown-item\" href=\"SolicitarPrestamo.jsp\">Solicitar prestamo</a>\r\n");
      out.write("\t\t        <a class=\"dropdown-item\" href=\"AbonarPrestamo.jsp\">Abonar Prestamo</a>\r\n");
      out.write("\t\t        <a class=\"dropdown-item\" href=\"PrestamosPendientes.jsp\">Prestamos Pendientes</a>\r\n");
      out.write("\t\t        <a class=\"dropdown-item\" href=\"PrestamosRechazados.jsp\">Prestamos Rechazados</a>\r\n");
      out.write("\t\t      </div>\r\n");
      out.write("\t\t    </li>\r\n");
      out.write("\t\t    <li class=\"nav-item\">\r\n");
      out.write("\t\t    \t<a class=\"nav-link\" href=\"../cliente/MisDatos.jsp\">Datos personales</a>\r\n");
      out.write("\t\t    </li>\r\n");
      out.write("\t\t");
 }
		
      out.write("\r\n");
      out.write("\t\t\t<li class=\"mt-0 mr-0 mb-0 ml-auto d-flex align-items-center\" style=\"gap: 1rem;\">\r\n");
      out.write("\t\t\t\t<span style=\"color: white;\">Usuario ");
      out.print(session.getAttribute("nombreUsurio"));
      out.write("</span>\r\n");
      out.write("\t\t\t\t<a href=\"Login.jsp\" class=\"btn btn-danger\"> Cerrar sesion</a>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t  </ul>\r\n");
      out.write("\t</nav>\r\n");
      out.write("</div>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
