<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <aside id="sidebar_left" class="nano nano-light affix">
        <div class="sidebar-left-content nano-content">
            <ul class="nav sidebar-menu">
                
                <li class="sidebar-label pt15">My E-mall</li>
                <li>
                    <a href="#">
                        <span class="glyphicon glyphicon-home"></span>
                        <span class="sidebar-title">Commodity management</span>
                        <span class="caret"></span>
                    </a>
                    <ul class="nav sub-nav">
                        <li>
                            <a href="${pageContext.request.contextPath}/ProductServlet?method=findAll">
                                <span class="glyphicon glyphicon-calendar"></span> Commodity list </a>
                        </li>
                        <li>
                            <a href="goods_add.html">
                                <span class="glyphicon glyphicon-check"></span> Add commodity </a>
                        </li>
						<li>
                            <a href="goods_update.html">
                                <span class="glyphicon glyphicon-check"></span> Edit commodity </a>
                        </li>
                    </ul>
                </li>
				<li>
                    <a href="#">
                        <span class="glyphicon glyphicon-home"></span>
                        <span class="sidebar-title">Category management</span>
                        <span class="caret"></span>
                    </a>
                    <ul class="nav sub-nav">
                        <li>
                            <a href="${pageContext.request.contextPath }/CategoryServlet?method=findAll">
                                <span class="glyphicon glyphicon-calendar"></span> Category list </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath }/CategoryServlet?method=saveUI">
                                <span class="glyphicon glyphicon-check"></span> Add category </a>
                        </li>
						<li>
                            <a href="${pageContext.request.contextPath }/CategoryServlet?method=updateUI">
                                <span class="glyphicon glyphicon-check"></span> Edit category </a>
                        </li>
                    </ul>
                </li>
            </ul>
            <div class="sidebar-toggle-mini">
                <a href="#">
                    <span class="fa fa-sign-out"></span>
                </a>
            </div>
        </div>
    </aside>